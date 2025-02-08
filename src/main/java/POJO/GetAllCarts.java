package POJO;

import java.util.List;

public class GetAllCarts {

	private int id;
	private int userId;
	private String date;
	private List<GetAllCarts_Products> products;
	private int __v; 
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<GetAllCarts_Products> getProducts() {
		return products;
	}
	public void setProducts(List<GetAllCarts_Products> products) {
		this.products = products;
	}	
	public int get__v() {
		return __v;
	}
	public void set__v(int __v) {
		this.__v = __v;
	}	
}
