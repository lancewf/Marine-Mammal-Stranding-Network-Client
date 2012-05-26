package com.mmsn.reportgen.client.data.attachment;

import java.util.ArrayList;
import java.util.List;

public class AttachmentList
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private List<Attachment> serverAttachments = new ArrayList<Attachment>();
   
   private List<Attachment> deletedAttachments = new ArrayList<Attachment>();
   
   private List<Attachment> addedAttachments = new ArrayList<Attachment>();
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public AttachmentList()
   {

   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public List<Attachment> getAttachments()
   {
      List<Attachment> attachments = new ArrayList<Attachment>();
      
      attachments.addAll(serverAttachments);
      attachments.addAll(addedAttachments);
      attachments.removeAll(deletedAttachments);
      
      return attachments;
   }
   
   public void deleteAttachment(Attachment attachment)
   {
      deletedAttachments.add(attachment);
   }
   
   public void addAttachment(Attachment attachment)
   {
      addedAttachments.add(attachment);
   }
   
   public void setAttachment(List<Attachment> attachments)
   {
      this.serverAttachments = attachments;
      
      deletedAttachments.clear();
      addedAttachments.clear();
   }

   public List<Attachment> getModifiedAttachments()
   {
      List<Attachment> attachments = new ArrayList<Attachment>();
      
      attachments.addAll(serverAttachments);
      attachments.removeAll(deletedAttachments);
      
      return attachments;
   }

   public List<Attachment> getDeletedAttachments()
   {
      return deletedAttachments;
   }

   public List<Attachment> getAddedAttachments()
   {
      List<Attachment> attachments = new ArrayList<Attachment>();
      
      attachments.addAll(addedAttachments);
      attachments.removeAll(deletedAttachments);
      
      return attachments;
   }

   public void saved()
   {
      serverAttachments.addAll(addedAttachments);
      serverAttachments.removeAll(deletedAttachments);
      
      deletedAttachments.clear();
      addedAttachments.clear();
   }
 
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
}
