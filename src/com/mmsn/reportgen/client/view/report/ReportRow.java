package com.mmsn.reportgen.client.view.report;

import java.util.Date;

import com.finfrock.client.Column;
import com.finfrock.client.CommonColumn;
import com.finfrock.client.DataChangeListener;
import com.finfrock.client.Row;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.User;
import com.mmsn.reportgen.client.data.report.Report;
import com.mmsn.reportgen.client.data.report.ReportManagerable;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.view.DeleteConfirmationPanel;
import com.mmsn.reportgen.client.view.ViewPanel;
import com.mmsn.reportgen.client.view.images.MMSNClientBundle;

public class ReportRow extends Row
{
   // --------------------------------------------------------------------------
   // Public static Data
   // --------------------------------------------------------------------------

   public static final int VIEW_INDEX = 0;

   public static final int DATE_TIME_INDEX = 1;

   public static final int WRITTEN_BY_INDEX = 2;
   
   public static final int SPECIES_INDEX = 3;

   public static final int LOCATION_INDEX = 4;

   public static final int DELETE_INDEX = 5;

   private static DateTimeFormat datetimeformat = 
      DateTimeFormat.getFormat("MMMM d, y h:mm a");
   
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Report report;
   private ReportManagerable reportManager;
   private WidgetFactory widgetFactory;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportRow(Report report, ReportManagerable reportManager, 
                    WidgetFactory widgetFactory, User user)
   {
      this.report = report;
      this.reportManager = reportManager;
      this.widgetFactory = widgetFactory;
      
      addColumn(createViewColumn());
      addColumn(createDateTimeColumn());
      addColumn(createWrittenByColumn());
      addColumn(createSpeciesColumn());
      addColumn(createLocationColumn());
      
      if(user.isAdmin())
      {
         addColumn(createDeleteColumn());
      }
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private Column createDeleteColumn()
   {
      CommonColumn column = new CommonColumn();
      
      MMSNClientBundle mmsnImageBundle = (MMSNClientBundle) 
      GWT.create(MMSNClientBundle.class);
      
      ImageResource deleteImageResource = mmsnImageBundle.deleteIcon();
      
      Image deleteimage = new Image(deleteImageResource);
      
      deleteimage.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            deleteReport();
         }
      });
      
      column.setValue(deleteimage);
      column.setIndex(DELETE_INDEX);
      column.setStyleName("buttonColumn");
      column.setValueType(Column.WIDGET_COLUMN_TYPE);
      
      return column;
   }
   
   private void deleteReport()
   {
      final ViewPanel viewPanel = widgetFactory.getViewPanel();
      
      final DeleteConfirmationPanel deleteConfirmationPanel = 
         new DeleteConfirmationPanel();
      
      deleteConfirmationPanel.setText("Are you sure you would like to delete " +
      		"this Report?");
      
      viewPanel.show(deleteConfirmationPanel);
      
      deleteConfirmationPanel.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            if(deleteConfirmationPanel.getReponse() == DeleteConfirmationPanel.YES)
            {
               reportManager.removeReport(report);
               
               viewPanel.showPreivous();
            }
            else if(deleteConfirmationPanel.getReponse() == 
               DeleteConfirmationPanel.NO)
            {
               viewPanel.showPreivous();
            }
         }
      });
   }
   
   private Column createViewColumn()
   {
      CommonColumn column = new CommonColumn();
      
      MMSNClientBundle mmsnImageBundle = (MMSNClientBundle) 
         GWT.create(MMSNClientBundle.class);
      
      ImageResource reportImageResource = mmsnImageBundle.reportIcon();
      
      final HorizontalPanel panel = new HorizontalPanel();
      final Label loadingLabel = new Label("loading...");
      loadingLabel.setVisible(false);
      
      final Image reportimage = new Image(reportImageResource);
      
      reportimage.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {  
            loadingLabel.setVisible(true);
            reportimage.setVisible(false);
            Timer timer = new Timer()
            {
               @Override
               public void run()
               {
                  widgetFactory.showReportViewPanel(report);
                  loadingLabel.setVisible(false);
                  reportimage.setVisible(true);
               }
            };
           
            timer.schedule(100);
         }
      });
      
      panel.add(reportimage);

      panel.add(loadingLabel);
      
      column.setValue(panel);
      column.setIndex(VIEW_INDEX);
      column.setStyleName("buttonColumn");
      column.setValueType(Column.WIDGET_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createLocationColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue(report.getReportCall().getLocation());
      column.setIndex(LOCATION_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }

   private Column createSpeciesColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue(report.getReportCall().getSpecies());
      column.setIndex(SPECIES_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }

   private Column createWrittenByColumn()
   {
      CommonColumn column = new CommonColumn();
      
      String writtenBy = "";
      Volunteer volunteer = report.getVolunteer();
      
      if(volunteer != null)
      {
         writtenBy = volunteer.getFullName();
      }
      else
      {
         writtenBy = "admin";
      }
      
      column.setValue(writtenBy);
      column.setIndex(WRITTEN_BY_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }

   private Column createDateTimeColumn()
   {
      CommonColumn column = new CommonColumn();
      
      Date date = report.getReportInvestigation().getDate();
      
      String text = "";
      
      if(date != null)
      {
         text = datetimeformat.format(date);
      }
      
      column.setValue(text);
      column.setIndex(DATE_TIME_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
}
