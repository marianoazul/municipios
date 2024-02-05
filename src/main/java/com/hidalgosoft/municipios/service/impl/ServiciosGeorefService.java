package com.hidalgosoft.municipios.service.impl;

import com.hidalgosoft.municipios.configuration.ConstantQuery;
import com.hidalgosoft.municipios.entity.ServiciosGeoref;
import com.hidalgosoft.municipios.model.response.ApiResponse;
import com.hidalgosoft.municipios.model.response.EstadoDTO;
import com.hidalgosoft.municipios.model.response.MunicipioDTO;
import com.hidalgosoft.municipios.repository.EstadoRepository;
import com.hidalgosoft.municipios.repository.MunicipioRepository;
import com.hidalgosoft.municipios.repository.ServiciosGeorefRepository;
import com.hidalgosoft.municipios.service.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ServiciosGeorefService {

    @Autowired
    private ServiciosGeorefRepository repository;

    @Autowired
    private SQLService sqlService;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    public ApiResponse<Object> findByMunicipioIdAndAplicacion(Long municipioId, String aplicacion) {
        List<ServiciosGeoref> serviciosGeorefencia = repository.findByMunicipioIdAndAplicacion(municipioId, aplicacion);
        ServiciosGeoref fileProperties = serviciosGeorefencia.get(0);
        return sqlService.performDatabaseOperations(fileProperties.getBdFile(), ConstantQuery.OBTENER_MENU);
    }


    public ApiResponse<List<EstadoDTO>> findByServiciosGeorefAplicacion(String aplicacion) {
        List<Object[]> results = estadoRepository.findByServiciosGeorefAplicacion(aplicacion);
        return ApiResponse.ok(results.stream()
                .map(row -> EstadoDTO.builder()
                        .estadoId((BigInteger) row[0])
                        .estado((String) row[1])
                        .build())
                .collect(Collectors.toList()));
    }

    public ApiResponse<List<MunicipioDTO>> findByServiciosGeorefAplicacion(Long estadoId, String aplicacion) {
        List<Object[]> results = municipioRepository.findByEstadoIdAndServiciosGeorefAplicacion(estadoId, aplicacion);
        return ApiResponse.ok(results.stream()
                .map(row -> MunicipioDTO.builder()
                        .municipioId((BigInteger) row[0])
                        .municipio((String) row[1])
                        .build())
                .collect(Collectors.toList()));

    }

}
