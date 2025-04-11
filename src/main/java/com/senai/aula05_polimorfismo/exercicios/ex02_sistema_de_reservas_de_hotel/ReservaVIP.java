package com.senai.aula05_polimorfismo.exercicios.ex02_sistema_de_reservas_de_hotel;

public class ReservaVIP extends Reserva{
    private double impostoImportacao;

    public ReservaVIP(String cliente, double custoTotal, double impostoImportacao) {
        super(cliente, custoTotal);
        this.impostoImportacao = impostoImportacao;
    }

    public double getImpostoImportacao() {
        return impostoImportacao;
    }

    public void setImpostoImportacao(double impostoImportacao) {
        this.impostoImportacao = impostoImportacao;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.printf("""
                 | Desconto: R$%,.2f
                 | Custo total: R$%,.2f
                """, impostoImportacao, getCustoOriginal() - impostoImportacao);
    }
}
