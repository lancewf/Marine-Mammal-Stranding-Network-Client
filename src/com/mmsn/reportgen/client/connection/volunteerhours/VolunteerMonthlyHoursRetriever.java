package com.mmsn.reportgen.client.connection.volunteerhours;

import java.util.ArrayList;
import java.util.List;

import com.finfrock.client.Retriever;
import com.google.gwt.core.client.JsArray;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerHours;

public class VolunteerMonthlyHoursRetriever extends Retriever<List<VolunteerHours>>
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private int year;
   private int month;
   private Volunteer volunteer;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerMonthlyHoursRetriever(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getVolunteerMonthlyHoursRetrieverAddress());
   }

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public int getYear()
   {
      return year;
   }

   public void setYear(int year)
   {
      this.year = year;
   }

   public int getMonth()
   {
      return month;
   }

   public void setMonth(int month)
   {
      this.month = month;
   }
   
   public void setVolunteer(Volunteer volunteer)
   {
      this.volunteer = volunteer;
   }
   
   // --------------------------------------------------------------------------
   // Protected Members
   // --------------------------------------------------------------------------
   
   @Override
   protected String getRequestData()
   {
      String requestData = "";
      
      requestData += "month=" + month + "&";
      requestData += "year=" + year + "&";
      requestData += "volunteerId=" + volunteer.getId();
      
      return requestData;
   }

   @Override
   protected List<VolunteerHours> parseText(String rawText)
   {
      JsArray<VolunteerHoursData> volunteerHoursDatas = 
         asArrayOfVolunteerHoursData(rawText);
      
      List<VolunteerHours> volunteerHoursCollection = new ArrayList<VolunteerHours>();
      for(int index = 0; index < volunteerHoursDatas.length(); index++)
      {
         VolunteerHoursData volunteerHoursData = volunteerHoursDatas.get(index);
         
         VolunteerHours volunteerHours = createVolunteerHours(volunteerHoursData);
         
         volunteerHoursCollection.add(volunteerHours);
      }
      
      return volunteerHoursCollection;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private VolunteerHours createVolunteerHours(VolunteerHoursData volunteerHoursData)
   {
      VolunteerHours volunteerHours = new VolunteerHours();

      volunteerHours.setId(volunteerHoursData.getId());
      volunteerHours.setDayOfMonth(volunteerHoursData.getDayOfMonth());
      volunteerHours.setMonth(volunteerHoursData.getMonth());
      volunteerHours.setYear(volunteerHoursData.getYear());
      volunteerHours.setMileage(volunteerHoursData.getMileage());
      volunteerHours.setComments(volunteerHoursData.getComments());
      volunteerHours.setTotalHours(volunteerHoursData.getTotalHours());
      
      return volunteerHours;
   }

   private final native JsArray<VolunteerHoursData> asArrayOfVolunteerHoursData(String json) 
   /*-{
      return eval(json);
   }-*/;

}
