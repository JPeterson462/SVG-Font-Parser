package org.w3c.dom.fonts;

public enum SVGFontFormat {

	TRUETYPE("ttf"),
	
	OPENTYPE("otf"),
	
	WEBOPEN("woff"),
	
	SVG("svg"),
	
	EMBEDDED_OPENTYPE("eot");
	
	private String extension;
	
	SVGFontFormat(String extension) {
		this.extension = extension.toLowerCase();
	}
	
	public String getExtension() {
		return extension;
	}
	
	public static SVGFontFormat determineType(String extension) {
		for (SVGFontFormat fontType : values()) {
			if (fontType.getExtension().equals(extension.toLowerCase())) {
				return fontType;
			}
		}
		return null;
	}
	
}
