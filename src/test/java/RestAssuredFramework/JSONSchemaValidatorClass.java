package RestAssuredFramework;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidatorClass {

    @Given("I will validate the JSON Schema")
    public void validate_JSON_Get(){
        baseURI = "https://reqres.in/api/";
        basePath = "users?page=2";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"));

    }

}
