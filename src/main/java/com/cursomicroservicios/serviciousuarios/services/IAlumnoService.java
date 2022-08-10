package com.cursomicroservicios.serviciousuarios.services;

import com.cursomicroservicios.serviciousuarios.models.entity.Alumno;

import java.util.Optional;

public interface IAlumnoService {

    public Iterable<Alumno> findAll();

    public Optional<Alumno> findById(Long id);

    public Alumno save(Alumno alumno);

    public void deleteById(Long id);

}
