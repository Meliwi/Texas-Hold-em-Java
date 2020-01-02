package poker;


/*SEGUNDA ENTREGA DEL PROYECTO
 * Gonzalez Nebrijo Melissa 1832127
 * Gonzalez Hernandez Michelle 1871074
 * */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaPrincipal.
 * Ventana que se muestra al iniciar el juego. 
 */
public class VentanaPrincipal extends JFrame {

		/** The gif animado. */
		private JLabel iniciarJuego, gifAnimado;
		
		/** The versus. */
		private VentanaVersus versus;
		
		/** The fondo. */
		private JLayeredPane fondo;
		
		/** The panel boton. */
		private JPanel panelBoton;
		
		/** The escucha. */
		private Escucha escucha;
		
		/** The imagen. */
		private ImageIcon imagen;
		
		/** The clip. */
		private Clip clip;
		
		/** The sonido iniciar. */
		private Clip sonidoIniciar;
		
		/**
		 * Instantiates a new ventana principal.
		 */
		public VentanaPrincipal() {
			initGUI();
			
			setSize(new Dimension(622,622));
			setTitle("Poker");
			setLocationRelativeTo(null);
			setVisible(true);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			reproducir();
		}
		
		/**
		 * Inits the GUI.
		 */
		private void initGUI() {
			//fondo
			
			fondo = new JLayeredPane();
			fondo.setSize(new Dimension(622,622));
			fondo.setLayout(new BorderLayout());
			add(fondo);
			
			//escucha
			escucha = new Escucha();
			
			
			imagen = new ImageIcon("src/Recursos/FondoVentanaPrincipal.gif");
			JLabel background = new JLabel(imagen);
			background.setSize(new Dimension(622,622));
			fondo.add(background,150);
		
			
			
			//Boton iniciarJuego
			imagen = new ImageIcon("src/Recursos/botonIniciar.png");
			iniciarJuego = new JLabel(imagen);
			iniciarJuego.addMouseListener(escucha);
			
			
			//panelBoton
			
			panelBoton = new JPanel();
			panelBoton.setBackground(new Color(0,0,0,0));
			panelBoton.setSize(new Dimension(630,630));
			panelBoton.setLayout(new BorderLayout());
			panelBoton.add(iniciarJuego, BorderLayout.PAGE_END);
			fondo.add(panelBoton, 0);
	
			
		}
		
		/**
		 * Reproducir.
		 * Es la funcion que se encarga de reproducir la musica de fondo y repetirla en caso 
		 * de que acabe. 
		 */
		private void reproducir() {
			try {
				
				clip = AudioSystem.getClip();
				File archivo = new File("src/Recursos/instrumentalsong.wav");
				clip.open(AudioSystem.getAudioInputStream(archivo));
		        clip.start();
		        clip.loop(Clip.LOOP_CONTINUOUSLY);
		        
			}
			catch(LineUnavailableException e){
				e.printStackTrace();
			}
			catch(IOException e){
				e.printStackTrace();
			}
            catch(UnsupportedAudioFileException e){
            	e.printStackTrace();
			}
			
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
				if(e.getSource()==iniciarJuego) {
					try {
						
						sonidoIniciar = AudioSystem.getClip();
						File archivo = new File("src/Recursos/Iniciar.wav");
						sonidoIniciar.open(AudioSystem.getAudioInputStream(archivo));
						sonidoIniciar.start();				        
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
					
					versus = new VentanaVersus();
					setVisible(false);
					setEnabled(false);
				}	
			}

		}
				
}
