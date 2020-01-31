package ed2.listaligada;

public class ListaLigada {

	private Celula primeira;
	private Celula ultima;
	private int totalDeElementos = 0;

	/*
	 * Na versão anterior fizemos com lista ligada. Agora será lista duplamente
	 * ligada
	 */
	public void adicionaNoComeco(Object elemento) {
		if (this.totalDeElementos == 0) {
			Celula nova = new Celula(elemento);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			/*
			 * O segredo está aqui. Primeiro eu crio uma nova célula, dizendo que a próxima
			 * célula é a primeira (primeira ligação) Depois eu digo que a célula anterior a
			 * PRIMEIRA é a nova que eu acabei de criar. (segunda ligação) Depois
			 * simplesmente mudo a referência dizendo que a primeira célula é a nova.
			 */
			Celula nova = new Celula(elemento, this.primeira);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}

		this.totalDeElementos++; // Contabiliza o total de elementos
	}

	public void adicionaNoFim(Object elemento) {
		// adiciona no fim da lista

		/*
		 * Caso não tenha elementos na lista, trata-se de uma nova lista, então apenas
		 * chama o adiciona no começo.
		 */
		if (this.totalDeElementos == 0) {
			adicionaNoComeco(elemento);
		} else {
			/*
			 * Aqui realiza praticamente a mesma coisa que no AdicionaNoComeco() Apenas
			 * fazemos as referências devidas.
			 */
			Celula nova = new Celula(elemento);
			this.ultima.setProximo(nova); // <-- Faz apontar nosso ultimo elemento para a nova
			nova.setAnterior(this.ultima); // <-- Faz apontar a nova célula para a última célula
			this.ultima = nova; // <-- Insere o novo elemento como último.
			this.totalDeElementos++; // <-- Contabiliza o novo elemento
		}
	}

	private boolean posicaoOcupada(int posicao) {
		// metodo auxiliar para retornar apenas as posicoes ocupadas
		return posicao >= 0 && posicao < this.totalDeElementos;
	}

	private Celula pegaCelula(int posicao) {
		// metodo auxilar para conseguir a posição da célula.

		if (!posicaoOcupada(posicao)) {
			// Validando caso não a posição inserida não seja nenhuma adicionada.
			throw new IllegalArgumentException("Posição inválida.");
		}

		Celula atual = primeira;

		for (int i = 0; i < posicao; i++) {
			// percorre todo a lista até a posição escolhida -1
			atual = atual.getProximo(); // Pega a próxima Célula
		}

		return atual; // Por fim retorna
	}

	public void adiciona(int posicao, Object elemento) {
		// Adiciona no meio da lista.

		if (posicao == 0) {
			adicionaNoComeco(elemento);
		} else if (posicao == this.totalDeElementos) {
			adicionaNoFim(elemento);
		} else {
			Celula anterior = this.pegaCelula(posicao - 1); // Pega a célula anterior a posição que eu inseri.
			Celula proxima = anterior.getProximo(); // Pega a próxima célula, que se encontra atualmente na posição que
													// quero inserir.

			Celula nova = new Celula(elemento, anterior.getProximo()); // Nova célula, e insiro como próxima da célula
																		// anterior.

			nova.setAnterior(anterior); // Aqui só refaço as ligações duplas
			anterior.setProximo(nova);
			proxima.setAnterior(nova);
			nova.setProximo(proxima);

			this.totalDeElementos++;// Adiciona mais um elemento no contador.

			/*
			 * O primeiro passo é pegar a posição da célula anterior a que eu inseri. Em
			 * seguida crio a nova célula. E já que eu tenho a ANTERIOR, eu já faço o
			 * apontamento para próxima com base no anterior. Por último só falta fazer o
			 * apontamento da nossa célula anterior para a que eu inseri.
			 */
		}
	}

	public Object pega(int posicao) {
		return this.pegaCelula(posicao).getElemento();
	}

	public void removeDoComeco() {
		if (this.totalDeElementos == 0) {
			throw new IllegalArgumentException("Lista vazia");
		}

		/*
		 * Remover do primeiro é simples, basta matar o apontamento primeiro elemento.
		 * Substituimos o primeiro pelo próximo, e removemos um elemento do contador.
		 */
		this.primeira = this.primeira.getProximo();
		this.totalDeElementos--;

		if (this.totalDeElementos == 0) {
			this.ultima = null;
		}
	}

	public void removeDoFim() {
		if (this.totalDeElementos == 1) {
			removeDoComeco();
		} else {
			/*
			 * Primeiro preciso pegar o penúltimo elemento. Assim quero a ligação que o
			 * último, setando o próximo (o último) como nulo. Depois defino que a última é
			 * a penúltima.
			 */

			Celula penultima = this.ultima.getAnterior();
			penultima.setProximo(null);
			this.ultima = penultima;
			this.totalDeElementos--;
		}
	}

	public void remove(int posicao) {
		if (posicao == 0) {
			this.removeDoComeco();
		} else if (posicao == this.totalDeElementos - 1) {
			this.removeDoFim();
		} else {

			/*
			 * Remover do meio também é tranquilo agora Basta eu pegar as 3 posições: A
			 * anterior, a atual que quero remover, e a próxima. Assim só refaço os
			 * relacionamentos entre a anterior e a próxima. A atual vai pro limbo.
			 */
			Celula anterior = this.pegaCelula(posicao - 1);
			Celula atual = anterior.getProximo();
			Celula proxima = atual.getProximo();

			anterior.setProximo(proxima);
			proxima.setAnterior(anterior);

			this.totalDeElementos--;
		}
	}

	public int tamanho() {
		return this.totalDeElementos;
	}

	
	public boolean contem(Object elemento) {
		Celula atual = this.primeira;
		while (atual != null) {
			if (atual.getElemento().equals(elemento)) {
				return true;
			}
			atual = atual.getProximo();
		}
		return false;
	}

	@Override
	public String toString() { // converte o retorno da lista para string.
		if (this.totalDeElementos == 0) {
			return "[]";
		}

		Celula atual = primeira;

		StringBuilder builder = new StringBuilder("[");

		for (int i = 0; i < totalDeElementos; i++) {
			builder.append(atual.getElemento());
			builder.append(", ");

			atual = atual.getProximo();
		}

		builder.append("]");
		return builder.toString();
	}
}
