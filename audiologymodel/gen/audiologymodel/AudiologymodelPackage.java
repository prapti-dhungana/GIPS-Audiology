package audiologymodel;

import java.lang.String;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EEnum;


import org.emoflon.smartemf.runtime.SmartPackage;

public interface AudiologymodelPackage extends SmartPackage {

	String eNAME = "audiologymodel";
	String eNS_URI = "http://www.example.org/audiologymodel";
	String eNS_PREFIX = "audiologymodel";

	AudiologymodelPackage eINSTANCE = audiologymodel.impl.AudiologymodelPackageImpl.init();

	int AUDIOLOGY_BOOKING = 2;
	int AUDIOLOGY_BOOKING__WAITING_LIST = 0;
	int AUDIOLOGY_BOOKING__STAFF = 1;
	int AUDIOLOGY_BOOKING__ROOMS = 2;
	int AUDIOLOGY_BOOKING__DAYS = 3;
	int AUDIOLOGY_BOOKING__TIMESLOTS = 4;
	int AUDIOLOGY_BOOKING__APPOINTMENT_ASSIGNMENTS = 5;
	int AUDIOLOGY_BOOKING__WEEKS = 6;
	int AUDIOLOGY_BOOKING_FEATURE_COUNT = 7;
	int AUDIOLOGY_BOOKING_OPERATION_COUNT = 0;
	
	int APPOINTMENT_REQUEST = 3;
	int APPOINTMENT_REQUEST__NUMBER = 7;
	int APPOINTMENT_REQUEST__ROOM_REQUIREMENT = 8;
	int APPOINTMENT_REQUEST__STAFF_BAND_REQUIREMENT = 9;
	int APPOINTMENT_REQUEST__APPOINTMENT_TYPE = 10;
	int APPOINTMENT_REQUEST__DURATION_SLOTS = 11;
	int APPOINTMENT_REQUEST__ARTS_FLAG = 12;
	int APPOINTMENT_REQUEST__BOOK_FROM_DAY_INDEX = 13;
	int APPOINTMENT_REQUEST__IDEAL_DAY_INDEX = 14;
	int APPOINTMENT_REQUEST_FEATURE_COUNT = 8;
	int APPOINTMENT_REQUEST_OPERATION_COUNT = 0;
	
	int STAFF_MEMBER = 4;
	int STAFF_MEMBER__NUMBER = 15;
	int STAFF_MEMBER__BAND = 16;
	int STAFF_MEMBER__WEEKLY_HOURS = 17;
	int STAFF_MEMBER__ARTS_FLAG = 18;
	int STAFF_MEMBER__WORKING_DAYS = 19;
	int STAFF_MEMBER__AVAILABLE_FROM_SLOT = 20;
	int STAFF_MEMBER__AVAILABLE_TO_SLOT = 21;
	int STAFF_MEMBER_FEATURE_COUNT = 7;
	int STAFF_MEMBER_OPERATION_COUNT = 0;
	
	int ROOM = 5;
	int ROOM__NUMBER = 22;
	int ROOM__ROOM_TYPE = 23;
	int ROOM__OPEN_DAYS = 24;
	int ROOM__AVAILABLE_FROM_SLOT = 25;
	int ROOM__AVAILABLE_TO_SLOT = 26;
	int ROOM_FEATURE_COUNT = 5;
	int ROOM_OPERATION_COUNT = 0;
	
	int PLANNING_DAY = 6;
	int PLANNING_DAY__DAY_INDEX = 27;
	int PLANNING_DAY__DAY_OF_WEEK = 28;
	int PLANNING_DAY__WEEK = 29;
	int PLANNING_DAY_FEATURE_COUNT = 3;
	int PLANNING_DAY_OPERATION_COUNT = 0;
	
	int PLANNING_WEEK = 7;
	int PLANNING_WEEK__WEEK_INDEX = 30;
	int PLANNING_WEEK_FEATURE_COUNT = 1;
	int PLANNING_WEEK_OPERATION_COUNT = 0;
	
	int TIMESLOT = 8;
	int TIMESLOT__START_INDEX = 31;
	int TIMESLOT_FEATURE_COUNT = 1;
	int TIMESLOT_OPERATION_COUNT = 0;
	
