package com.SpringBootMVC.Homework.Department.service;

import com.SpringBootMVC.Homework.Department.dto.DepartmentDto;
import com.SpringBootMVC.Homework.Department.exceptions.ResourceNotFoundException;
import com.SpringBootMVC.Homework.Department.repository.DepartmentRepository;
import com.SpringBootMVC.Homework.Department.entity.DepartmentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
    @Autowired
    ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDto> findAll() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();

        return departmentEntities.stream()
                .map(departmentEntity ->
                        modelMapper.map(departmentEntity, DepartmentDto.class))
                .collect(Collectors.toList());
    }

    public DepartmentDto save(DepartmentDto departmentDto) {
        DepartmentEntity departmentEntity = departmentRepository.save(modelMapper.map(departmentDto, DepartmentEntity.class));
        return modelMapper.map(departmentEntity, DepartmentDto.class);
    }

    public DepartmentDto getDepartmentById(int id) {
        return modelMapper.map(departmentRepository.findById(id).orElse(null), DepartmentDto.class);
    }

    public void deleteDepartmentById(int id) {
        departmentRepository.deleteById(id);
    }


    public DepartmentDto updateDepartmentById(DepartmentDto departmentDto, int id) throws ResourceNotFoundException {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDto, DepartmentEntity.class);
        if (departmentRepository.existsById(id)) {
            return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDto.class);
        } else {
            throw new ResourceNotFoundException("Department ID does not found: " + id);
        }
    }
}
