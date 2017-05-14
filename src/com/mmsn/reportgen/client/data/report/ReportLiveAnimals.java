package com.mmsn.reportgen.client.data.report;

public class ReportLiveAnimals {
	// --------------------------------------------------------------------------
	// Private Data
	// --------------------------------------------------------------------------

	private boolean isConSick;
	private boolean isConInjured;
	private boolean isConOutOfHabitat;
	private boolean isConDeemedReleasable;
	private boolean isConAbandoned;
	private boolean isConInaccessible;
	
	private boolean isConLocationHazardToAnimal;
	private boolean isConLocationHazardToHumans;
	private boolean isConUnknown;
	private boolean isConOther;

	private boolean isActionLeftAtSite;
	private boolean isActionImmediateReleaseAtSite;
	private boolean isActionRelocated;
	private boolean isActionDiedAtSite;
	private boolean isActionDiedDuringTransport;
	
	private boolean isActionEuthanizedAtSite;
	private boolean isActionEuthanizedDuringTransport;
	private boolean isActionTransferredToRehab;
	private boolean isActionOther;
	
	private String location;

	// --------------------------------------------------------------------------
	// Constructor
	// --------------------------------------------------------------------------

	public ReportLiveAnimals() {

	}

	// --------------------------------------------------------------------------
	// Public Members
	// --------------------------------------------------------------------------

	public boolean isConSick() {
		return isConSick;
	}

	public void setConSick(boolean isConSick) {
		this.isConSick = isConSick;
	}

	public boolean isConInjured() {
		return isConInjured;
	}

	public void setConInjured(boolean isConInjured) {
		this.isConInjured = isConInjured;
	}

	public boolean isConOutOfHabitat() {
		return isConOutOfHabitat;
	}

	public void setConOutOfHabitat(boolean isConOutOfHabitat) {
		this.isConOutOfHabitat = isConOutOfHabitat;
	}

	public boolean isConDeemedReleasable() {
		return isConDeemedReleasable;
	}

	public void setConDeemedReleasable(boolean isConDeemedReleasable) {
		this.isConDeemedReleasable = isConDeemedReleasable;
	}

	public boolean isConAbandoned() {
		return isConAbandoned;
	}

	public void setConAbandoned(boolean isConAbandoned) {
		this.isConAbandoned = isConAbandoned;
	}

	public boolean isConInaccessible() {
		return isConInaccessible;
	}

	public void setConInaccessible(boolean isConInaccessible) {
		this.isConInaccessible = isConInaccessible;
	}

	public boolean isConLocationHazardToAnimal() {
		return isConLocationHazardToAnimal;
	}

	public void setConLocationHazardToAnimal(boolean isConLocationHazardToAnimal) {
		this.isConLocationHazardToAnimal = isConLocationHazardToAnimal;
	}

	public boolean isConLocationHazardToHumans() {
		return isConLocationHazardToHumans;
	}

	public void setConLocationHazardToHumans(boolean isConLocationHazardToHumans) {
		this.isConLocationHazardToHumans = isConLocationHazardToHumans;
	}

	public boolean isConUnknown() {
		return isConUnknown;
	}

	public void setConUnknown(boolean isConUnknown) {
		this.isConUnknown = isConUnknown;
	}

	public boolean isConOther() {
		return isConOther;
	}

	public void setConOther(boolean isConOther) {
		this.isConOther = isConOther;
	}

	public boolean isActionLeftAtSite() {
		return isActionLeftAtSite;
	}

	public void setActionLeftAtSite(boolean isActionLeftAtSite) {
		this.isActionLeftAtSite = isActionLeftAtSite;
	}

	public boolean isActionImmediateReleaseAtSite() {
		return isActionImmediateReleaseAtSite;
	}

	public void setActionImmediateReleaseAtSite(boolean isActionImmediateReleaseAtSite) {
		this.isActionImmediateReleaseAtSite = isActionImmediateReleaseAtSite;
	}

	public boolean isActionRelocated() {
		return isActionRelocated;
	}

	public void setActionRelocated(boolean isActionRelocated) {
		this.isActionRelocated = isActionRelocated;
	}

	public boolean isActionDiedAtSite() {
		return isActionDiedAtSite;
	}

	public void setActionDiedAtSite(boolean isActionDiedAtSite) {
		this.isActionDiedAtSite = isActionDiedAtSite;
	}

	public boolean isActionDiedDuringTransport() {
		return isActionDiedDuringTransport;
	}

	public void setActionDiedDuringTransport(boolean isActionDiedDuringTransport) {
		this.isActionDiedDuringTransport = isActionDiedDuringTransport;
	}

	public boolean isActionEuthanizedAtSite() {
		return isActionEuthanizedAtSite;
	}

	public void setActionEuthanizedAtSite(boolean isActionEuthanizedAtSite) {
		this.isActionEuthanizedAtSite = isActionEuthanizedAtSite;
	}

	public boolean isActionEuthanizedDuringTransport() {
		return isActionEuthanizedDuringTransport;
	}

	public void setActionEuthanizedDuringTransport(boolean isActionEuthanizedDuringTransport) {
		this.isActionEuthanizedDuringTransport = isActionEuthanizedDuringTransport;
	}

	public boolean isActionTransferredToRehab() {
		return isActionTransferredToRehab;
	}

	public void setActionTransferredToRehab(boolean isActionTransferredToRehab) {
		this.isActionTransferredToRehab = isActionTransferredToRehab;
	}

	public boolean isActionOther() {
		return isActionOther;
	}

	public void setActionOther(boolean isActionOther) {
		this.isActionOther = isActionOther;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
