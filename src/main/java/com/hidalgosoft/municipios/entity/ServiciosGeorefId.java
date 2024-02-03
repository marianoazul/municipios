package com.hidalgosoft.municipios.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiciosGeorefId implements Serializable {

    private Long municipioId;
    private String aplicacion;

}
