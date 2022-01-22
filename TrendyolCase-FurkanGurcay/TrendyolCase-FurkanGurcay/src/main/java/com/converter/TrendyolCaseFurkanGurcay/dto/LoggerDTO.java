package com.converter.TrendyolCaseFurkanGurcay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoggerDTO {
    private long id;

    private LocalDate throwDate;
    private String throwMessage;
    private int throwStatusCode;

}
