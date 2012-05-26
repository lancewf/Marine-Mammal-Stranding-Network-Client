package com.mmsn.reportgen.client.connection.volunteer;

import com.finfrock.client.Sender;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;

public class VolunteerDeleter extends Sender
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Volunteer volunteer;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerDeleter(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getVolunteerDeleterAddress());
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
      String requestData = "";
      
      requestData += "volunteerId=" + volunteer.getId();
      
      return requestData;
   }
}