	int APPOINTMENT_ASSIGNMENT = 9;
	int APPOINTMENT_ASSIGNMENT__START_SLOT = 32;
	int APPOINTMENT_ASSIGNMENT__STAFF_MEMBER = 33;
	int APPOINTMENT_ASSIGNMENT__ROOM = 34;
	int APPOINTMENT_ASSIGNMENT__PLANNING_DAY = 35;
	int APPOINTMENT_ASSIGNMENT__REQUEST = 36;
	int APPOINTMENT_ASSIGNMENT_FEATURE_COUNT = 5;
	int APPOINTMENT_ASSIGNMENT_OPERATION_COUNT = 0;
	
	int DAYS = 0;
	int ROOM_TYPE = 1;
	

	EClass getAudiologyBooking();
	EReference getAudiologyBooking_WaitingList();
	EReference getAudiologyBooking_Staff();
	EReference getAudiologyBooking_Rooms();
	EReference getAudiologyBooking_Days();
	EReference getAudiologyBooking_Timeslots();
	EReference getAudiologyBooking_AppointmentAssignments();
	EReference getAudiologyBooking_Weeks();
	
	EClass getAppointmentRequest();
	EAttribute getAppointmentRequest_Number();
	EAttribute getAppointmentRequest_RoomRequirement();
	EAttribute getAppointmentRequest_StaffBandRequirement();
	EAttribute getAppointmentRequest_AppointmentType();
	EAttribute getAppointmentRequest_DurationSlots();
	EAttribute getAppointmentRequest_ArtsFlag();
	EAttribute getAppointmentRequest_BookFromDayIndex();
	EAttribute getAppointmentRequest_IdealDayIndex();
	
	EClass getStaffMember();
	EAttribute getStaffMember_Number();
	EAttribute getStaffMember_Band();
	EAttribute getStaffMember_WeeklyHours();
	EAttribute getStaffMember_ArtsFlag();
	EReference getStaffMember_WorkingDays();
	EAttribute getStaffMember_AvailableFromSlot();
	EAttribute getStaffMember_AvailableToSlot();
	
	EClass getRoom();
	EAttribute getRoom_Number();
	EAttribute getRoom_RoomType();
	EReference getRoom_OpenDays();
	EAttribute getRoom_AvailableFromSlot();
	EAttribute getRoom_AvailableToSlot();
	
	EClass getPlanningDay();
	EAttribute getPlanningDay_DayIndex();
	EAttribute getPlanningDay_DayOfWeek();
	EReference getPlanningDay_Week();
	
	EClass getPlanningWeek();
	EAttribute getPlanningWeek_WeekIndex();
	
	EClass getTimeslot();
	EAttribute getTimeslot_StartIndex();
	
	EClass getAppointmentAssignment();
	EReference getAppointmentAssignment_StartSlot();
	EReference getAppointmentAssignment_StaffMember();
	EReference getAppointmentAssignment_Room();
	EReference getAppointmentAssignment_PlanningDay();
	EReference getAppointmentAssignment_Request();
	
	EEnum getDays();
	EEnum getRoomType();
	
	audiologymodel.AudiologymodelFactory getAudiologymodelFactory();

	interface Literals {
		
		EClass AUDIOLOGY_BOOKING = eINSTANCE.getAudiologyBooking();
		
		EReference AUDIOLOGY_BOOKING__WAITING_LIST = eINSTANCE.getAudiologyBooking_WaitingList();
		
		EReference AUDIOLOGY_BOOKING__STAFF = eINSTANCE.getAudiologyBooking_Staff();
		
		EReference AUDIOLOGY_BOOKING__ROOMS = eINSTANCE.getAudiologyBooking_Rooms();
		
		EReference AUDIOLOGY_BOOKING__DAYS = eINSTANCE.getAudiologyBooking_Days();
		
		EReference AUDIOLOGY_BOOKING__TIMESLOTS = eINSTANCE.getAudiologyBooking_Timeslots();
		
		EReference AUDIOLOGY_BOOKING__APPOINTMENT_ASSIGNMENTS = eINSTANCE.getAudiologyBooking_AppointmentAssignments();
		
		EReference AUDIOLOGY_BOOKING__WEEKS = eINSTANCE.getAudiologyBooking_Weeks();
		
		EClass APPOINTMENT_REQUEST = eINSTANCE.getAppointmentRequest();
		
		EAttribute APPOINTMENT_REQUEST__NUMBER = eINSTANCE.getAppointmentRequest_Number();
		
		EAttribute APPOINTMENT_REQUEST__ROOM_REQUIREMENT = eINSTANCE.getAppointmentRequest_RoomRequirement();
		
