package runnerAndStepdefinition;

import org.springframework.test.context.ContextConfiguration;

import SetupTestingDesignPatern.Config.AutomationFrameworkConfig;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

}
