package audiologymodel;

import audiologymodel.AudiologymodelPackage;

import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.SmartObject;
import org.emoflon.smartemf.runtime.collections.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface AppointmentRequest extends EObject {
	
    public int getNumber();
    
    public void setNumber(int value);
    
    public audiologymodel.RoomType getRoomRequirement();
    
    public void setRoomRequirement(audiologymodel.RoomType value);
    
    public int getStaffBandRequirement();
    
    public void setStaffBandRequirement(int value);
    
    public int getAppointmentType();
    
    public void setAppointmentType(int value);
    
    public int getDurationSlots();
    
    public void setDurationSlots(int value);
    
    public boolean isArtsFlag();
    
    public void setArtsFlag(boolean value);
    
    public int getBookFromDayIndex();
    
    public void setBookFromDayIndex(int value);
    
    public int getIdealDayIndex();
    
    public void setIdealDayIndex(int value);
    

}
