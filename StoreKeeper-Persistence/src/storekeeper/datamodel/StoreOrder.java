package storekeeper.datamodel;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
public class StoreOrder implements java.io.Serializable {

	private static final long serialVersionUID = -4215756892193607702L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private int id;
	private Date order_date;
	private Date delivery_date;
	@ManyToOne
	private User user;
	@ManyToOne
	private Store store;
	@ManyToOne
	private OrderStatus orderStatus;
	@OneToMany
	private Set<OrderDetail> orderDetails;

	public int getId(){
		return id;
	}
	
	public void setOrder_date(Date iOrder_date){
		order_date = iOrder_date;
	}
	
	public Date getDelivery_date(){
		return delivery_date;
	}

	public void setDelivery_date(Date iDelivery_date){
		delivery_date = iDelivery_date;
	}
	
	public Date getOrder_date(){
		return order_date;
	}
	
	public void setUser(User iUser){
		if(iUser != null)
			user.removeOrder(this);
		user = iUser;
		if(user != null)
			user.addOrder(this);	
	}
	
	public User getUser(){
		return user;
	}

	public void setStore(Store iStore){
		if(iStore != null)
			store.removeOrder(this);
		store = iStore;
		if(store != null)
			store.addOrder(this);	
	}
	
	public Store getStore(){
		return store;
	}

	public void setOrderStatus(OrderStatus iOrderStatus){
		if(iOrderStatus != null)
			orderStatus.removeOrder(this);
		orderStatus = iOrderStatus;
		if(orderStatus != null)
			orderStatus.addOrder(this);	
	}
	
	public OrderStatus getOrderStatus(){
		return orderStatus;
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
}
