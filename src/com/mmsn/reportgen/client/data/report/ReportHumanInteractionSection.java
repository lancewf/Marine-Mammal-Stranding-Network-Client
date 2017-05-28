package com.mmsn.reportgen.client.data.report;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class ReportHumanInteractionSection {
	// --------------------------------------------------------------------------
	// Private Data
	// --------------------------------------------------------------------------

	private boolean isExamined;
	private String name;
	private String possibleHiLesion;
	private String possibleSource;
	private String scavengerDamage;

	// --------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------

	public ReportHumanInteractionSection(String name) {
		this.name = name;
	}

	// --------------------------------------------------------------------------
	// Public Members
	// --------------------------------------------------------------------------

	
	public JSONValue getJson() {

		JSONObject section = new JSONObject();

		section.put("name", new JSONString(getName()));
		section.put("is_examined", JSONBoolean.getInstance(isExamined()));
		section.put("possible_hi_lesion", new JSONString(getPossibleHiLesion()));
		section.put("possible_source", new JSONString(getPossibleSource()));
		section.put("scavenger_damage", new JSONString(getPossibleHiLesion()));
		
		return section;
	}

	public boolean isExamined() {
		return isExamined;
	}

	public void setExamined(boolean isExamined) {
		this.isExamined = isExamined;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPossibleHiLesion() {
		return possibleHiLesion;
	}

	public void setPossibleHiLesion(String possibleHiLesion) {
		this.possibleHiLesion = possibleHiLesion;
	}

	public String getPossibleSource() {
		return possibleSource;
	}

	public void setPossibleSource(String possibleSource) {
		this.possibleSource = possibleSource;
	}

	public String getScavengerDamage() {
		return scavengerDamage;
	}

	public void setScavengerDamage(String scavengerDamage) {
		this.scavengerDamage = scavengerDamage;
	}
}
