package com.hidalgosoft.municipios.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ServiciosGeorefId.class)
@Data
public class ServiciosGeoref {

    @Id
    @Column(name ="municipio_id" )
    private Long municipioId;

    @Id
    private String aplicacion;

    @Column(name = "bd_file")
    private String bdFile;

}
