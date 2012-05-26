package com.mmsn.reportgen.client.connection.volunteerhours;

import com.finfrock.client.SenderAndReceiver;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerHours;

public class VolunteerHoursAddedSender extends SenderAndReceiver
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private VolunteerHours volunteerHours;
   private Volunteer volunteer;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerHoursAddedSender(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getVolunteerHoursAddedSenderAddress());
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setVolunteerHours(VolunteerHours volunteerHours)
   {
      this.volunteerHours = volunteerHours;
   }
   
   public void setVolunteer(Volunteer volunteer)
   {
      this.volunteer = volunteer;
   }
   
   // --------------------------------------------------------------------------
   // Protected Members
   // --------------------------------------------------------------------------
   
   @Override
   protected String getData()
   {
      String requestData = "";
      
      requestData += "json=" + volunteerHours.getJson().toString() + "&";
      
      requestData += "volunteerId=" + volunteer.getId();
      
      return requestData;
   }

   @Override
   protected void reponse(String reponse)
   {
      if(volunteerHours.getId() < 0)
      {
         volunteerHours.setId(Integer.parseInt(reponse));
      }
   }

}
