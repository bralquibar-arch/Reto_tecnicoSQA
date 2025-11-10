package com.jqueryui.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.jqueryui.ui.CalendarUI.BTN_DAY;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectDateTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_DAY)
        );

    }
    public static Performable on(){return instrumented(SelectDateTask.class);
    }
}
