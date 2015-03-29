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
	private List<User> userList = new ArrayList<>();

	public String addNewUser(){
		user = userEJB.add(user);
		userList = getUserList();
		return "userList.xhtml";		
	}
	
	public List<User> getUserList(){
		return userEJB.findAll();
	}
	
	public User getUserByName(String iFirst_name, String iLast_name){
		return userEJB.findByName(iFirst_name, iLast_name);
	}

	public User getUserByEmail(String iEmail){
		return userEJB.findByEmail(iEmail);
	}
	
}
