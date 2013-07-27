package com.mmsn.reportgen.client.connection.report;

import com.finfrock.client.Sender;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.report.Report;

public class ReportModifiedSender extends Sender
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Report report;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public ReportModifiedSender(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getReportModifiedAddress());
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
      return "json=" + report.getJson().toString();
   }
}
