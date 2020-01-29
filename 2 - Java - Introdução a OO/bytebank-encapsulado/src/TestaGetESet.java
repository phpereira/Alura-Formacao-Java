
public class TestaGetESet {
	public static void main(String[] args) {
		Conta conta = new Conta(1337, 24226);
//		conta.numero = 1337;  --- Está encapsulado e setado, não é possível alterar diretamente
//		conta.setNumero(1337); --- Agora já setado no construtor
		System.out.println(conta.getNumero());
		
		Cliente paulo = new Cliente();
//		conta.titular = paulo;
		paulo.setNome("Paulo Pereira");
		
		conta.setTitular(paulo);
		
		System.out.println(conta.getTitular().getNome());
		
		conta.getTitular().setProfissao("Programador");
		//agora em duas linhas
		Cliente titularDaConta = conta.getTitular();
		titularDaConta.setProfissao("Programador");
		
		System.out.println(titularDaConta);
		System.out.println(paulo);
		System.out.println(conta.getTitular());
	}
}
