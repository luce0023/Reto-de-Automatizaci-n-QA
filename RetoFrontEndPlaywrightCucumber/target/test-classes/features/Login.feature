# Login.feature
@SelectClasspathResource("features") 

Feature: Autenticación de Usuarios en Sauce Demo
  Como usuario de Sauce Demo
  Quiero iniciar y cerrar sesión
  Para acceder a la tienda de productos

  Background:
    Given que el usuario está en la página de login "https://www.saucedemo.com/"

  @LoginValido
  Scenario: 1. Iniciar sesión con credenciales válidas
    Given un usuario con credenciales "standard_user" y "secret_sauce"
    When el usuario intenta iniciar sesión
    Then el inicio de sesión debe ser exitoso
    And el usuario es redirigido a la página de productos
    And el botón de menú es visible

  @LoginInvalido
  Scenario: 2. No se permite iniciar sesión con credenciales inválidas
    Given un usuario con credenciales "usuario_invalido" y "password_invalida"
    When el usuario intenta iniciar sesión
    Then el inicio de sesión debe fallar
    And se muestra el mensaje de error "Epic sadface: Username and password do not match any user in this service"
    
    @LoginBloqueado
  Scenario: 3. No se permite iniciar sesión con un usuario bloqueado
    Given un usuario con credenciales "locked_out_user" y "secret_sauce"
    When el usuario intenta iniciar sesión
    Then el inicio de sesión debe fallar
    And se muestra el mensaje de error "Epic sadface: Sorry, this user has been locked out."

    @FlujoCompleto
Scenario: 4. El usuario completa el flujo de compra
  Given que el usuario está en la página de login "https://www.saucedemo.com/"
  Given un usuario con credenciales "standard_user" y "secret_sauce"
  When el usuario intenta iniciar sesión
  Then el inicio de sesión debe ser exitoso
  
  When el usuario agrega un producto al carrito
  And navega al carrito de compras
  Then el producto es visible en el carrito
  
  When el usuario inicia el proceso de compra
  When ingresa los detalles de compra "Tester", "Sauce" y "12345"
  When confirma la compra
  Then la compra es confirmada con el mensaje "Thank you for your order!"