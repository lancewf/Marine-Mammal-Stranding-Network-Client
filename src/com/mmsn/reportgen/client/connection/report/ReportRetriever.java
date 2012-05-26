package com.mmsn.reportgen.client.connection.report;

import java.util.ArrayList;
import java.util.List;

import com.finfrock.client.Retriever;
import com.google.gwt.core.client.JsArray;
import com.mmsn.reportgen.client.connection.ServiceLocations;

public class ReportRetriever extends Retriever<List<ReportData>>
{
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public ReportRetriever(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getReportRetrieverAddress());
   }
   
   // --------------------------------------------------------------------------
   // Retriever Members
   // --------------------------------------------------------------------------
   
   @Override
   protected List<ReportData> parseText(String rawText)
   {
      JsArray<ReportData> reportDatas = asArrayOfReportData(rawText);

      List<ReportData> reports = new ArrayList<ReportData>();
      for(int index = 0; index < reportDatas.length(); index++)
      {
         ReportData reportData = reportDatas.get(index);

         reports.add(reportData);
      }
      
      return reports;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private final native JsArray<ReportData> asArrayOfReportData(String json) 
   /*-{
      return eval(json);
   }-*/;
}
