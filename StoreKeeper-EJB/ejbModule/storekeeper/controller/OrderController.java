package storekeeper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import storekeeper.datamodel.StoreOrder;
import storekeeper.ejb.OrderEJB;

@Named("OrderController")
@RequestScoped
public class OrderController {

	@EJB
	private OrderEJB orderEJB;
	private StoreOrder order = new StoreOrder();
	private List<StoreOrder> orderList = new ArrayList<>();

	public String addNewStoreOrder(){
		order = orderEJB.add(order);
		orderList = getStoreOrderList();
		return "orderList.xhtml";		
	}
	
	public List<StoreOrder> getStoreOrderList(){
		return orderEJB.findAll();
	}

}
