package audiologymodel;

import audiologymodel.AudiologymodelPackage;

import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.SmartObject;
import org.emoflon.smartemf.runtime.collections.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface AudiologyBooking extends EObject {
	
    public LinkedSmartESet<audiologymodel.AppointmentRequest> getWaitingList();
    
    public void setWaitingList(LinkedSmartESet<audiologymodel.AppointmentRequest> value);
    
    public LinkedSmartESet<audiologymodel.StaffMember> getStaff();
    
    public void setStaff(LinkedSmartESet<audiologymodel.StaffMember> value);
    
    public LinkedSmartESet<audiologymodel.Room> getRooms();
    
    public void setRooms(LinkedSmartESet<audiologymodel.Room> value);
    
    public LinkedSmartESet<audiologymodel.PlanningDay> getDays();
    
    public void setDays(LinkedSmartESet<audiologymodel.PlanningDay> value);
    
    public LinkedSmartESet<audiologymodel.Timeslot> getTimeslots();
    
    public void setTimeslots(LinkedSmartESet<audiologymodel.Timeslot> value);
    
    public LinkedSmartESet<audiologymodel.AppointmentAssignment> getAppointmentAssignments();
    
    public void setAppointmentAssignments(LinkedSmartESet<audiologymodel.AppointmentAssignment> value);
    
    public LinkedSmartESet<audiologymodel.PlanningWeek> getWeeks();
    
    public void setWeeks(LinkedSmartESet<audiologymodel.PlanningWeek> value);
    

}
