
public class TestaTributaveis {

	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(111, 1111);
		cc.deposita(100.0);

		SeguroDeVida sv = new SeguroDeVida();

		CalculadorImposto calc = new CalculadorImposto();
		calc.registra(cc);
		calc.registra(sv);

		System.out.println("CC = " + cc.getValorImposto());
		System.out.println("SV = " + sv.getValorImposto());
		System.out.println("Total = " + calc.getTotalImposto());
	}

}
