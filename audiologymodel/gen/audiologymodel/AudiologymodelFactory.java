package audiologymodel;

import audiologymodel.AudiologyBooking;
import audiologymodel.AppointmentRequest;
import audiologymodel.StaffMember;
import audiologymodel.Room;
import audiologymodel.PlanningDay;
import audiologymodel.PlanningWeek;
import audiologymodel.Timeslot;
import audiologymodel.AppointmentAssignment;

import org.eclipse.emf.ecore.EFactory;

public interface AudiologymodelFactory extends EFactory {

	AudiologymodelFactory eINSTANCE = audiologymodel.impl.AudiologymodelFactoryImpl.init();
	
	AudiologyBooking createAudiologyBooking();
	
	AppointmentRequest createAppointmentRequest();
	
	StaffMember createStaffMember();
	
	Room createRoom();
	
	PlanningDay createPlanningDay();
	
	PlanningWeek createPlanningWeek();
	
	Timeslot createTimeslot();
	
	AppointmentAssignment createAppointmentAssignment();
	
	
	AudiologymodelPackage getAudiologymodelPackage();

}
