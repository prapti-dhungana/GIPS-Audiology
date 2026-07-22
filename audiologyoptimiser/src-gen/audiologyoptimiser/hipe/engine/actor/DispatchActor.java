package audiologyoptimiser.hipe.engine.actor;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EObject;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.*;
import static akka.pattern.Patterns.ask;

import hipe.engine.util.HiPEMultiUtil;
import hipe.engine.util.IncUtil;
import hipe.engine.message.NewInput;
import hipe.engine.message.NoMoreInput;
import hipe.engine.message.input.ObjectAdded;
import hipe.engine.message.input.ObjectDeleted;
import hipe.engine.message.input.ReferenceAdded;
import hipe.engine.message.input.ReferenceDeleted;		
import hipe.engine.message.input.AttributeChanged;
import hipe.engine.message.input.NotificationContainer;

import hipe.generic.actor.junction.util.HiPEConfig;

public class DispatchActor extends AbstractActor {
	
	private int counter = 0;
	public long time = 0;
				
	private Map<String, ActorRef> name2actor;
	
	private Map<Object, Consumer<Object>> type2addConsumer = HiPEMultiUtil.createMap();
	private Map<Object, Consumer<Notification>> feature2setConsumer = HiPEMultiUtil.createMap();
	private Map<Object, Consumer<Notification>> feature2addEdgeConsumer = HiPEMultiUtil.createMap();
	private Map<Object, Consumer<Notification>> feature2removeEdgeConsumer = HiPEMultiUtil.createMap();
	
	private IncUtil incUtil;
	
	private ActorMaterializer materializer;
	
	public DispatchActor(Map<String, ActorRef> name2actor, IncUtil incUtil) {
		this.name2actor = name2actor;
		this.incUtil = incUtil;
		
		initializeAdd();
		initializeSet();
		initializeAddEdge();
		initializeRemoveEdge();
	
		materializer = ActorMaterializer.create(getContext());
	}
	
