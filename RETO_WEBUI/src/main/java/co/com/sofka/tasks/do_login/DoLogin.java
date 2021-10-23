package co.com.sofka.tasks.do_login;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.webdriver.WebdriverInstances;
import org.openqa.selenium.support.ui.WebDriverWait;

import static co.com.sofka.userinterfaces.login.Login.*;


public class DoLogin implements Task {

    private String user;
    private String password;

    public DoLogin setUser(String user)
    {
        this.user=user;
        return this;
    }

    public DoLogin setPassword(String password)
    {
        this.password=password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(TXT_USER_NAME),
                Clear.field(TXT_USER_NAME),
                Enter.theValue(this.user).into(TXT_USER_NAME),
                //Enter.keyValues("Admin").into(TXT_USER_NAME),

                Scroll.to(TXT_PASSWORD),
                Clear.field(TXT_PASSWORD),
                Enter.theValue(this.password).into(TXT_PASSWORD),
                //Enter.keyValues("admin123").into(TXT_PASSWORD),

                Scroll.to(BTN_LOGIN),
                Click.on(BTN_LOGIN)


        );
    }

    public static DoLogin doLogin()
    {
        return new DoLogin();
    }
}
