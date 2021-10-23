package co.com.sofka.stepdefinition.resetsearch;

import co.com.sofka.exceptions.login.ValidationLogin;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.exceptions.login.ValidationLogin.VALIDATION_DO_NOT_FOUND;
import static co.com.sofka.questions.resetsearch.ResetSearch.resetSearch;
import static co.com.sofka.tasks.do_login.DoLogin.doLogin;
import static co.com.sofka.tasks.do_resetsearch.DoResetSearch.doResetSearch;
import static co.com.sofka.tasks.landingpage.OpenLandinPage.openLandinPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ResetSearchStepDefinition extends Setup {

    private static final String USER = "Admin";
    private static final String PASSWORD = "admin123";
    private static final String ACTOR_NAME = "Chillin";
    private static final String EMPLOYEE_NAME = "la mejor";
    private static final String FALLO = "Reseteo fallido.";

    //Assertion
    private static final String ASSERTION_MESSAGE ="Aaliyah.Haq";

    @Given("quiero resetear los campos de busquedad")
    public void quiero_resetear_los_campos_de_busquedad() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(
                openLandinPage()
        );
    }

    @When("los campos estan llenos")
    public void los_campos_estan_llenos() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(
                doLogin().setUser(USER).setPassword(PASSWORD),
                doResetSearch().setUsername(ACTOR_NAME).setEmployeename(EMPLOYEE_NAME)
        );
    }

    @Then("deberia de resetear los espacios de busqueda")
    public void deberia_de_resetear_los_espacios_de_busqueda() {
            validationData(ASSERTION_MESSAGE);
    }

    public void validationData (String message)
    {
        theActorInTheSpotlight().should(
                seeThat
                        (
                                resetSearch().Target()
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
