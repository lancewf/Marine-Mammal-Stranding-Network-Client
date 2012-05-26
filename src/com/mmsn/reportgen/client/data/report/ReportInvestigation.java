package com.mmsn.reportgen.client.data.report;

import java.util.Date;

public class ReportInvestigation
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private String investigatorSupport;
   private Date date;
   private String latLonLocation;
   private String physicalLocation;
   private String species;
   private boolean animalNotFound;
   private String condition;
   private String tags;
   private String disposition;
   private String sealPickup;
   private String sex;
   private double weight;
   private double straightLength;
   private double contourLength;
   private double girth;
   private String comments;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public ReportInvestigation()
   {
      
   }

   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------
  
   public String getInvestigatorSupport()
   {
      return investigatorSupport;
   }

   public String getLatLonLocation()
   {
      return latLonLocation;
   }

   public void setLatLonLocation(String latLonLocation)
   {
      this.latLonLocation = latLonLocation;
   }

   public String getPhysicalLocation()
   {
      return physicalLocation;
   }

   public void setPhysicalLocation(String physicalLocation)
   {
      this.physicalLocation = physicalLocation;
   }

   public boolean isAnimalNotFound()
   {
      return animalNotFound;
   }

   public void setAnimalNotFound(boolean animalNotFound)
   {
      this.animalNotFound = animalNotFound;
   }

   public void setInvestigatorSupport(String investigatorSupport)
   {
      this.investigatorSupport = investigatorSupport;
   }

   public Date getDate()
   {
      return date;
   }

   public void setDate(Date date)
   {
      this.date = date;
   }

   public String getSpecies()
   {
      return species;
   }

   public void setSpecies(String species)
   {
      this.species = species;
   }

   public String getCondition()
   {
      return condition;
   }

   public void setCondition(String condition)
   {
      this.condition = condition;
   }

   public String getTags()
   {
      return tags;
   }

   public void setTags(String tags)
   {
      this.tags = tags;
   }

   public String getDisposition()
   {
      return disposition;
   }

   public void setDisposition(String disposition)
   {
      this.disposition = disposition;
   }

   public String getSealPickup()
   {
      return sealPickup;
   }

   public void setSealPickup(String sealPickup)
   {
      this.sealPickup = sealPickup;
   }

   public String getSex()
   {
      return sex;
   }

   public void setSex(String sex)
   {
      this.sex = sex;
   }

   public double getWeight()
   {
      return weight;
   }

   public void setWeight(double weight)
   {
      this.weight = weight;
   }

   public double getStraightLength()
   {
      return straightLength;
   }

   public void setStraightLength(double straightLength)
   {
      this.straightLength = straightLength;
   }

   public double getContourLength()
   {
      return contourLength;
   }

   public void setContourLength(double contourLength)
   {
      this.contourLength = contourLength;
   }

   public double getGirth()
   {
      return girth;
   }

   public void setGirth(double girth)
   {
      this.girth = girth;
   }

   public String getComments()
   {
      return comments;
   }

   public void setComments(String comments)
   {
      this.comments = comments;
   }
}
