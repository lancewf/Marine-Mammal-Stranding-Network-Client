package com.mmsn.reportgen.client.view.volunteerhours;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerHours;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursManager;
import com.mmsn.reportgen.client.view.Panel;
import com.mmsn.reportgen.client.view.toolbars.FormEditToolbar;

public class VolunteerAddHoursViewPanel extends VerticalPanel implements Panel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private VolunteerAddHoursControl volunteerAddHoursControl;

   private VolunteerMonthlyHoursManager volunteerAddHoursManager;

   private VolunteerHours volunteerHours;

   private boolean isNew = false;
   
   private FormEditToolbar formEditToolbar;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerAddHoursViewPanel(WidgetFactory widgetFactory,
         VolunteerMonthlyHoursManager volunteerAddHoursManager)
   {
      this.volunteerAddHoursManager = volunteerAddHoursManager;

      initalize(widgetFactory);
   }

   // --------------------------------------------------------------------------
   // Panel Members
   // --------------------------------------------------------------------------
   
   @Override
   public Widget getToolbar()
   {
      return formEditToolbar;
   }
   
   @Override
   public String getPanelName()
   {
      return "Add Hours";
   }

   @Override
   public Widget getWidget()
   {
      return this;
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setVolunteerHours(VolunteerHours volunteerHours)
   {
      this.volunteerHours = volunteerHours;
      volunteerAddHoursControl.setVolunteerHours(volunteerHours);      
   }

   public void setDate(int month, int dayOfMonth, int year)
   {
      volunteerAddHoursControl.setDate(month, dayOfMonth, year);
   }

   public void setVolunteer(Volunteer volunteer)
   {
      volunteerAddHoursControl.setVolunteer(volunteer);
   }

   public void clearData()
   {
      volunteerAddHoursControl.clearData();
   }

   public void setIsNew(boolean isNew)
   {
      this.isNew = isNew;
      
      formEditToolbar.setIsNew(isNew);
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private void initalize(WidgetFactory widgetFactory)
   {
      addStyleName("viewpanelItem");
      setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
      
      volunteerAddHoursControl = new VolunteerAddHoursControl();

      formEditToolbar = 
         new FormEditToolbar(widgetFactory, volunteerAddHoursControl)
      {

         @Override
         protected void resetControl()
         {
            volunteerAddHoursControl.setVolunteerHours(volunteerHours);
         }

         @Override
         protected void save()
         {
            if (isNew)
            {
               volunteerHours = volunteerAddHoursManager
                     .createNewVolunteerHours();
               
               isNew = false;
               formEditToolbar.setIsNew(false);
            }
            
            volunteerAddHoursControl.fillVolunteerHours(volunteerHours);

            volunteerAddHoursManager.save(volunteerHours);
         }
      };
      
      add(volunteerAddHoursControl);
   }
}
