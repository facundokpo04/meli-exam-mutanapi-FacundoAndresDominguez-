/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi.services;

import java.util.concurrent.CompletableFuture;
import melimutant.api.mutantapi.entity.ResultDna;
import melimutant.api.mutantapi.utils.Utils;
import melimutant.api.repository.ResultDnaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author facundoandresdominguez
 */
@Service
public class PersistenceServiceImp implements PersistenceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultDna.class);

       @Autowired
    private ResultDnaRepository repository;


  
    @Async
    @Override
    public CompletableFuture<String> persistDnaResult(String dna, boolean isMutant) {
        String mensaje;
        int existe = 0;
        LOGGER.info("Guardar ADN: {} carateres", dna.length());
        existe = repository.findByDna(dna);
        if (existe == 0) {
            repository.save(new ResultDna(dna, isMutant));
            mensaje = "ADN Guardado";
        } else {
            mensaje = "ADN ya existe";
        }
  

        return CompletableFuture.completedFuture(mensaje);
    }

}
