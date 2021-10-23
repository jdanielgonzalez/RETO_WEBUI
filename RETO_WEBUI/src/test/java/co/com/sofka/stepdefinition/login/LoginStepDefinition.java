package co.com.sofka.stepdefinition.login;

//estepdefition of login with cucumber

import co.com.sofka.exceptions.login.ValidationLogin;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.exceptions.login.ValidationLogin.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.login.Login.login;
import static co.com.sofka.tasks.do_login.DoLogin.doLogin;
import static co.com.sofka.tasks.landingpage.OpenLandinPage.openLandinPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDefinition extends Setup{

    private static final String ACTOR_NAME = "Chillin";
    private static final String USER = "Admin";
    private static final String PASSWORD = "admin123";
    private static final String FALLO = "Inicio de sesion fallido.";

    // Assertion
    private static final String PIM_ASSERTION = "PIM";
    private static final String EMPTY_ASSERTION = "Username cannot be empty";
    private static final String CREDENTIAL_ASSERTION = "Invalid credentials";
    private DataTable dataToValidate;

    @Given("que quiero iniciar sesion")
    public void queQuieroIniciarSesion() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(
                openLandinPage()
        );
    }

    @When("ingrese las credenciales correctas")
    public void ingreseLasCredencialesCorrectas() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(
                doLogin().setUser(USER).setPassword(PASSWORD)
        );
    }

    @Then("deberia logearme correctamente")
    public void deberiaLogearmeCorrectamente()
    {
        validationData("2",PIM_ASSERTION);
    }

    @When("ingrese las credenciales incorrectas")
    public void ingreseLasCredencialesIncorrectas() {}

    @When("escriba")
    public void escriba(io.cucumber.datatable.DataTable dataTable)
    {
        dataToValidate = dataTable;
        if(dataTable.row(0).get(1)==null && dataTable.row(1).get(1)==null)
        {
            theActorInTheSpotlight().attemptsTo(
                doLogin().setUser("").setPassword("")
            );
        }

        if(dataTable.row(0).get(1)!=null && dataTable.row(1).get(1)!=null)
        {
            theActorInTheSpotlight().attemptsTo(
                    doLogin().setUser(dataTable.row(0).get(1))
                            .setPassword(dataTable.row(1).get(1))
         );
        }
    }

    @Then("deberia aparecer una advertencia y no logearme")
    public void deberiaAparecerUnaAdvertenciaYNoLogearme() {

        if(dataToValidate.row(0).get(1)==null && dataToValidate.row(1).get(1)==null)
        {
            validationData("1",EMPTY_ASSERTION);
        }

        if(dataToValidate.row(0).get(1)!=null && dataToValidate.row(1).get(1)!=null)
        {
            validationData("1",CREDENTIAL_ASSERTION);
        }

    }

    public void validationData (String target, String message)
    {
        theActorInTheSpotlight().should(
                seeThat
                        (
                                login().Target(target)
                                        .AssertionMessage(message)
                                        .is()
                                , equalTo(true)
                        )
                        .orComplainWith
                                (ValidationLogin.class,

                                        String.format(VALIDATION_DO_NOT_MATCH, FALLO)
                                )
        );
    }
}
