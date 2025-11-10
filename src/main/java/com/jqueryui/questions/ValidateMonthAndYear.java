package com.jqueryui.questions;

import com.jqueryui.ui.CalendarUI;
import com.jqueryui.ui.HomeDateUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Switch;

public class ValidateMonthAndYear implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(Switch.toFrame(HomeDateUI.FRAME_DEMO.resolveFor(actor)));
        String title = CalendarUI.LBL_DATE.resolveFor(actor).getText();
        actor.attemptsTo(Switch.toDefaultContext());
        return title != null && !title.isEmpty();
    }

    public static Question<Boolean> isUpdated() {
        return new ValidateMonthAndYear();
    }
}
