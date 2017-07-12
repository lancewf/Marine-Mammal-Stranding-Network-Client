package com.mmsn.reportgen.client.view.volunteer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursManager;
import com.mmsn.reportgen.client.view.Panel;
import com.mmsn.reportgen.client.view.ViewPanel;
import com.mmsn.reportgen.client.view.images.MMSNClientBundle;
import com.mmsn.reportgen.client.view.report.ReportsViewPanel;
import com.mmsn.reportgen.client.view.volunteerhours.VolunteerAddHoursCalendarPanel;

public class VolunteerDetailsPanel extends VerticalPanel implements Panel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private WidgetFactory widgetFactory;

   private VolunteerMonthlyHoursManager volunteerMonthlyHoursManager;

   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerDetailsPanel(WidgetFactory widgetFactory, 
                      VolunteerMonthlyHoursManager volunteerMonthlyHoursManager)
   {
      this.widgetFactory = widgetFactory;
      this.volunteerMonthlyHoursManager = volunteerMonthlyHoursManager;

      initialize();
   }
   
   // --------------------------------------------------------------------------
   // Panel Members
   // --------------------------------------------------------------------------
   
   @Override
   public Widget getToolbar()
   {
      return widgetFactory.getNavigationToolbar();
   }
   
   @Override
   public String getPanelName()
   {
      return "Options";
   }

   @Override
   public Widget getWidget()
   {
      return this;
   }

   public boolean isEditing(){ return false;}

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {
      addStyleName("viewpanelItem");
      
      Widget addHoursPanel = createAddHoursPanel();
      Widget editInfoPanel = createEditInfoPanel();
      Widget createReportPanel = createReportPanel();
      
      setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

      VerticalPanel panel = new VerticalPanel();

      panel.addStyleName("viewpanelFolder");
      panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
      panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

      panel.add(editInfoPanel);
      panel.add(addHoursPanel);
      panel.add(createReportPanel);
      
      add(panel);
   }
   
   private Widget createReportPanel()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Anchor viewReports = new Anchor("Reports");

      viewReports.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            showReports();
         }
      });
      
      viewReports.addStyleName("volunteerNameControl");
      
      MMSNClientBundle mmsnImageBundle = (MMSNClientBundle) 
      GWT.create(MMSNClientBundle.class);
   
      ImageResource reportImageResource = mmsnImageBundle.reportIcon();

      Image reportimage = new Image(reportImageResource);

      reportimage.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            showReports();
         }
      });

      panel.add(viewReports);

      panel.add(reportimage);
      
      return panel;
   }
   
   private Widget createEditInfoPanel()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      Anchor editInfo = new Anchor("Edit Volunteer");

      editInfo.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            showVolunteerEditPanel();
         }
      });
      
      editInfo.addStyleName("volunteerNameControl");
      
      MMSNClientBundle mmsnImageBundle = (MMSNClientBundle) GWT
         .create(MMSNClientBundle.class);

      ImageResource editImageResource = mmsnImageBundle.editIcon();

      Image editImage = new Image(editImageResource);

      editImage.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            showVolunteerEditPanel();
         }
      });

      editImage.addStyleName("volunteerNameControl");
      
      panel.add(editInfo);
      
      panel.add(editImage);
      
      return panel;
   }
   
   private Widget createAddHoursPanel()
   {
      HorizontalPanel addHoursPanel = new HorizontalPanel();
      
      Anchor addHours = new Anchor("Add Volunteer Hours");

      addHours.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            showCalendar();
         }
      });
      
      addHours.addStyleName("volunteerNameControl");
      
      MMSNClientBundle mmsnImageBundle = (MMSNClientBundle) GWT
      .create(MMSNClientBundle.class);
      
      ImageResource calendarImageResource = mmsnImageBundle.calendarIcon();

      Image calendarImage = new Image(calendarImageResource);

      calendarImage.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            showCalendar();
         }
      });
      
      calendarImage.addStyleName("volunteerNameControl");
      
      addHoursPanel.add(addHours);
      
      addHoursPanel.add(calendarImage);
      
      return addHoursPanel;
   }
   
   private void showReports()
   {
      ViewPanel viewPanel = widgetFactory.getViewPanel();
      
      Volunteer volunteer = volunteerMonthlyHoursManager.getVolunteer();
      
      ReportsViewPanel reportsViewPanel = widgetFactory.getViewReportPanel(volunteer);
      
      reportsViewPanel.setVolunteer(volunteer);
      
      viewPanel.show(reportsViewPanel);
   }
   
   private void showVolunteerEditPanel()
   {
      ViewPanel viewPanel = widgetFactory.getViewPanel();
      VolunteerViewPanel volunteerViewPanel = widgetFactory
         .getVolunteerViewPanel();

      Volunteer volunteer = volunteerMonthlyHoursManager.getVolunteer();
      
      volunteerViewPanel.setVolunteerData(volunteer);

      viewPanel.show(volunteerViewPanel);
   }
   
   private void showCalendar()
   {
      ViewPanel viewPanel = widgetFactory.getViewPanel();
      VolunteerAddHoursCalendarPanel volunteerAddHoursCalendarPanel = 
         widgetFactory.getVolunteerAddHoursCalendarPanel(volunteerMonthlyHoursManager);
      
      viewPanel.show(volunteerAddHoursCalendarPanel);
   }
}
