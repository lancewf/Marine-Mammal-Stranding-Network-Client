package com.mmsn.reportgen.client.view;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TimedMessageControl extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Instrance Data
   // --------------------------------------------------------------------------

   private Label messageLabel;
   private double secondsShown;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public TimedMessageControl(String message, double secondsShown)
   {
      messageLabel = new Label(message);
      this.secondsShown = secondsShown;
      
      messageLabel.setVisible(false);
      
      setStyleName("timedMessage");
      
      add(messageLabel);
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void showMessage()
   {
      messageLabel.setVisible(true);
      Timer timer = new Timer()
      {
         @Override
         public void run()
         {
            messageLabel.setVisible(false);
         }
      };
     
      timer.schedule((int)(secondsShown*1000));
   }
}
