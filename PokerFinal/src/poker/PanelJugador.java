package poker;


/*SEGUNDA ENTREGA DEL PROYECTO
 * Gonzalez Nebrijo Melissa 1832127
 * Gonzalez Hernandez Michelle 1871074
 * */

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelJugador.
 * Contiene todo lo relacionado con el panel del jugador
 */
public class PanelJugador extends PanelFondo {
	
	/** The imagen. */
	private ImageIcon imagen;
	
	/** The perfil jugador. */
	private JLabel perfilJugador;
	
	/** The carta dos. */
	private Carta cartaUno, cartaDos;
	
	/** The mazo cartas. */
	private MazoCartas mazoCartas;
	
	/**
	 * Instantiates a new panel jugador.
	 *
	 * @param mazoCartas the mazo cartas
	 */
	public PanelJugador(MazoCartas mazoCartas) {
		this.mazoCartas = mazoCartas;
		
		this.establecerFondo("src/Recursos/jugador.png");
		setPreferredSize(new Dimension(500,200));
		setLayout(null);
		
		//Cartas del jugador
		imagen = new ImageIcon("src/Recursos/Cartas completas/cartaBocaAbajo.png");
		cartaUno = new Carta(imagen, "", 0);
		add(cartaUno);
		cartaUno.setLocation(110, 45);
		cartaUno.setSize(new Dimension(74,103));
		
		cartaDos = new Carta(imagen, "", 0);
		add(cartaDos);
		cartaDos.setLocation(200, 45);
		cartaDos.setSize(new Dimension(74,103));
		
		//perfilJugador
		imagen = new ImageIcon("src/Recursos/CuadroJugador (1).gif");
		perfilJugador = new JLabel(imagen);
		add(perfilJugador);
		perfilJugador.setLocation(300,65);
		perfilJugador.setSize(new Dimension(163,56));
							
	}
	
	/**
	 * Retornar mazojugador.
	 *
	 * @return the carta[]
	 */
	public Carta[] retornarMazojugador() {
		Carta mazoJugador[] = new Carta[2];
		mazoJugador[0] = cartaUno;
		mazoJugador[1] = cartaDos;
		return mazoJugador;
	}
	
	
	/**
	 * Repartir cartas.
	 * Instancia el mazo del jugador con dos cartas aleatorias
	 */
	public void repartirCartas() {
		cartaUno.establecerCarta(mazoCartas.retornarCarta());
		cartaDos.establecerCarta(mazoCartas.retornarCarta());

	}
	
}
