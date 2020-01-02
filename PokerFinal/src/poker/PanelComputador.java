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
 * The Class PanelComputador.
 * Aqui se almacena todo lo relacionado con las acciones que suceden en el panel del computador
 */
public class PanelComputador extends PanelFondo {
	
	/** The imagen. */
	private ImageIcon imagen;
	
	/** The perfil computador. */
	private JLabel perfilComputador;
	
	/** The carta dos. */
	private Carta cartaUno, cartaDos;
	
	/** The mazo cartas. */
	private MazoCartas mazoCartas;
	
	/** The mazo computador. */
	private Carta mazoComputador[];
	
	/**
	 * Instantiates a new panel computador.
	 *
	 * @param mazoCartas the mazo cartas
	 */
	public PanelComputador(MazoCartas mazoCartas) {
		this.mazoCartas = mazoCartas;
		
		this.establecerFondo("src/Recursos/computador.png");
		setPreferredSize(new Dimension(500,200));
		setLayout(null);
		
		//perfilJugador
		imagen = new ImageIcon("src/Recursos/CuadroComputador (1).gif");
		perfilComputador = new JLabel(imagen);
		add(perfilComputador);
		perfilComputador.setLocation(65,85);
		perfilComputador.setSize(new Dimension(163,56));
		
		//Cartas del jugador				
		imagen = new ImageIcon("src/Recursos/Cartas completas/cartaBocaAbajo.png");
		cartaUno = new Carta(imagen, "",0);
        add(cartaUno);
        cartaUno.setLocation(250, 65);
        cartaUno.setSize(new Dimension(74,103));
		
		cartaDos = new Carta(imagen,"" ,0);
		add(cartaDos);
		cartaDos.setLocation(340, 65);
		cartaDos.setSize(new Dimension(74,103));
						
	}
	
	/**
	 * Retornar mazocomputador.
	 *
	 * @return the carta[]
	 */
	public Carta[] retornarMazocomputador() {
		return mazoComputador;
	}
	
	/**
	 * Repartir cartas.
	 * Instancia el mazo con dos cartas aleatorias.
	 */
	public void repartirCartas() {
		mazoComputador = new Carta[2];
		mazoComputador[0] = mazoCartas.retornarCarta();
		mazoComputador[1] = mazoCartas.retornarCarta();
	}
	
	/**
	 * Mostrar cartas.
	 */
	public void mostrarCartas() {
		cartaUno.establecerCarta(mazoComputador[0]);
		cartaDos.establecerCarta(mazoComputador[1]);
	}
}
