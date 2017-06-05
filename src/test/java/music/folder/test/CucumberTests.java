package music.folder.test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/musicFolder.feature"},plugin = {"pretty", "html:target/cucumber"})
public class CucumberTests {
}
