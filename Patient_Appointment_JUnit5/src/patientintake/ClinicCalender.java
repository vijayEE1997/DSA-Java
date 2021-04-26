package patientintake;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ClinicCalender {
	
	private List<PatientAppointment> appointments;
	private LocalDate today;
	
	public ClinicCalender(LocalDate today) {
		this.today=today;
		this.appointments = new ArrayList<PatientAppointment>();
	}
	
	public void addAppointment(String patientFirstName,String patientLastName, String doctorKey, String dateTime) {
		
		Doctor doc = Doctor.valueOf(doctorKey.toLowerCase());
		LocalDateTime localDateTime = convertToDateTimeFromString(dateTime);		
		PatientAppointment appointment = new PatientAppointment(patientFirstName, patientLastName, localDateTime, doc);
		appointments.add(appointment);
		
	}

	private LocalDateTime convertToDateTimeFromString(String dateTime) {
		LocalDateTime localDateTime;
		try {
			if(dateTime.toLowerCase().startsWith("today")) {
				String[] parts = dateTime.split("",2);
				LocalTime time = LocalTime.parse(parts[1].toUpperCase(),DateTimeFormatter.ofPattern("h:mm a",Locale.US));
				localDateTime = LocalDateTime.of(today,time);
			}
			else {
				localDateTime = LocalDateTime.parse(dateTime.toUpperCase(),DateTimeFormatter.ofPattern("M/d/yyyy h:mm a",Locale.US));
			}
		}catch (Throwable e) {
			throw new RuntimeException("Unable to create date time from : ["+dateTime.toUpperCase()+"], please enter with format [M/d/yyyy h:mm a] ");
		}
		return localDateTime;
	}
	
	public List<PatientAppointment> getAppointments(){
		return this.appointments;
	}
	
	public List<PatientAppointment> getTodayAppointments(){
		return this.appointments.stream()
			.filter(app->app.getAppointmentDateTime().toLocalDate().equals(today))
			.collect(Collectors.toList());
	}

	public boolean hasAppointments(LocalDate date) {
		return this.appointments.stream()
				.anyMatch(app->app.getAppointmentDateTime().toLocalDate().equals(today));
	}

}
