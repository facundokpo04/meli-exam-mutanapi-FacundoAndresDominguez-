/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi;

import melimutant.api.mutantapi.services.MutantServiceImp;
import melimutant.api.mutantapi.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import melimutant.api.mutantapi.utils.UtilsDna;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author facundoandresdominguez
 */
@SpringBootTest
public class DnaTest {

    @Autowired
    Utils utils;
    @Autowired
    UtilsDna utilsdna;
    @Autowired
    MutantServiceImp service;

    @Test
    public void testCheckRowsNoMutantRow() {
        assertEquals(0, utilsdna.countMachtHorizontal(TestCase.DNA_WITH_NO_MUTANT_ROW));
        assertEquals(1, utilsdna.countMachtHorizontal(TestCase.DNA_WITH_ONE_MUTANT_ROW));

    }

    @Test
    public void testCheckRowsMutantRow() {
        assertEquals(2, utilsdna.countMachtHorizontal(TestCase.DNA_WITH_TWO_MUTANT_ROW));
        assertEquals(2, utilsdna.countMachtHorizontal(TestCase.DNA_WITH_MORE_MUTANT_ROW));
    }

    @Test
    public void testCheckColumnsNoMutantColumn() {
        assertEquals(0, utilsdna.countMachtVertical(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_NO_MUTANT_COLUMN)));
        assertEquals(1, utilsdna.countMachtVertical(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_ONE_MUTANT_COLUMN)));
    }

    @Test
    public void testCheckColumnsMutantColumn() {
        assertEquals(2, utilsdna.countMachtVertical(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_TWO_MUTANT_COLUMN)));
        assertEquals(2, utilsdna.countMachtVertical(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_MORE_MUTANT_COLUMN)));
    }

    @Test
    public void testCheckDiagSupMutant() {
        assertEquals(0, utilsdna.countMachtDiagonalSup(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_NO_MUTANT_DIAGSUP)));
        assertEquals(1, utilsdna.countMachtDiagonalSup(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_ONE_MUTANT_DIAGSUP)));
        assertEquals(2, utilsdna.countMachtDiagonalSup(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_TWO_MUTANT_DIAGSUP)));
        assertEquals(2, utilsdna.countMachtDiagonalSup(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_MORE_MUTANT_DIAGSUP)));
    }

    @Test
    public void testCheckDiagInfMutant() {
        assertEquals(0, utilsdna.countMachtDiagonalInf(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_NO_MUTANT_DIAGINF)));
        assertEquals(1, utilsdna.countMachtDiagonalInf(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_ONE_MUTANT_DIAGINF)));
        assertEquals(2, utilsdna.countMachtDiagonalInf(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_TWO_MUTANT_DIAGINF)));
    }

    @Test
    public void testCheckDiagSupInvMutant() {
        assertEquals(0, utilsdna.countMachtDiagonalSupInv(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_NO_MUTANT_DIAGSUPINV)));
        assertEquals(1, utilsdna.countMachtDiagonalSupInv(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_ONE_MUTANT_DIAGSUPINV)));
        assertEquals(2, utilsdna.countMachtDiagonalSupInv(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_TWO_MUTANT_DIAGSUPINV)));
        assertEquals(2, utilsdna.countMachtDiagonalSupInv(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_MORE_MUTANT_DIAGSUPINV)));
    }

    @Test
    public void testCheckDiagInfInvMutant() {
        assertEquals(0, utilsdna.countMachtDiagonalInfInv(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_NO_MUTANT_DIAGINFINV)));
        assertEquals(1, utilsdna.countMachtDiagonalInfInv(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_ONE_MUTANT_DIAGINFINV)));
        assertEquals(2, utilsdna.countMachtDiagonalInfInv(utils.stringArrayToCharMatrix(TestCase.DNA_WITH_TWO_MUTANT_DIAGINFINV)));
    }

    @Test
    public void testCeckIvalidDnaChars() {
        assertEquals(false, utils.validateArray(TestCase.DNA_INVALID_CHARS_ONE));
        assertEquals(false, utils.validateArray(TestCase.DNA_INVALID_CHARS_TWO));
        assertEquals(false, utils.validateArray(TestCase.DNA_INVALID_CHARS_THREE));
        assertEquals(false, utils.validateArray(TestCase.DNA_INVALID_CHARS_FOUR));
        assertEquals(false, utils.validateArray(TestCase.DNA_INVALID_CHARS_FIVE));
        assertEquals(false, utils.validateArray(TestCase.DNA_INVALID_CHARS_SIX));

    }

    @Test
    public void testCeckIvalidDnaDimension() {
        assertEquals(false, utils.validateArray(TestCase.DNA_INVALID_DIMENSION_ONE));
        assertEquals(false, utils.validateArray(TestCase.DNA_INVALID_DIMENSION_TWO));
        assertEquals(false, utils.validateArray(TestCase.DNA_INVALID_DIMENSION_THREE));
        assertEquals(false, utils.validateArray(TestCase.DNA_INVALID_DIMENSION_FOUR));
        assertEquals(false, utils.validateArray(TestCase.DNA_INVALID_DIMENSION_FIVE));
        assertEquals(false, utils.validateArray(TestCase.DNA_INVALID_DIMENSION_SIX));

    }

    @Test
    public void validateIsMutant1() throws JSONException {
        JSONArray array = new JSONArray(TestCase.DNA_MUTANT_ONE);
        JSONObject item = new JSONObject();
        item.put("dna", array);
        assertEquals(true, service.isMutant(item));

    }
    @Test
    public void validateIsMutant2() throws JSONException {
        JSONArray array = new JSONArray(TestCase.DNA_MUTANT_TWO);
        JSONObject item = new JSONObject();
        item.put("dna", array);
        assertEquals(true, service.isMutant(item));

    }
    @Test
    public void validateIsMutant3() throws JSONException {
        JSONArray array = new JSONArray(TestCase.DNA_MUTANT_THREE);
        JSONObject item = new JSONObject();
        item.put("dna", array);
        assertEquals(true, service.isMutant(item));

    }
       @Test
    public void validateIsHuman1() throws JSONException {
        JSONArray array = new JSONArray(TestCase.DNA_HUMAN_ONE);
        JSONObject item = new JSONObject();
        item.put("dna", array);
        assertEquals(false, service.isMutant(item));

    }
       @Test
    public void validateIsHuman2() throws JSONException {
        JSONArray array = new JSONArray(TestCase.DNA_HUMAN_TWO);
        JSONObject item = new JSONObject();
        item.put("dna", array);
        assertEquals(false, service.isMutant(item));

    }

}
