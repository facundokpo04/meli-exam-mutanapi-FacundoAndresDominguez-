/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.repository;

import java.util.List;
import melimutant.api.mutantapi.entity.ResultDna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author facundoandresdominguez
 */
@Repository
public interface ResultDnaRepository extends JpaRepository<ResultDna, Long> {

    @Query(value = "select count(r.test_result) from ResultDna r where r.test_result=true")
    public Long findMutantCount();

    @Query(value = "select count(r.test_result) from ResultDna r where r.test_result=false")
    public Long findHmanCount();

    @Query(value = "select count(r.test_id) from ResultDna r where  r.test_dna like %?1")
    public int findByDna(String dna);

    @Query(value = "select r from ResultDna r where  r.test_dna like %?1")
    public ResultDna findByDnaObject(String dna);
    
    @Query(value = "select r.test_result from ResultDna r where  r.test_dna like %?1")
    public boolean findByDnaBool(String dna);

}
