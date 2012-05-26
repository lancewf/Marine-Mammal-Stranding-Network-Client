package com.mmsn.reportgen.client.connection.volunteer;

import com.finfrock.client.SenderAndReceiver;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;

public class VolunteerAddedSender extends SenderAndReceiver
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Volunteer volunteer;
   
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
         volunteer.setId(Integer.parseInt(reponse));
      }
   }

}
