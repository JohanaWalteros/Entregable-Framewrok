package com.eventos.eventos.services.abstrac_service;

import org.springframework.data.domain.Page;

import com.eventos.eventos.entities.Evento;

public interface IEventoService {

    public Evento guardar(Evento objEvento);
    //public List<Evento> listarEventos();
    public Evento findById(String id);
    public Evento actualizar(Evento objEvento);
    public boolean eliminar(String id);
    public Page<Evento> listarEventos(int Page, int size);

    //4. Crear IEventos
}
