/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melimutant.api.mutantapi;

/**
 *
 * @author facundoandresdominguez
 */
public class TestCase {
    
	//DNAs con letras invalidas
	public static final String[] DNA_INVALID_CHARS_ONE 		= {"ATGCGF","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_INVALID_CHARS_TWO 		= {"ATGCGA","CAGTGZ","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_INVALID_CHARS_THREE 	= {"ATGCGA","CAGTGC","TTATGY","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_INVALID_CHARS_FOUR 	= {"ATGCGA","CAGTGC","TTATGT","AGAAGX","CCCCTA","TCACTG"};
	public static final String[] DNA_INVALID_CHARS_FIVE 	= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTQ","TCACTG"};
	public static final String[] DNA_INVALID_CHARS_SIX 		= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTJ"};
	
	//DNAs con dimensiones invalidas
	public static final String[] DNA_INVALID_DIMENSION_ONE		= {"ATGCG","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_INVALID_DIMENSION_TWO 		= {"ATGCGA","CAGTG","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_INVALID_DIMENSION_THREE	= {"ATGCGA","CAGTGC","TTATG","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_INVALID_DIMENSION_FOUR 	= {"ATGCGA","CAGTGC","TTATGT","AGAAG","CCCCTA","TCACTG"};
	public static final String[] DNA_INVALID_DIMENSION_FIVE 	= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCT","TCACTG"};
	public static final String[] DNA_INVALID_DIMENSION_SIX 		= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACT"};
	public static final String[] DNA_INVALID_DIMENSION_SEVEN 	= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA"};
	public static final String[] DNA_INVALID_DIMENSION_EIGHT	= {"ATGCG","CAGTG","TTATG","AGAAG","CCCCT","TCACT"};
	
	//DNAs Mutantes
	public static final String[] DNA_MUTANT_ONE 	= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_MUTANT_TWO 	= {"ATTTTA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_MUTANT_THREE 	= {"ATGCGA","CACCCC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_MUTANT_FOUR 	= {"ATGCGA","CAGTGC","GGGGGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_MUTANT_FIVE 	= {"ATGCGA","CAGTGC","TTATGT","AAAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_MUTANT_SIX 	= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TTTTTG"};
	public static final String[] DNA_MUTANT_SEVEN 	= {"GGGGGA","CAGTGC","TTATGT","AGAAAA","CCCCTA","TTTTTG"};
	
	//DNAs Humanos
	public static final String[] DNA_HUMAN_ONE = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
	public static final String[] DNA_HUMAN_TWO = {"ATGCGA","CAGTGC","TTATTT","AGACGG","TCGTCA","TCACTG"};
	
	//Lineas DNA para probar si hay secuencias mutantes o no.
	public static final String DNA_MUTANT_LINE_ONE 			= "AAAACA";
	public static final String DNA_MUTANT_LINE_TWO 			= "ATTTTA";
	public static final String DNA_MUTANT_LINE_THREE 		= "GGGGCA";
	public static final String DNA_MUTANT_LINE_FOUR 		= "ATCCCC";
	public static final String DNA_NO_MUTANT_LINE_ONE	 	= "ATGCCA";
	public static final String DNA_NO_MUTANT_LINE_TWO 		= "CGTACA";
	public static final String DNA_NO_MUTANT_LINE_THREE 	= "CCCTTT";
	
	//DNAs para probar si la diagonal tiene o no secuencias mutantes
	public static final String[] DNA_MUTANT_DIAGONAL_ONE 		= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_MUTANT_DIAGONAL_TWO 		= {"TTGCGA","CTGTGC","TTTTGT","AGATGG","CCCCTA","TCACTG"};
	public static final String[] DNA_MUTANT_DIAGONAL_THREE 		= {"CTGCGA","CCGTGC","TTCTGT","AGACGG","CCCCTA","TCACTG"};
	public static final String[] DNA_MUTANT_DIAGONAL_FOUR 		= {"GTGCGA","CGGTGC","TTGTGT","AGAGGG","CCCCTA","TCACTG"};
	public static final String[] DNA_NO_MUTANT_DIAGONAL_ONE 	= {"GTGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_NO_MUTANT_DIAGONAL_TWO 	= {"CTGCGA","CTGTGC","TTTTGT","AGATGG","CCCCGA","TCACTG"};
	public static final String[] DNA_NO_MUTANT_DIAGONAL_THREE 	= {"TTGCGA","CCGTGC","TTCTGT","AGACGG","CCCCTA","TCACTG"};
	public static final String[] DNA_NO_MUTANT_DIAGONAL_FOUR 	= {"ATGCGA","CGGTGC","TTGTGT","AGAGGG","CCCCTA","TCACTG"};
	
	//DNAs para probar el metodo DNAToUpperCase
	public static final String[] DNA_WITH_LOWERCASE_CHARS_ONE 				= {"AtGcGa","cagTGC","TTAtgt","AgaaGG","Ccccta","tcactg"};
	public static final String[] DNA_WITH_LOWERCASE_CHARS_TO_UPPER_ONE 		= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_WITH_LOWERCASE_CHARS_TWO 				= {"TTGCGA","CTGTGC","ttttgt","AGATGG","CCCCTA","TCACTG"};
	public static final String[] DNA_WITH_LOWERCASE_CHARS_TO_UPPER_TWO 		= {"TTGCGA","CTGTGC","TTTTGT","AGATGG","CCCCTA","TCACTG"};
	public static final String[] DNA_WITH_LOWERCASE_CHARS_THREE				= {"ctgcga","ccgtgc","ttctgt","agacgg","ccccta","tcactg"};
	public static final String[] DNA_WITH_LOWERCASE_CHARS_TO_UPPER_THREE	= {"CTGCGA","CCGTGC","TTCTGT","AGACGG","CCCCTA","TCACTG"};
	
	//DNAs para probar si hay o no filas con secuencias mutantes
	public static final String[] DNA_WITH_NO_MUTANT_ROW 				= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CGCCTA","TCACTG"};
	public static final String[] DNA_WITH_ONE_MUTANT_ROW 				= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_WITH_TWO_MUTANT_ROW 				= {"ATGGGG","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	/*Mas de dos*/public static final String[] DNA_WITH_MORE_MUTANT_ROW = {"ATGGGG","CAGTGC","TTATGT","CCCCGG","CCCCTA","TCACTG"};
	
	//DNAs para probar si hay o no columnas con secuencias mutantes
	public static final String[] DNA_WITH_NO_MUTANT_COLUMN 					= {"ATGCGA","CAGTGC","TTATAT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_WITH_ONE_MUTANT_COLUMN					= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_WITH_TWO_MUTANT_COLUMN					= {"ATGCGA","CAGTGC","CTATGT","CGAAGG","CCCCTA","TCACTG"};
	/*Mas de dos*/public static final String[] DNA_WITH_MORE_MUTANT_COLUMN	= {"ATGCGA","CAGTGC","CTATGT","CGAAGG","CCACTA","TCACTG"};
}
