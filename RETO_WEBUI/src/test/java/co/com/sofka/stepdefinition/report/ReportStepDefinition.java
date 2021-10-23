package co.com.sofka.stepdefinition.report;

import co.com.sofka.exceptions.login.ValidationLogin;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.exceptions.login.ValidationLogin.VALIDATION_DO_NOT_FOUND;
import static co.com.sofka.questions.login.Login.login;
import static co.com.sofka.questions.report.Report.report;
import static co.com.sofka.tasks.do_login.DoLogin.doLogin;
import static co.com.sofka.tasks.do_report.DoReport.doreport;
import static co.com.sofka.tasks.landingpage.OpenLandinPage.openLandinPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ReportStepDefinition extends Setup {

    private static final String ACTOR_NAME = "Chillin";
    private static final String USER = "Admin";
    private static final String PASSWORD = "admin123";
    private static final String REPORT_NAME = "-REPORTE DE CHILLIN-";
    private static final String FALLO = "Reporte creado fallido.";

    //Assertion
    private static final String ASSERTION_MESSAGE ="Report Name : -REPORTE DE CHILLIN-";

    @Given("quiero ver un reporte")
    public void quiero_ver_un_reporte() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(
                openLandinPage()
        );
    }

    @When("creo un reporte y lo ejecuto")
    public void creo_un_reporte_y_lo_ejecuto() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(
                doLogin().setUser(USER).setPassword(PASSWORD),
                doreport().setReportName(REPORT_NAME)
        );
    }

    @Then("deberia ver el reporte")
    public void deberia_ver_el_reporte() {
        validationData(ASSERTION_MESSAGE);
    }


    public void validationData (String message)
    {
        theActorInTheSpotlight().should(
                seeThat
                        (
                                report().Target()
                                        .AssertionMessage(message)
                                        .is()
                                , equalTo(true)
                        )
                        .orComplainWith
                                (ValidationLogin.class,

                                        String.format(VALIDATION_DO_NOT_FOUND, FALLO)
                                )
        );
    }
}
