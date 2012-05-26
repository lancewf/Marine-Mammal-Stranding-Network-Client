package com.mmsn.reportgen.client.view.volunteer;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.mmsn.reportgen.client.data.volunteer.Availablity;

public class HoursAvailableControl extends FlexTable
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private TimeOfDayControl sundayHours;
   private TimeOfDayControl mondayHours;
   private TimeOfDayControl tuesdayHours;
   private TimeOfDayControl wednesdayHours;
   private TimeOfDayControl thursdayHours;
   private TimeOfDayControl fridayHours;
   private TimeOfDayControl saturdayHours;
   
   private CheckBox sundayAnyTime;
   private CheckBox mondayAnyTime;
   private CheckBox tuesdayAnyTime;
   private CheckBox wednesdayAnyTime;
   private CheckBox thursdayAnyTime;
   private CheckBox fridayAnyTime;
   private CheckBox saturdayAnyTime;
   
   private CheckBox sundayNoTime;
   private CheckBox mondayNoTime;
   private CheckBox tuesdayNoTime;
   private CheckBox wednesdayNoTime;
   private CheckBox thursdayNoTime;
   private CheckBox fridayNoTime;
   private CheckBox saturdayNoTime;
   private boolean readOnly = false;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public HoursAvailableControl()
   {
      addStyleName("table");
      
      initialize();
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public Availablity getAvailablity()
   {
      Availablity availablity = new Availablity();
      
      availablity.setSundayFromHour(sundayHours.getHourFrom());
      availablity.setSundayToHour(sundayHours.getHourTo());
      availablity.setSundayAnyTime(sundayAnyTime.getValue());
      availablity.setSundayNoTime(sundayNoTime.getValue());
      
      availablity.setMondayFromHour(mondayHours.getHourFrom());
      availablity.setMondayToHour(mondayHours.getHourTo());
      availablity.setMondayAnyTime(mondayAnyTime.getValue());
      availablity.setMondayNoTime(mondayNoTime.getValue());
      
      availablity.setTuesdayFromHour(tuesdayHours.getHourFrom());
      availablity.setTuesdayToHour(tuesdayHours.getHourTo());
      availablity.setTuesdayAnyTime(tuesdayAnyTime.getValue());
      availablity.setTuesdayNoTime(tuesdayNoTime.getValue());
      
      availablity.setWednesdayFromHour(wednesdayHours.getHourFrom());
      availablity.setWednesdayToHour(wednesdayHours.getHourTo());
      availablity.setWednesdayAnyTime(wednesdayAnyTime.getValue());
      availablity.setWednesdayNoTime(wednesdayNoTime.getValue());
      
      availablity.setThursdayFromHour(thursdayHours.getHourFrom());
      availablity.setThursdayToHour(thursdayHours.getHourTo());
      availablity.setThursdayAnyTime(thursdayAnyTime.getValue());
      availablity.setThursdayNoTime(thursdayNoTime.getValue());
      
      availablity.setFridayFromHour(fridayHours.getHourFrom());
      availablity.setFridayToHour(fridayHours.getHourTo());
      availablity.setFridayAnyTime(fridayAnyTime.getValue());
      availablity.setFridayNoTime(fridayNoTime.getValue());
      
      availablity.setSaturdayFromHour(saturdayHours.getHourFrom());
      availablity.setSaturdayToHour(saturdayHours.getHourTo());
      availablity.setSaturdayAnyTime(saturdayAnyTime.getValue());
      availablity.setSaturdayNoTime(saturdayNoTime.getValue());
      
      return availablity;
   }
   
   public void setAvailablity(Availablity availablity)
   {
      if (availablity != null)
      {
         sundayHours.setHourFrom(availablity.getSundayFromHour());
         sundayHours.setHourTo(availablity.getSundayToHour());
         mondayHours.setHourFrom(availablity.getMondayFromHour());
         mondayHours.setHourTo(availablity.getMondayToHour());
         tuesdayHours.setHourFrom(availablity.getTuesdayFromHour());
         tuesdayHours.setHourTo(availablity.getTuesdayToHour());
         wednesdayHours.setHourFrom(availablity.getWednesdayFromHour());
         wednesdayHours.setHourTo(availablity.getWednesdayToHour());
         thursdayHours.setHourFrom(availablity.getThursdayFromHour());
         thursdayHours.setHourTo(availablity.getThursdayToHour());
         fridayHours.setHourFrom(availablity.getFridayFromHour());
         fridayHours.setHourTo(availablity.getFridayToHour());
         saturdayHours.setHourFrom(availablity.getSundayFromHour());
         saturdayHours.setHourTo(availablity.getSaturdayToHour());

         sundayAnyTime.setValue(availablity.isSundayAnyTime());
         mondayAnyTime.setValue(availablity.isMondayAnyTime());
         tuesdayAnyTime.setValue(availablity.isTuesdayAnyTime());
         wednesdayAnyTime.setValue(availablity.isWednesdayAnyTime());
         thursdayAnyTime.setValue(availablity.isThursdayAnyTime());
         fridayAnyTime.setValue(availablity.isFridayAnyTime());
         saturdayAnyTime.setValue(availablity.isSaturdayAnyTime());

         sundayNoTime.setValue(availablity.isSundayNoTime());
         mondayNoTime.setValue(availablity.isMondayNoTime());
         tuesdayNoTime.setValue(availablity.isTuesdayNoTime());
         wednesdayNoTime.setValue(availablity.isWednesdayNoTime());
         thursdayNoTime.setValue(availablity.isThursdayNoTime());
         fridayNoTime.setValue(availablity.isFridayNoTime());
         saturdayNoTime.setValue(availablity.isSaturdayNoTime());
         
         setEnabledControls();
      }
   }
   
   public void setReadOnly(boolean readOnly)
   {
      this.readOnly = readOnly;
      
      if (readOnly)
      {
         sundayHours.setReadOnly(false);
         mondayHours.setReadOnly(false);
         tuesdayHours.setReadOnly(false);
         wednesdayHours.setReadOnly(false);
         thursdayHours.setReadOnly(false);
         fridayHours.setReadOnly(false);
         saturdayHours.setReadOnly(false);

         sundayAnyTime.setEnabled(false);
         mondayAnyTime.setEnabled(false);
         tuesdayAnyTime.setEnabled(false);
         wednesdayAnyTime.setEnabled(false);
         thursdayAnyTime.setEnabled(false);
         fridayAnyTime.setEnabled(false);
         saturdayAnyTime.setEnabled(false);

         sundayNoTime.setEnabled(false);
         mondayNoTime.setEnabled(false);
         tuesdayNoTime.setEnabled(false);
         wednesdayNoTime.setEnabled(false);
         thursdayNoTime.setEnabled(false);
         fridayNoTime.setEnabled(false);
         saturdayNoTime.setEnabled(false);
      }
      else
      {
         setEnabledControls();
         
         sundayAnyTime.setEnabled(true);
         mondayAnyTime.setEnabled(true);
         tuesdayAnyTime.setEnabled(true);
         wednesdayAnyTime.setEnabled(true);
         thursdayAnyTime.setEnabled(true);
         fridayAnyTime.setEnabled(true);
         saturdayAnyTime.setEnabled(true);

         sundayNoTime.setEnabled(true);
         mondayNoTime.setEnabled(true);
         tuesdayNoTime.setEnabled(true);
         wednesdayNoTime.setEnabled(true);
         thursdayNoTime.setEnabled(true);
         fridayNoTime.setEnabled(true);
         saturdayNoTime.setEnabled(true);
      }
   }
   
   public void clearData()
   {
      sundayHours.clearData();
      mondayHours.clearData();
      tuesdayHours.clearData();
      wednesdayHours.clearData();
      thursdayHours.clearData();
      fridayHours.clearData();
      saturdayHours.clearData();

      sundayAnyTime.setEnabled(true);
      mondayAnyTime.setEnabled(true);
      tuesdayAnyTime.setEnabled(true);
      wednesdayAnyTime.setEnabled(true);
      thursdayAnyTime.setEnabled(true);
      fridayAnyTime.setEnabled(true);
      saturdayAnyTime.setEnabled(true);

      sundayNoTime.setEnabled(true);
      mondayNoTime.setEnabled(true);
      tuesdayNoTime.setEnabled(true);
      wednesdayNoTime.setEnabled(true);
      thursdayNoTime.setEnabled(true);
      fridayNoTime.setEnabled(true);
      saturdayNoTime.setEnabled(true);
      
      sundayAnyTime.setValue(false);
      mondayAnyTime.setValue(false);
      tuesdayAnyTime.setValue(false);
      wednesdayAnyTime.setValue(false);
      thursdayAnyTime.setValue(false);
      fridayAnyTime.setValue(false);
      saturdayAnyTime.setValue(false);

      sundayNoTime.setValue(false);
      mondayNoTime.setValue(false);
      tuesdayNoTime.setValue(false);
      wednesdayNoTime.setValue(false);
      thursdayNoTime.setValue(false);
      fridayNoTime.setValue(false);
      saturdayNoTime.setValue(false);
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void setEnabledControls()
   {
      if (!readOnly)
      {
         if (sundayNoTime.getValue())
         {
            sundayHours.setEnabled(false);
         }
         else if (sundayAnyTime.getValue())
         {
            sundayHours.setEnabled(false);
         }
         else
         {
            sundayHours.setEnabled(true);
         }

         if (mondayNoTime.getValue())
         {
            mondayHours.setEnabled(false);
         }
         else if (mondayAnyTime.getValue())
         {
            mondayHours.setEnabled(false);
         }
         else
         {
            mondayHours.setEnabled(true);
         }

         if (tuesdayNoTime.getValue())
         {
            tuesdayHours.setEnabled(false);
         }
         else if (tuesdayAnyTime.getValue())
         {
            tuesdayHours.setEnabled(false);
         }
         else
         {
            tuesdayHours.setEnabled(true);
         }

         if (wednesdayNoTime.getValue())
         {
            wednesdayHours.setEnabled(false);
         }
         else if (wednesdayAnyTime.getValue())
         {
            wednesdayHours.setEnabled(false);
         }
         else
         {
            wednesdayHours.setEnabled(true);
         }

         if (thursdayNoTime.getValue())
         {
            thursdayHours.setEnabled(false);
         }
         else if (thursdayAnyTime.getValue())
         {
            thursdayHours.setEnabled(false);
         }
         else
         {
            thursdayHours.setEnabled(true);
         }

         if (fridayNoTime.getValue())
         {
            fridayHours.setEnabled(false);
         }
         else if (fridayAnyTime.getValue())
         {
            fridayHours.setEnabled(false);
         }
         else
         {
            fridayHours.setEnabled(true);
         }

         if (saturdayNoTime.getValue())
         {
            saturdayHours.setEnabled(false);
         }
         else if (saturdayAnyTime.getValue())
         {
            saturdayHours.setEnabled(false);
         }
         else
         {
            saturdayHours.setEnabled(true);
         }
      }
   }

   private void initialize()
   {
      createHeader();
      
      createFromToHours();
      
      createAnyTimeRow();
      
      createNoTimeRow();
   }

   private void createNoTimeRow()
   {
      setText(3, 0, "No Time:");
      getCellFormatter().addStyleName(3, 0, "tableHeader");
      
      sundayNoTime = new CheckBox();
      setWidget(3, 1, sundayNoTime);
      getCellFormatter().addStyleName(3, 1, "buttonColumn");
      sundayNoTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(sundayNoTime.getValue())
            {
               sundayHours.setEnabled(false);
               sundayAnyTime.setValue(false);
            }
            else
            {
               sundayHours.setEnabled(true);
            }
         }
      });
      
      mondayNoTime = new CheckBox();
      setWidget(3, 2, mondayNoTime);
      getCellFormatter().addStyleName(3, 2, "buttonColumn");
      mondayNoTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(mondayNoTime.getValue())
            {
               mondayHours.setEnabled(false);
               mondayAnyTime.setValue(false);
            }
            else
            {
               mondayHours.setEnabled(true);
            }
         }
      });
      
      tuesdayNoTime = new CheckBox();
      setWidget(3, 3, tuesdayNoTime);
      getCellFormatter().addStyleName(3, 3, "buttonColumn");
      tuesdayNoTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(tuesdayNoTime.getValue())
            {
               tuesdayHours.setEnabled(false);
               tuesdayAnyTime.setValue(false);
            }
            else
            {
               tuesdayHours.setEnabled(true);
            }
         }
      });
      
      wednesdayNoTime = new CheckBox();
      setWidget(3, 4, wednesdayNoTime);
      getCellFormatter().addStyleName(3, 4, "buttonColumn");
      wednesdayNoTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(wednesdayNoTime.getValue())
            {
               wednesdayHours.setEnabled(false);
               wednesdayAnyTime.setValue(false);
            }
            else
            {
               wednesdayHours.setEnabled(true);
            }
         }
      });
      
      thursdayNoTime = new CheckBox();
      setWidget(3, 5, thursdayNoTime);
      getCellFormatter().addStyleName(3, 5, "buttonColumn");
      thursdayNoTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(thursdayNoTime.getValue())
            {
               thursdayHours.setEnabled(false);
               thursdayAnyTime.setValue(false);
            }
            else
            {
               thursdayHours.setEnabled(true);
            }
         }
      });
      
      fridayNoTime = new CheckBox();
      setWidget(3, 6, fridayNoTime);
      getCellFormatter().addStyleName(3, 6, "buttonColumn");
      fridayNoTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(fridayNoTime.getValue())
            {
               fridayHours.setEnabled(false);
               fridayAnyTime.setValue(false);
            }
            else
            {
               fridayHours.setEnabled(true);
            }
         }
      });
      
      saturdayNoTime = new CheckBox();
      setWidget(3, 7, saturdayNoTime);
      getCellFormatter().addStyleName(3, 7, "buttonColumn");
      saturdayNoTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(saturdayNoTime.getValue())
            {
               saturdayHours.setEnabled(false);
               saturdayAnyTime.setValue(false);
            }
            else
            {
               saturdayHours.setEnabled(true);
            }
         }
      });
      
   }

   private void createAnyTimeRow()
   {
      setText(2, 0, "Any Time:");
      getCellFormatter().addStyleName(2, 0, "tableHeader");
      
      sundayAnyTime = new CheckBox();
      setWidget(2, 1, sundayAnyTime);
      getCellFormatter().addStyleName(2, 1, "buttonColumn");
      sundayAnyTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(sundayAnyTime.getValue())
            {
               sundayHours.setEnabled(false);
               sundayNoTime.setValue(false);
            }
            else
            {
               sundayHours.setEnabled(true);
            }
         }
      });
      
      mondayAnyTime = new CheckBox();
      setWidget(2, 2, mondayAnyTime);
      getCellFormatter().addStyleName(2, 2, "buttonColumn");
      mondayAnyTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(mondayAnyTime.getValue())
            {
               mondayHours.setEnabled(false);
               mondayNoTime.setValue(false);
            }
            else
            {
               mondayHours.setEnabled(true);
            }
         }
      });
      
      tuesdayAnyTime = new CheckBox();
      setWidget(2, 3, tuesdayAnyTime);
      getCellFormatter().addStyleName(2, 3, "buttonColumn");
      tuesdayAnyTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(tuesdayAnyTime.getValue())
            {
               tuesdayHours.setEnabled(false);
               tuesdayNoTime.setValue(false);
            }
            else
            {
               tuesdayHours.setEnabled(true);
            }
         }
      });
      
      wednesdayAnyTime = new CheckBox();
      setWidget(2, 4, wednesdayAnyTime);
      getCellFormatter().addStyleName(2, 4, "buttonColumn");
      wednesdayAnyTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(wednesdayAnyTime.getValue())
            {
               wednesdayHours.setEnabled(false);
               wednesdayNoTime.setValue(false);
            }
            else
            {
               wednesdayHours.setEnabled(true);
            }
         }
      });
      
      thursdayAnyTime = new CheckBox();
      setWidget(2, 5, thursdayAnyTime);
      getCellFormatter().addStyleName(2, 5, "buttonColumn");
      thursdayAnyTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(thursdayAnyTime.getValue())
            {
               thursdayHours.setEnabled(false);
               thursdayNoTime.setValue(false);
            }
            else
            {
               thursdayHours.setEnabled(true);
            }
         }
      });
      
      fridayAnyTime = new CheckBox();
      setWidget(2, 6, fridayAnyTime);
      getCellFormatter().addStyleName(2, 6, "buttonColumn");
      fridayAnyTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(fridayAnyTime.getValue())
            {
               fridayHours.setEnabled(false);
               fridayNoTime.setValue(false);
            }
            else
            {
               fridayHours.setEnabled(true);
            }
         }
      });
      
      saturdayAnyTime = new CheckBox();
      setWidget(2, 7, saturdayAnyTime);
      getCellFormatter().addStyleName(2, 7, "buttonColumn");
      saturdayAnyTime.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            if(saturdayAnyTime.getValue())
            {
               saturdayHours.setEnabled(false);
               saturdayNoTime.setValue(false);
            }
            else
            {
               saturdayHours.setEnabled(true);
            }
         }
      });
      
   }

   private void createFromToHours()
   {
      setText(1, 0, "From/To:");
      getCellFormatter().addStyleName(1, 0, "tableHeader");
      
      sundayHours = new TimeOfDayControl();
      setWidget(1, 1, sundayHours);
      
      mondayHours = new TimeOfDayControl();
      setWidget(1, 2, mondayHours);
      
      tuesdayHours = new TimeOfDayControl();
      setWidget(1, 3, tuesdayHours);
      
      wednesdayHours = new TimeOfDayControl();
      setWidget(1, 4, wednesdayHours);
      
      thursdayHours = new TimeOfDayControl();
      setWidget(1, 5, thursdayHours);
      
      fridayHours = new TimeOfDayControl();
      setWidget(1, 6, fridayHours);
      
      saturdayHours = new TimeOfDayControl();
      setWidget(1, 7, saturdayHours);
   }

   private void createHeader()
   {
      getCellFormatter().addStyleName(0, 0, "tableHeader");
      getCellFormatter().addStyleName(0, 1, "tableHeader");
      getCellFormatter().addStyleName(0, 2, "tableHeader");
      getCellFormatter().addStyleName(0, 3, "tableHeader");
      getCellFormatter().addStyleName(0, 4, "tableHeader");
      getCellFormatter().addStyleName(0, 5, "tableHeader");
      getCellFormatter().addStyleName(0, 6, "tableHeader");
      getCellFormatter().addStyleName(0, 7, "tableHeader");
    
      setText(0, 0, "");
      setText(0, 1, "Sunday");
      setText(0, 2, "Monday");
      setText(0, 3, "Tuesday");
      setText(0, 4, "Wednesday");
      setText(0, 5, "Thursday");
      setText(0, 6, "Friday");
      setText(0, 7, "Saturday");
   }
}
