package com.hidalgosoft.municipios.service.impl;

import com.hidalgosoft.municipios.service.ReadFileService;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class ReadFileServiceImpl implements ReadFileService {
    @Override
    public Map<String, String> readFileProperties(String filePath) {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;

        Map<String, String> propertiesBD = null;
        try {
            propertiesBD = new HashMap<>();
            // Cargar el archivo de propiedades
            fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);

            // Obtener valores de las propiedades
            String valor1 = properties.getProperty("dataSource.url");
            String valor2 = properties.getProperty("dataSource.username");
            String valor3 = properties.getProperty("dataSource.password");
            propertiesBD.put("URL", valor1);
            propertiesBD.put("USER", valor2);
            propertiesBD.put("PASSWORD", valor3);

            // Puedes hacer lo que quieras con los valores, por ejemplo, imprimirlos
            System.out.println("Valor de propiedad1: " + valor1);
            System.out.println("Valor de propiedad2: " + valor2);
            System.out.println("Valor de propiedad3: " + valor3);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el FileInputStream en el bloque finally para asegurar que se cierre
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return propertiesBD;
    }
}

