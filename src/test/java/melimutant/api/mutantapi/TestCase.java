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
	
	

	//DNAs para probar si hay o no filas con secuencias mutantes
	public static final String[] DNA_WITH_NO_MUTANT_ROW 				= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CGCCTA","TCACTG"};
	public static final String[] DNA_WITH_ONE_MUTANT_ROW 				= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_WITH_TWO_MUTANT_ROW 				= {"ATGGGG","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	/*Mas de dos*/
        public static final String[] DNA_WITH_MORE_MUTANT_ROW = {"ATGGGG","CAGTGC","TTATGT","CCCCGG","CCCCTA","TCACTG"};
	
	//DNAs para probar si hay o no columnas con secuencias mutantes
	public static final String[] DNA_WITH_NO_MUTANT_COLUMN 					= {"ATGCGA","CAGTGC","TTATAT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] DNA_WITH_ONE_MUTANT_COLUMN					= {"ATGCGC","CAGTGC","TTATGG","AGAAGC","CCCCTA","CCCCTA"};
	public static final String[] DNA_WITH_TWO_MUTANT_COLUMN					= {"ATGCGC","CAGTGC","TTATGC","AGAAGC","CCCCTA","CCCCTA"};
        public static final String[] DNA_WITH_ONE_MUTANT_COLUMN2= {"ACCC","AGGG","ACCC","AAAA"};
	/*Mas de dos*/
        public static final String[] DNA_WITH_MORE_MUTANT_COLUMN	= {"ATGCGC","CAGTGC","TTATGC","AGAAGC","CCACTA","CCACTA"};
        
        //DNAs para probar si hay o no digonal superior con secuencias mutantes
	public static final String[] DNA_WITH_NO_MUTANT_DIAGSUP 				= {"CATACT","CAATAA","CATTAC","ATCTCT","TCTCAT","ATCCAT"};
	public static final String[] DNA_WITH_ONE_MUTANT_DIAGSUP				= {"CATACT","CAATAA","CATTTC","ATCTCT","TCTCAT","ATCCAT"};
	public static final String[] DNA_WITH_TWO_MUTANT_DIAGSUP				= {"CATACT","CACTAA","CATCTC","ATCTCT","TCTCAC","ATCCAT"};
        /*Mas de dos*/
        public static final String[] DNA_WITH_MORE_MUTANT_DIAGSUP={"CATACT","CACTAA","CATCTC","ATCTCT","TCTCTC","ATCCAT"};
        
        //DNAs para probar si hay o no digonal inferior con secuencias mutantes
	public static final String[] DNA_WITH_NO_MUTANT_DIAGINF	= {"CATACT","CACTAA","CATCTC","ATCTCT","TCTCTC","ATCCAT"};
	public static final String[] DNA_WITH_ONE_MUTANT_DIAGINF= {"CATACT","CACTAA","TATCTC","ATCTCT","TCTCTC","ATCTAT"};
	public static final String[] DNA_WITH_TWO_MUTANT_DIAGINF= {"CATACT","CACTAA","TCTCTC","ATCTCT","TCTCTC","ATCTCT"};
        
        //DNAs para probar si hay o no digonal superior invertida con secuencias mutantes
	public static final String[] DNA_WITH_NO_MUTANT_DIAGSUPINV= {"CATACT","CACTAA","CACCTC","ATCTCT","TCTCTC","ATCCAT"};
	public static final String[] DNA_WITH_ONE_MUTANT_DIAGSUPINV= {"CATACT","CACCAA","CACCTC","ACCTCT","TCTCTC","ATCCAT"};
	public static final String[] DNA_WITH_TWO_MUTANT_DIAGSUPINV= {"CATACT","CAACAA","CACCTC","ACCTCT","TCTCTC","ATCCAT"};
        /*Mas de dos*/
        public static final String[] DNA_WITH_MORE_MUTANT_DIAGSUPINV={"CATACT","CAACCA","CACCTC","ACCTCT","TCTCTC","ATCCAT"};
        
        //DNAs para probar si hay o no digonal inferior inv con secuencias mutantes
	public static final String[] DNA_WITH_NO_MUTANT_DIAGINFINV	= {"CATACT","CACTAA","TCTCTC","ATCACT","TCTTTC","ATCTCT"};
	public static final String[] DNA_WITH_ONE_MUTANT_DIAGINFINV= {"ATACT","CACTAA","TCTCTC","ATCACT","TCTCTC","ATCTCT"};
	public static final String[] DNA_WITH_TWO_MUTANT_DIAGINFINV= {"CATACT","CACTAA","TCTCTC","ATCTCT","TCTCTC","ATCTCT"};
        
}

