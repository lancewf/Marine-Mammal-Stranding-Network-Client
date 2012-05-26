package com.mmsn.reportgen.client.connection.volunteer;

import java.util.ArrayList;
import java.util.List;

import com.finfrock.client.Retriever;
import com.google.gwt.core.client.JsArray;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.volunteer.Availablity;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;

public class VolunteerRetriever extends Retriever<List<Volunteer>>
{
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerRetriever(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getVolunteerRetrieverAddress());
   }
   
   // --------------------------------------------------------------------------
   // Retriever Members
   // --------------------------------------------------------------------------
   
   @Override
   protected List<Volunteer> parseText(String rawText)
   {
      JsArray<VolunteerData> volunteerDatas = asArrayOfVolunteerData(rawText);

      List<Volunteer> volunteers = new ArrayList<Volunteer>();
      for(int index = 0; index < volunteerDatas.length(); index++)
      {
         VolunteerData volunteerData = volunteerDatas.get(index);
         
         Volunteer volunteer = createVolunteer(volunteerData);
         
         volunteers.add(volunteer);
      }
      
      return volunteers;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private Volunteer createVolunteer(VolunteerData volunteerData)
   {
      Volunteer volunteer = new Volunteer();
      
      volunteer.setId(volunteerData.getId());
      volunteer.setFirstName(volunteerData.getFirstName());
      volunteer.setLastName(volunteerData.getLastName());
      volunteer.setCity(volunteerData.getCity());
      volunteer.setState(volunteerData.getState());
      volunteer.setZip(volunteerData.getZip());
      volunteer.setStreetAddress(volunteerData.getStreetAddress());
      volunteer.setVehicle(volunteerData.getVehicle());
      volunteer.setIsland(volunteerData.getIsland());
      volunteer.setComments(volunteerData.getComments());
      volunteer.setPhoneNumber(volunteerData.getPhoneNumber());
      volunteer.setEmail(volunteerData.getEmail());
      volunteer.setTraining(volunteerData.getTraining());
      
      Availablity availablity = new Availablity();
      
      availablity.setSundayAnyTime(volunteerData.getSundayAnyTime());
      availablity.setMondayAnyTime(volunteerData.getMondayAnyTime());
      availablity.setTuesdayAnyTime(volunteerData.getTuesdayAnyTime());
      availablity.setWednesdayAnyTime(volunteerData.getWednesdayAnyTime());
      availablity.setThursdayAnyTime(volunteerData.getThursdayAnyTime());
      availablity.setFridayAnyTime(volunteerData.getFridayAnyTime());
      availablity.setSaturdayAnyTime(volunteerData.getSaturdayAnyTime());
      
      availablity.setSundayNoTime(volunteerData.getSundayNoTime());
      availablity.setMondayNoTime(volunteerData.getMondayNoTime());
      availablity.setTuesdayNoTime(volunteerData.getTuesdayNoTime());
      availablity.setWednesdayNoTime(volunteerData.getWednesdayNoTime());
      availablity.setThursdayNoTime(volunteerData.getThursdayNoTime());
      availablity.setFridayNoTime(volunteerData.getFridayNoTime());
      availablity.setSaturdayNoTime(volunteerData.getSaturdayNoTime());
      
      availablity.setSundayFromHour(volunteerData.getSundayFromHour());
      availablity.setMondayFromHour(volunteerData.getMondayFromHour());
      availablity.setTuesdayFromHour(volunteerData.getTuesdayFromHour());
      availablity.setWednesdayFromHour(volunteerData.getWednesdayFromHour());
      availablity.setThursdayFromHour(volunteerData.getThursdayFromHour());
      availablity.setFridayFromHour(volunteerData.getFridayFromHour());
      availablity.setSaturdayFromHour(volunteerData.getSaturdayFromHour());
      
      availablity.setSundayToHour(volunteerData.getSundayToHour());
      availablity.setMondayToHour(volunteerData.getMondayToHour());
      availablity.setTuesdayToHour(volunteerData.getTuesdayToHour());
      availablity.setWednesdayToHour(volunteerData.getWednesdayToHour());
      availablity.setThursdayToHour(volunteerData.getThursdayToHour());
      availablity.setFridayToHour(volunteerData.getFridayToHour());
      availablity.setSaturdayToHour(volunteerData.getSaturdayToHour());
      
      volunteer.setAvailablity(availablity);
      
      return volunteer;
   }

   private final native JsArray<VolunteerData> asArrayOfVolunteerData(String json) 
   /*-{
      return eval(json);
   }-*/;
}
