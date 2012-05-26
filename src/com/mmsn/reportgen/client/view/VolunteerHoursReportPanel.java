package com.mmsn.reportgen.client.view;

import java.util.Date;

import com.extjs.gxt.ui.client.util.DateWrapper;
import com.finfrock.client.Returnable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.WidgetFactory;
import com.mmsn.reportgen.client.connection.VolunteerHoursAndMilesCalculator;
import com.mmsn.reportgen.client.data.TotalHoursAndMiles;
import com.mmsn.reportgen.client.view.images.MMSNClientBundle;

public class VolunteerHoursReportPanel extends VerticalPanel implements Panel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private WidgetFactory widgetFactory;
   private ListBox fromMonthBox;
   private ListBox toMonthBox;
   private Button calculate;
   private ListBox fromYearBox;
   private ListBox toYearBox;
   private Label totalHoursLabel;
   private Label totalMilesLabel;
   private Image loadingImage;
   private Label errorMessage;
   private VolunteerHoursAndMilesCalculator volunteerHoursAndMilesCalulator;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerHoursReportPanel(WidgetFactory widgetFactory, 
               VolunteerHoursAndMilesCalculator volunteerHoursAndMilesCalulator)
   {
      this.widgetFactory = widgetFactory;
      this.volunteerHoursAndMilesCalulator = volunteerHoursAndMilesCalulator;
      
      initialize();
   }
   
   // --------------------------------------------------------------------------
   // Panel Members
   // --------------------------------------------------------------------------
   
   @Override
   public String getPanelName()
   {
      return "Volunteer Hours Report";
   }

   @Override
   public Widget getToolbar()
   {
      return widgetFactory.getNavigationToolbar();
   }

   @Override
   public Widget getWidget()
   {
      return this;
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
   
   private void initialize()
   {
      addStyleName("viewpanelItem");
      
      MMSNClientBundle mmsnImageBundle = (MMSNClientBundle) GWT
      .create(MMSNClientBundle.class);
      
      ImageResource loadingImageResource = mmsnImageBundle.loadingIcon();

      loadingImage = new Image(loadingImageResource);
      
      loadingImage.setVisible(false);
      
      errorMessage = new Label("Error: \"From\" Date must be before or equal to the \"To\" Date");
      errorMessage.setVisible(false);
      
      setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
      setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
      
      VerticalPanel panel = new VerticalPanel();
      
      panel.addStyleName("viewpanelFolder");
      
      FlexTable flexTable = new FlexTable();
      flexTable.setCellSpacing(10);
      flexTable.addStyleName("reportControlTable");
      
      fromMonthBox = createMonthBox();
      fromMonthBox.addChangeHandler(new ChangeHandler()
      {
         @Override
         public void onChange(ChangeEvent event)
         {
            comboboxChange();
         }
      });
      
      fromYearBox = createYearBox();
      fromYearBox.addChangeHandler(new ChangeHandler()
      {
         @Override
         public void onChange(ChangeEvent event)
         {
            comboboxChange();
         }
      });
      
      toMonthBox = createMonthBox();
      toMonthBox.addChangeHandler(new ChangeHandler()
      {
         @Override
         public void onChange(ChangeEvent event)
         {
            comboboxChange();
         }
      });
      
      toYearBox = createYearBox();
      toYearBox.addChangeHandler(new ChangeHandler()
      {
         @Override
         public void onChange(ChangeEvent event)
         {
            comboboxChange();
         }
      });
      
      calculate = new Button("Calculate");
      
      calculate.addClickHandler(new ClickHandler()
      {
         @Override
         public void onClick(ClickEvent event)
         {
            calculatedClicked();
         }
      });
      
      totalHoursLabel = new Label("-");
      totalMilesLabel = new Label("-");

      int rowIndex = 1;
      
      flexTable.setWidget(rowIndex, 0 , errorMessage);
      flexTable.getFlexCellFormatter().setColSpan(rowIndex, 0, 3);
      
      rowIndex++;
      
      flexTable.setText(rowIndex, 0 , "From:");
      flexTable.setWidget(rowIndex, 1, fromMonthBox);
      flexTable.setWidget(rowIndex, 2, fromYearBox);
      
      rowIndex++;
      
      flexTable.setText(rowIndex, 0 , "To:");
      flexTable.setWidget(rowIndex, 1, toMonthBox);
      flexTable.setWidget(rowIndex, 2, toYearBox);
      
      rowIndex++;
      
      flexTable.setWidget(rowIndex, 0 , calculate);
      flexTable.setWidget(rowIndex, 2, loadingImage);
      
      rowIndex++;
      
      flexTable.setText(rowIndex, 0 , "Total Hours:");
      flexTable.setWidget(rowIndex, 1, totalHoursLabel);

      rowIndex++;
      
      flexTable.setText(rowIndex, 0 , "Total Miles:");
      flexTable.setWidget(rowIndex, 1, totalMilesLabel);
      
      panel.add(flexTable);
      
      add(panel);
   }
   
   private void comboboxChange()
   {
      totalHoursLabel.setText("-");
      totalMilesLabel.setText("-");
      errorMessage.setVisible(false);
   }
   
   private void calculatedClicked()
   {
      int fromMonth = fromMonthBox.getSelectedIndex() + 1;
      int toMonth = toMonthBox.getSelectedIndex() + 1;
      int fromYear = fromYearBox.getSelectedIndex() + 2010;
      int toYear = toYearBox.getSelectedIndex() + 2010;
    
      if ((fromYear == toYear && fromMonth <= toMonth) || (fromYear < toYear))
      {
         calculate.setVisible(false);
         loadingImage.setVisible(true);
         errorMessage.setVisible(false);
         
         volunteerHoursAndMilesCalulator.setFromMonth(fromMonth);
         volunteerHoursAndMilesCalulator.setToMonth(toMonth);
         volunteerHoursAndMilesCalulator.setFromYear(fromYear);
         volunteerHoursAndMilesCalulator.setToYear(toYear);

         volunteerHoursAndMilesCalulator
            .setReturnable(new Returnable<TotalHoursAndMiles>()
            {
               @Override
               public void returned(TotalHoursAndMiles totalHoursAndMiles)
               {
                  totalHoursLabel.setText(totalHoursAndMiles.getTotalHours()
                        + "");
                  totalMilesLabel.setText(totalHoursAndMiles.getTotalMiles()
                        + "");

                  calculate.setVisible(true);
                  loadingImage.setVisible(false);
               }
            });

         volunteerHoursAndMilesCalulator.send();
      }
      else
      {
         errorMessage.setVisible(true);
      }
   }
   
   private ListBox createYearBox()
   {
      ListBox yearBox = new ListBox();
      
      yearBox.addItem("2010", "2010");
      yearBox.addItem("2011", "2011");
      yearBox.addItem("2012", "2012");
      
      DateWrapper currentDateDisplayed = new DateWrapper(new Date());
      
      yearBox.setSelectedIndex(currentDateDisplayed.getFullYear()-2010);
      
      return yearBox;
   }
   
   private ListBox createMonthBox()
   {
      ListBox monthBox = new ListBox();
      
      DateWrapper currentDateDisplayed = new DateWrapper(new Date());
      
      monthBox.addItem("January", "1");
      monthBox.addItem("February", "2");
      monthBox.addItem("March", "3");
      monthBox.addItem("April", "4");
      monthBox.addItem("May", "5");
      monthBox.addItem("June", "6");
      monthBox.addItem("July", "7");
      monthBox.addItem("August", "8");
      monthBox.addItem("September", "9");
      monthBox.addItem("October", "10");
      monthBox.addItem("November", "11");
      monthBox.addItem("December", "12");
      
      monthBox.setSelectedIndex(currentDateDisplayed.getMonth());
      
      return monthBox;
   }
   
}
