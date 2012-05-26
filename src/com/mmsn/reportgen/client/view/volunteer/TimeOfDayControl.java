package com.mmsn.reportgen.client.view.volunteer;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;

public class TimeOfDayControl extends HorizontalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private ListBox hourFromListBox;
   private ListBox hourToListBox;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public TimeOfDayControl()
   {
      hourFromListBox = new ListBox();
      
      hourFromListBox.addItem("");
      hourFromListBox.addItem("12 am");
      hourFromListBox.addItem("1 am");
      hourFromListBox.addItem("2 am");
      hourFromListBox.addItem("3 am");
      hourFromListBox.addItem("4 am");
      hourFromListBox.addItem("5 am");
      hourFromListBox.addItem("6 am");
      hourFromListBox.addItem("7 am");
      hourFromListBox.addItem("8 am");
      hourFromListBox.addItem("9 am");
      hourFromListBox.addItem("10 am");
      hourFromListBox.addItem("11 am");
      hourFromListBox.addItem("12 pm");
      hourFromListBox.addItem("1 pm");
      hourFromListBox.addItem("2 pm");
      hourFromListBox.addItem("3 pm");
      hourFromListBox.addItem("4 pm");
      hourFromListBox.addItem("5 pm");
      hourFromListBox.addItem("6 pm");
      hourFromListBox.addItem("7 pm");
      hourFromListBox.addItem("8 pm");
      hourFromListBox.addItem("9 pm");
      hourFromListBox.addItem("10 pm");
      hourFromListBox.addItem("11 pm");
      
      hourToListBox = new ListBox();
      
      hourToListBox.addItem("");
      hourToListBox.addItem("12 am");
      hourToListBox.addItem("1 am");
      hourToListBox.addItem("2 am");
      hourToListBox.addItem("3 am");
      hourToListBox.addItem("4 am");
      hourToListBox.addItem("5 am");
      hourToListBox.addItem("6 am");
      hourToListBox.addItem("7 am");
      hourToListBox.addItem("8 am");
      hourToListBox.addItem("9 am");
      hourToListBox.addItem("10 am");
      hourToListBox.addItem("11 am");
      hourToListBox.addItem("12 pm");
      hourToListBox.addItem("1 pm");
      hourToListBox.addItem("2 pm");
      hourToListBox.addItem("3 pm");
      hourToListBox.addItem("4 pm");
      hourToListBox.addItem("5 pm");
      hourToListBox.addItem("6 pm");
      hourToListBox.addItem("7 pm");
      hourToListBox.addItem("8 pm");
      hourToListBox.addItem("9 pm");
      hourToListBox.addItem("10 pm");
      hourToListBox.addItem("11 pm");
      
      add(hourFromListBox);
      add(hourToListBox);
   }

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setHourFrom(int hour24)
   {
      hourFromListBox.setSelectedIndex((hour24 + 1));
   }
   
   public void setHourTo(int hour24)
   {
      hourToListBox.setSelectedIndex((hour24 + 1));
   }
   
   public int getHourFrom()
   {      
      return hourFromListBox.getSelectedIndex() - 1;
   }
   
   public int getHourTo()
   {
      return hourToListBox.getSelectedIndex() - 1;
   }

   public void setEnabled(boolean enabled)
   {
      if(enabled)
      {
         hourFromListBox.setEnabled(true);
         hourToListBox.setEnabled(true);
      }
      else
      {
         hourFromListBox.setItemSelected(0, true);
         hourFromListBox.setEnabled(false);
         hourToListBox.setItemSelected(0, true);
         hourToListBox.setEnabled(false);
      }
   }
   
   public void setReadOnly(boolean readOnly)
   {
      if(readOnly)
      {
         hourFromListBox.setEnabled(true);
         hourToListBox.setEnabled(true);
      }
      else
      {
         hourFromListBox.setEnabled(false);
         hourToListBox.setEnabled(false);
      }
   }

   public void clearData()
   {
      hourFromListBox.setItemSelected(0, true);
      hourFromListBox.setEnabled(true);
      hourToListBox.setItemSelected(0, true);
      hourToListBox.setEnabled(true);
   }
   
}
