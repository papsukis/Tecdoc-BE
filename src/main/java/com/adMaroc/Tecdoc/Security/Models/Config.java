package com.adMaroc.Tecdoc.Security.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="config")
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="config_id")
    private long id;

    private String name;

    private String stringValue;

    @Column(nullable = true)
    private Date dateValue;
    @Column(nullable = true)
    private Long numberValue;
    @Column(nullable = true)
    private Boolean booleanValue;
}
