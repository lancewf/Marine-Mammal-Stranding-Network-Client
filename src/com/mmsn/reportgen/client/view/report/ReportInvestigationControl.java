package com.mmsn.reportgen.client.view.report;

import java.util.ArrayList;
import java.util.Date;

import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.DatePicker;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.TimeField;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.data.report.ReportInvestigation;
import com.mmsn.reportgen.client.view.StringModel;

public class ReportInvestigationControl extends VerticalPanel
{
   
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private boolean readOnly;
   private TextField<String> investigatorSupportField;
   private TimeField timeField;
   private DatePicker datePicker;
   private TextField<String> latlocationField;
   private TextField<String> lonlocationField;
   private TextField<String> physicalLocationField;
   private SpeciesField speciesField;
   private CheckBox animalNotFoundField;
   private ComboBox<StringModel> conditionComboBox;
   private ComboBox<StringModel> locationAccuracyComboBox;
   private TextField<String> tagsField;
   private ComboBox<StringModel> dispositionComboBox;
   private ComboBox<StringModel> sealPickupComboBox;
   private ComboBox<StringModel> sexComboBox;
   private NumberField weightField;
   private NumberField straightLengthField;
   private NumberField girthField;
   private TextArea commentsField;
   private Label tagsLabel;
   private Label dispositionLabel;
   private Label sealPickupLabel;
   private Label sexLabel;
   private Label girthLabel;
   private Label straightLengthLabel;
   private Label weightLabel;
   
   private ArrayList<AnimalStatusListener> animalStatusListeners = new ArrayList<AnimalStatusListener>();
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportInvestigationControl()
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

   public void setReportInvestigation(ReportInvestigation reportInvestigation)
   {
      setInvestigatorSupport(reportInvestigation.getInvestigatorSupport());
      setDate(reportInvestigation.getDate());
      setLatLocation(reportInvestigation.getLatLocation());
      setLonLocation(reportInvestigation.getLonLocation());
      setPhysicalLocation(reportInvestigation.getPhysicalLocation());
      setSpecies(reportInvestigation.getSpecies());
      setAnimalNotFound(reportInvestigation.isAnimalNotFound());
      setLocationAccuracy(reportInvestigation.getLocationAccuracy());
      setCondition(reportInvestigation.getCondition());
      setTags(reportInvestigation.getTags());
      setDisposition(reportInvestigation.getDisposition());
      setSealPickup(reportInvestigation.getSealPickup());
      setSex(reportInvestigation.getSex());
      setWeight(reportInvestigation.getWeight());
      setStraightLength(reportInvestigation.getStraightLength());
      setGirth(reportInvestigation.getGirth());
      setComments(reportInvestigation.getComments());
   }

   public void fillReportInvestigation(ReportInvestigation reportInvestigation)
   {
      reportInvestigation.setInvestigatorSupport(getInvestigatorSupport());
      reportInvestigation.setDate(getDate());
      reportInvestigation.setLatLocation(getLatLocation());
      reportInvestigation.setLonLocation(getLonLocation());
      reportInvestigation.setPhysicalLocation(getPhysicalLocation());
      reportInvestigation.setSpecies(getSpecies());
      reportInvestigation.setAnimalNotFound(isAnimalNotFound());
      reportInvestigation.setCondition(getCondition());
      reportInvestigation.setLocationAccuracy(getLocationAccuracy());
      reportInvestigation.setTags(getTags());
      reportInvestigation.setDisposition(getDisposition());
      reportInvestigation.setSealPickup(getSealPickup());
      reportInvestigation.setSex(getSex());
      reportInvestigation.setWeight(getWeight());
      reportInvestigation.setStraightLength(getStraightLength());
      reportInvestigation.setGirth(getGirth());
      reportInvestigation.setComments(getComments());
   }
   
   public ReportInvestigation getReportInvestigation()
   {
      ReportInvestigation reportInvestigation = new ReportInvestigation();
      
      fillReportInvestigation(reportInvestigation);
      
      return reportInvestigation;
   }
   
   public String getInvestigatorSupport()
   {
      return investigatorSupportField.getRawValue();
   }

   public void setInvestigatorSupport(String investigatorSupport)
   {
      investigatorSupportField.setValue(investigatorSupport);
   }

