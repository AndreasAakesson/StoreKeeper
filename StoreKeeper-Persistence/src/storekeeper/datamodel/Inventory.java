package storekeeper.datamodel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //false error
public class Inventory implements java.io.Serializable {

	private static final long serialVersionUID = 8582917755865252584L;

	@Id
	private int store_id;
	@Id
	private int product_id;
	private double amount;
	
	public void setStore_id(int iStore_id){
		store_id = iStore_id; 
	}

	public int getStore_id(){
		return store_id; 
	}
	
	public void setProduct_id(int iProduct_id){
		product_id = iProduct_id; 
	}

	public int getProduct_id(){
		return product_id; 
	}

	public void setAmount(int iAmount){
		amount = iAmount; 
	}

	public double getAmount(){
		return amount; 
	}

	
	
}
