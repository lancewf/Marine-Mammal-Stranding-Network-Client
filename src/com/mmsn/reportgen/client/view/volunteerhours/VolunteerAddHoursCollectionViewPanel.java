package com.mmsn.reportgen.client.view.volunteerhours;

import java.util.Date;

import com.finfrock.client.Returnable;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursManager;
import com.mmsn.reportgen.client.view.Panel;
import com.mmsn.reportgen.client.view.ViewPanel;
import com.mmsn.reportgen.client.view.toolbars.NavigationToolbar;

public class VolunteerAddHoursCollectionViewPanel extends VerticalPanel
implements Panel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private WidgetFactory widgetFactory;
   private VolunteerMonthlyHoursManager volunteerHoursManager;
   private int dayOfMonth;
   private int month;
   private int year;
   private Label dateLabel;
   private Widget toolbar;
   
   // --------------------------------------------------------------------------
   // Private static Data
   // --------------------------------------------------------------------------

   private static DateTimeFormat datetimeformat = 
      DateTimeFormat.getFormat("MMMM d, y");
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerAddHoursCollectionViewPanel(WidgetFactory widgetFactory, 
                                     VolunteerMonthlyHoursManager volunteerHoursManager, 
                                     int dayOfMonth, 
                                     int month, int year)
   {
      this.dayOfMonth = dayOfMonth;
      this.month = month;
      this.year = year;
      this.volunteerHoursManager = volunteerHoursManager;
      this.widgetFactory = widgetFactory;
      
      initialize();
   }
   
   // --------------------------------------------------------------------------
   // Panel Members
   // --------------------------------------------------------------------------
   
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
   public String getPanelName()
   {
      return "View Hours";
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
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      VerticalPanel panel = new VerticalPanel();
      
      panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      Label titleLabel = new Label("Volunteer Hours");
      titleLabel.setStyleName("pageTitle");
      panel.add(titleLabel);
      
      Volunteer volunteer = volunteerHoursManager.getVolunteer();
      
      Label voluteerNameLabel = new Label(volunteer.getFirstName() + " " 
         + volunteer.getLastName());
      
      voluteerNameLabel.setStyleName("pageTitle");
      panel.add(voluteerNameLabel);
      
      Date date = new Date(year - 1900,  month-1, dayOfMonth);
      dateLabel = new Label(datetimeformat.format(date));
      dateLabel.setStyleName("pageTitle");
      
      panel.add(dateLabel);
      
      setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
      
      add(panel);
      
      add(new VolunteerAddHoursTable(volunteerHoursManager, widgetFactory, 
         dayOfMonth, month, year));
   }
   
   private Widget createToolbar()
   {
      NavigationToolbar naviationToolbar = 
         new NavigationToolbar(widgetFactory.getViewPanel(), widgetFactory);
      
      naviationToolbar.addButton("Add New Hours", new Returnable<Object>()
      {
         
         @Override
         public void returned(Object object)
         {
            ViewPanel viewPanel = widgetFactory.getViewPanel();
            
            VolunteerAddHoursViewPanel newVolunteerAddHoursPanel = 
               widgetFactory.getNewVolunteerAddHoursPanel(volunteerHoursManager);
            
            newVolunteerAddHoursPanel.setDate(month, 
               dayOfMonth , year);
            
            newVolunteerAddHoursPanel.setVolunteer(
               volunteerHoursManager.getVolunteer());
            
            viewPanel.show(newVolunteerAddHoursPanel);
         }
      });

      return naviationToolbar;
   }
}
