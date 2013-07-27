package com.mmsn.reportgen.client.view;

import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.form.TextField;

public class PhoneNumberField extends TextField<String>{

	// --------------------------------------------------------------------------
	// Private Data
	// --------------------------------------------------------------------------
	   
	private static final String AREA_CODE_WARNING = "Include Area Code"; 
	
	// --------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------
	   
	public PhoneNumberField()
	{
		setValue(AREA_CODE_WARNING);
		
		addListener(Events.Focus, new Listener<FieldEvent>() {

			@Override
			public void handleEvent(FieldEvent be) 
			{
				if(!isReadOnly() && getRawValue().equals(AREA_CODE_WARNING))
				{
					setValue("");
				}
			}
		});
	}
	
	// --------------------------------------------------------------------------
	// Public Members
	// --------------------------------------------------------------------------

	
	public void setReadOnly(boolean readOnly)
	{
		if(readOnly)
		{
			if(getRawValue().equals(AREA_CODE_WARNING))
			{
				setValue("");
			}
		}
		else
		{
			if(getRawValue().length() == 0)
			{
				setValue(AREA_CODE_WARNING);
			}
		}
		
		super.setReadOnly(readOnly);
	}
}
