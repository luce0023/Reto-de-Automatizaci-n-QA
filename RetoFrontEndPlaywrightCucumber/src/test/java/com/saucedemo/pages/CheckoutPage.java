package com.saucedemo.pages;

import com.microsoft.playwright.Page;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutPage {
    private final Page page;

    // Localizadores
    private final String FIRST_NAME_FIELD = "#first-name";
    private final String LAST_NAME_FIELD = "#last-name";
    private final String POSTAL_CODE_FIELD = "#postal-code";
    private final String CONTINUE_BUTTON = "#continue";
    private final String FINISH_BUTTON = "#finish";
    private final String COMPLETE_HEADER = ".complete-header";

    public CheckoutPage(Page page) {
        this.page = page;
    }

    // Paso 1: Ingresar datos de usuario
    public void enterUserInfo(String firstName, String lastName, String postalCode) {
        page.locator(FIRST_NAME_FIELD).fill(firstName);
        page.locator(LAST_NAME_FIELD).fill(lastName);
        page.locator(POSTAL_CODE_FIELD).fill(postalCode);
        page.locator(CONTINUE_BUTTON).click();
    }

    // Paso 2: Finalizar la compra
    public void finishOrder() {
        page.locator(FINISH_BUTTON).click();
    }

    // Paso 3: Validar la confirmación
    public String getConfirmationMessage() {
        return page.locator(COMPLETE_HEADER).textContent();
    }
}