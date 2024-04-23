package com.mfront.front.configuration;

/*
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.mfront.front.beans.UserBean;
import com.mfront.front.proxies.Microservicesproxy;

import jakarta.annotation.PostConstruct;

@Component
public class EncryptPasswordsComponent {

	@Autowired
	private Microservicesproxy microservicesproxy;

	private static final Logger logger = Logger.getLogger(EncryptPasswordsComponent.class.getName());
	
	  @PostConstruct
	    public void encryptPasswordsOnStartup() {
	        encryptPasswordsInDatabase();
	    }

	public void encryptPasswordsInDatabase() {
		List<UserBean> users = microservicesproxy.getUsers();

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		for (UserBean user : users) {
			if (!isPasswordEncrypted(user.getPassword())) {
				String encryptedPassword = encoder.encode(user.getPassword());
				user.setPassword(encryptedPassword);
				microservicesproxy.saveUser(user);
				logger.info("Password for user " + user.getUsername() + " encrypted and updated in the database.");
			}
		}

		logger.info("Password encryption process completed.");
	}

	private boolean isPasswordEncrypted(String password) {
		return password.startsWith("$2a$");
	}
}
*/
