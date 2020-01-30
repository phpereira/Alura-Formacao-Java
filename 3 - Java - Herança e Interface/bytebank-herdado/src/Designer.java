public class Designer extends Funcionario{
	
	public double getBonificacao() {
		System.out.println("Testa bonificação do Designer");
		return 150; //super diz que a salario está definido na classe pai funcionario
	}
	
}

