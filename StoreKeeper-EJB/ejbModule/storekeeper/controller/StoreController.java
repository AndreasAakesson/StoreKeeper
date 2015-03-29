package storekeeper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import storekeeper.datamodel.Store;
import storekeeper.ejb.StoreEJB;

@Named("StoreController")
@RequestScoped
public class StoreController {

	@EJB
	private StoreEJB storeEJB;
	private Store store = new Store();
	private List<Store> storeList = new ArrayList<>();

	public String addNewStore(){
		store = storeEJB.add(store);
		storeList = getStoreList();
		return "storeList.xhtml";		
	}
	
	public List<Store> getStoreList(){
		return storeEJB.findAll();
	}
	
	public Store getStoreByName(String iName){
		return storeEJB.findByName(iName);
	}
	
}
