 package com.mfront.front.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mfront.front.beans.UserBean;
import com.mfront.front.proxies.Microservicesproxy;

/**
 * Custom user details service for Spring Security authentication.
 */
@Service
public class CustomUserDetailsService  implements UserDetailsService {

	   @Autowired
	    private Microservicesproxy microservicesproxy;

	   /**
	     * Load user details by username.
	     * @param username the username of the user to load
	     * @return UserDetails object representing the user
	     * @throws UsernameNotFoundException if the user is not found
	     */
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	      
	        UserBean user = microservicesproxy.getuser(username);
	        System.out.println("Loaded user: " + user.getUsername());
	     
	        return new User(user.getUsername(),
	                user.getPassword(), getGrantedAuthorities(user.getRole()));
	    }


	    /**
	     * Get the granted authorities for a user based on their role.
	     * @param role the role of the user
	     * @return list of granted authorities
	     */
	    private List<GrantedAuthority> getGrantedAuthorities(String role) {
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	   
	        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
	        return authorities;
	    }

	} 
