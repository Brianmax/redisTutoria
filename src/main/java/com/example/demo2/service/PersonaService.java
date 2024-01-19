package com.example.demo2.service;

import com.example.demo2.entity.Persona;
import com.example.demo2.feing.DniClient;
import com.example.demo2.repository.PersonaRepository;
import com.example.demo2.response.BaseResponse;
import com.example.demo2.response.ResponseDni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Value("token.api.reniec")
    private String token;
    private ResponseDni responseDni;
    @Autowired
    private DniClient dniClient;
    public BaseResponse savePersona(String dni){
        responseDni = dniClient.getInfoDni(dni,"Bearer " + "apis-token-6977.0NI94rai6fpaHDPYFHnn0y0SOLtgFFja");
        if(responseDni == null){
            return new BaseResponse(400,"No se encontro el dni",null);
        }
        Persona persona = convertResponse(responseDni);
        personaRepository.save(persona);
        return new BaseResponse(200,"Se guardo correctamente", Optional.of(persona));
    }
    public BaseResponse getPersona(String dni){
        Persona persona = personaRepository.findByNumeroDocumento(dni);
        if(persona == null){
            return new BaseResponse(400,"No se encontro el dni",null);
        }
        return new BaseResponse(200,"Se encontro el dni",Optional.of(persona));
    }
    public Persona convertResponse(ResponseDni responseDni)
    {
        Persona persona = new Persona();
        persona.setNombres(responseDni.getNombres());
        persona.setApellidoPaterno(responseDni.getApellidoPaterno());
        persona.setApellidoMaterno(responseDni.getApellidoMaterno());
        persona.setTipoDocumento(responseDni.getTipoDocumento());
        persona.setNumeroDocumento(responseDni.getNumeroDocumento());
        return persona;
    }
}
