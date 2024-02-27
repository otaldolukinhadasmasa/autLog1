package autoLog.utilitarios.paths;

import org.openqa.selenium.WebDriver;

import autoLog.utilitarios.WebSite;

public class Instagram extends WebSite {
    private final WebDriver navegador;

    public Instagram(WebDriver navegador) {
        super("instagram", navegador);
        this.navegador = navegador;
    }

    public String urlString() {
        return "https://www.instagram.com/accounts/login/?next=%2Fexplore%2F&source=desktop_nav";
    }

    @Override
    public String getXPath1() {
        return "/html/body/div[2]/div/div/div[2]/div/div/div[1]/section/main/div/div/div[1]/div[2]/form/div/div[1]/div/label/input";
    }

    @Override
    public String getXPath2() {
        return "/html/body/div[2]/div/div/div[2]/div/div/div[1]/section/main/div/div/div[1]/div[2]/form/div/div[2]/div/label/input";
    }
}
