import java.util.ArrayList;

public class VetorTeste {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Joao");
		Aluno a2 = new Aluno("Jose");

		Vetor lista = new Vetor();

		/*
		 * Exibe o tamanho da lista antes de inserir o primeiro aluno, ou seja, 0.
		 */
		System.out.println(lista.tamanho());
		
		lista.adiciona(a1);	
		/* Exibira o tamanho com 1 */
		System.out.println(lista.tamanho());
		
		lista.adiciona(a2);
		/* Exibira o tamanho com 2 */		
		System.out.println(lista.tamanho());

		/* Imprime a lista do array */
		System.out.println(lista);

		/* Imprime um booleano dizendo se contem o Aluno a1 dentro deste array */
		System.out.println(lista.contem(a1));

		Aluno a3 = new Aluno("Danilo");
		/*
		 * Criei um novo Aluno, NÃO adicionei no array e to verificando se ele está lá
		 */
		System.out.println(lista.contem(a3));

//		/* Tenta pegar uma aluno da lista em determinada posição */
//		Aluno x = lista.pega(158);
//		System.out.println(x);

		lista.adiciona(1, a3);
		System.out.println(lista);

		lista.remove(1);
		System.out.println(lista);
		
		/* Adicionamos o João + número da posição ATÉ a posição 299 (< 300)
		 * A lista dobrou a primeira vez 100*2, se tornando 200 posições
		 * depois dobrou pela segunda vez, tornando 400 posições.
		 * Assim coube as adições até a posição 299 e sobrou o espaço restante para adição
		 */
		for(int i = 0; i<300; i++) {
			Aluno y = new Aluno("João " + i);
			lista.adiciona(y);
		}
		
		System.out.println(lista);
		
		
		/* O Java já possui uma implementação de Vetor
		 * e lá possui todos os métodos parecidos com que foi implementado nesse projeto, e muitos outros.
		 */
		ArrayList<Aluno> listaDoJava = new ArrayList<Aluno>();
		
		/* Basta substituir o .add depois do listaDoJava por qualquer método fornecido e que você precise. */
		listaDoJava.add(a1);
	}
}
