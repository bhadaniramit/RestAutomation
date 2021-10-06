package RestAssuredFramework;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredClass {


    public String getURI() {
        return baseURI = "https://reqres.in/api/";

//        return baseURI = "https://jsonplaceholder.typicode.com/todos/1";
    }

    @Given("Running the Traditional Way of Rest")
    public void traditionWay() throws ParseException {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, getURI());
        String responseBody = response.body().asPrettyString();
        //Printing the Output
        System.out.println("Get the Response Body " + responseBody);
        System.out.println("Get the status Code " + response.statusCode());
        System.out.println("Get the Headers " + response.getHeaders().get("Date"));
        JSONParser jsonParser = new JSONParser();
        Object object1 = jsonParser.parse(responseBody);
        Object object2 = ((JSONObject) object1).get("total");
        System.out.println("Printing JSON Object -->" + object2);
        JSONArray jsonArray = (JSONArray) ((JSONObject) object1).get("data");
        System.out.println("Printing JSON Array " + jsonArray.toJSONString());
    }

    @Given("I will build the Get Call")
    public void i_will_build_the_get_call() {
        baseURI = "https://reqres.in/api/";
        basePath = "users?page=2";
        // Write code here that turns the phrase above into concrete actions
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("total", equalTo(12))
                .body("data[5].email", equalTo("tracey.ramos@reqres.in"))
                .log().all();
    }

    @Then("I will build the Post Call")
    public void i_will_trigger_the_post_call() {
        // Write code here that turns the phrase above into concrete actions
        baseURI = "https://reqres.in/api/";
        basePath = "users";
        Map postCall = new HashMap();
        postCall.put("name", "Mota");
        postCall.put("job", "TestLead");
        JSONObject jsonObject = new JSONObject(postCall);
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .post()
                .then()
                .statusCode(201)
                .log().all();

    }

    @Then("I will validate the PUT response")
    public void i_will_validate_the_response() {
        // Write code here that turns the phrase above into concrete actions
        baseURI = "https://reqres.in/api/";
        basePath = "users/2";
        Map myPutrequest  = new HashMap();
        myPutrequest.put("name", "kota");
        myPutrequest.put("job", "Test Lead");
        JSONObject jsonObject = new JSONObject(myPutrequest);
        given()
                .body(jsonObject.toJSONString())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .put()
                .then()
                .statusCode(200)
                .log().all();
    }

}
