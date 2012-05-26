package com.mmsn.reportgen.client.data.report;

import java.util.ArrayList;
import java.util.List;

import com.finfrock.client.DataChangeListener;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;

public class VolunteerReportManager implements ReportManagerable
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private ReportManagerable reportManager;
   private Volunteer volunteer;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public VolunteerReportManager(ReportManagerable reportManager,
         Volunteer volunteer)
   {
      this.reportManager = reportManager;
      this.volunteer = volunteer;
   }

   // --------------------------------------------------------------------------
   // ReportManagerable Members
   // --------------------------------------------------------------------------
   
   @Override
   public void addDataChangeListener(DataChangeListener dataChangeListener)
   {
      reportManager.addDataChangeListener(dataChangeListener);
   }

   @Override
   public Report createNewReport()
   {
      return reportManager.createNewReport();
   }

   @Override
   public List<Report> getReports()
   {
      List<Report> reports = new ArrayList<Report>();
      
      for(Report report : reportManager.getReports())
      {
         if(report.getVolunteer() == volunteer)
         {
            reports.add(report);
         }
      }
      
      return reports;
   }

   @Override
   public void removeReport(Report report)
   {
      reportManager.removeReport(report);
   }

   @Override
   public void saveReport(Report report)
   {
      reportManager.saveReport(report);
   }

}
