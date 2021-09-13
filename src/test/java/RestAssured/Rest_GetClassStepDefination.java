package RestAssured;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class Rest_GetClassStepDefination {

    @Given("User will call the http Get Call")
    public void invokeRestCall() {
        //BaseURI
        RestAssured.baseURI = "http://demoqa.com/utilities/weather/city";
        //RequestObject
        RequestSpecification httpRequest = RestAssured.given();
        //ResponseObject
        Response response = httpRequest.request(Method.GET,"/Hyderabad");
        //Print on Console
        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response as " + responseBody);
        System.out.println("Header" + response.getHeaders());
        System.out.println("Reading specific value from Header "+ response.getHeader("Date"));
        System.out.println("Status Code as " +response.getStatusCode());
        System.out.println("Another way of reading specific value from header "  + response.getHeader("Content-Type"));
        Assert.assertEquals("Received Status code is not equal" , 200, response.getStatusCode());
        Assert.assertEquals("Received status line is ", "HTTP/1.1 200 OK" , response.getStatusLine());

    }
}
