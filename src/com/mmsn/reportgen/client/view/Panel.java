package com.mmsn.reportgen.client.view;

import com.google.gwt.user.client.ui.Widget;

public interface Panel
{
   public String getPanelName();
   
   public Widget getWidget();

   public Widget getToolbar();
}
