package de.mosaic4cap.webapp.stereotypes.domain;

import java.awt.Color;

/**
 * Created by Lobedan on 22.09.2014.
 * <p>
 * Object representing color in html template or css
 */
public class HTMLColor {

	private Color awtColor;
	private String hexColor;

	public HTMLColor() {
	}

	public HTMLColor(Color aAwtColor, String aHexColor) {

		awtColor = aAwtColor;
		hexColor = aHexColor;
	}

	public Color getAwtColor() {
		return awtColor;
	}

	public void setAwtColor(Color aAwtColor) {
		awtColor = aAwtColor;
	}

	public String getHexColor() {
		return hexColor;
	}

	public void setHexColor(String aHexColor) {
		hexColor = aHexColor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HTMLColor htmlColor = (HTMLColor) o;
		if (awtColor != null ? !awtColor.equals(htmlColor.awtColor) : htmlColor.awtColor != null) {
			return false;
		}
		if (hexColor != null ? !hexColor.equals(htmlColor.hexColor) : htmlColor.hexColor != null) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = awtColor != null ? awtColor.hashCode() : 0;
		result = 31 * result + (hexColor != null ? hexColor.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "HTMLColor{" +
					 "awtColor=" + awtColor +
					 ", hexColor='" + hexColor + '\'' +
					 '}';
	}
}
