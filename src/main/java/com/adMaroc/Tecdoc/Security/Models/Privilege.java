package com.adMaroc.Tecdoc.Security.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Privilege_id")
    private Long id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "privileges")
    @JsonIgnore
    private List<Role> roles;


}
