package com.mmsn.reportgen.client.view.volunteer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursManager;
import com.mmsn.reportgen.client.view.TooltipListener;
import com.mmsn.reportgen.client.view.ViewPanel;
import com.mmsn.reportgen.client.view.images.MMSNClientBundle;
import com.mmsn.reportgen.client.view.report.ReportsViewPanel;
import com.mmsn.reportgen.client.view.volunteerhours.VolunteerAddHoursCalendarPanel;

public class VolunteerNameControl extends HorizontalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private WidgetFactory widgetFactory;
   private Volunteer volunteer;
   private VolunteerMonthlyHoursManager volunteerMonthlyHoursManager;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerNameControl(Volunteer volunteer, WidgetFactory widgetFactory, 
                               VolunteerMonthlyHoursManager volunteerMonthlyHoursManager)
   {
      this.widgetFactory = widgetFactory;
      this.volunteer = volunteer;
      this.volunteerMonthlyHoursManager = volunteerMonthlyHoursManager;

      add(createNameLink());

      add(createEditLink());
      
      add(createCalendarLink());
      
      add(createReportLink());
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private Widget createReportLink()
   {
      MMSNClientBundle mmsnImageBundle = (MMSNClientBundle) 
         GWT.create(MMSNClientBundle.class);
   
      ImageResource reportImageResource = mmsnImageBundle.reportIcon();

      Image reportimage = new Image(reportImageResource);

      reportimage.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            ViewPanel viewPanel = widgetFactory.getViewPanel();
            
            ReportsViewPanel reportsViewPanel = widgetFactory.getViewReportPanel(volunteer);
            
            reportsViewPanel.setVolunteer(volunteer);
            
            viewPanel.show(reportsViewPanel);
         }
      });
      
      reportimage.addMouseListener(new TooltipListener("Reports", 1000, "mmsntooltip"));
      
      reportimage.addStyleName("volunteerNameControl");
      
      return reportimage;
   }
   
   private Widget createCalendarLink()
   {
      MMSNClientBundle mmsnImageBundle = (MMSNClientBundle) GWT
      .create(MMSNClientBundle.class);
      
      ImageResource calendarImageResource = mmsnImageBundle.calendarIcon();

      Image calendarImage = new Image(calendarImageResource);

      calendarImage.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            ViewPanel viewPanel = widgetFactory.getViewPanel();
            VolunteerAddHoursCalendarPanel volunteerAddHoursCalendarPanel = 
               widgetFactory.getVolunteerAddHoursCalendarPanel(volunteerMonthlyHoursManager);

            viewPanel.show(volunteerAddHoursCalendarPanel);
         }
      });
      
      calendarImage.addStyleName("volunteerNameControl");
      
      calendarImage.addMouseListener(new TooltipListener("Add Hours", 1000, "mmsntooltip"));
      
      return calendarImage;
   }
   
   private Widget createEditLink()
   {
      MMSNClientBundle mmsnImageBundle = (MMSNClientBundle) GWT
         .create(MMSNClientBundle.class);

      ImageResource editImageResource = mmsnImageBundle.editIcon();

      Image editImage = new Image(editImageResource);

      editImage.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            ViewPanel viewPanel = widgetFactory.getViewPanel();
            VolunteerViewPanel volunteerViewPanel = 
               widgetFactory.getVolunteerViewPanel();

            volunteerViewPanel.setVolunteerData(volunteer);
            
            viewPanel.show(volunteerViewPanel);
         }
      });
      
      editImage.addStyleName("volunteerNameControl");
      
      editImage.addMouseListener(new TooltipListener("Edit Volunteer", 1000, "mmsntooltip"));
      
      return editImage;
   }

   private Widget createNameLink()
   {
      Anchor nameLink = new Anchor(volunteer.getLastName() + ", " + volunteer.getFirstName());
      
      nameLink.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            ViewPanel viewPanel = widgetFactory.getViewPanel();
            VolunteerDetailsPanel volunteerDetailsPanel = 
               widgetFactory.getVolunteerDetailsPanel(volunteerMonthlyHoursManager);
            
            viewPanel.show(volunteerDetailsPanel);
         }
      });
      
      nameLink.addStyleName("volunteerNameControl");
      
      return nameLink;
   }
   
}
