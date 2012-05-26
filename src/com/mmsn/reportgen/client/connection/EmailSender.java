package com.mmsn.reportgen.client.connection;

import com.finfrock.client.Sender;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

public class EmailSender extends Sender
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private String subject;
   private String message;

   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public EmailSender(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getEmailSendAddress());
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setMessage(String message)
   {
      this.message = message;
   }

   public void setSubject(String subject)
   {
      this.subject = subject;
   }

   // --------------------------------------------------------------------------
   // Sender Members
   // --------------------------------------------------------------------------
   
   @Override
   protected String getData()
   {
      JSONObject request = new JSONObject();
      
      request.put("message", new JSONString(message));
      request.put("subject", new JSONString(subject));
      
      return "json=" + request.toString();
   }

}
