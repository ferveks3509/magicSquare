package com.testproject.repository;

import com.testproject.model.MagicSquareModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface MagicSquareRepository extends CrudRepository<MagicSquareModel, Integer> {

    @Query(value = "SELECT * FROM MAGIC_SQUARE WHERE created = ?1", nativeQuery = true)
    List<MagicSquareModel> findByCreated(String localDate);

}
