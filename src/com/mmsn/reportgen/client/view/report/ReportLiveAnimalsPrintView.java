package com.mmsn.reportgen.client.view.report;

import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.data.report.ReportLiveAnimals;

public class ReportLiveAnimalsPrintView extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private Label isConSickField = new Label("[ ]");
   private Label isConInjuredField= new Label("[ ]");
   private Label isConOutOfHabitatField = new Label("[ ]");
   private Label isConDeemedReleasableField = new Label("[ ]");
   private Label isConAbandonedField = new Label("[ ]");
   private Label isConInaccessibleField = new Label("[ ]");
   
   private Label isConLocationHazardToAnimalField = new Label("[ ]");
   private Label isConLocationHazardToHumansField= new Label("[ ]");
   private Label isConUnknownField = new Label("[ ]");
   private Label isConOtherField = new Label("[ ]");
   
   private Label isActionLeftAtSiteField = new Label("[ ]");
   private Label isActionImmediateReleaseAtSiteField = new Label("[ ]");
   private Label isActionRelocatedField = new Label("[ ]");
   private Label isActionDiedAtSiteField = new Label("[ ]");
   private Label isActionDiedDuringTransportField = new Label("[ ]");
   
   private Label isActionEuthanizedAtSiteField = new Label("[ ]");
   private Label isActionEuthanizedDuringTransportField = new Label("[ ]");
   private Label isActionTransferredToRehabField = new Label("[ ]");
   private Label isActionOtherField = new Label("[ ]");
   
   private Label relocatedLocationField;
   private Label relocatedLocationTag;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportLiveAnimalsPrintView()
   {
      initialize();
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setReportLiveAnimals(ReportLiveAnimals reportLiveAnimals)
   {
	   setText(isConSickField, reportLiveAnimals.isConSick());
	   setText(isConInjuredField, reportLiveAnimals.isConInjured());
	   setText(isConOutOfHabitatField, reportLiveAnimals.isConOutOfHabitat());
	   setText(isConDeemedReleasableField, reportLiveAnimals.isConDeemedReleasable());
	   setText(isConAbandonedField, reportLiveAnimals.isConAbandoned());
	   setText(isConInaccessibleField, reportLiveAnimals.isConInaccessible());
	   
	   setText(isConLocationHazardToAnimalField, reportLiveAnimals.isConLocationHazardToAnimal());
	   setText(isConLocationHazardToHumansField, reportLiveAnimals.isConLocationHazardToHumans());
	   setText(isConUnknownField, reportLiveAnimals.isConUnknown());
	   setText(isConOtherField, reportLiveAnimals.isConOther());
	   
	   setText(isActionLeftAtSiteField, reportLiveAnimals.isActionLeftAtSite());
	   setText(isActionImmediateReleaseAtSiteField, reportLiveAnimals.isActionImmediateReleaseAtSite());
	   setText(isActionRelocatedField, reportLiveAnimals.isActionRelocated());
	   setText(isActionDiedAtSiteField, reportLiveAnimals.isActionDiedAtSite());
	   setText(isActionDiedDuringTransportField, reportLiveAnimals.isActionDiedDuringTransport());
	   
	   setText(isActionEuthanizedAtSiteField, reportLiveAnimals.isActionEuthanizedAtSite());
	   setText(isActionEuthanizedDuringTransportField, reportLiveAnimals.isActionEuthanizedDuringTransport());
	   setText(isActionTransferredToRehabField, reportLiveAnimals.isActionTransferredToRehab());
	   setText(isActionOtherField, reportLiveAnimals.isActionOther());
	   
	   if(reportLiveAnimals.isActionRelocated()){
		   relocatedLocationField.setVisible(true);
		   relocatedLocationTag.setVisible(true);
	   } else{
		   relocatedLocationField.setVisible(false);
		   relocatedLocationTag.setVisible(false);
	   }
	   relocatedLocationField.setText(reportLiveAnimals.getRelocatedLocation());
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {
      addStyleName("printPage");
      
      add(new HTML("<h2>Live Animals</h2>"));
      
      add(new HTML("<h3>Condition Determination:</h3>"));
      
      add(createFirstRow());
      
      add(createSecondRow());
      
      add(new HTML("<h3>Action Taken:</h3>"));
      
      add(createActionFirstRow());
      
      add(createActionSecondRow());
      
      add(createRelocatedLocationControl());
      
      add(new HTML("<br></br>"));
   }
   
   private Widget createRelocatedLocationControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      relocatedLocationTag = new Label("Relocated Location:");
      
      relocatedLocationTag.addStyleName("printLabel");
      
      relocatedLocationField = new Label("");
      
      relocatedLocationField.addStyleName("printField");
      
      panel.add(relocatedLocationTag);
      panel.add(relocatedLocationField);
      
      return panel;
   }
   
   private FlexTable createActionSecondRow(){
	   FlexTable flexTable = new FlexTable();
      int row = 0;
      int column = 0;
      
      flexTable.setWidget(row,column, createField(isActionEuthanizedAtSiteField, "Euthanized at Site"));
      column++;
      flexTable.setWidget(row,column, createField(isActionEuthanizedDuringTransportField, "Euthanized During Transport"));
      column++;
      flexTable.setWidget(row,column, createField(isActionTransferredToRehabField, "Transferred to Rehab"));
      column++;
      flexTable.setWidget(row,column, createField(isActionOtherField, "Other"));
      
      return flexTable;
   }   
   
   private FlexTable createActionFirstRow(){
	   FlexTable flexTable = new FlexTable();
      int row = 0;
      int column = 0;
      
      flexTable.setWidget(row,column, createField(isActionLeftAtSiteField, "Left at Site"));
      column++;
      flexTable.setWidget(row,column, createField(isActionImmediateReleaseAtSiteField, "Immediate Release at Site"));
      column++;
      flexTable.setWidget(row,column, createField(isActionRelocatedField, "Relocated"));
      column++;
      flexTable.setWidget(row,column, createField(isActionDiedAtSiteField, "Died at Site"));
      column++;
      flexTable.setWidget(row,column, createField(isActionDiedDuringTransportField, "Died During Transport"));
      
      return flexTable;
   }   
   
   private FlexTable createSecondRow(){
	   FlexTable flexTable = new FlexTable();
      int row = 0;
      int column = 0;
      
      flexTable.setWidget(row,column, createField(isConLocationHazardToAnimalField, "Location is hazardous to animal"));
      column++;
      flexTable.setWidget(row,column, createField(isConLocationHazardToHumansField, "Location is hazardous to humans"));
      column++;
      flexTable.setWidget(row,column, createField(isConUnknownField, "Unknown"));
      column++;
      flexTable.setWidget(row,column, createField(isConOtherField, "Other"));
      
      return flexTable;
   }
   
   private FlexTable createFirstRow(){
	   FlexTable flexTable = new FlexTable();
      int row = 0;
      int column = 0;
      
      flexTable.setWidget(row,column, createField(isConSickField, "Sick"));
      column++;
      flexTable.setWidget(row,column, createField(isConInjuredField, "Injured"));
      column++;
      flexTable.setWidget(row,column, createField(isConOutOfHabitatField, "Out of Habitat"));
      column++;
      flexTable.setWidget(row,column, createField(isConDeemedReleasableField, "Deemed Releasable"));
      column++;
      flexTable.setWidget(row,column, createField(isConAbandonedField, "Abandoned"));
      column++;
      flexTable.setWidget(row,column, createField(isConInaccessibleField, "Inaccessible"));
      
      return flexTable;
   }
   
   private Widget createField(Label label, String tag){
	      HorizontalPanel panel = new HorizontalPanel();
	      
	      Label label1 = new Label(tag);
	      
	      label1.addStyleName("printLabel");
	      
	      label.addStyleName("printField");
	      
	      panel.add(label);
	      panel.add(label1);
	      
	      return panel;
   }

   private void setText(Label label, boolean isChecked){
	   if(isChecked){
		   label.setText("[X]");
	   } else{
		   label.setText("[ ]");
	   } 
   }
}
