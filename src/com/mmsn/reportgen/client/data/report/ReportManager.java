package com.mmsn.reportgen.client.data.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.finfrock.client.DataChangeListener;
import com.finfrock.client.Returnable;
import com.google.gwt.user.client.Window;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.connection.attachment.AttachmentAddedSender;
import com.mmsn.reportgen.client.connection.attachment.AttachmentDeleter;
import com.mmsn.reportgen.client.connection.attachment.AttachmentModifiedSender;
import com.mmsn.reportgen.client.connection.report.ReportAddedSender;
import com.mmsn.reportgen.client.connection.report.ReportDeleter;
import com.mmsn.reportgen.client.connection.report.ReportModifiedSender;
import com.mmsn.reportgen.client.data.attachment.Attachment;
import com.mmsn.reportgen.client.data.attachment.AttachmentList;

public class ReportManager implements ReportManagerable
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private List<Report> reports;
   private List<DataChangeListener> dataChangeListeners = 
      new ArrayList<DataChangeListener>();
   private ReportModifiedSender reportModifiedSender;
   private ReportAddedSender reportAddedSender;
   private ReportDeleter reportDeleter;
   private ServiceLocations serviceLocations;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
	public ReportManager(List<Report> reports,
			ReportModifiedSender reportModifiedSender,
			ReportAddedSender reportAddedSender, ReportDeleter reportDeleter,
			ServiceLocations serviceLocations) {
		this.serviceLocations = serviceLocations;
		this.reports = reports;
		this.reportAddedSender = reportAddedSender;
		this.reportDeleter = reportDeleter;
		this.reportModifiedSender = reportModifiedSender;

		reportModifiedSender.addReturnableListener(new Returnable<Boolean>() {
			@Override
			public void returned(Boolean reponse) {
				if(reponse){
					Window.alert("Report Updated Success");
				} else{
					Window.alert("Report Update Failed. Please Edit and Save again");
				}
			}
		});
		
        reportAddedSender.addFinishSavingListener(new Returnable<Report>()
        {
           @Override
           public void returned(Report report)
           {
              saveAttachments(report);
           }
        });
	}
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.ReportManagerable#getReports()
    */
   public List<Report> getReports()
   {
      return reports;
   }

   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.ReportManagerable#addDataChangeListener(com.finfrock.client.DataChangeListener)
    */
   public void addDataChangeListener(
                                   DataChangeListener dataChangeListener)
   {
      dataChangeListeners.add(dataChangeListener);
   }
   
   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.ReportManagerable#createNewReport()
    */
   public Report createNewReport()
   {
      Report report = new Report();
      
      ReportCall reportCall = new ReportCall();
      
      reportCall.setDate(new Date());
      
      report.setReportCall(reportCall);
      
      ReportInvestigation reportInvestigation = 
         new ReportInvestigation();
      
      reportInvestigation.setDate(new Date());
      
      report.setReportInvestigation(reportInvestigation);
      
      report.setId(-1);
      
      return report;
   }

   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.ReportManagerable#saveReport(com.mmsn.reportgen.client.data.Report)
    */
   public void saveReport(Report report)
   {
      if(report.getId() < 0)
      {
         reports.add(report);
         
         reportAddedSender.setReport(report);
         
         reportAddedSender.send();
      }
      else
      {
         reportModifiedSender.setReport(report);
         
         reportModifiedSender.send();
         
         saveAttachments(report);
      }
      
      dataChange();
   }
   
   private void saveAttachments(Report report)
   {
      AttachmentList attachmentList = report.getAttachments();
      
      for(Attachment attachment : attachmentList.getAddedAttachments())
      {
         AttachmentAddedSender attachmentAddedSender = 
            new AttachmentAddedSender(serviceLocations);
         
         attachmentAddedSender.setReport(report);
         attachmentAddedSender.setAttachment(attachment);
         
         attachmentAddedSender.send();
      }
      
      for(Attachment attachment : attachmentList.getDeletedAttachments())
      {
         AttachmentDeleter attachmentDeleterSender = 
            new AttachmentDeleter(serviceLocations);
         
         attachmentDeleterSender.setAttachment(attachment);
         
         attachmentDeleterSender.send();
      }
      
      for(Attachment attachment : attachmentList.getModifiedAttachments())
      {
         AttachmentModifiedSender attachmentModifiedSender = 
            new AttachmentModifiedSender(serviceLocations);
         
         attachmentModifiedSender.setAttachment(attachment);
         
         attachmentModifiedSender.send();
      }
      
      attachmentList.saved();
   }
   
   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.ReportManagerable#removeReport(com.mmsn.reportgen.client.data.Report)
    */
   public void removeReport(Report report)
   {
      reports.remove(report);
      
      reportDeleter.setReport(report);
      
      reportDeleter.send();
      
      dataChange();
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void dataChange()
   {
      for(DataChangeListener dataChangeListener : dataChangeListeners)
      {
         dataChangeListener.onDataChange();
      }
   }
}
