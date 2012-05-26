package com.mmsn.reportgen.client.data.volunteerhours;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.finfrock.client.DataChangeListener;

public class VolunteerMonthlyHoursSortManager
{
   // --------------------------------------------------------------------------
   // Private Class Data
   // --------------------------------------------------------------------------
  
   public static final int TOTAL_TIME = 1;

   // --------------------------------------------------------------------------
   // Private Instance Data
   // --------------------------------------------------------------------------
  
   private VolunteerMonthlyHoursManager volunteerHoursManager;
   private int sortBy = TOTAL_TIME;
   private boolean isReversed = false;
   private List<DataChangeListener> dataChangeListeners = 
      new ArrayList<DataChangeListener>();
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerMonthlyHoursSortManager(
         VolunteerMonthlyHoursManager volunteerHoursManager)
   {
      this.volunteerHoursManager = volunteerHoursManager;
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

   public List<VolunteerHours> getVolunteerHours(
      int dayOfMonth, int month, int year)
   {
      List<VolunteerHours> volunteerHours = 
         volunteerHoursManager.getVolunteerHours(dayOfMonth, month, year);
      
      if (sortBy == TOTAL_TIME)
      {
         volunteerHours =  sortByTotalTime(volunteerHours);
      }

      if (isReversed)
      {
         Collections.reverse(volunteerHours);
      }
      
      return volunteerHours;
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

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private List<VolunteerHours> sortByTotalTime(List<VolunteerHours> volunteerHours)
   {
      Collections.sort(volunteerHours, new Comparator<VolunteerHours>()
      {
         @Override
         public int compare(VolunteerHours volunteerHours1, 
                            VolunteerHours volunteerHours2)
         {
            return (int)(100 *volunteerHours1.getTotalHours() - 
                  volunteerHours2.getTotalHours());
         }
      });
      
      return volunteerHours;
   }
   
   private void dataChanged()
   {
      for (DataChangeListener dataChangeListener : dataChangeListeners)
      {
         dataChangeListener.onDataChange();
      }
   }
}
