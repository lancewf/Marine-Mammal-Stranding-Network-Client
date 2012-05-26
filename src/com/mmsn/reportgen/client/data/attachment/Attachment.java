package com.mmsn.reportgen.client.data.attachment;

import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

public class Attachment
{  
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------

   private int id;

   private String fileName;

   private String comments;

   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------

   public Attachment()
   {
      
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getFileName()
   {
      return fileName;
   }

   public void setFileName(String fileName)
   {
      this.fileName = fileName;
   }

   public String getComments()
   {
      return comments;
   }

   public void setComments(String comments)
   {
      this.comments = comments;
   }

   public JSONValue getJson()
   {
      JSONObject request = new JSONObject();
      
      request.put("id", new JSONNumber(getId()));
      request.put("file_name", new JSONString(getFileName()));
      request.put("comments", new JSONString(getComments()));
      
      return request;
   }
}
