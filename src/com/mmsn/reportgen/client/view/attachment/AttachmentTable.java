package com.mmsn.reportgen.client.view.attachment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.finfrock.client.DataChangeListener;
import com.finfrock.client.Row;
import com.finfrock.client.Table;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.attachment.Attachment;
import com.mmsn.reportgen.client.data.attachment.AttachmentManager;

public class AttachmentTable extends Table
{

   // --------------------------------------------------------------------------
   // Private Instance Data
   // --------------------------------------------------------------------------
   
   private HashMap<Attachment, AttachmentRow> attachmentRowTable = 
      new HashMap<Attachment, AttachmentRow>();
   
   private AttachmentManager attachmentManager;
   private ServiceLocations serviceLocations;
   private WidgetFactory widgetFactory;
   private boolean readOnly = true;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public AttachmentTable(AttachmentManager attachmentManager, 
                          ServiceLocations serviceLocations, 
                          WidgetFactory widgetFactory)
   {
      this.attachmentManager = attachmentManager;
      this.serviceLocations = serviceLocations;
      this.widgetFactory= widgetFactory;
      
      attachmentManager.addDataChangeListener(new DataChangeListener()
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
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setReadOnly(boolean readOnly)
   {
      this.readOnly = readOnly;
      for(Row row : getRows())
      {
         AttachmentRow attachmentRow = (AttachmentRow)row;
         
         attachmentRow.setReadOnly(readOnly);
      }
   }
   
   public void clearData()
   {
      attachmentRowTable.clear();
   }
   
   // --------------------------------------------------------------------------
   // Table Members
   // --------------------------------------------------------------------------
   
   @Override
   protected Row getHeaderRow()
   {
      return new AttachmentHeaderRow();
   }

   @Override
   protected List<Row> getRows()
   {
      List<Row> attachmentRows = new ArrayList<Row>();
      
      for(Attachment attachment : attachmentManager.getAttachments())
      {
         Row row = getRow(attachment);
         
         attachmentRows.add(row);
      }
      
      return attachmentRows;
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private Row getRow(Attachment attachment)
   {
      AttachmentRow attachmentRow = 
         attachmentRowTable.get(attachment);
      
      if(attachmentRow == null)
      {
         attachmentRow = new AttachmentRow(widgetFactory, attachment, 
            attachmentManager, serviceLocations);
         
         attachmentRow.setReadOnly(readOnly);
         
         attachmentRowTable.put(attachment, attachmentRow);
      }
      
      return attachmentRow;
   }

}
