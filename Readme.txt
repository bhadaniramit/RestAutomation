In this Class, I have automated the first Rest Call.

Importatant Points for GET Call:
RestAssured dependencies should be put on POM.xml
RestAssured.baseURI - It is for the baseURI
RequestSpecification httpRequest = RestAssured.given(); //To build the URI
Response response = httpRequest.request(Method.GET, "/Hyderabad"); // To build the Complete URL
String responseBody = response.getBody().asString(); //To get the response in String and store in responseBody
