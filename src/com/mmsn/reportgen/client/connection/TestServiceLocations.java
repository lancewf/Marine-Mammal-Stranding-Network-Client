package com.mmsn.reportgen.client.connection;

import com.google.gwt.core.client.GWT;

public class TestServiceLocations implements ServiceLocations
{

   @Override
   public String getReportRetrieverAddress()
   {
      return getBaseServicesUrl() + "getReports.php";
   }

   @Override
   public String getVolunteerMonthlyHoursRetrieverAddress()
   {
      return getBaseServicesUrl() + "getVolunteerMonthlyHoursCollection.php";
   }

   @Override
   public String getVolunteerRetrieverAddress()
   {
      return getBaseServicesUrl() + "getVolunteers.php";
   }
   
   @Override
   public String getReportAddedSenderAddress()
   {
      return getBaseServicesUrl() + "updateReport.php";
   }

   @Override
   public String getReportDeleterAddress()
   {
      return getBaseServicesUrl() + "deleteReport.php";
   }

   @Override
   public String getVolunteerDeleterAddress()
   {
      return getBaseServicesUrl() + "deleteVolunteer.php";
   }

   @Override
   public String getVolunteerUpdateSenderAddress()
   {
      return getBaseServicesUrl() + "updateVolunteer.php";
   }

   @Override
   public String getVolunteerHoursDeleterAddress()
   {
      return getBaseServicesUrl() + "deleteVolunteerHours.php";
   }

   @Override
   public String getVolunteerHoursAddedSenderAddress()
   {
      return getBaseServicesUrl() + "updateVolunteerHours.php";
   }
   
   @Override
   public String getIslandsAddress()
   {
      return getBaseServicesUrl() + "getIslands.php";
   }
   
   public String getBaseServicesUrl() 
   {
      return GWT.getHostPageBaseURL();
   }

   @Override
   public String getPhotoUploadAddress()
   {
      return getBaseServicesUrl() + "getPhotoUpload.php";
   }

   @Override
   public String getBaseUrl()
   {
      return getBaseServicesUrl();
   }

   @Override
   public String getAttachmentDeleterAddress()
   {
      return getBaseServicesUrl() + "getIslands.php";
   }

   @Override
   public String getAttachmentAddedSenderAddress()
   {
      return getBaseServicesUrl() + "updateReport.php";
   }

   @Override
   public String getAttachmentModifiedAddress()
   {
      return getBaseServicesUrl() + "updateReport.php";
   }

   @Override
   public String getReportModifiedAddress()
   {
      return getBaseServicesUrl() + "getVolunteers.php";
   }

   @Override
   public String getVolunteerCreateSenderAddress()
   {
      return getBaseServicesUrl() + "getReports.php";
   }

   @Override
   public String getVolunteerHoursModifiedSenderAddress()
   {
      return getBaseServicesUrl() + "getReports.php";
   }

   @Override
   public String getEmailSendAddress()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String getVolunteerHoursAndMilesCalculatorAddress()
   {
      return getBaseServicesUrl() + "calculateVolunteerHoursAndMiles.php";
   }

   @Override
   public String getBlogAddedSenderAddress()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String getBlogModifiedSenderAddress()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String getBlogRetrieverAddress()
   {
      return getBaseServicesUrl() + "getBlogs.php";
   }

   @Override
   public String getBlogDeleterAddress()
   {
      // TODO Auto-generated method stub
      return null;
   }
}
