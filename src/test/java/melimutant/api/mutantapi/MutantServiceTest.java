/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi;

import melimutant.api.mutantapi.entity.ResultDna;
import melimutant.api.mutantapi.services.MutantService;
import melimutant.api.mutantapi.services.MutantServiceImp;
import melimutant.api.mutantapi.services.PersistenceServiceImp;
import melimutant.api.mutantapi.utils.Utils;
import melimutant.api.repository.ResultDnaRepository;
import org.assertj.core.api.Assertions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author facundoandresdominguez
 */
@SpringBootTest
public class MutantServiceTest {

    @Mock
    ResultDnaRepository repository;

    @Mock
    Utils utils;
    
    @InjectMocks
    MutantServiceImp service;

    String[] dnamutante = TestCase.DNA_MUTANT_ONE;

    

    @Test
    public void validateDna() throws JSONException {
       
        JSONArray array = new JSONArray(dnamutante);
        JSONObject item = new JSONObject();
        item.put("dna", array);
        Mockito.when(utils.generateJsonString(item)).thenReturn("ATGCGACAGTGCTTATGTAGAAGGCCCCTATCACTG");
        
        boolean res = service.isMutant(item);
        Assertions.assertThat(res).isEqualTo(true);

    }

}
