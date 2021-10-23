package co.com.sofka.tasks.landingpage;

import co.com.sofka.userinterfaces.landingpage.LandingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenLandinPage implements Task{

    private LandingPage landingPage;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Open.browserOn(landingPage));
    }

    public static OpenLandinPage openLandinPage()
    {
        return new OpenLandinPage();
    }
}
