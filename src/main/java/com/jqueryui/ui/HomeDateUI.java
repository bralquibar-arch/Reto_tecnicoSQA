package com.jqueryui.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeDateUI {

    public static final Target FRAME_DEMO = Target.the("frame demo")
            .located(By.cssSelector("iframe.demo-frame")); //se genera este metodo dado que el elemento se encuentra en un iframe

    public static final Target INPUT_DATE=Target.the("INPUT DATE")
        .located(By.id("datepicker"));
}
