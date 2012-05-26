package com.mmsn.reportgen.client.connection.report;

import com.finfrock.client.Sender;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.report.Report;

public class ReportDeleter extends Sender
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Report report;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public ReportDeleter(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getReportDeleterAddress());
   }

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setReport(Report report)
   {
      this.report = report;
   }
   
   // --------------------------------------------------------------------------
   // Protected Members
   // --------------------------------------------------------------------------

   @Override
   protected String getData()
   {
      String requestData = "";
      
      requestData += "reportId=" + report.getId();
      
      return requestData;
   }
}
