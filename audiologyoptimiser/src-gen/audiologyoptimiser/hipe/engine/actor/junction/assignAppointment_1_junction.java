package audiologyoptimiser.hipe.engine.actor.junction;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import java.util.Set;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

import hipe.engine.actor.Port;
import hipe.engine.util.HiPESet;
import hipe.engine.match.EdgeMatch;
import hipe.engine.match.HMatch;
import hipe.engine.actor.junction.PortJunction;
import hipe.engine.actor.junction.PortJunctionLeft;
import hipe.engine.actor.junction.PortJunctionRight;
import hipe.engine.message.input.AttributeChanged;
import hipe.engine.util.HiPEMultiUtil;

import hipe.generic.match.GenericJunctionMatch;
import hipe.generic.actor.junction.GenericJunctionActor;

import hipe.network.JunctionNode;

public class assignAppointment_1_junction extends GenericJunctionActor{
	private Map<Object, Collection<HMatch>> planningDayAttrMap = HiPEMultiUtil.createMap();
	private Map<Object, Collection<HMatch>> staffMemberAttrMap = HiPEMultiUtil.createMap();
	private Map<Object, Collection<HMatch>> appointmentRequestAttrMap = HiPEMultiUtil.createMap();
	private Map<Object, Collection<HMatch>> roomAttrMap = HiPEMultiUtil.createMap();
	private Map<Object, Collection<HMatch>> timeslotAttrMap = HiPEMultiUtil.createMap();
	
	@Override
	protected void initializePorts(Map<String, ActorRef> name2actor, JunctionNode node) {
		constraints.add(this::check_constraint_3);
		
		ports = new LinkedList<>();
		ports.add(new PortJunction(node.getPorts().getPort().get(0), getSelf(), name2actor.get("assignAppointment_production"), this::returnTrue , 0  , false ));
	}
	
	@Override
	protected void registerMatchForAttributeChanges(HMatch match) {
		Object[] matchObjects = match.getNodes();
		Collection<HMatch> planningDay_3_Matches = planningDayAttrMap.get(matchObjects[3]);
		if(planningDay_3_Matches == null) {
			planningDay_3_Matches = new LinkedList<>();
			planningDayAttrMap.put(matchObjects[3], planningDay_3_Matches);
		}
		
		planningDay_3_Matches.add(match);
		
		Collection<HMatch> staffMember_5_Matches = staffMemberAttrMap.get(matchObjects[5]);
		if(staffMember_5_Matches == null) {
			staffMember_5_Matches = new LinkedList<>();
			staffMemberAttrMap.put(matchObjects[5], staffMember_5_Matches);
		}
		
		staffMember_5_Matches.add(match);
		
		Collection<HMatch> appointmentRequest_2_Matches = appointmentRequestAttrMap.get(matchObjects[2]);
		if(appointmentRequest_2_Matches == null) {
			appointmentRequest_2_Matches = new LinkedList<>();
			appointmentRequestAttrMap.put(matchObjects[2], appointmentRequest_2_Matches);
		}
		
		appointmentRequest_2_Matches.add(match);
		
		Collection<HMatch> room_6_Matches = roomAttrMap.get(matchObjects[6]);
		if(room_6_Matches == null) {
			room_6_Matches = new LinkedList<>();
			roomAttrMap.put(matchObjects[6], room_6_Matches);
		}
		
		room_6_Matches.add(match);
		
		Collection<HMatch> timeslot_1_Matches = timeslotAttrMap.get(matchObjects[1]);
		if(timeslot_1_Matches == null) {
			timeslot_1_Matches = new LinkedList<>();
			timeslotAttrMap.put(matchObjects[1], timeslot_1_Matches);
		}
		
		timeslot_1_Matches.add(match);
		
	}
	
	@Override
	protected void deregisterMatchForAttributeChanges(Set<HMatch> matches, HMatch match) {
		Object[] matchObjects = match.getNodes();
		Collection<HMatch> matches_0 = planningDayAttrMap.get(matchObjects[3]);
		if(matches_0 != null) {
			matches_0.remove(match);
		}
		Collection<HMatch> matches_1 = staffMemberAttrMap.get(matchObjects[5]);
		if(matches_1 != null) {
			matches_1.remove(match);
		}
		Collection<HMatch> matches_2 = appointmentRequestAttrMap.get(matchObjects[2]);
		if(matches_2 != null) {
			matches_2.remove(match);
		}
		Collection<HMatch> matches_3 = roomAttrMap.get(matchObjects[6]);
		if(matches_3 != null) {
			matches_3.remove(match);
		}
		Collection<HMatch> matches_4 = timeslotAttrMap.get(matchObjects[1]);
		if(matches_4 != null) {
			matches_4.remove(match);
		}
	}
	
