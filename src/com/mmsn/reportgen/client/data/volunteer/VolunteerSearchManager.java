package com.mmsn.reportgen.client.data.volunteer;

import java.util.ArrayList;
import java.util.List;

import com.finfrock.client.DataChangeListener;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursManager;

public class VolunteerSearchManager implements VolunteerManagerable
{
   // --------------------------------------------------------------------------
   // Public static Data
   // --------------------------------------------------------------------------

   public static final String ALL_SELECTION = "All";
   public static final String AVAILABILITY_NOW = "Available Now";

   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
  
   private VolunteerManagerable volunteerManager;
   
   private List<DataChangeListener> dataChangeListeners = 
      new ArrayList<DataChangeListener>();

   private String islandSelection = ALL_SELECTION;

   private String availabilitySelection = ALL_SELECTION;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
  
   public VolunteerSearchManager(VolunteerManagerable volunteerManager)
   {
      this.volunteerManager = volunteerManager;
   }
   
   // --------------------------------------------------------------------------
   // VolunteerManagerable Members
   // --------------------------------------------------------------------------
  
   @Override
   public List<Volunteer> getVolunteers()
   {
      List<Volunteer> foundVolunteers = new ArrayList<Volunteer>();
      
      for(Volunteer volunteer : volunteerManager.getVolunteers())
      {
         if (!islandSelection.equalsIgnoreCase(ALL_SELECTION)
               && !islandSelection.equalsIgnoreCase(volunteer.getIsland()))
         {
            continue;
         }
         if (!availabilitySelection.equalsIgnoreCase(ALL_SELECTION)
               && (availabilitySelection.equalsIgnoreCase(AVAILABILITY_NOW) &&
                   !volunteerManager.isAvailableNow(volunteer)))
         {
            continue;
         }
         
         foundVolunteers.add(volunteer);
      }
      
      return foundVolunteers;
   }
   
   @Override
   public void addDataChangeListener(DataChangeListener dataChangeListener)
   {
      volunteerManager.addDataChangeListener(dataChangeListener);
      dataChangeListeners.add(dataChangeListener);
   }

   @Override
   public Volunteer createNewVolunteer()
   {
      return volunteerManager.createNewVolunteer();
   }

   @Override
   public int getMiles(Volunteer volunteer)
   {
      return volunteerManager.getMiles(volunteer);
   }

   @Override
   public double getTotalHours(Volunteer volunteer)
   {
      return volunteerManager.getTotalHours(volunteer);
   }

   @Override
   public Volunteer getVolunteer(int volunteerId)
   {
      return volunteerManager.getVolunteer(volunteerId);
   }

   @Override
   public VolunteerMonthlyHoursManager getVolunteerMonthlyHoursManager(Volunteer volunteer)
   {
      return volunteerManager.getVolunteerMonthlyHoursManager(volunteer);
   }

   @Override
   public void removeVolunteer(Volunteer volunteer)
   {
      volunteerManager.removeVolunteer(volunteer);
   }

   @Override
   public void saveVolunteer(Volunteer volunteer)
   {
      volunteerManager.saveVolunteer(volunteer);
   }
   
   @Override
   public void removeDataChangeListener(DataChangeListener dataChangeListener)
   {
      volunteerManager.removeDataChangeListener(dataChangeListener);
      dataChangeListeners.remove(dataChangeListener);
   }
   
   @Override
   public boolean isAvailableNow(Volunteer volunteer)
   {
      return volunteerManager.isAvailableNow(volunteer);
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
  
   public void setIslandSelection(String islandSelection)
   {
      if(!this.islandSelection.equalsIgnoreCase(islandSelection))
      {
         this.islandSelection = islandSelection;
      
         dataChanged();
      }
   }

   public void setAvailabilitySelection(String availabilitySelection)
   {
      if(!this.availabilitySelection.equalsIgnoreCase(availabilitySelection))
      {
         this.availabilitySelection = availabilitySelection;
      
         dataChanged();
      }
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void dataChanged()
   {
      for(DataChangeListener dataChangeListener : dataChangeListeners)
      {
         dataChangeListener.onDataChange();
      }
   }
}
