package com.mmsn.reportgen.client.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.finfrock.client.DataChangeListener;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.WidgetFactory;
import com.google.gwt.event.shared.GwtEvent.Type;

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
   private int moveBackCount = 0;
   private boolean checkEditing = true;
   private boolean inConfirmationMode = false;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public ViewPanel(WidgetFactory widgetFactory)
   {
      addStyleName("viewpanel");
      setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      

      History.addValueChangeHandler(new ValueChangeHandler<String>()
      {
         @Override
         public void onValueChange(ValueChangeEvent<String> event)
         {
             final String token = event.getValue();
             consoleLog("token: " + token + " moveback count: " + moveBackCount + " checkEditing: " + checkEditing);
             if(inConfirmationMode){
                 History.newItem(currentPanel.getPanelName(), false);
             } else if(moveBackCount == 0 && checkEditing && currentPanel != null && currentPanel.isEditing()){
                 final DeleteConfirmationPanel deleteConfirmationPanel = new DeleteConfirmationPanel();

                 deleteConfirmationPanel
                    .setText("You have unsaved changes. Would you like to return to your page and save these changes?");
                 inConfirmationMode = true;
                 History.newItem(currentPanel.getPanelName(), false);
                 show(deleteConfirmationPanel);
                 
                 deleteConfirmationPanel.addDataChangeListener(new DataChangeListener() {
                    @Override
                    public void onDataChange()
                    {
                       if (deleteConfirmationPanel.getReponse() == 
                          DeleteConfirmationPanel.YES)
                       {
                          inConfirmationMode = false;
                          deleteConfirmationPanel.setIsEditing(false);
                          showPreivous();
                       }else {
                          inConfirmationMode = false;
                          deleteConfirmationPanel.setIsEditing(false);
                          checkEditing = false;
                          moveBackCount = 1;
                          History.back();
                       }
                    }
                 });
             } else{
                 
                showPreivousWithToken(token);
                if(moveBackCount > 0){
                    moveBackCount--;
                    History.back();
                } else{
                   checkEditing = true;
                }
             }
         }
      });
      
      toolbarContainer = new ToolbarContainer(this, widgetFactory);
      
      add(toolbarContainer);
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void showPreivous(){
      History.back();
   }

   public void showPreivousWithToken(String token)
   {
      if (!widgetStack.isEmpty())
      {
         Panel current = widgetStack.pop();

         if (!widgetStack.isEmpty()) {
            Panel preivousPanel = widgetStack.pop();
            if (preivousPanel != null)
            {
               show(preivousPanel, token );
            }
         }
         else
         {
            widgetStack.push(current);
         }
      }
   }

  native void consoleLog( String message) /*-{
      console.log( "me:" + message );
  }-*/;

   public void showPreivous(String panelName) {
       if(!currentPanel.getPanelName().equals(panelName)){
           moveBackCount = findHowManyPanelBack(panelName);
           if(moveBackCount > 0){
               moveBackCount--;
               History.back();
           }
       }
   }

  private int findHowManyPanelBack(String panelName){
     
      Stack<Panel> tempStack = new Stack<Panel>();
      int count = 0;
      Panel current = widgetStack.pop();
      tempStack.push(current);
      while(!current.getPanelName().equals(panelName)) {
         current = widgetStack.pop();
         tempStack.push(current);
         count++;
      }

      while(!tempStack.isEmpty()){
        current = tempStack.pop();
        widgetStack.push(current);
      }
      
      return count;
  }

   public void show(Panel panel, String item)
   {
       item = item.replace(" ", "_");
      if(currentPanel != null)
      {
         removePanel(currentPanel);
      }
      
      History.newItem(item, false);

      widgetStack.push(panel);
      addPanel(panel);

      currentPanel = panel;
      
      dataChanged();
   }
   
   public void show(Panel panel)
   {
      show(panel, panel.getPanelName());
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
