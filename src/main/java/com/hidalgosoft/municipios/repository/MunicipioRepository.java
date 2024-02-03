package com.hidalgosoft.municipios.repository;

import com.hidalgosoft.municipios.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

    @Query(value = "SELECT m.id AS municipio_id, m.nombre AS municipio " +
            "FROM municipio m " +
            "WHERE m.estado_id = :estadoId " +
            "AND m.id IN (SELECT sg.municipio_id FROM servicios_georef sg WHERE sg.aplicacion = :aplicacion)",
            nativeQuery = true)
    List<Object[]> findByEstadoIdAndServiciosGeorefAplicacion(Long estadoId, String aplicacion);
}