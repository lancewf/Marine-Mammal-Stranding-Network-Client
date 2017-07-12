package com.mmsn.reportgen.client.view.toolbars;

import java.util.List;

import com.finfrock.client.DataChangeListener;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.mmsn.reportgen.client.view.Panel;
import com.mmsn.reportgen.client.view.ViewPanel;

public class NavigationButton extends HorizontalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private ViewPanel viewPanel;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public NavigationButton(ViewPanel viewPanel)
   {
      this.viewPanel = viewPanel;
      
      initialize();
   }

   // --------------------------------------------------------------------------
   // Protected Members
   // --------------------------------------------------------------------------

   protected void panelLinkSeleted(String panelName)
   {
      viewPanel.showPreivous(panelName);
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private void initialize()
   {
      viewPanel.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            clear();
            List<Panel> panels = viewPanel.getPanelList();
            
            for(Panel panel : panels)
            {
               Anchor anchor = new Anchor(panel.getPanelName());
               
               anchor.addStyleName("navigationButton");
               
               anchor.addClickHandler(new ClickHandler()
               {
                  @Override
                  public void onClick(ClickEvent event)
                  {
                     String panelName = 
                        event.getRelativeElement().getInnerText();
                    
                     panelLinkSeleted(panelName);
                  }
               });
               Label label = new Label(" > ");
               label.addStyleName("navigationButton");
               
               add(anchor);
               add(label);
            }
         }
      });
   }
}
