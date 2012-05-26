package com.mmsn.reportgen.client.view.toolbars;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.finfrock.client.DataChangeListener;
import com.finfrock.client.Returnable;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.view.DeleteConfirmationPanel;
import com.mmsn.reportgen.client.view.ViewPanel;

public class NavigationToolbar extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Button logoutButton;
   
   private HorizontalPanel leftPanel;
   private HorizontalPanel rightPanel;
   
   private ViewPanel viewPanel;
   private WidgetFactory widgetFactory;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public NavigationToolbar(ViewPanel viewPanel, WidgetFactory widgetFactory)
   {
      this.viewPanel = viewPanel;
      this.widgetFactory = widgetFactory;
      
      initialize();
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void addButton(String name, final Returnable<Object> returnable)
   {
      final Button button = new Button(name);
      
      button.addStyleName("toolbarbutton");
      
      button.addSelectionListener(new SelectionListener<ButtonEvent>()
      {
         @Override
         public void componentSelected(ButtonEvent ce)
         {
            returnable.returned(button);
         }
      });

      leftPanel.add(button);
   }
   
   protected boolean isEditing()
   {
      return false;
   }
   
   protected void save()
   {
      
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {
      setStyleName("toolbar");
      
      HorizontalPanel mainToolbarPanel = new HorizontalPanel();
      
      mainToolbarPanel.setStyleName("toolbar");
      
      leftPanel = new HorizontalPanel();
      
      leftPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      
      rightPanel = new HorizontalPanel();
      
      rightPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
      
      mainToolbarPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      mainToolbarPanel.add(leftPanel);

      mainToolbarPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
      mainToolbarPanel.add(rightPanel);
      
      logoutButton = new Button("Log out");
      
      logoutButton.addStyleName("toolbarbutton");
      
      logoutButton.addSelectionListener(new SelectionListener<ButtonEvent>()
      {
         @Override
         public void componentSelected(ButtonEvent ce)
         {
            logoutButtonClicked();
         }     
      });

      rightPanel.add(logoutButton);
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      add(new NavigationButton(viewPanel)
      {
         protected void panelLinkSeleted(String panelName)
         {
            backButtonClicked(panelName);
         }
      });
      
      add(mainToolbarPanel);
   }
   
   private void backButtonClicked(final String panelName)
   {
      final ViewPanel viewPanel = widgetFactory.getViewPanel();

      if (isEditing())
      {
         final DeleteConfirmationPanel deleteConfirmationPanel = new DeleteConfirmationPanel();

         deleteConfirmationPanel
            .setText("Would you like to save changes made?");

         viewPanel.show(deleteConfirmationPanel);

         deleteConfirmationPanel.addDataChangeListener(new DataChangeListener()
         {
            @Override
            public void onDataChange()
            {
               if (deleteConfirmationPanel.getReponse() == 
                  DeleteConfirmationPanel.YES)
               {
                  save();
               }

               viewPanel.showPreivous(panelName);
            }
         });
      }
      else
      {
         viewPanel.showPreivous(panelName);
      }
   }
   
   private void logoutButtonClicked()
   {
      final ViewPanel viewPanel = widgetFactory.getViewPanel();

      if (isEditing())
      {
         final DeleteConfirmationPanel deleteConfirmationPanel = new DeleteConfirmationPanel();

         deleteConfirmationPanel
            .setText("Would you like to save changes made?");

         viewPanel.show(deleteConfirmationPanel);

         deleteConfirmationPanel.addDataChangeListener(new DataChangeListener()
         {
            @Override
            public void onDataChange()
            {
               if (deleteConfirmationPanel.getReponse() == DeleteConfirmationPanel.YES)
               {
                  save();
               }
               else if (deleteConfirmationPanel.getReponse() == DeleteConfirmationPanel.NO)
               {
                  // do nothing
               }

               Window.Location.reload();
            }
         });
      }
      else
      {
         Window.Location.reload();
      }
   }
}
