package com.mmsn.reportgen.client.view.volunteer;

import java.util.Date;

import com.extjs.gxt.ui.client.util.DateWrapper;
import com.finfrock.client.Column;
import com.finfrock.client.CommonColumn;
import com.finfrock.client.DataChangeListener;
import com.finfrock.client.Row;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.User;
import com.mmsn.reportgen.client.data.volunteer.AvailabityManager;
import com.mmsn.reportgen.client.data.volunteer.Availablity;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursManager;
import com.mmsn.reportgen.client.view.DeleteConfirmationPanel;
import com.mmsn.reportgen.client.view.ViewPanel;
import com.mmsn.reportgen.client.view.images.MMSNClientBundle;

public class VolunteerRow extends Row
{

   // --------------------------------------------------------------------------
   // Public static Data
   // --------------------------------------------------------------------------

   public static final int NAME_INDEX = 0;
   public static final int TIME_AVAILABITY_INDEX = 1;
   public static final int CONTACT_CONTACT_PHONE_INDEX = 2;
   public static final int ISLAND_INDEX = 3;
   public static final int VEHICLE_INDEX = 4;
   public static final int DELETE_INDEX = 7;
   public static final int HOURS_INDEX = 5;
   public static final int MILES_INDEX = 6;
   
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private Volunteer volunteer;
   private WidgetFactory widgetFactory;
   private VolunteerManagerable volunteerManager;
   private VolunteerMonthlyHoursManager volunteerMonthlyHoursManager;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public VolunteerRow(VolunteerManagerable volunteerManager, 
                       Volunteer volunteer, WidgetFactory widgetFactory, 
                       User user)
   {
      this.volunteer = volunteer;
      this.widgetFactory = widgetFactory;
      this.volunteerManager = volunteerManager;
      
      volunteerMonthlyHoursManager = 
         volunteerManager.getVolunteerMonthlyHoursManager(volunteer);

      addColumn(createNameColumn());
      addColumn(createTimeAvailabityColumn());
      addColumn(createContactPhoneNumberColumn());
      addColumn(createVehicleColumn());
      addColumn(createIslandColumn());
      addColumn(createHoursColumn());
      addColumn(createMilesColumn());
      
      if(user.isAdmin())
      {
         addColumn(createDeleteColumn());
      }
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private Column createHoursColumn()
   {
      CommonColumn column = new CommonColumn();
      
      final Label label = new Label();
      
      label.setText(volunteerMonthlyHoursManager.getTotalHours() + "");
      
      DateWrapper date = new DateWrapper(new Date());
      
      final int currentMonth = date.getMonth() + 1;
      final int currentYear = date.getFullYear();
      
      volunteerMonthlyHoursManager.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            if(volunteerMonthlyHoursManager.getCurrentYear() == currentYear &&
                  volunteerMonthlyHoursManager.getCurrentMonth() == currentMonth)
            {
               double hours = volunteerMonthlyHoursManager.getTotalHours();
               label.setText(hours + "");
            }
         }
      });
      
      volunteerMonthlyHoursManager.updateMonth(currentMonth, currentYear);
      
      column.setValue(label);
      column.setStyleName("tableCenterColumn");
      column.setIndex(HOURS_INDEX);
      column.setValueType(Column.WIDGET_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createMilesColumn()
   {
      CommonColumn column = new CommonColumn();
      
      final Label label = new Label();
      
      label.setText(volunteerMonthlyHoursManager.getTotalMiles() + "");
      
      DateWrapper date = new DateWrapper(new Date());
      
      final int currentMonth = date.getMonth() + 1;
      final int currentYear = date.getFullYear();
      
      volunteerMonthlyHoursManager.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            if(volunteerMonthlyHoursManager.getCurrentYear() == currentYear &&
                  volunteerMonthlyHoursManager.getCurrentMonth() == currentMonth)
            {
               int miles = volunteerMonthlyHoursManager.getTotalMiles();
               label.setText(miles + "");
            }
         }
      });
      
      volunteerMonthlyHoursManager.updateMonth(date.getMonth() + 1, date.getFullYear());
      
      column.setValue(label);
      column.setStyleName("tableCenterColumn");
      column.setIndex(MILES_INDEX);
      column.setValueType(Column.WIDGET_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createVehicleColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue(volunteer.getVehicle());
      column.setStyleName("tableCenterColumn");
      column.setIndex(VEHICLE_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createIslandColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue(volunteer.getIsland());
      column.setStyleName("tableCenterColumn");
      column.setIndex(ISLAND_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createContactPhoneNumberColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue(volunteer.getPhoneNumber());
      column.setStyleName("tableCenterColumn");
      column.setIndex(CONTACT_CONTACT_PHONE_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createTimeAvailabityColumn()
   {
      CommonColumn column = new CommonColumn();
      
      Availablity availablity = volunteer.getAvailablity();
      
      String text = AvailabityManager.getAvailabityText(availablity);
      
      column.setValue(text);
      column.setStyleName("tableCenterColumn");
      column.setIndex(TIME_AVAILABITY_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createDeleteColumn()
   {
      CommonColumn column = new CommonColumn();
      
      MMSNClientBundle mmsnImageBundle = (MMSNClientBundle) 
      GWT.create(MMSNClientBundle.class);
      
      ImageResource deleteImageResource = mmsnImageBundle.deleteIcon();
      
      Image deleteimage = new Image(deleteImageResource);
      
      deleteimage.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            deleteReport();
         }
      });
      
      column.setValue(deleteimage);
      column.setStyleName("buttonColumn");
      column.setIndex(DELETE_INDEX);
      column.setValueType(Column.WIDGET_COLUMN_TYPE);
      
      return column;
   }
   
   private void deleteReport()
   {
      final ViewPanel viewPanel = widgetFactory.getViewPanel();
      
      final DeleteConfirmationPanel deleteConfirmationPanel = 
         new DeleteConfirmationPanel();
      
      deleteConfirmationPanel.setText("Are you sure you would like to delete Volunteer '" + 
         volunteer.getFullName() + "'?");
      
      viewPanel.show(deleteConfirmationPanel);
      
      deleteConfirmationPanel.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            if(deleteConfirmationPanel.getReponse() == DeleteConfirmationPanel.YES)
            {
               volunteerManager.removeVolunteer(volunteer);
               
               viewPanel.showPreivous();
            }
            else if(deleteConfirmationPanel.getReponse() == 
               DeleteConfirmationPanel.NO)
            {
               viewPanel.showPreivous();
            }
         }
      });
   }
   
   private Column createNameColumn()
   {
      CommonColumn column = new CommonColumn();
      
      Widget widget = new VolunteerNameControl(volunteer, widgetFactory, 
         volunteerMonthlyHoursManager);
      
      column.setValue(widget);
      column.setIndex(NAME_INDEX);
      column.setValueType(Column.WIDGET_COLUMN_TYPE);
      
      return column;
   }
}
