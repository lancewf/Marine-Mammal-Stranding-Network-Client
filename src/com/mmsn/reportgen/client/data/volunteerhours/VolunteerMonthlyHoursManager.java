package com.mmsn.reportgen.client.data.volunteerhours;

import java.util.ArrayList;
import java.util.List;

import com.finfrock.client.DataChangeListener;
import com.finfrock.client.Loadable;
import com.finfrock.client.Returnable;
import com.mmsn.reportgen.client.connection.volunteerhours.VolunteerHoursAddedSender;
import com.mmsn.reportgen.client.connection.volunteerhours.VolunteerHoursDeleter;
import com.mmsn.reportgen.client.connection.volunteerhours.VolunteerHoursModifiedSender;
import com.mmsn.reportgen.client.connection.volunteerhours.VolunteerMonthlyHoursRetriever;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;

public class VolunteerMonthlyHoursManager
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private List<VolunteerHours> collectionOfVolunteerHours = 
      new ArrayList<VolunteerHours>();
   
   private Volunteer volunteer;
   
   private List<DataChangeListener> dataChangeListeners = 
      new ArrayList<DataChangeListener>();
   
   private VolunteerMonthlyHoursRetriever volunteerMonthlyHoursRetriever;
   private VolunteerHoursAddedSender volunteerHoursAddedSender;
   private VolunteerHoursModifiedSender volunteerHoursModifiedSender;
   private VolunteerHoursDeleter volunteerHoursDeleter;
   private int currentMonth = -1;
   private int currentYear = -1;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public VolunteerMonthlyHoursManager(
                  VolunteerMonthlyHoursRetriever volunteerMonthlyHoursRetriever,
                  VolunteerHoursAddedSender volunteerHoursAddedSender, 
                  VolunteerHoursModifiedSender volunteerHoursModifiedSender,
                  VolunteerHoursDeleter volunteerHoursDeleter, 
                  Volunteer volunteer)
   {
      this.volunteerMonthlyHoursRetriever = volunteerMonthlyHoursRetriever;
      this.volunteerHoursAddedSender = volunteerHoursAddedSender;
      this.volunteerHoursModifiedSender = volunteerHoursModifiedSender;
      this.volunteerHoursDeleter = volunteerHoursDeleter;
      this.volunteer = volunteer;
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void addDataChangeListener(DataChangeListener dataChangeListener)
   {
      dataChangeListeners.add(dataChangeListener);
   }
   
   public Volunteer getVolunteer()
   {
      return volunteer;
   }

   public List<VolunteerHours> getVolunteerHours(int day, int month, int year)
   {
      List<VolunteerHours> foundVolunteerHours = new ArrayList<VolunteerHours>();
      
      for(VolunteerHours volunteerHours : collectionOfVolunteerHours)
      {
         if(volunteerHours.getDayOfMonth() == day && 
               volunteerHours.getMonth() == month && 
               volunteerHours.getYear() == year)
         {
            foundVolunteerHours.add(volunteerHours);
         }
      }

      return foundVolunteerHours;
   }

   public void save(VolunteerHours volunteerHours)
   {
      if(volunteerHours.getId() < 0)
      {
         volunteerHoursAddedSender.setVolunteer(volunteer);
         volunteerHoursAddedSender.setVolunteerHours(volunteerHours);
         
         volunteerHoursAddedSender.send();
         
         collectionOfVolunteerHours.add(volunteerHours);
      } else  {
         volunteerHoursModifiedSender.setVolunteerHours(volunteerHours);
      
         volunteerHoursModifiedSender.send();
      }
      
      dataChange();
   }
   
   public void removeVolunteerHours(VolunteerHours volunteerHours)
   {
      collectionOfVolunteerHours.remove(volunteerHours);
      
      volunteerHoursDeleter.setVolunteerHours(volunteerHours);
      
      volunteerHoursDeleter.send();

      dataChange();
   }
   
   public VolunteerHours createNewVolunteerHours()
   {
      VolunteerHours volunteerHours = new VolunteerHours();
      
      volunteerHours.setId(-1);
      
      return volunteerHours;
   }
   
   public void updateMonth(int month, int year)
   {
      if(volunteer.getId() > 0 && !isDateSameAsCurrent(month, year) )
      {
         currentMonth = month;
         currentYear = year;
         
         volunteerMonthlyHoursRetriever.setMonth(month);
         volunteerMonthlyHoursRetriever.setYear(year);
         volunteerMonthlyHoursRetriever.setVolunteer(volunteer);
         
         volunteerMonthlyHoursRetriever.startLoad(new Returnable<Loadable>()
         {
            @Override
            public void returned(Loadable object)
            {
               List<VolunteerHours> volunteerHoursCollection = volunteerMonthlyHoursRetriever
                  .getObject();

               collectionOfVolunteerHours.clear();

               collectionOfVolunteerHours.addAll(volunteerHoursCollection);

               dataChange();
            }
         });
      }
   }

   public double getTotalHours()
   {
      double totalHours = 0.0;
      
      for(VolunteerHours volunteerHours : collectionOfVolunteerHours)
      {
         totalHours += volunteerHours.getTotalHours();
      }
      
      return totalHours;
   }
   
   public int getTotalMiles()
   {
      int totalMiles = 0;
      
      for(VolunteerHours volunteerHours : collectionOfVolunteerHours)
      {
         totalMiles += volunteerHours.getMileage();
      }
      
      return totalMiles;
   }
   
   public int getCurrentYear()
   {
      return currentYear;
   }
   
   public int getCurrentMonth()
   {
      return currentMonth;
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
   
   private boolean isDateSameAsCurrent(int month, int year)
   {
      if(currentMonth == month && currentYear == year)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}
