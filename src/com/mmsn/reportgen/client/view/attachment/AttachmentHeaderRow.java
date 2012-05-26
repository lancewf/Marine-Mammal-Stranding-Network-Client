package com.mmsn.reportgen.client.view.attachment;

import com.finfrock.client.Column;
import com.finfrock.client.CommonColumn;
import com.finfrock.client.Row;

public class AttachmentHeaderRow extends Row
{
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public AttachmentHeaderRow()
   {
//      addColumn(createNameColumn());
//      addColumn(createDownloadColumn());
//      addColumn(createCommentsColumn());
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private Column createDeleteColumn()
   {
      CommonColumn column = new CommonColumn();

      column.setValue("Delete");
      column.setStyleName("tableHeader");
      column.setIndex(AttachmentRow.DELETE_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }

   private Column createCommentsColumn()
   {
      CommonColumn column = new CommonColumn();

      column.setValue("Comments");
      column.setStyleName("tableHeader");
      column.setIndex(AttachmentRow.COMMENTS_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }

   private Column createNameColumn()
   {
      CommonColumn column = new CommonColumn();

      column.setValue("Name");
      column.setStyleName("tableHeader");
      column.setIndex(AttachmentRow.NAME_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
}
