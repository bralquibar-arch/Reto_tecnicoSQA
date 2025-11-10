package com.jqueryui.taks;

import com.jqueryui.ui.HomeDateUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.jqueryui.ui.HomeDateUI.INPUT_DATE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class HomeDateTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
actor.attemptsTo(
        Switch.toFrame(HomeDateUI.FRAME_DEMO.resolveFor(actor)),
        WaitUntil.the(HomeDateUI.INPUT_DATE, isVisible()).forNoMoreThan(10).seconds(),
        //se llama el elemento real en el DOM apartir del target
        Click.on(INPUT_DATE),
        Switch.toDefaultContext()
);
    }
    public static Performable on(){
        return instrumented(HomeDateTask.class);
    }
}
