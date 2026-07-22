package audiologyoptimiser.hipe.engine;

import akka.actor.ActorRef;
import akka.actor.Props;

import audiologyoptimiser.hipe.engine.actor.NotificationActor;
import audiologyoptimiser.hipe.engine.actor.DispatchActor;
import audiologyoptimiser.hipe.engine.actor.node.AppointmentRequest_object;
import audiologyoptimiser.hipe.engine.actor.junction.assignAppointment_2_junction;
import audiologyoptimiser.hipe.engine.actor.junction.assignAppointment_1_junction;

import hipe.engine.IHiPEEngine;
import hipe.engine.message.InitGenReferenceActor;

import hipe.generic.actor.GenericObjectActor;
import hipe.generic.actor.GenericReferenceActor;
import hipe.generic.actor.GenericProductionActor;
import hipe.generic.actor.junction.*;

import hipe.network.*;

public class HiPEEngine extends IHiPEEngine{
	
	public HiPEEngine(HiPENetwork network) {
		super(network);
	}
	
	public HiPEEngine() {
		super();
	}
	
	@Override
	public String getClassLocation() {
		return getClass().getProtectionDomain().getCodeSource().getLocation().getPath().toString();
	}
	
	@Override
	public String getPackageName() {
		return getClass().getPackageName();
	}
	
	@Override
	protected ActorRef getDispatchActor() {
		return system.actorOf(
			Props.create(DispatchActor.class, () -> new DispatchActor(name2actor, incUtil)),
			"DispatchActor");
	}
	
	@Override
	protected ActorRef getNotificationActor(boolean cascadingNotifications) {
		return system.actorOf(
			Props.create(NotificationActor.class, () -> new NotificationActor(dispatcher, incUtil, cascadingNotifications)), 
			"NotificationActor");
	}
	
	@Override
	public void createProductionNodes() {
		classes.put("assignAppointment_production", GenericProductionActor.class);
		productionNodes2pattern.put("assignAppointment_production", "assignAppointment");
		classes.put("requestTuple_production", GenericProductionActor.class);
		productionNodes2pattern.put("requestTuple_production", "requestTuple");
		classes.put("roomDaySlotTuple_production", GenericProductionActor.class);
		productionNodes2pattern.put("roomDaySlotTuple_production", "roomDaySlotTuple");
		classes.put("staffDaySlotTuple_production", GenericProductionActor.class);
		productionNodes2pattern.put("staffDaySlotTuple_production", "staffDaySlotTuple");
		classes.put("staffDayTuple_production", GenericProductionActor.class);
		productionNodes2pattern.put("staffDayTuple_production", "staffDayTuple");
		classes.put("staffRoomDayTuple_production", GenericProductionActor.class);
		productionNodes2pattern.put("staffRoomDayTuple_production", "staffRoomDayTuple");
		classes.put("staffWeekTuple_production", GenericProductionActor.class);
		productionNodes2pattern.put("staffWeekTuple_production", "staffWeekTuple");
		
	}
	
	@Override
	public void createJunctionNodes() {
		classes.put("assignAppointment_2_junction", assignAppointment_2_junction.class);
		classes.put("assignAppointment_triangle_1_triangleJunction", GenericTriangleJunctionActor.class);
		classes.put("assignAppointment_triangle_0_triangleJunction", GenericTriangleJunctionActor.class);
		classes.put("assignAppointment_3_junction", GenericJunctionActor.class);
		classes.put("assignAppointment_1_junction", assignAppointment_1_junction.class);
		classes.put("roomDaySlotTuple_triangle_0_triangleJunction", GenericTriangleJunctionActor.class);
		classes.put("roomDaySlotTuple_24_junction", GenericJunctionActor.class);
		classes.put("staffDaySlotTuple_triangle_0_triangleJunction", GenericTriangleJunctionActor.class);
		classes.put("staffDaySlotTuple_34_junction", GenericJunctionActor.class);
		classes.put("staffDayTuple_triangle_0_triangleJunction", GenericTriangleJunctionActor.class);
		classes.put("staffRoomDayTuple_triangle_1_triangleJunction", GenericTriangleJunctionActor.class);
		classes.put("staffRoomDayTuple_triangle_0_triangleJunction", GenericTriangleJunctionActor.class);
		classes.put("staffWeekTuple_62_junction", GenericJunctionActor.class);
	}
	
