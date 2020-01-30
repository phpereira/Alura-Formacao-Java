
public class ContaCorrente extends Conta {
	
	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero); 
	}
	//Construtores não são herdados, sendo preciso definir um construtor específico na 
	//classe FILHA passando os parâmetros do construtor ESPECÍFICO para a classe Mãe.

	
	@Override
	public boolean saca(double valor) {
		double valorASacar = valor + 0.2;
		return super.saca(valorASacar);
	}
}
