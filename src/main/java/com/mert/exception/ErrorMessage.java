package com.mert.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data //
@AllArgsConstructor //
@NoArgsConstructor // parametreli constructor ların tümü
@Builder //default constructor
public class ErrorMessage {
    private Integer code;
    private String message;
    private List<String> fields;

    /**
     * fileds dediğimiz durum String password: @Valid, min=8, max=32 Enaz bir Büyük Hard,Bir küçük Harf, özel karakter
     */
}
