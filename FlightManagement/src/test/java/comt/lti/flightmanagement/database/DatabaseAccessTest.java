package comt.lti.flightmanagement.database;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import com.lti.flightmanagement.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DatabaseAccessTest {
	
	@Mock
	Database database;
	
	public Credentials credentials = new Credentials("username","password");
	
	@Test
	public void testUserSuccessfulLogin() {
		when(database.login(credentials)).thenReturn(true);
		Credentials sameCredentials = new Credentials("username","password");
		assertTrue(database.login(sameCredentials));
		
	}
	
	@Test
	public void testUserFailedLogin() {
		when(database.login(credentials)).thenReturn(true);
		Credentials otherCredentials = new Credentials("user","passwod");
		assertNotEquals(credentials.getUsername(),otherCredentials.getUsername());
		assertNotEquals(credentials.getPassword(),otherCredentials.getPassword());
		assertNotEquals(credentials.hashCode(),otherCredentials.hashCode());
		assertFalse(database.login(otherCredentials));
		
	}

}
