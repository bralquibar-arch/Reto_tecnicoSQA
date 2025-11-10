package com.jqueryui.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CalendarUI {


    public static final Target LBL_DATE=Target.the("LBL DATE")
            .located(By.cssSelector("div.ui-datepicker-title"));

    public static final Target BTN_DAY = Target.the("Día del calendario")
            .locatedBy("//table[@class='ui-datepicker-calendar']//a[text()='25']");

    public static final Target BTN_NEXT = Target.the("botón mes siguiente")
            .locatedBy("//a[@data-handler='next']");

    public static final Target BTN_PREV = Target.the("botón mes anterior")
            .locatedBy("//a[@data-handler='prev']");

    public static final Target SELECT_YEAR = Target.the("selector de año")
            .locatedBy("//select[@class='ui-datepicker-year']");

    public static final Target SELECT_MONTH = Target.the("selector de mes")
            .locatedBy("//select[@class='ui-datepicker-month']");
}
