package com.cursomicroservicios.serviciousuarios.models.repositories;

import com.cursomicroservicios.serviciousuarios.models.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno,Long> {
}
