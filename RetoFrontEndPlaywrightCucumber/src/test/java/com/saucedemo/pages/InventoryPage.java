package com.saucedemo.pages;

import com.microsoft.playwright.Page;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryPage {
    private final Page page;

    // Localizadores
    private final String PRODUCT_TITLE = ".title";
    private final String ADD_TO_CART_BUTTON = "#add-to-cart-sauce-labs-backpack"; // Usaremos un producto específico
    private final String SHOPPING_CART_LINK = ".shopping_cart_link";

    public InventoryPage(Page page) {
        this.page = page;
    }

    // Método para validar que estamos en la página de inventario
    public boolean isInventoryPageVisible() {
        return page.locator(PRODUCT_TITLE).textContent().equals("Products");
    }
    
    // Método para agregar un producto
    public void addProductToCart() {
        page.locator(ADD_TO_CART_BUTTON).click();
    }
    
    // Método para ir al carrito
    public void goToCart() {
        page.locator(SHOPPING_CART_LINK).click();
    }

    // Método para validar que el contador del carrito es correcto (opcional, pero buena práctica)
    public boolean isCartCountVisible(String expectedCount) {
        return page.locator(SHOPPING_CART_LINK).textContent().equals(expectedCount);
    }
}