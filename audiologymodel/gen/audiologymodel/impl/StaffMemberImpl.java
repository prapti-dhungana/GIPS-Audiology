package audiologymodel.impl;

import audiologymodel.AudiologymodelPackage;
import audiologymodel.AudiologymodelPackage;

import org.emoflon.smartemf.runtime.*;
import org.emoflon.smartemf.runtime.collections.*;
import org.emoflon.smartemf.persistence.SmartEMFResource;
import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.notification.NotifyStatus;

import java.util.function.Consumer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public class StaffMemberImpl extends SmartObject implements audiologymodel.StaffMember {

    protected int number = 0;
    protected int band = 0;
    protected int weeklyHours = 0;
    protected boolean artsFlag = false;
    protected LinkedSmartESet<audiologymodel.PlanningDay> workingDays = new LinkedSmartESet<audiologymodel.PlanningDay>(this, AudiologymodelPackage.Literals.STAFF_MEMBER__WORKING_DAYS);
    protected int availableFromSlot = 0;
    protected int availableToSlot = 0;
	
	protected StaffMemberImpl() {
		super(AudiologymodelPackage.Literals.STAFF_MEMBER);
	}
	
    
    @Override
    public int getNumber() {
    	return this.number;
    }
    
    @Override
    public void setNumber(int value) {
    	Object oldValue = this.number;
    	this.number = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.STAFF_MEMBER__NUMBER, oldValue, value, -1));
    }
    
    
    @Override
    public int getBand() {
    	return this.band;
    }
    
    @Override
    public void setBand(int value) {
    	Object oldValue = this.band;
    	this.band = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.STAFF_MEMBER__BAND, oldValue, value, -1));
    }
    
    
    @Override
    public int getWeeklyHours() {
    	return this.weeklyHours;
    }
    
    @Override
    public void setWeeklyHours(int value) {
    	Object oldValue = this.weeklyHours;
    	this.weeklyHours = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.STAFF_MEMBER__WEEKLY_HOURS, oldValue, value, -1));
    }
    
    
    @Override
    public boolean isArtsFlag() {
    	return this.artsFlag;
    }
    
    @Override
    public void setArtsFlag(boolean value) {
    	Object oldValue = this.artsFlag;
    	this.artsFlag = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.STAFF_MEMBER__ARTS_FLAG, oldValue, value, -1));
    }
    
    
    @Override
    public LinkedSmartESet<audiologymodel.PlanningDay> getWorkingDays() {
    	return this.workingDays;
    }
    
    @Override
    public void setWorkingDays(LinkedSmartESet<audiologymodel.PlanningDay> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    
    
    @Override
    public int getAvailableFromSlot() {
    	return this.availableFromSlot;
    }
    
    @Override
    public void setAvailableFromSlot(int value) {
    	Object oldValue = this.availableFromSlot;
    	this.availableFromSlot = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.STAFF_MEMBER__AVAILABLE_FROM_SLOT, oldValue, value, -1));
    }
    
    
    @Override
    public int getAvailableToSlot() {
    	return this.availableToSlot;
    }
    
    @Override
    public void setAvailableToSlot(int value) {
    	Object oldValue = this.availableToSlot;
    	this.availableToSlot = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.STAFF_MEMBER__AVAILABLE_TO_SLOT, oldValue, value, -1));
    }
    

    @Override
    public void eSet(EStructuralFeature eFeature, Object newValue){
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__NUMBER.equals(eFeature)) {
    		setNumber((int) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__BAND.equals(eFeature)) {
    		setBand((int) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__WEEKLY_HOURS.equals(eFeature)) {
    		setWeeklyHours((int) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__ARTS_FLAG.equals(eFeature)) {
    		setArtsFlag((boolean) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__WORKING_DAYS.equals(eFeature)) {
    		setWorkingDays((LinkedSmartESet<audiologymodel.PlanningDay>) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__AVAILABLE_FROM_SLOT.equals(eFeature)) {
    		setAvailableFromSlot((int) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__AVAILABLE_TO_SLOT.equals(eFeature)) {
    		setAvailableToSlot((int) newValue); 
    		return;
    	}
    	eDynamicSet(eFeature, newValue);
    }
    
    @Override
    public void eUnset(EStructuralFeature eFeature){
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__NUMBER.equals(eFeature)) {
    		setNumber((int)0); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__BAND.equals(eFeature)) {
    		setBand((int)0); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__WEEKLY_HOURS.equals(eFeature)) {
    		setWeeklyHours((int)0); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__ARTS_FLAG.equals(eFeature)) {
    		setArtsFlag((boolean)false); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__WORKING_DAYS.equals(eFeature)) {
    		getWorkingDays().clear(); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__AVAILABLE_FROM_SLOT.equals(eFeature)) {
    		setAvailableFromSlot((int)0); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__AVAILABLE_TO_SLOT.equals(eFeature)) {
    		setAvailableToSlot((int)0); 
    		return;
    	}
    	eDynamicUnset(eFeature);
    }

    @Override
    public String toString(){
		StringBuilder b = new StringBuilder();
		b.append(super.toString());
		b.append(" (");
		if (SmartEMFConfig.simpleStringRepresentations()) {
			b.append("number: ");
			b.append(getNumber());
		} else {
			b.append("number: ");
			b.append(getNumber());b.append(", ");
			b.append("band: ");
			b.append(getBand());b.append(", ");
			b.append("weeklyHours: ");
			b.append(getWeeklyHours());b.append(", ");
			b.append("artsFlag: ");
			b.append(isArtsFlag());b.append(", ");
			b.append("availableFromSlot: ");
			b.append(getAvailableFromSlot());b.append(", ");
			b.append("availableToSlot: ");
			b.append(getAvailableToSlot());
		}
		b.append(")");
		return b.toString();
    }

 	@Override
    public Object eGet(EStructuralFeature eFeature){
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__NUMBER.equals(eFeature))
    		return getNumber();
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__BAND.equals(eFeature))
    		return getBand();
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__WEEKLY_HOURS.equals(eFeature))
    		return getWeeklyHours();
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__ARTS_FLAG.equals(eFeature))
    		return isArtsFlag();
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__WORKING_DAYS.equals(eFeature))
    		return getWorkingDays();
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__AVAILABLE_FROM_SLOT.equals(eFeature))
    		return getAvailableFromSlot();
    	if (AudiologymodelPackage.Literals.STAFF_MEMBER__AVAILABLE_TO_SLOT.equals(eFeature))
    		return getAvailableToSlot();
    	return eDynamicGet(eFeature);
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType){
    	throw new UnsupportedOperationException("This method has been deactivated since it is not always safe to use.");
    }
    
    @Override
    public void eInverseAdd(Object otherEnd, EStructuralFeature feature) {
	    if(feature == null)
	    	return;
	    	
    	eDynamicInverseAdd(otherEnd, feature);
	    	}
    	
    @Override
	    	public void eInverseRemove(Object otherEnd, EStructuralFeature feature) {
	    if(feature == null)
	    	return;
	    		    		
    	eDynamicInverseRemove(otherEnd, feature);
	    	}
    
    @Override
    /**
    * This method sets the resource and generates REMOVING_ADAPTER and ADD notifications
    */
    protected void setResourceOfContainments(Consumer<SmartObject> setResourceCall) {
	    	}
	    	
	    	@Override
	    	/**
	    	* This method sets the resource and only generates REMOVING_ADAPTER notifications (no ADD messages)
	    	*/
    protected void setResourceOfContainmentsSilently(Resource r) { 		
	    	}
}
