package com.mmsn.reportgen.client;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.connection.EmailSender;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.connection.VolunteerHoursAndMilesCalculator;
import com.mmsn.reportgen.client.data.User;
import com.mmsn.reportgen.client.data.blog.BlogManager;
import com.mmsn.reportgen.client.data.report.Report;
import com.mmsn.reportgen.client.data.report.ReportManagerable;
import com.mmsn.reportgen.client.data.report.VolunteerReportManager;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursManager;
import com.mmsn.reportgen.client.view.AdminHomePanel;
import com.mmsn.reportgen.client.view.EmailVolunteersPanel;
import com.mmsn.reportgen.client.view.Panel;
import com.mmsn.reportgen.client.view.ViewPanel;
import com.mmsn.reportgen.client.view.VolunteerHoursReportPanel;
import com.mmsn.reportgen.client.view.blog.BlogPanel;
import com.mmsn.reportgen.client.view.report.ReportPrintView;
import com.mmsn.reportgen.client.view.report.ReportViewPanel;
import com.mmsn.reportgen.client.view.report.ReportsViewPanel;
import com.mmsn.reportgen.client.view.toolbars.NavigationToolbar;
import com.mmsn.reportgen.client.view.volunteer.VolunteerDetailsPanel;
import com.mmsn.reportgen.client.view.volunteer.VolunteerViewPanel;
import com.mmsn.reportgen.client.view.volunteer.VolunteersViewPanel;
import com.mmsn.reportgen.client.view.volunteerhours.VolunteerAddHoursCalendarPanel;
import com.mmsn.reportgen.client.view.volunteerhours.VolunteerAddHoursCollectionViewPanel;
import com.mmsn.reportgen.client.view.volunteerhours.VolunteerAddHoursViewPanel;

