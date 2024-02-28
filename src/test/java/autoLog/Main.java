package autoLog;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import autoLog.entidades.entidades.Acoes;
import autoLog.entidades.entidades.Atributos;
import autoLog.entidades.entidades.Caminhos;
import autoLog.utilitarios.Preencher;
import autoLog.utilitarios.Preencher2;
import autoLog.utilitarios.WebSite;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\pcdoq\\Documents\\drive\\msedgedriver.exe");

        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha a funcionalidade:");
        System.out.println("1. Funcionalidades da App");
        System.out.println("2. Funcionalidades da Automação");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                executarFuncionalidadesApp();
                break;
            case 2:
                executarFuncionalidadesAutomacao();
                break;
            default:
                System.out.println("Opção inválida. Escolha 1 ou 2.");
                break;
        }

        sc.close();
    }

    private static void executarFuncionalidadesApp() {
        Scanner sc = new Scanner(System.in);

        List<Atributos> file = new ArrayList<>();
        boolean valorValido = false;
        
        do {
            try {
                System.out.println("Informe o nome do arquivo: ");
                String nomeArq = sc.nextLine();

                System.out.println("Informe o paramentro de busca: ");
                String paramentro = sc.nextLine();

                Caminhos caminho = new Caminhos(nomeArq, paramentro);

                String caminhoOrigin = caminho.caminhoOrigin();
                String caminhoDestino = caminho.caminhoDestino();

                Acoes acoes = new Acoes(paramentro, file, caminhoOrigin, caminhoDestino);

                acoes.ler();

                acoes.escrever();

                valorValido = true;

                System.out.println("Sucesso!");

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Tente novamente.");
                valorValido = false;
            }
        } while (!valorValido);

        sc.close();
    }

    private static void executarFuncionalidadesAutomacao() {
        Scanner sc = new Scanner(System.in);

        List<Atributos> file = new ArrayList<>();
        boolean valorValido = false;
        
        do {
            try {
                System.out.println("Informe o nome do arquivo: ");
                String nomeArq = sc.nextLine();

                System.out.println("Informe o paramentro de busca: ");
                String paramentro = sc.nextLine();

                Caminhos caminho = new Caminhos(nomeArq, paramentro);

                String caminhoOrigin = caminho.caminhoOrigin();
                String caminhoDestino = caminho.caminhoDestino();

                Acoes acoes = new Acoes(paramentro, file, caminhoOrigin, caminhoDestino);

                acoes.ler();

                valorValido = true;

                System.out.println("Lido com sucesso!");

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Tente novamente.");
                valorValido = false;
            }
        } while (!valorValido);


        System.out.println("Informe o site:");
        String webSite = sc.nextLine();

        System.out.println();
        System.out.println("Carregando site...");

        // Create Edge driver
        WebDriver navegador = new EdgeDriver();
        WebSite site = WebSite.createWebsite(webSite, navegador);

        if (site != null) {
            site.getUrl();
        } else {
            System.out.println("Website não encontrado.");
            return;
        }

        Preencher2 preencher = new Preencher2(navegador, file, site, webSite);
        preencher.preencher();

        sc.close();
    }
}
