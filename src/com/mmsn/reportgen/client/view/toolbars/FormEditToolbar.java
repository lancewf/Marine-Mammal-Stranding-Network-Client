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
import com.mmsn.reportgen.client.view.FormEditControl;
import com.mmsn.reportgen.client.view.ViewPanel;

public abstract class FormEditToolbar extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Button editButton;

   private Button cancelButton;

   private Button saveButton;

   private NavigationButton navigation;
   
   private FormEditControl formEditControl;
   
   private WidgetFactory widgetFactory;

   private boolean isNewVolunteer;
   
   private HorizontalPanel leftPanel;
   private HorizontalPanel rightPanel;
   private Button logoutButton;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public FormEditToolbar(WidgetFactory widgetFactory, 
                          FormEditControl formEditControl)
   {
      this.widgetFactory = widgetFactory;
      this.formEditControl = formEditControl;
      
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
   
   public void setIsNew(boolean isNewVolunteer)
   {
      this.isNewVolunteer = isNewVolunteer;
      if(isNewVolunteer)
      {
         formEditControl.setReadOnly(false);
         editButton.setVisible(false);
         saveButton.setVisible(true);
         cancelButton.setVisible(true);
      }
      else
      {
         formEditControl.setReadOnly(true);
         editButton.setVisible(true);
         saveButton.setVisible(false);
         cancelButton.setVisible(false);
      }
   }
   
   // --------------------------------------------------------------------------
   // Protected abstract Members
   // --------------------------------------------------------------------------

   protected abstract void resetControl();
   protected abstract void save();
   
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
      
      formEditControl.setReadOnly(true);
      
      editButton = new Button("Edit");

      editButton.addStyleName("toolbarbutton");

      cancelButton = new Button("Cancel");

      cancelButton.addStyleName("toolbarbutton");

      cancelButton.setVisible(false);

      saveButton = new Button("Save");

      saveButton.addStyleName("toolbarbutton");

      saveButton.setVisible(false);

      navigation = new NavigationButton(widgetFactory.getViewPanel())
      {
         protected void panelLinkSeleted(String panelName)
         {
            backButtonClicked(panelName);
         }
      };

      cancelButton.addSelectionListener(new SelectionListener<ButtonEvent>()
      {
         @Override
         public void componentSelected(ButtonEvent ce)
         {
            cancelButtonClicked();
         }
      });

      saveButton.addSelectionListener(new SelectionListener<ButtonEvent>()
      {
         @Override
         public void componentSelected(ButtonEvent ce)
         {
            saveButtonClicked();
         }
      });

      editButton.addSelectionListener(new SelectionListener<ButtonEvent>()
      {
         @Override
         public void componentSelected(ButtonEvent ce)
         {
            editButtonClicked();
         }
      });

      leftPanel.add(saveButton);
      leftPanel.add(editButton);
      leftPanel.add(cancelButton);

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
      add(navigation);
      
      add(mainToolbarPanel);
   }
   
   private void editButtonClicked()
   {
      formEditControl.setReadOnly(false);

      editButton.setVisible(false);

      saveButton.setVisible(true);

      cancelButton.setVisible(true);
   }

   private boolean isEditing()
   {
      return saveButton.isVisible();
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

               editButton.setVisible(true);

               saveButton.setVisible(false);

               cancelButton.setVisible(false);

               Window.Location.reload();
            }
         });
      }
      else
      {
         editButton.setVisible(true);

         saveButton.setVisible(false);

         cancelButton.setVisible(false);

         Window.Location.reload();
      }
   }
   
   private void cancelButtonClicked()
   {
      final ViewPanel viewPanel = widgetFactory.getViewPanel();

      final DeleteConfirmationPanel deleteConfirmationPanel = new DeleteConfirmationPanel();

      deleteConfirmationPanel.setText("Would you like to save changes make?");

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
               if(!isNewVolunteer)
               {
                  resetControl();
               }
            }

            formEditControl.setReadOnly(true);

            editButton.setVisible(true);

            saveButton.setVisible(false);

            cancelButton.setVisible(false);

            viewPanel.showPreivous();
            
            if(isNewVolunteer)
            {
               viewPanel.showPreivous();
            }
         }
      });
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

               editButton.setVisible(true);

               saveButton.setVisible(false);

               cancelButton.setVisible(false);

               viewPanel.showPreivous(panelName);
            }
         });
      }
      else
      {
         editButton.setVisible(true);

         saveButton.setVisible(false);

         cancelButton.setVisible(false);
         
         viewPanel.showPreivous(panelName);
      }
   }

   private void saveButtonClicked()
   {
      formEditControl.setReadOnly(true);

      editButton.setVisible(true);

      saveButton.setVisible(false);

      cancelButton.setVisible(false);

      save();
   }
}
