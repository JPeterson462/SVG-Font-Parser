package org.w3c.dom.fonts;

import java.util.ArrayList;
import java.util.HashMap;

import com.digiturtle.util.FloatList;
import com.digiturtle.util.ShortList;

public class SVGFontAttributes {

	private ArrayList<String> fontFamily;
	
	private ShortList fontStyle, fontVariant, fontWeight, fontStretch;
	
	private ArrayList<String> fontSize;
	
	private boolean forAllFontSizes;
	
	private ArrayList<String> unicodeRange;
	
	private float unitsPerEm;
	
	private FloatList panose1;
	
	private float stemV, stemH, slope, capHeight, xHeight, accentHeight, ascent, descent, lineGap;
	
	private HashMap<Integer, Float> widths;
	
	private String widthsString;
	
	private float[] bBox;
	
	private float ideographic, alphabetic, mathematical, hanging, vIdeographic, vAlphabetic, 
					vMathematical, vHanging, underlinePosition, underlineThickness, strikethroughPosition,
					strikethroughThickness, overlinePosition, overlineThickness;
	
	private HashMap<String, String> fontSources;
	
	private boolean fontFamilySet, fontStyleSet, fontVariantSet, fontWeightSet,
					fontStretchSet, fontSizeSet, forAllFontSizesSet, unicodeRangeSet,
					unitsPerEmSet, panose1Set, stemVSet, stemHSet, slopeSet, capHeightSet,
					xHeightSet, accentHeightSet, ascentSet, descentSet, lineGapSet, widthsSet,
					widthsStringSet, bBoxSet, ideographicSet, alphabeticSet, mathematicalSet,
					hangingSet, vIdeographicSet, vAlphabeticSet, vMathematicalSet,
					vHangingSet, underlinePositionSet, underlineThicknessSet,
					strikethroughPositionSet, strikethroughThicknessSet, overlinePositionSet,
					overlineThicknessSet, fontSourcesSet;

	public SVGFontAttributes() {
		fontFamilySet = false;
		fontStyleSet = false;
		fontVariantSet = false;
		fontWeightSet = false;
		fontStretchSet = false;
		fontSizeSet = false;
		forAllFontSizesSet = false;
		unicodeRangeSet = false;
		unitsPerEmSet = false;
		panose1Set = false;
		stemVSet = false;
		stemHSet = false;
		slopeSet = false;
		capHeightSet = false;
		xHeightSet = false;
		accentHeightSet = false;
		ascentSet = false;
		descentSet = false;
		lineGapSet = false;
		widthsSet = false;
		widthsStringSet = false;
		bBoxSet = false;
		ideographicSet = false;
		alphabeticSet = false;
		mathematicalSet = false;
		hangingSet = false;
		vIdeographicSet = false;
		vAlphabeticSet = false;
		vMathematicalSet = false;
		vHangingSet = false;
		underlinePositionSet = false;
		underlineThicknessSet = false;
		strikethroughPositionSet = false;
		strikethroughThicknessSet = false;
		overlinePositionSet = false;
		overlineThicknessSet = false;
		fontSourcesSet = false;
	}
	
	public ArrayList<String> getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(ArrayList<String> fontFamily) {
		this.fontFamily = fontFamily;
		fontFamilySet = true;
	}

	public ShortList getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(ShortList fontStyle) {
		this.fontStyle = fontStyle;
		fontStyleSet = true;
	}

	public ShortList getFontVariant() {
		return fontVariant;
	}

	public void setFontVariant(ShortList fontVariant) {
		this.fontVariant = fontVariant;
		fontVariantSet = true;
	}

	public ShortList getFontWeight() {
		return fontWeight;
	}

	public void setFontWeight(ShortList fontWeight) {
		this.fontWeight = fontWeight;
		fontWeightSet = true;
	}

	public ShortList getFontStretch() {
		return fontStretch;
	}

	public void setFontStretch(ShortList fontStretch) {
		this.fontStretch = fontStretch;
		fontStretchSet = true;
	}

	public ArrayList<String> getFontSize() {
		return fontSize;
	}

	public void setFontSize(ArrayList<String> fontSize) {
		this.fontSize = fontSize;
		fontSizeSet = true;
	}

	public boolean isForAllFontSizes() {
		return forAllFontSizes;
	}

	public void setForAllFontSizes(boolean forAllFontSizes) {
		this.forAllFontSizes = forAllFontSizes;
		forAllFontSizesSet = true;
	}

