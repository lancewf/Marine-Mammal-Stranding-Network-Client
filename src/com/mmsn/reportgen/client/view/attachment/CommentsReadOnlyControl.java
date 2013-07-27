package com.mmsn.reportgen.client.view.attachment;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.data.attachment.Attachment;

public class CommentsReadOnlyControl extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private static final String COMMENTS_WARNING = "Add Comments Here"; 
   private Attachment attachment;
   private Label readOnlyText;
   private TextArea writableText;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public CommentsReadOnlyControl(Attachment attachment)
   {
      this.attachment = attachment;
      
      writableText = createWritableArea();
      
      writableText.addFocusHandler(new FocusHandler(){

  		@Override
  		public void onFocus(FocusEvent event) {
  			if(writableText.getText() != null && 
  					writableText.getText().equals(COMMENTS_WARNING))
  			{
  				writableText.setText("");
  			}
  		}});
      
      String comments = "bad image. please delete and try again.";
      if(attachment.getComments() != null){
    	  comments = attachment.getComments();
      }
      readOnlyText = new Label(comments);
      
      add(writableText);
      add(readOnlyText);
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setReadOnly(boolean readOnly)
   {
      writableText.setVisible(!readOnly);
      readOnlyText.setVisible(readOnly);
      
		if(readOnly)
		{
			if(writableText.getText() != null && writableText.getText().equals(COMMENTS_WARNING))
			{
				writableText.setText("");
			}
		}
		else
		{
			if(writableText.getText() != null && writableText.getText().length() == 0)
			{
				writableText.setText(COMMENTS_WARNING);
			}
		}
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private void textChanged()
   {
      attachment.setComments(writableText.getText());
      
      readOnlyText.setText(writableText.getText());
   }
   
   private TextArea createWritableArea()
   {
      TextArea text = new TextArea();
      
      text.setWidth("400px");
      
      if(attachment.getComments() == null ||
    		  attachment.getComments().length() == 0)
      {
    	  text.setText(COMMENTS_WARNING);
      }
      else
      {
    	  text.setText(attachment.getComments());
      }
      
      text.setVisible(false);
      
      text.addChangeHandler(new ChangeHandler()
      {
         @Override
         public void onChange(ChangeEvent event)
         {
            textChanged();
         }
      });
      
      return text;
   }
}
