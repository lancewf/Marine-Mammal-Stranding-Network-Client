package com.mmsn.reportgen.client.view.report;

import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.data.report.ReportLiveAnimals;
import com.google.gwt.user.client.ui.Label;

public class ReportLiveAnimalsControl extends VerticalPanel implements AnimalStatusListener 
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private boolean readOnly;
   private CheckBox isConSickField;
   private CheckBox isConInjuredField;
   private CheckBox isConOutOfHabitatField;
   private CheckBox isConDeemedReleasableField;
   private CheckBox isConAbandonedField;
   private CheckBox isConInaccessibleField;
   private CheckBox isConLocationHazardToAnimalField;
   private CheckBox isConLocationHazardToHumansField;
   private CheckBox isConUnknownField;
   private CheckBox isConOtherField;
   
   private CheckBox isActionLeftAtSiteField;
   private CheckBox isActionImmediateReleaseAtSiteField;
   private CheckBox isActionRelocatedField;
   private CheckBox isActionDiedAtSiteField;
   private CheckBox isActionDiedDuringTransportField;
	
   private CheckBox isActionEuthanizedAtSiteField;
   private CheckBox isActionEuthanizedDuringTransportField;
   private CheckBox isActionTransferredToRehabField;
   private CheckBox isActionOtherField;
   private TextField<String> locationField;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportLiveAnimalsControl()
   {
      initialize();
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
	public void statusChange(String state){
		if(state.equalsIgnoreCase("NOT_FOUND") || state.equalsIgnoreCase("DEAD")){
			setVisible(false);
		} else{
			setVisible(true);
		}
	}
   
   public boolean isVaild()
   {
      return true;
   }
   
   public String getLocation()
   {
      return locationField.getRawValue();
   }
   
   public void setLocation(String location)
   {
      locationField.setValue(location);
   }
   
   public boolean isActionLeftAtSite()
   {
      return isActionLeftAtSiteField.getValue();
   }
   
   public void setActionLeftAtSite(boolean isActionLeftAtSite)
   {
	   isActionLeftAtSiteField.setValue(isActionLeftAtSite);
   }
   
   public boolean isActionImmediateReleaseAtSite()
   {
      return isActionImmediateReleaseAtSiteField.getValue();
   }
   
   public void setActionImmediateReleaseAtSite(boolean isActionImmediateReleaseAtSite)
   {
	   isActionImmediateReleaseAtSiteField.setValue(isActionImmediateReleaseAtSite);
   }
   
   public boolean isActionRelocated()
   {
      return isActionRelocatedField.getValue();
   }
   
   public void setActionRelocated(boolean isActionRelocated)
   {
	   isActionRelocatedField.setValue(isActionRelocated);
   }
   
   public boolean isActionDiedAtSite()
   {
      return isActionDiedAtSiteField.getValue();
   }
   
   public void setActionDiedAtSite(boolean isActionDiedAtSite)
   {
	   isActionDiedAtSiteField.setValue(isActionDiedAtSite);
   }
   
   public boolean isActionDiedDuringTransport()
   {
      return isActionDiedDuringTransportField.getValue();
   }
   
   public void setActionDiedDuringTransport(boolean isActionDiedDuringTransport)
   {
	   isActionDiedDuringTransportField.setValue(isActionDiedDuringTransport);
   }
   
   public boolean isActionEuthanizedAtSite()
   {
      return isActionEuthanizedAtSiteField.getValue();
   }
   
   public void setActionEuthanizedAtSite(boolean isActionEuthanizedAtSite)
   {
	   isActionEuthanizedAtSiteField.setValue(isActionEuthanizedAtSite);
   }
   
   public boolean isActionEuthanizedDuringTransport()
   {
      return isActionEuthanizedDuringTransportField.getValue();
   }
   
   public void setActionEuthanizedDuringTransport(boolean isActionEuthanizedDuringTransport)
   {
	   isActionEuthanizedDuringTransportField.setValue(isActionEuthanizedDuringTransport);
   }
   
   public boolean isActionTransferredToRehab()
   {
      return isActionTransferredToRehabField.getValue();
   }
   
   public void setActionTransferredToRehab(boolean isActionTransferredToRehab)
   {
	   isActionTransferredToRehabField.setValue(isActionTransferredToRehab);
   }
   
   public boolean isActionOther()
   {
      return isActionOtherField.getValue();
   }
   
   public void setActionOther(boolean isActionOther)
   {
	   isActionOtherField.setValue(isActionOther);
   }   
   
   public boolean isConSick()
   {
      return isConSickField.getValue();
   }
   
   public void setConSick(boolean isConSick)
   {
	   isConSickField.setValue(isConSick);
   }
   
   public boolean isConInjured(){
	   return isConInjuredField.getValue();
   }
   
   public void setConInjured(boolean isConInjured){
	   isConInjuredField.setValue(isConInjured);
   }
   
   public boolean isConOutOfHabitat(){
	   return isConOutOfHabitatField.getValue();
   }
   
   public void setConOutOfHabitat(boolean isConOutOfHabitat){
	   isConOutOfHabitatField.setValue(isConOutOfHabitat);
   }
   
   public boolean isConDeemedReleasable(){
	   return isConDeemedReleasableField.getValue();
   }
   
   public void setConDeemedReleasable(boolean isConDeemedReleasable){
	   isConDeemedReleasableField.setValue(isConDeemedReleasable);
   }
   
   public boolean isConAbandoned(){
	   return isConAbandonedField.getValue();
   }
   
   public void setConAbandoned(boolean isConAbandoned){
	   isConAbandonedField.setValue(isConAbandoned);
   }
   
   public boolean isConInaccessible(){
	   return isConInaccessibleField.getValue();
   }
   
   public void setConInaccessible(boolean isConInaccessible){
	   isConInaccessibleField.setValue(isConInaccessible);
   }
   
   public boolean isConOther()
   {
      return isConOtherField.getValue();
   }
   
   public void setConOther(boolean isConOther)
   {
	   isConOtherField.setValue(isConOther);
   }
   
   public boolean isConUnknown()
   {
      return isConUnknownField.getValue();
   }
   
   public void setConUnknown(boolean isConUnknown)
   {
	   isConUnknownField.setValue(isConUnknown);
   }
   
   public boolean isConLocationHazardToHumans()
   {
      return isConLocationHazardToHumansField.getValue();
   }
   
   public void setConLocationHazardToHumans(boolean isConLocationHazardToHumans)
   {
	   isConLocationHazardToHumansField.setValue(isConLocationHazardToHumans);
   }
   
   public boolean isConLocationHazardToAnimal()
   {
      return isConLocationHazardToAnimalField.getValue();
   }
   
   public void setConLocationHazardToAnimal(boolean isConLocationHazardToAnimal)
   {
	   isConLocationHazardToAnimalField.setValue(isConLocationHazardToAnimal);
   }
   
   public boolean isReadOnly()
   {
      return readOnly;
   }
   
   public void setReadOnly(boolean readOnly)
   {
      if(readOnly)
      {
         setToReadOnly();
      }
      else
      {
         setToWritable();
      }
   }
   
   public void setReportLiveAnimals(ReportLiveAnimals reportLiveAnimals)
   {
	   setConSick(reportLiveAnimals.isConSick());
	   setConInjured(reportLiveAnimals.isConInjured());
	   setConOutOfHabitat(reportLiveAnimals.isConOutOfHabitat());
	   setConDeemedReleasable(reportLiveAnimals.isConDeemedReleasable());
	   setConAbandoned(reportLiveAnimals.isConAbandoned());
	   setConInaccessible(reportLiveAnimals.isConInaccessible());
	   setConLocationHazardToAnimal(reportLiveAnimals.isConLocationHazardToAnimal());
	   setConLocationHazardToHumans(reportLiveAnimals.isConLocationHazardToHumans());
	   setConUnknown(reportLiveAnimals.isConUnknown());
	   setConOther(reportLiveAnimals.isConOther());
	   
	   setActionLeftAtSite(reportLiveAnimals.isActionLeftAtSite());
	   setActionImmediateReleaseAtSite(reportLiveAnimals.isActionImmediateReleaseAtSite());
	   setActionRelocated(reportLiveAnimals.isActionRelocated());
	   setActionDiedAtSite(reportLiveAnimals.isActionDiedAtSite());
	   setActionDiedDuringTransport(reportLiveAnimals.isActionDiedDuringTransport());
	   setActionEuthanizedAtSite(reportLiveAnimals.isActionEuthanizedAtSite());
	   setActionEuthanizedDuringTransport(reportLiveAnimals.isActionEuthanizedDuringTransport());
	   setActionTransferredToRehab(reportLiveAnimals.isActionTransferredToRehab());
	   setActionOther(reportLiveAnimals.isActionOther());
	   
	   setLocation(reportLiveAnimals.getRelocatedLocation());
   }
   
   public void fillReportLiveAnimals(ReportLiveAnimals reportLiveAnimals)
   {
	   reportLiveAnimals.setConSick(isConSick());
	   reportLiveAnimals.setConInjured(isConInjured());
	   reportLiveAnimals.setConOutOfHabitat(isConOutOfHabitat());
	   reportLiveAnimals.setConDeemedReleasable(isConDeemedReleasable());
	   reportLiveAnimals.setConAbandoned(isConAbandoned());
	   reportLiveAnimals.setConInaccessible(isConInaccessible());
	   reportLiveAnimals.setConLocationHazardToAnimal(isConLocationHazardToAnimal());
	   reportLiveAnimals.setConLocationHazardToHumans(isConLocationHazardToHumans());
	   reportLiveAnimals.setConUnknown(isConUnknown());
	   reportLiveAnimals.setConOther(isConOther());
	   
	   reportLiveAnimals.setActionLeftAtSite(isActionLeftAtSite());
	   reportLiveAnimals.setActionImmediateReleaseAtSite(isActionImmediateReleaseAtSite());
	   reportLiveAnimals.setActionRelocated(isActionRelocated());
	   reportLiveAnimals.setActionDiedAtSite(isActionDiedAtSite());
	   reportLiveAnimals.setActionDiedDuringTransport(isActionDiedDuringTransport());
	   reportLiveAnimals.setActionEuthanizedAtSite(isActionEuthanizedAtSite());
	   reportLiveAnimals.setActionEuthanizedDuringTransport(isActionEuthanizedDuringTransport());
	   reportLiveAnimals.setActionTransferredToRehab(isActionTransferredToRehab());
	   reportLiveAnimals.setActionOther(isActionOther());
	   
	   reportLiveAnimals.setRelocatedLocation(getLocation());
   }
   
   public ReportLiveAnimals getReportLiveAnimals()
   {
      ReportLiveAnimals reportLiveAnimals = new ReportLiveAnimals();
      
      fillReportLiveAnimals(reportLiveAnimals);
      
      return reportLiveAnimals;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void setToWritable()
   {
      readOnly = false;
      isConSickField.setReadOnly(false);
      isConInjuredField.setReadOnly(false);
      isConOutOfHabitatField.setReadOnly(false);
      isConDeemedReleasableField.setReadOnly(false);
      isConAbandonedField.setReadOnly(false);
      isConInaccessibleField.setReadOnly(false);
      isConLocationHazardToAnimalField.setReadOnly(false);
      isConLocationHazardToHumansField.setReadOnly(false);
      isConUnknownField.setReadOnly(false);
      isConOtherField.setReadOnly(false);
      
      isActionLeftAtSiteField.setReadOnly(false);
      isActionImmediateReleaseAtSiteField.setReadOnly(false);
      isActionRelocatedField.setReadOnly(false);
      isActionDiedAtSiteField.setReadOnly(false);
      isActionDiedDuringTransportField.setReadOnly(false);
      isActionEuthanizedAtSiteField.setReadOnly(false);
      isActionEuthanizedDuringTransportField.setReadOnly(false);
      isActionTransferredToRehabField.setReadOnly(false);
      isActionOtherField.setReadOnly(false);
      
      locationField.setReadOnly(false);
   }
   
   private void setToReadOnly()
   {
      readOnly = true;
      isConSickField.setReadOnly(true);
      isConInjuredField.setReadOnly(true);
      isConOutOfHabitatField.setReadOnly(true);
      isConDeemedReleasableField.setReadOnly(true);
      isConAbandonedField.setReadOnly(true);
      isConInaccessibleField.setReadOnly(true);
      isConLocationHazardToAnimalField.setReadOnly(true);
      isConLocationHazardToHumansField.setReadOnly(true);
      isConUnknownField.setReadOnly(true);
      isConOtherField.setReadOnly(true);
      
      isActionLeftAtSiteField.setReadOnly(true);
      isActionImmediateReleaseAtSiteField.setReadOnly(true);
      isActionRelocatedField.setReadOnly(true);
      isActionDiedAtSiteField.setReadOnly(true);
      isActionDiedDuringTransportField.setReadOnly(true);
      
      isActionEuthanizedAtSiteField.setReadOnly(true);
      isActionEuthanizedDuringTransportField.setReadOnly(true);
      isActionTransferredToRehabField.setReadOnly(true);
      isActionOtherField.setReadOnly(true);
      
      locationField.setReadOnly(true);
   }

   private void initialize()
   {
	  Label title = new Label("Live Animals");
	  
	  title.addStyleName("sectionTile");
      add(title);
      add(new Label("Make sure to work with coordinator to assess condition determination and actions to be taken with live animals!"));
      
      add(new HTML("<h3>Condition Determination:</h3><br />"));
      
      add(createConditionFirstRow());
      add(createConditionSecondRow());
      
      add(new HTML("<h3>Action Taken:</h3><br />"));
      
      add(createActionFirstRow());
      add(createActionSecondRow());
      
      locationField = new TextField<String>();
      locationField.setFieldLabel("Location");
      locationField.setValue("");
      locationField.setWidth(250);
      
	  FlexTable flexTable = new FlexTable();
	  flexTable.setCellSpacing(10);
	  flexTable.addStyleName("reportControlTable");
		
      flexTable.setText(1, 0, "Location (if relocated):");
      flexTable.setWidget(1, 1, locationField);
      
      flexTable.getFlexCellFormatter().setColSpan(1, 1, 6);
      
      add(flexTable);
   }
   
	private FlexTable createActionFirstRow() {
		FlexTable flexTable = new FlexTable();
		flexTable.setCellSpacing(10);
		flexTable.addStyleName("reportControlTable");
		int rowIndex = 1;
		int columnIndex = 0;
		
		HorizontalPanel panel1 = new HorizontalPanel();
		panel1.addStyleName("reportLiveAnimalsControlTable");
		isActionLeftAtSiteField = new CheckBox();
		panel1.add(new Label("Left at Site: "));
		panel1.add(isActionLeftAtSiteField);
		flexTable.setWidget(rowIndex, columnIndex, panel1);
		columnIndex += 1;
		
		HorizontalPanel panel2 = new HorizontalPanel();
		panel2.addStyleName("reportLiveAnimalsControlTable");
		isActionImmediateReleaseAtSiteField = new CheckBox();
		panel2.add(new Label("Immediate Release at Site: "));
		panel2.add(isActionImmediateReleaseAtSiteField);
		flexTable.setWidget(rowIndex, columnIndex, panel2);
		columnIndex += 1;
		
		
		HorizontalPanel panel3 = new HorizontalPanel();
		panel3.addStyleName("reportLiveAnimalsControlTable");
		isActionRelocatedField = new CheckBox();
		panel3.add(new Label("Relocated: "));
		panel3.add(isActionRelocatedField);
		flexTable.setWidget(rowIndex, columnIndex, panel3);
		columnIndex += 1;
		
		
		HorizontalPanel panel4 = new HorizontalPanel();
		panel4.addStyleName("reportLiveAnimalsControlTable");
		isActionDiedAtSiteField = new CheckBox();
		panel4.add(new Label("Died at Site: "));
		panel4.add(isActionDiedAtSiteField);
		flexTable.setWidget(rowIndex, columnIndex, panel4);
		columnIndex += 1;
		
		HorizontalPanel panel5 = new HorizontalPanel();
		panel5.addStyleName("reportLiveAnimalsControlTable");
		isActionDiedDuringTransportField = new CheckBox();
		panel5.add(new Label("Died During Transport: "));
		panel5.add(isActionDiedDuringTransportField);
		flexTable.setWidget(rowIndex, columnIndex, panel5);
		
		return flexTable;
	}
	
	private FlexTable createActionSecondRow() {
		FlexTable flexTable = new FlexTable();
		flexTable.setCellSpacing(10);
		flexTable.addStyleName("reportControlTable");
		int rowIndex = 1;
		int columnIndex = 0;
		
		HorizontalPanel panel1 = new HorizontalPanel();
		panel1.addStyleName("reportLiveAnimalsControlTable");
		isActionEuthanizedAtSiteField = new CheckBox();
		panel1.add(new Label("Euthanized at Site:"));
		panel1.add(isActionEuthanizedAtSiteField);
		flexTable.setWidget(rowIndex, columnIndex, panel1);
		columnIndex += 1;
		
		HorizontalPanel panel2 = new HorizontalPanel();
		panel2.addStyleName("reportLiveAnimalsControlTable");
		isActionEuthanizedDuringTransportField = new CheckBox();
		panel2.add(new Label("Euthanized During Transport:"));
		panel2.add(isActionEuthanizedDuringTransportField);
		flexTable.setWidget(rowIndex, columnIndex, panel2);
		columnIndex += 1;
		
		HorizontalPanel panel3 = new HorizontalPanel();
		panel3.addStyleName("reportLiveAnimalsControlTable");
		isActionTransferredToRehabField = new CheckBox();
		panel3.add(new Label("Transferred to Rehab:"));
		panel3.add(isActionTransferredToRehabField);
		flexTable.setWidget(rowIndex, columnIndex, panel3);
		columnIndex += 1;
		
		HorizontalPanel panel4 = new HorizontalPanel();
		panel4.addStyleName("reportLiveAnimalsControlTable");
		isActionOtherField = new CheckBox();
		panel4.add(new Label("Other:"));
		panel4.add(isActionOtherField);
		flexTable.setWidget(rowIndex, columnIndex, panel4);
		
		return flexTable;
	}
   
	private FlexTable createConditionSecondRow() {
		FlexTable flexTable = new FlexTable();
		flexTable.setCellSpacing(10);
		flexTable.addStyleName("reportControlTable");
		int rowIndex = 1;
		int columnIndex = 0;
		
		HorizontalPanel panel1 = new HorizontalPanel();
		panel1.addStyleName("reportLiveAnimalsControlTable");
		isConLocationHazardToAnimalField = new CheckBox();
		panel1.add(new Label("Location is hazardous to animal:"));
		panel1.add(isConLocationHazardToAnimalField);
		flexTable.setWidget(rowIndex, columnIndex, panel1);
		columnIndex += 1;

		
		HorizontalPanel panel2 = new HorizontalPanel();
		panel2.addStyleName("reportLiveAnimalsControlTable");
		isConLocationHazardToHumansField = new CheckBox();
		panel2.add(new Label("Location is hazardous to humans:"));
		panel2.add(isConLocationHazardToHumansField);
		flexTable.setWidget(rowIndex, columnIndex, panel2);
		columnIndex += 1;

		
		HorizontalPanel panel3 = new HorizontalPanel();
		panel3.addStyleName("reportLiveAnimalsControlTable");
		isConUnknownField = new CheckBox();
		panel3.add(new Label("Unknown:"));
		panel3.add(isConUnknownField);
		flexTable.setWidget(rowIndex, columnIndex, panel3);
		columnIndex += 1;
		
		HorizontalPanel panel4 = new HorizontalPanel();
		panel4.addStyleName("reportLiveAnimalsControlTable");
		isConOtherField = new CheckBox();
		panel4.add(new Label("Other:"));
		panel4.add(isConOtherField);
		flexTable.setWidget(rowIndex, columnIndex, panel4);

		flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);

		return flexTable;
	}
   
	private FlexTable createConditionFirstRow() {
		FlexTable flexTable = new FlexTable();
		flexTable.setCellSpacing(10);
		flexTable.addStyleName("reportControlTable");

		int rowIndex = 1;
		int columnIndex = 0;
		
		HorizontalPanel panel1 = new HorizontalPanel();
		panel1.addStyleName("reportLiveAnimalsControlTable");
		isConSickField = new CheckBox();
		panel1.add(new Label("Sick:"));
		panel1.add(isConSickField);
		flexTable.setWidget(rowIndex, columnIndex, panel1);
		columnIndex += 1;
		
		HorizontalPanel panel2 = new HorizontalPanel();
		panel2.addStyleName("reportLiveAnimalsControlTable");
		isConInjuredField = new CheckBox();
		panel2.add(new Label("Injured:"));
		panel2.add(isConInjuredField);
		flexTable.setWidget(rowIndex, columnIndex, panel2);
		columnIndex += 1;

		HorizontalPanel panel3 = new HorizontalPanel();
		panel3.addStyleName("reportLiveAnimalsControlTable");
		isConOutOfHabitatField = new CheckBox();
		panel3.add(new Label("Out of Habitat:"));
		panel3.add(isConOutOfHabitatField);
		flexTable.setWidget(rowIndex, columnIndex, panel3);
		columnIndex += 1;

		HorizontalPanel panel4 = new HorizontalPanel();
		panel4.addStyleName("reportLiveAnimalsControlTable");
		isConDeemedReleasableField = new CheckBox();
		panel4.add(new Label("Deemed Releasable:"));
		panel4.add(isConDeemedReleasableField);
		flexTable.setWidget(rowIndex, columnIndex, panel4);
		columnIndex += 1;

		HorizontalPanel panel5 = new HorizontalPanel();
		panel5.addStyleName("reportLiveAnimalsControlTable");
		isConAbandonedField = new CheckBox();
		panel5.add(new Label("Abandoned:"));
		panel5.add(isConAbandonedField);
		flexTable.setWidget(rowIndex, columnIndex, panel5);
		columnIndex += 1;

		HorizontalPanel panel6 = new HorizontalPanel();
		panel6.addStyleName("reportLiveAnimalsControlTable");
		isConInaccessibleField = new CheckBox();
		panel6.add(new Label("Inaccessible:"));
		panel6.add(isConInaccessibleField);
		flexTable.setWidget(rowIndex, columnIndex, panel6);

		flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);

		return flexTable;
	}
}
