package com.adMaroc.Tecdoc.BackOffice.Repository;

import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.KeyTablesEntries;
import com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys.KeyTablesEntriesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyTablesEntriesRepository extends JpaRepository<KeyTablesEntries, KeyTablesEntriesId> {


}
