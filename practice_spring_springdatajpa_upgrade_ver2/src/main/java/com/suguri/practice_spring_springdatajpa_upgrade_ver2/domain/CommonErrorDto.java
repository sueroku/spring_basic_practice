package com.suguri.practice_spring_springdatajpa_upgrade_ver2.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class CommonErrorDto {
    private int statusCode;
    private String statusMessage;

    public CommonErrorDto(HttpStatus httpStatus, String message){
        this.statusCode = httpStatus.value();
        this.statusMessage = message;
    }
}
