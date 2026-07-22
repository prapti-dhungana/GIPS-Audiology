package audiologymodel;

import audiologymodel.AudiologymodelPackage;

import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.SmartObject;
import org.emoflon.smartemf.runtime.collections.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface AppointmentAssignment extends EObject {
	
    public audiologymodel.Timeslot getStartSlot();
    
    public void setStartSlot(audiologymodel.Timeslot value);
    
    public audiologymodel.StaffMember getStaffMember();
    
    public void setStaffMember(audiologymodel.StaffMember value);
    
    public audiologymodel.Room getRoom();
    
    public void setRoom(audiologymodel.Room value);
    
    public audiologymodel.PlanningDay getPlanningDay();
    
    public void setPlanningDay(audiologymodel.PlanningDay value);
    
    public audiologymodel.AppointmentRequest getRequest();
    
    public void setRequest(audiologymodel.AppointmentRequest value);
    

}
