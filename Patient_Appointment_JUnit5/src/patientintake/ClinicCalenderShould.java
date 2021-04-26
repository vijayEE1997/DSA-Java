package patientintake;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClinicCalenderShould {
	
	private static ClinicCalender calender;
	
	@BeforeEach
	public void init() {
		calender = new ClinicCalender(LocalDate.of(2021,4,26));
	}

	@Test
	public void allowEntryOfAnAppointments() {

		calender.addAppointment("Jay","Rajput","dhakad","12/24/2021 4:05 pm");
		List<PatientAppointment> appointments = calender.getAppointments();
		PatientAppointment enteredAppt = appointments.get(0);
		assertNotNull(appointments);
		assertEquals(1,appointments.size());
		assertAll(
				()->assertEquals("Jay",enteredAppt.getPatientFirstName()),
				()->assertEquals("Rajput",enteredAppt.getPatientLastName()),
				()->assertSame(Doctor.dhakad,enteredAppt.getDoctor()),
				()->assertEquals("12/24/2021 4:05 pm",enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy h:mm a")))
		);
		
	}
	
	@Test
	public void hasAppointment() {

		calender.addAppointment("Jay","Rajput","dhakad","4/26/2021 4:05 pm");
		assertTrue(calender.hasAppointments(LocalDate.of(2021,4,26)));
	}
	
	@Test
	public void notHasAppointment() {
		
		assertFalse(calender.hasAppointments(LocalDate.of(2021,12,24)));
	}
	
	@Test
	public void todayAppointmemts() {
		
		calender.addAppointment("Jay","Rajput","dhakad","4/26/2021 4:05 pm");
		calender.addAppointment("Sanjay","Rajput","dhakad","4/26/2021 5:05 pm");
		calender.addAppointment("Jay","Rajput","dhakad","4/28/2021 4:05 pm");
		assertEquals(2,calender.getTodayAppointments().size());
//		assertIterableEquals(calender.getTodayAppointments(),calender.getAppointments());
	}
}
