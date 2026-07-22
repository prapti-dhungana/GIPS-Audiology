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

public class PlanningWeekImpl extends SmartObject implements audiologymodel.PlanningWeek {

    protected int weekIndex = 0;
	
	protected PlanningWeekImpl() {
		super(AudiologymodelPackage.Literals.PLANNING_WEEK);
	}
	
    
    @Override
    public int getWeekIndex() {
    	return this.weekIndex;
    }
    
    @Override
    public void setWeekIndex(int value) {
    	Object oldValue = this.weekIndex;
    	this.weekIndex = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, AudiologymodelPackage.Literals.PLANNING_WEEK__WEEK_INDEX, oldValue, value, -1));
    }
    

    @Override
    public void eSet(EStructuralFeature eFeature, Object newValue){
    	if (AudiologymodelPackage.Literals.PLANNING_WEEK__WEEK_INDEX.equals(eFeature)) {
    		setWeekIndex((int) newValue); 
    		return;
    	}
    	eDynamicSet(eFeature, newValue);
    }
    
    @Override
    public void eUnset(EStructuralFeature eFeature){
    	if (AudiologymodelPackage.Literals.PLANNING_WEEK__WEEK_INDEX.equals(eFeature)) {
    		setWeekIndex((int)0); 
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
			b.append("weekIndex: ");
			b.append(getWeekIndex());
		} else {
			b.append("weekIndex: ");
			b.append(getWeekIndex());
		}
		b.append(")");
		return b.toString();
    }

 	@Override
    public Object eGet(EStructuralFeature eFeature){
    	if (AudiologymodelPackage.Literals.PLANNING_WEEK__WEEK_INDEX.equals(eFeature))
    		return getWeekIndex();
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
