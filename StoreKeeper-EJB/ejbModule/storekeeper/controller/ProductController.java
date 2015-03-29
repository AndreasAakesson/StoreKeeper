package storekeeper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import storekeeper.ejb.ProductEJB;
import storekeeper.datamodel.Product;

@Named("ProductController")
@RequestScoped
public class ProductController {

	@EJB
	private ProductEJB productEJB;
	private Product product = new Product();
	private List<Product> productList = new ArrayList<>();

	public String addNewProduct(){
		product = productEJB.add(product);
		productList = getProductList();
		return "productList.xhtml";		
	}
	
	public List<Product> getProductList(){
		return productEJB.findAll();
	}
	
	public Product getProductByName(String iName){
		return productEJB.findByName(iName);
	}
}