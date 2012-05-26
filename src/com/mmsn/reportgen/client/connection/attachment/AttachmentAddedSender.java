package com.mmsn.reportgen.client.connection.attachment;

import com.finfrock.client.SenderAndReceiver;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.attachment.Attachment;
import com.mmsn.reportgen.client.data.report.Report;

public class AttachmentAddedSender extends SenderAndReceiver
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Attachment attachment;
   private Report report;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public AttachmentAddedSender(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getAttachmentAddedSenderAddress());
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setAttachment(Attachment attachment)
   {
      this.attachment = attachment;
   }
   
   public void setReport(Report report)
   {
      this.report = report;
   }
   
   // --------------------------------------------------------------------------
   // Protected Members
   // --------------------------------------------------------------------------
   
   protected String getData()
   {
      String requestData = "";
      
      requestData += "json=" + attachment.getJson().toString() + "&";
      requestData += "reportid=" + report.getId();
      
      return requestData;
   }

   @Override
   protected void reponse(String reponse)
   {
      if(attachment.getId() < 0)
      {
         attachment.setId(Integer.parseInt(reponse));
      }
   }

}