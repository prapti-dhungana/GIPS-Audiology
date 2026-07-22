package audiologymodel;

import audiologymodel.AudiologymodelPackage;

import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.SmartObject;
import org.emoflon.smartemf.runtime.collections.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface Room extends EObject {
	
    public int getNumber();
    
    public void setNumber(int value);
    
    public audiologymodel.RoomType getRoomType();
    
    public void setRoomType(audiologymodel.RoomType value);
    
    public LinkedSmartESet<audiologymodel.PlanningDay> getOpenDays();
    
    public void setOpenDays(LinkedSmartESet<audiologymodel.PlanningDay> value);
    
    public int getAvailableFromSlot();
    
    public void setAvailableFromSlot(int value);
    
    public int getAvailableToSlot();
    
    public void setAvailableToSlot(int value);
    

}
