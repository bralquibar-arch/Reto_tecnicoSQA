package com.jqueryui.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectDataRestrictedTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        // la página correcta
        driver.get("https://jqueryui.com/datepicker/#min-max");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // espera hasta que el iframe esté disponible y cambia a él automáticamente
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.demo-frame")));

        // abre el calendario
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("datepicker")));
        input.click();

        // avanza al mes siguiente
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-datepicker-next"))).click();

        try {
            // intenta hacer clic en una fecha deshabilitada
            WebElement disabledDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".ui-datepicker-unselectable.ui-state-disabled")));
            disabledDate.click();
        } catch (ElementNotInteractableException e) {
            System.out.println("No se puede hacer clic en una fecha deshabilitada (correcto).");
        } catch (Exception e) {
            System.out.println("No se encontró ninguna fecha deshabilitada visible.");
        } finally {
            // volver al documento principal
            driver.switchTo().defaultContent();
        }
    }

    public static Performable now() {
        return instrumented(SelectDataRestrictedTask.class);
    }
}
