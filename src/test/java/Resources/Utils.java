package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	RequestSpecification reqspec;
	
	public RequestSpecification requestSpecification() throws IOException {
		
		reqspec = new RequestSpecBuilder()
				.setBaseUri(getGlobalProperties("baseUrl"))
				.setContentType(ContentType.JSON).build();
		
		return reqspec;
		
	}

	public String getGlobalProperties(String variable) throws IOException {
		
		FileInputStream pathProperties = new FileInputStream (System.getProperty("user.dir") + "//src//test//java//Resources//GlobalProperties.properties");
		Properties properties = new Properties();
		properties.load(pathProperties);
		
		return (properties.getProperty(variable));
	}
	
	public Object getJsonPath(Response response, String key) {
		
		JsonPath js = response.jsonPath();
		return (js.get(key));
		
	}
}
