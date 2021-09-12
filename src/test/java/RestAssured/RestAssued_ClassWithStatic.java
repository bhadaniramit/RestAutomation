package RestAssured;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class RestAssued_ClassWithStatic {

    @Given("Another example with Static RestAssured")
    public void restWithStatic() {
        baseURI = "https://reqres.in/api/";
        given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                get("users?page=2").
                then().
                statusCode(200).
                body("data[1].first_name", equalTo("Lindsay")).
                body("data.first_name", hasItems("Lindsay", "George"));
    }

    public void anotherWayofPost(){

    }

}
