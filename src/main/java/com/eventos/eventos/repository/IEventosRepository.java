package com.eventos.eventos.repository;

/*El repositorio se encarga de la persistencia de datos. La persistencia son
datos almacenados en una base de datos que se mantienen a lo largo del tiempo*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventos.eventos.entities.Evento;

//Jpa repository recibe dos parametros, el nombre de la tabla y el tipo de dato del id de la tabla 
@Repository

/*Interfaz: La interfaz es un contrato, define que puedo usar los métodos CRUD y otros 
de JPARepository
 * 
*/
public interface IEventosRepository extends JpaRepository<Evento,String>{


}
//3. Crear la carpeta Servicios