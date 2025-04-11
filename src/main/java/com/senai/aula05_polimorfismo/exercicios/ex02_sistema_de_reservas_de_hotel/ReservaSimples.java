package com.senai.aula05_polimorfismo.exercicios.ex02_sistema_de_reservas_de_hotel;

public class ReservaSimples extends Reserva{
    private double taxaServico;

    public ReservaSimples(String cliente, double custoTotal, double taxaServico) {
        super(cliente, custoTotal);
        this.taxaServico = taxaServico;
    }

    public double getTaxaServico() {
        return taxaServico;
    }

    public void setTaxaServico(double taxaServico) {
        this.taxaServico = taxaServico;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.printf("""
                 | Taxa de serviço: R$%,.2f
                 | Custo total: R$%,.2f
                """, taxaServico, getCustoOriginal() + taxaServico);
    }
}
