package com.senai.aula03_encapsulamento.exercicios.ex03_gerenciamento_de_funcionarios.ex02_conta_bancaria_com_operacoes_simples;

public class Funcionario {
    private String nome;
    private double salario;
    private String cargo;

    String[] cargosDisponiveis = {"gerente", "analista", "programador"};

    public Funcionario(String nome, double salario, String cargo) {
        if (!nome.isEmpty()){
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("O nome do funcionário não pode ser nulo ou vazio.");
        }

        if (salario > 1320){
            this.salario = salario;
        } else {
            throw new IllegalArgumentException("O salário do funcionário deve ser maior do que R$1320,00.");
        }

        this.cargo = null;
        for (String cargoDisponivel : cargosDisponiveis) {
            if (cargo.equalsIgnoreCase(cargoDisponivel)) {
                this.cargo = cargo;
                break;
            }
        }
        if (this.cargo == null){
            throw new IllegalArgumentException("O cargo do funcionário deve constar na lista de cargos disponíveis.");
        }
    }

    // Getters e setters

    // Nome
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        if (!nome.isEmpty()){
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("O nome do funcionário não pode ser nulo ou vazio.");
        }
    }

    // Preço
    public double getSalario(){
        return salario;
    }

    public void setSalario(double salario){
        if (salario > 1320){
            this.salario = salario;
        } else {
            throw new IllegalArgumentException("O salário do funcionário não pode ser menor do que R$1320,00.");
        }
    }

    // Cargo
    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo = null;
        for (String cargoDisponivel : cargosDisponiveis) {
            if (cargo.equalsIgnoreCase(cargoDisponivel)) {
                this.cargo = cargo;
                break;
            }
        }
        if (this.cargo == null){
            throw new IllegalArgumentException("O cargo do funcionário deve constar na lista de cargos disponíveis.");
        }
    }

    // Funções

    public void aumentarPercentual(float percentual){
        if(percentual > 0) {
            salario += percentual/100 * salario;
            System.out.printf("Foi aumentado " + percentual + " por cento ao salário do funcionário " + this.nome + ". O novo salário é R$%,.2f\n", salario);
        } else {
            throw new IllegalArgumentException("O percentual a ser aumentado não pode ser negativo.");
        }
    }

    @Override
    public String toString() {
        return  "Nome do funcionário: " + nome + "\n" +
                "Salário: " + salario + "\n" +
                "Cargo: " + cargo + "\n";
    }
}
