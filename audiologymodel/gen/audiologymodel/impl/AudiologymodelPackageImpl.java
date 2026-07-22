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


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emoflon.smartemf.runtime.SmartPackageImpl;

public class AudiologymodelPackageImpl extends SmartPackageImpl
		implements AudiologymodelPackage {
			
	private EClass audiologyBookingEClass = null;
	private EReference audiologyBooking_waitingListEReference = null;
	private EReference audiologyBooking_staffEReference = null;
	private EReference audiologyBooking_roomsEReference = null;
	private EReference audiologyBooking_daysEReference = null;
	private EReference audiologyBooking_timeslotsEReference = null;
	private EReference audiologyBooking_appointmentAssignmentsEReference = null;
	private EReference audiologyBooking_weeksEReference = null;
	private EClass appointmentRequestEClass = null;
	private EAttribute appointmentRequest_numberEAttribute = null;
	private EAttribute appointmentRequest_roomRequirementEAttribute = null;
	private EAttribute appointmentRequest_staffBandRequirementEAttribute = null;
	private EAttribute appointmentRequest_appointmentTypeEAttribute = null;
	private EAttribute appointmentRequest_durationSlotsEAttribute = null;
	private EAttribute appointmentRequest_artsFlagEAttribute = null;
	private EAttribute appointmentRequest_bookFromDayIndexEAttribute = null;
	private EAttribute appointmentRequest_idealDayIndexEAttribute = null;
	private EClass staffMemberEClass = null;
	private EAttribute staffMember_numberEAttribute = null;
	private EAttribute staffMember_bandEAttribute = null;
	private EAttribute staffMember_weeklyHoursEAttribute = null;
	private EAttribute staffMember_artsFlagEAttribute = null;
	private EReference staffMember_workingDaysEReference = null;
	private EAttribute staffMember_availableFromSlotEAttribute = null;
	private EAttribute staffMember_availableToSlotEAttribute = null;
	private EClass roomEClass = null;
	private EAttribute room_numberEAttribute = null;
	private EAttribute room_roomTypeEAttribute = null;
	private EReference room_openDaysEReference = null;
	private EAttribute room_availableFromSlotEAttribute = null;
	private EAttribute room_availableToSlotEAttribute = null;
	private EClass planningDayEClass = null;
	private EAttribute planningDay_dayIndexEAttribute = null;
	private EAttribute planningDay_dayOfWeekEAttribute = null;
	private EReference planningDay_weekEReference = null;
	private EClass planningWeekEClass = null;
	private EAttribute planningWeek_weekIndexEAttribute = null;
	private EClass timeslotEClass = null;
	private EAttribute timeslot_startIndexEAttribute = null;
	private EClass appointmentAssignmentEClass = null;
	private EReference appointmentAssignment_startSlotEReference = null;
	private EReference appointmentAssignment_staffMemberEReference = null;
	private EReference appointmentAssignment_roomEReference = null;
	private EReference appointmentAssignment_planningDayEReference = null;
	private EReference appointmentAssignment_requestEReference = null;
	
	private EEnum daysEEnum = null;
	private EEnum roomTypeEEnum = null;
	

	private AudiologymodelPackageImpl() {
		super(eNS_URI, audiologymodel.AudiologymodelFactory.eINSTANCE);
	}

	private static boolean isRegistered = false;
	private boolean isCreated = false;
	private boolean isInitialized = false;

	public static AudiologymodelPackage init() {
		if (isRegistered)
			return (AudiologymodelPackage) EPackage.Registry.INSTANCE
					.getEPackage(AudiologymodelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAudiologymodelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AudiologymodelPackageImpl theAudiologymodelPackage = registeredAudiologymodelPackage instanceof AudiologymodelPackageImpl
				? (AudiologymodelPackageImpl) registeredAudiologymodelPackage
				: new AudiologymodelPackageImpl();

		isRegistered = true;

		// Create package meta-data objects
		theAudiologymodelPackage.createPackageContents();

		// Initialize created meta-data
		theAudiologymodelPackage.initializePackageContents();
		
		// Inject internal eOpposites to unidirectional references
		theAudiologymodelPackage.injectDynamicOpposites();
		
		// Inject external references into foreign packages
		theAudiologymodelPackage.injectExternalReferences();

		// Mark meta-data to indicate it can't be changed
		theAudiologymodelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AudiologymodelPackage.eNS_URI,
				theAudiologymodelPackage);
				
		theAudiologymodelPackage.fetchDynamicEStructuralFeaturesOfSuperTypes();
		return theAudiologymodelPackage;
	}

	@Override
	public EClass getAudiologyBooking() {
		return audiologyBookingEClass;
	}
	@Override
	public EReference getAudiologyBooking_WaitingList() {
		return audiologyBooking_waitingListEReference;	
	}
	@Override
	public EReference getAudiologyBooking_Staff() {
		return audiologyBooking_staffEReference;	
	}
	@Override
	public EReference getAudiologyBooking_Rooms() {
		return audiologyBooking_roomsEReference;	
	}
	@Override
	public EReference getAudiologyBooking_Days() {
		return audiologyBooking_daysEReference;	
	}
	@Override
	public EReference getAudiologyBooking_Timeslots() {
		return audiologyBooking_timeslotsEReference;	
	}
	@Override
	public EReference getAudiologyBooking_AppointmentAssignments() {
		return audiologyBooking_appointmentAssignmentsEReference;	
	}
	@Override
	public EReference getAudiologyBooking_Weeks() {
		return audiologyBooking_weeksEReference;	
	}
	@Override
	public EClass getAppointmentRequest() {
		return appointmentRequestEClass;
	}
	@Override
	public EAttribute getAppointmentRequest_Number() {
		return appointmentRequest_numberEAttribute;	
	}
	@Override
	public EAttribute getAppointmentRequest_RoomRequirement() {
		return appointmentRequest_roomRequirementEAttribute;	
	}
	@Override
	public EAttribute getAppointmentRequest_StaffBandRequirement() {
		return appointmentRequest_staffBandRequirementEAttribute;	
	}
	@Override
	public EAttribute getAppointmentRequest_AppointmentType() {
		return appointmentRequest_appointmentTypeEAttribute;	
	}
	@Override
	public EAttribute getAppointmentRequest_DurationSlots() {
		return appointmentRequest_durationSlotsEAttribute;	
	}
	@Override
	public EAttribute getAppointmentRequest_ArtsFlag() {
		return appointmentRequest_artsFlagEAttribute;	
	}
	@Override
	public EAttribute getAppointmentRequest_BookFromDayIndex() {
		return appointmentRequest_bookFromDayIndexEAttribute;	
	}
	@Override
	public EAttribute getAppointmentRequest_IdealDayIndex() {
		return appointmentRequest_idealDayIndexEAttribute;	
	}
	@Override
	public EClass getStaffMember() {
		return staffMemberEClass;
	}
	@Override
	public EAttribute getStaffMember_Number() {
		return staffMember_numberEAttribute;	
	}
	@Override
	public EAttribute getStaffMember_Band() {
		return staffMember_bandEAttribute;	
	}
	@Override
	public EAttribute getStaffMember_WeeklyHours() {
		return staffMember_weeklyHoursEAttribute;	
	}
	@Override
	public EAttribute getStaffMember_ArtsFlag() {
		return staffMember_artsFlagEAttribute;	
	}
	@Override
	public EReference getStaffMember_WorkingDays() {
		return staffMember_workingDaysEReference;	
	}
	@Override
	public EAttribute getStaffMember_AvailableFromSlot() {
		return staffMember_availableFromSlotEAttribute;	
	}
	@Override
	public EAttribute getStaffMember_AvailableToSlot() {
		return staffMember_availableToSlotEAttribute;	
	}
	@Override
	public EClass getRoom() {
		return roomEClass;
	}
	@Override
	public EAttribute getRoom_Number() {
		return room_numberEAttribute;	
	}
	@Override
	public EAttribute getRoom_RoomType() {
		return room_roomTypeEAttribute;	
	}
	@Override
	public EReference getRoom_OpenDays() {
		return room_openDaysEReference;	
	}
	@Override
	public EAttribute getRoom_AvailableFromSlot() {
		return room_availableFromSlotEAttribute;	
	}
	@Override
	public EAttribute getRoom_AvailableToSlot() {
		return room_availableToSlotEAttribute;	
	}
	@Override
	public EClass getPlanningDay() {
		return planningDayEClass;
	}
	@Override
	public EAttribute getPlanningDay_DayIndex() {
		return planningDay_dayIndexEAttribute;	
	}
	@Override
	public EAttribute getPlanningDay_DayOfWeek() {
		return planningDay_dayOfWeekEAttribute;	
	}
	@Override
	public EReference getPlanningDay_Week() {
		return planningDay_weekEReference;	
	}
	@Override
	public EClass getPlanningWeek() {
		return planningWeekEClass;
	}
	@Override
	public EAttribute getPlanningWeek_WeekIndex() {
		return planningWeek_weekIndexEAttribute;	
	}
	@Override
	public EClass getTimeslot() {
		return timeslotEClass;
	}
	@Override
	public EAttribute getTimeslot_StartIndex() {
		return timeslot_startIndexEAttribute;	
	}
	@Override
	public EClass getAppointmentAssignment() {
		return appointmentAssignmentEClass;
	}
	@Override
	public EReference getAppointmentAssignment_StartSlot() {
		return appointmentAssignment_startSlotEReference;	
	}
	@Override
	public EReference getAppointmentAssignment_StaffMember() {
		return appointmentAssignment_staffMemberEReference;	
	}
	@Override
	public EReference getAppointmentAssignment_Room() {
		return appointmentAssignment_roomEReference;	
	}
	@Override
	public EReference getAppointmentAssignment_PlanningDay() {
		return appointmentAssignment_planningDayEReference;	
	}
	@Override
	public EReference getAppointmentAssignment_Request() {
		return appointmentAssignment_requestEReference;	
	}
	
	@Override
	public EEnum getDays() {
		return daysEEnum;
	}
	@Override
	public EEnum getRoomType() {
		return roomTypeEEnum;
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public audiologymodel.AudiologymodelFactory getAudiologymodelFactory() {
		return (audiologymodel.AudiologymodelFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		audiologyBookingEClass = createEClass(AUDIOLOGY_BOOKING);
		createEReference(audiologyBookingEClass, AUDIOLOGY_BOOKING__WAITING_LIST);
		audiologyBooking_waitingListEReference = (EReference) audiologyBookingEClass.getEStructuralFeatures().get(0);
		createEReference(audiologyBookingEClass, AUDIOLOGY_BOOKING__STAFF);
		audiologyBooking_staffEReference = (EReference) audiologyBookingEClass.getEStructuralFeatures().get(1);
		createEReference(audiologyBookingEClass, AUDIOLOGY_BOOKING__ROOMS);
		audiologyBooking_roomsEReference = (EReference) audiologyBookingEClass.getEStructuralFeatures().get(2);
		createEReference(audiologyBookingEClass, AUDIOLOGY_BOOKING__DAYS);
		audiologyBooking_daysEReference = (EReference) audiologyBookingEClass.getEStructuralFeatures().get(3);
		createEReference(audiologyBookingEClass, AUDIOLOGY_BOOKING__TIMESLOTS);
		audiologyBooking_timeslotsEReference = (EReference) audiologyBookingEClass.getEStructuralFeatures().get(4);
		createEReference(audiologyBookingEClass, AUDIOLOGY_BOOKING__APPOINTMENT_ASSIGNMENTS);
		audiologyBooking_appointmentAssignmentsEReference = (EReference) audiologyBookingEClass.getEStructuralFeatures().get(5);
		createEReference(audiologyBookingEClass, AUDIOLOGY_BOOKING__WEEKS);
		audiologyBooking_weeksEReference = (EReference) audiologyBookingEClass.getEStructuralFeatures().get(6);
		
		appointmentRequestEClass = createEClass(APPOINTMENT_REQUEST);
		createEAttribute(appointmentRequestEClass, APPOINTMENT_REQUEST__NUMBER);
		appointmentRequest_numberEAttribute = (EAttribute) appointmentRequestEClass.getEStructuralFeatures().get(0);
		createEAttribute(appointmentRequestEClass, APPOINTMENT_REQUEST__ROOM_REQUIREMENT);
		appointmentRequest_roomRequirementEAttribute = (EAttribute) appointmentRequestEClass.getEStructuralFeatures().get(1);
		createEAttribute(appointmentRequestEClass, APPOINTMENT_REQUEST__STAFF_BAND_REQUIREMENT);
		appointmentRequest_staffBandRequirementEAttribute = (EAttribute) appointmentRequestEClass.getEStructuralFeatures().get(2);
		createEAttribute(appointmentRequestEClass, APPOINTMENT_REQUEST__APPOINTMENT_TYPE);
		appointmentRequest_appointmentTypeEAttribute = (EAttribute) appointmentRequestEClass.getEStructuralFeatures().get(3);
		createEAttribute(appointmentRequestEClass, APPOINTMENT_REQUEST__DURATION_SLOTS);
		appointmentRequest_durationSlotsEAttribute = (EAttribute) appointmentRequestEClass.getEStructuralFeatures().get(4);
		createEAttribute(appointmentRequestEClass, APPOINTMENT_REQUEST__ARTS_FLAG);
		appointmentRequest_artsFlagEAttribute = (EAttribute) appointmentRequestEClass.getEStructuralFeatures().get(5);
		createEAttribute(appointmentRequestEClass, APPOINTMENT_REQUEST__BOOK_FROM_DAY_INDEX);
		appointmentRequest_bookFromDayIndexEAttribute = (EAttribute) appointmentRequestEClass.getEStructuralFeatures().get(6);
		createEAttribute(appointmentRequestEClass, APPOINTMENT_REQUEST__IDEAL_DAY_INDEX);
		appointmentRequest_idealDayIndexEAttribute = (EAttribute) appointmentRequestEClass.getEStructuralFeatures().get(7);
		
		staffMemberEClass = createEClass(STAFF_MEMBER);
		createEAttribute(staffMemberEClass, STAFF_MEMBER__NUMBER);
		staffMember_numberEAttribute = (EAttribute) staffMemberEClass.getEStructuralFeatures().get(0);
		createEAttribute(staffMemberEClass, STAFF_MEMBER__BAND);
		staffMember_bandEAttribute = (EAttribute) staffMemberEClass.getEStructuralFeatures().get(1);
		createEAttribute(staffMemberEClass, STAFF_MEMBER__WEEKLY_HOURS);
		staffMember_weeklyHoursEAttribute = (EAttribute) staffMemberEClass.getEStructuralFeatures().get(2);
		createEAttribute(staffMemberEClass, STAFF_MEMBER__ARTS_FLAG);
		staffMember_artsFlagEAttribute = (EAttribute) staffMemberEClass.getEStructuralFeatures().get(3);
		createEReference(staffMemberEClass, STAFF_MEMBER__WORKING_DAYS);
		staffMember_workingDaysEReference = (EReference) staffMemberEClass.getEStructuralFeatures().get(4);
		createEAttribute(staffMemberEClass, STAFF_MEMBER__AVAILABLE_FROM_SLOT);
		staffMember_availableFromSlotEAttribute = (EAttribute) staffMemberEClass.getEStructuralFeatures().get(5);
		createEAttribute(staffMemberEClass, STAFF_MEMBER__AVAILABLE_TO_SLOT);
		staffMember_availableToSlotEAttribute = (EAttribute) staffMemberEClass.getEStructuralFeatures().get(6);
		
		roomEClass = createEClass(ROOM);
		createEAttribute(roomEClass, ROOM__NUMBER);
		room_numberEAttribute = (EAttribute) roomEClass.getEStructuralFeatures().get(0);
		createEAttribute(roomEClass, ROOM__ROOM_TYPE);
		room_roomTypeEAttribute = (EAttribute) roomEClass.getEStructuralFeatures().get(1);
		createEReference(roomEClass, ROOM__OPEN_DAYS);
		room_openDaysEReference = (EReference) roomEClass.getEStructuralFeatures().get(2);
		createEAttribute(roomEClass, ROOM__AVAILABLE_FROM_SLOT);
		room_availableFromSlotEAttribute = (EAttribute) roomEClass.getEStructuralFeatures().get(3);
		createEAttribute(roomEClass, ROOM__AVAILABLE_TO_SLOT);
		room_availableToSlotEAttribute = (EAttribute) roomEClass.getEStructuralFeatures().get(4);
		
		planningDayEClass = createEClass(PLANNING_DAY);
		createEAttribute(planningDayEClass, PLANNING_DAY__DAY_INDEX);
		planningDay_dayIndexEAttribute = (EAttribute) planningDayEClass.getEStructuralFeatures().get(0);
		createEAttribute(planningDayEClass, PLANNING_DAY__DAY_OF_WEEK);
		planningDay_dayOfWeekEAttribute = (EAttribute) planningDayEClass.getEStructuralFeatures().get(1);
		createEReference(planningDayEClass, PLANNING_DAY__WEEK);
		planningDay_weekEReference = (EReference) planningDayEClass.getEStructuralFeatures().get(2);
		
		planningWeekEClass = createEClass(PLANNING_WEEK);
		createEAttribute(planningWeekEClass, PLANNING_WEEK__WEEK_INDEX);
		planningWeek_weekIndexEAttribute = (EAttribute) planningWeekEClass.getEStructuralFeatures().get(0);
		
		timeslotEClass = createEClass(TIMESLOT);
		createEAttribute(timeslotEClass, TIMESLOT__START_INDEX);
		timeslot_startIndexEAttribute = (EAttribute) timeslotEClass.getEStructuralFeatures().get(0);
		
		appointmentAssignmentEClass = createEClass(APPOINTMENT_ASSIGNMENT);
		createEReference(appointmentAssignmentEClass, APPOINTMENT_ASSIGNMENT__START_SLOT);
		appointmentAssignment_startSlotEReference = (EReference) appointmentAssignmentEClass.getEStructuralFeatures().get(0);
		createEReference(appointmentAssignmentEClass, APPOINTMENT_ASSIGNMENT__STAFF_MEMBER);
		appointmentAssignment_staffMemberEReference = (EReference) appointmentAssignmentEClass.getEStructuralFeatures().get(1);
		createEReference(appointmentAssignmentEClass, APPOINTMENT_ASSIGNMENT__ROOM);
		appointmentAssignment_roomEReference = (EReference) appointmentAssignmentEClass.getEStructuralFeatures().get(2);
		createEReference(appointmentAssignmentEClass, APPOINTMENT_ASSIGNMENT__PLANNING_DAY);
		appointmentAssignment_planningDayEReference = (EReference) appointmentAssignmentEClass.getEStructuralFeatures().get(3);
		createEReference(appointmentAssignmentEClass, APPOINTMENT_ASSIGNMENT__REQUEST);
		appointmentAssignment_requestEReference = (EReference) appointmentAssignmentEClass.getEStructuralFeatures().get(4);
		
		// Create enums
		daysEEnum = createEEnum(DAYS);
		roomTypeEEnum = createEEnum(ROOM_TYPE);
		
		// Create data types
	}

	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);
		
		// Obtain other dependent packages

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(audiologyBookingEClass, AudiologyBooking.class, "AudiologyBooking", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAudiologyBooking_WaitingList(), this.getAppointmentRequest(),  null, 
			"waitingList", null, 0, -1, AudiologyBooking.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAudiologyBooking_Staff(), this.getStaffMember(),  null, 
			"staff", null, 0, -1, AudiologyBooking.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAudiologyBooking_Rooms(), this.getRoom(),  null, 
			"rooms", null, 0, -1, AudiologyBooking.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAudiologyBooking_Days(), this.getPlanningDay(),  null, 
			"days", null, 0, -1, AudiologyBooking.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAudiologyBooking_Timeslots(), this.getTimeslot(),  null, 
			"timeslots", null, 0, -1, AudiologyBooking.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAudiologyBooking_AppointmentAssignments(), this.getAppointmentAssignment(),  null, 
			"appointmentAssignments", null, 0, -1, AudiologyBooking.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAudiologyBooking_Weeks(), this.getPlanningWeek(),  null, 
			"weeks", null, 0, -1, AudiologyBooking.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
				
		initEClass(appointmentRequestEClass, AppointmentRequest.class, "AppointmentRequest", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAppointmentRequest_Number(), ecorePackage.getEInt(),
			"number", "0", 0, 1, AppointmentRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppointmentRequest_RoomRequirement(), this.getRoomType(),
			"roomRequirement", "ROOM", 0, 1, AppointmentRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppointmentRequest_StaffBandRequirement(), ecorePackage.getEInt(),
			"staffBandRequirement", "0", 0, 1, AppointmentRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppointmentRequest_AppointmentType(), ecorePackage.getEInt(),
			"appointmentType", "0", 0, 1, AppointmentRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppointmentRequest_DurationSlots(), ecorePackage.getEInt(),
			"durationSlots", "0", 0, 1, AppointmentRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppointmentRequest_ArtsFlag(), ecorePackage.getEBoolean(),
			"artsFlag", "false", 0, 1, AppointmentRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppointmentRequest_BookFromDayIndex(), ecorePackage.getEInt(),
			"bookFromDayIndex", "0", 0, 1, AppointmentRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppointmentRequest_IdealDayIndex(), ecorePackage.getEInt(),
			"idealDayIndex", "0", 0, 1, AppointmentRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		
		initEClass(staffMemberEClass, StaffMember.class, "StaffMember", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStaffMember_Number(), ecorePackage.getEInt(),
			"number", "0", 0, 1, StaffMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaffMember_Band(), ecorePackage.getEInt(),
			"band", "0", 0, 1, StaffMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaffMember_WeeklyHours(), ecorePackage.getEInt(),
			"weeklyHours", "0", 0, 1, StaffMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaffMember_ArtsFlag(), ecorePackage.getEBoolean(),
			"artsFlag", "false", 0, 1, StaffMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getStaffMember_WorkingDays(), this.getPlanningDay(),  null, 
			"workingDays", null, 0, -1, StaffMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaffMember_AvailableFromSlot(), ecorePackage.getEInt(),
			"availableFromSlot", "0", 0, 1, StaffMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaffMember_AvailableToSlot(), ecorePackage.getEInt(),
			"availableToSlot", "0", 0, 1, StaffMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		
		initEClass(roomEClass, Room.class, "Room", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoom_Number(), ecorePackage.getEInt(),
			"number", "0", 0, 1, Room.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoom_RoomType(), this.getRoomType(),
			"roomType", "ROOM", 0, 1, Room.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getRoom_OpenDays(), this.getPlanningDay(),  null, 
			"openDays", null, 0, -1, Room.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoom_AvailableFromSlot(), ecorePackage.getEInt(),
			"availableFromSlot", "0", 0, 1, Room.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoom_AvailableToSlot(), ecorePackage.getEInt(),
			"availableToSlot", "0", 0, 1, Room.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		
		initEClass(planningDayEClass, PlanningDay.class, "PlanningDay", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlanningDay_DayIndex(), ecorePackage.getEInt(),
			"dayIndex", "0", 0, 1, PlanningDay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlanningDay_DayOfWeek(), this.getDays(),
			"dayOfWeek", "MONDAY", 0, 1, PlanningDay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getPlanningDay_Week(), this.getPlanningWeek(),  null, 
			"week", null, 0, 1, PlanningDay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
				
		initEClass(planningWeekEClass, PlanningWeek.class, "PlanningWeek", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlanningWeek_WeekIndex(), ecorePackage.getEInt(),
			"weekIndex", "0", 0, 1, PlanningWeek.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		
		initEClass(timeslotEClass, Timeslot.class, "Timeslot", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeslot_StartIndex(), ecorePackage.getEInt(),
			"startIndex", "0", 0, 1, Timeslot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		
		initEClass(appointmentAssignmentEClass, AppointmentAssignment.class, "AppointmentAssignment", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAppointmentAssignment_StartSlot(), this.getTimeslot(),  null, 
			"startSlot", null, 0, 1, AppointmentAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAppointmentAssignment_StaffMember(), this.getStaffMember(),  null, 
			"staffMember", null, 0, 1, AppointmentAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAppointmentAssignment_Room(), this.getRoom(),  null, 
			"room", null, 0, 1, AppointmentAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAppointmentAssignment_PlanningDay(), this.getPlanningDay(),  null, 
			"planningDay", null, 0, 1, AppointmentAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAppointmentAssignment_Request(), this.getAppointmentRequest(),  null, 
			"request", null, 0, 1, AppointmentAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
				
		
		// Initialize enums and add enum literals
		initEEnum(daysEEnum, Days.class, "Days");
		addEEnumLiteral(daysEEnum, audiologymodel.Days.MONDAY);
		addEEnumLiteral(daysEEnum, audiologymodel.Days.TUESDAY);
		addEEnumLiteral(daysEEnum, audiologymodel.Days.WEDNESDAY);
		addEEnumLiteral(daysEEnum, audiologymodel.Days.THURSDAY);
		addEEnumLiteral(daysEEnum, audiologymodel.Days.FRIDAY);
		initEEnum(roomTypeEEnum, RoomType.class, "RoomType");
		addEEnumLiteral(roomTypeEEnum, audiologymodel.RoomType.ROOM);
		addEEnumLiteral(roomTypeEEnum, audiologymodel.RoomType.BOOTH);
		
		// Initialize data types
		
		// Create resource
		createResource(eNS_URI);
	}

} 

