package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/DataFeatureFiles/UploadDataFeature",
glue = "definitionData",
plugin={
	"pretty",
	"html:target/cucumber-reports",
	"json:target/cucumber-reports/uploadDataTest.json"
})
public class RunnerUploadData extends AbstractTestNGCucumberTests {

}
