package co.com.sofka.questions.resetsearch;

import co.com.sofka.questions.report.Report;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.sofka.userinterfaces.resetsearch.ResetSearch.NAME_ON_LIST;

public class ResetSearch implements Question<Boolean> {

    private String assertionmessage;
    private Target Target;

    public ResetSearch AssertionMessage (String assertionmessage)
    {
        this.assertionmessage=assertionmessage;
        return this;
    }

    public ResetSearch Target()
    {
        this.Target= NAME_ON_LIST;
        return this;
    }

    public ResetSearch is()
    {
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (Target.resolveFor(actor).containsOnlyText(assertionmessage));
    }

    public static ResetSearch resetSearch()
    {
        return new ResetSearch();
    }
}
