package com.mmsn.reportgen.client.data.volunteer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.finfrock.client.DataChangeListener;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.connection.volunteer.VolunteerAddedSender;
import com.mmsn.reportgen.client.connection.volunteer.VolunteerDeleter;
import com.mmsn.reportgen.client.connection.volunteer.VolunteerModifiedSender;
import com.mmsn.reportgen.client.connection.volunteerhours.VolunteerHoursAddedSender;
import com.mmsn.reportgen.client.connection.volunteerhours.VolunteerHoursDeleter;
import com.mmsn.reportgen.client.connection.volunteerhours.VolunteerHoursModifiedSender;
import com.mmsn.reportgen.client.connection.volunteerhours.VolunteerMonthlyHoursRetriever;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursManager;

public class VolunteerManager implements VolunteerManagerable
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private List<Volunteer> volunteers;
   private List<DataChangeListener> dataChangeListeners = 
      new ArrayList<DataChangeListener>();
   private VolunteerModifiedSender volunteerModifiedSender;
   private VolunteerDeleter volunteerDeleter;
   private ServiceLocations serviceLocations;
   private VolunteerAddedSender volunteerAddedSender;
   private HashMap<Volunteer, VolunteerMonthlyHoursManager> volunteerMonthlyHoursManagerCache = 
      new HashMap<Volunteer, VolunteerMonthlyHoursManager>();
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public VolunteerManager(List<Volunteer> volunteers, 
                           VolunteerModifiedSender volunteerModifiedSender,
                           VolunteerAddedSender volunteerAddedSender,
                           VolunteerDeleter volunteerDeleter, 
                           ServiceLocations serviceLocations)
   {
      this.volunteers = volunteers;
      this.volunteerAddedSender = volunteerAddedSender;
      this.volunteerModifiedSender = volunteerModifiedSender;
      this.volunteerDeleter = volunteerDeleter;
      this.serviceLocations = serviceLocations;
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable#getVolunteerMonthlyHoursManager(com.mmsn.reportgen.client.data.volunteer.Volunteer)
    */
   public VolunteerMonthlyHoursManager getVolunteerMonthlyHoursManager(
                                                            Volunteer volunteer)
   {
      VolunteerMonthlyHoursManager volunteerMonthlyHoursManager = 
         volunteerMonthlyHoursManagerCache.get(volunteer);
      
      if(volunteerMonthlyHoursManager == null)
      {
         volunteerMonthlyHoursManager = createVolunteerMonthlyHoursManager(volunteer);
         
         volunteerMonthlyHoursManagerCache.put(volunteer, volunteerMonthlyHoursManager);
      }

      return volunteerMonthlyHoursManager;
   }
   
   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable#getVolunteers()
    */
   public List<Volunteer> getVolunteers()
   {
      return volunteers;
   }

   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable#addDataChangeListener(com.finfrock.client.DataChangeListener)
    */
   public void addDataChangeListener(
                                   DataChangeListener dataChangeListener)
   {
      dataChangeListeners.add(dataChangeListener);
   }
   
   @Override
   public void removeDataChangeListener(DataChangeListener dataChangeListener)
   {
      dataChangeListeners.remove(dataChangeListener);
   }
   
   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable#saveVolunteer(com.mmsn.reportgen.client.data.volunteer.Volunteer)
    */
   public void saveVolunteer(Volunteer volunteer)
   {
      if(volunteer.getId() < 0)
      {
         volunteers.add(volunteer);
         
         volunteerAddedSender.setVolunteer(volunteer);
         
         volunteerAddedSender.send();  
      }
      else
      {
         volunteerModifiedSender.setVolunteer(volunteer);
         
         volunteerModifiedSender.send();  
      }
      
      dataChange();
   }
   
   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable#createNewVolunteer()
    */
   public Volunteer createNewVolunteer()
   {
      Volunteer volunteer = new Volunteer();
      
      Availablity availablity = new Availablity();
      volunteer.setAvailablity(availablity);
      
      volunteer.setId(-1);
      
      return volunteer;
   }

   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable#removeVolunteer(com.mmsn.reportgen.client.data.volunteer.Volunteer)
    */
   public void removeVolunteer(Volunteer volunteer)
   {
      volunteers.remove(volunteer);
      
      volunteerDeleter.setVolunteer(volunteer);
      
      volunteerDeleter.send();
      
      dataChange();
   }
   
   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable#getVolunteer(int)
    */
   public Volunteer getVolunteer(int volunteerId)
   {
      Volunteer foundVolunteer = null;
      
      for(Volunteer volunteer : volunteers)
      {
         if(volunteer.getId() == volunteerId)
         {
            foundVolunteer = volunteer;
         }
      }
      
      return foundVolunteer;
   }
   
   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable#getMiles(com.mmsn.reportgen.client.data.volunteer.Volunteer)
    */
   public int getMiles(Volunteer volunteer)
   {
      VolunteerMonthlyHoursManager volunteerMonthlyHoursManager = 
         getVolunteerMonthlyHoursManager(volunteer);
      
      return volunteerMonthlyHoursManager.getTotalMiles();
   }

   /* (non-Javadoc)
    * @see com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable#getTotalHours(com.mmsn.reportgen.client.data.volunteer.Volunteer)
    */
   public double getTotalHours(Volunteer volunteer)
   {
      VolunteerMonthlyHoursManager volunteerMonthlyHoursManager = 
         getVolunteerMonthlyHoursManager(volunteer);
      
      return volunteerMonthlyHoursManager.getTotalHours();
   }
   
   @Override
   public boolean isAvailableNow(Volunteer volunteer)
   {
      Availablity availablity = volunteer.getAvailablity();
      
      return AvailabityManager.isAvailableNow(availablity);
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private VolunteerMonthlyHoursManager createVolunteerMonthlyHoursManager(
                                                            Volunteer volunteer)
   {
      VolunteerMonthlyHoursRetriever volunteerMonthlyHoursRetriever = 
         new VolunteerMonthlyHoursRetriever(
         serviceLocations);

      VolunteerHoursAddedSender volunteerHoursAddedSender = 
         new VolunteerHoursAddedSender(
         serviceLocations);

      VolunteerHoursDeleter volunteerHoursDeleter = new VolunteerHoursDeleter(
         serviceLocations);

      VolunteerHoursModifiedSender volunteerHoursModifiedSender = 
         new VolunteerHoursModifiedSender(
         serviceLocations);

      VolunteerMonthlyHoursManager volunteerMonthlyHoursManager = 
         new VolunteerMonthlyHoursManager(
         volunteerMonthlyHoursRetriever, volunteerHoursAddedSender,
         volunteerHoursModifiedSender, volunteerHoursDeleter, volunteer);

      return volunteerMonthlyHoursManager;
   }
   
   private void dataChange()
   {
      for(DataChangeListener dataChangeListener : dataChangeListeners)
      {
         dataChangeListener.onDataChange();
      }
   }
}