		EAttribute APPOINTMENT_REQUEST__STAFF_BAND_REQUIREMENT = eINSTANCE.getAppointmentRequest_StaffBandRequirement();
		
		EAttribute APPOINTMENT_REQUEST__APPOINTMENT_TYPE = eINSTANCE.getAppointmentRequest_AppointmentType();
		
		EAttribute APPOINTMENT_REQUEST__DURATION_SLOTS = eINSTANCE.getAppointmentRequest_DurationSlots();
		
		EAttribute APPOINTMENT_REQUEST__ARTS_FLAG = eINSTANCE.getAppointmentRequest_ArtsFlag();
		
		EAttribute APPOINTMENT_REQUEST__BOOK_FROM_DAY_INDEX = eINSTANCE.getAppointmentRequest_BookFromDayIndex();
		
		EAttribute APPOINTMENT_REQUEST__IDEAL_DAY_INDEX = eINSTANCE.getAppointmentRequest_IdealDayIndex();
		
		EClass STAFF_MEMBER = eINSTANCE.getStaffMember();
		
		EAttribute STAFF_MEMBER__NUMBER = eINSTANCE.getStaffMember_Number();
		
		EAttribute STAFF_MEMBER__BAND = eINSTANCE.getStaffMember_Band();
		
		EAttribute STAFF_MEMBER__WEEKLY_HOURS = eINSTANCE.getStaffMember_WeeklyHours();
		
		EAttribute STAFF_MEMBER__ARTS_FLAG = eINSTANCE.getStaffMember_ArtsFlag();
		
		EReference STAFF_MEMBER__WORKING_DAYS = eINSTANCE.getStaffMember_WorkingDays();
		
		EAttribute STAFF_MEMBER__AVAILABLE_FROM_SLOT = eINSTANCE.getStaffMember_AvailableFromSlot();
		
		EAttribute STAFF_MEMBER__AVAILABLE_TO_SLOT = eINSTANCE.getStaffMember_AvailableToSlot();
		
		EClass ROOM = eINSTANCE.getRoom();
		
		EAttribute ROOM__NUMBER = eINSTANCE.getRoom_Number();
		
		EAttribute ROOM__ROOM_TYPE = eINSTANCE.getRoom_RoomType();
		
		EReference ROOM__OPEN_DAYS = eINSTANCE.getRoom_OpenDays();
		
		EAttribute ROOM__AVAILABLE_FROM_SLOT = eINSTANCE.getRoom_AvailableFromSlot();
		
		EAttribute ROOM__AVAILABLE_TO_SLOT = eINSTANCE.getRoom_AvailableToSlot();
		
		EClass PLANNING_DAY = eINSTANCE.getPlanningDay();
		
		EAttribute PLANNING_DAY__DAY_INDEX = eINSTANCE.getPlanningDay_DayIndex();
		
		EAttribute PLANNING_DAY__DAY_OF_WEEK = eINSTANCE.getPlanningDay_DayOfWeek();
		
		EReference PLANNING_DAY__WEEK = eINSTANCE.getPlanningDay_Week();
		
		EClass PLANNING_WEEK = eINSTANCE.getPlanningWeek();
		
		EAttribute PLANNING_WEEK__WEEK_INDEX = eINSTANCE.getPlanningWeek_WeekIndex();
		
		EClass TIMESLOT = eINSTANCE.getTimeslot();
		
		EAttribute TIMESLOT__START_INDEX = eINSTANCE.getTimeslot_StartIndex();
		
		EClass APPOINTMENT_ASSIGNMENT = eINSTANCE.getAppointmentAssignment();
		
		EReference APPOINTMENT_ASSIGNMENT__START_SLOT = eINSTANCE.getAppointmentAssignment_StartSlot();
		
		EReference APPOINTMENT_ASSIGNMENT__STAFF_MEMBER = eINSTANCE.getAppointmentAssignment_StaffMember();
		
		EReference APPOINTMENT_ASSIGNMENT__ROOM = eINSTANCE.getAppointmentAssignment_Room();
		
		EReference APPOINTMENT_ASSIGNMENT__PLANNING_DAY = eINSTANCE.getAppointmentAssignment_PlanningDay();
		
		EReference APPOINTMENT_ASSIGNMENT__REQUEST = eINSTANCE.getAppointmentAssignment_Request();
		
		
		EEnum DAYS = eINSTANCE.getDays();
		EEnum ROOM_TYPE = eINSTANCE.getRoomType();
		
		
	}

} 
