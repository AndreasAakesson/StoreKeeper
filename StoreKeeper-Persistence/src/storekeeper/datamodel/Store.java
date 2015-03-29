package storekeeper.datamodel;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Store implements java.io.Serializable {

	private static final long serialVersionUID = 6611302239372639844L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="store_id")
	private int id;
	private String name;
	private String address;
	private String phone;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
	private Set<StoreOrder> orders;	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "stores")
	private Set<User> users;
	@OneToMany
	private Set<Inventory> inventories;
	
	public int getId(){
		return id; 
	}
	
	public void setName(String iName){
		name = iName;
	}

	public String getName(){
		return name;
	}

	public void setAddress(String iAddress){
		address = iAddress;
	}

	public String getAddress(){
		return address;
	}

	public void setPhone(String iPhone){
		phone = iPhone;
	}

	public String getPhone(){
		return phone;
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
	
	public void setUsers(Set<User> iUsers){
		users = iUsers;
	}

	public Set<User> getUsers() { 
		return users; 
	}

	public void setInventory(Set<Inventory> iInventories){
		inventories = iInventories;
	}
	
	public Set<Inventory> getInventory(){
		return inventories;
	}

	protected void addInventory(Inventory iInventories) {
		inventories.add(iInventories);
	}
	
	protected void removeInventory(Inventory iInventories) {
		inventories.remove(iInventories);
	}	
	
}
