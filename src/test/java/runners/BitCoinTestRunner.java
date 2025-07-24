package runners;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/Bitcoin",
    glue = {"stepdefinitions", "hooks"},
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)
@Test
public class BitCoinTestRunner extends AbstractTestNGCucumberTests {
}
