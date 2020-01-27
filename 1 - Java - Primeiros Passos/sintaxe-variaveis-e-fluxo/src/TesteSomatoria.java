
public class TesteSomatoria {
	public static void main(String[] args) {
		int contador = 0;
		int total = 0;
		while(contador <= 10) {
			
//			int total = 0; colocando o total aqui, ele inicializa com 0 SEMPRE.
			
//			total = total + contador;
			total += contador;

			contador++;
		}
		System.out.println(total);
	}
}
