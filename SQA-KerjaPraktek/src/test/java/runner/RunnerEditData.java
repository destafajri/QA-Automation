package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/DataFeatureFiles/editDataFeature",
glue = "definitionData.EditData",
plugin={
	"pretty",
	"html:target/cucumber-reports",
	"json:target/cucumber-reports/editDataTest.json"
})
public class RunnerEditData extends AbstractTestNGCucumberTests {

}