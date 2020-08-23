package com.rc.assessment.test.playsafepart1.controller;

import com.rc.assessment.test.playsafepart1.model.Unit;
import com.rc.assessment.test.playsafepart1.service.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversions")
public class ConversionController {

    private final ConversionService conversionService;

    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @PostMapping("/ktoc")
    public ResponseEntity<Double> kelvinToCelsius(@RequestBody Unit kelvin){
        return new ResponseEntity<>(conversionService.ktoc(kelvin), HttpStatus.OK);
    }

    @PostMapping("/ctok")
    public ResponseEntity<Double> celsiusToKelvin(@RequestBody Unit celsius){
        return new ResponseEntity<>(conversionService.ctok(celsius), HttpStatus.OK);
    }

    @PostMapping("/mtok")
    public ResponseEntity<Double> mileToKilometer(@RequestBody Unit mile) throws Exception {
        return new ResponseEntity<>(conversionService.mtok(mile), HttpStatus.OK);
    }
}
