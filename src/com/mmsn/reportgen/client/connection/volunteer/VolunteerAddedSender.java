package com.mmsn.reportgen.client.connection.volunteer;

import com.finfrock.client.SenderAndReceiver;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteer.VolunteerManager;

public class VolunteerAddedSender extends SenderAndReceiver
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Volunteer volunteer;
   private VolunteerManager volunteerManager;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerAddedSender(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getVolunteerCreateSenderAddress());
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setVolunteerManager(VolunteerManager volunteerManager)
   {
     this.volunteerManager = volunteerManager;
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
      return "json=" + volunteer.getJson().toString();
   }

   @Override
   protected void reponse(String reponse)
   {
      if(volunteer.getId() < 0)
      {
         int newId = Integer.parseInt(reponse);
         volunteerManager.setVolunteerId(volunteer, newId);
      }
   }

}
