/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 *
 * @author facundoandresdominguez
 */
@Component("Utils")
public class Utils {

    private static String VALID_GENOMA_PATTERN = "[^ATCG]";
    private static String VALID_ADNMUTANT_PATTERN = "A|T|C|G";

    public String[] generateJsonArray(JSONObject body) throws JSONException {
        JSONArray arr = body.getJSONArray("dna");
        return toStringArray(arr);
    }

    public String generateJsonString(JSONObject body) throws JSONException {
        JSONArray arr = body.getJSONArray("dna");
        String adn= arr.toString();
        return adn.replaceAll(VALID_GENOMA_PATTERN, "");  
    }
    
     public static String generateArrString(String[] matrixDna) throws JSONException {
       
        String adn= matrixDna.toString();
        return adn.replaceAll(VALID_GENOMA_PATTERN, "");  
    }

    public static String[] toStringArray(JSONArray array) {
        if (array == null) {
            return null;
        }

        String[] arr = new String[array.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array.optString(i);
        }
        return arr;

    }

    public boolean validateArray(String[] matrix) {
        int filas = matrix.length;
        boolean result = true;
        Pattern r = Pattern.compile(VALID_GENOMA_PATTERN);

        for (int i = 0; i < matrix.length; i++) {
            Matcher m = r.matcher(matrix[i]);

            if (matrix.length != matrix[i].length() || m.find()) {
                result = false;
                break;
            }
        }
        return result;

    }


    public static char[][] stringArrayToCharMatrix(String[] input) {
        int length = input.length;
        char[][] matrix = new char[length][length];
        for (int row = 0; row < length; row++) {
            matrix[row] = input[row].toCharArray();
        }
        return matrix;
    }
    
   
}
