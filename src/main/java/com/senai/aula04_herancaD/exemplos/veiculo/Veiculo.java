package com.senai.aula04_herancaD.exemplos.veiculo;

public class Veiculo {
    private String marca;
    private int ano;

    public Veiculo(String marca, int ano) {
        this.marca = marca;
        this.ano = ano;
    }

    // Getter e setter de marca

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Getter e setter de ano

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    // Métodos

    public void exibirDetalhes(){
        System.out.print(
                "Marca: " + marca + '\n' +
                "Ano: " + ano + '\n'
        );
    }
}
