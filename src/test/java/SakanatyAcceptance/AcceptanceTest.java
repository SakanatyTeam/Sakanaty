package SakanatyAcceptance;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "cases",
        plugin = { "summary", "html:target/cucumber/wikipidia.html"},
        monochrome=true,
        snippets = SnippetType.CAMELCASE,
        glue="SakanatyAcceptance")


public class AcceptanceTest{

}
