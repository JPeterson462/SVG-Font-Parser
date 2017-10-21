package org.w3c.dom.fonts;

import java.io.IOException;
import java.io.InputStream;

public interface SVGFontParser {
	
	@SuppressWarnings("rawtypes")
	public SVGFont parseFont(SVGFontFormat format, InputStream source, SVGFontAttributes attributes) throws IOException;

}
