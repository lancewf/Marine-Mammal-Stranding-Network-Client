package com.mmsn.reportgen.client.view.volunteerhours;

import com.finfrock.client.Column;
import com.finfrock.client.CommonColumn;
import com.finfrock.client.Row;

public class VolunteerHoursHeaderRow extends Row
{
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public VolunteerHoursHeaderRow()
   {
      addColumn(createViewColumn());
      addColumn(createTotalTimeColumn());
      addColumn(createMilesColumn());
      addColumn(createDeleteColumn());
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private Column createViewColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue("View");
      column.setStyleName("tableHeader");
      column.setIndex(VolunteerHoursRow.VIEW_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createMilesColumn()
   {
      CommonColumn column = new CommonColumn();

      column.setValue("Miles");
      column.setStyleName("sortableTableHeader");
      column.setIndex(VolunteerHoursRow.MILES_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createTotalTimeColumn()
   {
      CommonColumn column = new CommonColumn();

      column.setValue("Total Time");
      column.setStyleName("sortableTableHeader");
      column.setIndex(VolunteerHoursRow.TOTAL_TIME_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createDeleteColumn()
   {
      CommonColumn column = new CommonColumn();

      column.setValue("Delete");
      column.setStyleName("tableHeader");
      column.setIndex(VolunteerHoursRow.DELETE_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
}
