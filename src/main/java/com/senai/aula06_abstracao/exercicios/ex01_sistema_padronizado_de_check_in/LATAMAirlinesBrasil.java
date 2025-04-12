package com.senai.aula06_abstracao.exercicios.ex01_sistema_padronizado_de_check_in;

public class LATAMAirlinesBrasil implements CheckIn {
    public void exibirBoasVindasCompanhia() {
        System.out.println("LATAM Airlines Brasil - Sem fronteiras");
        CheckIn.exibirBoasVindas();
    }

    public void validarDocumentos(String cliente) {
        System.out.println("A LATAM está verificando seu RG e passaporte.");
        System.out.println("Documentos válidos!");
    }

    public void emitirCartoesDeEmbarque(String cliente) {
        System.out.println("Cartões de embarque emitidos pela LATAM com êxito!");
    }
}
