@Test
Feature: Seleccion de fecha en un campo de formulario
  Para evitar errores al ingresar fechas manualmente
  Como usuario de la aplicacion
  Quiero poder seleccionar una fecha desde un calendario emergente


  @Escenario1
  Scenario: Mostrar calendario emergente al hacer clic en el campo de fecha
    Given que el usuario esta en la pagina del formulario
    When hace clic en el campo de fecha
    Then se debe mostrar el calendario emergente

  @Escenario2
  Scenario: Seleccionar una fecha dentro del rango permitido
    Given que el calendario emergente esta Abierto
    When el usuario selecciona una fecha detro del rango permitido
    Then la fecha seleccionada se muestra en el campo con el formato esperado

  @Escenario3
  Scenario: Navegar entre meses y años en el calendario
    Given que el calendario emergente que tiene en lista meses y años esta Abierto
    When el usuario navega al mes siguiente y anterior ademas de cambiar el año
    Then el calendario debe actualizarse y mostrar las fechas del nuevo mes año

  @Escenario4
  Scenario: Impedir seleccion de fechas fuera del rango permitido
    Given que el calendario emergente con retriccion de rango esta Abierto
    When el usuario intenta seleccionar una fecha fuera del rango permitido
    Then la fecha no debe ser seleccionada
