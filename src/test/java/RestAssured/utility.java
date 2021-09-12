package RestAssured;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class utility {
    String fileName;

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
            returnValue = readPropertiesFile(fileName).getProperty(attributeToRead.replace("\" ",""));

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return returnValue;
    }
}
