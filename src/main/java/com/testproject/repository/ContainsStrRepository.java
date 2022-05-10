package com.testproject.repository;

import com.testproject.model.StrModel;
import org.springframework.data.repository.CrudRepository;

public interface ContainsStrRepository extends CrudRepository<StrModel, Integer> {
}
