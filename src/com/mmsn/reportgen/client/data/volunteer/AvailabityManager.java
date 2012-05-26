package com.mmsn.reportgen.client.data.volunteer;

import com.extjs.gxt.ui.client.util.DateWrapper;

public class AvailabityManager
{

   // --------------------------------------------------------------------------
   // Public Static Members
   // --------------------------------------------------------------------------
   
   public static boolean isAvailableNow(Availablity availablity)
   {
      boolean isAvailableNow = false;
      
      DateWrapper dateWrapper = new DateWrapper();
      
      int dayInWeek = dateWrapper.getDayInWeek();
      int hours = dateWrapper.getHours();

      if(dayInWeek == 0)
      {
         if(availablity.isSundayAnyTime())
         {
            isAvailableNow = true;
         }
         else if(availablity.isSundayNoTime())
         {
            isAvailableNow = false;
         }
         else if(availablity.getSundayFromHour() >= hours &&  
               availablity.getSundayToHour() <= hours)
         {
            isAvailableNow = true;
         }
      }
      if(dayInWeek == 1)
      {
         if(availablity.isMondayAnyTime())
         {
            isAvailableNow = true;
         }
         else if(availablity.isMondayNoTime())
         {
            isAvailableNow = false;
         }
         else if(availablity.getMondayFromHour() >= hours &&  
               availablity.getMondayToHour() <= hours)
         {
            isAvailableNow = true;
         }
      }
      else if(dayInWeek == 2)
      {
         if(availablity.isTuesdayAnyTime())
         {
            isAvailableNow = true;
         }
         else if(availablity.isTuesdayNoTime())
         {
            isAvailableNow = false;
         }
         else if(availablity.getTuesdayFromHour() >= hours &&  
               availablity.getTuesdayToHour() <= hours)
         {
            isAvailableNow = true;
         }
      }
      else if(dayInWeek == 3)
      {
         if(availablity.isWednesdayAnyTime())
         {
            isAvailableNow = true;
         }
         else if(availablity.isWednesdayNoTime())
         {
            isAvailableNow = false;
         }
         else if(availablity.getWednesdayFromHour() >= hours &&  
               availablity.getWednesdayToHour() <= hours)
         {
            isAvailableNow = true;
         }
      }
      else if(dayInWeek == 4)
      {
         if(availablity.isThursdayAnyTime())
         {
            isAvailableNow = true;
         }
         else if(availablity.isThursdayNoTime())
         {
            isAvailableNow = false;
         }
         else if(availablity.getThursdayFromHour() >= hours &&  
               availablity.getThursdayToHour() <= hours)
         {
            isAvailableNow = true;
         }
      }
      else if(dayInWeek == 5)
      {
         if(availablity.isFridayAnyTime())
         {
            isAvailableNow = true;
         }
         else if(availablity.isFridayNoTime())
         {
            isAvailableNow = false;
         }
         else if(availablity.getFridayFromHour() >= hours &&  
               availablity.getFridayToHour() <= hours)
         {
            isAvailableNow = true;
         }
      }
      else if(dayInWeek == 6)
      {
         if(availablity.isSaturdayAnyTime())
         {
            isAvailableNow = true;
         }
         else if(availablity.isSaturdayNoTime())
         {
            isAvailableNow = false;
         }
         else if(availablity.getSaturdayFromHour() >= hours &&  
               availablity.getSaturdayToHour() <= hours)
         {
            isAvailableNow = true;
         }
      }
      
      return isAvailableNow;
   }
   
   public static int compareAvailabity(Availablity availablity1, Availablity availablity2)
   {
      return getAvailabityText(availablity1).compareToIgnoreCase(
         getAvailabityText(availablity2));
   }
   
   public static String getAvailabityText(Availablity availablity)
   {      
      DateWrapper dateWrapper = new DateWrapper();
      
      int dayInWeek = dateWrapper.getDayInWeek();
      
      String text = "";
      
      if(dayInWeek == 0)
      {
         if(availablity.isSundayAnyTime())
         {
            text = "Any Time";
         }
         else if(availablity.isSundayNoTime())
         {
            text = "No Time";
         }
         else
         {
            text = getHourText(availablity.getSundayFromHour()) + " - " + 
               getHourText(availablity.getSundayToHour());
         }
      }
      if(dayInWeek == 1)
      {
         if(availablity.isMondayAnyTime())
         {
            text = "Any Time";
         }
         else if(availablity.isMondayNoTime())
         {
            text = "No Time";
         }
         else
         {
            text = getHourText(availablity.getMondayFromHour()) + " - " + 
               getHourText(availablity.getMondayToHour());
         }
      }
      if(dayInWeek == 2)
      {
         if(availablity.isTuesdayAnyTime())
         {
            text = "Any Time";
         }
         else if(availablity.isTuesdayNoTime())
         {
            text = "No Time";
         }
         else
         {
            text = getHourText(availablity.getTuesdayFromHour()) + " - " + 
               getHourText(availablity.getTuesdayToHour());
         }
      }
      if(dayInWeek == 3)
      {
         if(availablity.isWednesdayAnyTime())
         {
            text = "Any Time";
         }
         else if(availablity.isWednesdayNoTime())
         {
            text = "No Time";
         }
         else
         {
            text = getHourText(availablity.getWednesdayFromHour()) + " - " + 
               getHourText(availablity.getWednesdayToHour());
         }
      }
      if(dayInWeek == 4)
      {
         if(availablity.isThursdayAnyTime())
         {
            text = "Any Time";
         }
         else if(availablity.isThursdayNoTime())
         {
            text = "No Time";
         }
         else
         {
            text = getHourText(availablity.getThursdayFromHour()) + " - " + 
               getHourText(availablity.getThursdayToHour());
         }
      }
      if(dayInWeek == 5)
      {
         if(availablity.isFridayAnyTime())
         {
            text = "Any Time";
         }
         else if(availablity.isFridayNoTime())
         {
            text = "No Time";
         }
         else
         {
            text = getHourText(availablity.getFridayFromHour()) + " - " + 
               getHourText(availablity.getFridayToHour());
         }
      }
      if(dayInWeek == 6)
      {
         if(availablity.isSaturdayAnyTime())
         {
            text = "Any Time";
         }
         else if(availablity.isSaturdayNoTime())
         {
            text = "No Time";
         }
         else
         {
            text = getHourText(availablity.getSaturdayFromHour()) + " - " + 
               getHourText(availablity.getSaturdayToHour());
         }
      }
      
      return text;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private static String getHourText(int hour24)
   {
      String text = "";
      
      if(hour24 == 0)
      {
         text = "12 am";
      }
      else if(hour24 > 0 && hour24 < 12)
      {
         text = hour24 + " am";
      }
      else if(hour24 == 12)
      {
         text = "12 pm";
      }
      else if(hour24 > 12)
      {
         int hour12 = hour24 - 12;
         
         text = hour12 + " pm";
      }
      
      return text;
   }
}
