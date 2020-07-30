package apitest;

import org.junit.After;
import org.junit.Before;

//import com.sun.org.glassfish.gmbal.Description;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class SetUp {
	RequestSpecification requestSpecification;
    public String searchData;

    @Before
    public void Initialize() throws Exception
    {
    	GetInformation();
    }

    private void GetInformation() throws Exception
    {
        RestAssured.baseURI="http://www.omdbapi.com/";
        searchData="Harry Potter";
    }

    @After
    public void tearDown()
    {

    }
}
