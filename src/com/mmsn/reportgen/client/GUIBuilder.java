package com.mmsn.reportgen.client;

import com.finfrock.client.DataChangeListener;
import com.finfrock.client.Returnable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mmsn.reportgen.client.connection.DataBuilder;
import com.mmsn.reportgen.client.connection.LoadManager;
import com.mmsn.reportgen.client.connection.ReleaseServiceLocations;
import com.mmsn.reportgen.client.connection.ServiceLocations;
import com.mmsn.reportgen.client.connection.TestServiceLocations;
import com.mmsn.reportgen.client.data.User;
import com.mmsn.reportgen.client.view.LoginPanel;
import com.mmsn.reportgen.client.view.MainPanelControl;
import com.mmsn.reportgen.client.view.TitlePanel;

public class GUIBuilder
{
   // --------------------------------------------------------------------------
   // Private Class Data
   // --------------------------------------------------------------------------

   private static final String MAIN_DIV_TAG = "main";

   private static final String TITLE_DIV_TAG = "title";

   private LoginPanel loginPanel;

   private DataBuilder dataBuilder;

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public void build()
   {
      Widget titlePanel = new TitlePanel();

      RootPanel.get(TITLE_DIV_TAG).add(titlePanel);

      loadPanels();
   }

   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------

   private void loadPanels()
   {
      final ServiceLocations serviceLocations = getServiceLocations();

      loginPanel = createLoginPanel();

      RootPanel.get(MAIN_DIV_TAG).add(loginPanel);

      LoadManager loadManager = new LoadManager(serviceLocations);

      loadManager.startLoad(new Returnable<DataBuilder>()
      {
         @Override
         public void returned(DataBuilder dataBuilder)
         {
            GUIBuilder.this.dataBuilder = dataBuilder;

            loadMainPanel(serviceLocations);
         }
      });

      loginPanel.addOnSubmitListener(new DataChangeListener()
      {
         @Override
         public void onDataChange()
         {
            loadMainPanel(serviceLocations);
         }
      });
   }

   private void loadMainPanel(ServiceLocations serviceLocations)
   {
      if (dataBuilder != null && loginPanel.isSubmitted())
      {
         RootPanel.get(MAIN_DIV_TAG).remove(loginPanel);

         User user = new User(loginPanel.isAdmin());
         
         WidgetFactory widgetFactory = new WidgetFactory(
            dataBuilder.getReportManager(), 
            dataBuilder.getVolunteerManager(), 
            user, dataBuilder.getIslands(), dataBuilder.getBlogManager(), 
            serviceLocations);
         
         Widget homePanel = new MainPanelControl(widgetFactory);

         RootPanel.get(MAIN_DIV_TAG).add(homePanel);
      }
   }

   private ServiceLocations getServiceLocations()
   {
      //return new ReleaseServiceLocations();
      return new TestServiceLocations();
   }

   private LoginPanel createLoginPanel()
   {
      return new LoginPanel();
   }
}
