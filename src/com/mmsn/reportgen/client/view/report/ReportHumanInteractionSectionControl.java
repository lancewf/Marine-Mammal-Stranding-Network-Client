package com.mmsn.reportgen.client.view.report;

import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.data.report.ReportHumanInteraction;
import com.mmsn.reportgen.client.data.report.ReportHumanInteractionSection;
import com.mmsn.reportgen.client.data.report.ReportLiveAnimals;
import com.mmsn.reportgen.client.view.StringModel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ReportHumanInteractionSectionControl extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private boolean readOnly;
   private CheckBox isExaminedField;
   private ComboBox<StringModel> possibleHiLesionComboBox;
   private ComboBox<StringModel> possibleSourceComboBox;
   private ComboBox<StringModel> scavengerDamageComboBox;
   private String name;

   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportHumanInteractionSectionControl(String name, FlexTable flexTable)
   {
	   this.name = name;
      initialize(name, flexTable);
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public boolean isVaild()
   {
      return true;
   }

   public String getName(){
	   
	   return this.name;
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
   
   public void setReportHumanInteractionSection(ReportHumanInteractionSection reportHumanInteractionSection){
	   isExaminedField.setValue(reportHumanInteractionSection.isExamined());
	   possibleHiLesionComboBox.setValue(new StringModel(reportHumanInteractionSection.getPossibleHiLesion()));
	   possibleSourceComboBox.setValue(new StringModel(reportHumanInteractionSection.getPossibleSource()));
	   scavengerDamageComboBox.setValue(new StringModel(reportHumanInteractionSection.getScavengerDamage()));
	   this.name = reportHumanInteractionSection.getName();
   }
   
   public void fillReportHumanInteractionSection(ReportHumanInteractionSection reportHumanInteractionSection){
	   reportHumanInteractionSection.setExamined(isExaminedField.getValue());
	   reportHumanInteractionSection.setName(name);
	   reportHumanInteractionSection.setPossibleHiLesion(possibleHiLesionComboBox.getRawValue());
	   reportHumanInteractionSection.setPossibleSource(possibleSourceComboBox.getRawValue());
	   reportHumanInteractionSection.setScavengerDamage(scavengerDamageComboBox.getRawValue());
   }
   
   public ReportHumanInteractionSection getReportHumanInteractionSection()
   {
	   ReportHumanInteractionSection reportHumanInteractionSection = new ReportHumanInteractionSection();
      
	   fillReportHumanInteractionSection(reportHumanInteractionSection);
      
      return reportHumanInteractionSection;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void setToWritable()
   {
      readOnly = false;
      isExaminedField.setReadOnly(false);
      possibleHiLesionComboBox.setReadOnly(false);
      possibleSourceComboBox.setReadOnly(false);
      scavengerDamageComboBox.setReadOnly(false);
   }
   
   private void setToReadOnly()
   {
      readOnly = true;
      isExaminedField.setReadOnly(true);
      possibleHiLesionComboBox.setReadOnly(true);
      possibleSourceComboBox.setReadOnly(true);
      scavengerDamageComboBox.setReadOnly(true);
      
   }

	private void initialize(String name, FlexTable flexTable) {

		int rowIndex = flexTable.getRowCount();

		isExaminedField = new CheckBox();

		flexTable.setWidget(rowIndex, 0, isExaminedField);
		flexTable.setText(rowIndex, 1, name + ":");
		flexTable.setWidget(rowIndex, 2, createPossibleHiLesionComboBox());
		flexTable.setWidget(rowIndex, 3, createPossibleSourceComboBox());
		flexTable.setWidget(rowIndex, 4, createScavengerDamageComboBox());
	}
	
	private Widget createPossibleHiLesionComboBox(){
	      ListStore<StringModel> listStore = new ListStore<StringModel>();
	      
	      listStore.add(new StringModel("Yes"));
	      listStore.add(new StringModel("No"));
	      listStore.add(new StringModel("Unknown"));
	      
	      possibleHiLesionComboBox = new ComboBox<StringModel>();
	      possibleHiLesionComboBox.setFieldLabel("Possible HI Lesion");
	      possibleHiLesionComboBox.setDisplayField("name");
	      possibleHiLesionComboBox.setTriggerAction(TriggerAction.ALL);
	      possibleHiLesionComboBox.setStore(listStore);
	      possibleHiLesionComboBox.setForceSelection(true);
	      
	      return possibleHiLesionComboBox;
	}
	
	private Widget createPossibleSourceComboBox(){
	      ListStore<StringModel> listStore = new ListStore<StringModel>();
	      
	      listStore.add(new StringModel("Fishery"));
	      listStore.add(new StringModel("Boat"));
	      listStore.add(new StringModel("Gunshot"));
	      listStore.add(new StringModel("Other"));
	      listStore.add(new StringModel("Unknown"));
	      
	      possibleSourceComboBox = new ComboBox<StringModel>();
	      possibleSourceComboBox.setFieldLabel("Possible Source");
	      possibleSourceComboBox.setDisplayField("name");
	      possibleSourceComboBox.setTriggerAction(TriggerAction.ALL);
	      possibleSourceComboBox.setStore(listStore);
	      possibleSourceComboBox.setForceSelection(true);
	      
	      return possibleSourceComboBox;
	}
	
	private Widget createScavengerDamageComboBox(){
	      ListStore<StringModel> listStore = new ListStore<StringModel>();
	      
	      listStore.add(new StringModel("Yes"));
	      listStore.add(new StringModel("No"));
	      listStore.add(new StringModel("Unknown"));
	      
	      scavengerDamageComboBox = new ComboBox<StringModel>();
	      scavengerDamageComboBox.setFieldLabel("Scavenger Damage");
	      scavengerDamageComboBox.setDisplayField("name");
	      scavengerDamageComboBox.setTriggerAction(TriggerAction.ALL);
	      scavengerDamageComboBox.setStore(listStore);
	      scavengerDamageComboBox.setForceSelection(true);
	      
	      return scavengerDamageComboBox;
	}
}
