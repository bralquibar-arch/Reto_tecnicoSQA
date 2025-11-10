package com.jqueryui.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidateDateEmpty implements Question<Boolean> {

    public static ValidateDateEmpty inInput() {
        return new ValidateDateEmpty();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        try {
            // Cambiar al iframe donde está el calendario
            WebElement frame = driver.findElement(By.cssSelector("iframe.demo-frame"));
            driver.switchTo().frame(frame);

            // Obtener el valor del input
            WebElement input = driver.findElement(By.id("datepicker"));
            String value = input.getAttribute("value");

            // Regresar al contexto principal
            driver.switchTo().defaultContent();

            // Retornar true si el campo está vacío
            return value == null || value.isEmpty();

        } catch (Exception e) {
            System.out.println("⚠️ Error al validar el input del calendario: " + e.getMessage());
            driver.switchTo().defaultContent();
            return false;
        }
    }
}
