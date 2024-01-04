package CamelCase;

import java.util.ArrayList;
import java.util.List;


public class Texto {
	static List<String> valorConvertido;
	static String palavra;
	static int maiuscula;
	static int numero;
	static int posInicial;
	
	public static void printLista (List<String> lista) {
		for(int i = 0; i < lista.size(); i++){
			System.out.printf("Lista[%d]: %s\n", i, lista.get(i));
		} 
	}
	
	// Funcao principal para converter uma String em CamelCase em uma lista com as palavras separadas em itens
	public static List<String> converterCamelCase (String valorInicial) {
		testaFalhas(valorInicial);
		valorConvertido = new ArrayList<String>(); // Instancia uma lista do tipo Array para o objeto String.
		palavra = valorInicial.charAt(0)+"";
		maiuscula = Character.isUpperCase(valorInicial.charAt(0))&&Character.isUpperCase(valorInicial.charAt(1))?1:0;
		buscaPalavras(valorInicial);
	    separaUltimaPalavra();
	    return valorConvertido;
	}
	
	// Testa todas as falhas
	static void testaFalhas (String valorInicial) {
		if ( Character.isDigit(valorInicial.charAt(0)) ) {
			throw new NumeroPrimeiroException("Não é permitido que o primeiro valor seja numérico.");
		}
		
		if ( temCaracteresEspeciais(valorInicial) ) {
			throw new CaracteresEspeciaisException("Não é permitido que tenha caracteres especiais.");
		}
	}
		
	// Testa se a String inicial contem algum caractere que nao seja permitido
	static boolean temCaracteresEspeciais (String valorInicial) {
		for(int i = 1; i < valorInicial.length(); i++) {
			if ( !(Character.isAlphabetic(valorInicial.charAt(i)) || Character.isDigit(valorInicial.charAt(i)) ) ) {
				return true;
			}
		}
		return false;
	}
	
	// Faz o laco FOR para a busca de palavras
	static void buscaPalavras (String valorInicial) {
	    for(int i = 1; i < valorInicial.length(); i++) { // FOR para rodar cada caractere do texto
	    	testeChar(valorInicial, i);
	    	testeNumero(valorInicial, i);
	    	palavra += valorInicial.charAt(i);
	    }
	}
	
	// Faz os testes necessarios para tratar caracteres dentro do laco FOR
	static void testeChar (String valorInicial, int i) {
		if (Character.isUpperCase(valorInicial.charAt(i))) { // Caso o caractere for maiusculo, retorna o index
    		if (maiuscula == 0)
    			separaPalavraAntesMaiuscula(i);
    		maiuscula++;
    	} else {
    		if (maiuscula > 1)
    			separaPalavraMaiusculaMinuscula(i);
    	}
	}
	
	// Faz os testes necessarios para tratar numeros dentro do laco FOR
	static void testeNumero (String valorInicial, int i) {
		if (Character.isDigit(valorInicial.charAt(i))) { // Caso o caractere for numero, retorna o index
    		separaPalavraDeNumero(i);
		} else {
    		numero = 0;
		}
	}
	
	static void separaPalavraMaiusculaMinuscula (int i) {
    	System.out.printf("Separar palavra maiuscula e minuscula[%d]: %s\n", i, palavra);
		valorConvertido.add(palavra.substring(0, palavra.length()-1));
		palavra = palavra.substring(palavra.length()-1);
		maiuscula = 0;
	}
	
	// Separa as palavras com apenas uma letra em maiuscula
	static void separaPalavraEmMaiusculo(int i) {
    	System.out.printf("Separar palavra em maiusculo[%d]: %s\n", i, palavra);
		if (i != 1){
			valorConvertido.add(palavra.substring(0, i-1).toLowerCase());
			palavra = palavra.substring(i-1);
		}
		maiuscula = 0;
	}
	
	// Separa a ultima rodada de palavras (apos o laco FOR)
	static void separaUltimaPalavra () {
    	System.out.printf("Separar ultima palavra: %s\n", palavra);
	    if (maiuscula > 1) {
			valorConvertido.add(palavra);
	    } else {
			valorConvertido.add(palavra.toLowerCase());
	    }
	}
	
	// Separa palavra antes da maiuscula
	static void separaPalavraAntesMaiuscula (int i) {
    	System.out.printf("Separar palavra antes maiuscula[%d]: %s\n", i, palavra);
		valorConvertido.add(palavra.substring(0, palavra.length()).toLowerCase());
		palavra = palavra.substring(palavra.length());
	}
	
	// Separa a palavra que vem antes dos numeros
	static void separaPalavraDeNumero (int i) {
    	System.out.printf("Separar palavra de numero[%d]: %s\n", i, palavra);
		if (numero == 0) {
			valorConvertido.add(palavra.substring(0, palavra.length()));
			palavra = palavra.substring(palavra.length());
		} 
		numero++;
	}
}


