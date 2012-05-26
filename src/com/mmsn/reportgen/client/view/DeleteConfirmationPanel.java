package com.mmsn.reportgen.client.view;

import java.util.ArrayList;
import java.util.List;

import com.finfrock.client.DataChangeListener;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.view.toolbars.NullToolbar;

public class DeleteConfirmationPanel extends DockPanel implements Panel
{
   // --------------------------------------------------------------------------
   // Public Static Data
   // --------------------------------------------------------------------------

   public static final int NO = 0;
   public static final int YES = 1;
   public static final int NO_ANWSER = 3;
   
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private Label textLabel;
   private int reponse = NO_ANWSER;
   private List<DataChangeListener> dataChangeListeners = 
      new ArrayList<DataChangeListener>();
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public DeleteConfirmationPanel()
   {  
      addStyleName("viewpanelItem");
      
      setVerticalAlignment(ALIGN_MIDDLE);
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      VerticalPanel innerPanel = createInnerPanel();
      
      add(innerPanel, DockPanel.CENTER);
   }

   // --------------------------------------------------------------------------
   // Panel Members
   // --------------------------------------------------------------------------
   
   @Override
   public String getPanelName()
   {
      return "DeleteConfirmationPanel";
   }

   @Override
   public Widget getWidget()
   {
      return this;
   }
   
   @Override
   public Widget getToolbar()
   {
      return new NullToolbar();
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setText(String text)
   {
      textLabel.setText(text);
   }
   
   public int getReponse()
   {
      return reponse;
   }
   
   public void addDataChangeListener(DataChangeListener dataChangeListener)
   {
      dataChangeListeners.add(dataChangeListener);
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private VerticalPanel createInnerPanel()
   {
      VerticalPanel panel = new VerticalPanel();
      
      Widget buttonPanel = createButtonPanel();
      
      panel.addStyleName("deleteConfimationPanel");
      panel.setVerticalAlignment(ALIGN_MIDDLE);
      panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      textLabel = new Label("Do you want to delete?");
      
      panel.add(textLabel);
      panel.add(buttonPanel);
      
      return panel;
   }

   private HorizontalPanel createButtonPanel()
   {
      HorizontalPanel buttonPanel = new HorizontalPanel();
      
      Button yesButton = new Button("Yes");
      Button noButton = new Button("No");
      
      yesButton.setStyleName("buttonSpacing");
      noButton.setStyleName("buttonSpacing");
      
      buttonPanel.add(yesButton);
      buttonPanel.add(noButton);
      
      yesButton.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            reponse = YES;
            
            dataChange();
         }
      });
      
      noButton.addClickHandler(new ClickHandler()
      {
         
         @Override
         public void onClick(ClickEvent event)
         {
            reponse = NO;
            
            dataChange();
         }
      });
      
      return buttonPanel;
   }
   
   private void dataChange()
   {
      for(DataChangeListener dataChangeListener : dataChangeListeners)
      {
         dataChangeListener.onDataChange();
      }
   }
}
