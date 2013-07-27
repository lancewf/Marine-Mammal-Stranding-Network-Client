package com.mmsn.reportgen.client.connection.report;

import com.finfrock.client.Returnable;
import com.finfrock.client.SenderAndReceiver;
import com.google.gwt.user.client.Window;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.report.Report;

public class ReportAddedSender extends SenderAndReceiver
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Report report;
   private Returnable<Report> returnable;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public ReportAddedSender(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getReportAddedSenderAddress());
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setReport(Report report)
   {
      this.report = report;
   }
   
   public void addFinishSavingListener(Returnable<Report> returnable)
   {
      this.returnable = returnable;
   }
   
   // --------------------------------------------------------------------------
   // Protected Members
   // --------------------------------------------------------------------------
   
   protected String getData()
   {
      return "json=" + report.getJson().toString();
   }

   @Override
   protected void reponse(String reponse)
   {
      int id = -1;
      boolean summited = true;
      try
      {
         id = Integer.parseInt(reponse);
      }
      catch(Exception ex)
      {
    	 summited = false;
         Window.alert("Error parseing report id");
      }
      
      if(id < 0){
    	 summited = false;
      }
      
      report.setId(id);
      
      returnable.returned(report);
      
      if(summited){
    	  Window.alert("Report Added");
      } else{
    	  Window.alert("Report Failed. Please Edit and Save again");
      }
   }

}
