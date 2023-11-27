package org.example.service;

import org.example.dao.IPacienteDao;
import org.example.model.Paciente;

import java.util.List;

public class PacienteService {

    private IPacienteDao<Paciente> pacienteDao;

    public IPacienteDao<Paciente> getPacienteDao() {
        return pacienteDao;
    }

    public void setPacienteDao(IPacienteDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public Paciente buscarPaciente(Long dni){
        return pacienteDao.buscar(dni);

    }

    public void eliminarPaciente (Long id){
        pacienteDao.eliminar(id);
    }

    public Paciente crearPaciente (Paciente paciente){

        return  pacienteDao.crear(paciente) ;

    }
    public List<Paciente> listarPacientes(){
        return pacienteDao.listarTodos();
    }

}