	@Override
	protected void changeAttribute(AttributeChanged<HMatch> message) {
		for(Port<?> port : ports) {
			message.initialMessage.increment();
			port.forwardMessage(message);
		}
		Object obj = message.node;
		if(obj instanceof audiologymodel.PlanningDay) {
			if(planningDayAttrMap.containsKey(obj)) {
				for(HMatch attr_match : planningDayAttrMap.get(obj)) {
					for(int i=0; i<ports.size(); i++) {
						Port<HMatch> port = ports.get(i);
						HMatch match = attr_match;
												
						if(match.isConstraintSatisfied(i)) {
							if(!constraints.get(i).apply(match, i))
								port.sendRemove(message.initialMessage, match);
						}
						else {
							if(constraints.get(i).apply(match, i))
								port.sendAdd(message.initialMessage, match);
						}
					}
				}
			}
		}
		if(obj instanceof audiologymodel.StaffMember) {
			if(staffMemberAttrMap.containsKey(obj)) {
				for(HMatch attr_match : staffMemberAttrMap.get(obj)) {
					for(int i=0; i<ports.size(); i++) {
						Port<HMatch> port = ports.get(i);
						HMatch match = attr_match;
												
						if(match.isConstraintSatisfied(i)) {
							if(!constraints.get(i).apply(match, i))
								port.sendRemove(message.initialMessage, match);
						}
						else {
							if(constraints.get(i).apply(match, i))
								port.sendAdd(message.initialMessage, match);
						}
					}
				}
			}
		}
		if(obj instanceof audiologymodel.AppointmentRequest) {
			if(appointmentRequestAttrMap.containsKey(obj)) {
				for(HMatch attr_match : appointmentRequestAttrMap.get(obj)) {
					for(int i=0; i<ports.size(); i++) {
						Port<HMatch> port = ports.get(i);
						HMatch match = attr_match;
												
						if(match.isConstraintSatisfied(i)) {
							if(!constraints.get(i).apply(match, i))
								port.sendRemove(message.initialMessage, match);
						}
						else {
							if(constraints.get(i).apply(match, i))
								port.sendAdd(message.initialMessage, match);
						}
					}
				}
			}
		}
		if(obj instanceof audiologymodel.Room) {
			if(roomAttrMap.containsKey(obj)) {
				for(HMatch attr_match : roomAttrMap.get(obj)) {
					for(int i=0; i<ports.size(); i++) {
						Port<HMatch> port = ports.get(i);
						HMatch match = attr_match;
												
						if(match.isConstraintSatisfied(i)) {
							if(!constraints.get(i).apply(match, i))
								port.sendRemove(message.initialMessage, match);
						}
						else {
							if(constraints.get(i).apply(match, i))
								port.sendAdd(message.initialMessage, match);
						}
					}
				}
			}
		}
		if(obj instanceof audiologymodel.Timeslot) {
			if(timeslotAttrMap.containsKey(obj)) {
				for(HMatch attr_match : timeslotAttrMap.get(obj)) {
					for(int i=0; i<ports.size(); i++) {
						Port<HMatch> port = ports.get(i);
						HMatch match = attr_match;
												
						if(match.isConstraintSatisfied(i)) {
							if(!constraints.get(i).apply(match, i))
								port.sendRemove(message.initialMessage, match);
						}
						else {
							if(constraints.get(i).apply(match, i))
								port.sendAdd(message.initialMessage, match);
						}
					}
				}
			}
		}
		
		message.initialMessage.decrement();
	}
	
	public boolean check_constraint_3(HMatch match, int index) {
		audiologymodel.Room room = (audiologymodel.Room) match.getNodes()[6];
		audiologymodel.PlanningDay planningDay = (audiologymodel.PlanningDay) match.getNodes()[3];
		audiologymodel.Timeslot startSlot = (audiologymodel.Timeslot) match.getNodes()[1];
		audiologymodel.AppointmentRequest request = (audiologymodel.AppointmentRequest) match.getNodes()[2];
		audiologymodel.StaffMember staffMember = (audiologymodel.StaffMember) match.getNodes()[5];
		boolean predicate = staffMember.getBand()>=request.getStaffBandRequirement() && staffMember.isArtsFlag()==request.isArtsFlag() && room.getRoomType().ordinal()==request.getRoomRequirement().ordinal() && planningDay.getDayIndex()>=request.getBookFromDayIndex() && startSlot.getStartIndex()>=staffMember.getAvailableFromSlot() && startSlot.getStartIndex()>=room.getAvailableFromSlot() && startSlot.getStartIndex() + request.getDurationSlots() <= staffMember.getAvailableToSlot() && startSlot.getStartIndex() + request.getDurationSlots() <= room.getAvailableToSlot();
		match.setConstraintSatisfied(index, predicate);
		return predicate;
	}
	
}

