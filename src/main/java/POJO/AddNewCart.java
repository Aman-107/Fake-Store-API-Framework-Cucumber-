package POJO;

import java.util.List;

public class AddNewCart {

		private int id;
		private int userId;
		private String date;
		private List<AddNewCart_Products> products; 
		
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
		public List<AddNewCart_Products> getProducts() {
			return products;
		}
		public void setProducts(List<AddNewCart_Products> products) {
			this.products = products;
		}		

}
