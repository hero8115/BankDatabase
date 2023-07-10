package com.example.bankdatabase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanDTO {

    private Double amount;

    private Date date;

    private Integer account_id;

    private Integer branchs_id;

    private Integer year;
}
