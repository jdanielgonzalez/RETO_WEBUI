package co.com.sofka.questions.report;

import co.com.sofka.questions.login.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;


import static co.com.sofka.userinterfaces.report.Report.RESULT_RUN;

public class Report implements Question<Boolean> {

    private String assertionmessage;
    private Target Target;

    public Report AssertionMessage (String assertionmessage)
    {
        this.assertionmessage=assertionmessage;
        return this;
    }

    public Report Target()
    {
        this.Target= RESULT_RUN;
        return this;
    }

    public Report is()
    {
        return this;
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        return (Target.resolveFor(actor).containsOnlyText(assertionmessage));
    }

    public static Report report()
    {
        return new Report();
    }

}
