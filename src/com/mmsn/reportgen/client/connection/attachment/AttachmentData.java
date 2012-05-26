package com.mmsn.reportgen.client.connection.attachment;

import com.google.gwt.core.client.JavaScriptObject;

public class AttachmentData extends JavaScriptObject
{
   protected AttachmentData() 
   {
      
   }
   
   public final native int getId()
   /*-{
      return this.id;
   }-*/;
   
   public final native String getFileName()
   /*-{
      return this.file_name;
   }-*/;
   
   public final native String getComments()
   /*-{
      return this.comments;
   }-*/;
}
