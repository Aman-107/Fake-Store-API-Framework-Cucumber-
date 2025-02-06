package POJO;

public class CreateloginReq {
		
		private String email;
		private String username;
		 private String password;
		 private CreateLoginReq_Name name;
		 private CreateLoginReq_Address address;
		 private String phone;
		
		 public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public CreateLoginReq_Name getName() {
			return name;
		}
		public void setName(CreateLoginReq_Name name) {
			this.name = name;
		}
		public CreateLoginReq_Address getAddress() {
			return address;
		}
		public void setAddress(CreateLoginReq_Address address) {
			this.address = address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
}
