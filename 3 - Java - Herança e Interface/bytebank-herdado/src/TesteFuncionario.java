
public class TesteFuncionario {
	public static void main(String[] args) {
		Gerente nico = new Gerente();
		nico.setNome("Nico Steppet");
		nico.setCpf("741.852.933-45");
		nico.setSalario(2600.00);
		
		System.out.println(nico.getNome());
		
		System.out.println(nico.getBonificacao());
	}
}
