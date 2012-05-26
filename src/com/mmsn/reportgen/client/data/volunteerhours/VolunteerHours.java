package com.mmsn.reportgen.client.data.volunteerhours;

import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class VolunteerHours
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private int id;
   
   private double totalHours;

   private int mileage;

   private String comments;
   
   private int dayOfMonth;
   
   private int month;
   
   private int year;

   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public VolunteerHours()
   {
      
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public JSONValue getJson()
   {
      JSONObject request = new JSONObject();
    
      request.put("id", new JSONNumber(getId()));
      request.put("total_hours", new JSONNumber(getTotalHours()));
      request.put("mileage", new JSONNumber(getMileage()));
      request.put("comments", new JSONString(getComments()));
      request.put("dayofmonth", new JSONNumber(getDayOfMonth()));
      request.put("month", new JSONNumber(getMonth()));
      request.put("year", new JSONNumber(getYear()));
      
      return request;
   }
   
   public int getMileage()
   {
      return mileage;
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public int getDayOfMonth()
   {
      return dayOfMonth;
   }

   public void setDayOfMonth(int dayOfMonth)
   {
      this.dayOfMonth = dayOfMonth;
   }

   public int getMonth()
   {
      return month;
   }

   public void setMonth(int month)
   {
      this.month = month;
   }

   public int getYear()
   {
      return year;
   }

   public void setYear(int year)
   {
      this.year = year;
   }

   public void setMileage(int mileage)
   {
      this.mileage = mileage;
   }

   public String getComments()
   {
      return comments;
   }

   public void setComments(String comments)
   {
      this.comments = comments;
   }

   public void setTotalHours(double totalHours)
   {
      this.totalHours = totalHours;
   }

   public double getTotalHours()
   {
      return totalHours;
   }

}
