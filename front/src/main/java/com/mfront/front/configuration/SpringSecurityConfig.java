package com.mfront.front.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring Security.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	/**
	 * Configures the security filter chain.
	 * 
	 * @param http the HttpSecurity object to configure
	 * @return the configured SecurityFilterChain
	 * @throws Exception if an error occurs during configuration
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests((requests) -> requests.requestMatchers("/comment/add/data").permitAll()
						.requestMatchers("/patient/**", "/comment/**", "/curvePoint/**").hasAnyRole("USER", "ADMIN")

						.anyRequest().authenticated())

				.formLogin((form) -> form.permitAll())

				.logout((logout) -> logout.permitAll());

		return http.build();
	}

	/**
	 * Configures the authentication manager.
	 * 
	 * @param http the HttpSecurity object
	 * @param bCryptPasswordEncoder the BCryptPasswordEncoder bean
	 * @return the configured AuthenticationManager
	 * @throws Exception if an error occurs during configuration
	 */
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder)
			throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(customUserDetailsService)
				.passwordEncoder(bCryptPasswordEncoder);
		return authenticationManagerBuilder.build();
	}

	/**
	 * Creates a BCryptPasswordEncoder bean.
	 * 
	 * @return the BCryptPasswordEncoder bean
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

}
