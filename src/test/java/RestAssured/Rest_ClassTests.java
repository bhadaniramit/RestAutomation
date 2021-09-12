package RestAssured;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/RestClass.html",
                "json:target/results/cucumber.json"},
        features = {"src/test/resources/features/RestAssured.feature"},
        tags = "@auto",
        glue = {"src/test/java/RestAssured"},
        dryRun = true
)
public class Rest_ClassTests {
}
