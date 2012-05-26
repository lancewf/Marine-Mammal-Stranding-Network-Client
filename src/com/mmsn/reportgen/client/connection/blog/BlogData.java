package com.mmsn.reportgen.client.connection.blog;

import com.google.gwt.core.client.JavaScriptObject;

public class BlogData extends JavaScriptObject
{
   protected BlogData() 
   {
      
   }
   
   public final native int getId()
   /*-{
      return this.id;
   }-*/;
   
   public final native String getTitle()
   /*-{
      return this.title;
   }-*/;
   
   public final native String getMessage()
   /*-{
      return this.message;
   }-*/;
   
   public final native int getDayOfMonth()
   /*-{
      return this.dayofmonth;
   }-*/;
   
   public final native int getMonth()
   /*-{
      return this.month;
   }-*/;
   
   public final native int getYear()
   /*-{
      return this.year;
   }-*/;
}
