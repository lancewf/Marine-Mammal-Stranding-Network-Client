package com.mmsn.reportgen.client.view.volunteerhours;

import java.util.Date;

import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerHours;
import com.mmsn.reportgen.client.view.FormEditControl;

public class VolunteerAddHoursControl extends VerticalPanel 
   implements FormEditControl
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private NumberField totalTimeField;
   private NumberField mileageField;
   private TextArea commentsField;
   private Label voluteerNameLabel;
   private Label dateLabel;
   private Label editLabel;
   private Label saveLabel;
   private int month;
   private int dayOfMonth;
   private int year;
   
   // --------------------------------------------------------------------------
   // Private static Data
   // --------------------------------------------------------------------------

   private static DateTimeFormat datetimeformat = 
      DateTimeFormat.getFormat("MMMM d, y");
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public VolunteerAddHoursControl()
   {
      initialize();
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setReadOnly(boolean readOnly)
   {
      if(readOnly)
      {
         saveLabel.setVisible(false);
         editLabel.setVisible(true);
         totalTimeField.setReadOnly(true);
         mileageField.setReadOnly(true);
         commentsField.setReadOnly(true);
      }
      else
      {
         saveLabel.setVisible(true);
         editLabel.setVisible(false);
         totalTimeField.setReadOnly(false);
         mileageField.setReadOnly(false);
         commentsField.setReadOnly(false);
      }
   }
   
   public void clearData()
   {
      setTotalTime(0.0);
      
      setMileageTime(0);
      
      setComments("");
   }
   
   public void setVolunteerHours(VolunteerHours volunteerHours)
   {
      setTotalTime(volunteerHours.getTotalHours());
      
      setMileageTime(volunteerHours.getMileage());
      
      setComments(volunteerHours.getComments());
   }
   
   public VolunteerHours fillVolunteerHours(VolunteerHours volunteerHours)
   {
      volunteerHours.setDayOfMonth(dayOfMonth);
      volunteerHours.setMonth(month);
      volunteerHours.setYear(year);
      volunteerHours.setTotalHours(getTotalTime());
      volunteerHours.setMileage(getMileageTime());
      volunteerHours.setComments(getComments());
      
      return volunteerHours;
   }
   
   public void setDate(int month, int dayOfMonth, int year)
   {
      this.month = month;
      this.dayOfMonth = dayOfMonth;
      this.year = year;
      
      Date date = new Date(year - 1900,  month-1, dayOfMonth);
      
      dateLabel.setText(datetimeformat.format(date));
   }
   
   public void setVolunteer(Volunteer volunteer)
   {
      voluteerNameLabel.setText( volunteer.getFirstName() + " " 
         + volunteer.getLastName());
   }
   
   public void setTotalTime(double totalTime)
   {
      totalTimeField.setValue(totalTime);
   }
   
   public double getTotalTime()
   {
      Number number = totalTimeField.getValue();
      
      if(number != null)
      {
         return number.doubleValue();
      }
      else
      {
         return 0.0;
      }
   }
   
   public void setMileageTime(int mileageTime)
   {
      mileageField.setValue(mileageTime);
   }
   
   public int getMileageTime()
   {
      Number number = mileageField.getValue();
      
      if(number != null)
      {
         return number.intValue();
      }
      else
      {
         return 0;
      }
   }
   
   public void setComments(String comments)
   {
      commentsField.setValue(comments);
   }
   
   public String getComments()
   {
      return commentsField.getRawValue();
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {
      addStyleName("viewpanelItem");
      
      setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      add(createHeaderLabel());
      
      saveLabel = new Label("Select Save to keep your changes.");
      saveLabel.setStyleName("saveLabel");
      saveLabel.setVisible(false);
      
      add(saveLabel);
      
      editLabel = new Label("To edit these volunteer hours select Edit at the top of this page.");
      
      editLabel.setStyleName("editLabel");
      
      add(editLabel);
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      
      add(createTotalTime());
      add(createMileage());
      add(createComments());
   }
   
   private Widget createHeaderLabel()
   {
      VerticalPanel panel = new VerticalPanel();
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      Label title = new Label("Adding Volunteer Hours");
      
      title.setStyleName("pageTitle");
      
      panel.add(title);
      
      voluteerNameLabel = new Label("FirstName LastName");
      voluteerNameLabel.setStyleName("pageTitle");
      panel.add(voluteerNameLabel);
      
      dateLabel = new Label("Month day, year");
      dateLabel.setStyleName("pageTitle");
      panel.add(dateLabel);
      
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
      commentsField.setMaxLength(10000);
      formPanel.add(commentsField, formData);
      
      panel.add(formPanel);
      
      return panel;
   }
   
   private HorizontalPanel createTotalTime()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      FormPanel formPanel1 = new FormPanel();   
      formPanel1.setBodyBorder(false);
      formPanel1.setHeaderVisible(false);
      totalTimeField = new NumberField();
      totalTimeField.setFieldLabel("Total Time (Round up to .25 hour)");
      totalTimeField.setToolTip("Round up to .25 hour");
      
      formPanel1.add(totalTimeField, new FormData("-20"));
      
      panel.add(formPanel1);
      
      return panel;
   }
   
   private HorizontalPanel createMileage()
   {
      HorizontalPanel panel = new HorizontalPanel();
      
      FormPanel formPanel1 = new FormPanel();   
      formPanel1.setBodyBorder(false);
      formPanel1.setHeaderVisible(false);
      mileageField = new NumberField();
      mileageField.setFieldLabel("Mileage");
      
      formPanel1.add(mileageField, new FormData("-20"));
      
      panel.add(formPanel1);
      
      return panel;
   }
}
