package com.example.PropertyManagement.service.impl;

import com.example.PropertyManagement.converter.PropertyConverter;
import com.example.PropertyManagement.dto.PropertyDTO;
import com.example.PropertyManagement.entity.PropertyEntity;
import com.example.PropertyManagement.repository.PropertyRepository;
import com.example.PropertyManagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe = propertyConverter.convertDTOToEntity(propertyDTO);
        pe = propertyRepository.save(pe);
        PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
        return dto;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> propertyList = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propertyListDTO = new ArrayList<>();
        for(PropertyEntity prt:propertyList){
            propertyListDTO.add(propertyConverter.convertEntityToDTO(prt));
        }
        return propertyListDTO;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> OpnEntity = propertyRepository.findById(propertyID);
        PropertyDTO dto = null;
        if(OpnEntity.isPresent()){
            PropertyEntity pe = OpnEntity.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setDescription(propertyDTO.getDescription());
            pe.setAddress(propertyDTO.getAddress());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setPrice(propertyDTO.getPrice());
            propertyRepository.save(pe);
            dto = propertyConverter.convertEntityToDTO(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updateDescription(PropertyDTO propertyDTO, Long id) {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(id);
        PropertyDTO dto = null;
        if(optEntity.isPresent()){
            PropertyEntity pe = optEntity.get();
            pe.setDescription(propertyDTO.getDescription());
            propertyRepository.save(pe);
            dto = propertyConverter.convertEntityToDTO(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePrice(PropertyDTO propertyDTO, Long id) {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(id);
        PropertyDTO dto = null;
        if(optEntity.isPresent()){
            PropertyEntity pe = optEntity.get();
            pe.setPrice(propertyDTO.getPrice());
            propertyRepository.save(pe);
            dto = propertyConverter.convertEntityToDTO(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
