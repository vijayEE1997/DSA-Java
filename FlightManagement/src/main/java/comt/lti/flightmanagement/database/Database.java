package comt.lti.flightmanagement.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
	
	private Map<String,String> registerUsers = new HashMap<String, String>();
	List<List<String>> queriedData = new ArrayList<>();
	
	public boolean login(Credentials credentials) {
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		
		return registerUsers.keySet().contains(username) && registerUsers.get(username).equals(password);
	}

	public List<List<String>> getQueriedData() {
		return queriedData;
	}
	
}
