
package web.cucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    //features = {"src\\test\\resources\\features"},
    //features = {"src\\test\\resources\\features\\SearchProduct.feature"},
    //features = {"src\\test\\resources\\features\\AddProductToCart.feature"}, //APC
    features = {"src\\test\\resources\\features\\SignUp.feature"},
    plugin = {"pretty", "html:target/testReport.html", "json:target/jsonReport.json", "rerun:target/rerun.txt"},
    //dryRun = false,
    monochrome = true,
    //tags = "@sanity" //APC
    //tags = "@sb" // search bar
    tags = "@jr"
)
public class TestRunner {
}