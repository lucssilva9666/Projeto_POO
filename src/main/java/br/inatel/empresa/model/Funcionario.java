package main.java.br.inatel.empresa.model;

public abstract class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public abstract void calcularSalario(); // Método a ser implementado pelas subclasses

    // Getter para o campo nome
    public String getNome() {
        return nome;
    }

    // Setter para o campo nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para o campo salario
    public double getSalario() {
        return salario;
    }

    // Setter para o campo salario
    public void setSalario(double salario) {
        this.salario = salario;
    }
}