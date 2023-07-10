package com.example.bankdatabase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardDTO {

    private Double balance;

    private Integer number;

    private Date lifetime;

    private Integer customer_id;
}
