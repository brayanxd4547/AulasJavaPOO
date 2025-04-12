package com.senai.aula06_abstracao.exercicios.ex01_sistema_padronizado_de_check_in;

public class AzulLinhasAereas implements CheckIn {


    public void exibirBoasVindasCompanhia() {
        System.out.println("Azul Linhas Aéreas - O Céu do Brasil é Azul");
        CheckIn.exibirBoasVindas();
    }

    public void validarDocumentos(String cliente) {
        System.out.println("A Azul Linhas Aéreas está verificando seu RG e passaporte.");
        System.out.println("Documentos válidos!");
    }

    public void emitirCartoesDeEmbarque(String cliente) {
        System.out.println("Cartões de embarque emitidos pela Azul Linhas Aéreas com êxito!");
    }
}
