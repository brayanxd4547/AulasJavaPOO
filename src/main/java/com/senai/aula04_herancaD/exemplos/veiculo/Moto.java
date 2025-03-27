package com.senai.aula04_herancaD.exemplos.veiculo;

public class Moto extends Veiculo {
    private boolean partidaEletrica;

    public Moto(String marca, int ano, boolean partidaEletrica) {
        super(marca, ano);
        this.partidaEletrica = partidaEletrica;
    }

    // Getter e setter de qtdPortas

    public boolean getPartidaEletrica() {
        return partidaEletrica;
    }

    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }

    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.print(
                "Possui partida elétrica? " + (partidaEletrica ? "Sim" : "Não") + '\n'
        );
    }
}
