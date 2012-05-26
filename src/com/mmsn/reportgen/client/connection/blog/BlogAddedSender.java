package com.mmsn.reportgen.client.connection.blog;

import com.finfrock.client.SenderAndReceiver;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.blog.Blog;

public class BlogAddedSender extends SenderAndReceiver
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Blog blog;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public BlogAddedSender(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getBlogAddedSenderAddress());
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

   @Override
   protected void reponse(String reponse)
   {
      if(blog.getId() < 0)
      {
         blog.setId(Integer.parseInt(reponse));
      }
   }

}
