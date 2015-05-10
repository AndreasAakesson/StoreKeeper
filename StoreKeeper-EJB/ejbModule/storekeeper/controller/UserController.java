package storekeeper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import storekeeper.datamodel.User;
import storekeeper.ejb.UserEJB;

@Named("UserController")
@RequestScoped
public class UserController {

	@EJB
	private UserEJB userEJB;
	private User user = new User();
	private User exist;
	private List<User> userList = new ArrayList<>();
	
	private String reg_password;
	private String confirmation_password;
	private String message;

	public String addNewUser(){		
		exist = userEJB.add(user);
		if(exist != null)
			return "success";
		else
			return "failed";
	}
	
	public List<User> getUserList(){
		return userEJB.findAll();
	}
	
	public String register()
	{
		if(!reg_password.equals(confirmation_password))
			return "failed";
		
		exist = userEJB.findByEmail(user.getEmail());
		if(exist != null){
			message = "This email is already registered!";
			return "failed";					
		}		
		user.setPassword(reg_password);
		return addNewUser();
	}
	
	public User getUserByName(String iFirst_name, String iLast_name){
		return userEJB.findByName(iFirst_name, iLast_name);
	}

	public User getUserByEmail(String iEmail){
		return userEJB.findByEmail(iEmail);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getReg_password() {
		return reg_password;
	}

	public void setReg_password(String reg_password) {
		this.reg_password = reg_password;
	}

	public String getConfirmation_password() {
		return confirmation_password;
	}

	public void setConfirmation_password(String confirmation_password) {
		this.confirmation_password = confirmation_password;
	}

	public String getMessaage() {
		return message;
	}		
	
}
