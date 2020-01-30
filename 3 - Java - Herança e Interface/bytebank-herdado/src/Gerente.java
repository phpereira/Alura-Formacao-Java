//Gerente herda(extends) Funcionario e assina o contrato autenticavel
public class Gerente extends Funcionario implements Autenticavel {

	private int senha;

	public double getBonificacao() {
		System.out.println("Testa bonificação do Gerente");
		return super.getSalario(); // super diz que a salario está definido na classe pai funcionario
	}

	@Override
	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public boolean autentica(int senha) {
		if (this.senha == senha) {
			return true;
		} else {
			return false;
		}
	}

}