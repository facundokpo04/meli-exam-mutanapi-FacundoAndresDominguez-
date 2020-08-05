/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi.controller;

import melimutant.api.mutantapi.services.MutantService;
import melimutant.api.mutantapi.services.StatsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author facundoandresdominguez
 */
@RestController
public class ValidatorDnaController {

    @Autowired
    private MutantService service;
    HttpHeaders headers = new HttpHeaders();


    @PostMapping("/mutant")
    public ResponseEntity<?> isMutant(@RequestBody String body) {

        JSONObject jsonBody = new JSONObject(body);
        boolean result = service.validateDNA(jsonBody);
        if (result) {
            boolean resultADN = service.isMutant(jsonBody);
            if (resultADN) {
                return new ResponseEntity<>("ADN Mutante", headers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("ADN Humano", headers, HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>("ADN Invalido no se puede procesar", headers, HttpStatus.BAD_REQUEST);
        }

    }
    
    
    @PostMapping("/mutantasync")
    public ResponseEntity<?> isMutantAsync(@RequestBody String body) {

        JSONObject jsonBody = new JSONObject(body);
        boolean result = service.validateDNA(jsonBody);
        if (result) {
            boolean resultADN = service.isMutantAsync(jsonBody);
            if (resultADN) {
                return new ResponseEntity<>("ADN Mutante", headers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("ADN Humano", headers, HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>("ADN Invalido no se puede procesar", headers, HttpStatus.BAD_REQUEST);
        }

    }



}
