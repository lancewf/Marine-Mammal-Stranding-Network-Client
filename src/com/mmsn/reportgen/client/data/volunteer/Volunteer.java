package com.mmsn.reportgen.client.data.volunteer;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerHours;

public class Volunteer
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private int id;
   private String firstName;
   private String lastName;
   private String city;
   private String state;
   private String zip;
   private String streetAddress;
   private String vehicle;
   private String island;
   private String comments;
   private String phoneNumber;
   private Availablity availablity;
   private String email;
   private String training;

   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public Volunteer()
   {
      //
      // Do nothing
      //
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public JSONValue getJson()
   {
      JSONObject request = new JSONObject();
      
      request.put("id", new JSONNumber(getId()));
      request.put("first_name", new JSONString(getFirstName()));
      request.put("last_name", new JSONString(getLastName()));
      request.put("city", new JSONString(getCity()));
      request.put("state", new JSONString(getState()));
      request.put("zip", new JSONString(getZip()));
      request.put("streetaddress", new JSONString(getStreetAddress()));
      request.put("vehicle", new JSONString(getVehicle()));
      request.put("island", new JSONString(getIsland()));
      request.put("comments", new JSONString(getComments()));
      request.put("phonenumber", new JSONString(getPhoneNumber()));
      request.put("email", new JSONString(getEmail()));
      request.put("training", new JSONString(getTraining()));
      
      Availablity availablity = getAvailablity();
      
      request.put("sunday_from_hour", new JSONNumber(availablity.getSundayFromHour()));
      request.put("monday_from_hour", new JSONNumber(availablity.getMondayFromHour()));
      request.put("tuesday_from_hour", new JSONNumber(availablity.getTuesdayFromHour()));
      request.put("wednesday_from_hour", new JSONNumber(availablity.getWednesdayFromHour()));
      request.put("thursday_from_hour", new JSONNumber(availablity.getThursdayFromHour()));
      request.put("friday_from_hour", new JSONNumber(availablity.getFridayFromHour()));
      request.put("saturday_from_hour", new JSONNumber(availablity.getSaturdayFromHour()));
      
      request.put("sunday_to_hour", new JSONNumber(availablity.getSundayToHour()));
      request.put("monday_to_hour", new JSONNumber(availablity.getMondayToHour()));
      request.put("tuesday_to_hour", new JSONNumber(availablity.getTuesdayToHour()));
      request.put("wednesday_to_hour", new JSONNumber(availablity.getWednesdayToHour()));
      request.put("thursday_to_hour", new JSONNumber(availablity.getThursdayToHour()));
      request.put("friday_to_hour", new JSONNumber(availablity.getFridayToHour()));
      request.put("saturday_to_hour", new JSONNumber(availablity.getSaturdayToHour()));

      request.put("sunday_any_time", JSONBoolean.getInstance(availablity.isSundayAnyTime()));
      request.put("monday_any_time", JSONBoolean.getInstance(availablity.isMondayAnyTime()));
      request.put("tuesday_any_time", JSONBoolean.getInstance(availablity.isTuesdayAnyTime()));
      request.put("wednesday_any_time", JSONBoolean.getInstance(availablity.isWednesdayAnyTime()));
      request.put("thursday_any_time", JSONBoolean.getInstance(availablity.isThursdayAnyTime()));
      request.put("friday_any_time", JSONBoolean.getInstance(availablity.isFridayAnyTime()));
      request.put("saturday_any_time", JSONBoolean.getInstance(availablity.isSaturdayAnyTime()));
      
      request.put("sunday_no_time", JSONBoolean.getInstance(availablity.isSundayNoTime()));
      request.put("monday_no_time", JSONBoolean.getInstance(availablity.isTuesdayNoTime()));
      request.put("tuesday_no_time", JSONBoolean.getInstance(availablity.isTuesdayNoTime()));
      request.put("wednesday_no_time", JSONBoolean.getInstance(availablity.isWednesdayNoTime()));
      request.put("thursday_no_time", JSONBoolean.getInstance(availablity.isThursdayNoTime()));
      request.put("friday_no_time", JSONBoolean.getInstance(availablity.isFridayNoTime()));
      request.put("saturday_no_time", JSONBoolean.getInstance(availablity.isSaturdayNoTime()));

      return request;
   }
   
   public Availablity getAvailablity()
   {
      return availablity;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getTraining()
   {
      return training;
   }

   public void setTraining(String training)
   {
      this.training = training;
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public void setAvailablity(Availablity availablity)
   {
      this.availablity = availablity;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public String getFullName()
   {
      return firstName + " " + lastName;
   }

   public String getCity()
   {
      return city;
   }

   public void setCity(String city)
   {
      this.city = city;
   }

   public String getState()
   {
      return state;
   }

   public void setState(String state)
   {
      this.state = state;
   }

   public String getZip()
   {
      return zip;
   }

   public void setZip(String zip)
   {
      this.zip = zip;
   }

   public String getStreetAddress()
   {
      return streetAddress;
   }

   public void setStreetAddress(String streetAddress)
   {
      this.streetAddress = streetAddress;
   }

   public String getVehicle()
   {
      return vehicle;
   }

   public void setVehicle(String vehicle)
   {
      this.vehicle = vehicle;
   }

   public String getIsland()
   {
      return island;
   }

   public void setIsland(String island)
   {
      this.island = island;
   }

   public String getComments()
   {
      return comments;
   }

   public void setComments(String comments)
   {
      this.comments = comments;
   }

   public String getPhoneNumber()
   {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }

   public List<VolunteerHours> getVolunteerHours(int day, int month, int year)
   {
      return new ArrayList<VolunteerHours>();
   }

}
