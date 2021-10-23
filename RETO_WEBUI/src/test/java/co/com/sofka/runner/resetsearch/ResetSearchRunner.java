package co.com.sofka.runner.resetsearch;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/orange_hrm/resetsearch/resetsearch.feature"},
        glue = {"co.com.sofka.stepdefinition.resetsearch"},
        tags = {"not @ignore"}
)
public class ResetSearchRunner {
}
