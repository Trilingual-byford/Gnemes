package com.example.moduleone.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SinHysNmtRrkInfoOutDto {

    private SinHysNmtRrkInfoResultDto result;

    private List<ErrorInfoDto> errors;
}
