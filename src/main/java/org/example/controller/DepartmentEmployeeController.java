package org.example.controller;

import org.example.dto.DepartmentEmployeeDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.service.DepartmentEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departmentEmployees")
public class DepartmentEmployeeController {
    @Autowired
    private DepartmentEmployeeService service;

    @GetMapping
    public ResponseEntity<List<DepartmentEmployeeDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentEmployeeDto> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DepartmentEmployeeDto> save(@RequestBody DepartmentEmployeeDto dto) {
        try {
            return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<DepartmentEmployeeDto> update(@RequestBody DepartmentEmployeeDto dto) {
        try {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DepartmentEmployeeDto> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
