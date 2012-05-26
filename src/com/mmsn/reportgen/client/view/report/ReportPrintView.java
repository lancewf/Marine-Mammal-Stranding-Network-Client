package com.mmsn.reportgen.client.view.report;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.data.report.Report;

public class ReportPrintView extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private ReportInvestigationPrintView reportInvestigationPrintView;
   private ReportCallPrintView reportCallPrintView;
   private ReportAttachmentPrintView reportAttachmentPrintView;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportPrintView()
   {
      initialize();
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setReport(Report report)
   {
      reportInvestigationPrintView.setReportInvestigation(report.getReportInvestigation());
      reportCallPrintView.setReportCall(report.getReportCall());
      reportAttachmentPrintView.setAttachments(report.getAttachments());
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {
      setStyleName("printReport");
      
      reportAttachmentPrintView = new ReportAttachmentPrintView();
      reportCallPrintView = new ReportCallPrintView();
      reportInvestigationPrintView = new ReportInvestigationPrintView();
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
      
      add(new HTML("San Juan County Marine Mammal Stranding Network"));
      add(new HTML("Stranding Response Report"));
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      
      add(reportCallPrintView);
      add(reportInvestigationPrintView);
      add(reportAttachmentPrintView);
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
      add(new HTML("The Whale Museum 2010"));
   }
}
