package com.mmsn.reportgen.client.view.volunteerhours;

import com.finfrock.client.DataChangeListener;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursManager;
import com.mmsn.reportgen.client.view.Panel;

public class VolunteerAddHoursCalendarPanel extends VerticalPanel implements Panel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private VolunteerAddHoursCalendarControl calendar;
   
   private Label nameLabel;
   
   private Label totalMonthlyHoursLabel;
   
   private Label totalMonthlyMilesLabel;
   
   private WidgetFactory widgetFactory;
   
   private VolunteerMonthlyHoursManager volunteerMonthlyHoursManager;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerAddHoursCalendarPanel(WidgetFactory widgetFactory, 
                      VolunteerMonthlyHoursManager volunteerMonthlyHoursManager)
   {
      this.widgetFactory = widgetFactory;
      
      addStyleName("calendarPanel");
      
      this.volunteerMonthlyHoursManager = volunteerMonthlyHoursManager;
      
      calendar = new VolunteerAddHoursCalendarControl(
         widgetFactory, volunteerMonthlyHoursManager);

      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      add(createVolunteerInfoControl());
      
      add(calendar);
      
      setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
      
      add(createTotalHoursControl());
      add(createTotalMilesControl());
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
      return "Calendar";
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
  
   private Widget createTotalHoursControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      totalMonthlyHoursLabel = new Label("-");
      
      Label label = new Label("Total Monthly Hours: ");
      panel.add(label);
      panel.add(totalMonthlyHoursLabel);
      
      label.setStyleName("mmsnlabel");
      
      setTotalHours();
      
      volunteerMonthlyHoursManager.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            setTotalHours();
         }
      });
      
      totalMonthlyHoursLabel.setStyleName("mmsnlabel");
      
      return panel;
   }

   private Widget createTotalMilesControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      totalMonthlyMilesLabel = new Label("-");
      
      Label label = new Label("Total Monthly Miles: ");
      panel.add(label);
      panel.add(totalMonthlyMilesLabel);
      
      label.setStyleName("mmsnlabel");
      
      setTotalMiles();
      
      volunteerMonthlyHoursManager.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            setTotalMiles();
         }
      });
      
      totalMonthlyMilesLabel.setStyleName("mmsnlabel");
      
      return panel;
   }
   
   private void setTotalMiles()
   {
      totalMonthlyMilesLabel.setText(volunteerMonthlyHoursManager.getTotalMiles() + "");
   }
   
   private void setTotalHours()
   {
      totalMonthlyHoursLabel.setText(volunteerMonthlyHoursManager.getTotalHours() + "");
   }
   
   private Widget createVolunteerInfoControl()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      nameLabel = new Label("(Name) ");
      
      Label label = new Label("Volunteer: ");
      
      label.setStyleName("mmsnlabel");
      
      panel.add(label);
      panel.add(nameLabel);
      
      nameLabel.setStyleName("mmsnlabel");
      
      Volunteer volunteer = volunteerMonthlyHoursManager.getVolunteer();
      
      nameLabel.setText(volunteer.getFullName());
      
      return panel;
   }
}
