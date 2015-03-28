package storekeeper.ejb;

import storekeeper.datamodel.Product;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class ProductEJB extends GenericEJB<Product> {

	public ProductEJB(){
		super(Product.class);
	}	
	
	public Product findByName(String name){
		String query = "select p from Product p where p.name = :name";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name); 
		return super.findOneResult(query, parameters);
	}	
}
