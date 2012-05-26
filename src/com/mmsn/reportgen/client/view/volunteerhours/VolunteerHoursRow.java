package com.mmsn.reportgen.client.view.volunteerhours;

import com.finfrock.client.Column;
import com.finfrock.client.CommonColumn;
import com.finfrock.client.DataChangeListener;
import com.finfrock.client.Row;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerHours;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursManager;
import com.mmsn.reportgen.client.view.DeleteConfirmationPanel;
import com.mmsn.reportgen.client.view.ViewPanel;
import com.mmsn.reportgen.client.view.images.MMSNClientBundle;

public class VolunteerHoursRow extends Row
{

   // --------------------------------------------------------------------------
   // Public static Data
   // --------------------------------------------------------------------------

   public static final int VIEW_INDEX = 0;

   public static final int SPECIES_INDEX = 1;
   
   public static final int TOTAL_TIME_INDEX = 2;
   
   public static final int LOCATION_INDEX = 3;
   
   public static final int DELETE_INDEX = 5;

   public static final int MILES_INDEX = 4;
   
   private VolunteerHours volunteerHours;
   private VolunteerMonthlyHoursManager volunteerHoursManager;
   private WidgetFactory widgetFactory;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public VolunteerHoursRow(VolunteerHours volunteerHours,
                            VolunteerMonthlyHoursManager volunteerHoursManager,
                            WidgetFactory widgetFactory)
   {
      this.volunteerHoursManager = volunteerHoursManager;
      this.volunteerHours = volunteerHours;
      this.widgetFactory = widgetFactory;
      
      addColumn(createViewColumn());
      addColumn(createTotalTimeColumn());
      addColumn(createMilesColumn());
      addColumn(createDeleteColumn());
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   public Column createMilesColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue(volunteerHours.getMileage() + "");
      column.setIndex(MILES_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createTotalTimeColumn()
   {
      CommonColumn column = new CommonColumn();
      
      column.setValue(volunteerHours.getTotalHours() + "");
      column.setIndex(TOTAL_TIME_INDEX);
      column.setValueType(Column.TEXT_COLUMN_TYPE);
      
      return column;
   }
   
   private Column createViewColumn()
   {
      CommonColumn column = new CommonColumn();

      MMSNClientBundle mmsnImageBundle = (MMSNClientBundle) GWT
         .create(MMSNClientBundle.class);

      ImageResource reportImageResource = mmsnImageBundle.reportIcon();

      Image reportimage = new Image(reportImageResource);

      reportimage.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            ViewPanel viewPanel = widgetFactory.getViewPanel();
            
            VolunteerAddHoursViewPanel volunteerAddHoursViewPanel = widgetFactory
               .getVolunteerAddHoursViewPanel(volunteerHoursManager);

            volunteerAddHoursViewPanel.setVolunteerHours(volunteerHours);

            volunteerAddHoursViewPanel.setDate(volunteerHours.getMonth(), 
               volunteerHours.getDayOfMonth(), volunteerHours.getYear());

            volunteerAddHoursViewPanel
               .setVolunteer(volunteerHoursManager.getVolunteer());

            viewPanel.show(volunteerAddHoursViewPanel);
         }
      });
      
      column.setValue(reportimage);
      column.setIndex(VIEW_INDEX);
      column.setStyleName("buttonColumn");
      column.setValueType(Column.WIDGET_COLUMN_TYPE);
      
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
      column.setIndex(DELETE_INDEX);
      column.setStyleName("buttonColumn");
      column.setValueType(Column.WIDGET_COLUMN_TYPE);
      
      return column;
   }
   
   private void deleteReport()
   {
      final ViewPanel viewPanel = widgetFactory.getViewPanel();
      
      final DeleteConfirmationPanel deleteConfirmationPanel = 
         new DeleteConfirmationPanel();
      
      deleteConfirmationPanel.setText("Are you sure you would like to delete these Volunteer Hours?");
      
      viewPanel.show(deleteConfirmationPanel);
      
      deleteConfirmationPanel.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            if(deleteConfirmationPanel.getReponse() == DeleteConfirmationPanel.YES)
            {
               volunteerHoursManager.removeVolunteerHours(volunteerHours);
               
               viewPanel.showPreivous();
            }
            else if(deleteConfirmationPanel.getReponse() == DeleteConfirmationPanel.NO)
            {
               viewPanel.showPreivous();
            }
         }
      });
   }
}
