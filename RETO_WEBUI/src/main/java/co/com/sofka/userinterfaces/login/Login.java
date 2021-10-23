package co.com.sofka.userinterfaces.login;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class Login extends PageObject {
    public static final Target BTN_LOGIN = Target
            .the("boton login")
            .located(id("btnLogin"));

    public static final Target TXT_USER_NAME = Target
            .the("user name")
            .located(id("txtUsername"));

    public static final Target TXT_PASSWORD = Target
            .the("Password")
            .located(id("txtPassword"));

    public static final Target SPAN_MESSAGE = Target
            .the("span Message")
            .located(id("spanMessage"));

    public static final Target PIM = Target
            .the("PIM")
            .located(xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));
}
