package storekeeper.ejb;

import storekeeper.datamodel.StoreOrder;
import javax.ejb.Stateless;

@Stateless
public class OrderEJB extends GenericEJB<StoreOrder> {

	public OrderEJB(){
		super(StoreOrder.class);
	}	
}
