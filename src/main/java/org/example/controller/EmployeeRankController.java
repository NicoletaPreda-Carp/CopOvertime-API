package org.example.controller;

import org.example.dto.EmployeeRankDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.service.EmployeeRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeeRanks")
public class EmployeeRankController {
    @Autowired
    private EmployeeRankService service;

    @GetMapping
    public ResponseEntity<List<EmployeeRankDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeRankDto> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EmployeeRankDto> save(@RequestBody EmployeeRankDto dto) {
        try {
            return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<EmployeeRankDto> update(@RequestBody EmployeeRankDto dto) {
        try {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeRankDto> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
