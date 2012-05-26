package com.mmsn.reportgen.client.view.images;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface MMSNClientBundle extends ClientBundle
{
   /**
    * The Report icon
    */
   @Source("reports-icon.png")
   public ImageResource reportIcon();
   

   @Source("delete-icon.png")
   public ImageResource deleteIcon();
   

   @Source("Edit-icon.png")
   public ImageResource editIcon();
   

   @Source("calendar-icon.png")
   public ImageResource calendarIcon();
   

   @Source("title.png")
   public ImageResource titleIcon();
   

   @Source("dorsals.gif")
   public ImageResource dorsalsIcon();
   
   @Source("loading.gif")
   public ImageResource loadingIcon();
}
