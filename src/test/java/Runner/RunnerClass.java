package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/java/featureFile/DemoWenShop.feature",
        glue="stepDefination",
//        tags="@AddToCart",
        monochrome=true,
        plugin={"pretty","io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm","json:target/cucumber.json"}
)
public class RunnerClass extends AbstractTestNGCucumberTests {
}
