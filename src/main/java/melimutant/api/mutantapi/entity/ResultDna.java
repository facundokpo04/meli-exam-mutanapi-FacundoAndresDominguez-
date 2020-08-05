/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author facundoandresdominguez
 */
@Entity
@Table(name = "result_dna",
        indexes = {
            @Index(name = "indx_test_dna", columnList ="test_dna", unique = true),})
public class ResultDna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int test_id;

    @Column(name="test_dna",unique = true)

    private String test_dna;

    private boolean test_result;

    public ResultDna() {
    }

    public ResultDna(String test_dna, boolean test_result) {
        this.test_dna = test_dna;
        this.test_result = test_result;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public String getTest_dna() {
        return test_dna;
    }

    public void setTest_dna(String test_dna) {
        this.test_dna = test_dna;
    }

    public boolean isTest_result() {
        return test_result;
    }

    public void setTest_result(boolean test_result) {
        this.test_result = test_result;
    }

}
