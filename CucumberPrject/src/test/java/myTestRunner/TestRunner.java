package myTestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		
		//features = "Features",
		//features = "D:/Selenium_workspace/CucumberPrject/Features/Tagging.feature",
		features = "D:/Selenium_workspace/CucumberPrject/Features/Hooks.feature",
		
		glue="stepDefinations",
		
		/*format= {"pretty","html:test-output",
				"json:json_output/cucumber.json",
				"junit:junit_xml_output/cucumber.xml"},*/
		
		dryRun=false,
		monochrome=true,
		strict=false
		//tags= {"@SanityTesting"}  // execute only SanityTesting
		//tags= {"@SanityTesting, @RegressionTesting"}  // execute only scenarios which are comes under sanity OR regression
		//tags= {"@RegressionTesting","@EndToEndTesting"} //execute scenarios comes under both Regressions and End2End
		//tags= {"@SanityTesting","@EndToEndTesting"} //execute scenarios comes under both Regressions and End2End
		//tags= {"~@EndToEndTesting"}  // This will ignore End2End scenarios
		//tags= {"~@EndToEndTesting", "~@SanityTesting"}  // This will ignore Sanity & End2End
		
		)

 
public class TestRunner {

}
