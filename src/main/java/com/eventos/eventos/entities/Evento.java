package com.eventos.eventos.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Anotaciones
@Entity(name = "evento") //Anotacion que identifica la clase evento en una entidad
@AllArgsConstructor //Constructor lleno
@NoArgsConstructor //Constructor vacio
@Data //Set y get 

public class Evento {
    
    @Id //Id de la llave primaria de la entidad
    /*  
     * @GeneratedValue: Generacion de valores para la llave primaria
     * (strategy = GenerationType.UUID): Definir la estrategia de generación 
     * GenerationType.UUID: Identificador unico universal, se generarar un codigo de 23 numeros
     * alfanumericos para cada nueva fila insertada 
    */
    @GeneratedValue(strategy = GenerationType.UUID)

    //Atributos
    private String id;
    private String nombre;
    private LocalDate fecha; 
    private String ubicacion; 
    private int capacidad; 

    //SIGUIENTE PASO. Crear la carpeta Repository
}
