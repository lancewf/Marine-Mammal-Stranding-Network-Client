package com.mmsn.reportgen.client.view.report;

import java.util.Date;

import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.DatePicker;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.TimeField;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.data.report.ReportCall;
import com.mmsn.reportgen.client.view.PhoneNumberField;
import com.mmsn.reportgen.client.view.StringModel;

public class ReportCallControl extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private boolean readOnly;
   private TextField<String> responderField;
   private TextField<String> locationField;
   private TextField<String> whenFirstSeenField;
   private TextField<String> callReferredToField;
   private TextArea commentsField;
   private TimeField timeField;
   private DatePicker datePicker;
   private SpeciesField speciesField;
   private ComboBox<StringModel> conditionComboBox;
   private ComboBox<StringModel> callFromComboBox;
   private PhoneNumberField phoneNumberField;
   private TextField<String> callerNameField;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportCallControl()
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
   
   public String getResponder()
   {
      return responderField.getRawValue();
   }
   
   public void setResponder(String responder)
   {
      responderField.setValue(responder);
   }
   
   public Date getDateTime()
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
   
   public void setDateTime(Date date)
   {
      timeField.setDateValue(date);
      datePicker.setValue(date);
   }
   
   public String getCallFrom()
   {
      return callFromComboBox.getRawValue();
   }
   
   public void setCallFrom(String callFrom)
   {
      callFromComboBox.setValue(new StringModel(callFrom));
   }
   
   public String getCallerName()
   {
      return callerNameField.getRawValue();
   }
   
   public void setCallerName(String callerName)
   {
      callerNameField.setValue(callerName);
   }
   
   public String getCallerPhone()
   {
      return phoneNumberField.getRawValue();
   }
   
   public void setCallerPhone(String callerPhone)
   {
      phoneNumberField.setValue(callerPhone);
   }
   
   public String getLocation()
   {
      return locationField.getRawValue();
   }
   
   public void setLocation(String location)
   {
      locationField.setValue(location);
   }
   
   public String getSpecies()
   {
      return speciesField.getRawValue();
   }
   
   public void setSpecies(String species)
   {
      speciesField.setValue(species);
   }
   
   public String getWhenFirstSeen()
   {
      return whenFirstSeenField.getRawValue();
   }
   
   public void setWhenFirstSeen(String whenFirstSeen)
   {
      whenFirstSeenField.setValue(whenFirstSeen);
   }
   
   public String getComments()
   {
      return commentsField.getRawValue();
   }
   
   public void setComments(String comments)
   {
      commentsField.setValue(comments);
   }
   
   public String getCallReferredTo()
   {
      return callReferredToField.getRawValue();
   }
   
   public void setCallReferredTo(String callReferredTo)
   {
      callReferredToField.setValue(callReferredTo);
   }
   
   public String getCondition()
   {
      return conditionComboBox.getRawValue();
   }
   
   public void setCondition(String condition)
   {
      conditionComboBox.setValue(new StringModel(condition));
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
   
   public void setReportCall(ReportCall reportCall)
   {
      setResponder(reportCall.getResponder());
      setLocation(reportCall.getLocation());
      setWhenFirstSeen(reportCall.getWhenFirstSeen());
      setCallReferredTo(reportCall.getCallReferredTo());
      setComments(reportCall.getComments());
      setDateTime(reportCall.getDate());
      setSpecies(reportCall.getSpecies());
      setCondition(reportCall.getCondition());
      setCallFrom(reportCall.getCallFrom());
      setCallerPhone(reportCall.getCallerPhoneNumber());
      setCallerName(reportCall.getCallerName());
   }
   
   public void fillReportCall(ReportCall reportCall)
   {
      reportCall.setResponder(getResponder());
      reportCall.setLocation(getLocation());
      reportCall.setWhenFirstSeen(getWhenFirstSeen());
      reportCall.setCallerName(getCallerName());
      reportCall.setComments(getComments());
      reportCall.setDate(getDateTime());
      reportCall.setCallFrom(getCallFrom());
      reportCall.setSpecies(getSpecies());
      reportCall.setCallerPhoneNumber(getCallerPhone());
      reportCall.setCallReferredTo(getCallReferredTo());
      reportCall.setCondition(getCondition());
   }
   
   public ReportCall getReportCall()
   {
      ReportCall reportCall = new ReportCall();
      
      fillReportCall(reportCall);
      
      return reportCall;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void setToWritable()
   {
      readOnly = false;
      responderField.setReadOnly(false);
      locationField.setReadOnly(false);
      whenFirstSeenField.setReadOnly(false);
      callReferredToField.setReadOnly(false);
      commentsField.setReadOnly(false);
      timeField.setReadOnly(false);
      datePicker.setEnabled(true);
      speciesField.setReadOnly(false);
      conditionComboBox.setReadOnly(false);
      callFromComboBox.setReadOnly(false);
      phoneNumberField.setReadOnly(false);
      callerNameField.setReadOnly(false);
   }
   
   private void setToReadOnly()
   {
      readOnly = true;
      responderField.setReadOnly(true);
      locationField.setReadOnly(true);
      whenFirstSeenField.setReadOnly(true);
      callReferredToField.setReadOnly(true);
      commentsField.setReadOnly(true);
      timeField.setReadOnly(true);
      datePicker.setEnabled(false);
      speciesField.setReadOnly(true);
      conditionComboBox.setReadOnly(true);
      callFromComboBox.setReadOnly(true);
      phoneNumberField.setReadOnly(true);
      callerNameField.setReadOnly(true);
   }

   private void initialize()
   {
	  Label title = new Label("Initial Report");
		  
	  title.addStyleName("sectionTile");
      add(title);
      
      FlexTable flexTable = new FlexTable();
      flexTable.setCellSpacing(10);
      flexTable.addStyleName("reportControlTable");
      
      int rowIndex = 1;
      
      responderField = new TextField<String>();
      responderField.setFieldLabel("Responder(s)");
      responderField.setValue("");
      responderField.setWidth(250);
      
      flexTable.setText(rowIndex, 0 , "Responder(s):");
      flexTable.setWidget(rowIndex, 1, responderField);
      
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);
      
      rowIndex++;
      
      datePicker = new DatePicker();
      datePicker.setValue(new Date());
      flexTable.setWidget(rowIndex, 0, datePicker);
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 0, 2);
      
      rowIndex++;
      
      timeField = new TimeField();
      timeField.setFieldLabel("Call Time");
      timeField.setIncrement(1);
      timeField.setForceSelection(true);
      
      flexTable.setText(rowIndex, 0, "Call Time:");
      flexTable.setWidget(rowIndex, 1, timeField);
      
      rowIndex++;
      
      locationField = new TextField<String>();
      locationField.setFieldLabel("Reported Location");
      locationField.setValue("");
      locationField.setWidth(250);
      
      flexTable.setText(rowIndex, 0, "Reported Location:");
      flexTable.setWidget(rowIndex, 1, locationField);
      
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);
      
      rowIndex++;

      flexTable.setText(rowIndex, 0, "Call From:");
      flexTable.setWidget(rowIndex, 1, createCallFrom());
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);
      
      rowIndex++;
      
      callerNameField = new TextField<String>();
      callerNameField.setFieldLabel("Caller Name");
      callerNameField.setValue("");
      
      flexTable.setText(rowIndex, 0 , "Caller Name:");
      flexTable.setWidget(rowIndex, 1, callerNameField);
      
      phoneNumberField = new PhoneNumberField();
      phoneNumberField.setValue("");
      phoneNumberField.setFieldLabel("Caller Phone");
      
      flexTable.setText(rowIndex, 2, "Caller Phone:");
      flexTable.setWidget(rowIndex, 3, phoneNumberField);
      
      rowIndex++;
      
      
      speciesField = new SpeciesField();
      
      flexTable.setText(rowIndex, 0 , "Species:");
      flexTable.setWidget(rowIndex, 1, speciesField);
      
      flexTable.setText(rowIndex, 2, "Reported Condition:");
      flexTable.setWidget(rowIndex, 3, createConditionComboBox());
      
      rowIndex++;
      
      whenFirstSeenField = new TextField<String>();
      whenFirstSeenField.setWidth(250);
      
      flexTable.setText(rowIndex,0 , "When first seen:");
      flexTable.setWidget(rowIndex,1, whenFirstSeenField);
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);
      
      rowIndex++;
      
      commentsField = new TextArea();
      commentsField.setFieldLabel("General Comments");
      commentsField.setValue("");
      commentsField.setWidth(450);
      commentsField.setHeight(80);
      
      flexTable.setText(rowIndex,0 , "General Comments:");
      flexTable.setWidget(rowIndex,1, commentsField);
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);
      
      rowIndex++;
      
      callReferredToField = new TextField<String>();
      callReferredToField.setFieldLabel("Call referred to");
      callReferredToField.setValue("");
      callReferredToField.setWidth(250);
      
      flexTable.setText(rowIndex, 0 , "Call referred to:");
      flexTable.setWidget(rowIndex, 1, callReferredToField);
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 1, 4);
      
      add(flexTable);
   }
   
   private Widget createConditionComboBox()
   {
      ListStore<StringModel> conditionListStore = new ListStore<StringModel>();
      
      conditionListStore.add(new StringModel("Alive"));
      conditionListStore.add(new StringModel("Dead"));
      conditionListStore.add(new StringModel("Injured"));
      
      conditionComboBox = new ComboBox<StringModel>();
      conditionComboBox.setFieldLabel("Reported Condition");
      conditionComboBox.setDisplayField("name");
      conditionComboBox.setTriggerAction(TriggerAction.ALL);
      conditionComboBox.setStore(conditionListStore);
      conditionComboBox.setForceSelection(true);
      
      return conditionComboBox;
   }
   
   public Widget createCallFrom()
   {
      ListStore<StringModel> callFromListStore = new ListStore<StringModel>();
      
      callFromListStore.add(new StringModel("Hotline"));
      callFromListStore.add(new StringModel("Wolf Hollow"));
      callFromListStore.add(new StringModel("Public"));
      callFromListStore.add(new StringModel("TWM staff"));
      callFromListStore.add(new StringModel("Other"));
      
      callFromComboBox = new ComboBox<StringModel>();
      callFromComboBox.setFieldLabel("Call From");
      callFromComboBox.setDisplayField("name");
      callFromComboBox.setTriggerAction(TriggerAction.ALL);
      callFromComboBox.setStore(callFromListStore);
      callFromComboBox.setForceSelection(true);
      callFromComboBox.setWidth(100);
      
      return callFromComboBox;
   }
}
