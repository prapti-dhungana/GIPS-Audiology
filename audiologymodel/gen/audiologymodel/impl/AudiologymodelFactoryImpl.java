package audiologymodel.impl;

import audiologymodel.AudiologyBooking;
import audiologymodel.AppointmentRequest;
import audiologymodel.StaffMember;
import audiologymodel.Room;
import audiologymodel.PlanningDay;
import audiologymodel.PlanningWeek;
import audiologymodel.Timeslot;
import audiologymodel.AppointmentAssignment;

import audiologymodel.Days;
import audiologymodel.RoomType;

import audiologymodel.AudiologymodelFactory;
import audiologymodel.AudiologymodelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class AudiologymodelFactoryImpl extends EFactoryImpl implements audiologymodel.AudiologymodelFactory {

	public static audiologymodel.AudiologymodelFactory init() {
		try {
			AudiologymodelFactory theAudiologymodelFactory = (AudiologymodelFactory) EPackage.Registry.INSTANCE
					.getEFactory(AudiologymodelPackage.eNS_URI);
			if (theAudiologymodelFactory != null) {
				return theAudiologymodelFactory;
			}
		} catch (java.lang.Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AudiologymodelFactoryImpl();
	}

	public AudiologymodelFactoryImpl() {
		super();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case AudiologymodelPackage.AUDIOLOGY_BOOKING:
			return createAudiologyBooking();
		case AudiologymodelPackage.APPOINTMENT_REQUEST:
			return createAppointmentRequest();
		case AudiologymodelPackage.STAFF_MEMBER:
			return createStaffMember();
		case AudiologymodelPackage.ROOM:
			return createRoom();
		case AudiologymodelPackage.PLANNING_DAY:
			return createPlanningDay();
		case AudiologymodelPackage.PLANNING_WEEK:
			return createPlanningWeek();
		case AudiologymodelPackage.TIMESLOT:
			return createTimeslot();
		case AudiologymodelPackage.APPOINTMENT_ASSIGNMENT:
			return createAppointmentAssignment();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}
	
		@Override
		public Object createFromString(EDataType eDataType, String initialValue) {
			switch (eDataType.getClassifierID()) {
			case AudiologymodelPackage.DAYS:
				return createDaysFromString(eDataType, initialValue);
			case AudiologymodelPackage.ROOM_TYPE:
				return createRoomTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
			}
		}

	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case AudiologymodelPackage.DAYS:
			return convertDaysToString(eDataType, instanceValue);
		case AudiologymodelPackage.ROOM_TYPE:
			return convertRoomTypeToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}
	
	@Override
	public audiologymodel.AudiologyBooking createAudiologyBooking() {
		AudiologyBookingImpl audiologyBooking = new AudiologyBookingImpl();
		return audiologyBooking;
	}
	@Override
	public audiologymodel.AppointmentRequest createAppointmentRequest() {
		AppointmentRequestImpl appointmentRequest = new AppointmentRequestImpl();
		return appointmentRequest;
	}
	@Override
	public audiologymodel.StaffMember createStaffMember() {
		StaffMemberImpl staffMember = new StaffMemberImpl();
		return staffMember;
	}
	@Override
	public audiologymodel.Room createRoom() {
		RoomImpl room = new RoomImpl();
		return room;
	}
	@Override
	public audiologymodel.PlanningDay createPlanningDay() {
		PlanningDayImpl planningDay = new PlanningDayImpl();
		return planningDay;
	}
	@Override
	public audiologymodel.PlanningWeek createPlanningWeek() {
		PlanningWeekImpl planningWeek = new PlanningWeekImpl();
		return planningWeek;
	}
	@Override
	public audiologymodel.Timeslot createTimeslot() {
		TimeslotImpl timeslot = new TimeslotImpl();
		return timeslot;
	}
	@Override
	public audiologymodel.AppointmentAssignment createAppointmentAssignment() {
		AppointmentAssignmentImpl appointmentAssignment = new AppointmentAssignmentImpl();
		return appointmentAssignment;
	}
	
	public Days createDaysFromString(EDataType eDataType, String initialValue) {
		Days result = Days.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
				
		return result;
	}
	
	public String convertDaysToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}
	public RoomType createRoomTypeFromString(EDataType eDataType, String initialValue) {
		RoomType result = RoomType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
				
		return result;
	}
	
	public String convertRoomTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	@Override
	public AudiologymodelPackage getAudiologymodelPackage() {
	return (AudiologymodelPackage) getEPackage();
	}
} 
