package com.example.demo2.controller;

import com.example.demo2.response.BaseResponse;
import com.example.demo2.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @PostMapping
    public BaseResponse savePersona(@RequestParam String dni){
        return personaService.savePersona(dni);
    }
}
