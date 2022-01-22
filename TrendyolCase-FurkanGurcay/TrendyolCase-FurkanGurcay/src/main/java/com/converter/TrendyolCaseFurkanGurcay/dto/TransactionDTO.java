package com.converter.TrendyolCaseFurkanGurcay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    private int id;
    private long creationDate;

    private String deepLinkObject;
    private String webUrlObject;
}


