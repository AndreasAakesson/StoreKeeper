package storekeeper.datamodel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;
import javax.persistence.*;

@Entity
public class User implements java.io.Serializable {

	private static final long serialVersionUID = -1347163401332203556L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private byte[] password;
	@ManyToOne
	private Role role;
	@OneToMany
	private Set<StoreOrder> orders;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="StoreUser", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="store_id"))
	private Set<Store> stores;
	
	public int getId(){
		return id; 
	}
	
	public void setFirst_name(String iFirst_name){
		first_name = iFirst_name;
	}

	public String getFirst_name(){
		return first_name;
	}

	public void setLast_name(String iLast_name){
		last_name = iLast_name;
	}

	public String getLast_name(){
		return last_name;
	}

	public void setEmail(String iEmail){
		email = iEmail;
	}

	public String getEmail(){
		return email;
	}

	public void setPassword(String iPassword){
		try{
			password = hash(iPassword);
		}
		catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
	}
	
	public byte[] getPassword(){
		return password;
	}

	public void setRole(Role iRole){
		if(iRole != null)
			role.removeUser(this);
		role = iRole;
		if(role != null)
			role.addUser(this);	
	}
	
	public Role getRole(){
		return role;
	}
	
	public void setOrders(Set<StoreOrder> iOrders){
		orders = iOrders;
	}

	public Set<StoreOrder> getOrders() { 
		return orders; 
	}	

	protected void addOrder(StoreOrder iOrder) {
		orders.add(iOrder);
	}
	
	protected void removeOrder(StoreOrder iOrder) {
		orders.remove(iOrder);
	}
		
	public void setStore(Set<Store> iStore){
		stores = iStore;	
	}
	
	public Set<Store> getStore(){
		return stores;
	}

	public static byte[] hash(String password) throws NoSuchAlgorithmException {
	    MessageDigest sha256 = MessageDigest.getInstance("SHA-256");        
	    byte[] passBytes = password.getBytes();
	    byte[] passHash = sha256.digest(passBytes);
	    return passHash;
	}	
}
