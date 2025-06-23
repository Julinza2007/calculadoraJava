import GUI.Calculadora;

public class ClasePrimaria {

	public static void main(String[] args) {
		mostrarCalculadora();
	}
	
	public static void mostrarCalculadora() {
		Calculadora calc = new Calculadora();
		calc.setVisible(true);
	}

}
