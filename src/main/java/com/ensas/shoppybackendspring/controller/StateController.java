package com.ensas.shoppybackendspring.controller;

import com.ensas.shoppybackendspring.dtos.StateDto;
import com.ensas.shoppybackendspring.services.imp.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class StateController {

    private final StateService stateService;

    @GetMapping("/search/countryCode")
    public ResponseEntity<List<StateDto>> getStateByCountryCode(
            @RequestParam(name = "cc",defaultValue = "") String countryCode){
        return new ResponseEntity<>(stateService.findByCountryCode(countryCode), HttpStatus.OK);
    }

}
