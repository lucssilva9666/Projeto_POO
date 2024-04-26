// Main.java
package main.java.br.inatel;
import main.java.br.inatel.empresa.model.*;
import main.java.br.inatel.services.GerenciadorFuncionarios;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        String filePath = "src/main/java/br/inatel/empresa/resources/funcionarios.txt";
        try (Scanner scanner = new Scanner(new File((filePath)))) 
        {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(",");
                if (dados.length == 3) //Dados = Função, Nome, Salario.  
                {
                    if (dados[0].equals("Regular")) {
                        funcionarios.add(new FuncionarioRegular(dados[1], Double.parseDouble(dados[2])));
                    } else if (dados[0].equals("Gerente")) {
                        funcionarios.add(new Gerente(dados[1], Double.parseDouble(dados[2]), "TI"));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de funcionários: " + e.getMessage());
        }

        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios(funcionarios);
        gerenciador.processarPagamento();
    }
}
