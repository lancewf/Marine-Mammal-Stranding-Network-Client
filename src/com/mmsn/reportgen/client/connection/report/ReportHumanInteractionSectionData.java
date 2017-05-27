package com.mmsn.reportgen.client.connection.report;

import com.google.gwt.core.client.JavaScriptObject;

public class ReportHumanInteractionSectionData extends JavaScriptObject {

	protected ReportHumanInteractionSectionData() {
	}

	public final native boolean isExamined()
	/*-{
	  return this.is_examined;
	}-*/;
	
	public final native String getName()
	/*-{
	  return this.name;
	}-*/;
	
	public final native String getPossibleHiLesion()
	/*-{
	  return this.possible_hi_lesion;
	}-*/;
	
	public final native String getPossibleSource()
	/*-{
	  return this.possible_source;
	}-*/;
	
	public final native String getScavengerDamage()
	/*-{
	  return this.scavenger_damage;
	}-*/;
}
