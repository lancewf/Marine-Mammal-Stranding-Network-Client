package com.mmsn.reportgen.client.view;

import com.extjs.gxt.ui.client.data.BaseModel;

public class StringModel extends BaseModel
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   public StringModel(String name)
   {
      set("name", name);
   }
   
   public String getName()
   {
      return get("name");
   }
}
