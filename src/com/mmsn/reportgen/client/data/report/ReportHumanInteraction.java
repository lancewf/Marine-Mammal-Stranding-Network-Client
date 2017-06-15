package com.mmsn.reportgen.client.data.report;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONValue;

public class ReportHumanInteraction {
	
	public static final String ROSTRUM_SNOUT     = "Nose";
	public static final String MANDIBLE          = "Jaw";
	public static final String HEAD              = "Head";
	public static final String L_FRONT_APPENDAGE = "L Front appendage";
	public static final String R_FRONT_APPENDAGE = "R Front appendage";
	public static final String BODY_R_L          = "Body R L";
	public static final String DORSUM_DORSAL_FIN = "Back";
	public static final String VENTRUM           = "Belly";
	public static final String PEDUNCLE          = "Peduncle/tail stock";
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
		addSection(new ReportHumanInteractionSection(ROSTRUM_SNOUT));
		addSection(new ReportHumanInteractionSection(MANDIBLE));
		addSection(new ReportHumanInteractionSection(HEAD));
		addSection(new ReportHumanInteractionSection(L_FRONT_APPENDAGE));
		addSection(new ReportHumanInteractionSection(R_FRONT_APPENDAGE));
		addSection(new ReportHumanInteractionSection(BODY_R_L));
		addSection(new ReportHumanInteractionSection(DORSUM_DORSAL_FIN));
		addSection(new ReportHumanInteractionSection(VENTRUM));
		addSection(new ReportHumanInteractionSection(PEDUNCLE));
		addSection(new ReportHumanInteractionSection(L_REAR_APPENDAGE));
		addSection(new ReportHumanInteractionSection(R_REAR_APPENDAGE));
		addSection(new ReportHumanInteractionSection(FLUKES_TAIL));
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
