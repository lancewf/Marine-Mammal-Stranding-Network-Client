package com.mmsn.reportgen.client.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.finfrock.client.DataChangeListener;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.WidgetFactory;

public class ViewPanel extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Panel currentPanel = null;
   private Stack<Panel> widgetStack = new Stack<Panel>();
   private ToolbarContainer toolbarContainer;
   private static String MARK = "MARK";
   private List<DataChangeListener> dataChangeListeners = 
      new ArrayList<DataChangeListener>();
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public ViewPanel(WidgetFactory widgetFactory)
   {
      addStyleName("viewpanel");
      
      String initToken = History.getToken();
      if (initToken.length() == 0) 
      {
        History.newItem(MARK);
      }
      
      History.addValueChangeHandler(new ValueChangeHandler<String>()
      {
         @Override
         public void onValueChange(ValueChangeEvent<String> event)
         {
            String token = event.getValue();
            
            if(token.equalsIgnoreCase(""))
            {
               final DeleteConfirmationPanel deleteConfirmationPanel = 
                  new DeleteConfirmationPanel();

               deleteConfirmationPanel
                  .setText("Using the back button will leave the MMSN site. " +
                  		"Would you like to leave the MMSN site?");

               show(deleteConfirmationPanel);

               deleteConfirmationPanel.addDataChangeListener(new DataChangeListener()
               {
                  @Override
                  public void onDataChange()
                  {
                     if (deleteConfirmationPanel.getReponse() == DeleteConfirmationPanel.YES)
                     {
                        History.back();
                     }
                     else if (deleteConfirmationPanel.getReponse() == DeleteConfirmationPanel.NO)
                     {
                        History.newItem(MARK);
                        showPreivous();
                     }
                  }
               });
            }
         }
      });
      
      toolbarContainer = new ToolbarContainer(this, widgetFactory);
      
      add(toolbarContainer);
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void showPreivous()
   {
      if (!widgetStack.isEmpty())
      {
         Panel current = widgetStack.pop();

         if (!widgetStack.isEmpty())
         {
            Panel preivousPanel = widgetStack.peek();
            if (preivousPanel != null)
            {
               widgetStack.pop();
               show(preivousPanel);
            }
         }
         else
         {
            widgetStack.push(current);
         }
      }
   }
   
   public void showPreivous(String panelName)
   {
      while(!currentPanel.getPanelName().equals(panelName))
      {
         showPreivous();
      }
   }
   
   public void show(Panel panel)
   {
      if(currentPanel != null)
      {
         removePanel(currentPanel);
      }
      
      widgetStack.push(panel);
      addPanel(panel);

      currentPanel = panel;
      
      dataChanged();
   }
   
   public void addDataChangeListener(DataChangeListener dataChangeListener)
   {
      dataChangeListeners.add(dataChangeListener);
   }
   
   public List<Panel> getPanelList()
   {
      List<Panel> panels = new ArrayList<Panel>(widgetStack);
      
      return panels;
   }
   
   // --------------------------------------------------------------------------
   // private Members
   // --------------------------------------------------------------------------

   private void dataChanged()
   {
      for(DataChangeListener dataChangeListener: dataChangeListeners)
      {
         dataChangeListener.onDataChange();
      }
   }
   
   private void removePanel(Panel panel)
   {
      remove(panel.getWidget());
   }
   
   private void addPanel(Panel panel)
   {
      toolbarContainer.addToolbar(panel.getToolbar());
      
      add(panel.getWidget());
   }
   
}
