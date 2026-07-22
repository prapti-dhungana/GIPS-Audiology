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

public class PlanningDayImpl extends SmartObject implements audiologymodel.PlanningDay {

    protected int dayIndex = 0;
    protected audiologymodel.Days dayOfWeek = audiologymodel.Days.MONDAY;
    protected audiologymodel.PlanningWeek week = null;
	
	protected PlanningDayImpl() {
		super(AudiologymodelPackage.Literals.PLANNING_DAY);
	}
	
    
    @Override
    public int getDayIndex() {
    	return this.dayIndex;
    }
    
    @Override
    public void setDayIndex(int value) {
    	Object oldValue = this.dayIndex;
    	this.dayIndex = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.PLANNING_DAY__DAY_INDEX, oldValue, value, -1));
    }
    
    
    @Override
    public audiologymodel.Days getDayOfWeek() {
    	return this.dayOfWeek;
    }
    
    @Override
    public void setDayOfWeek(audiologymodel.Days value) {
    	Object oldValue = this.dayOfWeek;
    	this.dayOfWeek = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.PLANNING_DAY__DAY_OF_WEEK, oldValue, value, -1));
    }
    
    
    @Override
    public audiologymodel.PlanningWeek getWeek() {
    	return this.week;
    }
    
    @Override
    public void setWeek(audiologymodel.PlanningWeek value) {
    	
    	Object oldValue = this.week;
    	
    	if(value == null && oldValue == null)
    		return;
    		
    	if(value != null && value.equals(oldValue))
    		return;
    		
    	
    	
    		        this.week = value;
    		        
    	
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.PLANNING_DAY__WEEK, oldValue, value, -1));
    	        	
    	        	if(AudiologymodelPackage.Literals.PLANNING_DAY__WEEK.getEOpposite() != null) {
    	        		if(oldValue != null) {
    	        			((SmartObject) oldValue).eInverseRemove(this, AudiologymodelPackage.Literals.PLANNING_DAY__WEEK.getEOpposite());
    	        		}
    	        		if(value != null) {
    	        		    ((SmartObject) value).eInverseAdd(this, AudiologymodelPackage.Literals.PLANNING_DAY__WEEK.getEOpposite());
    	        		}
    	        	}
    }
    

    @Override
    public void eSet(EStructuralFeature eFeature, Object newValue){
    	if (AudiologymodelPackage.Literals.PLANNING_DAY__DAY_INDEX.equals(eFeature)) {
    		setDayIndex((int) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.PLANNING_DAY__DAY_OF_WEEK.equals(eFeature)) {
    		setDayOfWeek((audiologymodel.Days) newValue); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.PLANNING_DAY__WEEK.equals(eFeature)) {
    		setWeek((audiologymodel.PlanningWeek) newValue); 
    		return;
    	}
    	eDynamicSet(eFeature, newValue);
    }
    
    @Override
    public void eUnset(EStructuralFeature eFeature){
    	if (AudiologymodelPackage.Literals.PLANNING_DAY__DAY_INDEX.equals(eFeature)) {
    		setDayIndex((int)0); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.PLANNING_DAY__DAY_OF_WEEK.equals(eFeature)) {
    		setDayOfWeek((audiologymodel.Days)audiologymodel.Days.MONDAY); 
    		return;
    	}
    	if (AudiologymodelPackage.Literals.PLANNING_DAY__WEEK.equals(eFeature)) {
    		setWeek((audiologymodel.PlanningWeek)null); 
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
			b.append("dayIndex: ");
			b.append(getDayIndex());
		} else {
			b.append("dayIndex: ");
			b.append(getDayIndex());b.append(", ");
			b.append("dayOfWeek: ");
			b.append(getDayOfWeek());
		}
		b.append(")");
		return b.toString();
    }

 	@Override
    public Object eGet(EStructuralFeature eFeature){
    	if (AudiologymodelPackage.Literals.PLANNING_DAY__DAY_INDEX.equals(eFeature))
    		return getDayIndex();
    	if (AudiologymodelPackage.Literals.PLANNING_DAY__DAY_OF_WEEK.equals(eFeature))
    		return getDayOfWeek();
    	if (AudiologymodelPackage.Literals.PLANNING_DAY__WEEK.equals(eFeature))
    		return getWeek();
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
