package com.mmsn.reportgen.client.connection;

public interface ServiceLocations
{
   String getReportRetrieverAddress();

   String getVolunteerRetrieverAddress();

   String getReportAddedSenderAddress();

   String getReportDeleterAddress();

   String getVolunteerDeleterAddress();

   String getVolunteerUpdateSenderAddress();

   String getVolunteerMonthlyHoursRetrieverAddress();
   
   String getVolunteerHoursAddedSenderAddress();

   String getVolunteerHoursDeleterAddress();

   String getIslandsAddress();

   String getPhotoUploadAddress();
   
   String getBaseUrl();

   String getAttachmentDeleterAddress();

   String getAttachmentAddedSenderAddress();

   String getAttachmentModifiedAddress();

   String getReportModifiedAddress();

   String getVolunteerCreateSenderAddress();

   String getVolunteerHoursModifiedSenderAddress();

   String getEmailSendAddress();

   String getVolunteerHoursAndMilesCalculatorAddress();

   String getBlogRetrieverAddress();

   String getBlogAddedSenderAddress();

   String getBlogModifiedSenderAddress();

   String getBlogDeleterAddress();
}
