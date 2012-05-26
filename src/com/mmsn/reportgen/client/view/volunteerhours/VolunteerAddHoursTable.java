package com.mmsn.reportgen.client.view.volunteerhours;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.finfrock.client.DataChangeListener;
import com.finfrock.client.Row;
import com.finfrock.client.Table;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerHours;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursManager;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursSortManager;

public class VolunteerAddHoursTable extends Table
{
   // --------------------------------------------------------------------------
   // Private Instance Data
   // --------------------------------------------------------------------------
  
   private HashMap<VolunteerHours, VolunteerHoursRow> volunteerHoursRowTable = 
      new HashMap<VolunteerHours, VolunteerHoursRow>();
   
   private VolunteerMonthlyHoursManager volunteerHoursManager;
   private VolunteerMonthlyHoursSortManager volunteerMonthlyHoursSortManager;
   private WidgetFactory widgetFactory;
   
   private int dayOfMonth;
   private int month;
   private int year;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerAddHoursTable(
                         VolunteerMonthlyHoursManager volunteerHoursManager, 
                         WidgetFactory widgetFactory, int dayOfMonth, 
                         int month, int year)
   {
      this.volunteerHoursManager = volunteerHoursManager;
      this.widgetFactory = widgetFactory;
      this.dayOfMonth = dayOfMonth;
      this.month = month;
      this.year = year;
      
      volunteerMonthlyHoursSortManager = 
         new VolunteerMonthlyHoursSortManager(volunteerHoursManager);
      
      volunteerHoursManager.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            volunteerHoursRowTable.clear();
            
            updateTable();
         }
      });
      
      volunteerMonthlyHoursSortManager.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {            
            updateTable();
         }
      });
      
      updateTable();
   }

   // --------------------------------------------------------------------------
   // Table Members
   // --------------------------------------------------------------------------
   
   @Override
   protected void columnHeaderClicked(int column)
   {
      if (column == VolunteerHoursRow.TOTAL_TIME_INDEX)
      {
         volunteerMonthlyHoursSortManager.setSortBy(VolunteerMonthlyHoursSortManager.TOTAL_TIME);
      }
   }
   
   @Override
   protected Row getHeaderRow()
   {
      return new VolunteerHoursHeaderRow();
   }

   @Override
   protected List<Row> getRows()
   {
      List<Row> volunteerHoursRows = new ArrayList<Row>();
      
      for(VolunteerHours volunteerHours : 
         volunteerMonthlyHoursSortManager.getVolunteerHours(dayOfMonth, month, year))
      {
         VolunteerHoursRow volunteerHoursRow = getRow(volunteerHours);
         
         volunteerHoursRows.add(volunteerHoursRow);
      }
      
      return volunteerHoursRows;
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private VolunteerHoursRow getRow(VolunteerHours volunteerHours)
   {
      VolunteerHoursRow volunteerHoursRow = 
         volunteerHoursRowTable.get(volunteerHours);
         
      if(volunteerHoursRow == null)
      {
         volunteerHoursRow = new VolunteerHoursRow(volunteerHours, 
            volunteerHoursManager, widgetFactory);
         
         volunteerHoursRowTable.put(volunteerHours, volunteerHoursRow);
      }
      
      return volunteerHoursRow;
   }

}
