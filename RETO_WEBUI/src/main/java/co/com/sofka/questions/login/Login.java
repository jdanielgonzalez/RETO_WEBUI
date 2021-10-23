package co.com.sofka.questions.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.sofka.userinterfaces.login.Login.*;

public class Login implements Question<Boolean> {
/*
    private String user;
    private String password;

    public Login wasSetUser(String user) {
        this.user = user;
        return this;
    }

    public Login wasSetPassword(String password) {
        this.password = password;
        return this;
    }
*/  private String assertionmessage;
    private Target Target;

    public Login AssertionMessage(String assertionmessage){
        this.assertionmessage=assertionmessage;
        return this;
    }

    public Login Target(String target)
    {
        if(target=="1") {this.Target=SPAN_MESSAGE;}
        if(target=="2") {this.Target= PIM;}
        return this;
    }

    public Login is()
    {
        return this;
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        return (Target.resolveFor(actor).containsOnlyText(assertionmessage));
    }

    public static Login login()
    {
        return new Login();
    }
}
