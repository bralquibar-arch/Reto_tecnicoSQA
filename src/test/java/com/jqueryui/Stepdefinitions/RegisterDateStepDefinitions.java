package com.jqueryui.Stepdefinitions;

import com.jqueryui.questions.ValidateCalendar;
import com.jqueryui.questions.ValidateDate;
import com.jqueryui.questions.ValidateDateEmpty;
import com.jqueryui.questions.ValidateMonthAndYear;
import com.jqueryui.taks.*;
import com.jqueryui.ui.CalendarUI;
import com.jqueryui.ui.HomeDateUI;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.is;

public class RegisterDateStepDefinitions {

    @Before
    public void setStage(){setTheStage(new OnlineCast());}

    //Escenario Mostrar calendario emergente al hacer clic en el campo de fecha

    @Given("que el usuario esta en la pagina del formulario")
    public void queElUsuarioEstaEnLaPaginaDelFormulario() {
        theActorCalled("Usuario").wasAbleTo(
                Open.url("https://jqueryui.com/datepicker/")
        );
    }
    @When("hace clic en el campo de fecha")
    public void haceClicEnElCampoDeFecha() {
        theActorCalled("Usuario").wasAbleTo(
                HomeDateTask.on()
        );

    }
    @Then("se debe mostrar el calendario emergente")
    public void seDebeMostrarElCalendarioEmergente() {
        theActorInTheSpotlight().attemptsTo(
                Switch.toFrame(HomeDateUI.FRAME_DEMO.resolveFor(theActorInTheSpotlight())),
                WaitUntil.the(CalendarUI.LBL_DATE, isVisible())
                        .forNoMoreThan(10).seconds()

        );

        theActorInTheSpotlight().should(
                seeThat("Visible el calendario",
                        ValidateCalendar.esVisible(), is(true)
                )
        );
        theActorInTheSpotlight().attemptsTo(Switch.toDefaultContext());
    }

    //Escenario Seleccionar una fecha dentro del rango permitido


    @Given("que el calendario emergente esta Abierto")
    public void queElCalendarioEmergenteEstaAbierto() {
        theActorCalled("Usuario").wasAbleTo(
                Open.url("https://jqueryui.com/datepicker/"),
                HomeDateTask.on()
        );

    }
    @When("el usuario selecciona una fecha detro del rango permitido")
    public void elUsuarioSeleccionaUnaFechaDetroDelRangoPermitido() {
        theActorInTheSpotlight().attemptsTo(
                Switch.toFrame(HomeDateUI.FRAME_DEMO.resolveFor(theActorInTheSpotlight())),
                SelectDateTask.on()
        );
        theActorInTheSpotlight().attemptsTo(Switch.toDefaultContext());

    }
    @Then("la fecha seleccionada se muestra en el campo con el formato esperado")
    public void laFechaSeleccionadaSeMuestraEnElCampoConElFormatoEsperado() {

        theActorInTheSpotlight().attemptsTo(
                Switch.toFrame(HomeDateUI.FRAME_DEMO.resolveFor(theActorInTheSpotlight()))
                );

        theActorInTheSpotlight().should(
                seeThat(ValidateDate.isFormattedCorrectly(),is(true))
        );


    }

    //Escenario 3 navegar entre meses y años en el calendario


    @Given("que el calendario emergente que tiene en lista meses y años esta Abierto")
    public void queElUsuarioEstaEnElCalendarioConListasDeMesyAños() {
        theActorCalled("Usuario").wasAbleTo(
                Open.url("https://jqueryui.com/datepicker/#dropdown-month-year"),
                HomeDateTask.on()
        );
    }

    @When("el usuario navega al mes siguiente y anterior ademas de cambiar el año")
    public void elUsuarioNavegaAlMesSiguienteYAnteriorAdemasCambiaElAño() {
        theActorInTheSpotlight().attemptsTo(
                NavigateMonthYearsTaks.toYear("2026")
        );


    }
    @Then("el calendario debe actualizarse y mostrar las fechas del nuevo mes año")
    public void elCalendarioDebeActualizarseYMostrarFechasDelNuevoMesAño() {
        theActorInTheSpotlight().should(
                seeThat("El calendario se actualizo correctamente",
                ValidateMonthAndYear.isUpdated(),
                        org.hamcrest.Matchers.is(true)
                )



        );

    }
    //Escenrio 4 Validar restriccion de fechas fuera del rango

    @Given("que el calendario emergente con retriccion de rango esta Abierto")
    public void queElCalendarioEmergenteConRetriccionDeRangoEstaAbierto() {
        theActorCalled("Usuario").wasAbleTo(
                RestrictedCalendarTask.open()
        );

    }
    @When("el usuario intenta seleccionar una fecha fuera del rango permitido")
    public void elUsuarioIntentaSeleccionarUnaFechaFueraDelRangoPermitido() {
        theActorInTheSpotlight().attemptsTo(
                SelectDataRestrictedTask.now()
        );


    }
    @Then("la fecha no debe ser seleccionada")
    public void laFechaNoDebeSerSeleccionada() {
        theActorInTheSpotlight().should(
                seeThat("No se selecciono ninguna fecha",
                        ValidateDateEmpty.inInput(), is(true))
        );

    }


}
