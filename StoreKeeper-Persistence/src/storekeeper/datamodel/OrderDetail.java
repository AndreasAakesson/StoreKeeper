package storekeeper.datamodel;

import javax.persistence.*;

@Entity //false error
public class OrderDetail implements java.io.Serializable {

	private static final long serialVersionUID = 6370511882620070284L;

	@Id
	private int order_id;
	@Id
	private int product_id;
	private int ordered;
	private int delivered;
	
	public void setOrder_id(int iOrder_id){
		order_id = iOrder_id; 
	}

	public int getOrder_id(){
		return order_id; 
	}
	
	public void setProduct_id(int iProduct_id){
		product_id = iProduct_id; 
	}

	public int getProduct_id(){
		return product_id; 
	}

	public void setOrdered(int iOrdered){
		ordered = iOrdered; 
	}

	public int getOrdered(){
		return ordered; 
	}

	public void setDelivered(int iDelivered){
		delivered = iDelivered; 
	}

	public int getDelivered(){
		return delivered; 
	}
	
}
