package com.hidalgosoft.municipios.service;

import java.util.List;
import java.util.Map;

public interface SQLService {
    Map<Object, List<Map<String, Object>>> performDatabaseOperations(String file, String sqlQuery);

    void performDatabaseOperations2(String file);
}
