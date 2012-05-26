package com.mmsn.reportgen.client.data.report;

import java.util.Date;

public class ReportCall
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private String responder;

   private Date date;
   
   private String callFrom;

   private String callerName;

   private String callerPhoneNumber;

   private String location;

   private String species;

   private String whenFirstSeen;

   private String comments;

   private String callReferredTo;
   
   private String condition;

   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportCall()
   {
      
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
   
   public String getResponder()
   {
      return responder;
   }

   public void setResponder(String responder)
   {
      this.responder = responder;
   }

   public Date getDate()
   {
      return date;
   }

   public void setDate(Date date)
   {
      this.date = date;
   }

   public String getCallFrom()
   {
      return callFrom;
   }

   public void setCallFrom(String callFrom)
   {
      this.callFrom = callFrom;
   }

   public String getCallerName()
   {
      return callerName;
   }

   public void setCallerName(String callerName)
   {
      this.callerName = callerName;
   }

   public String getCallerPhoneNumber()
   {
      return callerPhoneNumber;
   }

   public void setCallerPhoneNumber(String callerPhoneNumber)
   {
      this.callerPhoneNumber = callerPhoneNumber;
   }

   public String getLocation()
   {
      return location;
   }

   public void setLocation(String location)
   {
      this.location = location;
   }

   public String getSpecies()
   {
      return species;
   }

   public void setSpecies(String species)
   {
      this.species = species;
   }

   public String getWhenFirstSeen()
   {
      return whenFirstSeen;
   }

   public void setWhenFirstSeen(String whenFirstSeen)
   {
      this.whenFirstSeen = whenFirstSeen;
   }

   public String getComments()
   {
      return comments;
   }

   public void setComments(String comments)
   {
      this.comments = comments;
   }

   public String getCallReferredTo()
   {
      return callReferredTo;
   }

   public void setCallReferredTo(String callReferredTo)
   {
      this.callReferredTo = callReferredTo;
   }

   public String getCondition()
   {
      return condition;
   }
   
   public void setCondition(String condition)
   {
      this.condition = condition;
   }
}
