/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import melimutant.api.mutantapi.entity.ResultDna;
import melimutant.api.mutantapi.utils.Utils;
import melimutant.api.mutantapi.utils.UtilsAsync;
import melimutant.api.mutantapi.utils.UtilsDna;
import melimutant.api.repository.ResultDnaRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author facundoandresdominguez
 */
@Service
public class MutantServiceImp implements MutantService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultDna.class);
    @Autowired
    Utils utils;
    @Autowired
    UtilsDna utilsDna;
    @Autowired
    UtilsAsync utilsasync;

    @Autowired
    private ResultDnaRepository repository;

    private PersistenceService persitenceServ;

    @Autowired
    public MutantServiceImp(PersistenceService persistenceService) {
        this.persitenceServ = persistenceService;
    }

    @Override
    public boolean isMutant(JSONObject body) throws JSONException {
        long startDiag = 0l;
        String dna = utils.generateJsonString(body);
        String[] matrixDna = utils.generateJsonArray(body);
        char[][] matrixDnaChar = null;
        boolean result = false;
        int countDnaFinal = 0;
        int existe = repository.findByDna(dna);

        if (existe == 1) {

            result = repository.findByDnaObject(dna).isTest_result();
            return result;

        } else {
            countDnaFinal = utilsDna.countMachtHorizontal(matrixDna);

            if (countDnaFinal < 2) {

                matrixDnaChar = utils.stringArrayToCharMatrix(matrixDna);
                countDnaFinal += utilsDna.countMachtVertical(matrixDnaChar);
            } //verificamos las diagonales
            if (countDnaFinal < 2) {
                //Generamos matriz de char

                countDnaFinal += utilsDna.countMachtDiagonalSup(matrixDnaChar);

                if (countDnaFinal < 2) {
                    countDnaFinal += utilsDna.countMachtDiagonalInf(matrixDnaChar);
                }
                if (countDnaFinal < 2) {
                    countDnaFinal += utilsDna.countMachtDiagonalSupInv(matrixDnaChar);
                }
                if (countDnaFinal < 2) {
                    countDnaFinal += utilsDna.countMachtDiagonalInfInv(matrixDnaChar);
                }

            }

            if (countDnaFinal > 1) {
                result = true;
            }
            long startSave = System.currentTimeMillis();
            persitenceServ.persistDnaResult(dna, result);
            return result;
        }
    }

    public boolean isMutantAsync(JSONObject body) throws JSONException {
        long startDiag = 0l;
        String dna = utils.generateJsonString(body);
        String[] matrixDna = utils.generateJsonArray(body);
        char[][] matrixDnaChar = null;
        boolean result = false;
        int countDnaFinal = 0;
        String mensaje;
        int existe = repository.findByDna(dna);

        if (existe == 1) {

            result = repository.findByDnaBool(dna);
            return result;

        } else {
            countDnaFinal = utilsDna.countMachtHorizontal(matrixDna);
            startDiag = System.currentTimeMillis();
            //diagonales y verticales todas juntas
            if (countDnaFinal < 2) {
                startDiag = System.currentTimeMillis();
                matrixDnaChar = utils.stringArrayToCharMatrix(matrixDna);
                countDnaFinal += utilsDna.countMachtVertical(matrixDnaChar);
            } //verificamos las diagonales
            //Generamos matriz de char

            if (countDnaFinal < 2) {
                try {

                    CompletableFuture<Integer> future1 = utilsasync.countMachtDiagonalSup(matrixDnaChar);
                    CompletableFuture<Integer> future2 = utilsasync.countMachtDiagonalInf(matrixDnaChar);
                    CompletableFuture<Integer> future3 = utilsasync.countMachtDiagonalSupInv(matrixDnaChar);
                    CompletableFuture<Integer> future4 = utilsasync.countMachtDiagonalInfInv(matrixDnaChar);
                    countDnaFinal = future1.get() + future2.get() + future3.get() + future4.get();
                } catch (InterruptedException ex) {
                    throw new JSONException(ex.getMessage());
                } catch (ExecutionException ex) {
                    throw new JSONException(ex.getMessage());
                }

            }
            if (countDnaFinal > 1) {
                result = true;

            }
            long startSave = System.currentTimeMillis();
            try {

                persitenceServ.persistDnaResult(dna, result);

            } catch (Exception e) {
                LOGGER.error("Error al Persistir dna:  {} error {}", dna, e.getMessage());

            }
        }

        return result;
    }

    @Override
    public boolean validateDNA(JSONObject body) throws JSONException {
        utils.generateJsonString(body);
        return utils.validateArray(utils.generateJsonArray(body));
    }

}
