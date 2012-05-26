package com.mmsn.reportgen.client.view.volunteer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.finfrock.client.DataChangeListener;
import com.finfrock.client.Row;
import com.finfrock.client.Table;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.User;
import com.mmsn.reportgen.client.data.volunteer.Volunteer;
import com.mmsn.reportgen.client.data.volunteer.VolunteerManagerable;
import com.mmsn.reportgen.client.data.volunteer.VolunteerTableSortManager;

public class VolunteerTable extends Table
{

   // --------------------------------------------------------------------------
   // Private Instance Data
   // --------------------------------------------------------------------------
   
   private HashMap<Volunteer, VolunteerRow> volunteerRowTable = 
      new HashMap<Volunteer, VolunteerRow>();
   
   private VolunteerManagerable volunteerManager;
   
   private WidgetFactory widgetFactory;
   
   private VolunteerTableSortManager volunteerSorterManager;
   
   private User user;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerTable(VolunteerManagerable volunteerManager, 
                         WidgetFactory widgetFactory, 
                         User user)
   {
      this.volunteerManager = volunteerManager;
      this.widgetFactory = widgetFactory;
      this.user = user;
      
      volunteerManager.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            volunteerRowTable.clear();
            
            updateTable();
         }
      });
      
      volunteerSorterManager = new VolunteerTableSortManager(volunteerManager);
      
      volunteerSorterManager.addDataChangeListener(new DataChangeListener()
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
      if (column == VolunteerRow.NAME_INDEX)
      {
         volunteerSorterManager.setSortBy(VolunteerTableSortManager.NAME);
      }
      else if (column == VolunteerRow.TIME_AVAILABITY_INDEX)
      {
         volunteerSorterManager.setSortBy(VolunteerTableSortManager.TIME_AVAILABITY);
      }
      else if (column == VolunteerRow.ISLAND_INDEX)
      {
         volunteerSorterManager.setSortBy(VolunteerTableSortManager.ISLAND);
      }
      else if (column == VolunteerRow.VEHICLE_INDEX)
      {
         volunteerSorterManager.setSortBy(VolunteerTableSortManager.VEHICLE);
      }
      else if (column == VolunteerRow.HOURS_INDEX)
      {
         volunteerSorterManager.setSortBy(VolunteerTableSortManager.HOURS_INDEX);
      }
      else if (column == VolunteerRow.MILES_INDEX)
      {
         volunteerSorterManager.setSortBy(VolunteerTableSortManager.MILES_INDEX);
      }
   }
   
   @Override
   protected Row getHeaderRow()
   {
      return new VolunteerHeaderRow(user);
   }

   @Override
   protected List<Row> getRows()
   {
      List<Row> volunteerRows = new ArrayList<Row>();
      
      for(Volunteer volunteer : volunteerSorterManager.getVolunteers())
      {
         VolunteerRow volunteerRow = getRow(volunteer);
         
         volunteerRows.add(volunteerRow);
      }
      
      return volunteerRows;
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private VolunteerRow getRow(Volunteer volunteer)
   {
      VolunteerRow volunteerRow = volunteerRowTable.get(volunteer);

      if (volunteerRow == null)
      {
         volunteerRow = new VolunteerRow(volunteerManager,
            volunteer, widgetFactory, user);

         volunteerRowTable.put(volunteer, volunteerRow);
      }

      return volunteerRow;
   }

 }