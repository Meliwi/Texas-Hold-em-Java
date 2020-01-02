package poker;


/*SEGUNDA ENTREGA DEL PROYECTO
 * Gonzalez Nebrijo Melissa - 1832127
 * Gonzalez Hernandez Michelle - 1871074
 * */

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelMesa.
 * Tiene las cinco que hacen parte de toda la ronda
 */
public class PanelMesa extends PanelFondo {
	
	/** The carta cinco. */
	private Carta cartaUno, cartaDos, cartaTres, cartaCuatro, cartaCinco;
	
	/** The imagen. */
	private ImageIcon imagen;
	
	/** The mazo cartas. */
	private MazoCartas mazoCartas;
	
	/**
	 * Instantiates a new panel mesa.
	 *
	 * @param mazoCartas the mazo cartas
	 */
	public PanelMesa(MazoCartas mazoCartas) {
		this.mazoCartas = mazoCartas;
		
		this.establecerFondo("src/Recursos/casinoroyalnew.png");
		setPreferredSize(new Dimension(500,200));
		
		//Cartas de la mesa
		imagen = new ImageIcon("src/Recursos/Cartas completas/cartaBocaAbajo.png");
		
		cartaUno = new Carta(imagen, "",0);
		add(cartaUno);
		
		cartaDos = new Carta(imagen ,"",0);
		add(cartaDos);
		
		cartaTres = new Carta(imagen,"" ,0);
		add(cartaTres);
		
		cartaCuatro = new Carta(imagen,"",0);
		add(cartaCuatro);
		
		cartaCinco = new Carta(imagen,"",0);
		add(cartaCinco);
		
	}
	
	/**
	 * Retornar mazomesa.
	 *
	 * @return the carta[]
	 */
	public Carta[] retornarMazomesa() {
		Carta mazoMesa[] = new Carta[5];
		mazoMesa[0] = cartaUno;
		mazoMesa[1] = cartaDos;
		mazoMesa[2] = cartaTres;
		mazoMesa[3] = cartaCuatro;
		mazoMesa[4] = cartaCinco;		
		return mazoMesa;
	}
	
	/**
	 * Etapas ronda.
	 *Es la funcion encargada de establecer las cartas aleatoriamente en cada una de las rondas 
	 *que hacen parte del juego que son flop, turn y river
	 * @param ronda the ronda
	 */
	public void etapasRonda(int ronda) {
		if(ronda ==1) {
			/*cartaUno.establecerCarta(mazoCartas.retornarCarta());
			cartaDos.establecerCarta(mazoCartas.retornarCarta());
			cartaTres.establecerCarta(mazoCartas.retornarCarta());	*/
			imagen = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/2.png");
			cartaUno.establecerCarta(new Carta(imagen,"corazones" , 2));
			
			imagen = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/3.png");
			cartaDos.establecerCarta(new Carta(imagen,"corazones" , 3));
			
			imagen = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/4.png");
			cartaTres.establecerCarta(new Carta(imagen,"corazones" , 4));
			

		}
		if(ronda == 2) {
			//cartaCuatro.establecerCarta(mazoCartas.retornarCarta());
			imagen = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/5.png");
			cartaCuatro.establecerCarta(new Carta(imagen,"corazones" , 5));

			
		}
		if(ronda == 3) {
			//cartaCinco.establecerCarta(mazoCartas.retornarCarta());
			imagen = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/6.png");
			cartaCinco.establecerCarta(new Carta(imagen,"corazones" , 6));
			
		}
	}
}
