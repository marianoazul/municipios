package com.hidalgosoft.municipios.repository;

import com.hidalgosoft.municipios.entity.Municipio;
import com.hidalgosoft.municipios.entity.ServiciosGeoref;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiciosGeorefRepository extends JpaRepository<ServiciosGeoref, Long> {

    List<ServiciosGeoref> findByMunicipioIdAndAplicacion(Long municipioId, String aplicacion);
}
