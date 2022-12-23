package com.example.PropertyManagement.repository;

import com.example.PropertyManagement.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
  //  PropertyEntity save(PropertyEntity propertyEntity);
}
