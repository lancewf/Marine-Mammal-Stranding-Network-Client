package com.mmsn.reportgen.client.view.report;

import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.data.report.ReportLiveAnimals;
import com.google.gwt.user.client.ui.Label;

public class ReportLiveAnimalsControl extends VerticalPanel
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
	   
	   setLocation(reportLiveAnimals.getLocation());
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
	   
	   reportLiveAnimals.setLocation(getLocation());
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
      add(new HTML("<h3>Live Animals</h3><br />"));
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
		
		isActionLeftAtSiteField = new CheckBox();
		flexTable.setText(rowIndex, 0, "Left at Site:");
		flexTable.setWidget(rowIndex, 1, isActionLeftAtSiteField);
		
		isActionImmediateReleaseAtSiteField = new CheckBox();
		flexTable.setText(rowIndex, 2, "Immediate Release at Site:");
		flexTable.setWidget(rowIndex, 3, isActionImmediateReleaseAtSiteField);
		
		isActionRelocatedField = new CheckBox();
		flexTable.setText(rowIndex, 4, "Relocated:");
		flexTable.setWidget(rowIndex, 5, isActionRelocatedField);
		
		isActionDiedAtSiteField = new CheckBox();
		flexTable.setText(rowIndex, 6, "Died at Site:");
		flexTable.setWidget(rowIndex, 7, isActionDiedAtSiteField);
		
		isActionDiedDuringTransportField = new CheckBox();
		flexTable.setText(rowIndex, 8, "Died During Transport:");
		flexTable.setWidget(rowIndex, 9, isActionDiedDuringTransportField);
		
		return flexTable;
	}
	
	private FlexTable createActionSecondRow() {
		FlexTable flexTable = new FlexTable();
		flexTable.setCellSpacing(10);
		flexTable.addStyleName("reportControlTable");
		int rowIndex = 1;
		
		isActionEuthanizedAtSiteField = new CheckBox();
		flexTable.setText(rowIndex, 0, "Euthanized at Site:");
		flexTable.setWidget(rowIndex, 1, isActionEuthanizedAtSiteField);
		
		isActionEuthanizedDuringTransportField = new CheckBox();
		flexTable.setText(rowIndex, 2, "Euthanized During Transport:");
		flexTable.setWidget(rowIndex, 3, isActionEuthanizedDuringTransportField);
		
		isActionTransferredToRehabField = new CheckBox();
		flexTable.setText(rowIndex, 4, "Transferred to Rehab:");
		flexTable.setWidget(rowIndex, 5, isActionTransferredToRehabField);
		
		isActionOtherField = new CheckBox();
		flexTable.setText(rowIndex, 6, "Other:");
		flexTable.setWidget(rowIndex, 7, isActionOtherField);
		
		return flexTable;
	}
   
	private FlexTable createConditionSecondRow() {
		FlexTable flexTable2 = new FlexTable();
		flexTable2.setCellSpacing(10);
		flexTable2.addStyleName("reportControlTable");
		int rowIndex = 1;

		isConLocationHazardToAnimalField = new CheckBox();

		flexTable2.setText(rowIndex, 0, "Location is hazardous to animal:");
		flexTable2.setWidget(rowIndex, 1, isConLocationHazardToAnimalField);

		isConLocationHazardToHumansField = new CheckBox();

		flexTable2.setText(rowIndex, 2, "Location is hazardous to humans:");
		flexTable2.setWidget(rowIndex, 3, isConLocationHazardToHumansField);

		isConUnknownField = new CheckBox();

		flexTable2.setText(rowIndex, 4, "Unknown:");
		flexTable2.setWidget(rowIndex, 5, isConUnknownField);

		isConOtherField = new CheckBox();

		flexTable2.setText(rowIndex, 6, "Other:");
		flexTable2.setWidget(rowIndex, 7, isConOtherField);

		flexTable2.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);

		return flexTable2;
	}
   
	private FlexTable createConditionFirstRow() {
		FlexTable flexTable = new FlexTable();
		flexTable.setCellSpacing(10);
		flexTable.addStyleName("reportControlTable");

		int rowIndex = 1;

		isConSickField = new CheckBox();

		flexTable.setText(rowIndex, 0, "Sick:");
		flexTable.setWidget(rowIndex, 1, isConSickField);

		isConInjuredField = new CheckBox();

		flexTable.setText(rowIndex, 2, "Injured:");
		flexTable.setWidget(rowIndex, 3, isConInjuredField);

		isConOutOfHabitatField = new CheckBox();

		flexTable.setText(rowIndex, 4, "Out of Habitat:");
		flexTable.setWidget(rowIndex, 5, isConOutOfHabitatField);

		isConDeemedReleasableField = new CheckBox();

		flexTable.setText(rowIndex, 6, "Deemed Releasable:");
		flexTable.setWidget(rowIndex, 7, isConDeemedReleasableField);

		isConAbandonedField = new CheckBox();

		flexTable.setText(rowIndex, 8, "Abandoned:");
		flexTable.setWidget(rowIndex, 9, isConAbandonedField);

		isConInaccessibleField = new CheckBox();

		flexTable.setText(rowIndex, 10, "Inaccessible:");
		flexTable.setWidget(rowIndex, 11, isConInaccessibleField);

		flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);

		return flexTable;
	}
}
