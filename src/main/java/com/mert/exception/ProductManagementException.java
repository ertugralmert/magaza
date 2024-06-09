package com.mert.exception;

import lombok.Getter;

/**
 * Bir sınıfın Exception sınıfı olarak görev yapabilmesi için Exception ya da RuntimeException'dan
 * miras alması gerekir.
 * Eğer hata mesajını fırlatmak ve iletmek istiyorsanız miras aldığımız sınıfın
 * constructor'una (super) ile ilgili mesajınmızı iletiyoruz.
 *
 *
 */
@Getter
public class ProductManagementException extends RuntimeException {
    private ErrorType errorType;

    public ProductManagementException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = getErrorType();

    }
    }

