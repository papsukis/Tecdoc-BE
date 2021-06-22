package com.adMaroc.Tecdoc.BackOffice.Repository;


import  com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.Header;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderRepository extends JpaRepository<Header, Long> {


}
