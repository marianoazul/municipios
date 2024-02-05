package com.hidalgosoft.municipios.service.impl;

import com.hidalgosoft.municipios.configuration.JdbcDto;
import com.hidalgosoft.municipios.model.response.ApiResponse;
import com.hidalgosoft.municipios.service.ReadFileService;
import com.hidalgosoft.municipios.service.SQLService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Log4j2
public class SQLServiceImpl implements SQLService {

    @Autowired
    private ReadFileService readFileService;
    @Override
    public ApiResponse<Object> performDatabaseOperations(String filePath, String sqlQuery) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        Map<String, String> propertiesDB = readFileService.readFileProperties(filePath);
        JdbcDto data = new JdbcDto(propertiesDB.get("URL"), propertiesDB.get("USER"), propertiesDB.get("PASSWORD"));
        String databaseURL = data.getUrlBD() + "?user=" + data.getUserBD() + "&password=" + data.getPasswordDB();

        try (Connection con = DriverManager.getConnection(databaseURL)) {
            System.out.println("Connected to the database");
            try (PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
                ResultSet resultSet = pstmt.executeQuery();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (resultSet.next()) {
                    // Crea un mapa para almacenar los datos de la fila
                    Map<String, Object> row = new HashMap<>();

                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object columnValue = resultSet.getObject(i);

                        row.put(columnName, columnValue);
                    }

                    resultList.add(row);
                }
            } catch (SQLException ex) {
                log.error(ex.getMessage());
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            return ApiResponse.error(ex.getMessage());
        }

        Map<Object, List<Map<String, Object>>> resultado = resultList.stream()
                .collect(Collectors.groupingBy(mapa -> mapa.get("tipo_servicio")));
        return ApiResponse.ok(resultado);
    }

    @Override
    public void performDatabaseOperations2(String file) {

    }
}
