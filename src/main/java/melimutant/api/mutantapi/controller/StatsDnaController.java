/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi.controller;


import melimutant.api.mutantapi.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author facundoandresdominguez
 */
@RestController
//@RequestMapping("/") //raiz de la url
public class StatsDnaController {
    @Autowired
    private StatsService service;
     HttpHeaders headers = new HttpHeaders();

    @GetMapping("/stats")
    public ResponseEntity<?> status() {
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(service.stats(), headers, HttpStatus.OK);

    }
}
