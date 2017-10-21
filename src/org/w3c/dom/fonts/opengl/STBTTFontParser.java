package org.w3c.dom.fonts.opengl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;

import org.lwjgl.BufferUtils;
import org.lwjgl.stb.STBTTAlignedQuad;
import org.lwjgl.stb.STBTTBakedChar;
import org.lwjgl.stb.STBTTFontinfo;
import org.lwjgl.stb.STBTruetype;
import org.lwjgl.system.MemoryStack;
import org.w3c.dom.fonts.SVGFont;
import org.w3c.dom.fonts.SVGFontAttributes;
import org.w3c.dom.fonts.SVGFontFormat;
import org.w3c.dom.fonts.SVGFontParser;

import com.digiturtle.util.IOUtils;
import com.digiturtle.util.Rect;

public class STBTTFontParser implements SVGFontParser {

	private GLBitmap bitmap;
	
	@Override
	public SVGFont<GLBitmap> parseFont(SVGFontFormat format, InputStream source, SVGFontAttributes attributes) throws IOException {
		ByteBuffer ttf = IOUtils.read(source);
		STBTTFontinfo info = STBTTFontinfo.create();
		if (!STBTruetype.stbtt_InitFont(info, ttf)) {
			throw new IllegalStateException("Failed to initialize font information.");
		}
		int ascent, descent, lineGap;
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer pAscent = stack.mallocInt(1);
			IntBuffer pDescent = stack.mallocInt(1);
			IntBuffer pLineGap = stack.mallocInt(1);
			STBTruetype.stbtt_GetFontVMetrics(info, pAscent, pDescent, pLineGap);
			ascent = pAscent.get(0);
			descent = pDescent.get(0);
			lineGap = pLineGap.get(0);
		}
		final int bitmapSize = 512;
		final float fontSize = 16;
		STBTTBakedChar.Buffer cdata = init(ttf, info, bitmapSize, bitmapSize, fontSize);
		HashMap<Character, Rect> bounds = new HashMap<>();
		try (MemoryStack stack = MemoryStack.stackPush()) {
			FloatBuffer x = stack.floats(0f);
			FloatBuffer y = stack.floats(0f);
			STBTTAlignedQuad q = STBTTAlignedQuad.mallocStack(stack);
			for (char c = 32; c < 128; c++) {
				STBTruetype.stbtt_GetBakedQuad(cdata, bitmapSize, bitmapSize, c - 32, x, y, q, true);
				HashMap<Character, Float> advances = new HashMap<>();
				for (char d = 32; d < 128; d++) {
					float advance = STBTruetype.stbtt_GetCodepointKernAdvance(info, c, d);
					advances.put(d, advance);
				}
				bounds.put(c, new Rect(q.x0(), q.y0(), q.x1() - q.x0(), q.y1() - q.y0(), q.s0(), q.t0(), q.s1(), q.t1(), advances));
			}
		}
		if (!attributes.isAscentSet()) {
			attributes.setAscent(ascent);
		}
		if (!attributes.isDescentSet()) {
			attributes.setDescent(descent);
		}
		if (!attributes.isLineGapSet()) {
			attributes.setLineGap(lineGap);
		}
		return new GLSVGFont(bitmap, attributes, bounds);
	}
	
	private STBTTBakedChar.Buffer init(ByteBuffer ttf, STBTTFontinfo info, int bitmapWidth, int bitmapHeight, float fontHeight) {
		STBTTBakedChar.Buffer cdata = STBTTBakedChar.malloc(96);
		ByteBuffer bitmap = BufferUtils.createByteBuffer(bitmapWidth * bitmapHeight);
		STBTruetype.stbtt_BakeFontBitmap(ttf, fontHeight, bitmap, bitmapWidth, bitmapHeight, 32, cdata);
		float scale = STBTruetype.stbtt_ScaleForPixelHeight(info, fontHeight);
		this.bitmap = new GLBitmap(bitmapWidth, bitmapHeight, bitmap, scale);
		return cdata;
	}

}
