package patientintake.notifier;

import java.util.ArrayList;

public class EmailNotifierTestDouble implements EmailNotifier{

	ArrayList<Message> recievedMessages = new ArrayList<>();
	
	@Override
	public void sendNotification(String subject, String body, String address) {
		recievedMessages.add(new Message(subject,body,address));
	}
	
	class Message{
		public String toAddress;
		public String subject;
		public String body;
		public Message(String subject, String body, String toAddress) {
			super();
			this.toAddress = toAddress;
			this.subject = subject;
			this.body = body;
		}	
	}
	

}
