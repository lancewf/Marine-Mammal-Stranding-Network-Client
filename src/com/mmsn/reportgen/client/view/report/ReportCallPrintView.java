package com.mmsn.reportgen.client.view.report;

import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.data.report.ReportCall;

public class ReportCallPrintView extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private Label responderField;
   private Label dateField;
   private Label timeField;
   private Label callFromField;
   private Label callerNamePhoneField;
   private Label speciesField;
   private Label conditionField;
   private Label locationField;
   private Label whenFirstSeenField;
   private Label commentsField;
   private Label callReferredToField;

   private static DateTimeFormat dateformat = 
      DateTimeFormat.getFormat("MMMM d, y");
   
   private static DateTimeFormat timeformat = 
      DateTimeFormat.getFormat("h:mm a");
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportCallPrintView()
   {
      initialize();
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setReportCall(ReportCall reportCall)
   {
      responderField.setText(reportCall.getResponder());
      dateField.setText(dateformat.format(reportCall.getDate()));
      timeField.setText(timeformat.format(reportCall.getDate()));
      callFromField.setText(reportCall.getCallFrom());
      callerNamePhoneField.setText(reportCall.getCallerPhoneNumber());
      speciesField.setText(reportCall.getSpecies());
      conditionField.setText(reportCall.getCondition());
      locationField.setText(reportCall.getLocation());
      whenFirstSeenField.setText(reportCall.getWhenFirstSeen());
      commentsField.setText(reportCall.getComments());
      callReferredToField.setText(reportCall.getCallReferredTo());
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {
      addStyleName("printPage");
      
      add(new HTML("<h4>CALL</h4>"));
      
      FlexTable flexTable = new FlexTable();
      
      flexTable.setWidget(1,0, createResponder());
      
      flexTable.getFlexCellFormatter().setColSpan(1, 0, 2);
      
      flexTable.setWidget(2,0, createDateControl());
      flexTable.setWidget(2,1, createTimeControl());
      
      flexTable.setWidget(3, 0, createCallFrom());
      
      flexTable.setWidget(4, 0, createCallerNamePhone());
      
      flexTable.getFlexCellFormatter().setColSpan(4, 0, 2);
      
      flexTable.setWidget(5, 0, createLocation());
      
      flexTable.getFlexCellFormatter().setColSpan(5, 0, 2);
      
      flexTable.setWidget(6, 0, createSpecies());
      
      flexTable.setWidget(6, 1, createCondition());
      
      flexTable.setWidget(7, 0, createWhenFirstSeen());
      
      flexTable.getFlexCellFormatter().setColSpan(7, 0, 2);
      
      flexTable.setWidget(8, 0, createComments());
      
      flexTable.getFlexCellFormatter().setColSpan(8, 0, 2);
      
      flexTable.setWidget(9, 0, createCallReferredTo());
      
      flexTable.getFlexCellFormatter().setColSpan(9, 0, 2);
      
      add(flexTable);
   }

   private Widget createCallReferredTo()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label1 = new Label("Call referred to:");
      
      label1.addStyleName("printLabel");
      
      callReferredToField = new Label("");
      
      callReferredToField.addStyleName("printField");
      
      panel.add(label1);
      panel.add(callReferredToField);
      
      return panel;
   }

   private Widget createComments()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label1 = new Label("Comments:");
      
      label1.addStyleName("printLabel");
      
      commentsField = new Label("");
      
      commentsField.addStyleName("printField");
      
      panel.add(label1);
      panel.add(commentsField);
      
      return panel;
   }

   private Widget createWhenFirstSeen()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label1 = new Label("When First Seen:");
      
      label1.addStyleName("printLabel");
      
      whenFirstSeenField = new Label("");
      
      whenFirstSeenField.addStyleName("printField");
      
      panel.add(label1);
      panel.add(whenFirstSeenField);
      
      return panel;
   }

   private Widget createSpecies()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label1 = new Label("Species:");
      
      label1.addStyleName("printLabel");
      
      speciesField = new Label("");
      
      speciesField.addStyleName("printField");
      
      panel.add(label1);
      panel.add(speciesField);
      
      return panel;
   }
   
   private Widget createCondition()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label2 = new Label("Condition:");
      
      label2.addStyleName("printLabel");
      
      conditionField = new Label("");
      
      conditionField.addStyleName("printField");
      
      panel.add(label2);
      panel.add(conditionField);
      
      return panel;
   }

   private Widget createLocation()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label1 = new Label("Location:");
      
      label1.addStyleName("printLabel");
      
      locationField = new Label("");
      
      locationField.addStyleName("printField");
      
      panel.add(label1);
      panel.add(locationField);
      
      return panel;
   }

   private Widget createCallerNamePhone()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label1 = new Label("Caller Name & Phone:");
      
      label1.addStyleName("printLabel");
      
      callerNamePhoneField = new Label("");
      
      callerNamePhoneField.addStyleName("printField");
      
      panel.add(label1);
      panel.add(callerNamePhoneField);
      
      return panel;
   }

   private Widget createCallFrom()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label1 = new Label("Call From:");
      
      label1.addStyleName("printLabel");
      
      callFromField = new Label("");
      
      callFromField.addStyleName("printField");
      
      panel.add(label1);
      panel.add(callFromField);
      
      return panel;
   }

   private Widget createTimeControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label2 = new Label("Time:");
      
      label2.addStyleName("printLabel");
      
      timeField = new Label("");
      
      timeField.addStyleName("printField");
      
      panel.add(label2);
      panel.add(timeField);
      
      return panel;
   }
   
   private Widget createDateControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label1 = new Label("Date:");
      
      label1.addStyleName("printLabel");
      
      dateField = new Label("");
      
      dateField.addStyleName("printField");
      
      panel.add(label1);
      panel.add(dateField);
      
      return panel;
   }

   private Widget createResponder()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label1 = new Label("Responder:");
      
      label1.addStyleName("printLabel");
      
      responderField = new Label("");
      
      responderField.addStyleName("printField");
      
      panel.add(label1);
      panel.add(responderField);
      
      return panel;
   }

}
