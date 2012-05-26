package com.mmsn.reportgen.client.view.report;

import com.finfrock.client.Returnable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.User;
import com.mmsn.reportgen.client.data.report.ReportManagerable;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.view.Panel;
import com.mmsn.reportgen.client.view.ViewPanel;
import com.mmsn.reportgen.client.view.toolbars.NavigationToolbar;

public class ReportsViewPanel extends VerticalPanel
 implements Panel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private WidgetFactory widgetFactory;
   private ReportManagerable reportManager;
   private Volunteer volunteer;
   private User user;
   private Widget toolbar;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public ReportsViewPanel(WidgetFactory widgetFactory, 
                           ReportManagerable reportManager, 
                           User user)
   {
      this.widgetFactory = widgetFactory;
      this.reportManager = reportManager;
      this.user = user;
      
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
      return "View Reports";
   }

   @Override
   public Widget getWidget()
   {
      return this;
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setVolunteer(Volunteer volunteer)
   {
      this.volunteer = volunteer;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {
      addStyleName("viewpanelItem");
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      Label titleLabel = new Label("Reports");
      titleLabel.setStyleName("pageTitle");
      
      add(titleLabel);
      
      add(new ReportTable(reportManager, widgetFactory, user));
   }
   
   private Widget createToolbar()
   {
      NavigationToolbar naviationToolbar = 
         new NavigationToolbar(widgetFactory.getViewPanel(), widgetFactory);

      naviationToolbar.addButton("Create New Report", new Returnable<Object>()
      {
         @Override
         public void returned(Object object)
         {
            widgetFactory.showNewReportPanel(volunteer);
         }
      });

      return naviationToolbar;
   }
}
