public class EditorDeVideo extends Funcionario{
	
	public double getBonificacao() {
		System.out.println("Testa bonificação do Editor de vídeo");
		return super.getBonificacao() + 100; //super diz que a salario está definido na classe pai funcionario
	}
	
}

