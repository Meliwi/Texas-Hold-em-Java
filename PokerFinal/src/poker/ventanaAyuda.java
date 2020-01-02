package poker;


/*SEGUNDA ENTREGA DEL PROYECTO
 * Gonzalez Nebrijo Melissa 1832127
 * Gonzalez Hernandez Michelle 1871074
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class ventanaAyuda.
 * Es una ventana que muestra las posibles jugadas de una mano
 */
public class ventanaAyuda extends JFrame {
	
	/** The panel ayuda. */
	private PanelFondo panelAyuda;
	
	/** The continuar partida. */
	private JLabel jugadas, continuarPartida;
	
	/** The imagen. */
	private ImageIcon imagen;
	
	/** The clip. */
	private Clip clip;
	
	/** The escucha. */
	private Escucha escucha;
	
	
	/**
	 * Instantiates a new ventana ayuda.
	 */
	public ventanaAyuda() {
		
		setUndecorated(true);
		setSize(new Dimension(530,315));
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Escucha
		escucha = new Escucha();
		
		//PanelAyuda
		panelAyuda = new PanelFondo();
		panelAyuda.establecerFondo("src/Recursos/fondoMesa.jpg");		
		
		//JLabel
		imagen = new ImageIcon("src/Recursos/ayudaFoto.png");
		jugadas = new JLabel(imagen);
		panelAyuda.add(jugadas);
		
		//Boton
		imagen = new ImageIcon("src/Recursos/continuarpartidanew.png");
		continuarPartida = new JLabel(imagen);
		continuarPartida.addMouseListener(escucha);
		panelAyuda.add(continuarPartida);
		
		add(panelAyuda);				
	}
	
	/**
	 * The Class Escucha.
	 */
	private class Escucha extends MouseAdapter implements MouseListener{

		/**
		 * Mouse clicked.
		 *
		 * @param e the e
		 */
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==continuarPartida) {
				try {
					
					clip = AudioSystem.getClip();
					File archivo = new File("src/Recursos/general.wav");
					clip.open(AudioSystem.getAudioInputStream(archivo));
					clip.start();				        
				}
				catch(LineUnavailableException a){
					a.printStackTrace();
				}
				catch(IOException a){
					a.printStackTrace();
				}
	            catch(UnsupportedAudioFileException a){
	            	a.printStackTrace();
				}
				setVisible(false);
				setEnabled(false);
			}			
		}		
	}
}
