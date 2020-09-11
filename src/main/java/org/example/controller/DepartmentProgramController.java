package org.example.controller;

import org.example.dto.DepartmentProgramDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.service.DepartmentProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departmentPrograms")
public class DepartmentProgramController {
    @Autowired
    private DepartmentProgramService service;

    @GetMapping
    public ResponseEntity<List<DepartmentProgramDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentProgramDto> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DepartmentProgramDto> save(@RequestBody DepartmentProgramDto dto) {
        try {
            return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<DepartmentProgramDto> update(@RequestBody DepartmentProgramDto dto) {
        try {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DepartmentProgramDto> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
