package com.senai.aula06_abstracao.exercicios.ex04_gerenciamento_de_eventos;

public interface EventoEmJogos {
    String[] PREMIACAO = {"Troféu Gamer do Mês - GameMasters", "Medalha de prata - GameMasters", "Medalha de bronze - GameMasters"};
    int TEMPO_LIMITE = 120;

    default void iniciarEvento() {
        int integridadeEvento = 0;
        while(integridadeEvento <= 1) {
            System.out.println("Analisando os candidatos e informações do evento...");
            integridadeEvento = validarEvento(integridadeEvento);
        }

        System.out.println("Evento iniciado! Boa sorte a todos os participantes!");
        System.out.println("____________________________________________________________________________________");
    }

    default void encerrarEvento() {
        System.out.println("____________________________________________________________________________________");
        System.out.printf("O tempo-limite de %d minutos foi esgotado! Bom jogo a todos os participantes. Vamos para a tabela definir os vencedores!\n", TEMPO_LIMITE);
    }

    default void aumentarPontuacao(String participante, int acrescimo){
        System.out.printf("O participante %s adquiriu %d pontos!\n", participante, acrescimo);
    }

    default void premiarParticipantes(String p1, String p2, String p3) {
        System.out.printf("""
                 * Parabéns, %s, %s e %s! A premiação para cada um no pódio será...
                 | %s: %s
                 | %s: %s
                 | %s: %s
                """, p1, p2, p3, p1, PREMIACAO[0], p2, PREMIACAO[1], p3, PREMIACAO[2]);
    }

    private int validarEvento(int integridadeEvento){
        if (integridadeEvento >= 1) {
            System.out.println("O evento consta com os padrões exigidos pela GameMasters.");
        } else {
            System.out.println("O evento dispõe de incongruências que precisam ser corrigidas. Aguardem até a realização do evento.");
        }
        return integridadeEvento + 1;
    }
}
