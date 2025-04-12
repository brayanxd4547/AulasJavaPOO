package com.senai.aula06_abstracao.exercicios.ex04_gerenciamento_de_eventos;

public class Competicao implements EventoEmJogos{
    public void organizarCompeticao(){
        System.out.println("Sejam bem-vindos, candidatos e telespectadores! Começará em breve o evento competitivo da GameMasters! ");
        System.out.println("Será selecionado um jogo específico, e os jogadores serão organizados em duplas que competirão entre si! Após o mata-mata, 8 últimos competidores competirão para o pódio de três lugares. Quem ficar no pódio, ganhará prêmios inéditos!");
    }
}
