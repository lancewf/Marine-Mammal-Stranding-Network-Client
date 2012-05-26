package com.mmsn.reportgen.client.connection;

public class ReleaseServiceLocations implements ServiceLocations
{ 
   // -------------------------------------------------------------------------
   // Public Report Address
   // -------------------------------------------------------------------------

   @Override
   public String getReportAddedSenderAddress()
   {
      return getBaseServicesUrl() + "createReport";
   }
   
   @Override
   public String getReportModifiedAddress()
   {
      return getBaseServicesUrl() + "updateReport";
   }
   
   @Override
   public String getReportDeleterAddress()
   {
      return getBaseServicesUrl() + "deleteReport";
   }

   @Override
   public String getReportRetrieverAddress()
   {
      return getBaseServicesUrl() + "getReports";
   }

   // -------------------------------------------------------------------------
   // Public Volunteer Address
   // -------------------------------------------------------------------------

   @Override
   public String getVolunteerRetrieverAddress()
   {
      return getBaseServicesUrl() + "getVolunteers";
   }
   
   @Override
   public String getVolunteerDeleterAddress()
   {
      return getBaseServicesUrl() + "deleteVolunteer";
   }

   @Override
   public String getVolunteerUpdateSenderAddress()
   {
      return getBaseServicesUrl() + "updateVolunteer";
   }
   
   @Override
   public String getVolunteerCreateSenderAddress()
   {
      return getBaseServicesUrl() + "createVolunteer";
   }
   
   @Override
   public String getEmailSendAddress()
   {
      return getBaseServicesUrl() + "sendEmailToVolunteers";
   }
   
   // -------------------------------------------------------------------------
   // Public Volunteer Hours Address
   // -------------------------------------------------------------------------

   @Override
   public String getVolunteerHoursDeleterAddress()
   {
      return getBaseServicesUrl() + "deleteVolunteerHours";
   }

   @Override
   public String getVolunteerHoursAddedSenderAddress()
   {
      return getBaseServicesUrl() + "createVolunteerHours";
   }

   @Override
   public String getVolunteerHoursModifiedSenderAddress()
   {
      return getBaseServicesUrl() + "updateVolunteerHours";
   }
   
   @Override
   public String getVolunteerMonthlyHoursRetrieverAddress()
   {
      return getBaseServicesUrl() + "getVolunteerMonthlyHoursCollection";
   }
   
   // -------------------------------------------------------------------------
   // Public Attachment Address
   // -------------------------------------------------------------------------

   @Override
   public String getAttachmentDeleterAddress()
   {
      return getBaseServicesUrl() + "deleteAttachment";
   }

   @Override
   public String getAttachmentAddedSenderAddress()
   {
      return getBaseServicesUrl() + "addAttachment";
   }

   @Override
   public String getAttachmentModifiedAddress()
   {
      return getBaseServicesUrl() + "modifyAttachment";
   }
   
   // -------------------------------------------------------------------------
   // Public Blog Address
   // -------------------------------------------------------------------------
   
   @Override
   public String getBlogAddedSenderAddress()
   {
      return getBaseServicesUrl() + "addBlog";
   }

   @Override
   public String getBlogModifiedSenderAddress()
   {
      return getBaseServicesUrl() + "modifyBlog";
   }

   @Override
   public String getBlogRetrieverAddress()
   {
      return getBaseServicesUrl() + "getBlogs";
   }
   
   @Override
   public String getBlogDeleterAddress()
   {
      return getBaseServicesUrl() + "deleteBlog";
   }
   
   // -------------------------------------------------------------------------
   // Public Other Address
   // -------------------------------------------------------------------------

   @Override
   public String getVolunteerHoursAndMilesCalculatorAddress()
   {
      return getBaseServicesUrl() + "getVolunteerHoursAndMilesCalculatorAddress";
   }
   
   @Override
   public String getIslandsAddress()
   {
      return getBaseServicesUrl() + "getIslands";
   }
   
   @Override
   public String getPhotoUploadAddress()
   {
      return getBaseServicesUrl() + "photoUpload";
   }

   @Override
   public String getBaseUrl()
   {
      return getBaseUrlNative();
   }
   
   // -------------------------------------------------------------------------
   // Private Members
   // -------------------------------------------------------------------------
   
   private static native String getBaseUrlNative() 
   /*-{
      return $wnd.base_url;
   }-*/;
   
   private static native String getBaseServicesUrl() 
   /*-{
      return $wnd.base_services_url;
   }-*/;
}
