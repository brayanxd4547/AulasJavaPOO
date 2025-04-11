package com.senai.aula05_polimorfismo.exercicios.ex03_gestao_de_produtos;

public class ProdutoDigital extends Produto {
    private double impostoComissao;

    public ProdutoDigital(String cliente, double custoTotal, double impostoComissao) {
        super(cliente, custoTotal);
        this.impostoComissao = impostoComissao;
    }

    public double getImpostoComissao() {
        return impostoComissao;
    }

    public void setImpostoComissao(double impostoComissao) {
        this.impostoComissao = impostoComissao;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.printf("""
                 | Imposto de importação: %.1f%%
                 | Custo total: R$%,.2f
                """, impostoComissao, getCustoOriginal() * (1 + impostoComissao /100));
    }
}
