/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi.utils;

import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.tomcat.jni.Time;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author facundoandresdominguez
 */
@Component("UtilsAsync")
public class UtilsAsync {

    private static final String VALID_ADNMUTANT_PATTERN = "A{4}|T{4}|C{4}|G{4}";
    private static final Pattern r = Pattern.compile(VALID_ADNMUTANT_PATTERN);

    @Async
    public CompletableFuture<Integer> countMachtVertical(char[][] matrix) {
        String result;
        int count = 0;
        int countmacht = 0;
        boolean stop = false;
        for (int columna = 0; columna < matrix.length && !stop; columna++) {
            result = "";
            for (int fila = 0; fila < matrix.length; fila++) {
                result += matrix[fila][columna];
            }
            countmacht += countMatcherDna(result, countmacht);

        }

        return CompletableFuture.completedFuture(countmacht);
    }

    @Async
    public CompletableFuture<Integer> countMachtDiagonalSup(char[][] matrix){

        String result;
        int count = 0;
        int countmacht = 0;
        boolean stop = false;

        //Diagonal (0,0) -> (n, n) Superior
        for (int columna = 0; columna < matrix.length && !stop; columna++) {
            result = "";
            for (int fila = 0; (fila < (matrix.length - columna)); fila++) {
                result += matrix[fila][fila + columna];
            }
            countmacht = countMatcherDna(result, countmacht);

            stop = result.length() == 4 || countmacht > 1;

        }

        return CompletableFuture.completedFuture(countmacht);
    }

    @Async
    public CompletableFuture<Integer> countMachtDiagonalInf(char[][] matrix) {

        String result;
        int count = 0;
        int countmacht = 0;
        boolean stop = false;

        //Diagonal (1,0) -> (n, n-1) Inferior
        for (int fila = 1; fila < matrix.length && !stop; fila++) {
            result = "";
            for (int columna = 0; columna < (matrix.length - fila); columna++) {
                result += matrix[fila + columna][columna];
            }

            countmacht = countMatcherDna(result, countmacht);

            stop = result.length() == 4 || countmacht > 1;

        }


        return CompletableFuture.completedFuture(countmacht);

    }

    @Async
    public CompletableFuture<Integer> countMachtDiagonalSupInv(char[][] matrix)  {

        String result;
        int count = 0;
        int countmacht = 0;
        boolean stop = false;

        //Diagonal (n, 0) -> (0, n) Superior
        for (int fila = matrix.length - 1; fila > 0 && !stop; fila--) {
            result = "";
            for (int columna = 0; columna <= (matrix.length - (matrix.length - fila)); columna++) {
                result += matrix[fila - columna][columna];
            }
            countmacht = countMatcherDna(result, countmacht);
            stop = result.length() == 4 || countmacht > 1;

        }

        return CompletableFuture.completedFuture(countmacht);

    }

    @Async
    public CompletableFuture<Integer> countMachtDiagonalInfInv(char[][] matrix) {

        String result;
        int count = 0;
        int countmacht = 0;
        boolean stop = false;

        //Diagonal (n, 1) -> (1, n) Inferior
        for (int columna = 1; columna < matrix.length && !stop; columna++) {
            result = "";
            int sum = 0;
            for (int fila = matrix.length - 1; fila >= columna; fila--, sum++) {
                result += matrix[fila][columna + sum];
            }
            countmacht = countMatcherDna(result, countmacht);
            stop = result.length() == 4 || countmacht > 1;
        }

        return CompletableFuture.completedFuture(countmacht);

    }

    private int countMatcherDna(String adn, int count) {

        Matcher matcher = r.matcher(adn);
        while (matcher.find()) {
            System.out.println("Genoma Encontrado: " + matcher.group());
            count++;

//            matcher.end();
        }
        return count;
    }

}
