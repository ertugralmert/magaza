package com.mert.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {
    BAD_REQUEST_ERROR(1001, "Girilen Bilgiler eksik ya da yanlıştır", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR(9998, "Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    DATA_NOT_FOUND(1002, "Veri bulunamadı", HttpStatus.NOT_FOUND),
    VALIDATION_ERROR(1003, "Validasyon hatası", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED_ERROR(1004, "Yetkisiz erişim", HttpStatus.UNAUTHORIZED),
    FORBIDDEN_ERROR(1005, "Erişim yasaklandı", HttpStatus.FORBIDDEN),
    CONFLICT_ERROR(1006, "Çakışma hatası", HttpStatus.CONFLICT);

    private Integer code;
    private String message;
    private HttpStatus httpStatus;
}
