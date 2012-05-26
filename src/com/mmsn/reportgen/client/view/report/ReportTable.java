package com.mmsn.reportgen.client.view.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.finfrock.client.DataChangeListener;
import com.finfrock.client.Row;
import com.finfrock.client.Table;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.User;
import com.mmsn.reportgen.client.data.report.Report;
import com.mmsn.reportgen.client.data.report.ReportManagerable;
import com.mmsn.reportgen.client.data.report.ReportSortManager;

public class ReportTable extends Table
{

  // --------------------------------------------------------------------------
  // Private Instance Data
  // --------------------------------------------------------------------------
  
  private HashMap<Report, ReportRow> reportRowTable = 
     new HashMap<Report, ReportRow>();
  
  private ReportSortManager reportSorterManager;
  
  private ReportManagerable reportManager;
  
  private WidgetFactory widgetFactory;
  
  private User user;
  
  // --------------------------------------------------------------------------
  // Constructor
  // --------------------------------------------------------------------------

  public ReportTable(ReportManagerable reportManager, 
                     WidgetFactory widgetFactory, User user)
  {
     this.reportManager = reportManager;
     this.widgetFactory = widgetFactory;
     this.user = user;
     
     reportManager.addDataChangeListener(new DataChangeListener()
     {
        @Override
        public void onDataChange()
        {
           reportRowTable.clear();
           
           updateTable();
        }
     });
     
     reportSorterManager = new ReportSortManager(reportManager);
     
     reportSorterManager.addDataChangeListener(new DataChangeListener()
     {
        @Override
        public void onDataChange()
        {
           updateTable();
        }
     });
     
     updateTable();
  }

  // --------------------------------------------------------------------------
  // Table Members
  // --------------------------------------------------------------------------
  
  @Override
  protected void columnHeaderClicked(int column)
  {
     if (column == ReportRow.DATE_TIME_INDEX)
     {
        reportSorterManager.setSortBy(ReportSortManager.DATE_TIME);
     }
     else if (column == ReportRow.LOCATION_INDEX)
     {
        reportSorterManager.setSortBy(ReportSortManager.LOCATION);
     }
     else if (column == ReportRow.WRITTEN_BY_INDEX)
     {
        reportSorterManager.setSortBy(ReportSortManager.WRITTEN_BY);
     }
     else if (column == ReportRow.SPECIES_INDEX)
     {
        reportSorterManager.setSortBy(ReportSortManager.SPECIES);
     }
  }
  
  @Override
  protected Row getHeaderRow()
  {
     return new ReportHeaderRow(user);
  }

  @Override
  protected List<Row> getRows()
  {
     List<Row> reportRows = new ArrayList<Row>();
     
     for(Report report : 
        reportSorterManager.getReports())
     {
       ReportRow reportRow = getRow(report);
        
       reportRows.add(reportRow);
     }
     
     return reportRows;
  }

  // --------------------------------------------------------------------------
  // Private Members
  // --------------------------------------------------------------------------

  private ReportRow getRow(Report report)
  {
    ReportRow reportRow = 
      reportRowTable.get(report);
     
     if(reportRow == null)
     {
       reportRow = new ReportRow(report, reportManager, widgetFactory, user);
        
        reportRowTable.put(report, reportRow);
     }
     
     return reportRow;
  }

}
