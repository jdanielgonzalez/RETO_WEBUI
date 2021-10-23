package co.com.sofka.tasks.do_resetsearch;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.resetsearch.ResetSearch.*;

public class DoResetSearch implements Task {

    private String username;
    private String employeename;

    public DoResetSearch setUsername(String username) {
        this.username = username;
        return this;
    }

    public DoResetSearch setEmployeename(String employeename) {
        this.employeename = employeename;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(

                    Scroll.to(ADMIN),
                    Click.on(ADMIN),

                    Scroll.to(USER_MANAGMENT),
                    Click.on(USER_MANAGMENT),

                    Scroll.to(SEARCH_USERNAME),
                    Clear.field(SEARCH_USERNAME),
                    Enter.theValue(username).into(SEARCH_USERNAME),

                    Scroll.to(SEARCH_EMPLOYEENAME),
                    Clear.field(SEARCH_EMPLOYEENAME),
                    Enter.theValue(employeename).into(SEARCH_EMPLOYEENAME),

                    Scroll.to(BTN_SEARCH),
                    Click.on(BTN_SEARCH),

                    Scroll.to(BTN_RESET),
                    Click.on(BTN_RESET)
            );
    }

    public static DoResetSearch doResetSearch()
    {
        return new DoResetSearch();
    }
}
