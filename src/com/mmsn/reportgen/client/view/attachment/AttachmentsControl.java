package com.mmsn.reportgen.client.view.attachment;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.attachment.Attachment;
import com.mmsn.reportgen.client.data.attachment.AttachmentList;
import com.mmsn.reportgen.client.data.attachment.AttachmentManager;

public class AttachmentsControl extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Public Data
   // --------------------------------------------------------------------------
   
   private AttachmentUploader photoUploader;
   private AttachmentTable attachmentTable;
   private AttachmentManager attachmentManager;
   private CheckBox isPhotoField;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public AttachmentsControl(ServiceLocations serviceLocations, 
                             WidgetFactory widgetFactory)
   {
      attachmentManager = new AttachmentManager();
      photoUploader = new AttachmentUploader(serviceLocations, attachmentManager);
      attachmentTable = new AttachmentTable(attachmentManager, serviceLocations, 
         widgetFactory);
      
      photoUploader.setVisible(false);
      isPhotoField = new CheckBox(); 
      
      FlexTable flexTable = new FlexTable();
      flexTable.setCellSpacing(10);
      flexTable.addStyleName("reportControlTable");
      
      flexTable.setText(1, 0 , "Photos Taken?:");
      flexTable.setWidget(1, 1, isPhotoField);
      
      add(new HTML("<h3>Attachments</h3>"));
      add(flexTable);
      add(photoUploader);
      add(attachmentTable);
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setIsPhotosTaken(boolean isPhotosTaken)
   {
      isPhotoField.setValue(isPhotosTaken);
   }
   
   public boolean getIsPhotosTaken()
   {
      return isPhotoField.getValue();
   }
   
   public void setReadOnly(boolean readOnly)
   {
      attachmentTable.setReadOnly(readOnly);
      photoUploader.setVisible(!readOnly);
      isPhotoField.setReadOnly(readOnly);
   }

   public AttachmentList getAttachments()
   {
      return attachmentManager.getAttachmentList();
   }

   public void setAttachments(AttachmentList originalAttachmentList)
   {
      AttachmentList copyiedAttachmentList = copyAttachments(originalAttachmentList);
      
      attachmentTable.clearData();
      
      attachmentManager.setAttachments(copyiedAttachmentList);
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private AttachmentList copyAttachments(AttachmentList originalAttachmentList)
   {
      List<Attachment> copyiedAttachments = new ArrayList<Attachment>();
      
      for(Attachment originalAttachment : originalAttachmentList.getAttachments())
      {
         Attachment attachment = new Attachment();
         
         attachment.setId(originalAttachment.getId());
         attachment.setComments(originalAttachment.getComments());
         attachment.setFileName(originalAttachment.getFileName());
         
         copyiedAttachments.add(attachment);
      }
      
      AttachmentList copyiedAttachmentList = new AttachmentList();
      
      copyiedAttachmentList.setAttachment(copyiedAttachments);
      
      return copyiedAttachmentList;
   }

}
