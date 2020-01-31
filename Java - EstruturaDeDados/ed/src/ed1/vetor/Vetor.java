package ed1.vetor;
import java.util.Arrays;


/* Estudo de Vetor
 * Armazenamento sequencial
 */

public class Vetor {
	private Aluno[] alunos = new Aluno[100];
	private int totalDeAlunos = 0;

	public void adiciona(Aluno aluno) {
		this.garanteEspaco();
		/*
		 * Utilizando um contador de alunos, é inserido o aluno DIRETO na posição vazia.
		 */
		this.alunos[totalDeAlunos] = aluno;
		totalDeAlunos++;

		/*
		 * Utilizando FOR, é necessário percorrer o array até encontrar uma posição
		 * vazia.
		 */
//		for (int i = 0; i < alunos.length; i++) {
//			if (alunos[i] == null) {
//				alunos[i] = aluno;
//				break;
//			}
//		}
	}

	/* Valida se a posição inserida existe dentro do array */
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= totalDeAlunos;
	}
	
	/* Verifica se o totalDeAlunos é igual ao tamanho do array
	 * caso sim, ele cria um novo array temporário com o dobro do tamanho.
	 * Em seguida copia todos os objetos para dentro do NOVO array.
	 * Por fim trocamos a referência.
	 */
	private void garanteEspaco() {
		if (totalDeAlunos == alunos.length) {
			Aluno[] novoArray = new Aluno[alunos.length*2];
			for(int i = 0; i<alunos.length; i++) {
				novoArray[i] = alunos[i];
			}
			this.alunos = novoArray;
		}
	}

	
	public void adiciona(int posicao, Aluno aluno) {
		this.garanteEspaco();
		if (!posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}

		/*
		 * Adiciona um aluno em qualquer posição existente do vetor, e todos os alunos posteriores
		 * a posição escolhida são empurrados para posição seguinte.
		 */
		
		for (int i = totalDeAlunos - 1; i >= posicao; i -= 1) {
			alunos[i + 1] = alunos[i];
		}
		alunos[posicao] = aluno;
		totalDeAlunos++;
	}

	private boolean posicaoOcupada(int posicao) {
		/*
		 * Valida que a posição inserida não seja um número negativo, nem maior que
		 * número de Alunos inseridos
		 */
		return posicao >= 0 && posicao < totalDeAlunos;
	}

	public Aluno pega(int posicao) {
		/* Retorna o aluno na posição inserida */
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		return alunos[posicao];
	}

	public void remove(int posicao) {
		/*
		 * Remove o aluno em determinada posição e move todos os outros elementos a
		 * direita para a esquerda. porém o último elemento ficará duplicado, sendo
		 * necessário fazer totalDeAlunos--
		 */
		for (int i = posicao; i < this.totalDeAlunos; i++) {
			this.alunos[i] = this.alunos[i + 1];
		}
		totalDeAlunos--;
	}

	public boolean contem(Aluno aluno) {
		/*
		 * Verifica a há um aluno específico dentro deste Array. Porém utilizando
		 * alunos.length, verificará até o fim do array, as 100 posições mas utilizando
		 * totalDeAlunos, irá verificar apenas até o último aluno inserido
		 */
		for (int i = 0; i < totalDeAlunos; i++) {
			// aluno é igual ao aluno na posição i do FOR.
			if (aluno.equals(alunos[i])) {
				return true;
			}
		}
		return false;
	}

	public int tamanho() {
		/* Basta utilizar o contador que já teremos o tamanho do array */
		return totalDeAlunos;
	}

	public String toString() {
		return Arrays.toString(alunos);
	}
}
