package RestAssured;

import io.cucumber.java.en.Given;

public class Rest_GetTestCase {
    utility utilityclass = new utility();
    String basePath = "Panosh+Kosher+Catering/@42.139053,-87.9701785,13z/data=!4m9!1m2!2m1!1sRestaurants!3m5!1s0x880fbc22ba83ae31:0xabca6f96f46b4792!8m2!3d42.1592137!4d-87.9431119!15sCgtSZXN0YXVyYW50c1oNIgtyZXN0YXVyYW50c5IBEGNhdGVyaW5nX3NlcnZpY2WaASNDaFpEU1VoTk1HOW5TMFZKUTBGblNVUlRNWEoxVTJGQkVBRQ";

    @Given("I will trigger the Google Map call")
    public void googleMapTestCase() {
        String serachResult = utilityclass.buildAPIGETMethod("https://reqres.in/api/users?page=2", "");
        System.out.println("Response from API " + serachResult);
//        System.out.println("Header "+utilityclass.response.statusCode());
//        System.out.println("Checking specific attribute "+utilityclass.response.body("data.id[1]",8));
    }


}
