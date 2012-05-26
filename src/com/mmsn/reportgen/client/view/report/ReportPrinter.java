package com.mmsn.reportgen.client.view.report;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.mmsn.reportgen.client.Print;
import com.mmsn.reportgen.client.data.report.Report;

public class ReportPrinter
{

   public ReportPrinter()
   {
      
   }
   
   public void printReport(Report report)
   {
      ReportPrintView reportPrintView = new ReportPrintView();
      
      reportPrintView.setReport(report);

      RootPanel.get("printDiv").add(reportPrintView);
      
      RootPanel.get("printDiv").setVisible(false);

      Print.it(getDocType(), getStyle(), DOM.getElementById("printDiv").getInnerHTML());

      RootPanel.get("printDiv").remove(reportPrintView);
   }
   
   private String getStyle()
   {
      String style = "<style type=\"text/css\"> " +
            ".printLabel { " +
               "font-weight: bold;         " +
               "padding-bottom: 5px;         " +
               "padding-right: 3px;      }      " +
               
               ".printField {" +
                  "text-decoration: underline;         " +
                  "padding-right: 5px;         " +
                  "padding-bottom: 5px;      " +
               "}" +
               ".printReport {" +
               "width: 100%;" +
               "height: 100%;"+
               "}</style>";
      
      return style;
   }
   
   private String getDocType()
   {
      return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">";
   }
}
