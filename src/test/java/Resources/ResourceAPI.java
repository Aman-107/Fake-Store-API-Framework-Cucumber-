package Resources;

public enum ResourceAPI {
	
	UserLogin("/auth/login"),
	GetAllProducts("/products"),
	GetSingleProducts("/products/{id}"),
	AddNewProducts("/products"),
	UpdateProduct("/products/{id}");

	private String resource;
	
	ResourceAPI(String resource) {
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}

	public String getResourceWithID(String id) {
		return (resource.replace("{id}", id));
	}
}
