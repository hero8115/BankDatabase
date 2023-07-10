package com.example.bankdatabase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchsDTO {

    private String name;

    private Date created_at;

    private Double branchs_amount;

    private String city;

    private String street;

    private Integer bank_id;

}
