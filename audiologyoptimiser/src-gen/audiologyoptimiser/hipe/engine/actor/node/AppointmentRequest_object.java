package audiologyoptimiser.hipe.engine.actor.node;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import akka.actor.ActorRef;

import hipe.engine.actor.Port;
import hipe.engine.actor.node.PortNode;
import hipe.engine.actor.node.PortNodeLeft;
import hipe.engine.actor.node.PortNodeRight;
import hipe.engine.actor.node.PortNodeMatch;
import hipe.engine.actor.node.PortNodeMatchLeft;
import hipe.engine.actor.node.PortNodeMatchRight;

import hipe.network.ObjectNode;

import hipe.generic.actor.GenericObjectActor;

import hipe.generic.actor.junction.util.HiPEConfig;
		
public class AppointmentRequest_object extends GenericObjectActor<audiologymodel.AppointmentRequest> {
	
	@Override
	protected void initializePorts(Map<String, ActorRef> name2actor, ObjectNode node) {
		ports = new LinkedList<>();
		ports.add(new PortNodeRight<audiologymodel.AppointmentRequest>(node.getPorts().getPort().get(0), getSelf(), name2actor.get("AudiologyBooking_waitingList_0_reference"), this::check_constraint_1 , 0   ));
		ports.add(new PortNodeRight<audiologymodel.AppointmentRequest>(node.getPorts().getPort().get(1), getSelf(), name2actor.get("AudiologyBooking_waitingList_1_reference"), this::returnTrue   ));
	}
	
	public boolean check_constraint_1(audiologymodel.AppointmentRequest request, int index) {
		return request.getDurationSlots()>0;
	}
	
}


