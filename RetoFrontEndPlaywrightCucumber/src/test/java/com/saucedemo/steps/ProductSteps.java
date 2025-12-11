package com.saucedemo.steps;

import com.microsoft.playwright.Page;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class ProductSteps {

    private final InventoryPage inventoryPage;
    private final CartPage cartPage;
    private final CheckoutPage checkoutPage;

    public ProductSteps(PlaywrightContext context) {
        Page page = context.page;
        this.inventoryPage = new InventoryPage(page);
        this.cartPage = new CartPage(page);
        this.checkoutPage = new CheckoutPage(page);
    }

    // Criterio 3: Agregar producto
    @When("el usuario agrega un producto al carrito")
    public void el_usuario_agrega_un_producto_al_carrito() {
        inventoryPage.addProductToCart();
    }

    // Criterio 4: Ver el carrito
    @And("navega al carrito de compras")
    public void navega_al_carrito_de_compras() {
        inventoryPage.goToCart();
    }

    @Then("el producto es visible en el carrito")
    public void el_producto_es_visible_en_el_carrito() {
        Assertions.assertTrue(cartPage.isProductInCart(), "El producto no apareció en el carrito.");
    }

    // Criterio 5: Completar la compra (Parte 1: Checkout)
    @When("el usuario inicia el proceso de compra")
    public void el_usuario_inicia_el_proceso_de_compra() {
        cartPage.startCheckout();
    }

    @When("ingresa los detalles de compra {string}, {string} y {string}")
    public void ingresa_los_detalles_de_compra(String firstName, String lastName, String postalCode) {
        checkoutPage.enterUserInfo(firstName, lastName, postalCode);
    }
    
    @When("confirma la compra")
    public void confirma_la_compra() {
        checkoutPage.finishOrder();
    }
    
    @Then("la compra es confirmada con el mensaje {string}")
    public void la_compra_es_confirmada(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, checkoutPage.getConfirmationMessage(), "El mensaje de confirmación es incorrecto.");
    }
}