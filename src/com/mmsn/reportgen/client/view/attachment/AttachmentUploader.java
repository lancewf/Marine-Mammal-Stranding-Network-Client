package com.mmsn.reportgen.client.view.attachment;

import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.data.attachment.Attachment;
import com.mmsn.reportgen.client.data.attachment.AttachmentManager;
import com.mmsn.reportgen.client.view.TimedMessageControl;
import com.mmsn.reportgen.client.view.images.MMSNClientBundle;

public class AttachmentUploader extends FormPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private AttachmentManager attachmentManager;
   private Image loadingImage;
   private FileUploadField upload;
   private Button submitButton;
   private TimedMessageControl fileUploadedControl;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public AttachmentUploader(ServiceLocations serviceLocations, 
                             AttachmentManager attachmentManager)
   {
      this.attachmentManager = attachmentManager;
      setAction(serviceLocations.getPhotoUploadAddress());
      setEncoding(FormPanel.ENCODING_MULTIPART);
      setMethod(FormPanel.METHOD_POST);

      initialize();
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {
      fileUploadedControl = new TimedMessageControl("Photo Uploaded", 5);
      
      MMSNClientBundle mmsnImageBundle = (MMSNClientBundle) GWT
      .create(MMSNClientBundle.class);
      
      ImageResource loadingImageResource = mmsnImageBundle.loadingIcon();

      loadingImage = new Image(loadingImageResource);
      
      loadingImage.setVisible(false);
      
      VerticalPanel panel = new VerticalPanel();
      
      HorizontalPanel holder = new HorizontalPanel();

      upload = new FileUploadField();
      upload.setName("userfile");
      upload.setWidth("300px");
      submitButton = new Button();
      
      submitButton.setText("Upload");
      panel.add(new Label("Select Browse to locate and select photo."));
      panel.add(new Label("You must select Upload to attach the photo."));
      
      panel.add(fileUploadedControl);
      panel.add(loadingImage);
      holder.add(upload);
      holder.add(submitButton);
      
      submitButton.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            loadingImage.setVisible(true);
            submit();
         }
      });
      
      addSubmitCompleteHandler(new SubmitCompleteHandler()
      {
         @Override
         public void onSubmitComplete(SubmitCompleteEvent event)
         {
            loadingImage.setVisible(false);
            String filename = event.getResults();
            
            //This is done only for chrom browser
            int end = filename.indexOf("<div");
            
            if(end > 0)
            {
               filename = filename.substring(0, end);
            }

            if(filename.equals("ERROR"))
            {
               Window.alert("Error Uploading File");
            }
            else
            {
               Attachment attachment = attachmentManager.creatAttachment();
            
               attachment.setFileName(filename);
               
               attachment.setComments("");
            
               attachmentManager.add(attachment);
               
               fileUploadedControl.showMessage();
            }
         }
      });

      panel.add(holder);
      
      add(panel);
   }
}
