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

public class assignAppointment_2_junction extends GenericJunctionActor{
	private Map<Object, Collection<HMatch>> appointmentRequestAttrMap = HiPEMultiUtil.createMap();
	private Map<Object, Collection<HMatch>> timeslotAttrMap = HiPEMultiUtil.createMap();
	
	@Override
	protected void initializePorts(Map<String, ActorRef> name2actor, JunctionNode node) {
		constraints.add(this::check_constraint_2);
		
		ports = new LinkedList<>();
		ports.add(new PortJunctionLeft(node.getPorts().getPort().get(0), getSelf(), name2actor.get("assignAppointment_1_junction"), this::returnTrue , 0  , false ));
	}
	
	@Override
	protected void registerMatchForAttributeChanges(HMatch match) {
		Object[] matchObjects = match.getNodes();
		Collection<HMatch> appointmentRequest_2_Matches = appointmentRequestAttrMap.get(matchObjects[2]);
		if(appointmentRequest_2_Matches == null) {
			appointmentRequest_2_Matches = new LinkedList<>();
			appointmentRequestAttrMap.put(matchObjects[2], appointmentRequest_2_Matches);
		}
		
		appointmentRequest_2_Matches.add(match);
		
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
		Collection<HMatch> matches_0 = appointmentRequestAttrMap.get(matchObjects[2]);
		if(matches_0 != null) {
			matches_0.remove(match);
		}
		Collection<HMatch> matches_1 = timeslotAttrMap.get(matchObjects[1]);
		if(matches_1 != null) {
			matches_1.remove(match);
		}
	}
	
	@Override
	protected void changeAttribute(AttributeChanged<HMatch> message) {
		for(Port<?> port : ports) {
			message.initialMessage.increment();
			port.forwardMessage(message);
		}
		Object obj = message.node;
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
	
	public boolean check_constraint_2(HMatch match, int index) {
		audiologymodel.Timeslot startSlot = (audiologymodel.Timeslot) match.getNodes()[1];
		audiologymodel.AppointmentRequest request = (audiologymodel.AppointmentRequest) match.getNodes()[2];
		boolean predicate = startSlot.getStartIndex() + request.getDurationSlots() <= 32.0;
		match.setConstraintSatisfied(index, predicate);
		return predicate;
	}
	
}

