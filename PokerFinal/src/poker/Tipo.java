package poker;


/*SEGUNDA ENTREGA DEL PROYECTO
 * Gonzalez Nebrijo Melissa 1832127
 * Gonzalez Hernandez Michelle 1871074
 * */

// TODO: Auto-generated Javadoc
/**
 * The Class Tipo.
 * Es una clase que guarda las relaciones que hay entre las cartas
 * Contiene el valor de la carta y la cantidad que hay del mismo valor.
 */
public class Tipo {
	
	/** The valor carta. */
	private int valorCarta;
	
	/** The cantidad. */
	private int cantidad;
	
	/**
	 * Instantiates a new tipo.
	 *
	 * @param valorCarta the valor carta
	 * @param cantidad the cantidad
	 */
	public Tipo(int valorCarta, int cantidad) {
		this.valorCarta = valorCarta;
		this.cantidad = cantidad;
	}
	
	/**
	 * Retornar valor.
	 *
	 * @return the int
	 */
	public int retornarValor() {
		return valorCarta;
	}
	
	/**
	 * Retornar cantidad.
	 *
	 * @return the int
	 */
	public int retornarCantidad() {
		return cantidad;
	}
}