public class WidgetFactory
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Panel homePanel;

   private ViewPanel viewPanel;
   
   private ReportManagerable reportManager;

   private VolunteerManagerable volunteerManager;
   
   private BlogManager blogManager;

   private ReportViewPanel reportViewPanel;

   private Panel reportsViewPanel;

   private VolunteersViewPanel volunteersViewPanel;
   
   private VolunteerViewPanel volunteerViewPanel;
   
   private User user;
   
   private List<String> islands;
   
   private ServiceLocations serviceLocations;
   private Widget navigationToolbar;

   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public WidgetFactory(ReportManagerable reportManager,
         VolunteerManagerable volunteerManager, 
         User user, List<String> islands, BlogManager blogManager, 
         ServiceLocations serviceLocations)
   {
      this.blogManager = blogManager;
      this.serviceLocations = serviceLocations;
      this.user = user;
      this.islands = islands;
      this.reportManager = reportManager;
      this.volunteerManager = volunteerManager;

      initialize();
   }

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public BlogPanel getBlogPanel()
   {
      return new BlogPanel(user, blogManager, this);
   }
   
   public Panel getAdminHomePanel()
   {
      if(homePanel == null)
      {
         homePanel = new AdminHomePanel(this);
      }
      
      return homePanel;
   }

   public void showNewReportPanel(Volunteer volunteer)
   {
      if (reportViewPanel == null)
      {
         reportViewPanel = new ReportViewPanel(this, 
            reportManager, serviceLocations);
      }
      else
      {
         reportViewPanel.clearData();
      }

      reportViewPanel.setIsNew(true);
      
      reportViewPanel.setVolunteer(volunteer);

      viewPanel.show(reportViewPanel);
   }

   public void showReportViewPanel(Report report)
   {
      if (reportViewPanel == null)
      {
         reportViewPanel = new ReportViewPanel(this, 
            reportManager, serviceLocations);
      }
      else
      {
         reportViewPanel.clearData();
      }

      reportViewPanel.setIsNew(false);

      reportViewPanel.setReport(report);
      
      viewPanel.show(reportViewPanel);
   }

   public Panel getViewReportPanel()
   {
      if (reportsViewPanel == null)
      {
         reportsViewPanel = new ReportsViewPanel(this, reportManager, user);
      }

      return reportsViewPanel;
   }
   
   public ReportsViewPanel getViewReportPanel(Volunteer volunteer)
   {
      VolunteerReportManager volunteerReportManager = 
         new VolunteerReportManager(reportManager, volunteer);
      
      ReportsViewPanel reportsViewPanel = 
         new ReportsViewPanel(this, volunteerReportManager, user);

      return reportsViewPanel;
   }

   public VolunteerViewPanel getNewVolunteersPanel()
   {
      if (volunteerViewPanel == null)
      {
         volunteerViewPanel = new VolunteerViewPanel(this, 
            volunteerManager, islands);
      }
      else
      {
         volunteerViewPanel.clearData();
      }
      
      volunteerViewPanel.setIsNew(true);

      return volunteerViewPanel;
   }

   public Panel getViewVolunteersPanel()
   {
      if (volunteersViewPanel == null)
      {
         volunteersViewPanel = new VolunteersViewPanel(this, 
            volunteerManager, user, islands);
      }

      return volunteersViewPanel;
   }

   public ViewPanel getViewPanel()
   {
      return viewPanel;
   }

   public VolunteerViewPanel getVolunteerViewPanel()
   {
      if (volunteerViewPanel == null)
      {
         volunteerViewPanel = new VolunteerViewPanel(this, 
            volunteerManager, islands);
      }
      else
      {
         volunteerViewPanel.clearData();
      }

      volunteerViewPanel.setIsNew(false);
      
      return volunteerViewPanel;
   }

   public VolunteerAddHoursCollectionViewPanel getVolunteerAddHoursViewPanel(
                          VolunteerMonthlyHoursManager volunteerHoursManager,
                          int dayOfMonth,
                          int month,
                          int year)
   {
      return new VolunteerAddHoursCollectionViewPanel(this,
         volunteerHoursManager, dayOfMonth, month, year);
   }
   
   public VolunteerAddHoursCalendarPanel getVolunteerAddHoursCalendarPanel(
                      VolunteerMonthlyHoursManager volunteerMonthlyHoursManager)
   {
      VolunteerAddHoursCalendarPanel volunteerAddHoursCalendarPanel = 
         new VolunteerAddHoursCalendarPanel(this, volunteerMonthlyHoursManager);

      return volunteerAddHoursCalendarPanel;
   }

   public VolunteerAddHoursViewPanel getNewVolunteerAddHoursPanel(
                     VolunteerMonthlyHoursManager volunteerMonthlyHoursManager)
   {
      VolunteerAddHoursViewPanel volunteerAddHoursViewPanel = 
         new VolunteerAddHoursViewPanel(this, volunteerMonthlyHoursManager);

      volunteerAddHoursViewPanel.setIsNew(true);
      
      return volunteerAddHoursViewPanel;
   }

   public VolunteerAddHoursViewPanel getVolunteerAddHoursViewPanel(
                      VolunteerMonthlyHoursManager volunteerMonthlyHoursManager)
   {
      VolunteerAddHoursViewPanel volunteerAddHoursViewPanel = 
            new VolunteerAddHoursViewPanel(this, volunteerMonthlyHoursManager);

      volunteerAddHoursViewPanel.setIsNew(false);
      
      return volunteerAddHoursViewPanel;
   }

   public VolunteerDetailsPanel getVolunteerDetailsPanel(
                      VolunteerMonthlyHoursManager volunteerMonthlyHoursManager)
   {
      return new VolunteerDetailsPanel(this, volunteerMonthlyHoursManager);
   }
   
   public Panel getVolunteerHourAndMilesReportPanel()
   {
      VolunteerHoursAndMilesCalculator volunteerHoursAndMilesCalulator = 
         new VolunteerHoursAndMilesCalculator(serviceLocations);
      
      return new VolunteerHoursReportPanel(this, volunteerHoursAndMilesCalulator);
   }

   public ReportPrintView getReportPrintViewPanel()
   {
      return new ReportPrintView();
   }
   
   public Widget getNavigationToolbar()
   {
      if(navigationToolbar == null)
      {
         navigationToolbar = new NavigationToolbar(viewPanel, this);
      }
      
      return navigationToolbar;
   }

   public Panel getEmailVolunteersPanel()
   {
      return new EmailVolunteersPanel(this, new EmailSender(serviceLocations));
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private void initialize()
   {
      viewPanel = new ViewPanel(this);
      
      if(user.isAdmin())
      {
         viewPanel.show(getAdminHomePanel());
      }
      else
      {
         viewPanel.show(getBlogPanel());
      }
   }
}