	@Override
	public void createReferenceNodes() {
		classes.put("AudiologyBooking_timeslots_0_reference",AudiologyBooking_timeslots_0_reference.class);
		classes.put("AudiologyBooking_waitingList_0_reference",AudiologyBooking_waitingList_0_reference.class);
		classes.put("PlanningDay_week_0_reference",PlanningDay_week_0_reference.class);
		classes.put("AudiologyBooking_staff_0_reference",AudiologyBooking_staff_0_reference.class);
		classes.put("StaffMember_workingDays_0_reference",StaffMember_workingDays_0_reference.class);
		classes.put("AudiologyBooking_days_0_reference",AudiologyBooking_days_0_reference.class);
		classes.put("Room_openDays_0_reference",Room_openDays_0_reference.class);
		classes.put("AudiologyBooking_rooms_0_reference",AudiologyBooking_rooms_0_reference.class);
		classes.put("AudiologyBooking_waitingList_1_reference",AudiologyBooking_waitingList_1_reference.class);
		classes.put("AudiologyBooking_weeks_0_reference",AudiologyBooking_weeks_0_reference.class);
		
	}
	
	@Override
	public void createObjectNodes() {
		classes.put("Timeslot_object",Timeslot_object.class);
		classes.put("AppointmentRequest_object",AppointmentRequest_object.class);
		classes.put("PlanningDay_object",PlanningDay_object.class);
		classes.put("PlanningWeek_object",PlanningWeek_object.class);
		classes.put("StaffMember_object",StaffMember_object.class);
		classes.put("Room_object",Room_object.class);
		classes.put("AudiologyBooking_object_SP0",AudiologyBooking_object_SP0.class);
		classes.put("AudiologyBooking_object_SP1",AudiologyBooking_object_SP1.class);
		
	}
	
	@Override
	public void initializeReferenceNodes() {
		name2initRefGen.put("AudiologyBooking_timeslots_0_reference", new InitGenReferenceActor<audiologymodel.AudiologyBooking,audiologymodel.Timeslot>(name2actor, name2node.get("AudiologyBooking_timeslots_0_reference"), (o) -> o instanceof audiologymodel.AudiologyBooking, null, (o) -> o.getTimeslots(), false, prodUtil, incUtil));
		name2initRefGen.put("AudiologyBooking_waitingList_0_reference", new InitGenReferenceActor<audiologymodel.AudiologyBooking,audiologymodel.AppointmentRequest>(name2actor, name2node.get("AudiologyBooking_waitingList_0_reference"), (o) -> o instanceof audiologymodel.AudiologyBooking, null, (o) -> o.getWaitingList(), false, prodUtil, incUtil));
		name2initRefGen.put("PlanningDay_week_0_reference", new InitGenReferenceActor<audiologymodel.PlanningDay,audiologymodel.PlanningWeek>(name2actor, name2node.get("PlanningDay_week_0_reference"), (o) -> o instanceof audiologymodel.PlanningDay, (o) -> o.getWeek(), null, false, prodUtil, incUtil));
		name2initRefGen.put("AudiologyBooking_staff_0_reference", new InitGenReferenceActor<audiologymodel.AudiologyBooking,audiologymodel.StaffMember>(name2actor, name2node.get("AudiologyBooking_staff_0_reference"), (o) -> o instanceof audiologymodel.AudiologyBooking, null, (o) -> o.getStaff(), false, prodUtil, incUtil));
		name2initRefGen.put("StaffMember_workingDays_0_reference", new InitGenReferenceActor<audiologymodel.StaffMember,audiologymodel.PlanningDay>(name2actor, name2node.get("StaffMember_workingDays_0_reference"), (o) -> o instanceof audiologymodel.StaffMember, null, (o) -> o.getWorkingDays(), false, prodUtil, incUtil));
		name2initRefGen.put("AudiologyBooking_days_0_reference", new InitGenReferenceActor<audiologymodel.AudiologyBooking,audiologymodel.PlanningDay>(name2actor, name2node.get("AudiologyBooking_days_0_reference"), (o) -> o instanceof audiologymodel.AudiologyBooking, null, (o) -> o.getDays(), false, prodUtil, incUtil));
		name2initRefGen.put("Room_openDays_0_reference", new InitGenReferenceActor<audiologymodel.Room,audiologymodel.PlanningDay>(name2actor, name2node.get("Room_openDays_0_reference"), (o) -> o instanceof audiologymodel.Room, null, (o) -> o.getOpenDays(), false, prodUtil, incUtil));
		name2initRefGen.put("AudiologyBooking_rooms_0_reference", new InitGenReferenceActor<audiologymodel.AudiologyBooking,audiologymodel.Room>(name2actor, name2node.get("AudiologyBooking_rooms_0_reference"), (o) -> o instanceof audiologymodel.AudiologyBooking, null, (o) -> o.getRooms(), false, prodUtil, incUtil));
		name2initRefGen.put("AudiologyBooking_waitingList_1_reference", new InitGenReferenceActor<audiologymodel.AudiologyBooking,audiologymodel.AppointmentRequest>(name2actor, name2node.get("AudiologyBooking_waitingList_1_reference"), (o) -> o instanceof audiologymodel.AudiologyBooking, null, (o) -> o.getWaitingList(), false, prodUtil, incUtil));
		name2initRefGen.put("AudiologyBooking_weeks_0_reference", new InitGenReferenceActor<audiologymodel.AudiologyBooking,audiologymodel.PlanningWeek>(name2actor, name2node.get("AudiologyBooking_weeks_0_reference"), (o) -> o instanceof audiologymodel.AudiologyBooking, null, (o) -> o.getWeeks(), false, prodUtil, incUtil));
	}
}

