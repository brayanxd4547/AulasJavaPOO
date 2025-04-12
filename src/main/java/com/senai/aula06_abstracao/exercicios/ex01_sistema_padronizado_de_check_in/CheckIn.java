package com.senai.aula06_abstracao.exercicios.ex01_sistema_padronizado_de_check_in;

public interface CheckIn {
    float PESO_MAX_NACIONAL = 120;
    float PESO_MAX_INTERNACIONAL = 150;

    void validarDocumentos(String cliente);
    void emitirCartoesDeEmbarque(String cliente);
    void exibirBoasVindasCompanhia();

    static void exibirBoasVindas() {
        System.out.println("Bem-vindo! Check-in seguro realizado pela FlySecure. Desejamos uma boa viagem.");
    }

    default void realizarCheckIn(String cliente, boolean vooInternacional, float pesoBagagem) {
        System.out.println("FlySecure - Seja bem-vindo, " + cliente + ", ao check-in para voos " + (vooInternacional ? "internacionais." : "nacionais."));
        validarDocumentos(cliente);
        emitirCartoesDeEmbarque(cliente);
        verificarBagagem(vooInternacional, pesoBagagem);
    }

    private void verificarBagagem(boolean vooInternacional, float pesoBagagem) {
        System.out.println("Verificando peso da bagagem...");
        float pesoMaximo = vooInternacional ? PESO_MAX_INTERNACIONAL : PESO_MAX_NACIONAL;

        if (pesoBagagem > pesoMaximo) {
            System.out.println("A bagagem ultrapassa o limite de peso estabelecido pela FlySecure de " + pesoMaximo + " kg.");
        } else {
            System.out.println("A bagagem valida o protocolo da FlySecure por ter peso igual ou inferior a " + pesoMaximo + " kg.");
        }
    }
}