   public Date getDate()
   {
      Date date = datePicker.getValue();
      Date time = timeField.getDateValue();
      
      if(time != null)
      {
         date.setHours(time.getHours());
         date.setMinutes(time.getMinutes());
      }
      
      return date;
   }

   public void setDate(Date date)
   {
      timeField.setDateValue(date);
      datePicker.setValue(date);
   }

   public String getPhysicalLocation()
   {
      return physicalLocationField.getRawValue();
   }

   public void setPhysicalLocation(String physicalLocation)
   {
      physicalLocationField.setValue(physicalLocation);
   }
   
   public String getLatLocation()
   {
      return latlocationField.getRawValue();
   }

   public void setLatLocation(String latLon)
   {
      latlocationField.setValue(latLon);
   }
   
   public String getLonLocation()
   {
      return lonlocationField.getRawValue();
   }

   public void setLonLocation(String latLon)
   {
      lonlocationField.setValue(latLon);
   }

   public String getSpecies()
   {
      return speciesField.getRawValue();
   }

   public void setSpecies(String species)
   {
      speciesField.setValue(species);
   }

   public String getCondition()
   {
      return conditionComboBox.getRawValue();
   }

   public void setCondition(String condition)
   {
      conditionComboBox.setValue(new StringModel(condition));
   }

   public String getLocationAccuracy()
   {
      return locationAccuracyComboBox.getRawValue();
   }

   public void setLocationAccuracy(String locationAccuracy)
   {
	   locationAccuracyComboBox.setValue(new StringModel(locationAccuracy));
   }

   public String getTags()
   {
      return tagsField.getRawValue();
   }

   public void setTags(String tags)
   {
      tagsField.setValue(tags);
   }

   public String getDisposition()
   {
      return dispositionComboBox.getRawValue();
   }

   public void setDisposition(String disposition)
   {
      dispositionComboBox.setValue(new StringModel(disposition));
   }

   public String getSealPickup()
   {
      return sealPickupComboBox.getRawValue();
   }

   public void setSealPickup(String sealPickup)
   {
      sealPickupComboBox.setValue(new StringModel(sealPickup));
   }

   public String getSex()
   {
      return sexComboBox.getRawValue();
   }

   public void setSex(String sex)
   {
      this.sexComboBox.setValue(new StringModel(sex));
   }

   public double getWeight()
   {
      Number value = weightField.getValue();
      
      if(value != null)
      {
         return value.doubleValue();
      }
      else
      {
         return 0.0;
      }
   }

   public void setWeight(double weight)
   {
      weightField.setValue(weight);
   }

   public double getStraightLength()
   {
      Number value = straightLengthField.getValue();
      
      if(value != null)
      {
         return value.doubleValue();
      }
      else
      {
         return 0.0;
      }
   }

   public void setStraightLength(double straightLength)
   {
      straightLengthField.setValue(straightLength);
   }

   public double getGirth()
   {
      Number value = girthField.getValue();
      
      if(value != null)
      {
         return value.doubleValue();
      }
      else
      {
         return 0.0;
      }
   }

   public void setGirth(double girth)
   {
      girthField.setValue(girth);
   }

   public boolean isAnimalNotFound()
   {
      return animalNotFoundField.getValue();
   }

   public void setAnimalNotFound(boolean animalNotFound)
   {
      animalNotFoundField.setValue(animalNotFound);
      
      isAnimalCheckBoxChanged(animalNotFound);
   }

   public String getComments()
   {
      return commentsField.getRawValue();
   }

   public void setComments(String comments)
   {
      commentsField.setValue(comments);
   }
   
