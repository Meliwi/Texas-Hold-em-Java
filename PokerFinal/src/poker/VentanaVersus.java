package poker;


/*SEGUNDA ENTREGA DEL PROYECTO
 * Gonzalez Nebrijo Melissa 1832127
 * Gonzalez Hernandez Michelle 1871074
 * */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
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
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaVersus.
 * Esta ventana contiene los gifs animados de los personajes patrick y alex que representan
 * al jugador y al computador.
 */
public class VentanaVersus extends JFrame {
	
	/** The panel versus. */
	private PanelFondo panelVersus;
	
	/** The continuar. */
	private JLabel jugador, computador , nombreComputador, nombreJugador, continuar;
	
	/** The imagen. */
	private ImageIcon imagen;
	
	/** The escucha. */
	private Escucha escucha;
	
	/** The ventana juego. */
	private VentanaJuego ventanaJuego;
	
	/** The sonido continuar. */
	private Clip sonidoContinuar;
	
	/**
	 * Instantiates a new ventana versus.
	 */
	public VentanaVersus(){
		initGUI();
		
		setUndecorated(true);
		setSize(new Dimension(500,450));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	/**
	 * Inits the GUI.
	 */
	private void initGUI(){
		//Escucha
		escucha = new Escucha();
	
		//panelVersus
		panelVersus = new PanelFondo();
		panelVersus.setSize(new Dimension(500,450));
		panelVersus.setLayout(null);
		panelVersus.establecerFondo("src/Recursos/fondoVersus.jpg");
		add(panelVersus);
	
		//Jugador, computador
		imagen = new ImageIcon("src/Recursos/jugador.gif");
		jugador = new JLabel(imagen);
		panelVersus.add(jugador);
		jugador.setLocation(300, 80);
		jugador.setSize(new Dimension(128,220));
		
		imagen = new ImageIcon("src/Recursos/computador.gif");
		computador = new JLabel(imagen);
		panelVersus.add(computador);
		computador.setLocation(50,80);
		computador.setSize(new Dimension(128,220));
		
		//Nombres
		imagen = new ImageIcon("src/Recursos/nombreComputador (1).gif");
		nombreComputador = new JLabel(imagen);
		panelVersus.add(nombreComputador);
		nombreComputador.setLocation(50, 50);
		nombreComputador.setSize(new Dimension(131,89));
		
		imagen = new ImageIcon("src/Recursos/nombreJugador.gif");
		nombreJugador = new JLabel(imagen);
		panelVersus.add(nombreJugador);
		nombreJugador.setLocation(300,300);
		nombreJugador.setSize(new Dimension(131,89));
		
		//BotonContinuar
		imagen = new ImageIcon("src/Recursos/boton continuar (8).png");
		continuar = new JLabel(imagen);
		panelVersus.add(continuar);
		continuar.setLocation(160,370);
		continuar.setSize(new Dimension(197,70));
		continuar.addMouseListener(escucha);
		
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
			if(e.getSource()==continuar) {
				try {
					
					sonidoContinuar = AudioSystem.getClip();
					File archivo = new File("src/Recursos/continuar.wav");
					sonidoContinuar.open(AudioSystem.getAudioInputStream(archivo));
					sonidoContinuar.start();				        
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
				ventanaJuego = new VentanaJuego();
				setVisible(false);
				setEnabled(false);
			}		
		}		
	}
}
