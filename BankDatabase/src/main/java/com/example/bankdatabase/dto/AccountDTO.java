package com.example.bankdatabase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDTO {

    private Double balance;

    private String currency;

    private Date created_at;

    private Integer customer_id;
}
