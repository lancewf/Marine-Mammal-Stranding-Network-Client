package com.mmsn.reportgen.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.view.blog.BlogPanel;

public class AdminHomePanel extends VerticalPanel implements Panel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private WidgetFactory widgetFactory;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public AdminHomePanel(WidgetFactory widgetFactory)
   {
      this.widgetFactory = widgetFactory;
      
      initialize();
   }

   // --------------------------------------------------------------------------
   // Panel Members
   // --------------------------------------------------------------------------
   
   @Override
   public String getPanelName()
   {
      return "Option";
   }

   @Override
   public Widget getWidget()
   {
      return this;
   }
   
   @Override
   public Widget getToolbar()
   {
      return widgetFactory.getNavigationToolbar();
   }

   public boolean isEditing(){ return false;}
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {  
      addStyleName("viewpanelItem");
      
      setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      VerticalPanel panel = new VerticalPanel();
      
      panel.addStyleName("viewpanelFolder");
      panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
      panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      panel.add(createReportLink());
      panel.add(createVolunteersLink());
      panel.add(createEmailVolunteersLink());
      panel.add(createVolunteerHourAndMilesCalculatorLink());
      panel.add(createBlogLink());
      
      add(panel);
   }

   private Widget createBlogLink()
   {
      Anchor blogLink = new Anchor("News");
      
      blogLink.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            showBlog();
         }
      });
      return blogLink;
   }
   
   private Widget createVolunteerHourAndMilesCalculatorLink()
   {
      Anchor volunteerHourAndMilesCalculator = new Anchor("Calculate Volunteer Hours and Miles");
      
      volunteerHourAndMilesCalculator.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            showVolunteerHourAndMilesCalculator();
         }
      });
      return volunteerHourAndMilesCalculator;
   }
   
   private Widget createEmailVolunteersLink()
   {
      Anchor viewEmailVolunteers = new Anchor("Email Volunteers");
      
      viewEmailVolunteers.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            showEmailVolunteers();
         }
      });
      return viewEmailVolunteers;
   }

   private Anchor createVolunteersLink()
   {
      Anchor viewVolunteers = new Anchor("Volunteers");
    
      viewVolunteers.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            showVolunteers();
         }
      });
      return viewVolunteers;
   }

   private Anchor createReportLink()
   {
      Anchor viewReports = new Anchor("Reports");
      
      viewReports.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            showReports();
         }
      });
      return viewReports;
   }
   
   private void showBlog()
   {
      ViewPanel viewPanel = widgetFactory.getViewPanel();
      BlogPanel panel = widgetFactory.getBlogPanel();
      panel.closeBlogEntriesOpenForEdit();
      viewPanel.show(panel);
   }
   
   private void showVolunteerHourAndMilesCalculator()
   {
      ViewPanel viewPanel = widgetFactory.getViewPanel();
      Panel panel = widgetFactory.getVolunteerHourAndMilesReportPanel();
      
      viewPanel.show(panel);
   }
   
   private void showEmailVolunteers()
   {
      ViewPanel viewPanel = widgetFactory.getViewPanel();
      Panel panel = widgetFactory.getEmailVolunteersPanel();
      
      viewPanel.show(panel);
   }
   
   private void showVolunteers()
   {
      ViewPanel viewPanel = widgetFactory.getViewPanel();
      Panel panel = widgetFactory.getViewVolunteersPanel();
      
      viewPanel.show(panel);
   }
   
   private void showReports()
   {
      ViewPanel viewPanel = widgetFactory.getViewPanel();
      Panel panel = widgetFactory.getViewReportPanel();
      
      viewPanel.show(panel);
   }
}
