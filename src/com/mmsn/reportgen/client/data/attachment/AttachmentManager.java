package com.mmsn.reportgen.client.data.attachment;

import java.util.ArrayList;
import java.util.List;

import com.finfrock.client.DataChangeListener;

public class AttachmentManager
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private AttachmentList attachmentList = new AttachmentList();
   
   private List<DataChangeListener> dataChangeListeners = 
      new ArrayList<DataChangeListener>();
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public AttachmentManager()
   {
      
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void addDataChangeListener(DataChangeListener dataChangeListener)
   {
      dataChangeListeners.add(dataChangeListener);
   }

   public void removeDataChangeListener(DataChangeListener dataChangeListener)
   {
      dataChangeListeners.remove(dataChangeListener);
   }
   
   public AttachmentList getAttachmentList()
   {
      return attachmentList;
   }
   
   public List<Attachment> getAttachments()
   {
      return attachmentList.getAttachments();
   }
   
   public void add(Attachment attachment)
   {
      attachmentList.addAttachment(attachment);
      
      dataChange();
   }

   public void remove(Attachment attachment)
   {
      attachmentList.deleteAttachment(attachment);
      
      dataChange();
   }
   
   public void setAttachments(AttachmentList attachmentList)
   {
      this.attachmentList = attachmentList;
      
      dataChange();
   }
   
   public Attachment creatAttachment()
   {
      Attachment attachment = new Attachment();
      
      attachment.setId(-1);
      attachment.setComments("");
      attachment.setFileName("");
      
      return attachment;
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void dataChange()
   {
      for(DataChangeListener dataChangeListener : dataChangeListeners)
      {
         dataChangeListener.onDataChange();
      }
   }
}
