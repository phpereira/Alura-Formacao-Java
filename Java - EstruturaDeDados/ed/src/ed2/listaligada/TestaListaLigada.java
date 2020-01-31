package ed2.listaligada;

public class TestaListaLigada {
	public static void main(String[] args) {
		ListaLigada lista = new ListaLigada();
		
		System.out.println(lista);
		lista.adicionaNoComeco("Maurício");
		System.out.println(lista);
		lista.adicionaNoComeco("Paulo");
		System.out.println(lista);
		lista.adicionaNoComeco("Guilherme");
		System.out.println(lista);
		lista.adicionaNoComeco("José");
		System.out.println(lista);
		lista.adicionaNoComeco("João");
		System.out.println(lista);
		
		lista.adicionaNoFim("Marcelo");
		System.out.println(lista);
		
		lista.adiciona(2, "Gabriel");
		System.out.println(lista);
		
		lista.adiciona(2, "Letícia");
		System.out.println(lista);
		
		Object x = lista.pega(2);
		System.out.println(x);
		
		System.out.println(lista.tamanho());
		
		lista.removeDoComeco();
		System.out.println(lista);
		
		lista.removeDoFim();
		System.out.println(lista);
		
		lista.remove(4);
		System.out.println(lista);
		
		System.out.println(lista.contem("Guilherme"));
		System.out.println(lista.contem("Paulo"));
	}
}
