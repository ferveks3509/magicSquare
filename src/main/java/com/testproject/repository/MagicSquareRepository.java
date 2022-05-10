package com.testproject.repository;

import com.testproject.model.MagicSquareModel;
import org.springframework.data.repository.CrudRepository;

public interface MagicSquareRepository extends CrudRepository<MagicSquareModel, Integer> {

}
