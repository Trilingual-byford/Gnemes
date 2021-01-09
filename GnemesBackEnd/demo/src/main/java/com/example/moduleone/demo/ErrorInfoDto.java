package com.example.moduleone.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorInfoDto {
    private String code;
    private String message;
    private String field;
}
