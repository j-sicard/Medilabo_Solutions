package servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mpatient.mpatient.entity.UserMO;
import com.mpatient.mpatient.service.UserService;

import jakarta.transaction.Transactional;
import utilstest.AbstractConfigurationTest;

@Transactional
public class UserServiceTest extends AbstractConfigurationTest   {
	
	@Autowired
	UserService userService; 
	
	@Test
	void findByUsernameTest() {
		assertTrue(userService.findByUsername("UserTest").getPassword().equals("UserPassTerst")); 
	}
	
	@Test
	void getUsersTest() {
		assertEquals(4, userService.findUsers().size());  
	}
	
	@Test
	void saveUserTest() {
		assertEquals(4, userService.findUsers().size()); 

		UserMO user = new UserMO(); 
		user.setUserId(4);
		user.setUsername("SavetTestUserName");
		user.setPassword("SavetTestPassword");
		user.setRole("USER");
		
		userService.saveUser(user);
		
		assertEquals(5, userService.findUsers().size()); 
		
		
	}
	

}
