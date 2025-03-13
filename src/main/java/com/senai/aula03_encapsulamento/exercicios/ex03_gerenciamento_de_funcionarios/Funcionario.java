package com.senai.aula03_encapsulamento.exercicios.ex03_gerenciamento_de_funcionarios;

public class Funcionario {
    private String nome;
    private double salario;
    private String cargo;

    String[] cargosDisponiveis = {"gerente", "analista", "programador"};

    public Funcionario(String nome, double salario, int idCargo) {
        if (!nome.isBlank()){
            this.nome = nome;
        } else {
            System.out.println("O nome do funcionário não pode ser nulo ou vazio. Seu nome será atribuído como 'Funcionario'");
            this.nome = "Funcionario";
        }

        if (salario > 1320){
            this.salario = salario;
        } else {
            System.out.println("O salário do funcionário deve ser maior do que R$1320,00. Seu salario será redefinido para R$2000,00.");
            this.salario = 2000;
        }

        if (idCargo < cargosDisponiveis.length + 1 && idCargo <= 1) {
                this.cargo = cargosDisponiveis[idCargo];
        } else {
            System.out.println("O idCargo do funcionário deve constar na lista de cargos disponíveis. Seu idCargo será definido como 'programador'");
            this.cargo = cargosDisponiveis[2];
        }
    }

    // Getters e setters

    // Nome
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        if (!nome.isBlank()){
            this.nome = nome;
        } else {
            System.out.println("O nome do funcionário não pode ser nulo ou vazio. Seu nome será atribuído como 'Funcionario'");
            this.nome = "Funcionario";
        }
    }

    // Salário
    public double getSalario(){
        return salario;
    }

    public void setSalario(double salario){
        if (salario > 1320){
            this.salario = salario;
        } else {
            System.out.println("O salário do funcionário não pode ser menor do que R$1320,00.");
        }
    }

    // Cargo
    public String getCargo(){
        return cargo;
    }

    public void setCargo(int idCargo){
        if (idCargo < cargosDisponiveis.length + 1 && idCargo <= 1) {
            this.cargo = cargosDisponiveis[idCargo];
        } else {
            System.out.println("O idCargo do funcionário deve constar na lista de cargos disponíveis. Seu idCargo será definido como 'programador'");
            this.cargo = cargosDisponiveis[2];
        }
    }

    // Funções

    public void aumentarPercentual(float percentagem){
        if(percentagem > 0) {
            salario += percentagem /100 * salario;
            System.out.printf("Foi aumentado " + percentagem + " por cento ao salário do funcionário " + this.nome + ". O novo salário é R$%,.2f\n", salario);
        } else {
            System.out.println("O percentagem a ser aumentado não pode ser negativo.");
        }
    }

    @Override
    public String toString() {
        return  "Nome do funcionário: " + nome + "\n" +
                "Salário: " + salario + "\n" +
                "Cargo: " + cargo + "\n";
    }
}
