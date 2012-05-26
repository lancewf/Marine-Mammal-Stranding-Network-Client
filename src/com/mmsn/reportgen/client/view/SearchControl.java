package com.mmsn.reportgen.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.data.volunteer.VolunteerSearchManager;

public class SearchControl extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private SearchFieldControl searchFieldControl;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public SearchControl(VolunteerSearchManager volunteerSearchManager, List<String> islands)
   {
      initialize(volunteerSearchManager, islands);
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize(VolunteerSearchManager volunteerSearchManager, List<String> islands) 
   {
      addStyleName("searchControl");
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      searchFieldControl = new SearchFieldControl(
         volunteerSearchManager, islands);

      searchFieldControl.setVisible(false);

      VerticalPanel searchButtonPanel = new VerticalPanel();
      
      final Button searchButton = new Button("Show Search");
      
      searchButton.setStyleName("cq-Button");
      
      searchButton.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(searchFieldControl.isVisible())
            {
               searchFieldControl.setVisible(false);
               searchButton.setText("Show Search");
            }
            else
            {
               searchFieldControl.setVisible(true);
               searchButton.setText("Hide Search");
            }
         }

      });
      
      searchButtonPanel.add(searchButton);
      
      add(searchButtonPanel);
      add(searchFieldControl);
   }
}
