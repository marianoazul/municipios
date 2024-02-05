package com.hidalgosoft.municipios.service;

import com.hidalgosoft.municipios.model.response.ApiResponse;

import java.util.List;
import java.util.Map;

public interface SQLService {
    ApiResponse<Object> performDatabaseOperations(String file, String sqlQuery);

    void performDatabaseOperations2(String file);
}
