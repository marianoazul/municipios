package com.hidalgosoft.municipios.controller;

import com.hidalgosoft.municipios.model.response.ApiResponse;
import com.hidalgosoft.municipios.model.response.EstadoDTO;
import com.hidalgosoft.municipios.model.response.MunicipioDTO;
import com.hidalgosoft.municipios.service.impl.ServiciosGeorefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/georeferencia")
public class ServiciosGeorefController {

    @Autowired
    private ServiciosGeorefService service;

    @GetMapping("/{municipioId}/{aplicacion}")
    public ResponseEntity<ApiResponse<Object>> getByMunicipioIdAndAplicacion(
            @PathVariable Long municipioId,
            @PathVariable String aplicacion) {

        return ResponseEntity.ok(service.findByMunicipioIdAndAplicacion(municipioId, aplicacion));
    }

    @GetMapping("estado/{aplicacion}")
    public ResponseEntity<ApiResponse<List<EstadoDTO>>> findByServiciosGeorefAplicacion(
            @PathVariable String aplicacion) {

        return ResponseEntity.ok(service.findByServiciosGeorefAplicacion(aplicacion));
    }

    @GetMapping("municipio/{estadoId}/{aplicacion}")
    public ResponseEntity<ApiResponse<List<MunicipioDTO>>> findByServiciosGeorefAplicacion(
            @PathVariable Long estadoId,
            @PathVariable String aplicacion) {

        return ResponseEntity.ok(service.findByServiciosGeorefAplicacion(estadoId, aplicacion));
    }
}
