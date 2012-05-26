package com.mmsn.reportgen.client.connection.volunteerhours;

import com.finfrock.client.Sender;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerHours;

public class VolunteerHoursModifiedSender extends Sender
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private VolunteerHours volunteerHours;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerHoursModifiedSender(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getVolunteerHoursModifiedSenderAddress());
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setVolunteerHours(VolunteerHours volunteerHours)
   {
      this.volunteerHours = volunteerHours;
   }
   
   // --------------------------------------------------------------------------
   // Protected Members
   // --------------------------------------------------------------------------
   
   @Override
   protected String getData()
   {
      String requestData = "";
      
      requestData += "json=" + volunteerHours.getJson().toString();
      
      return requestData;
   }
}
