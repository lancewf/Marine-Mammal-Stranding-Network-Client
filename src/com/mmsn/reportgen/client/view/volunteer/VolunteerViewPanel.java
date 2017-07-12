package com.mmsn.reportgen.client.view.volunteer;

import java.util.List;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable;
import com.mmsn.reportgen.client.view.Panel;
import com.mmsn.reportgen.client.view.toolbars.FormEditToolbar;

public class VolunteerViewPanel extends VerticalPanel implements Panel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private VolunteerControl volunteerControl;

   private Volunteer volunteer;

   private VolunteerManagerable volunteerManager;
   
   private boolean isNew = false;
   
   private FormEditToolbar formEditToolbar;

   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerViewPanel(WidgetFactory widgetFactory,
         VolunteerManagerable volunteerManager, List<String> islands)
   {
      this.volunteerManager = volunteerManager;

      initalize(islands, widgetFactory);
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
      return "Information";
   }

   @Override
   public Widget getWidget()
   {
      return this;
   }
   
   public boolean isEditing(){ return formEditToolbar.isEditing();}

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setVolunteerData(Volunteer volunteer)
   {
      this.volunteer = volunteer;
      volunteerControl.setVolunteer(volunteer);
   }

   public void clearData()
   {
      volunteerControl.clearData();
   }
   
   public void setIsNew(boolean isNewVolunteer)
   {
      this.isNew = isNewVolunteer;
      
      formEditToolbar.setIsNew(isNewVolunteer);
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private void initalize(List<String> islands, WidgetFactory widgetFactory)
   {
      addStyleName("viewpanelItem");

      volunteerControl = new VolunteerControl(islands);

      createToolbar(widgetFactory);
      
      add(volunteerControl);
   }

   private void createToolbar(WidgetFactory widgetFactory)
   {
      formEditToolbar = 
         new FormEditToolbar(widgetFactory, volunteerControl)
      {

         @Override
         protected void resetControl()
         {
            volunteerControl.setVolunteer(volunteer);

            volunteerControl.setReadOnly(true);
         }

         @Override
         protected void save()
         {
            if (isNew)
            {
               volunteer = volunteerManager.createNewVolunteer();
               isNew = false;
               formEditToolbar.setIsNew(false);
            }
            
            volunteerControl.fillVolunteer(volunteer);

            volunteerManager.saveVolunteer(volunteer);
         }
      };
   }
}
