package com.jqueryui.questions;

import com.jqueryui.ui.HomeDateUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidateDate implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        String selectedDate = HomeDateUI.INPUT_DATE.resolveFor(actor).getValue();
        System.out.println("Fecha seleccionada: "+ selectedDate);

        //validar formato fecha

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
            sdf.setLenient(false);
            sdf.parse(selectedDate);
                    return true;
        }
        catch (ParseException e) {
            return false;
        }
    }
    public static ValidateDate isFormattedCorrectly(){
        return new ValidateDate();
    }
}

