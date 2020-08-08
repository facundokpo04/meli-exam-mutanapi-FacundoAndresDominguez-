/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi.services;


import java.text.DecimalFormat;
import melimutant.api.repository.ResultDnaRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author facundoandresdominguez
 */
@Service
public class StatsServiceImp implements StatsService{
    
    @Autowired
    private ResultDnaRepository repository;
    
    @Override
    public String stats() {
        JSONObject response = new JSONObject();
        Long count_mutant_dna=repository.findMutantCount();
        Long count_human_dna=repository.findHmanCount();
        response.put("count_mutant_dna",count_mutant_dna );
        response.put("count_human_dna", count_human_dna);
        if(repository.findHmanCount()!=0) {
            float ratio = (float) count_mutant_dna / (float) count_human_dna;
            DecimalFormat formatTwoDecimal = new DecimalFormat("#.##");
            formatTwoDecimal.format(ratio);
            response.put("ratio", ratio);
        }
        else{
            String humanCero = "No se testearon Humanos";
            response.put("ratio",humanCero);
        }


        return response.toString();
    }
    
}