	private void initializeAdd() {
		type2addConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getPlanningDay(), obj -> {
			audiologymodel.PlanningDay _planningday = (audiologymodel.PlanningDay) obj;
			incUtil.newMessage();
			name2actor.get("PlanningDay_object").tell(new ObjectAdded<audiologymodel.PlanningDay>(incUtil, _planningday), getSelf());
		});
		type2addConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getStaffMember(), obj -> {
			audiologymodel.StaffMember _staffmember = (audiologymodel.StaffMember) obj;
			incUtil.newMessage();
			name2actor.get("StaffMember_object").tell(new ObjectAdded<audiologymodel.StaffMember>(incUtil, _staffmember), getSelf());
		});
		type2addConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAppointmentRequest(), obj -> {
			audiologymodel.AppointmentRequest _appointmentrequest = (audiologymodel.AppointmentRequest) obj;
			incUtil.newMessage();
			name2actor.get("AppointmentRequest_object").tell(new ObjectAdded<audiologymodel.AppointmentRequest>(incUtil, _appointmentrequest), getSelf());
		});
		type2addConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getRoom(), obj -> {
			audiologymodel.Room _room = (audiologymodel.Room) obj;
			incUtil.newMessage();
			name2actor.get("Room_object").tell(new ObjectAdded<audiologymodel.Room>(incUtil, _room), getSelf());
		});
		type2addConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getPlanningWeek(), obj -> {
			audiologymodel.PlanningWeek _planningweek = (audiologymodel.PlanningWeek) obj;
			incUtil.newMessage();
			name2actor.get("PlanningWeek_object").tell(new ObjectAdded<audiologymodel.PlanningWeek>(incUtil, _planningweek), getSelf());
		});
		type2addConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking(), obj -> {
			audiologymodel.AudiologyBooking _audiologybooking = (audiologymodel.AudiologyBooking) obj;
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_object_SP0").tell(new ObjectAdded<audiologymodel.AudiologyBooking>(incUtil, _audiologybooking), getSelf());
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_object_SP1").tell(new ObjectAdded<audiologymodel.AudiologyBooking>(incUtil, _audiologybooking), getSelf());
		});
		type2addConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getTimeslot(), obj -> {
			audiologymodel.Timeslot _timeslot = (audiologymodel.Timeslot) obj;
			incUtil.newMessage();
			name2actor.get("Timeslot_object").tell(new ObjectAdded<audiologymodel.Timeslot>(incUtil, _timeslot), getSelf());
		});
	}
	
	private void initializeSet() {
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getPlanningDay_DayIndex(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.PlanningDay) {
				incUtil.newMessage();
				name2actor.get("PlanningDay_object").tell(new AttributeChanged<audiologymodel.PlanningDay>(incUtil, (audiologymodel.PlanningDay) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getRoom_AvailableToSlot(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.Room) {
				incUtil.newMessage();
				name2actor.get("Room_object").tell(new AttributeChanged<audiologymodel.Room>(incUtil, (audiologymodel.Room) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAppointmentRequest_StaffBandRequirement(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.AppointmentRequest) {
				incUtil.newMessage();
				name2actor.get("AppointmentRequest_object").tell(new AttributeChanged<audiologymodel.AppointmentRequest>(incUtil, (audiologymodel.AppointmentRequest) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getRoom_AvailableFromSlot(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.Room) {
				incUtil.newMessage();
				name2actor.get("Room_object").tell(new AttributeChanged<audiologymodel.Room>(incUtil, (audiologymodel.Room) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAppointmentRequest_DurationSlots(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.AppointmentRequest) {
				incUtil.newMessage();
				name2actor.get("AppointmentRequest_object").tell(new AttributeChanged<audiologymodel.AppointmentRequest>(incUtil, (audiologymodel.AppointmentRequest) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getStaffMember_ArtsFlag(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.StaffMember) {
				incUtil.newMessage();
				name2actor.get("StaffMember_object").tell(new AttributeChanged<audiologymodel.StaffMember>(incUtil, (audiologymodel.StaffMember) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getStaffMember_Band(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.StaffMember) {
				incUtil.newMessage();
				name2actor.get("StaffMember_object").tell(new AttributeChanged<audiologymodel.StaffMember>(incUtil, (audiologymodel.StaffMember) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getStaffMember_AvailableToSlot(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.StaffMember) {
				incUtil.newMessage();
				name2actor.get("StaffMember_object").tell(new AttributeChanged<audiologymodel.StaffMember>(incUtil, (audiologymodel.StaffMember) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getRoom_RoomType(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.Room) {
				incUtil.newMessage();
				name2actor.get("Room_object").tell(new AttributeChanged<audiologymodel.Room>(incUtil, (audiologymodel.Room) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getStaffMember_AvailableFromSlot(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.StaffMember) {
				incUtil.newMessage();
				name2actor.get("StaffMember_object").tell(new AttributeChanged<audiologymodel.StaffMember>(incUtil, (audiologymodel.StaffMember) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAppointmentRequest_ArtsFlag(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.AppointmentRequest) {
				incUtil.newMessage();
				name2actor.get("AppointmentRequest_object").tell(new AttributeChanged<audiologymodel.AppointmentRequest>(incUtil, (audiologymodel.AppointmentRequest) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAppointmentRequest_BookFromDayIndex(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.AppointmentRequest) {
				incUtil.newMessage();
				name2actor.get("AppointmentRequest_object").tell(new AttributeChanged<audiologymodel.AppointmentRequest>(incUtil, (audiologymodel.AppointmentRequest) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getTimeslot_StartIndex(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.Timeslot) {
				incUtil.newMessage();
				name2actor.get("Timeslot_object").tell(new AttributeChanged<audiologymodel.Timeslot>(incUtil, (audiologymodel.Timeslot) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
		feature2setConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAppointmentRequest_RoomRequirement(), notification -> {
			if(notification.getNotifier() instanceof audiologymodel.AppointmentRequest) {
				incUtil.newMessage();
				name2actor.get("AppointmentRequest_object").tell(new AttributeChanged<audiologymodel.AppointmentRequest>(incUtil, (audiologymodel.AppointmentRequest) notification.getNotifier(), notification.getOldValue()), getSelf());
			}
		});
		
	}
	
	private void initializeAddEdge() {
		feature2addEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking_WaitingList(), notification -> {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_waitingList_0_reference").tell(new ReferenceAdded<audiologymodel.AudiologyBooking, audiologymodel.AppointmentRequest>(incUtil,(audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.AppointmentRequest) notification.getNewValue(), "audiologymodel.AudiologyBooking_waitingList_AppointmentRequest"), getSelf());
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_waitingList_1_reference").tell(new ReferenceAdded<audiologymodel.AudiologyBooking, audiologymodel.AppointmentRequest>(incUtil,(audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.AppointmentRequest) notification.getNewValue(), "audiologymodel.AudiologyBooking_waitingList_AppointmentRequest"), getSelf());
		});
		feature2addEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getRoom_OpenDays(), notification -> {
			incUtil.newMessage();
			name2actor.get("Room_openDays_0_reference").tell(new ReferenceAdded<audiologymodel.Room, audiologymodel.PlanningDay>(incUtil,(audiologymodel.Room) notification.getNotifier(), (audiologymodel.PlanningDay) notification.getNewValue(), "audiologymodel.Room_openDays_PlanningDay"), getSelf());
		});
		feature2addEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking_Staff(), notification -> {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_staff_0_reference").tell(new ReferenceAdded<audiologymodel.AudiologyBooking, audiologymodel.StaffMember>(incUtil,(audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.StaffMember) notification.getNewValue(), "audiologymodel.AudiologyBooking_staff_StaffMember"), getSelf());
		});
		feature2addEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking_Timeslots(), notification -> {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_timeslots_0_reference").tell(new ReferenceAdded<audiologymodel.AudiologyBooking, audiologymodel.Timeslot>(incUtil,(audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.Timeslot) notification.getNewValue(), "audiologymodel.AudiologyBooking_timeslots_Timeslot"), getSelf());
		});
		feature2addEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getPlanningDay_Week(), notification -> {
			incUtil.newMessage();
			name2actor.get("PlanningDay_week_0_reference").tell(new ReferenceAdded<audiologymodel.PlanningDay, audiologymodel.PlanningWeek>(incUtil,(audiologymodel.PlanningDay) notification.getNotifier(), (audiologymodel.PlanningWeek) notification.getNewValue(), "audiologymodel.PlanningDay_week_PlanningWeek"), getSelf());
		});
		feature2addEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking_Days(), notification -> {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_days_0_reference").tell(new ReferenceAdded<audiologymodel.AudiologyBooking, audiologymodel.PlanningDay>(incUtil,(audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.PlanningDay) notification.getNewValue(), "audiologymodel.AudiologyBooking_days_PlanningDay"), getSelf());
		});
		feature2addEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking_Rooms(), notification -> {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_rooms_0_reference").tell(new ReferenceAdded<audiologymodel.AudiologyBooking, audiologymodel.Room>(incUtil,(audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.Room) notification.getNewValue(), "audiologymodel.AudiologyBooking_rooms_Room"), getSelf());
		});
		feature2addEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getStaffMember_WorkingDays(), notification -> {
			incUtil.newMessage();
			name2actor.get("StaffMember_workingDays_0_reference").tell(new ReferenceAdded<audiologymodel.StaffMember, audiologymodel.PlanningDay>(incUtil,(audiologymodel.StaffMember) notification.getNotifier(), (audiologymodel.PlanningDay) notification.getNewValue(), "audiologymodel.StaffMember_workingDays_PlanningDay"), getSelf());
		});
		feature2addEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking_Weeks(), notification -> {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_weeks_0_reference").tell(new ReferenceAdded<audiologymodel.AudiologyBooking, audiologymodel.PlanningWeek>(incUtil,(audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.PlanningWeek) notification.getNewValue(), "audiologymodel.AudiologyBooking_weeks_PlanningWeek"), getSelf());
		});
	}
	
	private void initializeRemoveEdge() {
		feature2removeEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking_WaitingList(), notification -> {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_waitingList_0_reference").tell(new ReferenceDeleted<audiologymodel.AudiologyBooking, audiologymodel.AppointmentRequest>(incUtil, (audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.AppointmentRequest) notification.getOldValue(), "audiologymodel.AudiologyBooking_waitingList_AppointmentRequest"), getSelf());
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_waitingList_1_reference").tell(new ReferenceDeleted<audiologymodel.AudiologyBooking, audiologymodel.AppointmentRequest>(incUtil, (audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.AppointmentRequest) notification.getOldValue(), "audiologymodel.AudiologyBooking_waitingList_AppointmentRequest"), getSelf());
		});
		feature2removeEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getRoom_OpenDays(), notification -> {
			incUtil.newMessage();
			name2actor.get("Room_openDays_0_reference").tell(new ReferenceDeleted<audiologymodel.Room, audiologymodel.PlanningDay>(incUtil, (audiologymodel.Room) notification.getNotifier(), (audiologymodel.PlanningDay) notification.getOldValue(), "audiologymodel.Room_openDays_PlanningDay"), getSelf());
		});
		feature2removeEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking_Staff(), notification -> {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_staff_0_reference").tell(new ReferenceDeleted<audiologymodel.AudiologyBooking, audiologymodel.StaffMember>(incUtil, (audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.StaffMember) notification.getOldValue(), "audiologymodel.AudiologyBooking_staff_StaffMember"), getSelf());
		});
		feature2removeEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking_Timeslots(), notification -> {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_timeslots_0_reference").tell(new ReferenceDeleted<audiologymodel.AudiologyBooking, audiologymodel.Timeslot>(incUtil, (audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.Timeslot) notification.getOldValue(), "audiologymodel.AudiologyBooking_timeslots_Timeslot"), getSelf());
		});
		feature2removeEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getPlanningDay_Week(), notification -> {
			incUtil.newMessage();
			name2actor.get("PlanningDay_week_0_reference").tell(new ReferenceDeleted<audiologymodel.PlanningDay, audiologymodel.PlanningWeek>(incUtil, (audiologymodel.PlanningDay) notification.getNotifier(), (audiologymodel.PlanningWeek) notification.getOldValue(), "audiologymodel.PlanningDay_week_PlanningWeek"), getSelf());
		});
		feature2removeEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking_Days(), notification -> {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_days_0_reference").tell(new ReferenceDeleted<audiologymodel.AudiologyBooking, audiologymodel.PlanningDay>(incUtil, (audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.PlanningDay) notification.getOldValue(), "audiologymodel.AudiologyBooking_days_PlanningDay"), getSelf());
		});
		feature2removeEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking_Rooms(), notification -> {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_rooms_0_reference").tell(new ReferenceDeleted<audiologymodel.AudiologyBooking, audiologymodel.Room>(incUtil, (audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.Room) notification.getOldValue(), "audiologymodel.AudiologyBooking_rooms_Room"), getSelf());
		});
		feature2removeEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getStaffMember_WorkingDays(), notification -> {
			incUtil.newMessage();
			name2actor.get("StaffMember_workingDays_0_reference").tell(new ReferenceDeleted<audiologymodel.StaffMember, audiologymodel.PlanningDay>(incUtil, (audiologymodel.StaffMember) notification.getNotifier(), (audiologymodel.PlanningDay) notification.getOldValue(), "audiologymodel.StaffMember_workingDays_PlanningDay"), getSelf());
		});
		feature2removeEdgeConsumer.put(audiologymodel.AudiologymodelPackage.eINSTANCE.getAudiologyBooking_Weeks(), notification -> {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_weeks_0_reference").tell(new ReferenceDeleted<audiologymodel.AudiologyBooking, audiologymodel.PlanningWeek>(incUtil, (audiologymodel.AudiologyBooking) notification.getNotifier(), (audiologymodel.PlanningWeek) notification.getOldValue(), "audiologymodel.AudiologyBooking_weeks_PlanningWeek"), getSelf());
		});
	}

	@Override
	public void preStart() throws Exception {
		super.preStart();
	}

	@Override
	public void postStop() throws Exception {
		if(HiPEConfig.logWorkloadActivated) {
			DecimalFormat df = new DecimalFormat("0.#####");
	        df.setMaximumFractionDigits(5);
			System.err.println("DispatchNode" + ";"  + counter + ";" + df.format((double) time / (double) (1000 * 1000 * 1000)));
		}
	}

	@Override
	public Receive createReceive() {
		return receiveBuilder() //
				.match(NotificationContainer.class, this::handleNotificationContainer)
				.match(NoMoreInput.class, this::sendFinished) //
				.build();
	}

	private void sendFinished(NoMoreInput m) {
		incUtil.allMessagesInserted();
	}
	
	private void handleNotificationContainer(NotificationContainer nc) {
		counter++;
		long tic = System.nanoTime();
		nc.notifications.parallelStream().forEach(this::handleNotification);
		time += System.nanoTime() - tic;
	}
	
	private void handleNotification(Notification notification) {
		switch (notification.getEventType()) {
		case Notification.ADD:
			handleAdd(notification);
			break;
		case Notification.REMOVE:
			handleRemove(notification);
			break;
		case Notification.REMOVING_ADAPTER:
			handleRemoveAdapter(notification);
			break;	
		case Notification.SET:
			handleSet(notification);
			break;
		}
	}

	private void handleAdd(Notification notification) {
		if(notification.getFeature() == null) 
			handleAddedNode(notification.getNewValue());
		else
			handleAddedEdge(notification);
	}

	private void handleAddedNode(Object node) {
		if(node == null) 
			return;
			
		EObject obj = (EObject) node;
		if(type2addConsumer.containsKey(obj.eClass())) {
			type2addConsumer.get(obj.eClass()).accept(node);
		}
	}
	
	private void handleSet(Notification notification) {
		Object feature = notification.getFeature();
		if(feature2setConsumer.containsKey(feature)) {
			feature2setConsumer.get(feature).accept(notification);
		}
	}

	private void handleAddedEdge(Notification notification) {
		//check for self-edges
		if(notification.getNotifier().equals(notification.getNewValue()))
			handleAddedNode(notification.getNewValue());
					
		Object feature = notification.getFeature();
		if(feature2addEdgeConsumer.containsKey(feature)) {
			feature2addEdgeConsumer.get(feature).accept(notification);
		}
	}

	private void handleRemove(Notification notification) {
		Object feature = notification.getFeature();
		if(feature2removeEdgeConsumer.containsKey(feature)) {
			feature2removeEdgeConsumer.get(feature).accept(notification);
		}
	}
	
	private void handleRemoveAdapter(Notification notification) {
		Object node = notification.getNotifier();
		if (node instanceof audiologymodel.Timeslot) {
			incUtil.newMessage();
			name2actor.get("Timeslot_object").tell(new ObjectDeleted<audiologymodel.Timeslot>(incUtil, (audiologymodel.Timeslot) node), getSelf());
		}
		if (node instanceof audiologymodel.AppointmentRequest) {
			incUtil.newMessage();
			name2actor.get("AppointmentRequest_object").tell(new ObjectDeleted<audiologymodel.AppointmentRequest>(incUtil, (audiologymodel.AppointmentRequest) node), getSelf());
		}
		if (node instanceof audiologymodel.PlanningDay) {
			incUtil.newMessage();
			name2actor.get("PlanningDay_object").tell(new ObjectDeleted<audiologymodel.PlanningDay>(incUtil, (audiologymodel.PlanningDay) node), getSelf());
		}
		if (node instanceof audiologymodel.PlanningWeek) {
			incUtil.newMessage();
			name2actor.get("PlanningWeek_object").tell(new ObjectDeleted<audiologymodel.PlanningWeek>(incUtil, (audiologymodel.PlanningWeek) node), getSelf());
		}
		if (node instanceof audiologymodel.StaffMember) {
			incUtil.newMessage();
			name2actor.get("StaffMember_object").tell(new ObjectDeleted<audiologymodel.StaffMember>(incUtil, (audiologymodel.StaffMember) node), getSelf());
		}
		if (node instanceof audiologymodel.Room) {
			incUtil.newMessage();
			name2actor.get("Room_object").tell(new ObjectDeleted<audiologymodel.Room>(incUtil, (audiologymodel.Room) node), getSelf());
		}
		if (node instanceof audiologymodel.AudiologyBooking) {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_object_SP0").tell(new ObjectDeleted<audiologymodel.AudiologyBooking>(incUtil, (audiologymodel.AudiologyBooking) node), getSelf());
		}
		if (node instanceof audiologymodel.AudiologyBooking) {
			incUtil.newMessage();
			name2actor.get("AudiologyBooking_object_SP1").tell(new ObjectDeleted<audiologymodel.AudiologyBooking>(incUtil, (audiologymodel.AudiologyBooking) node), getSelf());
		}
	}
}

