package audiologymodel;

import audiologymodel.AudiologymodelPackage;

import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.SmartObject;
import org.emoflon.smartemf.runtime.collections.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface PlanningDay extends EObject {
	
    public int getDayIndex();
    
    public void setDayIndex(int value);
    
    public audiologymodel.Days getDayOfWeek();
    
    public void setDayOfWeek(audiologymodel.Days value);
    
    public audiologymodel.PlanningWeek getWeek();
    
    public void setWeek(audiologymodel.PlanningWeek value);
    

}
