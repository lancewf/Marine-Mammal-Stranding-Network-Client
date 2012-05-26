package com.mmsn.reportgen.client.connection;

import com.finfrock.client.Returnable;
import com.finfrock.client.SenderAndReceiver;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.mmsn.reportgen.client.data.TotalHoursAndMiles;

public class VolunteerHoursAndMilesCalculator extends SenderAndReceiver
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private int fromMonth;
   private int toMonth;
   private int fromYear;
   private int toYear;
   private Returnable<TotalHoursAndMiles> returnable;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public VolunteerHoursAndMilesCalculator(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getVolunteerHoursAndMilesCalculatorAddress());
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public void setFromMonth(int fromMonth)
   {
      this.fromMonth = fromMonth;
   }

   public void setToMonth(int toMonth)
   {
      this.toMonth = toMonth;
   }

   public void setFromYear(int fromYear)
   {
      this.fromYear = fromYear;
   }

   public void setToYear(int toYear)
   {
      this.toYear = toYear;
   }
   
   public void setReturnable(Returnable<TotalHoursAndMiles> returnable)
   {
      this.returnable = returnable;
   }
   
   // --------------------------------------------------------------------------
   // Protected Members
   // --------------------------------------------------------------------------
   
   protected String getData()
   {
      String requestData = "";
      
      JSONObject request = new JSONObject();
      
      request.put("from_month", new JSONNumber(fromMonth));
      request.put("to_month", new JSONNumber(toMonth));
      request.put("from_year", new JSONNumber(fromYear));
      request.put("to_year", new JSONNumber(toYear));
      
      requestData += "json=" + request.toString();
      
      return requestData;
   }

   @Override
   protected void reponse(String reponse)
   {
      //Window.alert(reponse);
      JSONValue value = JSONParser.parse(reponse);
      
      JSONObject obj = value.isObject();
      
      if(reponse == null || obj == null)
      {
         Window.alert("Error calculating: " + reponse);
         return;
      }
     
      double totalHours = obj.get("total_hours").isNumber().doubleValue();
      
      double totalMiles = obj.get("total_miles").isNumber().doubleValue();
      
      TotalHoursAndMiles totalHoursAndMiles = 
         new TotalHoursAndMiles();
      
      totalHoursAndMiles.setTotalHours(totalHours);
      totalHoursAndMiles.setTotalMiles(totalMiles);
      
      returnable.returned(totalHoursAndMiles);
   }
}
