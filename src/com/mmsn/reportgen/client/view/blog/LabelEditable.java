package com.mmsn.reportgen.client.view.blog;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LabelEditable extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Instance Data
   // --------------------------------------------------------------------------

   private Label label;
   private TextBox textbox;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public LabelEditable(String text)
   {
      label = new Label(text);
      
      textbox = new TextBox();
      textbox.setText(text);
      textbox.setVisible(false);
      
      add(label);
      add(textbox);
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setText(String text)
   {
      label.setText(text);
      textbox.setText(text);
   }
   
   public void setWidth(String width)
   {
      textbox.setWidth(width);
   }
   
   public void setReadOnly(boolean readOnly)
   {
      label.setText(textbox.getText());
      
      label.setVisible(readOnly);
      textbox.setVisible(!readOnly);
   }

   public String getText()
   {
      return textbox.getText();
   }
}
