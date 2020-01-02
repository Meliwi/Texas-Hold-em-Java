package poker;

/*SEGUNDA ENTREGA DEL PROYECTO
 * Gonzalez Nebrijo Melissa 1832127
 * Gonzalez Hernandez Michelle 1871074
 * */

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class Carta.
 * 
 * En esta clase se recibe la imagen de la carta , su palo y su valor;
 */
public class Carta extends JLabel implements Comparable<Carta>{
	
	/** The imagen carta. */
	private ImageIcon imagenCarta;
	
	/** The palo. */
	private String palo;
	
	/** The valor. */
	private int valor;
	
	/**
	 * Instantiates a new carta.
	 *
	 * @param imagenCarta the imagen carta
	 * @param palo the palo
	 * @param valor the valor
	 */
	public Carta(ImageIcon imagenCarta ,String palo, int valor ) {
		this.imagenCarta = imagenCarta;
		this.palo = palo;
		this.valor = valor;
		setIcon(imagenCarta);
	}
	
	/**
	 * Retornar imagen.
	 *
	 * @return the image icon
	 */
	public ImageIcon retornarImagen() {
		return imagenCarta;
	}
	
	/**
	 * Retornar palo.
	 *
	 * @return the string
	 */
	public String retornarPalo() {
		return palo;
	}
	
	/**
	 * Retornar valor.
	 *
	 * @return the int
	 */
	public int retornarValor() {
		return valor;
	}
	
	/**
	 * Establecer carta.
	 * Recibe una carta, los valores de la que carta que esta llamando la funcion son reemplazados por
	 * los de la nueva carta junto con la imagen
	 *
	 * @param cartaNueva the carta nueva
	 */
	public void establecerCarta(Carta cartaNueva) {
		imagenCarta = cartaNueva.retornarImagen();
		palo = cartaNueva.retornarPalo();
		valor = cartaNueva.retornarValor();
		setIcon(imagenCarta);
	}


	public int compareTo(Carta c) {
		if(valor<c.valor) {
			return 1;
		}
		if(valor>c.valor) {
			return -1;
		}
		return 0;
	}
	
}
