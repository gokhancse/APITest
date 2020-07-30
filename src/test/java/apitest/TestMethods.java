package apitest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.apache.http.HttpStatus;
import org.junit.Test;

import apitest.DataManagement;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestMethods extends SetUp{

	// Seçilen indexte bulunan filmi getir
	  public String GetMovie(int index)
	    {
	        Response response = requestDataSearch(searchData).when().get(baseURI).then().extract().response();
	        String moviename = new StringBuilder().append("Search[").append(index).append("].imdbID").toString();
	        return response.jsonPath().getString(moviename);
	    }
	  
	  // Search movie and some assertions
	  public void SearchWithID(String imdbId)
	    {
	        requestDataID(imdbId).when().get(baseURI).then()
	                .statusCode(HttpStatus.SC_OK).and()
	                .body("Title", equalTo("Harry Potter and the Sorcerer's Stone")).and()
	                .body("Year",equalTo("2001")).and()
	                .body("Released",equalTo("16 Nov 2001"));
	    }
	  
	  //Request body initialization
	  private RequestSpecification requestDataSearch(String searchData)
	    {
	        requestSpecification = given().
	                param(DataManagement.API_KEY.getData(), "b8d8600e").// Veriler enum yapısı ile alındı
	                param(DataManagement.FILM_NAME.getData(), searchData).
	                param(DataManagement.TYPE.getData(), "movie").
	                param(DataManagement.YEAR.getData(), "").
	                param(DataManagement.DATA_TYPE.getData(), "json").
	                param(DataManagement.PAGE.getData(), "1");
	        return requestSpecification;
	    }
	//Request body initialization by id
	   public RequestSpecification requestDataID(String getid)
	    {
	        requestSpecification = given().
	                param(DataManagement.API_KEY.getData(), "b8d8600e").// my appkey
	                param(DataManagement.ID.getData(), getid).
	                param(DataManagement.TITLE.getData(), "").
	                param(DataManagement.TYPE.getData(), "").
	                param(DataManagement.YEAR.getData(), "").
	                param(DataManagement.DATA_TYPE.getData(), "json");
	        return requestSpecification;
	    }
	
	
}
