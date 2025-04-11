package com.senai.aula05_polimorfismo.exercicios.ex03_gestao_de_produtos;

public class ProdutoFisico extends Produto {
    private double impostoImportacao;

    public ProdutoFisico(String cliente, double custoTotal, double impostoImportacao) {
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
                 | Imposto de importação: %.1f%%
                 | Custo total: R$%,.2f
                """, impostoImportacao, getCustoOriginal() * (1 + impostoImportacao/100));
    }
}
