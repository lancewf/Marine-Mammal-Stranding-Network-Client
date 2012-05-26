package com.mmsn.reportgen.client.connection.attachment;

import com.finfrock.client.Sender;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.attachment.Attachment;

public class AttachmentModifiedSender extends Sender
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Attachment attachment;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public AttachmentModifiedSender(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getAttachmentModifiedAddress());
   }

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setAttachment(Attachment attachment)
   {
      this.attachment = attachment;
   }
   
   // --------------------------------------------------------------------------
   // Protected Members
   // --------------------------------------------------------------------------

   @Override
   protected String getData()
   {
      String requestData = "";
      
      requestData += "json=" + attachment.getJson().toString();
      
      return requestData;
   }
}
