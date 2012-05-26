package com.mmsn.reportgen.client.data.volunteer;

import java.util.List;

import com.finfrock.client.DataChangeListener;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursManager;

public interface VolunteerManagerable
{

   VolunteerMonthlyHoursManager getVolunteerMonthlyHoursManager(Volunteer volunteer);

   List<Volunteer> getVolunteers();

   void addDataChangeListener(DataChangeListener dataChangeListener);

   void removeDataChangeListener(DataChangeListener dataChangeListener);
   
   void saveVolunteer(Volunteer volunteer);

   Volunteer createNewVolunteer();

   void removeVolunteer(Volunteer volunteer);

   Volunteer getVolunteer(int volunteerId);

   int getMiles(Volunteer volunteer);

   double getTotalHours(Volunteer volunteer);

   boolean isAvailableNow(Volunteer volunteer);

}