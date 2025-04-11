package com.senai.aula05_polimorfismo.exercicios.ex03_gestao_de_produtos;

public class ProdutoServico extends Produto {
    private double impostoServico;

    public ProdutoServico(String cliente, double custoTotal, double impostoServico) {
        super(cliente, custoTotal);
        this.impostoServico = impostoServico;
    }

    public double getImpostoServico() {
        return impostoServico;
    }

    public void setImpostoServico(double impostoServico) {
        this.impostoServico = impostoServico;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.printf("""
                 | Imposto de importação: %.1f%%
                 | Custo total: R$%,.2f
                """, impostoServico, getCustoOriginal() * (1 + impostoServico /100));
    }
}
