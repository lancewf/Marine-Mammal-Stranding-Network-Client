package com.mmsn.reportgen.client.view.report;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.data.attachment.Attachment;
import com.mmsn.reportgen.client.data.attachment.AttachmentList;

public class ReportAttachmentPrintView extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private FlexTable flexTable;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportAttachmentPrintView()
   {
      initialize();
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setAttachments(AttachmentList attachmentList)
   {
      int index = 1;
      for(Attachment attachment : attachmentList.getAttachments())
      {
    	 String filename = "not found";
    	 if(attachment.getFileName() != null){
    		 filename = attachment.getFileName();
    	 }
         Label name = new Label(filename);
         name.addStyleName("printLabel");
         flexTable.setWidget(index,0, name);
         
         String comments = "bad attachment";
         if(attachment.getComments() != null){
        	 comments = attachment.getComments();
         }
         Label commentsLabel = new Label(comments);
         name.addStyleName("printField");
         flexTable.setWidget(index,1, commentsLabel);
         
         index++;
      }
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {
      addStyleName("printPage");
      
      add(new HTML("<h4>Attachments</h4>"));
      
      flexTable = new FlexTable();
      
      add(flexTable);
   }
}
