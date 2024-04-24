package com.mfront.front.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller class for handling login-related requests.
 */
@RestController
public class LoginController {

	
    /**
     * Handles GET requests to the login endpoint.
     * @return ModelAndView containing the view name for the login page.
     */
    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
}
