package com.hidalgosoft.municipios.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoDTO {
    private BigInteger estadoId;
    private String estado;
}
