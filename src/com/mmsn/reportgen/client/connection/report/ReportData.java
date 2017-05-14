package com.mmsn.reportgen.client.connection.report;

import com.google.gwt.core.client.JavaScriptObject;

public class ReportData extends JavaScriptObject
{
   protected ReportData() 
   {
      
   }
   
   public final native int getId()
   /*-{
      return this.id;
   }-*/;
   
   public final native void setId(int id)
   /*-{
      this.id = id;
   }-*/;
   
   public final native int getVolunteerId()
   /*-{
      return this.volunteer_id;
   }-*/;
   
   public final native String getResponder()
   /*-{
      return this.responder;
   }-*/;
   
   public final native int getCallDateMinute()
   /*-{
      return this.call_date_minute;
   }-*/;
   
   public final native int getCallDateHour()
   /*-{
      return this.call_date_hour;
   }-*/;
   
   public final native int getCallDateDayOfMonth()
   /*-{
      return this.call_date_dayofmonth;
   }-*/;
   
   public final native int getCallDateMonth()
   /*-{
      return this.call_date_month;
   }-*/;
   
   public final native int getCallDateYear()
   /*-{
      return this.call_date_year;
   }-*/;
   
   public final native String getCallFrom()
   /*-{
      return this.call_from;
   }-*/;
   
   public final native String getCallerName()
   /*-{
      return this.caller_name;
   }-*/;
   
   public final native String getCallerPhoneNumber()
   /*-{
      return this.caller_phone_number;
   }-*/;
   
   public final native String getCallLocation()
   /*-{
      return this.call_location;
   }-*/;
   
   public final native String getCallSpecies()
   /*-{
      return this.call_species;
   }-*/;
   
   public final native String getWhenFirstSeen()
   /*-{
      return this.when_first_seen;
   }-*/;
   
   public final native String getCallComments()
   /*-{
      return this.call_comments;
   }-*/;
   
   public final native String getCallReferredTo()
   /*-{
      return this.call_referred_to;
   }-*/;
   
   public final native String getCallCondition()
   /*-{
      return this.call_condition;
   }-*/;
   
   public final native String getInvestigatorSupport()
   /*-{
      return this.investigator_support;
   }-*/;
   
   public final native int getInvestigationDateMinute()
   /*-{
      return this.investigation_date_minute;
   }-*/;
   
   public final native int getInvestigationDateHour()
   /*-{
      return this.investigation_date_hour;
   }-*/;
   
   public final native int getInvestigationDateDayOfMonth()
   /*-{
      return this.investigation_date_dayofmonth;
   }-*/;
   
   public final native int getInvestigationDateMonth()
   /*-{
      return this.investigation_date_month;
   }-*/;
   
   public final native int getInvestigationDateYear()
   /*-{
      return this.investigation_date_year;
   }-*/;
   
   public final native String getInvestigationLatLonLocation()
   /*-{
      return this.investigation_lat_lon_location;
   }-*/;
   
   public final native String getInvestigationPhysicalLocation()
   /*-{
      return this.investigation_physical_location;
   }-*/;
   
   public final native String getInvestigationSpecies()
   /*-{
      return this.investigation_species;
   }-*/;
   
   public final native boolean getAnimalNotFound()
   /*-{
      return this.animal_not_found;
   }-*/;
   
   public final native String getInvestigationCondition()
   /*-{
      return this.investigation_condition;
   }-*/;
   
   public final native String getTags()
   /*-{
      return this.tags;
   }-*/;
   
   public final native String getDisposition()
   /*-{
      return this.disposition;
   }-*/;
   
   public final native String getSealPickup()
   /*-{
      return this.seal_pickup;
   }-*/;
   
   public final native String getSex()
   /*-{
      return this.sex;
   }-*/;
   
   public final native double getWeight()
   /*-{
      return this.weight;
   }-*/;
   
   public final native double getStraightLength()
   /*-{
      return this.straight_length;
   }-*/;
   
   public final native double getGirth()
   /*-{
      return this.girth;
   }-*/;
   
   public final native String getInvestigationComments()
   /*-{
      return this.investigation_comments;
   }-*/;
   
   public final native String getPhotosComment()
   /*-{
      return this.photos_comment;
   }-*/;
   
   public final native JavaScriptObject getAttachments()
   /*-{
      return this.attachments;
   }-*/;
   
   public final native boolean getIsPhotoTaken()
   /*-{
      return this.is_photo_taken;
   }-*/;
}
