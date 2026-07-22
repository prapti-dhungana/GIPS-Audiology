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

public class AppointmentAssignmentImpl extends SmartObject implements audiologymodel.AppointmentAssignment {

    protected audiologymodel.Timeslot startSlot = null;
    protected audiologymodel.StaffMember staffMember = null;
    protected audiologymodel.Room room = null;
    protected audiologymodel.PlanningDay planningDay = null;
    protected audiologymodel.AppointmentRequest request = null;
	
	protected AppointmentAssignmentImpl() {
		super(AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT);
	}
	
    
    @Override
    public audiologymodel.Timeslot getStartSlot() {
    	return this.startSlot;
    }
    
    @Override
    public void setStartSlot(audiologymodel.Timeslot value) {
    	
    	Object oldValue = this.startSlot;
    	
    	if(value == null && oldValue == null)
    		return;
    		
    	if(value != null && value.equals(oldValue))
    		return;
    		
    	
    	
    		        this.startSlot = value;
    		        
    	
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__START_SLOT, oldValue, value, -1));
    	        	
    	        	if(AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__START_SLOT.getEOpposite() != null) {
    	        		if(oldValue != null) {
    	        			((SmartObject) oldValue).eInverseRemove(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__START_SLOT.getEOpposite());
    	        		}
    	        		if(value != null) {
    	        		    ((SmartObject) value).eInverseAdd(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__START_SLOT.getEOpposite());
    	        		}
    	        	}
    }
    
    
    @Override
    public audiologymodel.StaffMember getStaffMember() {
    	return this.staffMember;
    }
    
    @Override
    public void setStaffMember(audiologymodel.StaffMember value) {
    	
    	Object oldValue = this.staffMember;
    	
    	if(value == null && oldValue == null)
    		return;
    		
    	if(value != null && value.equals(oldValue))
    		return;
    		
    	
    	
    		        this.staffMember = value;
    		        
    	
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__STAFF_MEMBER, oldValue, value, -1));
    	        	
    	        	if(AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__STAFF_MEMBER.getEOpposite() != null) {
    	        		if(oldValue != null) {
    	        			((SmartObject) oldValue).eInverseRemove(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__STAFF_MEMBER.getEOpposite());
    	        		}
    	        		if(value != null) {
    	        		    ((SmartObject) value).eInverseAdd(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__STAFF_MEMBER.getEOpposite());
    	        		}
    	        	}
    }
    
    
    @Override
    public audiologymodel.Room getRoom() {
    	return this.room;
    }
    
    @Override
    public void setRoom(audiologymodel.Room value) {
    	
    	Object oldValue = this.room;
    	
    	if(value == null && oldValue == null)
    		return;
    		
    	if(value != null && value.equals(oldValue))
    		return;
    		
    	
    	
    		        this.room = value;
    		        
    	
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__ROOM, oldValue, value, -1));
    	        	
    	        	if(AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__ROOM.getEOpposite() != null) {
    	        		if(oldValue != null) {
    	        			((SmartObject) oldValue).eInverseRemove(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__ROOM.getEOpposite());
    	        		}
    	        		if(value != null) {
    	        		    ((SmartObject) value).eInverseAdd(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__ROOM.getEOpposite());
    	        		}
    	        	}
    }
    
    
    @Override
    public audiologymodel.PlanningDay getPlanningDay() {
    	return this.planningDay;
    }
    
    @Override
    public void setPlanningDay(audiologymodel.PlanningDay value) {
    	
    	Object oldValue = this.planningDay;
    	
    	if(value == null && oldValue == null)
    		return;
    		
    	if(value != null && value.equals(oldValue))
    		return;
    		
    	
    	
    		        this.planningDay = value;
    		        
    	
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__PLANNING_DAY, oldValue, value, -1));
    	        	
    	        	if(AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__PLANNING_DAY.getEOpposite() != null) {
    	        		if(oldValue != null) {
    	        			((SmartObject) oldValue).eInverseRemove(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__PLANNING_DAY.getEOpposite());
    	        		}
    	        		if(value != null) {
    	        		    ((SmartObject) value).eInverseAdd(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__PLANNING_DAY.getEOpposite());
    	        		}
    	        	}
    }
    
    
    @Override
    public audiologymodel.AppointmentRequest getRequest() {
    	return this.request;
    }
    
    @Override
    public void setRequest(audiologymodel.AppointmentRequest value) {
    	
    	Object oldValue = this.request;
    	
    	if(value == null && oldValue == null)
    		return;
    		
    	if(value != null && value.equals(oldValue))
    		return;
    		
    	
    	
    		        this.request = value;
    		        
    	
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__REQUEST, oldValue, value, -1));
    	        	
    	        	if(AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__REQUEST.getEOpposite() != null) {
    	        		if(oldValue != null) {
    	        			((SmartObject) oldValue).eInverseRemove(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__REQUEST.getEOpposite());
    	        		}
    	        		if(value != null) {
    	        		    ((SmartObject) value).eInverseAdd(this, AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__REQUEST.getEOpposite());
    	        		}
    	        	}
    }
    

    @Override
    public void eSet(EStructuralFeature eFeature, Object newValue){
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__START_SLOT.equals(eFeature)) {
    		setStartSlot((audiologymodel.Timeslot) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__STAFF_MEMBER.equals(eFeature)) {
    		setStaffMember((audiologymodel.StaffMember) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__ROOM.equals(eFeature)) {
    		setRoom((audiologymodel.Room) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__PLANNING_DAY.equals(eFeature)) {
    		setPlanningDay((audiologymodel.PlanningDay) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__REQUEST.equals(eFeature)) {
    		setRequest((audiologymodel.AppointmentRequest) newValue); 
    		return;
    	}
    	eDynamicSet(eFeature, newValue);
    }
    
    @Override
    public void eUnset(EStructuralFeature eFeature){
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__START_SLOT.equals(eFeature)) {
    		setStartSlot((audiologymodel.Timeslot)null); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__STAFF_MEMBER.equals(eFeature)) {
    		setStaffMember((audiologymodel.StaffMember)null); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__ROOM.equals(eFeature)) {
    		setRoom((audiologymodel.Room)null); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__PLANNING_DAY.equals(eFeature)) {
    		setPlanningDay((audiologymodel.PlanningDay)null); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__REQUEST.equals(eFeature)) {
    		setRequest((audiologymodel.AppointmentRequest)null); 
    		return;
    	}
    	eDynamicUnset(eFeature);
    }

    @Override
    public String toString(){
		return super.toString();
    }

 	@Override
    public Object eGet(EStructuralFeature eFeature){
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__START_SLOT.equals(eFeature))
    		return getStartSlot();
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__STAFF_MEMBER.equals(eFeature))
    		return getStaffMember();
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__ROOM.equals(eFeature))
    		return getRoom();
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__PLANNING_DAY.equals(eFeature))
    		return getPlanningDay();
    	if (AudiologymodelPackage.Literals.APPOINTMENT_ASSIGNMENT__REQUEST.equals(eFeature))
    		return getRequest();
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
