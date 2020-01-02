package poker;


/*SEGUNDA ENTREGA DEL PROYECTO
 * Gonzalez Nebrijo Melissa 1832127
 * Gonzalez Hernandez Michelle 1871074
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelDealer.
 * Contiene todo lo relacionado con las apuestas tanto del computador como el jugador, el monto
 * disponible de este ultimo y el total de las apuestas durante la ronda
 */
public class PanelDealer extends JPanel {
	
	/** The dinero disponible. */
	private JTextField apuestaJugador , apuestaComputador, apuestaTotal , dineroDisponible;
	
	/** The letra dinero disponible. */
	private JLabel perfilDealer, letraApuestaJugador , letraApuestaComputador, letraApuestaTotal, letraDineroDisponible ;
	
	/** The imagen. */
	private ImageIcon imagen;
	
	/** The fichas jugador. */
	private JLabel fichasComputador, fichasJugador;
	
	/** The control dealer. */
	private JPanel controlComputador , controlJugador , controlDealer;
	
	/** The ayuda. */
	private JLabel abandonar, pasarTurno, ayuda;
	
	/** The escucha. */
	private Escucha escucha;
	
	/** The sonido boton. */
	private Clip sonidoBoton;
	
	/** The ventana ayuda. */
	private ventanaAyuda ventanaAyuda;
	
	/** The total apuesta. */
	private int montoJugador, jugadorApuesta, totalApuesta;
	
	/** The warning. */
	private JFrame ventanaMensajes, warning;
	
	/** The escucha teclado. */
	private EscuchaTeclado escuchaTeclado;
	
	
	
	/**
	 * Instantiates a new panel dealer.
	 *
	 * @param ventanaMensajes the ventana mensajes
	 * @param warning the warning
	 */
	public PanelDealer(JFrame ventanaMensajes, JFrame warning) {
		//Inicialiaar ventanaMensajes
		this.ventanaMensajes = ventanaMensajes;
		this.warning = warning;
		
		//Montos
		montoJugador = 10000;
		jugadorApuesta = 0;
		totalApuesta = 0;
		
		//Instanciamos el escucha
		escucha = new Escucha();
		escuchaTeclado = new EscuchaTeclado();

		//Paneles internos
		controlComputador = new JPanel();
		controlJugador = new JPanel();
		controlDealer = new JPanel();
		
		controlComputador.setPreferredSize(new Dimension(300,200));
		controlJugador.setPreferredSize(new Dimension(300,200));
		controlDealer.setPreferredSize(new Dimension(230,200));
		
		
		controlComputador.setBackground(Color.BLACK);
		controlJugador.setBackground(Color.BLACK);
		controlDealer.setBackground(Color.BLACK);
		
		
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(300,610));
		//Apuesta del computador
		imagen = new ImageIcon("src/Recursos/fichass_opt.png");
		fichasComputador = new JLabel(imagen);
		controlComputador.add(fichasComputador);
		
		imagen = new ImageIcon("src/Recursos/apuestaBoton.png");
		letraApuestaComputador = new JLabel(imagen);
		controlComputador.add(letraApuestaComputador);
		
		Font fuente = new Font(Font.DIALOG, Font.BOLD,20);
		apuestaComputador = new JTextField();
		apuestaComputador.setPreferredSize(new Dimension(70,25));
		apuestaComputador.setText(""+jugadorApuesta);
		apuestaComputador.setFont(fuente);
		apuestaComputador.setDisabledTextColor(Color.BLACK);
		apuestaComputador.setEnabled(false);
		controlComputador.add(apuestaComputador);
		

		imagen = new ImageIcon("src/Recursos/ayudaBoton.png");
		ayuda = new JLabel(imagen);
		ayuda.addMouseListener(escucha);
		controlComputador.add(ayuda);
	
		
		//Dealer
		imagen = new ImageIcon("src/Recursos/CuadroDealer (1).gif");
		perfilDealer = new JLabel(imagen);
		controlDealer.add(perfilDealer);
		
		imagen = new ImageIcon("src/Recursos/totalBoton.png");
		letraApuestaTotal = new JLabel(imagen);
		controlDealer.add(letraApuestaTotal);
		
		apuestaTotal = new JTextField();
		apuestaTotal.setPreferredSize(new Dimension(70,25));
		apuestaTotal.setText(""+totalApuesta);
		apuestaTotal.setFont(fuente);
		apuestaTotal.setDisabledTextColor(Color.BLACK);
		apuestaTotal.setEnabled(false);
		controlDealer.add(apuestaTotal);
		
		imagen = new ImageIcon("src/Recursos/pasarTurnoBoton.png");
		pasarTurno = new JLabel(imagen);
		pasarTurno.addMouseListener(escucha);
		controlDealer.add(pasarTurno);
		
		//Apuesta del jugador
		imagen = new ImageIcon("src/Recursos/fichass_opt.png");
		fichasJugador = new JLabel(imagen);
		controlJugador.add(fichasJugador);
			
		imagen = new ImageIcon("src/Recursos/apuestaBoton.png");
		letraApuestaJugador = new JLabel(imagen);
		controlJugador.add(letraApuestaJugador);
		
