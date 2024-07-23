package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Feature/LoginFeature.feature",
		glue = "StepDefinition",
		dryRun = false,
		monochrome = true,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		) 
//pretty" ,"html:target/cucumber-reports/reports1.html
public class Run
{

}
