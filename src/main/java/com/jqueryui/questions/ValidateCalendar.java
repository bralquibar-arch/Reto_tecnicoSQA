package com.jqueryui.questions;

import com.jqueryui.ui.CalendarUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class ValidateCalendar implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return CalendarUI.LBL_DATE.resolveFor(actor).isVisible();
    }

    public static ValidateCalendar esVisible() {
        return new ValidateCalendar();
    }
}