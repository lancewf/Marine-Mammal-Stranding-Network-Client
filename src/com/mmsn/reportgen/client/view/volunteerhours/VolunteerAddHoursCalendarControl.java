package com.mmsn.reportgen.client.view.volunteerhours;

import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.util.DateWrapper;
import com.finfrock.client.DataChangeListener;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerHours;
import com.mmsn.reportgen.client.data.volunteerhours.VolunteerMonthlyHoursManager;
import com.mmsn.reportgen.client.view.ViewPanel;

public class VolunteerAddHoursCalendarControl extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private DateWrapper currentDateDisplayed;
   private Grid grid;
   private Button previousButton;
   private Button nextButton;
   private Label monthLabel;
   
   private VolunteerMonthlyHoursManager volunteerHoursManager;
   private WidgetFactory widgetFactory;
   
   private static String[] months = new String[]{"January", "February", "March", "April", 
      "May", "June", "July", "August", "September", "October", "November", "December"};
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public VolunteerAddHoursCalendarControl(WidgetFactory widgetFactory, 
                             VolunteerMonthlyHoursManager volunteerHoursManager)
   {
      addStyleName("volunteerAddHoursCalendar");
      
      this.widgetFactory = widgetFactory;
      this.volunteerHoursManager = volunteerHoursManager;
      
      HorizontalPanel headerPanel = createHeaderPanel();
      
      createGrid();
      
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      add(headerPanel);
      add(grid);
      
      currentDateDisplayed = new DateWrapper(new Date());
      updateDayOfMonthCalendar();
      
      volunteerHoursManager.addDataChangeListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            updateDayOfMonthCalendar();
         }
      });
      
      updateDayOfMonthData();
   }

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------


   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private HorizontalPanel createHeaderPanel()
   {
      HorizontalPanel headerPanel = new HorizontalPanel();
      headerPanel.addStyleName("volunteerAddHoursCalendarHeader");
      headerPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
      monthLabel = new Label("Month");
      
      monthLabel.addStyleName("volunteerAddHoursCalendarMonth");
      
      previousButton = new Button("Previous");
      previousButton.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            currentDateDisplayed = currentDateDisplayed.addMonths(-1);
            
            updateDayOfMonthCalendar();
            updateDayOfMonthData();
         }
      });
      
      nextButton = new Button("Next");
      nextButton.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            currentDateDisplayed = currentDateDisplayed.addMonths(1);
            
            updateDayOfMonthCalendar();
            updateDayOfMonthData();
         }
      });
      
      headerPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
      headerPanel.add(previousButton);
      headerPanel.add(monthLabel);
      headerPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
      headerPanel.add(nextButton);
      
      return headerPanel;
   }

   private void createGrid()
   {
      grid = new Grid(7, 7);
      
      grid.setWidget(0, 0, new Label("Sun"));
      grid.setWidget(0, 1, new Label("Mon"));
      grid.setWidget(0, 2, new Label("Tues"));
      grid.setWidget(0, 3, new Label("Wed"));
      grid.setWidget(0, 4, new Label("Thurs"));
      grid.setWidget(0, 5, new Label("Fri"));
      grid.setWidget(0, 6, new Label("Sat"));
      
      for(int column = 0; column < 7; column++)
      {
         grid.getCellFormatter().addStyleName(0, column, "calendarWeekDayHeaderCell");
      }
      
      grid.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            Cell cell = grid.getCellForEvent(event);
            
            if(cell != null)
            {
               Widget widget = grid.getWidget(cell.getRowIndex(), 
                  cell.getCellIndex());
               
               if(widget instanceof HoursEnteredCell)
               {
                  HoursEnteredCell hoursEnteredCell = (HoursEnteredCell) widget;
                  
                  ViewPanel viewPanel = widgetFactory.getViewPanel();
                  
                  List<VolunteerHours> volunteerHoursCollection = 
                     hoursEnteredCell.getVolunteerHoursCollection();
                  
                  if(volunteerHoursCollection.size() == 0)
                  {
                     VolunteerAddHoursViewPanel newVolunteerAddHoursPanel = 
                        widgetFactory.getNewVolunteerAddHoursPanel(volunteerHoursManager);
                     
                     newVolunteerAddHoursPanel.setDate(hoursEnteredCell.getMonth(), 
                        hoursEnteredCell.getDay() , hoursEnteredCell.getYear());
                     
                     newVolunteerAddHoursPanel.setVolunteer(
                        volunteerHoursManager.getVolunteer());
                     
                     viewPanel.show(newVolunteerAddHoursPanel);
                  }
                  else
                  {
                     VolunteerAddHoursCollectionViewPanel volunteerAddHoursViewPanel = 
                        widgetFactory.getVolunteerAddHoursViewPanel(
                           volunteerHoursManager, hoursEnteredCell.getDay(), 
                           hoursEnteredCell.getMonth(), hoursEnteredCell.getYear());

                     viewPanel.show(volunteerAddHoursViewPanel);
                  }
               }
            }
         }
      });
   }
   
   private void updateDayOfMonthData()
   {
      DateWrapper firstDayOfMonth = currentDateDisplayed.getFirstDayOfMonth();
      int month = firstDayOfMonth.getMonth() + 1;
      int year = firstDayOfMonth.getFullYear();
      
      volunteerHoursManager.updateMonth(month, year);
   }
   
   private void updateDayOfMonthCalendar()
   {
      DateWrapper firstDayOfMonth = currentDateDisplayed.getFirstDayOfMonth();
      int month = firstDayOfMonth.getMonth() + 1;
      int year = firstDayOfMonth.getFullYear();
      int daysInMonth = firstDayOfMonth.getDaysInMonth();
      int dayOfWeekOfFirstDay = firstDayOfMonth.getDayInWeek();
      
      for(int row = 1; row < 7 ; row++)
      {
         for(int column = 0; column < 7; column++)
         {
            grid.clearCell(row, column);
            grid.getCellFormatter().removeStyleName(row, column, "calendarCell");
         }
      }
      
      int day = 1;
      for(int dayOfWeek = dayOfWeekOfFirstDay; dayOfWeek < 7; dayOfWeek++)
      {
         grid.setWidget(1, dayOfWeek, getWidgetForDay(day, month, year));
         grid.getCellFormatter().addStyleName(1, dayOfWeek, "calendarCell");
         day++;
      }
      
      int week = 2;
      while(day <= daysInMonth)
      {  
         for(int dayOfWeek = 0 ; dayOfWeek < 7 && day <= daysInMonth; dayOfWeek++)
         {
            grid.setWidget(week, dayOfWeek, getWidgetForDay(day, month, year));
            grid.getCellFormatter().addStyleName(week, dayOfWeek, "calendarCell");
            day++;
         }
         week++;
      }
      
      monthLabel.setText(months[currentDateDisplayed.getMonth()] + 
         " " + currentDateDisplayed.getFullYear());
   }

   private Widget getWidgetForDay(int day, int month, int year)
   {
      List<VolunteerHours> volunteerHoursCollection = 
         volunteerHoursManager.getVolunteerHours(day, month, year);
      
      return new HoursEnteredCell(volunteerHoursCollection, day, month, year);
   }
   
}
