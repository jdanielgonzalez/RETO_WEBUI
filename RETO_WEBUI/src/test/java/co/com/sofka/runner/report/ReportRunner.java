package co.com.sofka.runner.report;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/orange_hrm/report/report.feature"},
        glue = {"co.com.sofka.stepdefinition.report"},
        tags = {"not @ignore"}
)
public class ReportRunner {
}
