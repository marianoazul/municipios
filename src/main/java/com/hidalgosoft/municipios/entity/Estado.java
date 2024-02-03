package com.hidalgosoft.municipios.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "estado")
@Data
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "abreviatura", length = 10, nullable = false)
    private String abreviatura;

    @Column(name = "clave", nullable = false)
    private Integer clave;


}
