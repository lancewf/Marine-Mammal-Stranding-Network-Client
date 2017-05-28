package com.mmsn.reportgen.client.data.report;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONValue;

public class ReportHumanInteraction {
	
	public static final String ROSTRUM_SNOUT     = "Rostrum/snout";
	public static final String MANDIBLE          = "Mandible";
	public static final String HEAD              = "Head";
	public static final String L_FRONT_APPENDAGE = "L Front appendage";
	public static final String R_FRONT_APPENDAGE = "R Front appendage";
	public static final String BODY_R_L          = "Body R L";
	public static final String DORSUM_DORSAL_FIN = "Dorsum/dorsal fin";
	public static final String VENTRUM           = "Ventrum";
	public static final String PEDUNCLE          = "Peduncle";
	public static final String L_REAR_APPENDAGE  = "L Rear appendage";
	public static final String R_REAR_APPENDAGE  = "R Rear appendage";
	public static final String FLUKES_TAIL       = "Flukes/tail";
	
	// --------------------------------------------------------------------------
	// Private Data
	// --------------------------------------------------------------------------
	
	private List<ReportHumanInteractionSection> sections = new ArrayList<ReportHumanInteractionSection>();

	// --------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------

	public ReportHumanInteraction() {

	}

	// --------------------------------------------------------------------------
	// Public Members
	// --------------------------------------------------------------------------
	
	public List<ReportHumanInteractionSection> getSections() {
		
		return new ArrayList<ReportHumanInteractionSection>(sections);
	}
	
	public ReportHumanInteractionSection getSection(String sectionName) {
		ReportHumanInteractionSection foundSection = null;
		for(ReportHumanInteractionSection section : sections){
			if(section.getName().equals(sectionName)){
				foundSection = section;
				break;
			}
		}
		
		return foundSection;
	}
	
	public void setSections(List<ReportHumanInteractionSection> sections){
		this.sections = sections;
	}

	public void addSection(ReportHumanInteractionSection section) {
		sections.add(section);
	}
	
	public JSONValue getJson() {
		JSONArray sectionsArray = new JSONArray();

		int index = 0;
		for(ReportHumanInteractionSection section : sections){
			sectionsArray.set(index, section.getJson());
			
			index++;
		}

		return sectionsArray;
	}
}