   public void registerForAnimalStatus(AnimalStatusListener animalStatusListener){
	   animalStatusListeners.add(animalStatusListener);
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
  
   private void setToWritable()
   {
      readOnly = false;
      investigatorSupportField.setReadOnly(false);
      timeField.setReadOnly(false);
      datePicker.setEnabled(true);
      latlocationField.setReadOnly(false);
      lonlocationField.setReadOnly(false);
      physicalLocationField.setReadOnly(false);
      speciesField.setReadOnly(false);
      animalNotFoundField.setReadOnly(false);
      conditionComboBox.setReadOnly(false);
      locationAccuracyComboBox.setReadOnly(false);
      tagsField.setReadOnly(false);
      dispositionComboBox.setReadOnly(false);
      sealPickupComboBox.setReadOnly(false);
      sexComboBox.setReadOnly(false);
      weightField.setReadOnly(false);
      straightLengthField.setReadOnly(false);
      girthField.setReadOnly(false);
      commentsField.setReadOnly(false);
   }
   
   private void setToReadOnly()
   {
      readOnly = true;
      investigatorSupportField.setReadOnly(true);
      timeField.setReadOnly(true);
      datePicker.setEnabled(false);
      latlocationField.setReadOnly(true);
      lonlocationField.setReadOnly(true);
      physicalLocationField.setReadOnly(true);
      speciesField.setReadOnly(true);
      animalNotFoundField.setReadOnly(true);
      conditionComboBox.setReadOnly(true);
      locationAccuracyComboBox.setReadOnly(true);
      tagsField.setReadOnly(true);
      dispositionComboBox.setReadOnly(true);
      sealPickupComboBox.setReadOnly(true);
      sexComboBox.setReadOnly(true);
      weightField.setReadOnly(true);
      straightLengthField.setReadOnly(true);
      girthField.setReadOnly(true);
      commentsField.setReadOnly(true);
   }
   
   private void initialize()
   {
	   
	  Label title = new Label("Investigation");
		  
	  title.addStyleName("sectionTile");
      add(title);
      
      FlexTable flexTable = new FlexTable();
      flexTable.setCellSpacing(10);
      flexTable.addStyleName("reportControlTable");
      
      int rowIndex = 1;
      
      investigatorSupportField = new TextField<String>();
      investigatorSupportField.setWidth(250);
      
      flexTable.setText(rowIndex, 0 , "Responder(s):");
      flexTable.setWidget(rowIndex, 1, investigatorSupportField);
      
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);
      
      rowIndex++;
      
      datePicker = new DatePicker();
      datePicker.setValue(new Date());
      flexTable.setWidget(rowIndex, 0, datePicker);
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 0, 2);
      
      rowIndex++;
      
      timeField = new TimeField();
      timeField.setFieldLabel("Time");
      timeField.setIncrement(1);
      timeField.setForceSelection(true);
      
      flexTable.setText(rowIndex, 0, "Start Time:");
      flexTable.setWidget(rowIndex, 1, timeField);
      
      rowIndex++;
      
      physicalLocationField = new TextField<String>();
      physicalLocationField.setFieldLabel("Physical Location");
      physicalLocationField.setValue("");
      physicalLocationField.setWidth(250);
      
