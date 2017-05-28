package com.mmsn.reportgen.client.view.report;

import java.util.HashMap;

import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.data.report.ReportHumanInteraction;
import com.mmsn.reportgen.client.data.report.ReportHumanInteractionSection;
import com.mmsn.reportgen.client.data.report.ReportInvestigation;

public class ReportHumanInteractionPrintView extends VerticalPanel {
	// --------------------------------------------------------------------------
	// Private Data
	// --------------------------------------------------------------------------
	private String[] sectionOrder = new String[] { ReportHumanInteraction.ROSTRUM_SNOUT,
			ReportHumanInteraction.MANDIBLE, ReportHumanInteraction.HEAD, ReportHumanInteraction.L_FRONT_APPENDAGE,
			ReportHumanInteraction.R_FRONT_APPENDAGE, ReportHumanInteraction.BODY_R_L,
			ReportHumanInteraction.DORSUM_DORSAL_FIN, ReportHumanInteraction.VENTRUM, ReportHumanInteraction.PEDUNCLE,
			ReportHumanInteraction.L_REAR_APPENDAGE, ReportHumanInteraction.R_REAR_APPENDAGE,
			ReportHumanInteraction.FLUKES_TAIL, };
	
	private HashMap<String, Label> isExaminedControls = new HashMap<String, Label>();
	private HashMap<String, Label> possibleHiLesionControls = new HashMap<String, Label>();
	private HashMap<String, Label> possibleSouceControls = new HashMap<String, Label>();
	private HashMap<String, Label> scavengerDamageControls = new HashMap<String, Label>();

	// --------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------

	public ReportHumanInteractionPrintView() {
		initialize();
	}

	// --------------------------------------------------------------------------
	// Public Members
	// --------------------------------------------------------------------------

	public void setReportHumanInteraction(ReportHumanInteraction reportHumanInteraction) {
		
		for(ReportHumanInteractionSection section : reportHumanInteraction.getSections()){
			String name = section.getName();
			Label isExaminedControl = isExaminedControls.get(name);
			if(section.isExamined()){
				isExaminedControl.setText("[X]");
			} else{
				isExaminedControl.setText("[ ]");
			}
			
			Label possibleHiLesionControl = possibleHiLesionControls.get(name);
			possibleHiLesionControl.setText(section.getPossibleHiLesion());
			
			Label possibleSourceControl = possibleSouceControls.get(name);
			possibleSourceControl.setText(section.getPossibleSource());
			
			Label scavengerDamageControl = scavengerDamageControls.get(name);
			scavengerDamageControl.setText(section.getScavengerDamage());
		}
		
	}

	// --------------------------------------------------------------------------
	// Private Members
	// --------------------------------------------------------------------------

	private void initialize() {
		addStyleName("printPage");

		add(new HTML("<h4>Human Interaction</h4>"));

		FlexTable flexTable = new FlexTable();
		int index = 0;

		flexTable.setText(index, 2, "Examined?");
		flexTable.setText(index, 3, "Possible HI lesion?");
		flexTable.setText(index, 4, "Possible source?");
		flexTable.setText(index, 5, "Scavenger damage?");

		for (String sectionName : sectionOrder) {
			index++;
			flexTable.setWidget(index, 1, createIsExaminedControl(sectionName));
			flexTable.setText(index, 2, sectionName);
			flexTable.setWidget(index, 3, createPossibleHiLesionControl(sectionName));
			flexTable.setWidget(index, 4, createPossibleSouceControl(sectionName));
			flexTable.setWidget(index, 5, createScavengerDamageControl(sectionName));
		}

		add(flexTable);
	}

	private Label createIsExaminedControl(String sectionName) {
		Label labelField = new Label("");

		labelField.addStyleName("printField");
		
		isExaminedControls.put(sectionName, labelField);

		return labelField;
	}
	
	private Label createPossibleHiLesionControl(String sectionName) {
		Label labelField = new Label("");

		labelField.addStyleName("printField");
		
		possibleHiLesionControls.put(sectionName, labelField);

		return labelField;
	}
	
	private Label createPossibleSouceControl(String sectionName) {
		Label labelField = new Label("");

		labelField.addStyleName("printField");
		
		possibleSouceControls.put(sectionName, labelField);

		return labelField;
	}
	
	private Label createScavengerDamageControl(String sectionName) {
		Label labelField = new Label("");

		labelField.addStyleName("printField");
		
		scavengerDamageControls.put(sectionName, labelField);

		return labelField;
	}
}
