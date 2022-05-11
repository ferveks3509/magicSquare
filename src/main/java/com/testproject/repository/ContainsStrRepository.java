package com.testproject.repository;

import com.testproject.model.ContainsStrModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContainsStrRepository extends CrudRepository<ContainsStrModel, Integer> {

    @Query(value = "SELECT * FROM STR_MODEL WHERE created =?1", nativeQuery = true)
    List<ContainsStrModel> findByCreated(String localDate);
}
