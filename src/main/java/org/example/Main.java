package org.example;

import org.example.dao.PacientesDaoH2;
import org.example.model.Paciente;
import org.example.service.PacienteService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        PacienteService service= new PacienteService();
        service.setPacienteDao(new PacientesDaoH2());
       // service.buscarPaciente(12345678L);
        service.crearPaciente(new Paciente("a","b",56789123L));
        service.listarPacientes();
    }
}