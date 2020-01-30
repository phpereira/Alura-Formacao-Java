//Gerente herda(extends) Funcionario e assina o contrato autenticavel
public class Gerente extends Funcionario implements Autenticavel {

	private AutenticacaoUtil autenticador;

	public Gerente() {
		this.autenticador = new AutenticacaoUtil();
	}

	@Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}

	@Override
	public boolean autentica(int senha) {
		return this.autenticador.autentica(senha);
		
	}

	public double getBonificacao() {
		System.out.println("Testa bonificação do Gerente");
		return super.getSalario(); // super diz que a salario está definido na classe pai funcionario
	}
}