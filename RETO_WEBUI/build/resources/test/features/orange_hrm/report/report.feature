Feature: Reports
  yo como usuario administraor deseo crear un reporte
  en la base de datos de recursos humanos y correrlo


  Scenario: crear un reporte y ejecutarlo
    Given quiero ver un reporte
    When creo un reporte y lo ejecuto
    Then deberia ver el reporte
