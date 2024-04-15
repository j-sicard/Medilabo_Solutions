package Businesstest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mpatient.mpatient.business.UserBusiness;
import com.mpatient.mpatient.entity.UserMO;

import jakarta.transaction.Transactional;
import utilstest.AbstractConfigurationTest;

@Transactional
public class UserBusinessTest  extends AbstractConfigurationTest{
	
	@Autowired
	UserBusiness userBusiness; 
	
	@Test
	void getUserTest() {
		assertTrue(userBusiness.getUser("UserTest").getPassword().equals("UserPassTerst"));
	}
	
	@Test
	void getUsersTest() {
		assertEquals(4, userBusiness.getUsers().size()); 
	}

}
