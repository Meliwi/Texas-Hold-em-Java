package poker;



/*SEGUNDA ENTREGA DEL PROYECTO
 * Gonzalez Nebrijo Melissa 1832127
 * Gonzalez Hernandez Michelle 1871074
 * */

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelFondo.
 * Esta clase permite establecer el fondo de un panel facilmente
 */
public class PanelFondo extends JPanel {
	
	/** The fondo. */
	private Image fondo;
	
	/**
	 * Paint component.
	 *
	 * @param g the g
	 */
	public void paintComponent(Graphics g) {	
		int alto = getSize().height;
		int ancho = getSize().width;
		if(fondo != null) {
			g.drawImage(fondo,0,0,ancho,alto,null);
		}
		super.paintComponent(g);
	}
	
	/**
	 * Establecer fondo.
	 *
	 * @param direccionImagen the direccion imagen
	 */
	public void establecerFondo(String direccionImagen) {
		setOpaque(false);
		fondo = new ImageIcon(direccionImagen).getImage();
		repaint();
	}
}
