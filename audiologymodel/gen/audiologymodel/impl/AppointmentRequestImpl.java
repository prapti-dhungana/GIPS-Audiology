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

public class AppointmentRequestImpl extends SmartObject implements audiologymodel.AppointmentRequest {

    protected int number = 0;
    protected audiologymodel.RoomType roomRequirement = audiologymodel.RoomType.ROOM;
    protected int staffBandRequirement = 0;
    protected int appointmentType = 0;
    protected int durationSlots = 0;
    protected boolean artsFlag = false;
    protected int bookFromDayIndex = 0;
    protected int idealDayIndex = 0;
	
	protected AppointmentRequestImpl() {
		super(AudiologymodelPackage.Literals.APPOINTMENT_REQUEST);
	}
	
    
    @Override
    public int getNumber() {
    	return this.number;
    }
    
    @Override
    public void setNumber(int value) {
    	Object oldValue = this.number;
    	this.number = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__NUMBER, oldValue, value, -1));
    }
    
    
    @Override
    public audiologymodel.RoomType getRoomRequirement() {
    	return this.roomRequirement;
    }
    
    @Override
    public void setRoomRequirement(audiologymodel.RoomType value) {
    	Object oldValue = this.roomRequirement;
    	this.roomRequirement = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__ROOM_REQUIREMENT, oldValue, value, -1));
    }
    
    
    @Override
    public int getStaffBandRequirement() {
    	return this.staffBandRequirement;
    }
    
    @Override
    public void setStaffBandRequirement(int value) {
    	Object oldValue = this.staffBandRequirement;
    	this.staffBandRequirement = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__STAFF_BAND_REQUIREMENT, oldValue, value, -1));
    }
    
    
    @Override
    public int getAppointmentType() {
    	return this.appointmentType;
    }
    
    @Override
    public void setAppointmentType(int value) {
    	Object oldValue = this.appointmentType;
    	this.appointmentType = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__APPOINTMENT_TYPE, oldValue, value, -1));
    }
    
    
    @Override
    public int getDurationSlots() {
    	return this.durationSlots;
    }
    
    @Override
    public void setDurationSlots(int value) {
    	Object oldValue = this.durationSlots;
    	this.durationSlots = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__DURATION_SLOTS, oldValue, value, -1));
    }
    
    
    @Override
    public boolean isArtsFlag() {
    	return this.artsFlag;
    }
    
    @Override
    public void setArtsFlag(boolean value) {
    	Object oldValue = this.artsFlag;
    	this.artsFlag = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__ARTS_FLAG, oldValue, value, -1));
    }
    
    
    @Override
    public int getBookFromDayIndex() {
    	return this.bookFromDayIndex;
    }
    
    @Override
    public void setBookFromDayIndex(int value) {
    	Object oldValue = this.bookFromDayIndex;
    	this.bookFromDayIndex = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__BOOK_FROM_DAY_INDEX, oldValue, value, -1));
    }
    
    
    @Override
    public int getIdealDayIndex() {
    	return this.idealDayIndex;
    }
    
    @Override
    public void setIdealDayIndex(int value) {
    	Object oldValue = this.idealDayIndex;
    	this.idealDayIndex = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__IDEAL_DAY_INDEX, oldValue, value, -1));
    }
    

    @Override
    public void eSet(EStructuralFeature eFeature, Object newValue){
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__NUMBER.equals(eFeature)) {
    		setNumber((int) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__ROOM_REQUIREMENT.equals(eFeature)) {
    		setRoomRequirement((audiologymodel.RoomType) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__STAFF_BAND_REQUIREMENT.equals(eFeature)) {
    		setStaffBandRequirement((int) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__APPOINTMENT_TYPE.equals(eFeature)) {
    		setAppointmentType((int) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__DURATION_SLOTS.equals(eFeature)) {
    		setDurationSlots((int) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__ARTS_FLAG.equals(eFeature)) {
    		setArtsFlag((boolean) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__BOOK_FROM_DAY_INDEX.equals(eFeature)) {
    		setBookFromDayIndex((int) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__IDEAL_DAY_INDEX.equals(eFeature)) {
    		setIdealDayIndex((int) newValue); 
    		return;
    	}
    	eDynamicSet(eFeature, newValue);
    }
    
    @Override
    public void eUnset(EStructuralFeature eFeature){
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__NUMBER.equals(eFeature)) {
    		setNumber((int)0); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__ROOM_REQUIREMENT.equals(eFeature)) {
    		setRoomRequirement((audiologymodel.RoomType)audiologymodel.RoomType.ROOM); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__STAFF_BAND_REQUIREMENT.equals(eFeature)) {
    		setStaffBandRequirement((int)0); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__APPOINTMENT_TYPE.equals(eFeature)) {
    		setAppointmentType((int)0); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__DURATION_SLOTS.equals(eFeature)) {
    		setDurationSlots((int)0); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__ARTS_FLAG.equals(eFeature)) {
    		setArtsFlag((boolean)false); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__BOOK_FROM_DAY_INDEX.equals(eFeature)) {
    		setBookFromDayIndex((int)0); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__IDEAL_DAY_INDEX.equals(eFeature)) {
    		setIdealDayIndex((int)0); 
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
			b.append("roomRequirement: ");
			b.append(getRoomRequirement());b.append(", ");
			b.append("staffBandRequirement: ");
			b.append(getStaffBandRequirement());b.append(", ");
			b.append("appointmentType: ");
			b.append(getAppointmentType());b.append(", ");
			b.append("durationSlots: ");
			b.append(getDurationSlots());b.append(", ");
			b.append("artsFlag: ");
			b.append(isArtsFlag());b.append(", ");
			b.append("bookFromDayIndex: ");
			b.append(getBookFromDayIndex());b.append(", ");
			b.append("idealDayIndex: ");
			b.append(getIdealDayIndex());
		}
		b.append(")");
		return b.toString();
    }

 	@Override
    public Object eGet(EStructuralFeature eFeature){
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__NUMBER.equals(eFeature))
    		return getNumber();
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__ROOM_REQUIREMENT.equals(eFeature))
    		return getRoomRequirement();
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__STAFF_BAND_REQUIREMENT.equals(eFeature))
    		return getStaffBandRequirement();
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__APPOINTMENT_TYPE.equals(eFeature))
    		return getAppointmentType();
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__DURATION_SLOTS.equals(eFeature))
    		return getDurationSlots();
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__ARTS_FLAG.equals(eFeature))
    		return isArtsFlag();
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__BOOK_FROM_DAY_INDEX.equals(eFeature))
    		return getBookFromDayIndex();
    	if (AudiologymodelPackage.Literals.APPOINTMENT_REQUEST__IDEAL_DAY_INDEX.equals(eFeature))
    		return getIdealDayIndex();
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
