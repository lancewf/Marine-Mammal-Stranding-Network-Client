package com.mmsn.reportgen.client.view.report;

import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.data.report.ReportInvestigation;

public class ReportInvestigationPrintView extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private static DateTimeFormat dateformat = 
      DateTimeFormat.getFormat("MMMM d, y");
   
   private static DateTimeFormat timeformat = 
      DateTimeFormat.getFormat("h:mm a");

   private Label commentsField;

   private Label girthField;

   private Label straightLengthField;

   private Label weightField;

   private Label sexField;

   private Label sealPickupField;

   private Label dispositionField;

   private Label tagsField;

   private Label conditionField;

   private Label speciesField;

   private Label latLonLocationField;
   
   private Label physicalLocationField;

   private Label startTimeField;

   private Label dateField;

   private Label investigatorSupportField;

   private Label animalNotFoundField;
   
   private Label girthlabel;
   private Label straightLengthLabel;
   private Label weightLabel;
   private Label sexlabel;
   private Label sealPickupLabel;
   private Label dispositionLabel;
   private Label tagsLabel;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportInvestigationPrintView()
   {
      initialize();
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setReportInvestigation(ReportInvestigation reportInvestigation)
   {
      sealPickupField.setText(reportInvestigation.getSealPickup());
      dispositionField.setText(reportInvestigation.getDisposition());
      tagsField.setText(reportInvestigation.getTags());
      conditionField.setText(reportInvestigation.getCondition());
      speciesField.setText(reportInvestigation.getSpecies());
      latLonLocationField.setText(reportInvestigation.getLatLonLocation());
      physicalLocationField.setText(reportInvestigation.getPhysicalLocation());
      investigatorSupportField.setText(reportInvestigation.getInvestigatorSupport());
      
      if(reportInvestigation.isAnimalNotFound())
      {
         animalNotFoundField.setText("X");
         girthField.setVisible(false);
         girthlabel.setVisible(false);
         straightLengthField.setVisible(false);
         straightLengthLabel.setVisible(false);
         weightField.setVisible(false);
         weightLabel.setVisible(false);
         sexField.setVisible(false);
         sexlabel.setVisible(false);
         sealPickupField.setVisible(false);
         sealPickupLabel.setVisible(false);
         dispositionField.setVisible(false);
         dispositionLabel.setVisible(false);
         tagsField.setVisible(false);
         tagsLabel.setVisible(false);
      }
      else
      {
         animalNotFoundField.setText("_");
         girthField.setVisible(true);
         girthlabel.setVisible(true);
         straightLengthField.setVisible(true);
         straightLengthLabel.setVisible(true);
         weightField.setVisible(true);
         weightLabel.setVisible(true);
         sexField.setVisible(true);
         sexlabel.setVisible(true);
         sealPickupField.setVisible(true);
         sealPickupLabel.setVisible(true);
         dispositionField.setVisible(true);
         dispositionLabel.setVisible(true);
         tagsField.setVisible(true);
         tagsLabel.setVisible(true);
      }
      
      girthField.setText(reportInvestigation.getGirth() + " cm");
      straightLengthField.setText(reportInvestigation.getStraightLength() + " cm");
      weightField.setText(reportInvestigation.getWeight() + " kg");
      sexField.setText(reportInvestigation.getSex());
      
      commentsField.setText(reportInvestigation.getComments());
      
      dateField.setText(dateformat.format(reportInvestigation.getDate()));
      startTimeField.setText(timeformat.format(reportInvestigation.getDate()));
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {
      addStyleName("printPage");
      
      add(new HTML("<h4>INVESTIGATION</h4>"));
      
      FlexTable flexTable = new FlexTable();
      
      int index = 1;
      
      flexTable.setWidget(index, 0, createInvestigatorSupportControl());
      
      flexTable.getFlexCellFormatter().setColSpan(index, 0, 2);
      
      index++;
      
      flexTable.setWidget(index, 0, createDateControl());
      
      flexTable.setWidget(index, 1, createStartTimeControl());

      index++;
      
      flexTable.setWidget(index, 0, createPhysicalLocationControl());
      
      flexTable.setWidget(index, 0, createLatLonLocationControl());
      
      flexTable.getFlexCellFormatter().setColSpan(index, 0, 2);

      index++;
      
      flexTable.setWidget(index, 0, createSpeciesControl());
      
      flexTable.setWidget(index, 1, createConditionControl());
      
      index++;
      
      flexTable.setWidget(index, 0, createAnimalNotFoundControl());
      
      flexTable.getFlexCellFormatter().setColSpan(index, 0, 2);

      index++;
      
      flexTable.setWidget(index, 0, createTagsControl());
      
      flexTable.getFlexCellFormatter().setColSpan(index, 0, 2);

      index++;
      
      flexTable.setWidget(index, 0, createDispositionControl());
      
      flexTable.setWidget(index, 1, createSealPickupControl());

      index++;
      
      flexTable.setWidget(index, 0, createSexControl());
      
      flexTable.setWidget(index, 1, createWeightControl());
      
      index++;
      
      flexTable.setWidget(index, 0, createStraightLenghtControl());
      
      flexTable.setWidget(index, 0, createGirthControl());
      
      index++;
      
      flexTable.setWidget(index, 0, createCommentsControl());
      
      flexTable.getFlexCellFormatter().setColSpan(index, 0, 2);
      
      add(flexTable);
   }

   private Widget createCommentsControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label2 = new Label("General Comments:");
      
      label2.addStyleName("printLabel");
      
      commentsField = new Label("");
      
      commentsField.addStyleName("printField");
      
      panel.add(label2);
      panel.add(commentsField);
      
      return panel;
   }
   
   private Widget createGirthControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      girthlabel = new Label("Girth:");
      
      girthlabel.addStyleName("printLabel");
      
      girthField = new Label("");
      
      girthField.addStyleName("printField");
      
      panel.add(girthlabel);
      panel.add(girthField);
      
      return panel;
   }

   private Widget createStraightLenghtControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      straightLengthLabel = new Label("Straight Length:");
      
      straightLengthLabel.addStyleName("printLabel");
      
      straightLengthField = new Label("");
      
      straightLengthField.addStyleName("printField");
      
      panel.add(straightLengthLabel);
      panel.add(straightLengthField);
      
      return panel;
   }

   private Widget createWeightControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      weightLabel = new Label("Weight:");
      
      weightLabel.addStyleName("printLabel");
      
      weightField = new Label("");
      
      weightField.addStyleName("printField");
      
      panel.add(weightLabel);
      panel.add(weightField);
      
      return panel;
   }
   
   private Widget createSexControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      sexlabel = new Label("Sex:");
      
      sexlabel.addStyleName("printLabel");
      
      sexField = new Label("");
      
      sexField.addStyleName("printField");
      
      panel.add(sexlabel);
      panel.add(sexField);
      
      return panel;
   }
   
   private Widget createSealPickupControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      sealPickupLabel = new Label("Seal pickup:");
      
      sealPickupLabel.addStyleName("printLabel");
      
      sealPickupField = new Label("");
      
      sealPickupField.addStyleName("printField");
      
      panel.add(sealPickupLabel);
      panel.add(sealPickupField);
      
      return panel;
   }

   private Widget createDispositionControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      dispositionLabel = new Label("Disposition:");
      
      dispositionLabel.addStyleName("printLabel");
      
      dispositionField = new Label("");
      
      dispositionField.addStyleName("printField");
      
      panel.add(dispositionLabel);
      panel.add(dispositionField);
      
      return panel;
   }

   private Widget createTagsControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      tagsLabel = new Label("Tags:");
      
      tagsLabel.addStyleName("printLabel");
      
      tagsField = new Label("");
      
      tagsField.addStyleName("printField");
      
      panel.add(tagsLabel);
      panel.add(tagsField);
      
      return panel;
   }

   private Widget createConditionControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label2 = new Label("Overall Condition:");
      
      label2.addStyleName("printLabel");
      
      conditionField = new Label("");
      
      conditionField.addStyleName("printField");
      
      panel.add(label2);
      panel.add(conditionField);
      
      return panel;
   }

   private Widget createAnimalNotFoundControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label2 = new Label("Animal not found:");
      
      label2.addStyleName("printLabel");
      
      animalNotFoundField = new Label("");
      
      animalNotFoundField.addStyleName("printField");
      
      panel.add(label2);
      panel.add(animalNotFoundField);
      
      return panel;
   }

   private Widget createSpeciesControl()
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

   private Widget createLatLonLocationControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label1 = new Label("Lat\\Lon:");
      
      label1.addStyleName("printLabel");
      
      latLonLocationField = new Label("");
      
      latLonLocationField.addStyleName("printField");
      
      panel.add(label1);
      panel.add(latLonLocationField);
      
      return panel;
   }
   
   private Widget createPhysicalLocationControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label1 = new Label("Physical Location:");
      
      label1.addStyleName("printLabel");
      
      physicalLocationField = new Label("");
      
      physicalLocationField.addStyleName("printField");
      
      panel.add(label1);
      panel.add(physicalLocationField);
      
      return panel;
   }

   private Widget createStartTimeControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label2 = new Label("Time:");
      
      label2.addStyleName("printLabel");
      
      startTimeField = new Label("");
      
      startTimeField.addStyleName("printField");
      
      panel.add(label2);
      panel.add(startTimeField);
      
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

   private Widget createInvestigatorSupportControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label1 = new Label("Responder(s):");
      
      label1.addStyleName("printLabel");
      
      investigatorSupportField = new Label("");
      
      investigatorSupportField.addStyleName("printField");
      
      panel.add(label1);
      panel.add(investigatorSupportField);
      
      return panel;
   }
}
