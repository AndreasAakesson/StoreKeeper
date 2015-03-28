package storekeeper.ejb;

import storekeeper.datamodel.Store;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class StoreEJB extends GenericEJB<Store> {

	public StoreEJB(){
		super(Store.class);
	}	
	
	public Store findByName(String name){
		String query = "select s from Store s where s.name = :name";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name); 
		return super.findOneResult(query, parameters);
	}	
}
