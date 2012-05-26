package com.mmsn.reportgen.client.data.blog;

import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

public class Blog
{
   // --------------------------------------------------------------------------
   // Private Instrance Data
   // --------------------------------------------------------------------------
   private int id;
   private String title;
   private String message;
   private int dayOfMonth;
   private int month;
   private int year;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public Blog()
   {
      //
      // Do nothing
      //
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public String getTitle()
   {
      return title;
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }

   public String getMessage()
   {
      return message;
   }

   public void setMessage(String message)
   {
      this.message = message;
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

   public JSONObject getJson()
   {
      JSONObject request = new JSONObject();
      
      request.put("id", new JSONNumber(getId()));
      request.put("message", new JSONString(getMessage()));
      request.put("title", new JSONString(getTitle()));
      request.put("dayofmonth", new JSONNumber(getDayOfMonth()));
      request.put("month", new JSONNumber(getMonth()));
      request.put("year", new JSONNumber(getYear()));
      
      return request;
   }
}
