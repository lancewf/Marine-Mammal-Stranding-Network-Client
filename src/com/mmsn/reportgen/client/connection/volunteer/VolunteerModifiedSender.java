package com.mmsn.reportgen.client.connection.volunteer;

import com.finfrock.client.Sender;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;

public class VolunteerModifiedSender extends Sender
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Volunteer volunteer;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerModifiedSender(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getVolunteerUpdateSenderAddress());
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
}
