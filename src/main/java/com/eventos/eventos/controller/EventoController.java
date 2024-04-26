package com.eventos.eventos.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eventos.eventos.entities.Evento;
import com.eventos.eventos.services.abstrac_service.IEventoService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;



@RestController //Estudiar
@AllArgsConstructor
@RequestMapping("api/v2/evento") //Api + el versionamiento de la appi + evento
public class EventoController {

    @Autowired
    private final IEventoService eventoService; //Es un atribuuto de     

    //Método 
    //ResponseEntity: Muestra el status 
    @PostMapping
    public ResponseEntity<Evento>guardar(@RequestBody Evento objEvento){

        //Validaciónes 
        int capacidadEvento = objEvento.getCapacidad();
        LocalDate fecha = objEvento.getFecha();

        if (capacidadEvento < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        if (fecha.isBefore(LocalDate.now())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.ok(this.eventoService.guardar(objEvento));
    }

    @GetMapping
    public ResponseEntity<Page<Evento>>listarEventos( 
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "3") int size){
        Page<Evento> ListaDeEventos = this.eventoService.listarEventos(page-1,size);
        return ResponseEntity.ok(ListaDeEventos);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Evento>buscarPorId(@PathVariable String id){
        Evento objEvento = this.eventoService.findById(id);

        return ResponseEntity.ok(objEvento);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String>eliminarEvento(@PathVariable String id){
        Boolean validacion = this.eventoService.eliminar(id);
        if(validacion == true){
            return ResponseEntity.ok("Eliminando correctamente");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El evento con el ID" + id + " no ha sido encontrado");
        }
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<Evento>actualizarEvento(@PathVariable String id, @RequestBody Evento objEvento){
        
        objEvento.setId(id);
        Evento evento = this.eventoService.actualizar(objEvento);

        return ResponseEntity.ok(evento);
    }
}
