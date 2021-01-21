package com.adMaroc.Tecdoc.Security.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author Ali Belemlih
 * Entity Role, with getter and setters. Represents the role of the user.
 * There is a Many to Many relationship with entity @see User
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private List<Privilege> privileges;

    public Role(String name){
        this.name="name";
    }

}
