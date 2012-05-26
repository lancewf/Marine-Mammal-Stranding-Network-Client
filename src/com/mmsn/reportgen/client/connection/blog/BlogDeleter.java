package com.mmsn.reportgen.client.connection.blog;

import com.finfrock.client.Sender;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.blog.Blog;

public class BlogDeleter extends Sender
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Blog blog;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public BlogDeleter(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getBlogDeleterAddress());
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
      
      requestData += "blogId=" + blog.getId();
            
      return requestData;
   }
}
