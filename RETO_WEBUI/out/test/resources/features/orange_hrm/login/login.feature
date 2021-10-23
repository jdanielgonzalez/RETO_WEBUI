Feature: login
  yo como usuario administraor deseo loggearme en la pagina para realizar cambios
  en la base de datos de recursos humanos de OrangeHRM


  Scenario: login exitoso
    Given que quiero iniciar sesion
    When ingrese las credenciales correctas
    Then deberia logearme correctamente


  Scenario Outline: fallido
    Given que quiero iniciar sesion
    When ingrese las credenciales incorrectas
    And escriba
    |user|<user>|
    |password|<password>|
    Then deberia aparecer una advertencia y no logearme


  Examples:
      | user  | password |
      | Admin | admin124 |
      | admin | admin123 |