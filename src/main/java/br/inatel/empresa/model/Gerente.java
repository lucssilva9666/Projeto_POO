// Gerente.java
package main.java.br.inatel.empresa.model;

public class Gerente extends Funcionario {
    private String departamento;

    public Gerente(String nome, double salario, String departamento) {
        super(nome, salario);
        this.departamento = departamento;
    }

    @Override
    public void calcularSalario() {
        setSalario(getSalario() + 1000);
    }
}