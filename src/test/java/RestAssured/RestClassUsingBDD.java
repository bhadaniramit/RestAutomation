package RestAssured;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class RestClassUsingBDD {

    public void call(){
        baseURI = "";
        basePath = "";
    }


    public void callingGetCall(){
        given()
                .when()

                .then();


    }
}
