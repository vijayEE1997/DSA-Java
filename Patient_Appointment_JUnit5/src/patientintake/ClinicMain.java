package patientintake;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClinicMain {
	
	public static ClinicCalender calender;
	
	public static void main(String[] args) throws Throwable {
		
		calender = new ClinicCalender(LocalDate.now());
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to the Patient Intake Computer System! \n\n");
		String lastOption ="";
		while(!lastOption.equalsIgnoreCase("x")) {
			lastOption = displayMenu(s);
		}
		
		System.out.println("\nExiting System...\n");
	}

	private static String displayMenu(Scanner s) throws Throwable{
		
		System.out.println("Please Select an option:");
		System.out.println("1. Enter a Patient Apppointment");
		System.out.println("2. View All Appointments");
		System.out.println("3. View Today's Appointments");
		System.out.println("X. Exit System.");
		System.out.println("Option: ");
		
		String option = s.next();
		
		switch(option) {
		case "1" : performsPatientEntry(s);
					return option;
		case "2" : performAllAppointments(s);
					return option;
		case "3" : performTodayAppointments(s);
					return option;
		default  : System.out.println("Invalid option, please re-enter."); 
					return option;
		}
	}

	private static void performTodayAppointments(Scanner s) {
System.out.println("\n\nToday's Appointments in System");
		
		for(PatientAppointment p: calender.getTodayAppointments()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mm: a");
			String apptTime = p.getAppointmentDateTime().format(formatter);
			System.out.println(String.format("%s: %s, %s\t\tDoctor: %s",apptTime,p.getPatientLastName(),p.getPatientFirstName(),p.getDoctor().getName()));
		}
		
		System.out.println("\nPress any key to continue...");
	}

	private static void performAllAppointments(Scanner s) {
		
		System.out.println("\n\nAll Appointments in System");
		
		for(PatientAppointment p: calender.getAppointments()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mm: a");
			String apptTime = p.getAppointmentDateTime().format(formatter);
			System.out.println(String.format("%s: %s, %s\t\tDoctor: %s",apptTime,p.getPatientLastName(),p.getPatientFirstName(),p.getDoctor().getName()));
		}
		
		System.out.println("\nPress any key to continue...");
	}

	private static void performsPatientEntry(Scanner s) throws Throwable {

		s.nextLine();
		
		System.out.println("\n\nPlease Enter Appointment Info:");
		
		System.out.println("Patient Last Name:");
		String lastName = s.nextLine();
		System.out.println("Patient First Name:");
		String firstName = s.nextLine();
		System.out.println("Appointment Date [M/d/yyyy h:m a]:");
		String when = s.nextLine();
		System.out.println("Doctor's Last Name:");
		String doc = s.nextLine();
		
		try {
			calender.addAppointment(firstName, lastName, doc, when);
		}catch (Throwable e) {
			System.out.println("Erros! "+ e.getMessage());
			return;
		}
		
	}
}
