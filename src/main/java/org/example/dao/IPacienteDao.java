package org.example.dao;

import java.util.List;

public interface IPacienteDao <T> {

    public T buscar(Long id);
    public T crear(T t);
    public void eliminar(Long id);
    public List<T> listarTodos();



}
