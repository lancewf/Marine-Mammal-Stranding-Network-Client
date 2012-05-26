package com.mmsn.reportgen.client.view.volunteer;

import java.util.List;

import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.data.volunteer.Availablity;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.view.FormEditControl;
import com.mmsn.reportgen.client.view.PhoneNumberField;
import com.mmsn.reportgen.client.view.StringModel;

public class VolunteerControl extends VerticalPanel  implements FormEditControl
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private boolean readOnly;
   private TextField<String> firstNameField;
   private TextField<String> lastNameField;
   private TextField<String> cityField;
   private TextField<String> stateField;
   private TextField<String> zipField;
   private TextField<String> streetAddressField;
   private TextField<String> vehicleField;
   private ComboBox<StringModel> islandComboBox;
   private TextField<String> emailField;
   private TextField<String> trainingField;
   private TextArea commentsField;
   private PhoneNumberField phoneNumberField;
   private HoursAvailableControl hoursAvailableControl;
   private Label editLabel;
   private Label saveLabel;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public VolunteerControl(List<String> islands)
   {
      initialize(islands);
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setReadOnly(boolean readOnly)
   {
      if(readOnly)
      {  
         setToReadOnly();
      }
      else
      {
         setToWritable();
      }
   }
   
   public boolean isReadOnly()
   {
      return readOnly;
   }
   
   public void setFirstName(String firstName)
   {
      firstNameField.setValue(firstName);
   }
   
   public void setLastName(String lastName)
   {
      lastNameField.setValue(lastName);
   }
   
   public void setIsland(String island)
   {
      islandComboBox.setValue(new StringModel(island));
   }
   
   public void setEmail(String email)
   {
      emailField.setValue(email);
   }
   
   public void setTraining(String training)
   {
      trainingField.setValue(training);
   }
   
   public void setStreetAddress(String streetAddress)
   {
      streetAddressField.setValue(streetAddress);
   }
   
   public void setCity(String city)
   {
      cityField.setValue(city);
   }
   
   public void setState(String state)
   {
      stateField.setValue(state);
   }
   
   public void setZip(String zip)
   {
      zipField.setValue(zip);
   }
   
   public void setVehicle(String vehicle)
   {
      vehicleField.setValue(vehicle);
   }
   
   public void setComments(String comments)
   {
      commentsField.setValue(comments);
   }
   
   public void setAvailablity(Availablity availablity)
   {
      hoursAvailableControl.setAvailablity(availablity);
   }
   
   public void setPhoneNumber(String phoneNumber)
   {
      phoneNumberField.setValue(phoneNumber);
   }
   
   public String getFirstName()
   {
      return firstNameField.getRawValue();
   }
   
   public String getLastName()
   {
      return lastNameField.getRawValue();
   }
   
   public String getIsland()
   {
      return islandComboBox.getRawValue();
   }
   
   public String getEmail()
   {
      return emailField.getRawValue();
   }
   
   public String getTraining()
   {
      return trainingField.getRawValue();
   }
   
   public String getStreetAddress()
   {
      return streetAddressField.getRawValue();
   }
   
   public String getCity()
   {
      return cityField.getRawValue();
   }
   
   public String getState()
   {
      return stateField.getRawValue();
   }
   
   public String getZip()
   {
      return zipField.getRawValue();
   }
   
   public String getVehicle()
   {
      return vehicleField.getRawValue();
   }
   
   public String getComments()
   {
      return commentsField.getRawValue();
   }
   
   public Availablity getAvailablity()
   {
      return hoursAvailableControl.getAvailablity();
   }
   
   public String getPhoneNumber()
   {
      return phoneNumberField.getRawValue();
   }
   
   public void setVolunteer(Volunteer volunteer)
   {
      setFirstName(volunteer.getFirstName());
      setLastName(volunteer.getLastName());
      setIsland(volunteer.getIsland());
      setEmail(volunteer.getEmail());
      setTraining(volunteer.getTraining());
      setStreetAddress(volunteer.getStreetAddress());
      setCity(volunteer.getCity());
      setState(volunteer.getState());
      setZip(volunteer.getZip());
      setVehicle(volunteer.getVehicle());
      setComments(volunteer.getComments());
      setPhoneNumber(volunteer.getPhoneNumber());
      setAvailablity(volunteer.getAvailablity());
   }
   
   public Volunteer fillVolunteer(Volunteer volunteer)
   {
      volunteer.setFirstName(getFirstName());
      volunteer.setLastName(getLastName());
      volunteer.setIsland(getIsland());
      volunteer.setEmail(getEmail());
      volunteer.setTraining(getTraining());
      volunteer.setStreetAddress(getStreetAddress());
      volunteer.setCity(getCity());
      volunteer.setState(getState());
      volunteer.setZip(getZip());
      volunteer.setVehicle(getVehicle());
      volunteer.setComments(getComments());
      volunteer.setPhoneNumber(getPhoneNumber());
      volunteer.setAvailablity(getAvailablity());
      
      return volunteer;
   }
   
   public void clearData()
   {
      setFirstName("");
      setLastName("");
      setIsland("");
      setEmail("");
      setTraining("");
      setStreetAddress("");
      setCity("");
      setState("WA");
      setZip("");
      setVehicle("");
      setComments("");
      setPhoneNumber("");
      
      hoursAvailableControl.clearData();
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void setToWritable()
   {
      readOnly = false;
      
      saveLabel.setVisible(true);
      editLabel.setVisible(false);
      firstNameField.setReadOnly(false);
      lastNameField.setReadOnly(false);
      islandComboBox.setReadOnly(false);
      emailField.setReadOnly(false);
      trainingField.setReadOnly(false);
      streetAddressField.setReadOnly(false);
      cityField.setReadOnly(false);
      stateField.setReadOnly(false);
      zipField.setReadOnly(false);
      vehicleField.setReadOnly(false);
      commentsField.setReadOnly(false);
      phoneNumberField.setReadOnly(false);
      hoursAvailableControl.setReadOnly(false);
      
   }
   
   private void setToReadOnly()
   {
      readOnly = true;
      
      saveLabel.setVisible(false);
      editLabel.setVisible(true);
      firstNameField.setReadOnly(true);
      lastNameField.setReadOnly(true);
      islandComboBox.setReadOnly(true);
      emailField.setReadOnly(true);
      trainingField.setReadOnly(true);
      streetAddressField.setReadOnly(true);
      cityField.setReadOnly(true);
      stateField.setReadOnly(true);
      zipField.setReadOnly(true);
      vehicleField.setReadOnly(true);
      commentsField.setReadOnly(true);
      phoneNumberField.setReadOnly(true);
      hoursAvailableControl.setReadOnly(true);
   }
   
   private void initialize(List<String> islands)
   {
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      Label titleLabel = new Label("Volunteer Form");
      
      titleLabel.setStyleName("pageTitle");
      
      add(titleLabel);
      
      saveLabel = new Label("Select Save to keep your changes.");
      saveLabel.setStyleName("saveLabel");
      
      saveLabel.setVisible(false);
      
      editLabel = new Label("To edit this volunteer select Edit at the top of this page.");
      editLabel.setStyleName("editLabel");
      
      add(saveLabel);
      add(editLabel);
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      
      add(createNameField());
      
      add(createIslandField(islands));
      
      add(createStreetAddress());
      
      add(createAddressField());
      
      add(createContactPhone());
      
      add(createEmailField());
      
      add(createTrainingField());
      
      add(createVehicleField());
      
      add(createComments());
      
      add(new HTML("<h3>Availablity:</h3>"));
      
      hoursAvailableControl = new HoursAvailableControl();
      
      add(hoursAvailableControl);
   }
   
   private Widget createEmailField()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      FormPanel formPanel = new FormPanel();   
      formPanel.setBodyBorder(false);
      formPanel.setHeaderVisible(false);
   
      emailField = new TextField<String>();
      emailField.setFieldLabel("Email");
      formPanel.add(emailField, new FormData("150"));
      
      panel.add(formPanel);
      
      return panel;
   }
   
   private Widget createTrainingField()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      FormPanel formPanel = new FormPanel();   
      formPanel.setBodyBorder(false);
      formPanel.setHeaderVisible(false);
   
      trainingField = new TextField<String>();
      trainingField.setFieldLabel("Training Last Attended");
      formPanel.add(trainingField, new FormData("150"));
      
      panel.add(formPanel);
      
      return panel;
   }
   
   private Widget createIslandField(List<String> islands)
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      FormPanel formPanel = new FormPanel();   
      formPanel.setBodyBorder(false);
      formPanel.setHeaderVisible(false);
   
      FormData formData = new FormData("150");
      
      ListStore<StringModel> islandListStore = new ListStore<StringModel>();
      
      for(String island : islands)
      {
         islandListStore.add(new StringModel(island));
      }
      
      islandComboBox = new ComboBox<StringModel>();
      islandComboBox.setFieldLabel("Island");
      islandComboBox.setDisplayField("name");
      islandComboBox.setTriggerAction(TriggerAction.ALL);
      islandComboBox.setStore(islandListStore);
      islandComboBox.setAllowBlank(true);
      
      formPanel.add(islandComboBox, formData);
      
      panel.add(formPanel);
      
      return panel;
   }

   private Widget createVehicleField()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      FormPanel formPanel = new FormPanel();
      formPanel.setBodyBorder(false);
      formPanel.setHeaderVisible(false);
   
      FormData formData = new FormData("150");
      vehicleField = new TextField<String>();
      vehicleField.setFieldLabel("Vehicles (car,boats, truck, etc.)");
      formPanel.add(vehicleField, formData);
      
      panel.add(formPanel);
      
      return panel;
   }

   private Widget createComments()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      FormPanel formPanel = new FormPanel();   
      formPanel.setBodyBorder(false);
      formPanel.setHeaderVisible(false);
   
      FormData formData = new FormData("300");
      commentsField = new TextArea();
      commentsField.setFieldLabel("Comments");
      commentsField.setMaxLength(1000);
      formPanel.add(commentsField, formData);
      
      panel.add(formPanel);
      
      return panel;
   }
   
   private Widget createStreetAddress()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      FormPanel formPanel = new FormPanel();   
      formPanel.setBodyBorder(false);
      formPanel.setHeaderVisible(false);
   
      FormData formData = new FormData("200");
      streetAddressField = new TextField<String>();
      streetAddressField.setFieldLabel("Street Address");
      formPanel.add(streetAddressField, formData);
      
      panel.add(formPanel);
      
      return panel;
   }
   
   private HorizontalPanel createContactPhone()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      FormPanel formPanel1 = new FormPanel();   
      formPanel1.setBodyBorder(false);
      formPanel1.setHeaderVisible(false);
      phoneNumberField = new PhoneNumberField();
      phoneNumberField.setFieldLabel("Phone Number");
      
      formPanel1.add(phoneNumberField, new FormData("150"));
      
      panel.add(formPanel1);
      
      return panel;
   }
   
   private HorizontalPanel createAddressField()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      FormPanel formPanel1 = new FormPanel();   
      formPanel1.setBodyBorder(false);
      formPanel1.setHeaderVisible(false);
      cityField = new TextField<String>();
      cityField.setFieldLabel("City");
      formPanel1.add(cityField, new FormData("10"));
      
      panel.add(formPanel1);
      
      FormPanel formPanel2 = new FormPanel();   
      formPanel2.setBodyBorder(false);
      formPanel2.setHeaderVisible(false);
      stateField = new TextField<String>();
      stateField.setFieldLabel("State");
      stateField.setWidth(20);
      stateField.setMaxLength(2);
      stateField.setMinLength(2);
      formPanel2.add(stateField, new FormData("10"));
      
      panel.add(formPanel2);
      
      FormPanel formPanel3 = new FormPanel();   
      formPanel3.setBodyBorder(false);
      formPanel3.setHeaderVisible(false);
      zipField = new TextField<String>();
      zipField.setFieldLabel("Zip");
      zipField.setWidth(70);
      stateField.setMaxLength(10);
      stateField.setValue("WA");
      formPanel3.add(zipField, new FormData("10"));
      
      panel.add(formPanel3);
      
      return panel;
   }
   
   private HorizontalPanel createNameField()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      FormPanel formPanel = new FormPanel();   
      formPanel.setBodyBorder(false);
      formPanel.setHeaderVisible(false);
   
      FormData formData = new FormData("-20");
      firstNameField = new TextField<String>();
      firstNameField.setFieldLabel("First Name");
      formPanel.add(firstNameField, formData);
      
      panel.add(formPanel);
      
      FormPanel formPanel1 = new FormPanel();   
      formPanel1.setBodyBorder(false);
      formPanel1.setHeaderVisible(false);
      lastNameField = new TextField<String>();
      lastNameField.setFieldLabel("Last Name");
      formPanel1.add(lastNameField, formData);
      
      panel.add(formPanel1);
      return panel;
   }
}
