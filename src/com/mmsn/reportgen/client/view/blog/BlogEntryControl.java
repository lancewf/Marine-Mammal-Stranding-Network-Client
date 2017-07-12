package com.mmsn.reportgen.client.view.blog;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.User;
import com.mmsn.reportgen.client.data.blog.Blog;
import com.mmsn.reportgen.client.data.blog.BlogManager;
import com.mmsn.reportgen.client.view.FormEditControl;
import com.mmsn.reportgen.client.view.TextAreaReadWrite;

public class BlogEntryControl extends VerticalPanel implements FormEditControl
{
   // --------------------------------------------------------------------------
   // Private Instance Data
   // --------------------------------------------------------------------------

   private LabelEditable title;
   private TextAreaReadWrite message;
   private static DateTimeFormat datetimeformat = 
      DateTimeFormat.getFormat("MMMM d, y");
   private BlogManager blogManager;
   private Blog blog;
   private User user;
   private WidgetFactory widgetFactory;
   private boolean readOnly = true;
   private BlogEditToolbar formEditToolbar;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public BlogEntryControl(User user, Blog blog, WidgetFactory widgetFactory, 
                           BlogManager blogManager)
   {
      this.user = user;
      this.widgetFactory = widgetFactory;
      this.blogManager = blogManager;
      this.blog = blog;
      
      initialize(widgetFactory);
   }

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

     public void resetControl()
     {
        title.setText(blog.getTitle());
        message.setText(blog.getMessage());
        setReadOnly(true);
        if(formEditToolbar != null){
          formEditToolbar.readOnlyMode();
        }
     }

   @Override
   public void setReadOnly(boolean readOnly)
   {
      this.readOnly = readOnly;
      title.setReadOnly(readOnly);
      message.setReadOnly(readOnly);
   }
   
   public boolean isReadOnly()
   {
      return readOnly;
   }
   
   public void saveBlog()
   {
      blog.setMessage(message.getText());
      blog.setTitle(title.getText());
      
      blogManager.save(blog);
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private void initialize(WidgetFactory widgetFactory)
   {
      addStyleName("blog");
      
      title = new LabelEditable(blog.getTitle());
      title.setWidth("400px");
      title.setStyleName("blogTitle");
      
      message = new TextAreaReadWrite(blog.getMessage());
      message.setWidth("100%");
      message.setHeight("400px");
      message.setStyleName("blogMessage");
      
      Date date = new Date(blog.getYear() - 1900,  blog.getMonth()-1, blog.getDayOfMonth());
      Label dateLabel = new Label(datetimeformat.format(date));
      
      HorizontalPanel horizontalPanel = new HorizontalPanel();
      horizontalPanel.setStyleName("blogTitle");
      
      horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
      horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      horizontalPanel.add(title);
      horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
      horizontalPanel.add(dateLabel);
      
      VerticalPanel messagePanel = new VerticalPanel();
      messagePanel.setStyleName("blogMessagePanel");
      messagePanel.add(message);
      
      VerticalPanel panel = new VerticalPanel();
      panel.setWidth("70%");
      
      if(user.isAdmin())
      {
         formEditToolbar = createToolbar();
         panel.add(formEditToolbar);
      }
      
      panel.add(horizontalPanel);
      
      panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      panel.add(messagePanel);
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      add(panel);
   }
   
   private BlogEditToolbar createToolbar()
   {
      BlogEditToolbar formEditToolbar = 
         new BlogEditToolbar(widgetFactory, this)
      {
         @Override
         protected void resetControl()
         {
            BlogEntryControl.this.resetControl();
         }

         @Override
         protected void save()
         {
            saveBlog();
         }
         
         protected void delete()
         {
            blogManager.delete(blog);
         }
      };
      
      if(blogManager.isNew(blog))
      {
         formEditToolbar.editeMode();
      }
      
      return formEditToolbar;
   }
}