	public ArrayList<String> getUnicodeRange() {
		return unicodeRange;
	}

	public void setUnicodeRange(ArrayList<String> unicodeRange) {
		this.unicodeRange = unicodeRange;
		unicodeRangeSet = true;
	}

	public float getUnitsPerEm() {
		return unitsPerEm;
	}

	public void setUnitsPerEm(float unitsPerEm) {
		this.unitsPerEm = unitsPerEm;
		unitsPerEmSet = true;
	}

	public FloatList getPanose1() {
		return panose1;
	}

	public void setPanose1(FloatList panose1) {
		this.panose1 = panose1;
		panose1Set = true;
	}

	public float getStemV() {
		return stemV;
	}

	public void setStemV(float stemV) {
		this.stemV = stemV;
		stemVSet = true;
	}

	public float getStemH() {
		return stemH;
	}

	public void setStemH(float stemH) {
		this.stemH = stemH;
		stemHSet = true;
	}

	public float getSlope() {
		return slope;
	}

	public void setSlope(float slope) {
		this.slope = slope;
		slopeSet = true;
	}

	public float getCapHeight() {
		return capHeight;
	}

	public void setCapHeight(float capHeight) {
		this.capHeight = capHeight;
		capHeightSet = true;
	}

	public float getxHeight() {
		return xHeight;
	}

	public void setXHeight(float xHeight) {
		this.xHeight = xHeight;
		xHeightSet = true;
	}

	public float getAccentHeight() {
		return accentHeight;
	}

	public void setAccentHeight(float accentHeight) {
		this.accentHeight = accentHeight;
		accentHeightSet = true;
	}

	public float getAscent() {
		return ascent;
	}

	public void setAscent(float ascent) {
		this.ascent = ascent;
		ascentSet = true;
	}

	public float getDescent() {
		return descent;
	}

	public void setDescent(float descent) {
		this.descent = descent;
		descentSet = true;
	}
	
	public float getLineGap() {
		return lineGap;
	}
	
	public void setLineGap(float lineGap) {
		this.lineGap = lineGap;
		lineGapSet = true;
	}

	public HashMap<Integer, Float> getWidths() {
		return widths;
	}

	public void setWidths(HashMap<Integer, Float> widths) {
		this.widths = widths;
		widthsSet = true;
	}

	public String getWidthsString() {
		return widthsString;
	}

	public void setWidthsString(String widthsString) {
		this.widthsString = widthsString;
		widthsStringSet = true;
	}

	public float[] getBBox() {
		return bBox;
	}

	public void setBBox(float[] bBox) {
		this.bBox = bBox;
		bBoxSet = true;
	}

	public float getIdeographic() {
		return ideographic;
	}

	public void setIdeographic(float ideographic) {
		this.ideographic = ideographic;
		ideographicSet = true;
	}

	public float getAlphabetic() {
		return alphabetic;
	}

	public void setAlphabetic(float alphabetic) {
		this.alphabetic = alphabetic;
		alphabeticSet = true;
	}

	public float getMathematical() {
		return mathematical;
	}

	public void setMathematical(float mathematical) {
		this.mathematical = mathematical;
		mathematicalSet = true;
	}

	public float getHanging() {
		return hanging;
	}

	public void setHanging(float hanging) {
		this.hanging = hanging;
		hangingSet = true;
	}

	public float getVIdeographic() {
		return vIdeographic;
	}

	public void setVIdeographic(float vIdeographic) {
		this.vIdeographic = vIdeographic;
		vIdeographicSet = true;
	}

	public float getVAlphabetic() {
		return vAlphabetic;
	}

	public void setVAlphabetic(float vAlphabetic) {
		this.vAlphabetic = vAlphabetic;
		vAlphabeticSet = true;
	}

	public float getVMathematical() {
		return vMathematical;
	}

	public void setVMathematical(float vMathematical) {
		this.vMathematical = vMathematical;
		vMathematicalSet = true;
	}

	public float getVHanging() {
		return vHanging;
	}

	public void setVHanging(float vHanging) {
		this.vHanging = vHanging;
		vHangingSet = true;
	}

	public float getUnderlinePosition() {
		return underlinePosition;
	}

	public void setUnderlinePosition(float underlinePosition) {
		this.underlinePosition = underlinePosition;
		underlinePositionSet = true;
	}

	public float getUnderlineThickness() {
		return underlineThickness;
	}

