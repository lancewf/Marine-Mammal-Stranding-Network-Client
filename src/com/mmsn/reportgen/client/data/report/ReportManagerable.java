package com.mmsn.reportgen.client.data.report;

import java.util.List;

import com.finfrock.client.DataChangeListener;

public interface ReportManagerable
{

   List<Report> getReports();

   void addDataChangeListener(DataChangeListener dataChangeListener);

   Report createNewReport();

   void saveReport(Report report);

   void removeReport(Report report);

}