      flexTable.setText(rowIndex, 0, "Physical Location:");
      flexTable.setWidget(rowIndex, 1, physicalLocationField);
      
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);
      
      rowIndex++;
      
      latlocationField = new TextField<String>();
      latlocationField.setFieldLabel("Lat");
      latlocationField.setValue("");
      latlocationField.setWidth(100);
     
      lonlocationField = new TextField<String>();
      lonlocationField.setFieldLabel("Lon");
      lonlocationField.setValue("");
      lonlocationField.setWidth(100);
      
      flexTable.setText(rowIndex, 0, "Lat/Lon:");
      HorizontalPanel panel1 = new HorizontalPanel();
      panel1.add(latlocationField);
      panel1.add(new Label("/"));
      panel1.add(lonlocationField);
      flexTable.setWidget(rowIndex, 1, panel1);
     
      flexTable.setText(rowIndex, 2, "Accuracy:");
      flexTable.setWidget(rowIndex, 3, createLocationAccuracy());
      
      rowIndex++;
      
      speciesField = new SpeciesField();
      
      flexTable.setText(rowIndex, 0 , "Species:");
      flexTable.setWidget(rowIndex, 1, speciesField);
      
      flexTable.setText(rowIndex, 2, "Overall Condition:");
      flexTable.setWidget(rowIndex, 3, createConditionControl());
      
      rowIndex++;
      
      animalNotFoundField = new CheckBox();
      animalNotFoundField.setFieldLabel("Animal not found");
      
      animalNotFoundField.addListener(Events.Change, 
         new Listener<FieldEvent>()
      {
         @Override
         public void handleEvent(FieldEvent be)
         {
            CheckBox checkBox = (CheckBox)be.getBoxComponent();
          
            boolean isChecked = checkBox.getValue();
            
            isAnimalCheckBoxChanged(isChecked);
         }
      });
      
      flexTable.setText(rowIndex, 0, "Animal not found:");
      flexTable.setWidget(rowIndex, 1, animalNotFoundField);
      flexTable.getFlexCellFormatter().setHorizontalAlignment(rowIndex, 1, HasHorizontalAlignment.ALIGN_LEFT);
      
      rowIndex++;
      
      tagsField = new TextField<String>();
      tagsField.setFieldLabel("Tags");
      tagsField.setValue("");
      tagsField.setWidth(250);
      
      tagsLabel = new Label("Tags:");
      flexTable.setWidget(rowIndex, 0, tagsLabel);
      flexTable.setWidget(rowIndex, 1, tagsField);
      
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);
      
      rowIndex++;
      
      dispositionLabel = new Label("Disposition:");
      flexTable.setWidget(rowIndex, 0, dispositionLabel);
      flexTable.setWidget(rowIndex, 1, createDispositionControl());
      
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);
      
      rowIndex++;
      
      sealPickupLabel = new Label("Seal Pickup:");
      flexTable.setWidget(rowIndex, 0, sealPickupLabel);
      flexTable.setWidget(rowIndex, 1, createSealPickupControl());
      
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);
      
      rowIndex++;
      
      sexLabel = new Label("Sex:");
      flexTable.setWidget(rowIndex, 0, sexLabel);
      flexTable.setWidget(rowIndex, 1, createSexControl());
      
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);
      
      rowIndex++;
      
      weightField = new NumberField();
      weightField.setFieldLabel("Weight (kg)");
      weightField.setValue(0);
      
      weightLabel = new Label("Weight (kg):");
      flexTable.setWidget(rowIndex, 0, weightLabel);
      flexTable.setWidget(rowIndex, 1, weightField);
      
      rowIndex++;
      
      straightLengthField = new NumberField();
      straightLengthField.setValue(0);
      straightLengthField.setFieldLabel("Straight Length (cm)");
      
      straightLengthLabel = new Label("Straight Length (cm):");
      flexTable.setWidget(rowIndex, 0, straightLengthLabel);
      flexTable.setWidget(rowIndex, 1, straightLengthField);
      
      rowIndex++;

      girthField = new NumberField();
      girthField.setValue(0);
      girthField.setFieldLabel("Girth (cm)");
      
      girthLabel = new Label("Girth (cm):");
      flexTable.setWidget(rowIndex, 0, girthLabel);
      flexTable.setWidget(rowIndex, 1, girthField);
      
      rowIndex++;
      
      commentsField = new TextArea();
      commentsField.setFieldLabel("General Comments");
      commentsField.setValue("");
      commentsField.setWidth(450);
      commentsField.setHeight(80);
      
      flexTable.setText(rowIndex,0 , "General Comments:");
      flexTable.setWidget(rowIndex,1, commentsField);
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);
      
      add(flexTable);
   }
   
   private void isAnimalCheckBoxChanged(boolean value)
   {
      tagsLabel.setVisible(!value);
      tagsField.setVisible(!value);
      dispositionLabel.setVisible(!value);
      dispositionComboBox.setVisible(!value);
      sealPickupLabel.setVisible(!value);
      sealPickupComboBox.setVisible(!value);
      sexLabel.setVisible(!value);
      sexComboBox.setVisible(!value);
      
      weightLabel.setVisible(!value);
      weightField.setVisible(!value);
      straightLengthLabel.setVisible(!value);
      straightLengthField.setVisible(!value);
      girthLabel.setVisible(!value);
      girthField.setVisible(!value);
      
      for(AnimalStatusListener animalStatusListener : animalStatusListeners){
    	  if(value){
    		  animalStatusListener.statusChange("NOT_FOUND");
    	  } else{
    		  animalStatusListener.statusChange("FOUND");    		  
    	  }
      }
   }

   private Widget createSexControl()
   {
      ListStore<StringModel> listStore = new ListStore<StringModel>();
      
      listStore.add(new StringModel("Not Determined"));
      listStore.add(new StringModel("Unable to determine"));
      listStore.add(new StringModel("Male"));
      listStore.add(new StringModel("Female"));
      
      sexComboBox = new ComboBox<StringModel>();
      sexComboBox.setFieldLabel("Sex");
      sexComboBox.setDisplayField("name");
      sexComboBox.setTriggerAction(TriggerAction.ALL);
      sexComboBox.setStore(listStore);
      sexComboBox.setForceSelection(true);
      sexComboBox.setValue(new StringModel("Not Determined"));
      
      return sexComboBox;
   }

   private Widget createSealPickupControl()
   {
      ListStore<StringModel> listStore = new ListStore<StringModel>();
      
      listStore.add(new StringModel("None"));
      listStore.add(new StringModel("Injured"));
      listStore.add(new StringModel("Harassment"));
      listStore.add(new StringModel("Public Agent"));
      listStore.add(new StringModel("Dog(s)"));
      listStore.add(new StringModel("Sick"));
      
      sealPickupComboBox = new ComboBox<StringModel>();
      sealPickupComboBox.setFieldLabel("Seal Pickup");
      sealPickupComboBox.setDisplayField("name");
      sealPickupComboBox.setTriggerAction(TriggerAction.ALL);
      sealPickupComboBox.setStore(listStore);
      sealPickupComboBox.setForceSelection(true);
      
      return sealPickupComboBox;
   }

   private Widget createDispositionControl()
   {
      ListStore<StringModel> listStore = new ListStore<StringModel>();
      
      listStore.add(new StringModel("Left at site"));
      listStore.add(new StringModel("Moved"));
      listStore.add(new StringModel("Transport to Rehab"));
      listStore.add(new StringModel("Collected"));
      
      dispositionComboBox = new ComboBox<StringModel>();
      dispositionComboBox.setFieldLabel("Disposition");
      dispositionComboBox.setDisplayField("name");
      dispositionComboBox.setTriggerAction(TriggerAction.ALL);
      dispositionComboBox.setStore(listStore);
      dispositionComboBox.setForceSelection(true);
      
      return dispositionComboBox;
   }
   
   private Widget createLocationAccuracy()
   {
      ListStore<StringModel> listStore = new ListStore<StringModel>();
      
      listStore.add(new StringModel("Estimated"));
      listStore.add(new StringModel("Actual"));
      
      locationAccuracyComboBox = new ComboBox<StringModel>();
      locationAccuracyComboBox.setFieldLabel("Location Accuracy");
      locationAccuracyComboBox.setDisplayField("name");
      locationAccuracyComboBox.setTriggerAction(TriggerAction.ALL);
      locationAccuracyComboBox.setStore(listStore);
      locationAccuracyComboBox.setForceSelection(true);
      
      return locationAccuracyComboBox;
   }

   private Widget createConditionControl()
   {
      ListStore<StringModel> listStore = new ListStore<StringModel>();
      
      listStore.add(new StringModel("Alive"));
      listStore.add(new StringModel("Injured"));
      listStore.add(new StringModel("Dead Fresh"));
      listStore.add(new StringModel("Dead Stinky"));
      listStore.add(new StringModel("Dead Ugly"));
      
      conditionComboBox = new ComboBox<StringModel>();
      conditionComboBox.setFieldLabel("Overall Condition");
      conditionComboBox.setDisplayField("name");
      conditionComboBox.setTriggerAction(TriggerAction.ALL);
      conditionComboBox.setStore(listStore);
      conditionComboBox.setForceSelection(true);
      
      conditionComboBox.addListener(Events.Select, 
    	         new Listener<FieldEvent>()
      {
         @Override
         public void handleEvent(FieldEvent be)
         {
        	 String status = getCondition();
             for(AnimalStatusListener animalStatusListener : animalStatusListeners){
            	 if (status.equalsIgnoreCase("Alive")) animalStatusListener.statusChange("ALIVE");
            	 else if (status.equalsIgnoreCase("Injured")) animalStatusListener.statusChange("ALIVE");
            	 else if (status.equalsIgnoreCase("Dead Fresh")) animalStatusListener.statusChange("DEAD");
            	 else if (status.equalsIgnoreCase("Dead Stinky")) animalStatusListener.statusChange("DEAD");
            	 else if (status.equalsIgnoreCase("Dead Ugly")) animalStatusListener.statusChange("DEAD");
             }
         }
      });
      
      return conditionComboBox;
   }
}
