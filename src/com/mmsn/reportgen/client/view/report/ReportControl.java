package com.mmsn.reportgen.client.view.report;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.attachment.AttachmentList;
import com.mmsn.reportgen.client.data.report.Report;
import com.mmsn.reportgen.client.data.report.ReportCall;
import com.mmsn.reportgen.client.data.report.ReportInvestigation;
import com.mmsn.reportgen.client.data.report.ReportLiveAnimals;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.view.FormEditControl;
import com.mmsn.reportgen.client.view.attachment.AttachmentsControl;

public class ReportControl extends VerticalPanel implements FormEditControl
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private ReportCallControl reportCallControl;
   private ReportInvestigationControl reportInvestigationControl;
   private ReportLiveAnimalsControl reportLiveAnimalsControl;
   private Label editLabel1;
   private Label editLabel2;
   private AttachmentsControl photoControl;
   private WidgetFactory widgetFactory;
   private Label saveLabel1;
   private Label saveLabel2;
   private Label writtenByLabel;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportControl(ServiceLocations serviceLocations, 
                        WidgetFactory widgetFactory)
   {
      this.widgetFactory = widgetFactory;
      
      initialize(serviceLocations);
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setReadOnly(boolean readOnly)
   {
      reportCallControl.setReadOnly(readOnly);
      reportInvestigationControl.setReadOnly(readOnly);
      reportLiveAnimalsControl.setReadOnly(readOnly);

      if(readOnly)
      {
         editLabel1.setVisible(true);
         editLabel2.setVisible(true);
         saveLabel1.setVisible(false);
         saveLabel2.setVisible(false);
         photoControl.setReadOnly(true);
      }
      else
      {
         editLabel1.setVisible(false);
         editLabel2.setVisible(false);
         saveLabel1.setVisible(true);
         saveLabel2.setVisible(true);
         photoControl.setReadOnly(false);
      }
   }
   
   public void setReportCall(ReportCall reportCall)
   {
      reportCallControl.setReportCall(reportCall);
   }

   public void setReportLiveAnimals(ReportLiveAnimals reportLiveAnimals)
   {
      reportLiveAnimalsControl.setReportLiveAnimals(reportLiveAnimals);
   }
   
   public void setReportInvestigation(ReportInvestigation reportInvestigation)
   {
      reportInvestigationControl.setReportInvestigation(reportInvestigation);
   }
   
   public void setAttachments(AttachmentList attachmentList)
   {  
      photoControl.setAttachments(attachmentList);
   }
   
   public ReportCall getReportCall()
   {
      return reportCallControl.getReportCall();
   }
   
   public ReportLiveAnimals getReportLiveAnimals()
   {
      return reportLiveAnimalsControl.getReportLiveAnimals();
   }

   public ReportInvestigation getReportInvestigation()
   {
      return reportInvestigationControl.getReportInvestigation();
   }
   
   public void setReport(Report report)
   {
      setReportCall(report.getReportCall());
      
      setReportInvestigation(report.getReportInvestigation());
      
      setReportLiveAnimals(report.getReportLiveAnimals());
      
      photoControl.setIsPhotosTaken(report.getIsPhotoTaken());
      
      setAttachments(report.getAttachments());
      
      Volunteer volunteer = report.getVolunteer();
      
      setVolunteer(volunteer);
   }
   
   public void setVolunteer(Volunteer volunteer)
   {
      String author = "";
      if(volunteer != null)
      {
         author = volunteer.getFullName();
      }
      else
      {
         author = "admin";
      }
      
      writtenByLabel.setText("Report written by: " + author);
   }
   
   public void fillReport(Report report)
   {
      reportCallControl.fillReportCall(report.getReportCall());
      reportInvestigationControl.fillReportInvestigation(
         report.getReportInvestigation());
      reportLiveAnimalsControl.fillReportLiveAnimals(report.getReportLiveAnimals());

      report.setIsPhotoTaken(photoControl.getIsPhotosTaken());      
      report.setAttachments(photoControl.getAttachments());
   }
   
   public boolean isVaild()
   {
      return false;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize(ServiceLocations serviceLocations)
   {
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      editLabel1 = new Label("To edit this report select Edit at the top of this page.");
      editLabel2 = new Label("To edit this report select Edit at the top of this page.");
      saveLabel1 = new Label("Select Save to keep your changes.");
      saveLabel1.setVisible(false);
      saveLabel2 = new Label("Select Save to keep your changes.");
      saveLabel2.setVisible(false);
      
      saveLabel1.setStyleName("saveLabel");
      saveLabel2.setStyleName("saveLabel");
      
      editLabel1.setStyleName("editLabel");
      editLabel2.setStyleName("editLabel");
      
      Label title = new Label("Stranding Response Report");
      
      title.setStyleName("pageTitle");
      add(title);
      add(editLabel1);
      add(saveLabel1);
      
      writtenByLabel = new Label("Report written by:");
      add(writtenByLabel);
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      
      reportCallControl = new ReportCallControl();
      
      reportInvestigationControl = 
         new ReportInvestigationControl();

      reportLiveAnimalsControl = 
         new ReportLiveAnimalsControl();
      
      photoControl = new AttachmentsControl(serviceLocations, widgetFactory);
      
      add(reportCallControl);
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      add(editLabel2);
      add(saveLabel2);
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      
      add(reportInvestigationControl);
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      add(editLabel2);
      add(saveLabel2);
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      
      add(reportLiveAnimalsControl);

      add(photoControl);
   }
}
