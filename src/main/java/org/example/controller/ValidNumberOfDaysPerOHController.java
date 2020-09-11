package org.example.controller;

import org.example.dto.ProgramTypeDto;
import org.example.dto.ValidNumberOfDaysPerOHDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.service.ProgramTypeService;
import org.example.service.ValidNumberOfDaysPerOHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/validNumberOfDays")
public class ValidNumberOfDaysPerOHController {
    @Autowired
    private ValidNumberOfDaysPerOHService service;

    @GetMapping
    public ResponseEntity<List<ValidNumberOfDaysPerOHDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValidNumberOfDaysPerOHDto> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ValidNumberOfDaysPerOHDto> save(@RequestBody ValidNumberOfDaysPerOHDto dto) {
        try {
            return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<ValidNumberOfDaysPerOHDto> update(@RequestBody ValidNumberOfDaysPerOHDto dto) {
        try {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ValidNumberOfDaysPerOHDto> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CopOvertimeGenericException retEx) {
            retEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
