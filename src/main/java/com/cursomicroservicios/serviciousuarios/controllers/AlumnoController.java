package com.cursomicroservicios.serviciousuarios.controllers;
import com.cursomicroservicios.serviciousuarios.models.entity.Alumno;
import com.cursomicroservicios.serviciousuarios.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(alumnoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  ver(@PathVariable Long id){
        Optional<Alumno> o = alumnoService.findById(id);

        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(o.get());

    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno){
        Alumno alumnoDb=alumnoService.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
    }
    @PutMapping("/id")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno,@PathVariable Long id){
        Optional<Alumno> o =alumnoService.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Alumno alumnoDb=o.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumnoDb));

    }

    @DeleteMapping("/id")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        alumnoService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}
