package com.mmsn.reportgen.client.data.blog;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.extjs.gxt.ui.client.util.DateWrapper;
import com.finfrock.client.DataChangeListener;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.connection.blog.BlogAddedSender;
import com.mmsn.reportgen.client.connection.blog.BlogDeleter;
import com.mmsn.reportgen.client.connection.blog.BlogModifiedSender;

public class BlogManager
{
   // --------------------------------------------------------------------------
   // Private Instrance Data
   // --------------------------------------------------------------------------

   private List<Blog> blogs;
   private List<DataChangeListener> dataChangeListeners = 
      new ArrayList<DataChangeListener>();
   private ServiceLocations serviceLocations;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public BlogManager(List<Blog> blogs, 
                      ServiceLocations serviceLocations)
   {
      this.serviceLocations = serviceLocations;
      this.blogs = blogs;
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public Blog createNewBlog()
   {
      Blog newBlog = new Blog();
 
      newBlog.setId(-1);
      
      DateWrapper dateWrapper = new DateWrapper();
      
      newBlog.setDayOfMonth(dateWrapper.getDate());
      newBlog.setMonth(dateWrapper.getMonth() + 1);
      newBlog.setYear(dateWrapper.getFullYear());
      
      newBlog.setTitle("Title Here");
      newBlog.setMessage("Message Here");
      
      return newBlog;
   }
   
   public List<Blog> getBlogs()
   {
      Collections.sort(blogs, new Comparator<Blog>()
      {
         @Override
         public int compare(Blog blog1,
                            Blog blog2)
         {
            Date date1 = new Date(blog1.getYear(), blog1.getMonth(), blog1.getDayOfMonth());
            Date date2 = new Date(blog2.getYear(), blog2.getMonth(), blog2.getDayOfMonth());
            
            return date2.compareTo(date1);
         }
      });
      
      return blogs;
   }

   public void addDataChangeListener(
                                   DataChangeListener dataChangeListener)
   {
      dataChangeListeners.add(dataChangeListener);
   }
   
   public void removeDataChangeListener(DataChangeListener dataChangeListener)
   {
      dataChangeListeners.remove(dataChangeListener);
   }
   
   public void add(Blog blog)
   {
      blogs.add(blog);
      
      dataChanged();
   }
   
   public void save(Blog blog)
   {
      if(isNew(blog))
      {
         BlogAddedSender blogAddedSender = new BlogAddedSender(serviceLocations);
         
         blogAddedSender.setBlog(blog);
         
         blogAddedSender.send();
         
         if(!blogs.contains(blog))
         {
            blogs.add(blog);
         }
      }
      else
      {
         BlogModifiedSender blogModifiedSender = new BlogModifiedSender(serviceLocations);
         
         blogModifiedSender.setBlog(blog);
         
         blogModifiedSender.send();
      }
      
      dataChanged();
   }
   
   public void delete(Blog blog)
   {
      blogs.remove(blog);
      
      if(!isNew(blog))
      {
         BlogDeleter blogDeleter = new BlogDeleter(serviceLocations);
         
         blogDeleter.setBlog(blog);
         
         blogDeleter.send();  
      }
      
      dataChanged();
   }
   
   public boolean isNew(Blog blog)
   {
      return blog.getId() < 0;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private void dataChanged()
   {
      for(DataChangeListener dataChangeListener : dataChangeListeners)
      {
         dataChangeListener.onDataChange();
      }
   }
}
