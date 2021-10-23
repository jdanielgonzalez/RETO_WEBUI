package co.com.sofka.tasks.do_report;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import static co.com.sofka.userinterfaces.report.Report.*;

public class DoReport implements Task {

    private String report_name;

    public DoReport setReportName(String report_name)
    {
        this.report_name=report_name;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Scroll.to(PIM),
                Click.on(PIM),

                Scroll.to(REPORTS),
                Click.on(REPORTS),

                Scroll.to(ADD),
                Click.on(ADD),

                Scroll.to(REPORT_NAME),
                Clear.field(REPORT_NAME),
                Enter.theValue(this.report_name).into(REPORT_NAME),

                Scroll.to(DISPLAY_FIELD_GROUPS),
                Click.on(DISPLAY_FIELD_GROUPS),

                Scroll.to(SAVE),
                Click.on(SAVE),

                Scroll.to(RUN),
                Click.on(RUN)


        );
    }

    public static DoReport doreport()
    {
        return new DoReport();
    }
}
