package com.adMaroc.Tecdoc.BackOffice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterDTO<T>{
    private String type;
    private String value ;
    private String label;
    private String target;
    private List<T> list;
}
