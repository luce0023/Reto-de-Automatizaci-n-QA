package com.saucedemo.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class PlaywrightContext {
    private Playwright playwright;
    private Browser browser;
    public Page page; 
    
    public PlaywrightContext() {
    }

    @Before
    public void setUp() {
        // Inicialización de Playwright y el navegador (Chrome, sin cabeza)
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
    }

    @After
    public void tearDown() {
        // Cierre de Playwright y el navegador al final de cada escenario
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}