	public void setUnderlineThickness(float underlineThickness) {
		this.underlineThickness = underlineThickness;
		underlineThicknessSet = true;
	}

	public float getStrikethroughPosition() {
		return strikethroughPosition;
	}

	public void setStrikethroughPosition(float strikethroughPosition) {
		this.strikethroughPosition = strikethroughPosition;
		strikethroughPositionSet = true;
	}

	public float getStrikethroughThickness() {
		return strikethroughThickness;
	}

	public void setStrikethroughThickness(float strikethroughThickness) {
		this.strikethroughThickness = strikethroughThickness;
		strikethroughThicknessSet = true;
	}

	public float getOverlinePosition() {
		return overlinePosition;
	}

	public void setOverlinePosition(float overlinePosition) {
		this.overlinePosition = overlinePosition;
		overlinePositionSet = true;
	}

	public float getOverlineThickness() {
		return overlineThickness;
	}

	public void setOverlineThickness(float overlineThickness) {
		this.overlineThickness = overlineThickness;
		overlineThicknessSet = true;
	}

	public HashMap<String, String> getFontSources() {
		return fontSources;
	}

	public void setFontSources(HashMap<String, String> fontSources) {
		this.fontSources = fontSources;
		fontSourcesSet = true;
	}

	public float[] getbBox() {
		return bBox;
	}

	public float getvIdeographic() {
		return vIdeographic;
	}

	public float getvAlphabetic() {
		return vAlphabetic;
	}

	public float getvMathematical() {
		return vMathematical;
	}

	public float getvHanging() {
		return vHanging;
	}

	public boolean isFontFamilySet() {
		return fontFamilySet;
	}

	public boolean isFontStyleSet() {
		return fontStyleSet;
	}

	public boolean isFontVariantSet() {
		return fontVariantSet;
	}

	public boolean isFontWeightSet() {
		return fontWeightSet;
	}

	public boolean isFontStretchSet() {
		return fontStretchSet;
	}

	public boolean isFontSizeSet() {
		return fontSizeSet;
	}

	public boolean isForAllFontSizesSet() {
		return forAllFontSizesSet;
	}

	public boolean isUnicodeRangeSet() {
		return unicodeRangeSet;
	}

	public boolean isUnitsPerEmSet() {
		return unitsPerEmSet;
	}

	public boolean isPanose1Set() {
		return panose1Set;
	}

	public boolean isStemVSet() {
		return stemVSet;
	}

	public boolean isStemHSet() {
		return stemHSet;
	}

	public boolean isSlopeSet() {
		return slopeSet;
	}

	public boolean isCapHeightSet() {
		return capHeightSet;
	}

	public boolean isxHeightSet() {
		return xHeightSet;
	}

	public boolean isAccentHeightSet() {
		return accentHeightSet;
	}

	public boolean isAscentSet() {
		return ascentSet;
	}

	public boolean isDescentSet() {
		return descentSet;
	}
	
	public boolean isLineGapSet() {
		return lineGapSet;
	}

	public boolean isWidthsSet() {
		return widthsSet;
	}

	public boolean isWidthsStringSet() {
		return widthsStringSet;
	}

	public boolean isbBoxSet() {
		return bBoxSet;
	}

	public boolean isIdeographicSet() {
		return ideographicSet;
	}

	public boolean isAlphabeticSet() {
		return alphabeticSet;
	}

	public boolean isMathematicalSet() {
		return mathematicalSet;
	}

	public boolean isHangingSet() {
		return hangingSet;
	}

	public boolean isVIdeographicSet() {
		return vIdeographicSet;
	}

	public boolean isVAlphabeticSet() {
		return vAlphabeticSet;
	}

	public boolean isVMathematicalSet() {
		return vMathematicalSet;
	}

	public boolean isVHangingSet() {
		return vHangingSet;
	}

	public boolean isUnderlinePositionSet() {
		return underlinePositionSet;
	}

	public boolean isUnderlineThicknessSet() {
		return underlineThicknessSet;
	}

	public boolean isStrikethroughPositionSet() {
		return strikethroughPositionSet;
	}

	public boolean isStrikethroughThicknessSet() {
		return strikethroughThicknessSet;
	}

	public boolean isOverlinePositionSet() {
		return overlinePositionSet;
	}

	public boolean isOverlineThicknessSet() {
		return overlineThicknessSet;
	}

	public boolean isFontSourcesSet() {
		return fontSourcesSet;
	}
	
}
