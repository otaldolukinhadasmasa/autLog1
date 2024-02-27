package autoLog;
import java.util.Scanner;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import autoLog.utilitarios.Preencher;
import autoLog.utilitarios.WebSite;

public class Automacao {
    @Test
    public static void main(String[] args) {
       
        System.setProperty("webdriver.edge.driver", "C:\\Users\\pcdoq\\Documents\\drive\\msedgedriver.exe");

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o site:");
        String webSite = sc.nextLine();

         // Create Edge driver
        WebDriver navegador = new EdgeDriver();
        WebSite site = WebSite.createWebsite(webSite, navegador);

        if (site != null) {
            site.getUrl();
        } else {
            System.out.println("Website não encontrado.");
        }

        String login = "login";
        String senha = "senha";

        Preencher preencher = new Preencher(navegador, site, login, senha, webSite);
        preencher.preencher();

        sc.close();
    }
} 