Feature: Reset Search
  yo como usuario administraor deseo resetear la busqueda
  para volver a buscar nuevamente.


  Scenario: buscar y resetear busqueda
    Given quiero resetear los campos de busquedad
    When los campos estan llenos
    Then deberia de resetear los espacios de busqueda
