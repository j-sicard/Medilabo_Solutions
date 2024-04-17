package com.mfront.front.beans;

import jakarta.validation.constraints.NotBlank;

public class UserBean {
  
    private Integer userId;
   
    @NotBlank(message = "Username is mandatory")
    private String username;  
    
    @NotBlank(message = "Password is mandatory")
    private String password;
    
    @NotBlank(message = "Role is mandatory")
    private String role;
    
       

    public UserBean(Integer userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;        
        this.role = role;
    }

	public UserBean() {	
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
				+ "]";
	}

    
}
