package com.mmsn.reportgen.client.view.report;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.data.report.ReportHumanInteraction;
import com.mmsn.reportgen.client.data.report.ReportHumanInteractionSection;
import com.google.gwt.user.client.ui.Label;

public class ReportHumanInteractionControl extends VerticalPanel {
	// --------------------------------------------------------------------------
	// Private Data
	// --------------------------------------------------------------------------

	private boolean readOnly;

	private String[] sectionOrder = new String[] { 
			ReportHumanInteraction.ROSTRUM_SNOUT,
			ReportHumanInteraction.MANDIBLE,
			ReportHumanInteraction.HEAD,
			ReportHumanInteraction.L_FRONT_APPENDAGE,
			ReportHumanInteraction.R_FRONT_APPENDAGE,
			ReportHumanInteraction.BODY_R_L,
			ReportHumanInteraction.DORSUM_DORSAL_FIN,
			ReportHumanInteraction.VENTRUM,
			ReportHumanInteraction.PEDUNCLE,
			ReportHumanInteraction.L_REAR_APPENDAGE,
			ReportHumanInteraction.R_REAR_APPENDAGE,
			ReportHumanInteraction.FLUKES_TAIL,
			};

	private List<ReportHumanInteractionSectionControl> sectionControls = new ArrayList<ReportHumanInteractionSectionControl>();

	// --------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------

	public ReportHumanInteractionControl() {
		initialize();
	}

	// --------------------------------------------------------------------------
	// Public Members
	// --------------------------------------------------------------------------

	public boolean isVaild() {
		return true;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		if (readOnly) {
			setToReadOnly();
		} else {
			setToWritable();
		}
	}

	private ReportHumanInteractionSectionControl getSectionControl(ReportHumanInteractionSection section) {
		ReportHumanInteractionSectionControl foundSectionControl = null;
		for (ReportHumanInteractionSectionControl sectionControl : sectionControls) {
			if (sectionControl.getName().equals(section.getName())) {
				foundSectionControl = sectionControl;
				break;
			}
		}

		return foundSectionControl;
	}

	private List<ReportHumanInteractionSection> getSections() {
		List<ReportHumanInteractionSection> sections = new ArrayList<ReportHumanInteractionSection>();
		for (ReportHumanInteractionSectionControl sectionControl : sectionControls) {
			sections.add(sectionControl.getReportHumanInteractionSection());
		}

		return sections;
	}
	
	private void setSection(ReportHumanInteractionSection section){
		ReportHumanInteractionSectionControl matchingSectionControl = getSectionControl(section);
		
		if(matchingSectionControl != null){
			matchingSectionControl.setReportHumanInteractionSection(section);
		} else{
			System.out.println("Error missing section: " + section.getName());
		}
	}

	public void setReportHumanInteraction(ReportHumanInteraction reportHumanInteraction) {
		for (ReportHumanInteractionSection section : reportHumanInteraction.getSections()) {
			setSection(section);
		}
	}

	public void fillReportHumanInteraction(ReportHumanInteraction reportHumanInteraction) {
		reportHumanInteraction.setSections(getSections());
	}

	public ReportHumanInteraction getReportHumanInteraction() {
		ReportHumanInteraction reportHumanInteraction = new ReportHumanInteraction();

		fillReportHumanInteraction(reportHumanInteraction);

		return reportHumanInteraction;
	}

	// --------------------------------------------------------------------------
	// Private Members
	// --------------------------------------------------------------------------

	private void setToWritable() {
		readOnly = false;
		for(ReportHumanInteractionSectionControl sectionControl : sectionControls){
			sectionControl.setReadOnly(false);
		}
	}

	private void setToReadOnly() {
		readOnly = true;
		for(ReportHumanInteractionSectionControl sectionControl : sectionControls){
			sectionControl.setReadOnly(true);
		}
	}

	private void initialize() {
		add(new HTML("<h3>Human Interaction</h3><br />"));
		add(new Label(
				"Examine each of the following anatomical areas for lesions (e.g., impressions, lacerations, penetrating wounds, healed HI scars, \n "
						+ "abrasions, etc). Indicate scavenger damage if it hinders your ability to examine the area."));

		FlexTable flexTable = new FlexTable();
		flexTable.setCellSpacing(10);
		flexTable.addStyleName("reportControlTable");

		flexTable.setText(1, 1, "Examined?");
		flexTable.setText(1, 2, "Possible HI lesion?");
		flexTable.setText(1, 3, "Possible source?");
		flexTable.setText(1, 4, "Scavenger damage?");
		
		for(String sectionName : sectionOrder){
			ReportHumanInteractionSectionControl sectionControl = new ReportHumanInteractionSectionControl(sectionName, flexTable);
			sectionControls.add(sectionControl);
		}
		
		add(flexTable);
	}
}
