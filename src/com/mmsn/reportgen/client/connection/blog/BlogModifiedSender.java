package com.mmsn.reportgen.client.connection.blog;

import com.finfrock.client.Sender;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.blog.Blog;

public class BlogModifiedSender extends Sender
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Blog blog;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public BlogModifiedSender(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getBlogModifiedSenderAddress());
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setBlog(Blog blog)
   {
      this.blog = blog;
   }
   
   // --------------------------------------------------------------------------
   // Protected Members
   // --------------------------------------------------------------------------
   
   @Override
   protected String getData()
   {
      String requestData = "";
      
      requestData += "json=" + blog.getJson().toString();
      
      return requestData;
   }
}
