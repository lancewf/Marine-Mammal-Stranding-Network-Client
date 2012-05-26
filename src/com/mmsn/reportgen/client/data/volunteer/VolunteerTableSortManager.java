package com.mmsn.reportgen.client.data.volunteer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.finfrock.client.DataChangeListener;

public class VolunteerTableSortManager
{
   // --------------------------------------------------------------------------
   // Public class Data
   // --------------------------------------------------------------------------
   
   public static final int NAME = 0;
   public static final int TIME_AVAILABITY = 1;
   public static final int ISLAND = 2;
   public static final int VEHICLE = 3;
   public static final int HOURS_INDEX = 4;
   public static final int MILES_INDEX = 5;

   // --------------------------------------------------------------------------
   // Private Instance Data
   // --------------------------------------------------------------------------
   
   private VolunteerManagerable volunteerManager;
   private List<DataChangeListener> dataChangeListeners = 
      new ArrayList<DataChangeListener>();
   private int sortBy = NAME;
   private boolean isReversed = false;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public VolunteerTableSortManager(VolunteerManagerable volunteerManager)
   {
      this.volunteerManager = volunteerManager;
   }

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public List<Volunteer> getVolunteers()
   {
      List<Volunteer> volunteers = volunteerManager.getVolunteers();
      
      if (sortBy == NAME)
      {
         volunteers =  sortByName(volunteers);
      }
      else if (sortBy == TIME_AVAILABITY)
      {
         volunteers =  sortByTimeAvailabity( volunteers);
      }
      else if (sortBy == ISLAND)
      {
         volunteers =  sortByIsland(volunteers);
      }
      else if (sortBy == VEHICLE)
      {
         volunteers =  sortByVehicle(volunteers);
      }
      else if (sortBy == MILES_INDEX)
      {
         volunteers =  sortByMiles(volunteers);
      }
      else if (sortBy == HOURS_INDEX)
      {
         volunteers =  sortByHours(volunteers);
      }

      if (isReversed)
      {
         Collections.reverse(volunteers);
      }
      
      return volunteers;
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

   public void addDataChangeListener(DataChangeListener dataChangeListener)
   {
      dataChangeListeners.add(dataChangeListener);
   }
   
   public void removeDataChangeListener(DataChangeListener dataChangeListener)
   {
      dataChangeListeners.remove(dataChangeListener);
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private List<Volunteer> sortByHours(List<Volunteer> volunteers)
   {
      Collections.sort(volunteers, new Comparator<Volunteer>()
      {
         @Override
         public int compare(Volunteer volunteer1, Volunteer volunteer2)
         {
            double hours1 = volunteerManager.getTotalHours(volunteer1);
            double hours2 = volunteerManager.getTotalHours(volunteer2);
            
            return ((int)(hours2 * 100)) - ((int)(hours1 * 100));
         }
      });

      return volunteers;
   }

   private List<Volunteer> sortByMiles(List<Volunteer> volunteers)
   {
      Collections.sort(volunteers, new Comparator<Volunteer>()
      {
         @Override
         public int compare(Volunteer volunteer1, Volunteer volunteer2)
         {
            int miles1 = volunteerManager.getMiles(volunteer1);
            int miles2 = volunteerManager.getMiles(volunteer2);
            
            return ((int)(miles2 * 100)) - ((int)(miles1 * 100));
         }
      });

      return volunteers;
   }
   
   private List<Volunteer> sortByVehicle(List<Volunteer> volunteers)
   {
      Collections.sort(volunteers, new Comparator<Volunteer>()
      {
         @Override
         public int compare(Volunteer volunteer1, Volunteer volunteer2)
         {
            return volunteer1.getVehicle().compareToIgnoreCase(volunteer2
               .getVehicle());
         }
      });
      
      return volunteers;
   }

   private List<Volunteer> sortByIsland(List<Volunteer> volunteers)
   {
      Collections.sort(volunteers, new Comparator<Volunteer>()
      {
         @Override
         public int compare(Volunteer volunteer1, Volunteer volunteer2)
         {
            return volunteer1.getIsland().compareToIgnoreCase(volunteer2
               .getIsland());
         }
      });

      return volunteers;
   }

   private List<Volunteer> sortByTimeAvailabity(List<Volunteer> volunteers)
   {
      Collections.sort(volunteers, new Comparator<Volunteer>()
      {
         @Override
         public int compare(Volunteer volunteer1, Volunteer volunteer2)
         {
            AvailabityManager availabityManager = new AvailabityManager();
            Availablity availablity1 = volunteer1.getAvailablity();
            Availablity availablity2 = volunteer2.getAvailablity();

            return availabityManager.compareAvailabity(availablity1, availablity2);
         }
      });

      return volunteers;
   }

   private List<Volunteer> sortByName(List<Volunteer> volunteers)
   {
      Collections.sort(volunteers, new Comparator<Volunteer>()
      {
         @Override
         public int compare(Volunteer volunteer1, Volunteer volunteer2)
         {
            return volunteer1.getLastName().compareToIgnoreCase(volunteer2
               .getLastName());
         }
      });

      return volunteers;
   }
   
   private void dataChanged()
   {
      for (DataChangeListener dataChangeListener : dataChangeListeners)
      {
         dataChangeListener.onDataChange();
      }
   }
}
