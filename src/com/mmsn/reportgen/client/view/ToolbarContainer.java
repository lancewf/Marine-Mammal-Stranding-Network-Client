package com.mmsn.reportgen.client.view;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.view.toolbars.NavigationToolbar;

public class ToolbarContainer extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Instance Data
   // --------------------------------------------------------------------------

   private Widget defaultToolbar;
   private Widget currentToolbar;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public ToolbarContainer(ViewPanel viewPanel, WidgetFactory widgetFactory)
   {
      setStyleName("toolbar");
      
      defaultToolbar = new NavigationToolbar(viewPanel, widgetFactory);
      
      currentToolbar = defaultToolbar;
      
      add(defaultToolbar);
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void addToolbar(Widget toolbar)
   {
      remove(currentToolbar);
      add(toolbar);
      currentToolbar = toolbar;
   }
   
   public void clearToolbar()
   {
      addToolbar(defaultToolbar);
   }
}
