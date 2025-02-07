package Resources;

public enum ResourceAPI {
	
	UserLogin("/auth/login"),
	GetAllProducts("/products"),
	GetSingleProducts("/products/{key}"),
	AddNewProducts("/products"),
	UpdateProduct("/products/{key}"),
	DeleteProduct("/products/{key}"),
	FilteredProduct("products/category/{key}");

	private String resource;
	
	ResourceAPI(String resource) {
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}

	public String getResourceWithkey(String key) {
		return (resource.replace("{key}", key));
	}
}
