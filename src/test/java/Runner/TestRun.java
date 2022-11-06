package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Feature"},
        glue = {"StepDefinition"},
        plugin = {"json:target/cucumber.json",
        		"html:target/HtmlReports"}, 
        monochrome = true
        )
public class TestRun {
}
