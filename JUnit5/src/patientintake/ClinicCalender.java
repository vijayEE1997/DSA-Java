package patientintake;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ClinicCalender {
	
	List<PatientAppointment> appointments;
	
	public ClinicCalender() {
		this.appointments = new ArrayList<PatientAppointment>();
	}
	
	public void addAppointment(String patientFirstName,String patientLastName, String doctorKey, String dateTime) {
		
		Doctor doc = Doctor.valueOf(doctorKey.toLowerCase());
		LocalDateTime localDateTime;
		try {
			localDateTime = LocalDateTime.parse(dateTime.toUpperCase(),DateTimeFormatter.ofPattern("M/d/yyyy h:mm a",Locale.US));
		}catch (Throwable e) {
			throw new RuntimeException("Unable to create date time from : ["+dateTime.toUpperCase()+"], please enter with format [M/d/yyyy h:mm a] ");
		}
		PatientAppointment appointment = new PatientAppointment(patientFirstName, patientLastName, localDateTime, doc);
		appointments.add(appointment);
		
	}
	
	public List<PatientAppointment> getAppointments(){
		return this.appointments;
	}

}
