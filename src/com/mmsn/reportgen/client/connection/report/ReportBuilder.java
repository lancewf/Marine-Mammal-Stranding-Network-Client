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
import com.mmsn.reportgen.client.data.report.ReportHumanInteraction;
import com.mmsn.reportgen.client.data.report.ReportHumanInteractionSection;
import com.mmsn.reportgen.client.data.report.ReportInvestigation;
import com.mmsn.reportgen.client.data.report.ReportLiveAnimals;
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
      
      reportInvestigation.setLatLocation(reportData.getInvestigationLatLocation());
      reportInvestigation.setLonLocation(reportData.getInvestigationLonLocation());
      reportInvestigation.setLocationAccuracy(reportData.getInvestigationLocationAccuracy());
      reportInvestigation.setPhysicalLocation(reportData.getInvestigationPhysicalLocation());
      reportInvestigation.setSpecies(reportData.getInvestigationSpecies());
      reportInvestigation.setAnimalNotFound(reportData.getAnimalNotFound());
      reportInvestigation.setCondition(reportData.getInvestigationCondition());
      reportInvestigation.setTags(reportData.getTags());
      reportInvestigation.setDisposition(reportData.getDisposition());
      reportInvestigation.setSex(reportData.getSex());
      reportInvestigation.setWeight(reportData.getWeight());
      reportInvestigation.setStraightLength(reportData.getStraightLength());
      reportInvestigation.setGirth(reportData.getGirth());
      reportInvestigation.setComments(reportData.getInvestigationComments());
      reportInvestigation.setAgeClass(reportData.getInvestigationAgeClass());
      reportInvestigation.setNutritionalCondition(reportData.getInvestigationNutritionalCondition());
      
      report.setIsPhotoTaken(reportData.getIsPhotoTaken());
      
      report.setReportInvestigation(reportInvestigation);
     
      //************************ Live Animals *************************
      
      ReportLiveAnimals reportLiveAnimals = new ReportLiveAnimals();
      
      reportLiveAnimals.setConSick(reportData.getLiveAnimalsIsConSick());
      reportLiveAnimals.setConInjured(reportData.getLiveAnimalsIsConInjured());
      reportLiveAnimals.setConOutOfHabitat(reportData.getLiveAnimalsIsConOutOfHabitat());
      reportLiveAnimals.setConDeemedReleasable(reportData.getLiveAnimalsIsConDeemedReleasable());
      reportLiveAnimals.setConAbandoned(reportData.getLiveAnimalsIsConAbandoned());
      reportLiveAnimals.setConInaccessible(reportData.getLiveAnimalsIsConInaccessible());
      reportLiveAnimals.setConLocationHazardToAnimal(reportData.getLiveAnimalsIsConLocationHazardToAnimal());
      reportLiveAnimals.setConLocationHazardToHumans(reportData.getLiveAnimalsIsConLocationHazardToHumans());
      reportLiveAnimals.setConUnknown(reportData.getLiveAnimalsIsConUnknown());
      reportLiveAnimals.setConOther(reportData.getLiveAnimalsIsConOther());
      
      reportLiveAnimals.setActionLeftAtSite(reportData.getLiveAnimalsIsActionLeftAtSite());
      reportLiveAnimals.setActionImmediateReleaseAtSite(reportData.getLiveAnimalsIsActionImmediateReleaseAtSite());
      reportLiveAnimals.setActionRelocated(reportData.getLiveAnimalsIsActionRelocated());
      reportLiveAnimals.setActionDiedAtSite(reportData.getLiveAnimalsIsActionDiedAtSite());
      reportLiveAnimals.setActionDiedDuringTransport(reportData.getLiveAnimalsIsActionDiedDuringTransport());
      reportLiveAnimals.setActionEuthanizedAtSite(reportData.getLiveAnimalsIsActionEuthanizedAtSite());
      reportLiveAnimals.setActionEuthanizedDuringTransport(reportData.getLiveAnimalsIsActionEuthanizedDuringTransport());
      reportLiveAnimals.setActionTransferredToRehab(reportData.getLiveAnimalsIsActionTransferredToRehab());
      reportLiveAnimals.setActionOther(reportData.getLiveAnimalsIsActionOther());
      reportLiveAnimals.setRelocatedLocation(reportData.getLiveAnimalsRelocatedLocation());
      reportLiveAnimals.setComments(reportData.getLiveAnimalsComments());
      
      
      report.setReportLiveAnimals(reportLiveAnimals);
      
      //************************ Human Interaction *************************
 
      ReportHumanInteraction reportHumanInteraction = new ReportHumanInteraction();
      reportHumanInteraction.setSections(getHumanInteractionSections(reportData));
      
      report.setReportHumanInteraction(reportHumanInteraction);
 
      //************************ Attachments *************************
      
      List<Attachment> attachments = getAttachments(reportData);
      
      AttachmentList attachmentList = new AttachmentList();
      
      attachmentList.setAttachment(attachments);
      
      report.setAttachments(attachmentList);
      
      return report;
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private List<ReportHumanInteractionSection> getHumanInteractionSections(ReportData reportData) {
		JavaScriptObject javaScriptObject = null;

		try {
			javaScriptObject = reportData.getHumanInteractionSections();
		} catch (Exception ex) {
			javaScriptObject = null;
		}

		List<ReportHumanInteractionSection> sections = new ArrayList<ReportHumanInteractionSection>();

		if (javaScriptObject != null) {
			JsArray<ReportHumanInteractionSectionData> sectionDatas = asArrayOfHumanInteractionSectionData(javaScriptObject);
			for (int index = 0; index < sectionDatas.length(); index++) {
				ReportHumanInteractionSectionData sectionData = sectionDatas.get(index);
				
				ReportHumanInteractionSection section = new ReportHumanInteractionSection(sectionData.getName());
				
				section.setExamined(sectionData.isExamined());
				section.setPossibleHiLesion(sectionData.getPossibleHiLesion());
				section.setPossibleSource(sectionData.getPossibleSource());
				section.setScavengerDamage(sectionData.getScavengerDamage());

				sections.add(section);
			}
		}
		return sections;
   }
   
	private List<Attachment> getAttachments(ReportData reportData) {
		JavaScriptObject javaScriptObject = null;

		try {
			javaScriptObject = reportData.getAttachments();
		} catch (Exception ex) {
			javaScriptObject = null;
		}

		List<Attachment> attachments = new ArrayList<Attachment>();

		if (javaScriptObject != null) {
			JsArray<AttachmentData> attachmentDatas = asArrayOfAttachmentData(javaScriptObject);
			for (int index = 0; index < attachmentDatas.length(); index++) {
				AttachmentData attachmentData = attachmentDatas.get(index);
				
				Attachment attachment = new Attachment();
				if(attachmentData.getFileName() != null && attachmentData.getComments() != null){
					attachment.setFileName(attachmentData.getFileName());
					attachment.setComments(attachmentData.getComments());
				}
				else{
					attachment.setFileName("Bad_Image_Please_delete");
					attachment.setComments("Bad Image Please delete");
				}
				attachment.setId(attachmentData.getId());

				attachments.add(attachment);
			}
		}
		return attachments;
	}
   
   private final native JsArray<ReportHumanInteractionSectionData> asArrayOfHumanInteractionSectionData(JavaScriptObject json) 
   /*-{
	return eval(json);
   }-*/;
	   
   private final native JsArray<AttachmentData> asArrayOfAttachmentData(JavaScriptObject json) 
   /*-{
	return eval(json);
   }-*/;
}
