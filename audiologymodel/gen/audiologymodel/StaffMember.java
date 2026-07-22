package audiologymodel;

import audiologymodel.AudiologymodelPackage;

import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.SmartObject;
import org.emoflon.smartemf.runtime.collections.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface StaffMember extends EObject {
	
    public int getNumber();
    
    public void setNumber(int value);
    
    public int getBand();
    
    public void setBand(int value);
    
    public int getWeeklyHours();
    
    public void setWeeklyHours(int value);
    
    public boolean isArtsFlag();
    
    public void setArtsFlag(boolean value);
    
    public LinkedSmartESet<audiologymodel.PlanningDay> getWorkingDays();
    
    public void setWorkingDays(LinkedSmartESet<audiologymodel.PlanningDay> value);
    
    public int getAvailableFromSlot();
    
    public void setAvailableFromSlot(int value);
    
    public int getAvailableToSlot();
    
    public void setAvailableToSlot(int value);
    

}
