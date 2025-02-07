package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification reqspec;
	
	public RequestSpecification requestSpecification() throws IOException {
		
		if(reqspec == null) {
		
			FileOutputStream file = new FileOutputStream("logging.txt");
			PrintStream log = new PrintStream(file);
		
		reqspec = new RequestSpecBuilder()
				.setBaseUri(getGlobalProperties("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		
		}
		return reqspec;
	}

	public String getGlobalProperties(String variable) throws IOException {
		
		FileInputStream pathProperties = new FileInputStream (System.getProperty("user.dir") + "//src//test//java//Resources//GlobalProperties.properties");
		Properties properties = new Properties();
		properties.load(pathProperties);
		
		return (properties.getProperty(variable));
	}
	
	public String getJsonPath(Response response, String key) {
		
		JsonPath js = response.jsonPath();
		return (js.get(key));	
	}
	
    public int getJsonPathInt(Response response, String key) {
		
		JsonPath js = response.jsonPath();
		return (js.getInt(key));	
	}

}
