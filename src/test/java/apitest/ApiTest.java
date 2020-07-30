package apitest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.apache.http.HttpStatus;
import org.junit.Test;

import apitest.DataManagement;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest extends TestMethods{

	@Test
    public void TestGroup()
    {
		SearchWithID(GetMovie(1));
        requestSpecification.
        when().get(baseURI).then().statusCode(HttpStatus.SC_OK);
    }
	

	
	
}
