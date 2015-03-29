package storekeeper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import storekeeper.ejb.RoleEJB;
import storekeeper.datamodel.Role;

@Named("RoleController")
@RequestScoped
public class RoleController {

	@EJB
	private RoleEJB roleEJB;
	private Role role = new Role();
	private List<Role> roleList = new ArrayList<>();

	public String addNewRole(){
		role = roleEJB.add(role);
		roleList = getRoleList();
		return "roleList.xhtml";		
	}
	
	public List<Role> getRoleList(){
		return roleEJB.findAll();
	}
	
	public Role getRoleByName(String iName){
		return roleEJB.findByName(iName);
	}
}