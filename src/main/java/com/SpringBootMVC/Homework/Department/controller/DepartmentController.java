package com.SpringBootMVC.Homework.Department.controller;

import com.SpringBootMVC.Homework.Department.dto.DepartmentDto;
import com.SpringBootMVC.Homework.Department.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentDto> getDepartments() {
        return departmentService.findAll();
    }

    @PostMapping(path = "/save")
    public DepartmentDto postDepartments(@RequestBody  @Valid DepartmentDto departmentDto) {
        return departmentService.save(departmentDto);
    }

    @GetMapping(path = "/{id}")
    public DepartmentDto getDepartmentById(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteDepartmentById(@PathVariable int id) {
        departmentService.deleteDepartmentById(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DepartmentDto> putDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable int id) throws Exception {
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentDto, id));
    }
}
