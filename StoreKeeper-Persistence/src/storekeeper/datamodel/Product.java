package storekeeper.datamodel;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 3740264192336479501L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private int id;	
	private String name;
	private double cost;
	private double price;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Inventory", joinColumns=@JoinColumn(name="product_id"), inverseJoinColumns=@JoinColumn(name="store_id"))
	private Set<Store> stores;
	@OneToMany
	private Set<OrderDetail> orderDetails;
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
	
	public void setCost(double iCost){
		cost = iCost;
	}
	
	public double getCost(){
		return cost; 
	}

	public void setPrice(double iPrice){
		price = iPrice;
	}
	
	public double getPrice(){
		return price; 
	}

	public void setStores(Set<Store> iStores){
		stores = iStores;
	}

	public Set<Store> getStores() { 
		return stores; 
	}

	public void setOrderDetails(Set<OrderDetail> iOrderDetails){
		orderDetails = iOrderDetails;
	}
	
	public Set<OrderDetail> getOrderDetail(){
		return orderDetails;
	}

	protected void addOrderDetail(OrderDetail iOrderDetail) {
		orderDetails.add(iOrderDetail);
	}
	
	protected void removeOrderDetail(OrderDetail iOrderDetail) {
		orderDetails.remove(iOrderDetail);
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
