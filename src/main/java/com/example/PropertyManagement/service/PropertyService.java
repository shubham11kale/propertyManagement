package com.example.PropertyManagement.service;

import com.example.PropertyManagement.dto.PropertyDTO;

import java.util.List;


public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();

    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long id);

    PropertyDTO updateDescription(PropertyDTO propertyDTO, Long id);

    PropertyDTO updatePrice(PropertyDTO propertyDTO, Long id);

    void deleteProperty(Long id);
}
