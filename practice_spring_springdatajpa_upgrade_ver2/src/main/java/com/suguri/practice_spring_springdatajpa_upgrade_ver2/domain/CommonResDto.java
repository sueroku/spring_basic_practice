package com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class CommonResDto {

    private int statusCode;
    private String statusMessage;
    private Object result;

    public CommonResDto(HttpStatus httpStatus, String message, Object result){
        this.statusCode = httpStatus.value();
        this.statusMessage = message;
        this.result = result;
    }
}
