package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginSteps {

    private Page page;
    private LoginPage loginPage;
    private String username;
    private String password;

  
    public LoginSteps(PlaywrightContext context) {
        this.page = context.page; // <-- ¡ESTA ES LA CORRECCIÓN CLAVE!
        this.loginPage = new LoginPage(this.page);
    }
    
   
    @Given("que el usuario está en la página de login {string}")
    public void que_el_usuario_esta_en_la_pagina_de_login(String url) {
        loginPage.goTo(url);
    }

    @Given("un usuario con credenciales {string} y {string}")
    public void un_usuario_con_credenciales(String user, String pass) {
        this.username = user;
        this.password = pass;
    }

    @When("el usuario intenta iniciar sesión")
    public void el_usuario_intenta_iniciar_sesion() {
        loginPage.login(username, password);
    }

    @Then("el inicio de sesión debe ser exitoso")
    public void el_inicio_de_sesion_debe_ser_exitoso() {
        assertTrue(loginPage.isLoginSuccessful(), "El inicio de sesión falló, la página de productos no es visible.");
    }

    @Then("el usuario es redirigido a la página de productos")
    public void el_usuario_es_redirigido_a_la_pagina_de_productos() {
        
        assertEquals("https://www.saucedemo.com/inventory.html", page.url(), "La URL no es la esperada tras el login.");
    }

    @Then("el botón de menú es visible")
    public void el_boton_de_menu_es_visible() {
        assertTrue(loginPage.isLoginSuccessful(), "El botón de menú no es visible.");
    }

    @Then("el inicio de sesión debe fallar")
    public void el_inicio_de_sesion_debe_fallar() {
        
        assertEquals("https://www.saucedemo.com/", page.url(), "El usuario fue redirigido a pesar de credenciales inválidas.");
    }

    @Then("se muestra el mensaje de error {string}")
    public void se_muestra_el_mensaje_de_error(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        assertEquals(expectedMessage, actualMessage, "El mensaje de error no coincide.");
    }
}