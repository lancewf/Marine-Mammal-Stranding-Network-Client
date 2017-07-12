package com.mmsn.reportgen.client.view;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.finfrock.client.DataChangeListener;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginPanel extends DockPanel
{
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private boolean isSubmitted = false;
   private List<DataChangeListener> dataChangeListeners = 
      new ArrayList<DataChangeListener>();
   private ComboBox<StringModel> userComboBox;
   private TextField<String> passwordField;
   private Label errorLabel;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public LoginPanel()
   {
      initialize();
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   public boolean isSubmitted()
   {
      return isSubmitted;
   }
   
   public void addOnSubmitListener(DataChangeListener dataChangeListener)
   {
      dataChangeListeners.add(dataChangeListener);
   }
   
   public boolean isAdmin()
   {
      return userComboBox.getRawValue().equals("Administrator");
   }
   
   public boolean isVolunteer()
   {
      return userComboBox.getRawValue().equals("Volunteer");
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private void onSubmit()
   {
      isSubmitted = true;
      for(DataChangeListener dataChangeListener : dataChangeListeners)
      {
         dataChangeListener.onDataChange();
      }
   }
   
   private void initialize()
   {
      setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      FormPanel formPanel = new FormPanel();   
      formPanel.setBodyBorder(false);
      formPanel.setHeaderVisible(false);
   
      userComboBox = createUserComboBox();
      passwordField = createPasswordField();
      
      errorLabel = new Label("The User ID or Password you entered is not correct");
      errorLabel.setVisible(false);
      errorLabel.setStyleName("errorLabel");
      
      formPanel.add(errorLabel, new FormData("5"));
      formPanel.add(userComboBox, new FormData("5"));
      formPanel.add(passwordField, new FormData("5"));
      
      formPanel.addButton(createLoginButton());
      
      addStyleName("loginPanelOuter");

      VerticalPanel panel = new VerticalPanel();

      panel.addStyleName("loginPanelInner");
      panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
      panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

      panel.add(formPanel);

      setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

      add(panel, DockPanel.CENTER);
   }
   
   private Button createLoginButton()
   {
      Button button = new Button("Login");
      
      button.addSelectionListener(new SelectionListener<ButtonEvent>()
      {
         @Override
         public void componentSelected(ButtonEvent ce)
         {
            login();
         }
      });
      
      return button;
   }
   
   private void login()
   {
      if(vaildateUser())
      {
         onSubmit();
      }
      else
      {
         errorLabel.setVisible(true);
      }
   }
   
   private boolean vaildateUser()
   {
      String password = passwordField.getRawValue();
      
      if(isVolunteer() && password.equalsIgnoreCase("stranding"))
      {
         return true;
      }
      if(isAdmin() && password.equalsIgnoreCase("islands"))
      {
         return true;
      }
      
      return false;
   }

   private TextField<String> createPasswordField()
   {
      TextField<String> passwordField = new TextField<String>();
      passwordField.setFieldLabel("Password");
      passwordField.setPassword(true);
      passwordField.addKeyListener(new KeyListener()
      {
         public void componentKeyPress(ComponentEvent event) 
         {
            int key = event.getKeyCode();
            
            if(key == 13)
            {
               login();
            }
         }
      });
      
      return passwordField;
   }
   
   private ComboBox<StringModel> createUserComboBox()
   {
      ListStore<StringModel> userListStore = new ListStore<StringModel>();
      
      userListStore.add(new StringModel("Volunteer"));
      userListStore.add(new StringModel("Administrator"));
      
      ComboBox<StringModel> userComboBox = new ComboBox<StringModel>();
      userComboBox.setFieldLabel("User");
      userComboBox.setDisplayField("name");
      userComboBox.setTriggerAction(TriggerAction.ALL);
      userComboBox.setStore(userListStore);
      userComboBox.setForceSelection(true);
      userComboBox.setValidateOnBlur(true);
      userComboBox.setAllowBlank(false);
      userComboBox.setValue(new StringModel("Volunteer"));
      
      userComboBox.addKeyListener(new KeyListener()
      {
         public void componentKeyPress(ComponentEvent event) 
         {
            int key = event.getKeyCode();
            
            if(key == 13)
            {
               login();
            }
         }
      });
      
      return userComboBox;
   }
}
