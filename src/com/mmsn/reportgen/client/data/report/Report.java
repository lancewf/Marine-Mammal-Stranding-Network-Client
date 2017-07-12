package com.mmsn.reportgen.client.data.report;

import java.util.Date;
import java.util.List;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.mmsn.reportgen.client.data.attachment.Attachment;
import com.mmsn.reportgen.client.data.attachment.AttachmentList;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;

public class Report
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private int id;
   
   private Volunteer volunteer;
   
   private ReportCall reportCall;

   private ReportLiveAnimals reportLiveAnimals;
   
   private boolean isPhotoTaken;
   
   private ReportInvestigation reportInvestigation;
   
   private ReportHumanInteraction reportHumanInteraction;
   
   private AttachmentList attachmentList = new AttachmentList();
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public Report()
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
      
      DateTimeFormat minuteFormater = DateTimeFormat.getFormat("m");
      DateTimeFormat hourFormater = DateTimeFormat.getFormat("H");
      DateTimeFormat monthFormater = DateTimeFormat.getFormat("M");
      DateTimeFormat dayFormater = DateTimeFormat.getFormat("d");
      DateTimeFormat yearFormater = DateTimeFormat.getFormat("y");
      
      request.put("id", new JSONNumber(getId()));
      
      Volunteer volunteer = getVolunteer();
      
      if(volunteer != null)
      {
         request.put("volunteer_id", new JSONNumber(volunteer.getId()));
      }
      else
      {
         request.put("volunteer_id", new JSONNumber(-1));
      }
      
      ReportCall reportCall = getReportCall();

      request.put("responder", new JSONString(reportCall.getResponder()));
      
      Date callDate = reportCall.getDate();
      
      request.put("call_date_minute", new JSONString(minuteFormater.format(callDate)));
      request.put("call_date_hour", new JSONString(hourFormater.format(callDate)));
      request.put("call_date_dayofmonth", new JSONString(dayFormater.format(callDate)));
      request.put("call_date_month", new JSONString(monthFormater.format(callDate)));
      request.put("call_date_year", new JSONString(yearFormater.format(callDate)));      
      request.put("call_from", new JSONString(reportCall.getCallFrom()));
      request.put("caller_name", new JSONString(reportCall.getCallerName()));
      request.put("caller_phone_number", new JSONString(reportCall.getCallerPhoneNumber()));      
      request.put("call_location", new JSONString(reportCall.getLocation()));      
      request.put("call_species", new JSONString(reportCall.getSpecies()));      
      request.put("when_first_seen", new JSONString(reportCall.getWhenFirstSeen()));
      request.put("call_comments", new JSONString(reportCall.getComments()));
      request.put("call_referred_to", new JSONString(reportCall.getCallReferredTo()));
      request.put("call_condition", new JSONString(reportCall.getCondition()));
      
      ReportInvestigation reportInvestigation = getReportInvestigation();
      
      Date investigationDate = reportInvestigation.getDate();
      
      request.put("investigator_support", new JSONString(reportInvestigation.getInvestigatorSupport()));    
      request.put("investigation_date_minute", new JSONString(minuteFormater.format(investigationDate)));      
      request.put("investigation_date_hour", new JSONString(hourFormater.format(investigationDate)));      
      request.put("investigation_date_dayofmonth", new JSONString(dayFormater.format(investigationDate)));      
      request.put("investigation_date_month", new JSONString(monthFormater.format(investigationDate)));      
      request.put("investigation_date_year", new JSONString(yearFormater.format(investigationDate)));
      request.put("investigation_lat_location", new JSONString(reportInvestigation.getLatLocation()));
      request.put("investigation_lon_location", new JSONString(reportInvestigation.getLonLocation()));
      request.put("investigation_location_accuracy", new JSONString(reportInvestigation.getLocationAccuracy()));
      request.put("investigation_physical_location", new JSONString(reportInvestigation.getPhysicalLocation()));
      request.put("investigation_species", new JSONString(reportInvestigation.getSpecies()));
      request.put("animal_not_found", JSONBoolean.getInstance(reportInvestigation.isAnimalNotFound()));
      request.put("investigation_condition", new JSONString(reportInvestigation.getCondition()));
      request.put("investigation_nutritional_condition", new JSONString(reportInvestigation.getNutritionalCondition()));
      request.put("investigation_age_class", new JSONString(reportInvestigation.getAgeClass()));
      request.put("tags", new JSONString(reportInvestigation.getTags()));
      request.put("disposition", new JSONString(reportInvestigation.getDisposition()));
      request.put("sex", new JSONString(reportInvestigation.getSex()));
      request.put("weight", new JSONNumber(reportInvestigation.getWeight()));
      request.put("straight_length", new JSONNumber(reportInvestigation.getStraightLength()));
      request.put("girth", new JSONNumber(reportInvestigation.getGirth()));
      request.put("investigation_comments", new JSONString(reportInvestigation.getComments()));
      request.put("is_photo_taken", JSONBoolean.getInstance(isPhotoTaken));
      
      //************************ Live Animals *************************
      
      ReportLiveAnimals reportLiveAnimals = getReportLiveAnimals();

      request.put("is_con_sick", JSONBoolean.getInstance(reportLiveAnimals.isConSick()));
      request.put("is_con_injured", JSONBoolean.getInstance(reportLiveAnimals.isConInjured()));
      request.put("is_con_out_of_habitat", JSONBoolean.getInstance(reportLiveAnimals.isConOutOfHabitat()));
      request.put("is_con_deemed_releasable", JSONBoolean.getInstance(reportLiveAnimals.isConDeemedReleasable()));
      request.put("is_con_abandoned", JSONBoolean.getInstance(reportLiveAnimals.isConAbandoned()));
      
      request.put("is_con_inaccessible", JSONBoolean.getInstance(reportLiveAnimals.isConInaccessible()));
      request.put("is_con_location_hazard_to_animal", JSONBoolean.getInstance(reportLiveAnimals.isConLocationHazardToAnimal()));
      request.put("is_con_location_hazard_to_humans", JSONBoolean.getInstance(reportLiveAnimals.isConLocationHazardToHumans()));
      request.put("is_con_unknown", JSONBoolean.getInstance(reportLiveAnimals.isConUnknown()));
      request.put("is_con_other", JSONBoolean.getInstance(reportLiveAnimals.isConOther()));
      
      request.put("is_action_left_at_site", JSONBoolean.getInstance(reportLiveAnimals.isActionLeftAtSite()));
      request.put("is_action_immediate_release_at_site", JSONBoolean.getInstance(reportLiveAnimals.isActionImmediateReleaseAtSite()));
      request.put("is_action_relocated", JSONBoolean.getInstance(reportLiveAnimals.isActionRelocated()));
      request.put("is_action_died_at_site", JSONBoolean.getInstance(reportLiveAnimals.isActionDiedAtSite()));
      request.put("is_action_died_during_transport", JSONBoolean.getInstance(reportLiveAnimals.isActionDiedDuringTransport()));
      
      request.put("is_action_euthanized_at_site", JSONBoolean.getInstance(reportLiveAnimals.isActionEuthanizedAtSite()));
      request.put("is_action_euthanized_during_transport", JSONBoolean.getInstance(reportLiveAnimals.isActionEuthanizedDuringTransport()));
      request.put("is_action_transferred_to_rehab", JSONBoolean.getInstance(reportLiveAnimals.isActionTransferredToRehab()));
      request.put("is_action_other", JSONBoolean.getInstance(reportLiveAnimals.isActionOther()));
      request.put("relocated_location", new JSONString(reportLiveAnimals.getRelocatedLocation()));
      request.put("live_animals_comments", new JSONString(reportLiveAnimals.getComments()));

      //************************ Human Interaction *************************
      
      request.put("human_interactions", reportHumanInteraction.getJson());
      
      //************************ Attachments *************************
      
      JSONArray attachementArray = new JSONArray();
      
      List<Attachment> attachments = attachmentList.getAttachments();
      
      for(int index = 0; index < attachments.size(); index++)
      {
         Attachment attachment = attachments.get(index);
         
         JSONValue attachmentJson = attachment.getJson();

         attachementArray.set(index, attachmentJson);
      }
      
      request.put("attachments", attachementArray);
      
      return request;
   }
   
   public boolean getIsPhotoTaken()
   {
      return isPhotoTaken;
   }

   public void setIsPhotoTaken(boolean isPhotoTaken)
   {
      this.isPhotoTaken = isPhotoTaken;
   }

   public Volunteer getVolunteer()
   {
      return volunteer;
   }

   public AttachmentList getAttachments()
   {
      return attachmentList;
   }

   public void setAttachments(AttachmentList attachmentList)
   {
      this.attachmentList = attachmentList;
   }

   public void setVolunteer(Volunteer volunteer)
   {
      this.volunteer = volunteer;
   }
   
   public ReportCall getReportCall()
   {
      return reportCall;
   }

   public void setReportCall(ReportCall reportCall)
   {
      this.reportCall = reportCall;
   }

   public void setId(int id)
   {
      this.id = id;
   }
   
   public int getId()
   {
      return id;
   }

   public ReportInvestigation getReportInvestigation()
   {
      return reportInvestigation;
   }

   public void setReportInvestigation(ReportInvestigation reportInvestigation)
   {
      this.reportInvestigation = reportInvestigation;
   }

   public ReportLiveAnimals getReportLiveAnimals()
   {
      return reportLiveAnimals;
   }

   public void setReportLiveAnimals(ReportLiveAnimals reportLiveAnimals)
   {
      this.reportLiveAnimals = reportLiveAnimals;
   }
   
   public ReportHumanInteraction getReportHumanInteraction()
   {
      return reportHumanInteraction;
   }

   public void setReportHumanInteraction(ReportHumanInteraction reportHumanInteraction)
   {
      this.reportHumanInteraction = reportHumanInteraction;
   }
}
