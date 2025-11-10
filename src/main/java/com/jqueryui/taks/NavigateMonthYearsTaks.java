package com.jqueryui.taks;

import com.jqueryui.ui.CalendarUI;
import com.jqueryui.ui.HomeDateUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateMonthYearsTaks implements Task {
    private final String newYear;

    public NavigateMonthYearsTaks(String newYear) {
        this.newYear = newYear;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toFrame(HomeDateUI.FRAME_DEMO.resolveFor(actor)),
                WaitUntil.the(CalendarUI.LBL_DATE, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CalendarUI.BTN_NEXT),
                WaitUntil.the(CalendarUI.LBL_DATE, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(CalendarUI.BTN_PREV),
                SelectFromOptions.byVisibleText(newYear).from(CalendarUI.SELECT_YEAR),
                Switch.toDefaultContext()

        );

    }

    public static Performable toYear(String year) {
        return instrumented(NavigateMonthYearsTaks.class, year);
    }
}