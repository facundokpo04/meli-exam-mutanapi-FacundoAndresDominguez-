/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi;

import melimutant.api.mutantapi.entity.ResultDna;
import melimutant.api.mutantapi.services.MutantService;
import melimutant.api.mutantapi.services.MutantServiceImp;
import melimutant.api.mutantapi.services.PersistenceService;
import melimutant.api.repository.ResultDnaRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;


/**
 *
 * @author facundoandresdominguez
 */
//@TestPropertySource(locations = {"classpath:application.properties"})
//@ContextConfiguration
@SpringBootTest
@ContextConfiguration
public class MutantServiceTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(MutantServiceTests.class);
    
    @TestConfiguration
    static class MutantServiceTestsContextConfiguration {
        
        @MockBean
        private PersistenceService repository;
        
        @Bean
        public MutantServiceImp dnaService() {
            return new MutantServiceImp(repository);
        }
    }
    
    String[] dnamutante = TestCase.DNA_MUTANT_ONE;
    
    @Autowired
    private MutantService dnaService;
    
    @MockBean
    private ResultDnaRepository dnaRepository;
    
    @Test
    public void isMutantDna1() throws JSONException {
        JSONArray array = new JSONArray(dnamutante);
        JSONObject item = new JSONObject();
        item.put("dna", array);
        LOGGER.info("llego al test");
        assertTrue(dnaService.isMutant(item));
        
        
    }
}
