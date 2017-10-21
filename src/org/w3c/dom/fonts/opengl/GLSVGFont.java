package org.w3c.dom.fonts.opengl;

import java.util.HashMap;

import org.w3c.dom.fonts.SVGFont;
import org.w3c.dom.fonts.SVGFontAttributes;

import com.digiturtle.util.Rect;

public class GLSVGFont implements SVGFont<GLBitmap> {
	
	private GLBitmap bitmap;
	
	private SVGFontAttributes attributes;
	
	private HashMap<Character, Rect> characterBounds;
	
	public GLSVGFont(GLBitmap bitmap, SVGFontAttributes attributes, HashMap<Character, Rect> characterBounds) {
		this.bitmap = bitmap;
		this.attributes = attributes;
		this.characterBounds = characterBounds;
	}

	@Override
	public GLBitmap getBitmap() {
		return bitmap;
	}

	@Override
	public SVGFontAttributes getAttributes() {
		return attributes;
	}

	@Override
	public HashMap<Character, Rect> getCharacterBounds() {
		return characterBounds;
	}

}
