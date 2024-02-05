package com.hidalgosoft.municipios.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.PackagePrivate;

@Data
@PackagePrivate
@AllArgsConstructor
public class ApiResponse<T> {
    boolean hasError;
    String message;
    T data;

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(false, "Operación exitosa", data);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(true, message, null);
    }
}
