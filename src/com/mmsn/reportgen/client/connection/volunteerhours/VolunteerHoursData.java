package com.mmsn.reportgen.client.connection.volunteerhours;

import com.google.gwt.core.client.JavaScriptObject;

public class VolunteerHoursData extends JavaScriptObject
{
   protected VolunteerHoursData() 
   {
      
   }
   
   public final native int getId()
   /*-{
      return this.id;
   }-*/;
   
   public final native double getTotalHours()
   /*-{
      return this.total_hours;
   }-*/;
   
   public final native int getMileage()
   /*-{
      return this.mileage;
   }-*/;
   
   public final native String getComments()
   /*-{
      return this.comments;
   }-*/;
   
   public final native int getDayOfMonth()
   /*-{
      return this.dayofmonth;
   }-*/;
   
   public final native int getMonth()
   /*-{
      return this.month;
   }-*/;
   
   public final native int getYear()
   /*-{
      return this.year;
   }-*/;
}
