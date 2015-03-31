package storekeeper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import storekeeper.ejb.PermissionEJB;
import storekeeper.datamodel.Permission;

@Named("PermissionController")
@RequestScoped
public class PermissionController {

	@EJB
	private PermissionEJB permissionEJB;
	private Permission permission = new Permission();
	private List<Permission> permissionList = new ArrayList<>();

	public String addNewPermission(){
		permission = permissionEJB.add(permission);
		permissionList = getPermissionList();
		return "permissionList.xhtml";		
	}
	
	public List<Permission> getPermissionList(){
		return permissionEJB.findAll();
	}
	
	public Permission getPermissionByName(String iName){
		return permissionEJB.findByName(iName);
	}
}