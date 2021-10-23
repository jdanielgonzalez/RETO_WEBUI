package co.com.sofka.userinterfaces.resetsearch;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class ResetSearch extends PageObject {

    public static final Target ADMIN = Target
            .the("boton ADMIN")
            .located(xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b"));

    public static final Target USER_MANAGMENT = Target
            .the("boton USER MANAGMENT")
            .located(id("menu_admin_UserManagement"));

    public static final Target SEARCH_USERNAME = Target
            .the("cuadro de texto USER NAME")
            .located(id("searchSystemUser_userName"));

    public static final Target SEARCH_EMPLOYEENAME = Target
            .the("cuadro de texto EMPLOYEE NAME")
            .located(id("searchSystemUser_employeeName_empName"));

    public static final Target BTN_SEARCH = Target
            .the("boton SEARCH")
            .located(id("searchBtn"));

    public static final Target BTN_RESET = Target
            .the("boton RESET")
            .located(id("resetBtn"));

    public static final Target NAME_ON_LIST = Target
            .the("nombre para comparar")
            .located(xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a"));

}
