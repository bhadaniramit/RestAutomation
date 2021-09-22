In this Class, I have automated the first Rest Call.
/*This is Get Call
Importatant Points for GET Call:
RestAssured dependencies should be put on POM.xml
RestAssured.baseURI - It is for the baseURI
RequestSpecification httpRequest = RestAssured.given(); //To build the URI
Response response = httpRequest.request(Method.GET, "/Hyderabad"); // To build the Complete URL
String responseBody = response.getBody().asString(); //To get the response in String and store in responseBody



/**
Post Call
RestAssured.baseURI = //Path
RequestSpecification httpRequest = RestAssured.given();
//Added value for body
JSONObject jsonobject = new JSONObject();
jsonobject.put("FirstName", "Ramit");
jsonobject.put("LastName", "Bhadani");
jsonobject.put("Age", 35);
jsonobject.put("Address", "123 Main Street");

//Adding header
httpRequest.header("Content-Type", "application/json");
httpRequest.body(jsonobject.toJsonString);
Response response = httpRequest.request(Method.POST)
//  if the end point needs to parameterize => Response response = httpRequest.request(Method.Post, "Value to Parameterize")

//To read the specific from header
response.jsonPath().get("message");
*/

/**
How to read the JSON
JSONParser jsonparser = new JSONParser();
Object object1 = jsonparser.parse(responseBody);
//For Simple JSON Object
Object object2 = ((JSONObject) object1).get("DATA TO RETRIVE");
//For JSONArray
JSONArray jsonarray = (JSONArray) ((JSONObject) object1).get("ARRY DATA TO RETRIVE");
jsonarray.get(0);
*/