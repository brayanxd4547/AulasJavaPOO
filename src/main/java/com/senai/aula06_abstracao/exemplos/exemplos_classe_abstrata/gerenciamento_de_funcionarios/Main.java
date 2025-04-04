package com.senai.aula06_abstracao.exemplos.exemplos_classe_abstrata.gerenciamento_de_funcionarios;

public class Main {
    public static void main(String[] args) {
    testarPagamento(new FuncionarioEfetivo("Leonardo", 30000, 120));
    testarPagamento(new FuncionarioTemporario("Josafa", 2000,200, 300));
    }

    public static void testarPagamento(Funcionario funcionario) {
        System.out.println(" - Testando pagamento dos funcionarios - ");
        funcionario.exibirDados();
        funcionario.aumentarSalario(10);
        funcionario.exibirDados();
        funcionario.calcularBonus();
        funcionario.exibirDados();
    }

}


