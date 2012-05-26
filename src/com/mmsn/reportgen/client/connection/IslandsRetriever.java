package com.mmsn.reportgen.client.connection;

import java.util.ArrayList;
import java.util.List;

import com.finfrock.client.Retriever;

public class IslandsRetriever extends Retriever<List<String>>
{
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public IslandsRetriever(ServiceLocations serviceLocations)
   {
      super(serviceLocations.getIslandsAddress());
   }
   
   // --------------------------------------------------------------------------
   // Retriever Members
   // --------------------------------------------------------------------------
   
   @Override
   protected List<String> parseText(String rawText)
   {
      String[] islands = rawText.split(";");

      List<String> islandList = new ArrayList<String>();
      for(String island : islands)
      {
         islandList.add(island);
      }
      
      return islandList;
   }
}
