package patientintake.notifier;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import patientintake.ClinicCalender;
import patientintake.PatientAppointment;

public class UpcomingAppointmetNotifier {
	
	private ClinicCalender calender;
	private EmailNotifier notifier;

	public UpcomingAppointmetNotifier(ClinicCalender calender,EmailNotifier notifier) {
		this.calender = calender;
		this.notifier = notifier;
	}
	
	public void run() {
		calender.getTomorrowAppointments().forEach(p->{
			sendNotificationAppointment(p);
		});
	}

	private void sendNotificationAppointment(PatientAppointment p) {
		String email = p.getPatientLastName().toLowerCase()+p.getPatientFirstName().toLowerCase()+"@gmail.com";
		System.out.println("Sending with body: " + buildMessageBody(p));
		notifier.sendNotification("Appointment Reminder", buildMessageBody(p), email);
	}

	private String buildMessageBody(PatientAppointment p) {
		return "You have an appointment tomorrow at " 
				+ p.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("h:mm a",Locale.US))
				+ " with Dr. "
				+ p.getDoctor().getName()+ ".";
	}
	
	
}
