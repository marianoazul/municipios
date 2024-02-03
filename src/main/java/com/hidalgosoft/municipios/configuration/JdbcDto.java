package com.hidalgosoft.municipios.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.PackagePrivate;

@Data
@PackagePrivate
@AllArgsConstructor
public class JdbcDto {
    String urlBD;
    String userBD;
    String passwordDB;
}
