package com.mmsn.reportgen.client.connection;

import java.util.ArrayList;
import java.util.List;

import com.finfrock.client.Loadable;
import com.mmsn.reportgen.client.connection.blog.BlogAddedSender;
import com.mmsn.reportgen.client.connection.blog.BlogDeleter;
import com.mmsn.reportgen.client.connection.blog.BlogEntryRetriever;
import com.mmsn.reportgen.client.connection.blog.BlogModifiedSender;
import com.mmsn.reportgen.client.connection.report.ReportAddedSender;
import com.mmsn.reportgen.client.connection.report.ReportBuilder;
import com.mmsn.reportgen.client.connection.report.ReportData;
import com.mmsn.reportgen.client.connection.report.ReportDeleter;
import com.mmsn.reportgen.client.connection.report.ReportModifiedSender;
import com.mmsn.reportgen.client.connection.report.ReportRetriever;
import com.mmsn.reportgen.client.connection.volunteer.VolunteerAddedSender;
import com.mmsn.reportgen.client.connection.volunteer.VolunteerDeleter;
import com.mmsn.reportgen.client.connection.volunteer.VolunteerModifiedSender;
import com.mmsn.reportgen.client.connection.volunteer.VolunteerRetriever;
import com.mmsn.reportgen.client.data.blog.Blog;
import com.mmsn.reportgen.client.data.blog.BlogManager;
import com.mmsn.reportgen.client.data.report.Report;
import com.mmsn.reportgen.client.data.report.ReportManager;
import com.mmsn.reportgen.client.data.report.ReportManagerable;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteer.VolunteerManager;
import com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable;

public class DataBuilder
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private ReportManagerable reportManager;
   private VolunteerManagerable volunteerManager;
   private ReportRetriever reportRetriever;
   private VolunteerRetriever volunteerRetriever;
   private ServiceLocations serviceLocations;
   private IslandsRetriever islandsRetriever;
   private BlogManager blogManager;
   private BlogEntryRetriever blogEntryRetriever;
   
   // --------------------------------------------------------------------------
   // Constructor Members
   // --------------------------------------------------------------------------

   public DataBuilder(ServiceLocations serviceLocations)
   {
      this.serviceLocations = serviceLocations;
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setLoadable(Loadable loadable)
   {
      if (loadable instanceof ReportRetriever)
      {
         reportRetriever = (ReportRetriever) loadable;
      }
      else if (loadable instanceof VolunteerRetriever)
      {
         volunteerRetriever = (VolunteerRetriever) loadable;
      }
      else if (loadable instanceof IslandsRetriever)
      {
         islandsRetriever = (IslandsRetriever) loadable;
      }
      else if (loadable instanceof BlogEntryRetriever)
      {
         blogEntryRetriever = (BlogEntryRetriever) loadable;
      }
   }
   
   public void build()
   {
      volunteerManager = buildVolunteerManager();
      
      reportManager = buildReportManager(volunteerManager);
      
      blogManager = buildBlogManager();
   }

   public ReportManagerable getReportManager()
   {
      return reportManager;
   }

   public VolunteerManagerable getVolunteerManager()
   {
      return volunteerManager;
   }
   
   public List<String> getIslands()
   {
      return islandsRetriever.getObject();
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private BlogManager buildBlogManager()
   {
      List<Blog> blogs = blogEntryRetriever.getObject();
      
      BlogManager blogManager = new BlogManager(blogs, serviceLocations);
      
      return blogManager;
   }
   
   private ReportManager buildReportManager(VolunteerManagerable volunteerManager)
   {
      List<ReportData> reportDatas = reportRetriever.getObject();
      
      List<Report> reports = new ArrayList<Report>();
      
      ReportBuilder reportBuilder = new ReportBuilder(volunteerManager);
      
      for(ReportData reportData : reportDatas)
      {
         Report report = reportBuilder.buildReport(reportData);
         
         reports.add(report);
      }
      
      ReportAddedSender reportAddedSender = 
         new ReportAddedSender(serviceLocations);
      
      ReportModifiedSender reportModifiedSender = 
         new ReportModifiedSender(serviceLocations);
      
      ReportDeleter reportDeleter = new ReportDeleter(serviceLocations);
      
      ReportManager reportManager = new ReportManager(reports, 
         reportModifiedSender, reportAddedSender, reportDeleter, 
         serviceLocations);
      
      return reportManager;
   }
   
   private VolunteerManagerable buildVolunteerManager()
   {
      List<Volunteer> volunteers = volunteerRetriever.getObject();
      
      VolunteerModifiedSender volunteerModifiedSender = 
         new VolunteerModifiedSender(serviceLocations);
      
      VolunteerAddedSender volunteerAddedSender = 
         new VolunteerAddedSender(serviceLocations);
      
      VolunteerDeleter volunteerDeleter = new VolunteerDeleter(serviceLocations);
      
      VolunteerManagerable volunteerManager = new VolunteerManager(volunteers, 
         volunteerModifiedSender, volunteerAddedSender, 
         volunteerDeleter, serviceLocations);
      
      return volunteerManager;
   }

   public BlogManager getBlogManager()
   {
      return blogManager;
   }
}
