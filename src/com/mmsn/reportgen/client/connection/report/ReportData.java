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
   
   //************************ Live Animals *************************
   
   public final native boolean getLiveAnimalsIsConSick()
   /*-{
      return this.is_con_sick;
   }-*/;
   public final native boolean getLiveAnimalsIsConInjured()
   /*-{
      return this.is_con_injured;
   }-*/;
   public final native boolean getLiveAnimalsIsConOutOfHabitat()
   /*-{
      return this.is_con_out_of_habitat;
   }-*/;
   public final native boolean getLiveAnimalsIsConDeemedReleasable()
   /*-{
      return this.is_con_deemed_releasable;
   }-*/;
   public final native boolean getLiveAnimalsIsConAbandoned()
   /*-{
      return this.is_con_abandoned;
   }-*/;
   public final native boolean getLiveAnimalsIsConInaccessible()
   /*-{
      return this.is_con_inaccessible;
   }-*/;
   public final native boolean getLiveAnimalsIsConLocationHazardToAnimal()
   /*-{
      return this.is_con_location_hazard_to_animal;
   }-*/;
   public final native boolean getLiveAnimalsIsConLocationHazardToHumans()
   /*-{
      return this.is_con_location_hazard_to_humans;
   }-*/;
   public final native boolean getLiveAnimalsIsConUnknown()
   /*-{
      return this.is_con_unknown;
   }-*/;
   public final native boolean getLiveAnimalsIsConOther()
   /*-{
      return this.is_con_other;
   }-*/;
   public final native boolean getLiveAnimalsIsActionLeftAtSite()
   /*-{
      return this.is_action_left_at_site;
   }-*/;
   public final native boolean getLiveAnimalsIsActionImmediateReleaseAtSite()
   /*-{
      return this.is_action_immediate_release_at_site;
   }-*/;
   public final native boolean getLiveAnimalsIsActionRelocated()
   /*-{
      return this.is_action_relocated;
   }-*/;
   public final native boolean getLiveAnimalsIsActionDiedAtSite()
   /*-{
      return this.is_action_died_at_site;
   }-*/;
   public final native boolean getLiveAnimalsIsActionDiedDuringTransport()
   /*-{
      return this.is_action_died_during_transport;
   }-*/;
   public final native boolean getLiveAnimalsIsActionEuthanizedAtSite()
   /*-{
      return this.is_action_euthanized_at_site;
   }-*/;
   public final native boolean getLiveAnimalsIsActionEuthanizedDuringTransport()
   /*-{
      return this.is_action_euthanized_during_transport;
   }-*/;
   public final native boolean getLiveAnimalsIsActionTransferredToRehab()
   /*-{
      return this.is_action_transferred_to_rehab;
   }-*/;
   public final native boolean getLiveAnimalsIsActionOther()
   /*-{
      return this.is_action_other;
   }-*/;

   public final native String getLiveAnimalsRelocatedLocation()
   /*-{
      return this.relocated_location;
   }-*/;
   
   //************************ Human Interaction Sections *************************
   
   public final native JavaScriptObject getHumanInteractionSections()
   /*-{
      return this.report_human_interaction_sections;
   }-*/;
   
   //************************ Attachments *************************

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
