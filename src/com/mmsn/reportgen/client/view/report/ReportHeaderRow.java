package com.mmsn.reportgen.client.view.report;

import com.finfrock.client.Column;
import com.finfrock.client.CommonColumn;
import com.finfrock.client.Row;
import com.mmsn.reportgen.client.data.User;

public class ReportHeaderRow extends Row
{
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportHeaderRow(User user)
   {
      addColumn(createViewColumn());
      addColumn(createDateTimeColumn());
      addColumn(createResponderColumn());
      addColumn(createSpeciesColumn());
      addColumn(createLocationColumn());
      
      if(user.isAdmin())
      {
         addColumn(createDeleteColumn());
      }
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private Column createDeleteColumn()
   {
      CommonColumn column = new CommonColumn();

      column.setValue("Delete");
      column.setStyleName("tableHeader");
      column.setIndex(ReportRow.DELETE_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createViewColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue("View");
      column.setStyleName("tableHeader");
      column.setIndex(ReportRow.VIEW_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createLocationColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue("Location");
      column.setStyleName("sortableTableHeader");
      column.setIndex(ReportRow.LOCATION_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }

   private Column createSpeciesColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue("Species");
      column.setStyleName("sortableTableHeader");
      column.setIndex(ReportRow.SPECIES_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }

   private Column createResponderColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue("Written By");
      column.setStyleName("sortableTableHeader");
      column.setIndex(ReportRow.WRITTEN_BY_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }

   private Column createDateTimeColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue("Date/Time");
      column.setStyleName("sortableTableHeader");
      column.setIndex(ReportRow.DATE_TIME_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
}
