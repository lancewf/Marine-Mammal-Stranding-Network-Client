package com.mmsn.reportgen.client.view.volunteer;

import java.util.List;

import com.finfrock.client.Returnable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.User;
import com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable;
import com.mmsn.reportgen.client.data.volunteer.VolunteerSearchManager;
import com.mmsn.reportgen.client.view.Panel;
import com.mmsn.reportgen.client.view.SearchControl;
import com.mmsn.reportgen.client.view.ViewPanel;
import com.mmsn.reportgen.client.view.toolbars.NavigationToolbar;

public class VolunteersViewPanel extends VerticalPanel implements Panel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private WidgetFactory widgetFactory;
   private VolunteerManagerable volunteerManager;
   private User user;
   private Widget toolbar;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteersViewPanel(WidgetFactory widgetFactory, 
                              VolunteerManagerable volunteerManager, 
                              User user, List<String> islands)
   {
      this.widgetFactory = widgetFactory;
      this.volunteerManager = volunteerManager;
      this.user = user;
      
      initialize(islands);
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
      return "Volunteers";
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
   
   private void initialize(List<String> islands)
   {
      addStyleName("viewpanelItem");
      
      setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      Label titleLabel = new Label("Volunteers");
      titleLabel.setStyleName("pageTitle");
      VolunteerSearchManager volunteerSearchManager = 
         new VolunteerSearchManager(volunteerManager);
      
      volunteerManager = volunteerSearchManager;
      
      add(titleLabel);
      add(new SearchControl(volunteerSearchManager, islands));
      add(new VolunteerTable(volunteerManager, 
         widgetFactory, user));
   }
   
   private Widget createToolbar()
   {
      NavigationToolbar naviationToolbar = 
         new NavigationToolbar(widgetFactory.getViewPanel(), widgetFactory);
      
      if(user.isAdmin())
      {
         naviationToolbar.addButton("Add New Volunteer",
            new Returnable<Object>()
            {
               @Override
               public void returned(Object object)
               {
                  ViewPanel viewPanel = widgetFactory.getViewPanel();
                  
                  Panel newReportPanel = widgetFactory.getNewVolunteersPanel();
                  
                  viewPanel.show(newReportPanel);
               }
            });
      }
      
      return naviationToolbar;
   }
}
