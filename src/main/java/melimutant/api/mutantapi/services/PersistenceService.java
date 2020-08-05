/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import melimutant.api.mutantapi.entity.ResultDna;

/**
 *
 * @author facundoandresdominguez
 */
public interface PersistenceService {
    
     CompletableFuture<String>persistDnaResult(String matrixDna, boolean isMutant);
}
