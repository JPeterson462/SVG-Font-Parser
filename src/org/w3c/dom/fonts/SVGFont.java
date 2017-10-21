package org.w3c.dom.fonts;

import java.util.HashMap;

import com.digiturtle.util.Rect;

public interface SVGFont<T> {

	public T getBitmap();
	
	public SVGFontAttributes getAttributes();
	
	public HashMap<Character, Rect> getCharacterBounds();
	
}
