package com.mmsn.reportgen.client.view;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TextAreaReadWrite extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Instance Data
   // --------------------------------------------------------------------------

   private HTML label;
   private TextArea textArea;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public TextAreaReadWrite(String text)
   {
      label = new HTML();
            
      textArea = new TextArea();
      textArea.setVisible(false);
      
      setText(text);
      
      add(label);
      add(textArea);
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void setText(String text)
   {
      textArea.setText(text);
      setReadOnlyText(text);
   }
   
   public String getText()
   {
      return textArea.getText();
   }
   
   public void setWidth(String width)
   {
      textArea.setWidth(width);
   }
   
   public void setHeight(String height)
   {
      textArea.setHeight(height);
   }
   
   public void setReadOnly(boolean readOnly)
   {
      setReadOnlyText(textArea.getText());
      
      textArea.setVisible(!readOnly);
      label.setVisible(readOnly);
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private void setReadOnlyText(String text)
   {
      text = text.replace("\n", "<br />");
      text = text.replace("  ", " &nbsp ");
      
      label.setHTML(text);
   }
   
}
