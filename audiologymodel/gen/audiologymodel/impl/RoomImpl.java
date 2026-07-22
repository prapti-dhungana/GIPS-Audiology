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

public class RoomImpl extends SmartObject implements audiologymodel.Room {

    protected int number = 0;
    protected audiologymodel.RoomType roomType = audiologymodel.RoomType.ROOM;
    protected LinkedSmartESet<audiologymodel.PlanningDay> openDays = new LinkedSmartESet<audiologymodel.PlanningDay>(this, AudiologymodelPackage.Literals.ROOM__OPEN_DAYS);
    protected int availableFromSlot = 0;
    protected int availableToSlot = 0;
	
	protected RoomImpl() {
		super(AudiologymodelPackage.Literals.ROOM);
	}
	
    
    @Override
    public int getNumber() {
    	return this.number;
    }
    
    @Override
    public void setNumber(int value) {
    	Object oldValue = this.number;
    	this.number = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.ROOM__NUMBER, oldValue, value, -1));
    }
    
    
    @Override
    public audiologymodel.RoomType getRoomType() {
    	return this.roomType;
    }
    
    @Override
    public void setRoomType(audiologymodel.RoomType value) {
    	Object oldValue = this.roomType;
    	this.roomType = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.ROOM__ROOM_TYPE, oldValue, value, -1));
    }
    
    
    @Override
    public LinkedSmartESet<audiologymodel.PlanningDay> getOpenDays() {
    	return this.openDays;
    }
    
    @Override
    public void setOpenDays(LinkedSmartESet<audiologymodel.PlanningDay> value) {
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
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.ROOM__AVAILABLE_FROM_SLOT, oldValue, value, -1));
    }
    
    
    @Override
    public int getAvailableToSlot() {
    	return this.availableToSlot;
    }
    
    @Override
    public void setAvailableToSlot(int value) {
    	Object oldValue = this.availableToSlot;
    	this.availableToSlot = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.ROOM__AVAILABLE_TO_SLOT, oldValue, value, -1));
    }
    

    @Override
    public void eSet(EStructuralFeature eFeature, Object newValue){
    	if (AudiologymodelPackage.Literals.ROOM__NUMBER.equals(eFeature)) {
    		setNumber((int) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.ROOM__ROOM_TYPE.equals(eFeature)) {
    		setRoomType((audiologymodel.RoomType) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.ROOM__OPEN_DAYS.equals(eFeature)) {
    		setOpenDays((LinkedSmartESet<audiologymodel.PlanningDay>) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.ROOM__AVAILABLE_FROM_SLOT.equals(eFeature)) {
    		setAvailableFromSlot((int) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.ROOM__AVAILABLE_TO_SLOT.equals(eFeature)) {
    		setAvailableToSlot((int) newValue); 
    		return;
    	}
    	eDynamicSet(eFeature, newValue);
    }
    
    @Override
    public void eUnset(EStructuralFeature eFeature){
    	if (AudiologymodelPackage.Literals.ROOM__NUMBER.equals(eFeature)) {
    		setNumber((int)0); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.ROOM__ROOM_TYPE.equals(eFeature)) {
    		setRoomType((audiologymodel.RoomType)audiologymodel.RoomType.ROOM); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.ROOM__OPEN_DAYS.equals(eFeature)) {
    		getOpenDays().clear(); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.ROOM__AVAILABLE_FROM_SLOT.equals(eFeature)) {
    		setAvailableFromSlot((int)0); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.ROOM__AVAILABLE_TO_SLOT.equals(eFeature)) {
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
			b.append("roomType: ");
			b.append(getRoomType());b.append(", ");
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
    	if (AudiologymodelPackage.Literals.ROOM__NUMBER.equals(eFeature))
    		return getNumber();
    	if (AudiologymodelPackage.Literals.ROOM__ROOM_TYPE.equals(eFeature))
    		return getRoomType();
    	if (AudiologymodelPackage.Literals.ROOM__OPEN_DAYS.equals(eFeature))
    		return getOpenDays();
    	if (AudiologymodelPackage.Literals.ROOM__AVAILABLE_FROM_SLOT.equals(eFeature))
    		return getAvailableFromSlot();
    	if (AudiologymodelPackage.Literals.ROOM__AVAILABLE_TO_SLOT.equals(eFeature))
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
