package de.mosaic4cap.webapp.stereotypes.enumeration;

import java.awt.Color;

import de.mosaic4cap.webapp.stereotypes.domain.HTMLColor;

/**
 * Created by Lobedan on 22.09.2014.
 * <p>
 * Globale alert type used by cuple of classes or enums
 * it holds informations for bootstrap design in order to display the right color
 */
public enum AlertType {
	DEFAULT(null, "btn-default", "label-default", "", "", "", "", "", "", "", ""),
	PRIMARY(new HTMLColor(new Color(66, 139, 202), "428bca"),
					"btn-primary",
					"label-primary",
					"",
					"",
					"",
					"panel-primary",
					"",
					"",
					"text-primary",
					"bg-primary"),
	ACTIVE(null, "active", "", "", "", "active", "", "active", "", "text-muted", ""),
	INFO(new HTMLColor(new Color(91, 192, 222), "5bc0de"), "btn-info",
			 "label-info",
			 "alert-info",
			 "progress-bar-info",
			 "list-group-item-info",
			 "panel-info",
			 "info",
			 "",
			 "text-muted",
			 "bg-info"),
	DANGER(new HTMLColor(new Color(217, 83, 79), "d9534f"), "btn-danger",
				 "label-danger",
				 "alert-danger",
				 "progress-bar-danger",
				 "list-group-item-danger",
				 "panel-danger",
				 "danger",
				 "has-error",
				 "text-danger",
				 "bg-danger"),
	WARNING(new HTMLColor(new Color(240, 173, 78), "f0ad4e"), "btn-warning",
					"label-warning",
					"alert-warning",
					"progress-bar-warning",
					"list-group-item-warning",
					"panel-warning",
					"warning",
					"has-warning",
					"text-warning",
					"bg-warning"),
	SUCCESS(new HTMLColor(new Color(92, 184, 92), "5cb85c"), "btn-success",
					"label-success",
					"alert-success",
					"progress-bar-success",
					"list-group-item-success",
					"panel-success",
					"success",
					"has-success",
					"text-success",
					"bg-success");

	private HTMLColor basecolor;
	private String button;
	private String label;
	private String alert;
	private String progressbar;
	private String listGroupItem;
	private String panel;
	private String table;
	private String input;
	private String text;
	private String bg;

	//CHECKSTYLE:OFF
	AlertType(HTMLColor aBasecolor,
						String aButton,
						String aLabel,
						String aAlert,
						String aProgressbar,
						String aListGroupItem, String aPanel, String aTable, String aInput, String aText, String aBg) {
		basecolor = aBasecolor;
		button = aButton;
		label = aLabel;
		alert = aAlert;
		progressbar = aProgressbar;
		listGroupItem = aListGroupItem;
		panel = aPanel;
		table = aTable;
		input = aInput;
		text = aText;
		bg = aBg;
	}
	//CHECKSTYLE:ON

	public HTMLColor getBasecolor() {
		return basecolor;
	}

	public void setBasecolor(HTMLColor aBasecolor) {
		basecolor = aBasecolor;
	}

	public String getButton() {
		return button;
	}

	public void setButton(String aButton) {
		button = aButton;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String aLabel) {
		label = aLabel;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String aAlert) {
		alert = aAlert;
	}

	public String getProgressbar() {
		return progressbar;
	}

	public void setProgressbar(String aProgressbar) {
		progressbar = aProgressbar;
	}

	public String getListGroupItem() {
		return listGroupItem;
	}

	public void setListGroupItem(String aListGroupItem) {
		listGroupItem = aListGroupItem;
	}

	public String getPanel() {
		return panel;
	}

	public void setPanel(String aPanel) {
		panel = aPanel;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String aTable) {
		table = aTable;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String aInput) {
		input = aInput;
	}

	public String getText() {
		return text;
	}

	public void setText(String aText) {
		text = aText;
	}

	public String getBg() {
		return bg;
	}

	public void setBg(String aBg) {
		bg = aBg;
	}
}
