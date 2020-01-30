
public class TestaReferencias {
	public static void main(String[] args) {
		Gerente g1 = new Gerente();
		g1.setNome("Marcos");
		g1.setSalario(5000.0);
		
		Designer d = new Designer();
		d.setSalario(2000.0);
		
		EditorDeVideo e = new EditorDeVideo();
		e.setSalario(5000.0);
		
		ControleBonificacao controle = new ControleBonificacao();

		controle.registra(g1);

		controle.registra(d);

		controle.registra(e);
		
		System.out.println(controle.getSoma());
	}

}
