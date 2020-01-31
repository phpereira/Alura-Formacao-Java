package ed2.listaligada;

public class ListaLigada {

	private Celula primeira = null;
	private Celula ultima = null;
	private int totalDeElementos = 0;

	/*
	 * Na primeira iteração o elemento = "Maurício" e o primeira vale Null,
	 * adiciona. Em seguida o primeira = nova com o valor "Maurício".
	 * 
	 * Na segunda iteração o elemento = "Paulo" e o primeira vale "Maurício",
	 * adiciona. Em seguida primeira = nova com o valor "Paulo".
	 * 
	 * Na terceira iteração e assim por diante funcionam da mesma forma...
	 */
	public void adicionaNoComeco(Object elemento) {
		Celula nova = new Celula(elemento, primeira);
		this.primeira = nova;

		if (this.totalDeElementos == 0) {
			this.ultima = this.primeira;
			/*
			 * Aqui verificamos se há algum elemento inserido Caso não tenha, o this.ultima
			 * terá o mesmo valor de this.primeira Por que fazemos isso? Assim que
			 * adicionamos o primeiro valor ele se torna o último, então guardamos essa
			 * informação
			 */
		}

		this.totalDeElementos++; // Contabiliza o total de elementos
	}

	public void adiciona(Object elemento) {
		// adiciona no fim da lista

		/*
		 * Caso não tenha elementos na lista, trata-se de uma nova lista, então apenas
		 * chama o adiciona no começo.
		 */
		if (this.totalDeElementos == 0) {
			adicionaNoComeco(elemento);
		} else {
			/*
			 * Adicionar no fim é mais complexo. Primeiro criamos uma NOVA célula, mas
			 * sabemos que o próximo elemento é nulo. Então fazemos o último elemento atual
			 * apontar para a célula nova que criamos. Aí sim inserimos a nova célula como
			 * última.
			 */
			Celula nova = new Celula(elemento, null); // <-- próximo elemento null
			this.ultima.setProximo(nova); // <-- Faz apontar nosso ultimo elemento para a nova
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
			adiciona(elemento);
		} else {
			Celula anterior = this.pegaCelula(posicao - 1); // Pega a célula anterior a que eu inseri.
			Celula nova = new Celula(elemento, anterior.getProximo()); // Nova célula, e faço o apontamento para a próxima usando o anterior.
			anterior.setProximo(nova); // Por fim setamos o anterior apontando para a nova célula que inserimos
			
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
		if (this.totalDeElementos==0) {
			throw new IllegalArgumentException("Lista vazia");
		}
		
		/*
		 * Remover do primeiro é simples, basta matar o apontamento primeiro elemento.
		 * Substituimos o primeiro pelo próximo, e removemos um elemento do contador.
		 */
		this.primeira = this.primeira.getProximo();
		this.totalDeElementos--;
		
		if(this.totalDeElementos == 0) {
			this.ultima = null;
		}
	}
	

	public void remove(int posicao) {
		//proximo capítulo nas listas duplamente ligadas
	}

	public int tamanho() {
		return this.totalDeElementos;
	}

	public boolean contem(Object o) {
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
