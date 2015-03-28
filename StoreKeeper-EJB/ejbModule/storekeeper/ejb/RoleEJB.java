package storekeeper.ejb;

import storekeeper.datamodel.Role;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class RoleEJB extends GenericEJB<Role> {

	public RoleEJB(){
		super(Role.class);
	}	
	
	public Role findByName(String name){
		String query = "select r from Role r where r.name = :name";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name); 
		return super.findOneResult(query, parameters);
	}	
}	