class Timeslot_object extends GenericObjectActor<audiologymodel.Timeslot> { }
class PlanningDay_object extends GenericObjectActor<audiologymodel.PlanningDay> { }
class PlanningWeek_object extends GenericObjectActor<audiologymodel.PlanningWeek> { }
class StaffMember_object extends GenericObjectActor<audiologymodel.StaffMember> { }
class Room_object extends GenericObjectActor<audiologymodel.Room> { }
class AudiologyBooking_object_SP0 extends GenericObjectActor<audiologymodel.AudiologyBooking> { }
class AudiologyBooking_object_SP1 extends GenericObjectActor<audiologymodel.AudiologyBooking> { }

class AudiologyBooking_timeslots_0_reference extends GenericReferenceActor<audiologymodel.AudiologyBooking, audiologymodel.Timeslot> { }
class AudiologyBooking_waitingList_0_reference extends GenericReferenceActor<audiologymodel.AudiologyBooking, audiologymodel.AppointmentRequest> { }
class PlanningDay_week_0_reference extends GenericReferenceActor<audiologymodel.PlanningDay, audiologymodel.PlanningWeek> { }
class AudiologyBooking_staff_0_reference extends GenericReferenceActor<audiologymodel.AudiologyBooking, audiologymodel.StaffMember> { }
class StaffMember_workingDays_0_reference extends GenericReferenceActor<audiologymodel.StaffMember, audiologymodel.PlanningDay> { }
class AudiologyBooking_days_0_reference extends GenericReferenceActor<audiologymodel.AudiologyBooking, audiologymodel.PlanningDay> { }
class Room_openDays_0_reference extends GenericReferenceActor<audiologymodel.Room, audiologymodel.PlanningDay> { }
class AudiologyBooking_rooms_0_reference extends GenericReferenceActor<audiologymodel.AudiologyBooking, audiologymodel.Room> { }
class AudiologyBooking_waitingList_1_reference extends GenericReferenceActor<audiologymodel.AudiologyBooking, audiologymodel.AppointmentRequest> { }
class AudiologyBooking_weeks_0_reference extends GenericReferenceActor<audiologymodel.AudiologyBooking, audiologymodel.PlanningWeek> { }

