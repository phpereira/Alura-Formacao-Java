
public class CalculadorImposto {

	private double totalImposto;
	
	public void registra(Tributavel t) {
		this.totalImposto += t.getValorImposto();
	}
	
	public double getTotalImposto() {
		return totalImposto;
	}
}
