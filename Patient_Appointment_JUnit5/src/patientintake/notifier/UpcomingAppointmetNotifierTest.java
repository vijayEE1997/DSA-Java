package patientintake.notifier;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import patientintake.ClinicCalender;
import patientintake.Doctor;
import patientintake.PatientAppointment;

class UpcomingAppointmetNotifierTest {

	private EmailNotifierTestDouble emailDouble;
	
	@BeforeEach
	void init() {
		emailDouble = new EmailNotifierTestDouble();
	}
	
	@Test
	void sendNotificationWithCorrectFormat() {

		ClinicCalender calender = new ClinicCalender(LocalDate.of(2021,4,26));
		calender.addAppointment("Jay","Dhakad","meena","4/27/2021 4:00 pm");
		UpcomingAppointmetNotifier notifier = new UpcomingAppointmetNotifier(calender,emailDouble);
		
		notifier.run();
		
		assertEquals(1,emailDouble.recievedMessages.size());
		EmailNotifierTestDouble.Message expectedMessage = emailDouble.recievedMessages.get(0);
		assertAll(
				()->assertEquals("dhakadjay@gmail.com",expectedMessage.toAddress),
				()->assertEquals("Appointment Reminder",expectedMessage.subject),
				()->assertEquals("You have an appointment tomorrow at 4:00 PM"+" with Dr. Lalita Meena.",expectedMessage.body)
				);
	}

}
