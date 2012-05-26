package com.mmsn.reportgen.client.view.report;

import com.finfrock.client.Returnable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.report.Report;
import com.mmsn.reportgen.client.data.report.ReportManagerable;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.view.Panel;
import com.mmsn.reportgen.client.view.toolbars.FormEditToolbar;

public class ReportViewPanel extends VerticalPanel implements Panel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private ReportControl reportControl;
   private ReportManagerable reportManager;
   private Report report;
   private boolean isNew = false;
   private FormEditToolbar formEditToolbar;
   private Volunteer volunteer;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportViewPanel(WidgetFactory widgetFactory, 
                          ReportManagerable reportManager, 
                          ServiceLocations serviceLocations)
   {
      this.reportManager = reportManager;
      
      initalize(serviceLocations, widgetFactory);
   }

   // --------------------------------------------------------------------------
   // Panel Members
   // --------------------------------------------------------------------------
   
   @Override
   public Widget getToolbar()
   {
      return formEditToolbar;
   }
   
   @Override
   public String getPanelName()
   {
      return "Report";
   }

   @Override
   public Widget getWidget()
   {
      return this;
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setReport(Report report)
   {
      this.report = report;
      reportControl.setReport(report);
   }

   public void clearData()
   {
      Report report = reportManager.createNewReport();
      
      reportControl.setReport(report);
   }
   
   public void setIsNew(boolean isNewVolunteer)
   {
      this.isNew = isNewVolunteer;
      
      formEditToolbar.setIsNew(isNewVolunteer);
   }
   
   public void setVolunteer(Volunteer volunteer)
   {
      this.volunteer = volunteer;
      
      reportControl.setVolunteer(volunteer);
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private void initalize(ServiceLocations serviceLocations, 
                          WidgetFactory widgetFactory)
   {
      addStyleName("viewpanelItem");
      
      reportControl = new ReportControl(serviceLocations, widgetFactory);

      formEditToolbar = 
         new FormEditToolbar(widgetFactory, reportControl)
      {
         @Override
         protected void resetControl()
         {
            reportControl.setReport(report);
         }

         @Override
         protected void save()
         {
            if (isNew)
            {
               report = reportManager.createNewReport();
               
               report.setVolunteer(volunteer);
               
               isNew = false;
               formEditToolbar.setIsNew(false);
            }
            
            reportControl.fillReport(report);

            reportManager.saveReport(report);
         }
      };
      
      formEditToolbar.addButton("Print", new Returnable<Object>()
      {
         @Override
         public void returned(Object object)
         {
            printButtonClicked();
         }
      });
      
      add(reportControl);
   }
   
   private void printButtonClicked()
   {
      ReportPrinter printer = new ReportPrinter();
      
      Report report = reportManager.createNewReport();
      
      reportControl.fillReport(report);
      
      printer.printReport(report);
   }
}
