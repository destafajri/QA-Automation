package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featureFile",
glue = "definition",
plugin={
	"pretty",
	"html:target/cucumber-reports",
	"json:target/cucumber-reports/paymentTest.json"
})
public class RunnerOpenApp extends AbstractTestNGCucumberTests {

}
