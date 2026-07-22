package audiologyoptimiser.hipe.engine.actor;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;

import akka.actor.ActorRef;

import hipe.engine.actor.GenericNotificationActor;
import hipe.engine.util.IncUtil;

public class NotificationActor extends GenericNotificationActor {
	
	public NotificationActor(ActorRef dispatchActor, IncUtil incUtil, boolean cascadingNotifications) {
		super(dispatchActor, incUtil, cascadingNotifications);
	}
	
	@Override
	protected void initializeExploration() {
		explorationConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getPlanningDay(), obj -> {
			Collection<EObject> children = new LinkedList<>();
			return children;
		});
		explorationConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getStaffMember(), obj -> {
			Collection<EObject> children = new LinkedList<>();
			return children;
		});
		explorationConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAppointmentRequest(), obj -> {
			Collection<EObject> children = new LinkedList<>();
			return children;
		});
		explorationConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getRoom(), obj -> {
			Collection<EObject> children = new LinkedList<>();
			return children;
		});
		explorationConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getPlanningWeek(), obj -> {
			Collection<EObject> children = new LinkedList<>();
			return children;
		});
		explorationConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking(), obj -> {
			Collection<EObject> children = new LinkedList<>();
			audiologymodel.AudiologyBooking _audiologybooking = (audiologymodel.AudiologyBooking) obj;
			children.addAll(_audiologybooking.getWaitingList());
			children.addAll(_audiologybooking.getStaff());
			children.addAll(_audiologybooking.getRooms());
			children.addAll(_audiologybooking.getDays());
			children.addAll(_audiologybooking.getTimeslots());
			children.addAll(_audiologybooking.getAppointmentAssignments());
			children.addAll(_audiologybooking.getWeeks());
			return children;
		});
		explorationConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getTimeslot(), obj -> {
			Collection<EObject> children = new LinkedList<>();
			return children;
		});
		explorationConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAppointmentAssignment(), obj -> {
			Collection<EObject> children = new LinkedList<>();
			return children;
		});
	}
}

