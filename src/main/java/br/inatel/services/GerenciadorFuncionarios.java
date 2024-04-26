package main.java.br.inatel.services;

import main.java.br.inatel.empresa.model.Funcionario;
import main.java.br.inatel.empresa.model.FuncionarioRegular;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class GerenciadorFuncionarios {
    private List<Funcionario> funcionarios;

    public GerenciadorFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void processarPagamento() {
        System.out.println("Processando pagamentos dos funcionários...");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pagamentos.txt", true))) {  // 'true' to append data to file
            for (Funcionario funcionario : funcionarios) {
                funcionario.calcularSalario(); // Chamada polimórfica ao método calcularSalario()

                // Exibir e registrar informações do pagamento do funcionário
                String pagamentoInfo = exibirInformacoesPagamento(funcionario);
                writer.write(pagamentoInfo + "\n"); // Escreve no arquivo com quebra de linha
            }
            System.out.println("Pagamentos processados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    private String exibirInformacoesPagamento(Funcionario funcionario) {
        String tipoFuncionario = funcionario instanceof FuncionarioRegular ? "Funcionário Regular" : "Gerente";
        String pagamentoInfo = "Pagamento processado para " + funcionario.getNome() +
                           " (" + tipoFuncionario + "). Novo salário: R$ " + funcionario.getSalario();
        System.out.println(pagamentoInfo);
        return pagamentoInfo;  // Retorna a string de informação para ser escrita no arquivo
    }
}