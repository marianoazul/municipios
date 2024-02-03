package com.hidalgosoft.municipios.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pais")
@Data
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

}