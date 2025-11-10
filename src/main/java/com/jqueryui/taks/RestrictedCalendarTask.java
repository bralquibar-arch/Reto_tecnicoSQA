package com.jqueryui.taks;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RestrictedCalendarTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getDriver();

        // Abrir la página de rango restringido
        actor.attemptsTo(
                Open.url("https://jqueryui.com/datepicker/#min-max")
        );

        // Esperar manualmente a que el iframe aparezca
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.demo-frame"))
        );

        // Cambiar al iframe
        driver.switchTo().frame(iframe);

        //  Esperar el input del calendario
        wait.until(ExpectedConditions.elementToBeClickable(By.id("datepicker")));

        // Hacer clic para abrir el calendario
        WebElement inputDate = driver.findElement(By.id("datepicker"));
        inputDate.click();

        // Validar que el calendario se abrió
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-datepicker-calendar")));
    }

    public static Performable open() {
        return instrumented(RestrictedCalendarTask.class);
    }
}
