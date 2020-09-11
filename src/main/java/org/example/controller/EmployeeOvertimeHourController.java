package org.example.controller;

import org.example.dto.EmployeeOvertimeHourDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.service.EmployeeOvertimeHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/EmployeeOvertimeHours")
public class EmployeeOvertimeHourController {
    @Autowired
    private EmployeeOvertimeHourService service;

    @GetMapping
    public ResponseEntity<List<EmployeeOvertimeHourDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeOvertimeHourDto> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EmployeeOvertimeHourDto> save(@RequestBody EmployeeOvertimeHourDto dto) {
        try {
            return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<EmployeeOvertimeHourDto> update(@RequestBody EmployeeOvertimeHourDto dto) {
        try {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeOvertimeHourDto> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
