package storekeeper.ejb;

import storekeeper.datamodel.Permission;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class PermissionEJB extends GenericEJB<Permission> {

	public PermissionEJB(){
		super(Permission.class);
	}	
	
	public Permission findByName(String name){
		String query = "select p from Permission p where p.name = :name";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name); 
		return super.findOneResult(query, parameters);
	}	
}
