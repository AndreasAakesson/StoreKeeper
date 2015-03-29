package storekeeper.datamodel;

import java.util.Set;

import javax.persistence.*;

@Entity
public class OrderStatus implements java.io.Serializable {

	private static final long serialVersionUID = 1080622417582291448L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderstatus_id")
	private int id;	
	private String name;	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orderStatus")
	private Set<StoreOrder> orders;

	public int getId(){
		return id;
	}
	
	public void setName(String iName){
		name = iName;
	}
	
	public String getName(){
		return name; 
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
	
}
