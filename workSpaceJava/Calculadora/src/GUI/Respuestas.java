package GUI;

public class Respuestas {
	
	public static double ansBasico;
	public static double[] ansVector;
	public static double[][] ansMatriz;

// Agregar más variables estáticas (ELU Y SEBAS) según sea necesario para otras operaciones
	
	
	public static void guardarRespuestas(int operacion, double ansBasico, double[] ansVector, double ansMatriz[][] /*ACÁ FIJENSE USTEDES CHICOS (elu y sebas)*/ ) {
		switch (operacion) {
		case 1: // Operaciones basicas.
			Respuestas.ansBasico = ansBasico;
			break;
			
		case 2: // Operaciones con vectores.
			Respuestas.ansVector = ansVector;
			break;
			
		case 3: // Operaciones con matrices.
			Respuestas.ansMatriz = ansMatriz;
		break;
		}
	}
	
	public static double obtenerBasico() {
		return ansBasico;
	}
	
	public static double[] obtenerVector() {
		return ansVector;
	}
	
	
	public static double[][] obtenerMatriz() {
		return ansMatriz;
	}
    
}