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
   
   private Label isConSickField;
   
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
	   if(reportLiveAnimals.isConSick()){
		   isConSickField.setText("[X]");
	   } else{
		   isConSickField.setText("[ ]");
	   }
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {
      addStyleName("printPage");
      
      add(new HTML("<h4>Live Animals</h4>"));
      
      FlexTable flexTable = new FlexTable();
      
      int index = 1;
      
      flexTable.setWidget(1,0, createIsConSick());
      
      flexTable.getFlexCellFormatter().setColSpan(index, 0, 2);
      
      index++;
      
      add(flexTable);
   }
   
   private Widget createIsConSick()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Label label1 = new Label("Sick:");
      
      label1.addStyleName("printLabel");
      
      isConSickField = new Label("[ ]");
      
      isConSickField.addStyleName("printField");
      
      panel.add(isConSickField);
      panel.add(label1);
      
      return panel;
   }
}
