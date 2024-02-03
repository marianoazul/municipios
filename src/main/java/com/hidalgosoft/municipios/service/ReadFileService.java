package com.hidalgosoft.municipios.service;

import java.util.Map;

public interface ReadFileService {
    Map<String,String> readFileProperties(String filePath);
}
