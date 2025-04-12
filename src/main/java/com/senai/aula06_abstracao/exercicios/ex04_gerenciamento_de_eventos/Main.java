package com.senai.aula06_abstracao.exercicios.ex04_gerenciamento_de_eventos;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        EventoEmJogos eventoSocial = new EventoSocial();
        EventoEmJogos desafiosRelampagos = new DesafiosRelampagos();
        EventoEmJogos competicao = new Competicao();

        testarEventos(eventoSocial, new String[]{
                "Elisa Monteiro Dias",
                "Leonardo Takashi Ferreira",
                "Sofia Mendes",
                "Enzo Rocha Santiago",
                "Maya Alencar Diniz",
                "Tiago Souza Lima",
                "Antonella Schmidt Barbosa",
                "Gabriel Costa"
        });

        testarEventos(desafiosRelampagos, new String[]{
                "Valentina Ribeiro Duarte",
                "Caio Nakamura Batista",
                "Isabelle Nogueira",
                "Noah Silva Ferreira",
                "Luana Albuquerque Costa",
                "Yasmin Oliveira Martins",
                "Rafael Müller dos Santos",
                "Júlia Vasconcelos Rios"
        });

        testarEventos(competicao, new String[]{
                "Gabriel Costa",
                "Daniel Fernandes da Cunha",
                "Caio Nakamura Batista",
                "Elisa Monteiro Dias",
                "Leonardo Takashi Ferreira",
                "Sofia Mendes",
                "Enzo Rocha Santiago",
                "Maya Alencar Diniz",
                "Tiago Souza Lima",
                "Antonella Schmidt Barbosa",
                "Guilherme Ayres",
                "Lara Carvalho de Faria",
                "Nicolas Almeida Machado",
                "Helena Torres Gouveia",
                "Beatriz Takeda de Lima",
                "João Henrique Prado Souto",
                "Manuela Castro Tavares",
                "Valentina Ribeiro Duarte",
                "Isabelle Nogueira",
                "Noah Silva Ferreira",
                "Luana Albuquerque Costa",
                "Yasmin Oliveira Martins",
                "Rafael Müller dos Santos",
                "Júlia Vasconcelos Rios"
        });
    }

    public static void testarEventos(EventoEmJogos evento, String[] participantes) {
        System.out.println();

        if (evento instanceof EventoSocial eventoSocial) {
            eventoSocial.mensagemPreEvento();
        } else if (evento instanceof DesafiosRelampagos desafiosRelampagos) {
            desafiosRelampagos.definirRegras();
        } else if (evento instanceof Competicao competicao) {
            competicao.organizarCompeticao();
        }

        evento.iniciarEvento();
        evento.aumentarPontuacao(participantes[new Random().nextInt(participantes.length)], 10);
        evento.aumentarPontuacao(participantes[new Random().nextInt(participantes.length)], 10);
        evento.aumentarPontuacao(participantes[new Random().nextInt(participantes.length)], 10);
        evento.aumentarPontuacao(participantes[new Random().nextInt(participantes.length)], 10);
        evento.aumentarPontuacao(participantes[new Random().nextInt(participantes.length)], 10);
        evento.aumentarPontuacao(participantes[new Random().nextInt(participantes.length)], 10);
        evento.aumentarPontuacao(participantes[new Random().nextInt(participantes.length)], 10);
        evento.encerrarEvento();
        evento.premiarParticipantes(participantes[0], participantes[1], participantes[2]);
    }
}
