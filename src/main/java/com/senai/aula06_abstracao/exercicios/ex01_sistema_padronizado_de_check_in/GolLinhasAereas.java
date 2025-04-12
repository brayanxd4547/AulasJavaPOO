package com.senai.aula06_abstracao.exercicios.ex01_sistema_padronizado_de_check_in;

public class GolLinhasAereas implements CheckIn {
    public void exibirBoasVindasCompanhia() {
        System.out.println("Gol Linhas Aéreas - Voe Gol");
        CheckIn.exibirBoasVindas();
    }

    public void validarDocumentos(String cliente) {
        System.out.println("A Gol Linhas Aéreas está verificando seu RG e passaporte.");
        System.out.println("Documentos válidos!");
    }

    public void emitirCartoesDeEmbarque(String cliente) {
        System.out.println("Cartões de embarque emitidos pela Gol Linhas Aéreas com êxito!");
    }
}
