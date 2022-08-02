package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/DataFeatureFiles/DistributeDataFeature",
glue = "definitionData.DistributeData",
plugin={
	"pretty",
	"html:target/cucumber-reports",
	"json:target/cucumber-reports/distributeDataTest.json"
})
public class RunnerDistributeData extends AbstractTestNGCucumberTests {

}