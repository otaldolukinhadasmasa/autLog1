package autoLog.utilitarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Preencher {
    private String webSite;
    private String login;
    private String senha;
    private WebSite site;
    private WebDriver navegador;

    public Preencher(){

    }

    public Preencher(WebDriver navegador, WebSite site, String login, String senha, String webSite) {
        this.webSite = webSite;
        this.site = site;
        this.navegador = navegador;
        this.login = login;
        this.senha = senha;
    }

    public void preencher() {
        if (webSite != "google") {
        //if (!"google".equalsIgnoreCase(webSite)) {
            navegador.get(site.urlString());

            // primeira caixa
            WebElement primeiraCaixa = waitUntilElementVisible(By.xpath(site.getXPath1()));
            primeiraCaixa.click();
            primeiraCaixa.sendKeys("login");

            // segunda caixa
            WebElement segundaCaixa = waitUntilElementVisible(By.xpath(site.getXPath2()));
            segundaCaixa.click();
            segundaCaixa.sendKeys("senha");
        } else {
           System.out.println("");
        }
    }

    private WebElement waitUntilElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
} 


