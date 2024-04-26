package com.eventos.eventos.services;
//Logica de negocio


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eventos.eventos.entities.Evento;
import com.eventos.eventos.repository.IEventosRepository;
import com.eventos.eventos.services.abstrac_service.IEventoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventosService implements IEventoService {

    //Inyeccion de dependencias 
    @Autowired
    private final IEventosRepository eventosRepository;

    @Override
    public Evento actualizar(Evento objEvento) {
        return this.eventosRepository.save(objEvento);
        
    }

    @Override
    public boolean eliminar(String id) {

        //Trae el objeto osea el JSON que haya con ese id que se ingreso
        Evento objEvento = this.findById(id);

        //Si el Json tiene datos con la info
        if (objEvento != null){
            this.eventosRepository.delete(objEvento);
            return true;
        }

        return false;
        
    }

    @Override
    public Evento findById(String id) {
        return this.eventosRepository.findById(id).orElse(null);
    }

    @Override
    public Evento guardar(Evento objEvento) {
        //Acceder a los métodos del JPA
        return this.eventosRepository.save(objEvento);
    }
/* 
    @Override
    public List<Evento> listarEventos() {
       return this.eventosRepository.findAll();
    }
*/
    @Override
    public Page<Evento> listarEventos(int Page, int size) {

        if (Page < 0) {
            Page = 1;
        }

        // Crear objeto de paginación
        Pageable objPageable = PageRequest.of(Page, size);

        return this.eventosRepository.findAll(objPageable);
    }
    
    //5. Crear EneventosServices
    //6. Crear Controller
}
