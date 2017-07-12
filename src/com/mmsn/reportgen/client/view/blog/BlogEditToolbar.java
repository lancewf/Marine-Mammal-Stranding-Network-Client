package com.mmsn.reportgen.client.view.blog;

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

public abstract class BlogEditToolbar extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private Button editButton;

   private Button cancelButton;

   private Button saveButton;
   
   private Button deleteButton;
   
   private FormEditControl formEditControl;
   
   private WidgetFactory widgetFactory;
   
   private HorizontalPanel leftPanel;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public BlogEditToolbar(WidgetFactory widgetFactory, 
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
   
   public void editeMode()
   {
      formEditControl.setReadOnly(false);

      editButton.setVisible(false);

      saveButton.setVisible(true);

      cancelButton.setVisible(true);
      
      deleteButton.setVisible(true);
   }
   
   public void readOnlyMode()
   {
      formEditControl.setReadOnly(true);

      editButton.setVisible(true);

      saveButton.setVisible(false);

      cancelButton.setVisible(false);
      
      deleteButton.setVisible(false);
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
      
      mainToolbarPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      mainToolbarPanel.add(leftPanel);

      mainToolbarPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
      
      formEditControl.setReadOnly(true);
      
      editButton = new Button("Edit");

      editButton.addStyleName("toolbarbutton");

      cancelButton = new Button("Cancel");

      cancelButton.addStyleName("toolbarbutton");

      cancelButton.setVisible(false);

      saveButton = new Button("Save");

      saveButton.addStyleName("toolbarbutton");

      saveButton.setVisible(false);

      deleteButton = new Button("Delete");

      deleteButton.addStyleName("toolbarbutton");

      deleteButton.setVisible(false);
      
      cancelButton.addSelectionListener(new SelectionListener<ButtonEvent>()
      {
         @Override
         public void componentSelected(ButtonEvent ce)
         {
            cancelButtonClicked();
         }
      });

      deleteButton.addSelectionListener(new SelectionListener<ButtonEvent>()
      {
         @Override
         public void componentSelected(ButtonEvent ce)
         {
            deleteButtonClicked();
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
      leftPanel.add(deleteButton);

      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      
      add(mainToolbarPanel);
   }
   
   private void editButtonClicked()
   {
      editeMode();
   }
   
   private void cancelButtonClicked()
   {
      final ViewPanel viewPanel = widgetFactory.getViewPanel();

      final DeleteConfirmationPanel deleteConfirmationPanel = new DeleteConfirmationPanel();

      deleteConfirmationPanel.setText("Would you like to save changes made?");

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
               resetControl();
            }

            deleteConfirmationPanel.setIsEditing(false);
            readOnlyMode();

            viewPanel.showPreivous();
         }
      });
   }
   
   private void deleteButtonClicked()
   {
      final ViewPanel viewPanel = widgetFactory.getViewPanel();

      final DeleteConfirmationPanel deleteConfirmationPanel = new DeleteConfirmationPanel();

      deleteConfirmationPanel.setText("Are you sure you want to Delete it?");

      viewPanel.show(deleteConfirmationPanel);

      deleteConfirmationPanel.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            if (deleteConfirmationPanel.getReponse() == DeleteConfirmationPanel.YES)
            {
               delete();
            }
            else if (deleteConfirmationPanel.getReponse() == DeleteConfirmationPanel.NO)
            {
               
            }
            
            deleteConfirmationPanel.setIsEditing(false);
            viewPanel.showPreivous();
         }
      });
   }
   
   protected void delete()
   {

   }

   private void saveButtonClicked()
   {
      readOnlyMode();

      save();
   }
}
