package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class utility {
    String fileName;
    public Response response;

    public Properties readPropertiesFile(String fileName) throws IOException {
        this.fileName = fileName;
        FileInputStream fileInputStream = null;
        Properties properties = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            fileInputStream.close();
        }
        return properties;
    }

    public String returnPropertyValue(String attributeToRead) throws IOException {
        String returnValue = null;
        try {
            returnValue = readPropertiesFile(fileName).getProperty(attributeToRead.replace("\" ", ""));

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return returnValue;
    }

    public String buildAPIGETMethod(String baseURI, String basePath) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.accept(ContentType.JSON);
        if (basePath.equals("")) {
            response = httpRequest.get(baseURI);
        } else {
            response = httpRequest.request(Method.GET, basePath);
        }

        String retriveredResponse = response.body().asPrettyString();
        return retriveredResponse;
    }
}
