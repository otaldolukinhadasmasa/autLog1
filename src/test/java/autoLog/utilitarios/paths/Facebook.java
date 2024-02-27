package autoLog.utilitarios.paths;

import org.openqa.selenium.WebDriver;

import autoLog.utilitarios.WebSite;

public class Facebook extends WebSite{
    private final WebDriver navegador;

    public Facebook(WebDriver navegador) {
        super("facebook", navegador);
        this.navegador = navegador;
    }

    public String urlString(){
        return "https://pt-br.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100";
    }

    public String getXPath1(){
        //return "//input[@email='email']";
        return "/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/form/div/div[1]/input";
    }
    
    @Override
    public String getXPath2(){
        //return "//input[@name='password']";
        return "/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/form/div/div[2]/div/div/input";
    }
    /* 
    @Override
    public String getXPath1(){
        return "/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/form/div/div[1]/input";
    }

    @Override
    public String getXPath2(){
        return "/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/form/div[2]/div[2]/div/div/input";
    }*/
}