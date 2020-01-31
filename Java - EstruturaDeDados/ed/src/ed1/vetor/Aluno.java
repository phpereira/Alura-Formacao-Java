package ed1.vetor;
public class Aluno {
	private String nome;
	
	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public boolean equals(Object obj) {
//		if (obj == null) return false; /* Desta forma verifica se há algum Aluno nulo, mas preferi implementar direto na classe Vetor, no método contem. */
		Aluno outro = (Aluno) obj;
		return outro.getNome().equals(this.nome);
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
