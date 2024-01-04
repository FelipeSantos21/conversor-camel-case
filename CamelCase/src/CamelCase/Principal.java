package CamelCase;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String valor = "recupera10Primeiros";
		System.out.printf("TESTANDO POR %s\n", valor);
		Texto.printLista(Texto.converterCamelCase(valor));
	}

}

