// FuncionarioRegular.java
package main.java.br.inatel.empresa.model;

public class FuncionarioRegular extends Funcionario {
    public FuncionarioRegular(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void calcularSalario() {
        
        setSalario(getSalario() - 300);

    }
}
