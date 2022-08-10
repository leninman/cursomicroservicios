package com.cursomicroservicios.serviciousuarios.models.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    @Column(name="created_at")
    private LocalDate createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt= LocalDate.now();
    }




}
