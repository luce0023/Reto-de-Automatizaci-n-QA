package com.saucedemo.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class LoginPage {
    private final Page page;
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator errorMessage;
    private final Locator menuButton;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.locator("#user-name");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("#login-button");
        this.errorMessage = page.locator(".error-message-container.error h3");
        this.menuButton = page.locator("#react-burger-menu-btn");
    }
    public void goTo(String url) {
        page.navigate(url);
    }
    public void login(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }
    public boolean isLoginSuccessful() {
        return menuButton.isVisible();
    }
    public String getErrorMessage() {
        return errorMessage.textContent();
    }
}