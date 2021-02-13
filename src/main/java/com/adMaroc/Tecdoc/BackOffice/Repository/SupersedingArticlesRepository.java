package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.SupersedingArticles;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.SupersedingArticlesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupersedingArticlesRepository extends JpaRepository<SupersedingArticles, SupersedingArticlesId> {


}
