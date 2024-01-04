package CamelCase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class TesteCamelCase { 

	@Test
	public void testeAssinatura() {
		List<String> listRetorno = new ArrayList<String>();
		listRetorno.add("nome");

		assertEquals(listRetorno, Texto.converterCamelCase("nome"));
	}
	
	@Test
	public void testeUmaPalavraEmCamelCase() {
		List<String> listRetorno = new ArrayList<String>();
		listRetorno.add("nome");

		assertEquals(listRetorno, Texto.converterCamelCase("Nome"));
	}
	
	@Test
	public void testeDuasPalavrasEmCamelCase1() {
		List<String> listRetorno = new ArrayList<String>();
		listRetorno.add("nome");
		listRetorno.add("composto");

		assertEquals(listRetorno, Texto.converterCamelCase("nomeComposto"));
	}
	
	@Test
	public void testeDuasPalavrasEmCamelCase2() {
		List<String> listRetorno = new ArrayList<String>();
		listRetorno.add("nome");
		listRetorno.add("composto");

		assertEquals(listRetorno, Texto.converterCamelCase("NomeComposto"));
	}
	
	@Test
	public void testeUmaPalavraTodaEmMaiuscula() {
		List<String> listRetorno = new ArrayList<String>();
		listRetorno.add("CPF");
	
		assertEquals(listRetorno, Texto.converterCamelCase("CPF"));
	}
	
	@Test
	public void testeUmaPalavraMinusculaUmaPalavraTodaEmMaiuscula() {
		List<String> listRetorno = new ArrayList<String>();
		listRetorno.add("numero");
		listRetorno.add("CPF");
	
		assertEquals(listRetorno, Texto.converterCamelCase("numeroCPF"));
	}
	
	@Test
	public void testeUmaPalavraMinusculaUmaPalavraTodaEmMaiusculaOutraMinuscula() {
		List<String> listRetorno = new ArrayList<String>();
		listRetorno.add("numero");
		listRetorno.add("CPF");
		listRetorno.add("contribuinte");
	
		assertEquals(listRetorno, Texto.converterCamelCase("numeroCPFContribuinte"));
	}
	
	@Test
	public void testeUmaPalavraMinusculaUmNumeroOutraMinuscula() {
		List<String> listRetorno = new ArrayList<String>();
		listRetorno.add("recupera");
		listRetorno.add("10");
		listRetorno.add("primeiros");
	
		assertEquals(listRetorno, Texto.converterCamelCase("recupera10Primeiros"));
	}
	
	@Test
	public void testeErroNumeroPrimeiro() {
		try {
			Texto.converterCamelCase("10Primeiros");
			fail();
		} catch (NumeroPrimeiroException e) {}
	}
	
	@Test
	public void testeErroCaractereEspecial() {
		try {
			Texto.converterCamelCase("nome#Composto");
			fail();
		} catch (CaracteresEspeciaisException e) {}
	}
}
