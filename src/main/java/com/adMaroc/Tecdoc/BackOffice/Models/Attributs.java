package com.adMaroc.Tecdoc.BackOffice.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attributs {

    private String name;
    private int pos;
    private int length;
    private String type;
    private String description;
}
