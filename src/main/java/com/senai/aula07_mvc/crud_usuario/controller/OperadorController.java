package com.senai.aula07_mvc.crud_usuario.controller;

import com.senai.aula07_mvc.crud_usuario.model.Operador;
import com.senai.aula07_mvc.crud_usuario.model.OperadorDAO;

import java.util.List;

public class OperadorController {
    private OperadorDAO operadorDAO = new OperadorDAO();

    public List<Operador> listarOperadores() {
        return OperadorDAO.listar();
    }

    public boolean cadastrarOperador (Operador op){
        if (op != null){
            operadorDAO.salvar(op);
            return true;
        } else
            return false;
    }

    public boolean atualizarOperador (Operador op) {
        if (op != null){
            operadorDAO.atualizar(op);
            return true;
        } else
            return false;
    }

    public boolean deletarOperador (int id) {
        if (id >= 0) {
            operadorDAO.deletar(id);
            return true;
        } else
            return false;
    }
}
