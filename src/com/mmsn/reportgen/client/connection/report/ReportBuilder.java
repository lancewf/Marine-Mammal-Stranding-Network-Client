package com.mmsn.reportgen.client.connection.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.mmsn.reportgen.client.connection.attachment.AttachmentData;
import com.mmsn.reportgen.client.data.attachment.Attachment;
import com.mmsn.reportgen.client.data.attachment.AttachmentList;
import com.mmsn.reportgen.client.data.report.Report;
import com.mmsn.reportgen.client.data.report.ReportCall;
import com.mmsn.reportgen.client.data.report.ReportInvestigation;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable;

public class ReportBuilder
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private VolunteerManagerable volunteerManager;

   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public ReportBuilder(VolunteerManagerable volunteerManager)
   {
      this.volunteerManager = volunteerManager;
   }

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public Report buildReport(ReportData reportData)
   {
      Report report = new Report();
      
      int volunteerId = reportData.getVolunteerId();
      
      Volunteer volunteer = volunteerManager.getVolunteer(
         volunteerId);
      
      report.setVolunteer(volunteer);
      
      report.setId(reportData.getId());
      
      ReportCall reportCall = new ReportCall();
      
      reportCall.setResponder(reportData.getResponder());
      
      Date callDate = new Date(reportData.getCallDateYear() - 1900, 
         reportData.getCallDateMonth() - 1, reportData.getCallDateDayOfMonth(), 
         reportData.getCallDateHour(), reportData.getCallDateMinute());
      
      reportCall.setDate(callDate);
      
      reportCall.setCallFrom(reportData.getCallFrom());
      reportCall.setCallerName(reportData.getCallerName());
      reportCall.setCallerPhoneNumber(reportData.getCallerPhoneNumber());
      reportCall.setLocation(reportData.getCallLocation());
      reportCall.setSpecies(reportData.getCallSpecies());
      reportCall.setWhenFirstSeen(reportData.getWhenFirstSeen());
      reportCall.setComments(reportData.getCallComments());
      reportCall.setCallReferredTo(reportData.getCallReferredTo());
      reportCall.setCondition(reportData.getCallCondition());
      
      report.setReportCall(reportCall);
      
      ReportInvestigation reportInvestigation = new ReportInvestigation();
      
      reportInvestigation.setInvestigatorSupport(reportData.getInvestigatorSupport());

      Date investigationDate = new Date(reportData.getInvestigationDateYear() - 1900, 
         reportData.getInvestigationDateMonth() - 1, reportData.getInvestigationDateDayOfMonth(), 
         reportData.getInvestigationDateHour(), reportData.getInvestigationDateMinute());
      
      reportInvestigation.setDate(investigationDate);
      
      reportInvestigation.setLatLonLocation(reportData.getInvestigationLatLonLocation());
      reportInvestigation.setPhysicalLocation(reportData.getInvestigationPhysicalLocation());
      reportInvestigation.setSpecies(reportData.getInvestigationSpecies());
      reportInvestigation.setAnimalNotFound(reportData.getAnimalNotFound());
      reportInvestigation.setCondition(reportData.getInvestigationCondition());
      reportInvestigation.setTags(reportData.getTags());
      reportInvestigation.setDisposition(reportData.getDisposition());
      reportInvestigation.setSealPickup(reportData.getSealPickup());
      reportInvestigation.setSex(reportData.getSex());
      reportInvestigation.setWeight(reportData.getWeight());
      reportInvestigation.setStraightLength(reportData.getStraightLength());
      reportInvestigation.setContourLength(reportData.getContourLength());
      reportInvestigation.setGirth(reportData.getGirth());
      reportInvestigation.setComments(reportData.getInvestigationComments());
      
      report.setIsPhotoTaken(reportData.getIsPhotoTaken());
      
      report.setReportInvestigation(reportInvestigation);
      
      List<Attachment> attachments = getAttachments(reportData);
      
      AttachmentList attachmentList = new AttachmentList();
      
      attachmentList.setAttachment(attachments);
      
      report.setAttachments(attachmentList);
      
      return report;
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private List<Attachment> getAttachments(ReportData reportData)
   {
      JsArray<AttachmentData> attachmentDatas = 
         asArrayOfAttachmentData(reportData.getAttachments());
      
      List<Attachment> attachments = new ArrayList<Attachment>();
      
      for(int index = 0; index < attachmentDatas.length(); index++)
      {
         AttachmentData attachmentData = attachmentDatas.get(index);

         Attachment attachment = new Attachment();
         
         attachment.setId(attachmentData.getId());
         attachment.setFileName(attachmentData.getFileName());
         attachment.setComments(attachmentData.getComments());
         
         attachments.add(attachment);
      }
      return attachments;
   }
   
   private final native JsArray<AttachmentData> asArrayOfAttachmentData(
      JavaScriptObject json) 
   /*-{
      return eval(json);
   }-*/;
}
