package com.mmsn.reportgen.client.connection.blog;

import java.util.ArrayList;
import java.util.List;

import com.finfrock.client.Retriever;
import com.google.gwt.core.client.JsArray;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.blog.Blog;

public class BlogEntryRetriever extends Retriever<List<Blog>>
{
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public BlogEntryRetriever(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getBlogRetrieverAddress());
   }
   
   // --------------------------------------------------------------------------
   // Retriever Members
   // --------------------------------------------------------------------------
   
   @Override
   protected List<Blog> parseText(String rawText)
   {
      JsArray<BlogData> blogDatas = asArrayOfBlogData(rawText);

      List<Blog> blogs = new ArrayList<Blog>();
      for(int index = 0; index < blogDatas.length(); index++)
      {
         BlogData blogData = blogDatas.get(index);
         
         Blog blog = createBlog(blogData);
         
         blogs.add(blog);
      }
      
      return blogs;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private Blog createBlog(BlogData blogData)
   {
      Blog blog = new Blog();
      
      blog.setId(blogData.getId()); 
      blog.setTitle(blogData.getTitle());
      blog.setMessage(blogData.getMessage());
      blog.setDayOfMonth(blogData.getDayOfMonth());
      blog.setMonth(blogData.getMonth());
      blog.setYear(blogData.getYear());
      
      return blog;
   }

   private final native JsArray<BlogData> asArrayOfBlogData(String json) 
   /*-{
      return eval(json);
   }-*/;
}
