package co.com.sofka.userinterfaces.report;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class Report extends PageObject {


    public static final Target PIM = Target
            .the("boton PIM")
            .located(xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));

    public static final Target REPORTS = Target
            .the("boton REPORTS")
            .located(xpath("//*[@id=\"menu_core_viewDefinedPredefinedReports\"]"));

    public static final Target ADD = Target
            .the("boton ADD")
            .located(id("btnAdd"));

    public static final Target REPORT_NAME = Target
            .the("cuadro de texto REPORT NAME")
            .located(id("report_report_name"));

    public static final Target DISPLAY_FIELD_GROUPS = Target
            .the("boton add DISPLAY FIELD GROUPS")
            .located(id("btnAddDisplayGroup"));

    public static final Target SAVE = Target
            .the("boton SAVE")
            .located(id("btnSave"));

    public static final Target RUN = Target
            .the("boton RUN")
            .located(xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[3]/a"));


    public static final Target RESULT_RUN = Target
            .the("resul RUN")
            .located(xpath("//*[@id=\"search-results\"]/div[1]/h1"));

}
