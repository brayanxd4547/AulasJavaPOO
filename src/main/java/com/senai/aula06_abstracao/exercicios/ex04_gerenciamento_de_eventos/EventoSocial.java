package com.senai.aula06_abstracao.exercicios.ex04_gerenciamento_de_eventos;

public class EventoSocial implements EventoEmJogos{
    public void mensagemPreEvento(){
        System.out.println("Sejam bem-vindos, candidatos e telespectadores! Começará em breve o evento social da GameMasters! ");
        System.out.println("Aproveitem para assistirem partidas competitivas e interagirem! Pontos são acumulados para os jogadores que vencerem mais partidas. Os três participantes com mais pontos ganham prêmios!");
    }
}
