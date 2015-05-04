package storekeeper.ejb;

import storekeeper.datamodel.User;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class UserEJB extends GenericEJB<User> {

	public UserEJB(){
		super(User.class);
	}	
	
	public User findByName(String first_name, String last_name){
		String query = "select u from User u where u.first_name = :fname and u.last_name = :lname";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fname", first_name);
		parameters.put("lname", last_name);
		return super.findOneResult(query, parameters);
	}	

	public User findByEmail(String email){
		String query = "select u from User u where u.email = :email";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		return super.findOneResult(query, parameters);
	}
	
	public User login(String email, String password)
	{
		User user = null;
		byte[] hashed_password;
		try {
			hashed_password = User.hash(password);
			
			String query = "select u from User u where u.email = :email and u.password = :password";
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("email", email);
			parameters.put("password", hashed_password);
			user = super.findOneResult(query, parameters);
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return user;
	}
	
}
