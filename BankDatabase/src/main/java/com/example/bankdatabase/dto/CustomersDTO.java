package com.example.bankdatabase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomersDTO {

    private String firstname;

    private String lastname;

    private String phonenumber;

    private Integer branchs_id;

}
