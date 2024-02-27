package autoLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import autoLog.entidades.entidades.Acoes;
import autoLog.entidades.entidades.Atributos;
import autoLog.entidades.entidades.Caminhos;

public class App {
    public static void main(String[] args) throws Exception {

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
}
