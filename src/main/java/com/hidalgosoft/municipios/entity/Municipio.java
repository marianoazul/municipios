package com.hidalgosoft.municipios.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "municipio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "clave", length = 3, nullable = false)
    private String clave;

}