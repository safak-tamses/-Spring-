package com.safakTamses.cityService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class city {
    private Date createDate;
    private String id;
    private String name;

}
