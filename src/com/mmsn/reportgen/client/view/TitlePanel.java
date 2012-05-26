package com.mmsn.reportgen.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.mmsn.reportgen.client.view.images.MMSNClientBundle;

public class TitlePanel extends HorizontalPanel
{

   public TitlePanel()
   {
      setStyleName("titlepanel");
      
      setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
      
      MMSNClientBundle mmsnImageBundle = (MMSNClientBundle) GWT
      .create(MMSNClientBundle.class);
      
      ImageResource titleImageResource = mmsnImageBundle.titleIcon();

      Image titleImage = new Image(titleImageResource);

      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      
      add(titleImage);
      
      ImageResource dorsalsImageResource = mmsnImageBundle.dorsalsIcon();

      Image dorsalsImage = new Image(dorsalsImageResource);
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
      
      add(dorsalsImage);
   }
   
}
