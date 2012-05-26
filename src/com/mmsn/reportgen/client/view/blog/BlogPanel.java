package com.mmsn.reportgen.client.view.blog;

import java.util.HashMap;

import com.finfrock.client.DataChangeListener;
import com.finfrock.client.Returnable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.User;
import com.mmsn.reportgen.client.data.blog.Blog;
import com.mmsn.reportgen.client.data.blog.BlogManager;
import com.mmsn.reportgen.client.view.DeleteConfirmationPanel;
import com.mmsn.reportgen.client.view.Panel;
import com.mmsn.reportgen.client.view.ViewPanel;
import com.mmsn.reportgen.client.view.toolbars.NavigationToolbar;

public class BlogPanel extends VerticalPanel implements Panel
{
   // --------------------------------------------------------------------------
   // Private Instance Data
   // --------------------------------------------------------------------------

   private BlogManager blogManager;
   private WidgetFactory widgetFactory;
   private User user;
   private Widget toolbar;
   private HashMap<Blog, BlogEntryControl> blogEntryControlTable = 
      new HashMap<Blog, BlogEntryControl>();
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public BlogPanel(User user, BlogManager blogManager, WidgetFactory widgetFactory)
   {
      this.user = user;
      this.widgetFactory = widgetFactory;
      this.blogManager = blogManager;
      
      initialize();
   }

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   @Override
   public String getPanelName()
   {
      return "News";
   }

   @Override
   public Widget getToolbar()
   {
      if(toolbar == null)
      {
         toolbar = createToolbar();
      }
      
      return toolbar;
   }

   @Override
   public Widget getWidget()
   {
      return this;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private Widget createToolbar()
   {
      NavigationToolbar naviationToolbar = 
         new NavigationToolbar(widgetFactory.getViewPanel(), widgetFactory)
      {
         protected boolean isEditing()
         {
            return areAnyBlogEntriesOpenForEdit();
         }
         
         protected void save()
         {
            saveAllOpenBlogEntries();
         }
      };
      
      if(user.isAdmin())
      {
         naviationToolbar.addButton("Add New Entry",
            new Returnable<Object>()
            {
               @Override
               public void returned(Object object)
               {
                  Blog blog = blogManager.createNewBlog();
                  
                  blogManager.add(blog);
               }
            });
      }
      else
      {
         naviationToolbar.addButton("Goto Volunteers List",
            new Returnable<Object>()
            {
               @Override
               public void returned(Object object)
               {
                  ViewPanel viewPanel = widgetFactory.getViewPanel();
                  Panel panel = widgetFactory.getViewVolunteersPanel();
                  
                  viewPanel.show(panel);
               }
            });
      }
      
      return naviationToolbar;
   }
   
   private void initialize()
   {
      addStyleName("viewpanelItem");
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      refreshPage();
      
      blogManager.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            refreshPage();
         }
      });
   }
   
   /**
    * clear all rows but the first row the header row.
    */
   private void clearTable()
   {
      while (this.getWidgetCount() > 0)
      {
         remove(0);
      }
   }
   
   private void refreshPage()
   {
      clearTable();
      
      for(Blog blog : blogManager.getBlogs())
      {
         BlogEntryControl blogEntryControl = getBlogEntryControl(blog);
         
         add(blogEntryControl);
      }
   }
   
   private void saveAllOpenBlogEntries()
   {
      for(int index = 0; index < getWidgetCount(); index++)
      {
         Widget widget = getWidget(index);
         
         if(widget instanceof BlogEntryControl)
         {
            BlogEntryControl blogEntryControl = (BlogEntryControl)widget;
            
            if(!blogEntryControl.isReadOnly())
            {
               blogEntryControl.saveBlog();
            }
         }
      }
   }
   
   private boolean areAnyBlogEntriesOpenForEdit()
   {
      boolean blogEntryIsOpenForEdit = false;
      
      for(int index = 0; index < getWidgetCount(); index++)
      {
         Widget widget = getWidget(index);
         
         if(widget instanceof BlogEntryControl)
         {
            BlogEntryControl blogEntryControl = (BlogEntryControl)widget;
            
            if(!blogEntryControl.isReadOnly())
            {
               blogEntryIsOpenForEdit = true;
               break;
            }
         }
      }
      
      return blogEntryIsOpenForEdit;
   }
   
   private BlogEntryControl getBlogEntryControl(Blog blog)
   {
      BlogEntryControl blogEntryControl = blogEntryControlTable.get(blog);
      
      if(blogEntryControl == null)
      {
         blogEntryControl = new BlogEntryControl(user, 
            blog, widgetFactory, blogManager);
         
         blogEntryControlTable.put(blog, blogEntryControl);
      }
      
      return blogEntryControl;
   }
}
