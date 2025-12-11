package com.saucedemo.pages;

import com.microsoft.playwright.Page;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPage {
    private final Page page;

    // Localizadores
    private final String CART_ITEM = ".cart_item";
    private final String CHECKOUT_BUTTON = "#checkout";

    public CartPage(Page page) {
        this.page = page;
    }

    // Método para validar que hay al menos un producto en el carrito
    public boolean isProductInCart() {
        return page.locator(CART_ITEM).isVisible();
    }
    
    // Método para iniciar el checkout
    public void startCheckout() {
        page.locator(CHECKOUT_BUTTON).click();
    }
}