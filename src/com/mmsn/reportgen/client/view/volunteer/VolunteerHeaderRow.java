package com.mmsn.reportgen.client.view.volunteer;

import com.finfrock.client.Column;
import com.finfrock.client.CommonColumn;
import com.finfrock.client.Row;
import com.mmsn.reportgen.client.data.User;

public class VolunteerHeaderRow extends Row
{
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public VolunteerHeaderRow(User user)
   {
      addColumn(createNameColumn());
      addColumn(createTimeAvailabityColumn());
      addColumn(createContactPhoneNumberColumn());
      addColumn(createIslandColumn());
      addColumn(createVehicleColumn());
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
   
   private Column createMilesColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue("Monthly Miles");
      column.setStyleName("sortableTableHeader");
      column.setIndex(VolunteerRow.MILES_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createHoursColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue("Monthly Hours");
      column.setStyleName("sortableTableHeader");
      column.setIndex(VolunteerRow.HOURS_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createVehicleColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue("Vehicle");
      column.setStyleName("sortableTableHeader");
      column.setIndex(VolunteerRow.VEHICLE_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createIslandColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue("Island");
      column.setStyleName("sortableTableHeader");
      column.setIndex(VolunteerRow.ISLAND_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createContactPhoneNumberColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue("Contact Phone");
      column.setStyleName("tableHeader");
      column.setIndex(VolunteerRow.CONTACT_CONTACT_PHONE_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createDeleteColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue("Delete");
      column.setStyleName("tableHeader");
      column.setIndex(VolunteerRow.DELETE_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createTimeAvailabityColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue("Today's Availability");
      column.setStyleName("sortableTableHeader");
      column.setIndex(VolunteerRow.TIME_AVAILABITY_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createNameColumn()
   {
      CommonColumn column = new CommonColumn();

      column.setValue("Name");
      column.setStyleName("sortableTableHeader");
      column.setIndex(VolunteerRow.NAME_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
}
