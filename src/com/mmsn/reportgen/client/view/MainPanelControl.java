package com.mmsn.reportgen.client.view;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;

public class MainPanelControl extends VerticalPanel
{

   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public MainPanelControl(WidgetFactory widgetFactory)
   {
      addStyleName("report");
      
      setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
      
      Widget splitPanel = initialize(widgetFactory);
      
      setHeight(Window.getClientHeight()*.8 + "px");
      
      add(splitPanel);
   }

   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private Widget initialize(WidgetFactory widgetFactory)
   {      
      return widgetFactory.getViewPanel();
   }
}
