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

public class AudiologyBookingImpl extends SmartObject implements audiologymodel.AudiologyBooking {

    protected LinkedSmartESet<audiologymodel.AppointmentRequest> waitingList = new LinkedSmartESet<audiologymodel.AppointmentRequest>(this, AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__WAITING_LIST);
    protected LinkedSmartESet<audiologymodel.StaffMember> staff = new LinkedSmartESet<audiologymodel.StaffMember>(this, AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__STAFF);
    protected LinkedSmartESet<audiologymodel.Room> rooms = new LinkedSmartESet<audiologymodel.Room>(this, AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__ROOMS);
    protected LinkedSmartESet<audiologymodel.PlanningDay> days = new LinkedSmartESet<audiologymodel.PlanningDay>(this, AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__DAYS);
    protected LinkedSmartESet<audiologymodel.Timeslot> timeslots = new LinkedSmartESet<audiologymodel.Timeslot>(this, AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__TIMESLOTS);
    protected LinkedSmartESet<audiologymodel.AppointmentAssignment> appointmentAssignments = new LinkedSmartESet<audiologymodel.AppointmentAssignment>(this, AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__APPOINTMENT_ASSIGNMENTS);
    protected LinkedSmartESet<audiologymodel.PlanningWeek> weeks = new LinkedSmartESet<audiologymodel.PlanningWeek>(this, AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__WEEKS);
	
	protected AudiologyBookingImpl() {
		super(AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING);
	}
	
    
    @Override
    public LinkedSmartESet<audiologymodel.AppointmentRequest> getWaitingList() {
    	return this.waitingList;
    }
    
    @Override
    public void setWaitingList(LinkedSmartESet<audiologymodel.AppointmentRequest> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    
    
    @Override
    public LinkedSmartESet<audiologymodel.StaffMember> getStaff() {
    	return this.staff;
    }
    
    @Override
    public void setStaff(LinkedSmartESet<audiologymodel.StaffMember> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    
    
    @Override
    public LinkedSmartESet<audiologymodel.Room> getRooms() {
    	return this.rooms;
    }
    
    @Override
    public void setRooms(LinkedSmartESet<audiologymodel.Room> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    
    
    @Override
    public LinkedSmartESet<audiologymodel.PlanningDay> getDays() {
    	return this.days;
    }
    
    @Override
    public void setDays(LinkedSmartESet<audiologymodel.PlanningDay> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    
    
    @Override
    public LinkedSmartESet<audiologymodel.Timeslot> getTimeslots() {
    	return this.timeslots;
    }
    
    @Override
    public void setTimeslots(LinkedSmartESet<audiologymodel.Timeslot> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    
    
    @Override
    public LinkedSmartESet<audiologymodel.AppointmentAssignment> getAppointmentAssignments() {
    	return this.appointmentAssignments;
    }
    
    @Override
    public void setAppointmentAssignments(LinkedSmartESet<audiologymodel.AppointmentAssignment> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    
    
    @Override
    public LinkedSmartESet<audiologymodel.PlanningWeek> getWeeks() {
    	return this.weeks;
    }
    
    @Override
    public void setWeeks(LinkedSmartESet<audiologymodel.PlanningWeek> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    

    @Override
    public void eSet(EStructuralFeature eFeature, Object newValue){
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__WAITING_LIST.equals(eFeature)) {
    		setWaitingList((LinkedSmartESet<audiologymodel.AppointmentRequest>) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__STAFF.equals(eFeature)) {
    		setStaff((LinkedSmartESet<audiologymodel.StaffMember>) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__ROOMS.equals(eFeature)) {
    		setRooms((LinkedSmartESet<audiologymodel.Room>) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__DAYS.equals(eFeature)) {
    		setDays((LinkedSmartESet<audiologymodel.PlanningDay>) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__TIMESLOTS.equals(eFeature)) {
    		setTimeslots((LinkedSmartESet<audiologymodel.Timeslot>) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__APPOINTMENT_ASSIGNMENTS.equals(eFeature)) {
    		setAppointmentAssignments((LinkedSmartESet<audiologymodel.AppointmentAssignment>) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__WEEKS.equals(eFeature)) {
    		setWeeks((LinkedSmartESet<audiologymodel.PlanningWeek>) newValue); 
    		return;
    	}
    	eDynamicSet(eFeature, newValue);
    }
    
    @Override
    public void eUnset(EStructuralFeature eFeature){
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__WAITING_LIST.equals(eFeature)) {
    		getWaitingList().clear(); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__STAFF.equals(eFeature)) {
    		getStaff().clear(); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__ROOMS.equals(eFeature)) {
    		getRooms().clear(); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__DAYS.equals(eFeature)) {
    		getDays().clear(); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__TIMESLOTS.equals(eFeature)) {
    		getTimeslots().clear(); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__APPOINTMENT_ASSIGNMENTS.equals(eFeature)) {
    		getAppointmentAssignments().clear(); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__WEEKS.equals(eFeature)) {
    		getWeeks().clear(); 
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
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__WAITING_LIST.equals(eFeature))
    		return getWaitingList();
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__STAFF.equals(eFeature))
    		return getStaff();
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__ROOMS.equals(eFeature))
    		return getRooms();
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__DAYS.equals(eFeature))
    		return getDays();
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__TIMESLOTS.equals(eFeature))
    		return getTimeslots();
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__APPOINTMENT_ASSIGNMENTS.equals(eFeature))
    		return getAppointmentAssignments();
    	if (AudiologymodelPackage.Literals.AUDIOLOGY_BOOKING__WEEKS.equals(eFeature))
    		return getWeeks();
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
    	for(Object obj : getWaitingList()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
    	for(Object obj : getStaff()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
    	for(Object obj : getRooms()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
    	for(Object obj : getDays()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
    	for(Object obj : getTimeslots()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
    	for(Object obj : getAppointmentAssignments()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
    	for(Object obj : getWeeks()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
	    	}
	    	
	    	@Override
	    	/**
	    	* This method sets the resource and only generates REMOVING_ADAPTER notifications (no ADD messages)
	    	*/
    protected void setResourceOfContainmentsSilently(Resource r) { 		
    	for(Object obj : getWaitingList()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
    	for(Object obj : getStaff()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
    	for(Object obj : getRooms()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
    	for(Object obj : getDays()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
    	for(Object obj : getTimeslots()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
    	for(Object obj : getAppointmentAssignments()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
    	for(Object obj : getWeeks()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
	    	}
}