		apuestaJugador = new JTextField();
		apuestaJugador.setPreferredSize(new Dimension(70,25));
		apuestaJugador.setText(""+jugadorApuesta);
		apuestaJugador.setFont(fuente);
		apuestaJugador.setForeground(Color.BLACK);
		apuestaJugador.setDisabledTextColor(Color.BLACK);
		apuestaJugador.setEnabled(false);
		apuestaJugador.addKeyListener(escuchaTeclado);
		controlJugador.add(apuestaJugador);
		
		imagen = new ImageIcon("src/Recursos/disponibleBoton.png");
		letraDineroDisponible = new JLabel(imagen);
		controlJugador.add(letraDineroDisponible);
		
		dineroDisponible = new JTextField();
		dineroDisponible.setPreferredSize(new Dimension(70,25));
		dineroDisponible.setText(""+montoJugador);
		dineroDisponible.setFont(fuente);
		dineroDisponible.setDisabledTextColor(Color.BLACK);
		dineroDisponible.setEnabled(false);
		controlJugador.add(dineroDisponible);
	
		
		imagen = new ImageIcon("src/Recursos/abandonarBoton.png");
		abandonar = new JLabel(imagen);
		abandonar.addMouseListener(escucha);
		controlJugador.add(abandonar);
	
		
		
		
		add(controlComputador);
		add(controlDealer);
		add(controlJugador);
		
		//Ventana ayuda
		ventanaAyuda = new ventanaAyuda();
	}
	
	/**
	 * Activar apuesta.
	 */
	public void activarApuesta() {
		apuestaJugador.setEnabled(true);
	}
	
	
	/**
	 * The Class EscuchaTeclado.
	 */
	private class EscuchaTeclado implements KeyListener{

		/**
		 * Key pressed.
		 *
		 * @param arg0 the arg 0
		 */
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		/**
		 * Key released.
		 *De ser posible toma el valor que hay en el JTextField de la apuesta del
		 *jugador una vez es presionada la tecla enter.
		 * @param e the e
		 */
		public void keyReleased(KeyEvent e) {
			if(e.getSource()==apuestaJugador) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(apuestaJugador.getText().equals("")) {
						
					}
					else {
						int valor = Integer.parseInt(apuestaJugador.getText());
						if((montoJugador-valor)<0) {
							
						}
						else {
							jugadorApuesta = valor;
							montoJugador -= valor;
							dineroDisponible.setText(""+montoJugador);
							
							apuestaComputador.setText(""+jugadorApuesta);
							totalApuesta += jugadorApuesta*2;
							
							apuestaTotal.setText(""+totalApuesta);	
						}		
					}	
				}
				
			}
			
		}
		
		/**
		 * Key typed.
		 *
		 * @param e the e
		 */
		public void keyTyped(KeyEvent e) {
			
		}
		
	}
	
	/**
	 * Resultados.
	 * Recibe un string que indica el ganador de la ronda y en base a esto modifica los valores
	 * relacionados con los montos de los jugadores
	 *
	 * @param ganador the ganador
	 */
	public void resultados(String ganador) {
		if(ganador.equals("jugador")) {
			montoJugador += totalApuesta;
			totalApuesta = 0;
			jugadorApuesta = 0;
			apuestaComputador.setText("" + 0);
			apuestaJugador.setText("" + jugadorApuesta);
			
			dineroDisponible.setText(""+montoJugador); 
			apuestaTotal.setText(""+0);
		}
		else {
			montoJugador -= jugadorApuesta;
			totalApuesta = 0;
			jugadorApuesta = 0;
			apuestaComputador.setText("" + 0);
			apuestaJugador.setText("" + jugadorApuesta);
			
			dineroDisponible.setText(""+montoJugador); 
			apuestaTotal.setText(""+0);
		}
		
	}
		
	/**
	 * The Class Escucha.
	 */
	private class Escucha extends MouseAdapter implements MouseListener{
		
		/**
		 * Mouse clicked.
		 *Cuando se presiona el boton se activa un sonido y se habilita la ventana de warning 
		 * @param e the e
		 */
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == abandonar) {
				try {
					sonidoBoton = AudioSystem.getClip();
					File archivo = new File("src/Recursos/Abandonar.wav");
					sonidoBoton.open(AudioSystem.getAudioInputStream(archivo));
			        sonidoBoton.start();
			        
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
				warning.setEnabled(true);
				warning.setVisible(true);
			}
			//Habilita la ventana de mensajes que se encarga de mostrar el progreso del 
			//estado del juego
			if(e.getSource() == pasarTurno) {
				try {
					sonidoBoton = AudioSystem.getClip();
					File archivo = new File("src/Recursos/general.wav");
					sonidoBoton.open(AudioSystem.getAudioInputStream(archivo));
			        sonidoBoton.start();
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
				ventanaMensajes.setVisible(true);
				ventanaMensajes.setEnabled(true);
			}
			//Despliega una ventana que muestra las posibles jugadas para una mano
			if(e.getSource() == ayuda) {
				try {
					sonidoBoton = AudioSystem.getClip();
					File archivo = new File("src/Recursos/general.wav");
					sonidoBoton.open(AudioSystem.getAudioInputStream(archivo));
			        sonidoBoton.start();
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
				ventanaAyuda.setVisible(true);
				ventanaAyuda.setEnabled(true);
				
			}
		}
	}
	
	
}
