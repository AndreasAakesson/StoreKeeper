package storekeeper.ejb;

import storekeeper.datamodel.Order;
import javax.ejb.Stateless;

@Stateless
public class OrderEJB extends GenericEJB<Order> {

	public OrderEJB(){
		super(Order.class);
	}	
}
