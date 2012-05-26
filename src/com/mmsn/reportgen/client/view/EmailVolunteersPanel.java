package com.mmsn.reportgen.client.view;

import com.finfrock.client.Returnable;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.connection.EmailSender;

public class EmailVolunteersPanel extends VerticalPanel implements Panel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private WidgetFactory widgetFactory;
   private EmailSender emailSender;
   private TextArea messageTextArea;
   private TextBox subjectTextBox;
   private Label messageLabel;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public EmailVolunteersPanel(WidgetFactory widgetFactory, 
                               EmailSender emailSender)
   {
      this.widgetFactory = widgetFactory;
      this.emailSender = emailSender;
      
      initialize();
   }

   // --------------------------------------------------------------------------
   // Panel Members
   // --------------------------------------------------------------------------
   
   @Override
   public String getPanelName()
   {
      return "Email";
   }

   @Override
   public Widget getToolbar()
   {
      return widgetFactory.getNavigationToolbar();
   }

   @Override
   public Widget getWidget()
   {
      return this;
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {
      addStyleName("viewpanelItem");
      
      setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      VerticalPanel panel = new VerticalPanel();
      
      panel.addStyleName("viewpanelFolder");

      messageLabel = new Label();
      
      messageLabel.setStyleName("messageMessage");
      
      panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      panel.add(messageLabel);
      
      panel.add(createSubject());
      
      panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      panel.add(new Label("Message:"));
      panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      messageTextArea = new TextArea();
      messageTextArea.setWidth("500px");
      messageTextArea.setHeight("200px");
      panel.add(messageTextArea);
      
      panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      Button sendButton = new Button("Send");
      
      sendButton.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            emailSender.setMessage(messageTextArea.getText());
            emailSender.setSubject(subjectTextBox.getText());
            
            emailSender.send();
            
            messageLabel.setText("Sending...");
            emailSender.addReturnableListener(new Returnable<Boolean>()
            {
               @Override
               public void returned(Boolean sentCompelete)
               {
                  if(sentCompelete)
                  {
                     messageLabel.setText("Message Sent");
                  }
                  else
                  {
                     messageLabel.setText("Error in sending message");
                  }
                  
                  Timer t = new Timer() 
                  {
                    public void run() 
                    {
                       messageLabel.setText("");
                    }
                  };
                  
                  // Schedule the timer to run every 1 minutes.
                  t.schedule(10000);
               }
            });
            
            messageTextArea.setText("");
            subjectTextBox.setText("");
         }
      });
      
      panel.add(sendButton);
      
      add(new Label("This form sends an email message to all the volunteers."));
      
      add(panel);
   }
   
   private Widget createSubject()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
      panel.add(new Label("Subject:"));
      panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      subjectTextBox = new TextBox();
      
      subjectTextBox.setWidth("450px");
      panel.add(subjectTextBox);
      
      return panel;
   }
}
