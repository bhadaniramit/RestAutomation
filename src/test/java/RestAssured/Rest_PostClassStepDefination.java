package RestAssured;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;

public class Rest_PostClassStepDefination {
    String propertiesFilePath = System.getProperty("user.dir") + File.separator + "src/test/resources/PropertiesFolder/propertiesfile";
    utility utilityclass = new utility();

    @Given("User will send the post call")
    public void user_will_send_the_post_call() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject postParam = new JSONObject();
        utilityclass.readPropertiesFile(propertiesFilePath);
        postParam.putAll(utilityclass.readPropertiesFile(propertiesFilePath));
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(postParam.toJSONString());
        Response response = httpRequest.request(Method.POST);
        System.out.println("Response " +response.statusCode());
        System.out.println("Response Body is " +response.getBody().asString());
        System.out.println("Response Success Message " +response.jsonPath().get("message"));
    }
}
