package com.mmsn.reportgen.client.view.report;

import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.mmsn.reportgen.client.view.StringModel;

public class SpeciesField extends VerticalPanel
{
   // --------------------------------------------------------------------------
   // Private Data
   // --------------------------------------------------------------------------
   
   private ComboBox<StringModel> speciesField;
   
   // --------------------------------------------------------------------------
   // Constructor
   // --------------------------------------------------------------------------
   
   public SpeciesField()
   {
      initialize();
   }
   
   // --------------------------------------------------------------------------
   // Public Members
   // --------------------------------------------------------------------------

   public String getRawValue()
   {
      return speciesField.getRawValue();
   }

   public void setValue(String species)
   {
      speciesField.setValue(new StringModel(species));
   }

   public void setReadOnly(boolean readOnly)
   {
      speciesField.setReadOnly(readOnly);
   }
   
   // --------------------------------------------------------------------------
   // Private Members
   // --------------------------------------------------------------------------
 
   private void initialize()
   {
      ListStore<StringModel> listStore = new ListStore<StringModel>();
      
      listStore.add(new StringModel("Californian Sea Lion"));
      listStore.add(new StringModel("Steller Sea Lion"));
      listStore.add(new StringModel("Dall's Porpoise"));
      listStore.add(new StringModel("Harbor Porpoise"));
      listStore.add(new StringModel("Harbor Seal"));
      listStore.add(new StringModel("Northern Elephant Seal"));
      listStore.add(new StringModel("Other"));
      
      speciesField = new ComboBox<StringModel>();
      speciesField.setFieldLabel("Species");
      speciesField.setDisplayField("name");
      speciesField.setTriggerAction(TriggerAction.ALL);
      speciesField.setStore(listStore);
      
      add(speciesField);
   }
}
