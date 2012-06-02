package com.mmsn.reportgen.client.view.attachment;

import com.finfrock.client.Column;
import com.finfrock.client.CommonColumn;
import com.finfrock.client.DataChangeListener;
import com.finfrock.client.Row;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Image;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.attachment.Attachment;
import com.mmsn.reportgen.client.data.attachment.AttachmentManager;
import com.mmsn.reportgen.client.view.DeleteConfirmationPanel;
import com.mmsn.reportgen.client.view.ViewPanel;

public class AttachmentRow extends Row
{
   // --------------------------------------------------------------------------
   // Public Static Data
   // --------------------------------------------------------------------------
   
   private static String ATTACHMENT_FOLDER = "uploads";
   public static final int PREVIEW_INDEX = 4;
   public static final int DELETE_INDEX = 3;
   public static final int COMMENTS_INDEX = 2;
   public static final int NAME_INDEX = 1;

   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private ServiceLocations serviceLocations;
   private Anchor removeAnchor;
   private Attachment attachment;
   private Image image;
   private AttachmentManager attachmentManager;
   private CommentsReadOnlyControl commentsReadOnlyControl;
   private WidgetFactory widgetFactory;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public AttachmentRow(WidgetFactory widgetFactory, Attachment attachment,
         AttachmentManager attachmentManager, 
         ServiceLocations serviceLocations)
   {
      this.attachment = attachment;
      this.attachmentManager = attachmentManager;
      this.serviceLocations = serviceLocations;
      this.widgetFactory = widgetFactory;
      
      addColumn(createNameColumn());
      addColumn(createCommentsColumn());
      addColumn(createPreviewColumn());
      addColumn(createDeleteColumn());
   }

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setReadOnly(boolean readOnly)
   {
      removeAnchor.setVisible(!readOnly);
      commentsReadOnlyControl.setReadOnly(readOnly);
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private Column createPreviewColumn(){
	   CommonColumn column = new CommonColumn();
	   
	   image = new Image();
	   
	   image.setWidth("240px");
	   image.setHeight("160px");
	   String encodedFile = URL.encodeQueryString(attachment.getFileName());
	   image.setUrl(serviceLocations.getBaseUrl() + ATTACHMENT_FOLDER + 
  	         "/" + encodedFile);
	   
	   column.setValue(image);
	   column.setIndex(PREVIEW_INDEX);
	   column.setValueType(Column.WIDGET_COLUMN_TYPE);
	   return column;
   }
   
   private Column createDeleteColumn()
   {
      CommonColumn column = new CommonColumn();
      
      removeAnchor = new Anchor("[remove]");
      
      removeAnchor.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            deleteAttachment();
         }
      });
      
      removeAnchor.setVisible(false);
      
      column.setValue(removeAnchor);
      column.setIndex(DELETE_INDEX);
      column.setValueType(Column.WIDGET_COLUMN_TYPE);
      
      return column;
   }
   
   private void deleteAttachment()
   {
      final ViewPanel viewPanel = widgetFactory.getViewPanel();
      
      final DeleteConfirmationPanel deleteConfirmationPanel = 
         new DeleteConfirmationPanel();
      
      deleteConfirmationPanel.setText("Are you sure you would like to delete '" +
         attachment.getFileName() + "' Attachment?");
      
      viewPanel.show(deleteConfirmationPanel);
      
      deleteConfirmationPanel.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            if(deleteConfirmationPanel.getReponse() == DeleteConfirmationPanel.YES)
            {
               attachmentManager.remove(attachment);
               
               viewPanel.showPreivous();
            }
            else if(deleteConfirmationPanel.getReponse() == 
               DeleteConfirmationPanel.NO)
            {
               viewPanel.showPreivous();
            }
         }
      });
   }

   private Column createCommentsColumn()
   {
      CommonColumn column = new CommonColumn();
      
      commentsReadOnlyControl = 
         new CommentsReadOnlyControl(attachment);
      
      column.setValue(commentsReadOnlyControl);
      column.setIndex(COMMENTS_INDEX);
      column.setValueType(Column.WIDGET_COLUMN_TYPE);
      
      return column;
   }

   private Column createNameColumn()
   {
      CommonColumn column = new CommonColumn();
      
      String encodedFile = URL.encodeQueryString(attachment.getFileName());
      
      Anchor anchor = new Anchor(attachment.getFileName(), 
    		  serviceLocations.getBaseUrl() + ATTACHMENT_FOLDER + 
    	         "/" + encodedFile, "_blank");
      
      column.setValue(anchor);
      column.setIndex(NAME_INDEX);
      column.setValueType(Column.WIDGET_COLUMN_TYPE);
      
      return column;
   }
}
