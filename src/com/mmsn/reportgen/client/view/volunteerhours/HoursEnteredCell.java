package com.mmsn.reportgen.client.view.volunteerhours;

import java.util.List;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerHours;

public class HoursEnteredCell extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private int day;
   private int month;
   private int year;
   private List<VolunteerHours> volunteerHoursCollection;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public HoursEnteredCell(List<VolunteerHours> volunteerHoursCollection, int day, 
                           int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
      
      this.volunteerHoursCollection = volunteerHoursCollection;
 
      addStyleName("HoursEnteredCell");
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
      
      Label label = new Label(day + "");

      add(label);
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      if(volunteerHoursCollection.size() > 0)
      {
         Label label2 = new Label();
         label2.setText(getTotalHours() + " hrs");
         add(label2);
      }
   }

   private double getTotalHours()
   {
      double totalHours = 0.0;
      
      for(VolunteerHours volunteerHours : volunteerHoursCollection)
      {
         totalHours += volunteerHours.getTotalHours();
      }
      
      return totalHours;
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
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

   public List<VolunteerHours> getVolunteerHoursCollection()
   {
      return volunteerHoursCollection;
   }

   public void setVolunteerHoursCollection(
                                  List<VolunteerHours> volunteerHoursCollection)
   {
      this.volunteerHoursCollection = volunteerHoursCollection;
   }

   public void setDay(int day)
   {
      this.day = day;
   }
   
   public int getDay()
   {
      return day;
   }
   
}
