package com.adMaroc.Tecdoc.BackOffice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class x3Article {

    String ref;
    String designation;
    String statut;
    String famille;
    String marque;
    int stock;
    int enComande;
    float pvp;
}
