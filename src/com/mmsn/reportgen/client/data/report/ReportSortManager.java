package com.mmsn.reportgen.client.data.report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.finfrock.client.DataChangeListener;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;

public class ReportSortManager
{
   // --------------------------------------------------------------------------
   // Public class Data
   // --------------------------------------------------------------------------
   
   public static final int DATE_TIME = 1;
   public static final int LOCATION = 2;
   public static final int WRITTEN_BY = 3;
   public static final int SPECIES = 4;
   
   // --------------------------------------------------------------------------
   // Private Instance Data
   // --------------------------------------------------------------------------
   
   private ReportManagerable reportManager;
   private List<DataChangeListener> dataChangeListeners = 
      new ArrayList<DataChangeListener>();
   private int sortBy = DATE_TIME;
   private boolean isReversed = false;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public ReportSortManager(ReportManagerable reportManager)
   {
      this.reportManager = reportManager;
   }

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void addDataChangeListener(DataChangeListener dataChangeListener)
   {
      dataChangeListeners.add(dataChangeListener);
   }
   
   public void removeDataChangeListener(DataChangeListener dataChangeListener)
   {
      dataChangeListeners.remove(dataChangeListener);
   }

   public void setSortBy(int sortBy)
   {
      if (this.sortBy == sortBy)
      {
         isReversed = !isReversed;
      }
      else
      {
         isReversed = false;
      }

      this.sortBy = sortBy;

      dataChanged();
   }

   public List<Report> getReports()
   {
      List<Report> reports = reportManager.getReports();
      
      if (sortBy == DATE_TIME)
      {
         reports =  sortByDateTime(reports);
      }
      else if (sortBy == LOCATION)
      {
         reports =  sortByLocation(reports);
      }
      else if (sortBy == WRITTEN_BY)
      {
         reports =  sortByWrittenBy(reports);
      }
      else if (sortBy == SPECIES)
      {
         reports =  sortBySpecies(reports);
      }

      if (isReversed)
      {
         Collections.reverse(reports);
      }
      
      return reports;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private List<Report> sortBySpecies(List<Report> reports)
   {
      Collections.sort(reports, new Comparator<Report>()
      {
         @Override
         public int compare(Report report1, Report report2)
         {
            return report1.getReportCall().getSpecies().compareToIgnoreCase(
               report2.getReportCall().getSpecies());
         }
      });
      
      return reports;
   }
   
   private List<Report> sortByWrittenBy(List<Report> reports)
   {
      Collections.sort(reports, new Comparator<Report>()
      {
         @Override
         public int compare(Report report1, Report report2)
         {
            
            return getWrittenByName(report1).compareToIgnoreCase(
               getWrittenByName(report2));
         }
      });
      
      return reports;
   }
   
   private String getWrittenByName(Report report)
   {
      String writtenByName = "";
      Volunteer volunteer = report.getVolunteer();
      
      if(volunteer != null)
      {
         writtenByName = volunteer.getFullName();
      }
      else
      {
         writtenByName = "admin";
      }
      
      return writtenByName;
   }
   
   private List<Report> sortByLocation(List<Report> reports)
   {
      Collections.sort(reports, new Comparator<Report>()
      {
         @Override
         public int compare(Report report1, Report report2)
         {
            return report1.getReportCall().getLocation().compareToIgnoreCase(
               report2.getReportCall().getLocation());
         }
      });
      
      return reports;
   }
   
   private List<Report> sortByDateTime(List<Report> reports)
   {
      Collections.sort(reports, new Comparator<Report>()
      {
         @Override
         public int compare(Report report1, Report report2)
         {
            Date date1 = report1.getReportInvestigation().getDate();
            Date date2 = report2.getReportInvestigation().getDate();
            
            return date2.compareTo(date1);
         }
      });
      
      return reports;
   }
   
   private void dataChanged()
   {
      for (DataChangeListener dataChangeListener : dataChangeListeners)
      {
         dataChangeListener.onDataChange();
      }
   }
}
