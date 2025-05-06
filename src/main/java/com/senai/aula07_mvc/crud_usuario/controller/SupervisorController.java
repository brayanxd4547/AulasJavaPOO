package com.senai.aula07_mvc.crud_usuario.controller;

import com.senai.aula07_mvc.crud_usuario.model.OperadorDAO;
import com.senai.aula07_mvc.crud_usuario.model.Supervisor;
import com.senai.aula07_mvc.crud_usuario.model.SupervisorDAO;

import java.util.List;

public class SupervisorController {
    private SupervisorDAO supervisorDAO = new OperadorDAO();

    public List<Supervisor> listarSupervisores() {
        return supervisorDAO.listar();
    }

    public boolean cadastrarSupervisor (Supervisor sup){
        if (sup != null){
            supervisorDAO.salvar(sup);
            return true;
        } else
            return false;
    }

    public boolean atualizarSupervisor (Supervisor sup) {
        if (sup != null){
            supervisorDAO.atualizar(sup);
            return true;
        } else
            return false;
    }

    public boolean deletarOperador (int id) {
        if (id >= 0) {
            supervisorDAO.deletar(id);
            return true;
        } else
            return false;
    }
}
