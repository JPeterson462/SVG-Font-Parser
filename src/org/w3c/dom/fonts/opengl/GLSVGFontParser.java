package org.w3c.dom.fonts.opengl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.w3c.dom.fonts.SVGFont;
import org.w3c.dom.fonts.SVGFontAttributes;
import org.w3c.dom.fonts.SVGFontFormat;
import org.w3c.dom.fonts.SVGFontParser;

public class GLSVGFontParser implements SVGFontParser {
	
	private HashMap<SVGFontFormat, SVGFontParser> parsers = new HashMap<>();
	
	public GLSVGFontParser() {
		parsers.put(SVGFontFormat.TRUETYPE, new STBTTFontParser());
	}

	@SuppressWarnings("unchecked")
	@Override
	public SVGFont<GLBitmap> parseFont(SVGFontFormat format, InputStream source, SVGFontAttributes attributes) throws IOException {
		SVGFontParser parser = parsers.get(format);
		if (parser != null) {
			return parser.parseFont(format, source, attributes);
		}
		throw new IllegalStateException("Unsupported Format!");
	}

	@Override
	public float getBaseFontSize() {
		return SVGFont.BASE_SIZE;
	}

}
