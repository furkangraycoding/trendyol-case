package com.converter.TrendyolCaseFurkanGurcay.controller;

import com.converter.TrendyolCaseFurkanGurcay.dto.LoggerDTO;
import com.converter.TrendyolCaseFurkanGurcay.model.Logger;
import com.converter.TrendyolCaseFurkanGurcay.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class LoggerController {

    LoggerService loggerService;


    @Autowired
    public LoggerController(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @PostMapping("/logs")
    public Logger saveLogs(@RequestBody LoggerDTO loggerDTO){
        return loggerService.save(loggerDTO);

    }

    @GetMapping("/logs")
    public ResponseEntity<List<Logger>> getAllLogs(){
        return new ResponseEntity<>(loggerService.findAll(), HttpStatus.OK);
    }

}
