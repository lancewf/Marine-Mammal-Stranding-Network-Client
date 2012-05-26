package com.mmsn.reportgen.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.ListBox;
import com.mmsn.reportgen.client.data.volunteer.VolunteerSearchManager;

public class SearchFieldControl extends Grid
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private VolunteerSearchManager volunteerSearchManager;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public SearchFieldControl(VolunteerSearchManager volunteerSearchManager, 
                             List<String> islands)
   {
      super(2, 2);
      
      this.volunteerSearchManager = volunteerSearchManager;
      
      initialize(islands);
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize(List<String> islands) 
   {
      int currentRow = 0;
      
      setText(currentRow, 0, "Availability:");
      getCellFormatter().setHorizontalAlignment(currentRow, 0, HasHorizontalAlignment.ALIGN_LEFT);
      setWidget(currentRow, 1, createAvailabilitySelection());
      getCellFormatter().setHorizontalAlignment(currentRow, 1, HasHorizontalAlignment.ALIGN_LEFT);
      currentRow++;
      
      setText(currentRow, 0, "Island:");
      getCellFormatter().setHorizontalAlignment(currentRow, 0, HasHorizontalAlignment.ALIGN_LEFT);
      setWidget(currentRow, 1, createIslandSelection(islands));
      getCellFormatter().setHorizontalAlignment(currentRow, 1, HasHorizontalAlignment.ALIGN_LEFT);
      currentRow++;
   }

   private ListBox createIslandSelection(List<String> islands)
   {
      ListBox islandsCombobox = new ListBox();
      
      islandsCombobox.addItem(VolunteerSearchManager.ALL_SELECTION);
      
      for(String location : islands)
      {
         islandsCombobox.addItem(location);
      }
      
      islandsCombobox.addChangeHandler(new ChangeHandler(){
         @Override
         public void onChange(ChangeEvent event)
         {
            ListBox listBox = (ListBox)event.getSource();
            
            String text = 
               listBox.getItemText(listBox.getSelectedIndex());
            
            volunteerSearchManager.setIslandSelection(text);
         }
      });
      
      return islandsCombobox;
   }
   
   private ListBox createAvailabilitySelection()
   {
      ListBox availabilityCombobox = new ListBox();
      
      availabilityCombobox.addItem(VolunteerSearchManager.ALL_SELECTION);
      availabilityCombobox.addItem(VolunteerSearchManager.AVAILABILITY_NOW);
      
      availabilityCombobox.addChangeHandler(new ChangeHandler(){
         @Override
         public void onChange(ChangeEvent event)
         {
            ListBox listBox = (ListBox)event.getSource();
            
            String text = 
               listBox.getItemText(listBox.getSelectedIndex());
            
            volunteerSearchManager.setAvailabilitySelection(text);
         }
         
      });
      
      return availabilityCombobox;
   }
}
