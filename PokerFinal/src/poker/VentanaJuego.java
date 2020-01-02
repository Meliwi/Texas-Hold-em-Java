package poker;


/*SEGUNDA ENTREGA DEL PROYECTO
 * Gonzalez Nebrijo Melissa - 1832127
 * Gonzalez Hernandez Michelle - 1871074
 * */

import java.awt.Color;
import java.util.Arrays;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



// TODO: Auto-generated Javadoc
/**
 * The Class VentanaJuego.
 * Es la ventana donde se controla y muestra el progreso del juego
 */
public class VentanaJuego extends JFrame {
	
	/** The mazo cartas. */
	private MazoCartas mazoCartas;
	
	/** The mazo aux jugador. */
	private ArrayList<Carta> mazoAuxJugador = new ArrayList<Carta>();
	
	/** The copia mazo aux jugador. */
	private ArrayList<Carta> copiaMazoAuxJugador = new ArrayList<Carta>();
	
	/** The mazo aux computador. */
	private ArrayList<Carta> mazoAuxComputador = new ArrayList<Carta>();
	
	/** The copia mazo aux computador. */
	private ArrayList<Carta> copiaMazoAuxComputador = new ArrayList<Carta>();
	
	/** The mazo aleatorio jugador. */
	private ArrayList<Tipo> mazoAleatorioJugador = new ArrayList<Tipo>();
	
	/** The mazo aleatorio computador. */
	private ArrayList<Tipo> mazoAleatorioComputador = new ArrayList<Tipo>();
	
	
	
	
	/** The mazo mesa. */
	private Carta mazoComputador[] , mazoJugador[] , mazoMesa[];
	
	private Carta mazoEvaluarJugador[], mazoEvaluarComputador[];
	
	private ArrayList<Carta> manoJugador = new ArrayList<Carta>();
	
	private ArrayList<Carta> manoComputador = new ArrayList<Carta>();
	
	/** The panel jugador. */
	private PanelJugador panelJugador;
	
	/** The panel computador. */
	private PanelComputador panelComputador;
	
	/** The panel mesa. */
	private PanelMesa panelMesa;
	
	/** The panel dealer. */
	private PanelDealer panelDealer;
	
	/** The ventana mensajes. */
	private ventanaMensajes ventanaMensajes;
	
	/** The continuar. */
	private JLabel   continuar;
	
	/** The panel warning. */
	private PanelFondo panelMensajes, panelWarning;
	
	/** The imagen. */
	private ImageIcon imagen;
		
	/** The escucha warning. */
	private Escucha escucha, escuchaWarning;
	
	/** The clip. */
	private Clip clip;
	
	/** The estado del juego. */
	private int estadoDelJuego;
	
	/** The mazo guardado. */
	private ArrayList<Integer> mazoGuardado = new ArrayList();
	
	/** The warning. */
	private JFrame warning;
	
	/** The icono warning. */
	private JLabel aceptar , cancelar , mensajeWarning , iconoWarning;
	
	/**
	 * Instantiates a new ventana juego.
	 */
	public VentanaJuego() {
		ventanaMensajes = new ventanaMensajes();
		initGUI();
		
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setSize(new Dimension(820,700));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);	
		ventanaMensajes.setVisible(true);
	}
	
	/**
	 * Inits the GUI.
	 */
	private void initGUI() {
		//Mazo de cartas
		mazoCartas = new MazoCartas();
		estadoDelJuego = 1;
		
		escuchaWarning = new Escucha();
		imagen = new ImageIcon("src/Recursos/Ganador/warningReaccion.png");
		warning = new JFrame();
		warning.setLocationRelativeTo(null);
		warning.setUndecorated(false);
		warning.setSize(new Dimension(500,245));
		warning.setResizable(false);
		
		panelWarning = new PanelFondo();
		panelWarning.setBackground(new Color(0,0,0,0));
		panelWarning.establecerFondo("src/Recursos/fondoMesa.jpg");
		imagen = new ImageIcon("src/Recursos/Ganador/warningReaccion.png");
		iconoWarning = new JLabel(imagen);
		panelWarning.add(iconoWarning);
		
		imagen = new ImageIcon("src/Recursos/Ganador/warning.png");
		mensajeWarning = new JLabel(imagen);
		panelWarning.add(mensajeWarning);
		
		imagen = new ImageIcon("src/Recursos/Ganador/botonAceptar.png");
		aceptar = new JLabel(imagen);
		aceptar.addMouseListener(escuchaWarning);
		
		imagen = new ImageIcon("src/Recursos/Ganador/botonCancelar.png");
		cancelar = new JLabel(imagen);
		cancelar.addMouseListener(escuchaWarning);
		
		panelWarning.add(aceptar);
		panelWarning.add(cancelar);
		panelWarning.setPreferredSize(new Dimension(500,245));
		
		warning.add(panelWarning);
		
		
		panelJugador = new PanelJugador(mazoCartas);
		panelComputador = new PanelComputador(mazoCartas);
		panelMesa = new PanelMesa(mazoCartas);
		panelDealer = new PanelDealer(ventanaMensajes,warning);
		
		JPanel zonaJuego = new JPanel();		
		setLayout(new FlowLayout());
		
		zonaJuego.add(panelComputador);
	    zonaJuego.add(panelMesa);
		zonaJuego.add(panelJugador);
		zonaJuego.setPreferredSize(new Dimension(500,700));
		zonaJuego.setBackground(new Color(0,0,0,0));
		
		JPanel zonaDealer = new JPanel();
		zonaDealer.setPreferredSize(new Dimension(300,700));
		zonaDealer.setBackground(new Color(0,0,0,0));
		
		zonaDealer.add(panelDealer);
		
		add(zonaJuego);
		add(zonaDealer);
		
	}
	
	/**
	 * Establecer mazos.
	 * 
	 * Se hace uso de la funcion de cada panel que es la encargada de retornar los mazos 
	 * para construir el principal de cada jugador
	 */
	public void establecerMazos() {
		mazoJugador = panelJugador.retornarMazojugador();
		mazoMesa = panelMesa.retornarMazomesa();
		mazoComputador = panelComputador.retornarMazocomputador();
	}
	
	
	public void madeMazosaEvaluar() {
		mazoEvaluarJugador = new Carta[7];
		mazoEvaluarComputador = new Carta[7];
		//Construccion del mazo del jugador donde se realizaran las evaluaciones
		for(int i=0; i<mazoJugador.length;i++) {
			mazoEvaluarJugador[i]= mazoJugador[i];
		}
		
		for(int i=0; i<mazoMesa.length;i++) {
			mazoEvaluarJugador[i+2]= mazoMesa[i];
		}
		
		
		//Construccion del mazo del jugador donde se realizaran las evaluaciones
		for(int i=0; i<mazoComputador.length;i++) {
			mazoEvaluarComputador[i]= mazoComputador[i];
		}
				
		for(int i=0; i<mazoMesa.length;i++) {
			mazoEvaluarComputador[i+2]= mazoMesa[i];
		}
	}
	
	public int evaluarMazo(Carta[] mazo, ArrayList<Carta> mazoPorEstablecer) {
		ArrayList<Tipo> mazoClasificado = new ArrayList<Tipo>();
		Arrays.sort(mazo);
		Carta mazoCopia[] = new Carta[7];
		for(int i=0; i<mazo.length;i++) {
			mazoCopia[i]= mazo[i];
		}
		
		//Agrupamos las cartas que son del mismo valor y guardamos todo en un arreglo
		for(int i=0;i<mazoCopia.length;i++) {
			if(mazoCopia[i]!=null) {
				int pivote = mazoCopia[i].retornarValor();
				int cantidad = 0;
				for(int j=0;j<mazoCopia.length;j++) {
					if(mazoCopia[j]!=null) {
						if(pivote==mazoCopia[j].retornarValor()) {
							cantidad++;
							mazoCopia[j] = null;
						}
					}
				}
				mazoClasificado.add(new Tipo(pivote,cantidad));
			}	
		}
				
		//Empezamos la evaluacion del mazo 
		
		//Condicion para determinar la escalera real
		Boolean escaleraReal = true;
		for(int i=0; i<mazo.length;i++) {
			int valorAux = mazo[i].retornarValor();
			if((valorAux == 10|| valorAux == 11 || valorAux == 12|| 
			   valorAux == 13||valorAux == 1 )==false) {
				escaleraReal = false;
			}
		}
		if(escaleraReal==true) {
			for(int i=0;i<mazo.length;i++) {
				int valorAux = mazo[i].retornarValor();
				if(valorAux == 10|| valorAux == 11 || valorAux == 12|| 
				   valorAux == 13||valorAux == 1 ){
					mazoPorEstablecer.add(mazo[i]);
				}
			}
			return 10;
		}
		{
			Boolean escaleraColor = false;
			int corazones = 0;
			int picas = 0;
			int diamantes = 0;
			int treboles = 0;
			for(int i=0; i<mazo.length; i++) {
				if(mazo[i].retornarPalo().equals("corazones")) {
					corazones++;
				}
				if(mazo[i].retornarPalo().equals("picas")) {
					picas++;
				}
				if(mazo[i].retornarPalo().equals("diamantes")) {
					diamantes++;
				}
				if(mazo[i].retornarPalo().equals("treboles")) {
					treboles++;
				}	
			}	
			if(corazones>=5 ||picas>=5 ||diamantes>=5 ||treboles>=5) {
				escaleraColor = true;
			}
			
			if(escaleraColor==true) {
				String palo = "";
				
				if(corazones >=5) {
					palo = "corazones";
				}
				
				if(picas >=5) {
					palo = "picas";
				}
				
				if(diamantes >=5) {
					palo = "diamantes";
				}
				
				if(treboles >=5) {
					palo = "treboles";
				}
				
				//Se toman 3 casos principales, si la longitud del arraylist mazoClasificado es
				//5, 6 o 7. Que son los unicos casos posibles en los que se podria armar 
				//una escalera tomando en cuenta que la longitud del array puede variar si hay cartas 
				//repetidas y si la longitud del array es menor a 5 es porque no hay como minimo 5 cartas
				//distintas a evaluar para comprobar si la distancia entre ellas es de 1, osea escalera 
				//y ademas tienen el mismo palo.
				
				if(mazoClasificado.size()==5) {
					
					for(int i=0; i<4;i++) {
						int diferencia = mazoClasificado.get(i).retornarValor()-
								   mazoClasificado.get(i+1).retornarValor();
						if(diferencia != 1){
							escaleraColor = false;
						}
					}
						
					if(escaleraColor==true) {
						Boolean continuar = true;
						int i = 0;
						int valorPivote = 0;
						ArrayList<Carta> mazoAux = new ArrayList<Carta>();
						
						while(continuar ==true && (i<mazoClasificado.size())) {
							continuar = false;
							valorPivote = mazoClasificado.get(i).retornarValor();
							for(int j=0;j<mazo.length;j++) {
								if(mazo[j].retornarValor()==valorPivote) {
									if(mazo[j].retornarPalo().equals(palo)) {	
										continuar = true;
										mazoAux.add(mazo[j]);
									}
								}
							}
							i++;
						}
						
						if(mazoAux.size()==5) {
							for(int j=0; j<mazoAux.size();j++) {
								mazoPorEstablecer.add(mazoAux.get(j));
							}
							return 9;
						}		
					}		
				}
				
				if(mazoClasificado.size()==6) {
					
					for(int i=0; i<4;i++) {
						int diferencia = mazoClasificado.get(i).retornarValor()-
								   mazoClasificado.get(i+1).retornarValor();
						if(diferencia != 1){
							escaleraColor = false;
						}
					}
						
					if(escaleraColor==true) {
						Boolean continuar = true;
						int i = 0;
						int valorPivote = 0;
						ArrayList<Carta> mazoAux = new ArrayList<Carta>();
						
						while(continuar ==true && (i<5)) {
							continuar = false;
							valorPivote = mazoClasificado.get(i).retornarValor();
							for(int j=0;j<mazo.length;j++) {
								if(mazo[j].retornarValor()==valorPivote) {
									if(mazo[j].retornarPalo().equals(palo)) {	
										continuar = true;
										mazoAux.add(mazo[j]);
									}
								}
							}
							i++;
						}
						
						if(mazoAux.size()==5) {
							for(int j=0; j<mazoAux.size();j++) {
								mazoPorEstablecer.add(mazoAux.get(j));
							}
							return 9;
						}		
					}
					
					
					//Cambiamos los limites donde revisaremos el arreglo para ver la otra
					//posible mano de 5 cartas
					
					escaleraColor = true;
					for(int i=1; i<5;i++) {
						int diferencia = mazoClasificado.get(i).retornarValor()-
								   mazoClasificado.get(i+1).retornarValor();
						if(diferencia != 1){
							escaleraColor = false;
						}
					}
						
					if(escaleraColor==true) {
						Boolean continuar = true;
						int i = 1;
						int valorPivote = 0;
						ArrayList<Carta> mazoAux = new ArrayList<Carta>();
						
						while(continuar ==true && (i<mazoClasificado.size())) {
							continuar = false;
							valorPivote = mazoClasificado.get(i).retornarValor();
							for(int j=0;j<mazo.length;j++) {
								if(mazo[j].retornarValor()==valorPivote) {
									if(mazo[j].retornarPalo().equals(palo)) {	
										continuar = true;
										mazoAux.add(mazo[j]);
									}
								}
							}
							i++;
						}
						
						if(mazoAux.size()==5) {
							for(int j=0; j<mazoAux.size();j++) {
								mazoPorEstablecer.add(mazoAux.get(j));
							}
							return 9;
						}		
					}
					
				}
				
				//Ultimo caso de los posibles en que se puede armar la escalera de Color
				//con respecto al tamano del array mazoClasificado
				if(mazoClasificado.size()==7) {
					
					for(int i=0; i<4;i++) {
						int diferencia = mazoClasificado.get(i).retornarValor()-
								   mazoClasificado.get(i+1).retornarValor();
						if(diferencia != 1){
							escaleraColor = false;
						}
					}
						
					if(escaleraColor==true) {
						Boolean continuar = true;
						int i = 0;
						int valorPivote = 0;
						ArrayList<Carta> mazoAux = new ArrayList<Carta>();
						
						while(continuar ==true && (i<5)) {
							continuar = false;
							valorPivote = mazoClasificado.get(i).retornarValor();
							for(int j=0;j<mazo.length;j++) {
								if(mazo[j].retornarValor()==valorPivote) {
									if(mazo[j].retornarPalo().equals(palo)) {	
										continuar = true;
										mazoAux.add(mazo[j]);
									}
								}
							}
							i++;
						}
						
						if(mazoAux.size()==5) {
							for(int j=0; j<mazoAux.size();j++) {
								mazoPorEstablecer.add(mazoAux.get(j));
							}
							return 9;
						}		
					}
					
					
					//Cambiamos los limites donde revisaremos el arreglo para ver la otra
					//posible mano de 5 cartas
					
					escaleraColor = true;
					for(int i=1; i<5;i++) {
						int diferencia = mazoClasificado.get(i).retornarValor()-
								   mazoClasificado.get(i+1).retornarValor();
						if(diferencia != 1){
							escaleraColor = false;
						}
					}
						
					if(escaleraColor==true) {
						Boolean continuar = true;
						int i = 1;
						int valorPivote = 0;
						ArrayList<Carta> mazoAux = new ArrayList<Carta>();
						
						while(continuar ==true && (i<6)) {
							continuar = false;
							valorPivote = mazoClasificado.get(i).retornarValor();
							for(int j=0;j<mazo.length;j++) {
								if(mazo[j].retornarValor()==valorPivote) {
									if(mazo[j].retornarPalo().equals(palo)) {	
										continuar = true;
										mazoAux.add(mazo[j]);
									}
								}
							}
							i++;
						}
						
						if(mazoAux.size()==5) {
							for(int j=0; j<mazoAux.size();j++) {
								mazoPorEstablecer.add(mazoAux.get(j));
							}
							return 9;
						}		
					}
					
					
					//Cambiamos nuevamente los limites donde revisaremos el arreglo para ver la otra
					//posible mano de 5 cartas
					
					escaleraColor = true;
					for(int i=2; i<6;i++) {
						int diferencia = mazoClasificado.get(i).retornarValor()-
								   mazoClasificado.get(i+1).retornarValor();
						if(diferencia != 1){
							escaleraColor = false;
						}
					}
						
					if(escaleraColor==true) {
						Boolean continuar = true;
						int i = 2;
						int valorPivote = 0;
						ArrayList<Carta> mazoAux = new ArrayList<Carta>();
						
						while(continuar ==true && (i<mazoClasificado.size())) {
							continuar = false;
							valorPivote = mazoClasificado.get(i).retornarValor();
							for(int j=0;j<mazo.length;j++) {
								if(mazo[j].retornarValor()==valorPivote) {
									if(mazo[j].retornarPalo().equals(palo)) {	
										continuar = true;
										mazoAux.add(mazo[j]);
									}
								}
							}
							i++;
						}
						
						if(mazoAux.size()==5) {
							for(int j=0; j<mazoAux.size();j++) {
								mazoPorEstablecer.add(mazoAux.get(j));
							}
							return 9;
						}		
					}
					
				}	
			}
		}
		
		
		{
			//Condicion poker (Four of a kind/ 4 cartas del mismo valor)
			for(int i =0;i<mazoClasificado.size(); i++) {
				if(mazoClasificado.get(i).retornarCantidad()==4) {
					for(int j=0; j<mazo.length;j++) {
						if(mazo[j].retornarValor()==mazoClasificado.get(i).retornarValor()) {
							mazoPorEstablecer.add(mazo[j]);
						}
					}
					int k = 0;
					Boolean continuar  = true;
					while(continuar && (k<mazo.length)) {
						if(mazo[k].retornarValor()!=mazoClasificado.get(i).retornarValor()){
							mazoPorEstablecer.add(mazo[k]);
							continuar = false;
						}
						k++;
					}
					return 8;
				}
			}
		}
		{
			//Condicion full house(un trio y una pareja)
			Boolean trio = false;
			Boolean pareja = false;
			int pivote1 = 0;
			int pivote2 = 0;
			for(int i =0;i<mazoClasificado.size(); i++) {
				if(mazoClasificado.get(i).retornarCantidad()==3 ) {
					trio = true;
					pivote1 = mazoClasificado.get(i).retornarValor();
				}
			}
		
			for(int i =0;i<mazoClasificado.size(); i++) {
				if(mazoClasificado.get(i).retornarCantidad()==2 ) {
					pareja = true;
					pivote2 = mazoClasificado.get(i).retornarValor();
				}
			}
			
			if(trio && pareja) {
				for(int j=0;j<mazo.length; j++) {
					if(mazo[j].retornarValor()==pivote1||mazo[j].retornarValor()==pivote2 ){
						mazoPorEstablecer.add(mazo[j]);
					}
				}
				return 7;
			}
		}
		
		{
			//Condicion de color
			Boolean color = false;
			int corazones = 0;
			int picas = 0;
			int diamantes = 0;
			int treboles = 0;
			for(int i=0; i<mazo.length; i++) {
				if(mazo[i].retornarPalo().equals("corazones")) {
					corazones++;
				}
				if(mazo[i].retornarPalo().equals("picas")) {
					picas++;
				}
				if(mazo[i].retornarPalo().equals("diamantes")) {
					diamantes++;
				}
				if(mazo[i].retornarPalo().equals("treboles")) {
					treboles++;
				}	
			}	
			if(corazones>=5 ||picas>=5 ||diamantes>=5 ||treboles>=5) {
				color = true;
			}
			
			String palo = "";
			
			if(corazones >=5) {
				palo = "corazones";
			}
			
			if(picas >=5) {
				palo = "picas";
			}
			
			if(diamantes >=5) {
				palo = "diamantes";
			}
			
			if(treboles >=5) {
				palo = "treboles";
			}
			
			if(color ==true) {
				int tamanoMazo = 0;
				for(int i=0; i<mazo.length;i++) {
					if(tamanoMazo < 5 && mazo[i].retornarPalo().equals(palo)) {
						mazoPorEstablecer.add(mazo[i]);
						tamanoMazo++;
					}
				}
				
				return 6;
			}
			
			
		}
		
		
		
		return 0;
	}
	
	/**
	 * Mazos.
	 * Creamos dos mazos que son para contener el valor y la cantidad de cada una de las cartas
	 * de los jugadores buscando formar relaciones entre ellas para un uso posterior en la funcion
	 * de determinar jugadas
	 */
	public void mazos() {
		
		//Creacion del arreglo completo del jugador
		for(int i=0; i<mazoJugador.length; i++) {
			mazoAuxJugador.add(mazoJugador[i]);
		}
		for(int i=0; i<mazoMesa.length; i++) {
			mazoAuxJugador.add( mazoMesa[i]);
		}
		
		//Se hace una copia del arreglo para su uso posterior ya este sera borrada en el siguiente while
		for(int i=0; i<mazoAuxJugador.size();i++) {
			copiaMazoAuxJugador.add(mazoAuxJugador.get(i));
		}
		
		//Agrupamos las cartas que son del mismo valor y guardamos todo en un arreglo
		while(mazoAuxJugador.size()!=0) {
			int pivote = mazoAuxJugador.get(0).retornarValor();
			int cantidad = 1;
			mazoAuxJugador.remove(0);
			for(int i=0; i<mazoAuxJugador.size();i++) {
				if(pivote == mazoAuxJugador.get(i).retornarValor()) {
					
					mazoAuxJugador.remove(i);
					cantidad++;
				}
			}
			
			mazoAleatorioJugador.add(new Tipo(pivote,cantidad));			
		}
		
		//Creacion del arreglo completo del computador
			
		for(int i=0; i<mazoComputador.length; i++) {
			mazoAuxComputador.add(mazoComputador[i]);
		}
		
		for(int i=0; i<mazoMesa.length; i++) {
			mazoAuxComputador.add( mazoMesa[i]);
		}
		
		for(int i=0; i<mazoAuxComputador.size();i++) {
			copiaMazoAuxComputador.add(mazoAuxComputador.get(i));
		}
		
		while(mazoAuxComputador.size()!=0) {
			int pivote = mazoAuxComputador.get(0).retornarValor();
			int cantidad = 1;
			mazoAuxComputador.remove(0);
			for(int i=0; i<mazoAuxComputador.size();i++) {
				if(pivote == mazoAuxComputador.get(i).retornarValor()) {
					cantidad++;
					mazoAuxComputador.remove(i);
				}
			}
			mazoAleatorioComputador.add(new Tipo(pivote,cantidad));			
		}
				
	}
	
	/**
	 * Determinar jugada computador.
	 *Se encarga de determinar la mejor jugada para el jugador 
	 * @return the int
	 */
	public int determinarJugadaComputador() {
			
			//Condicion para determinar la escalera real
			Boolean escaleraReal = true;
			for(int i=0; i<mazoAleatorioComputador.size();i++) {
				int valorAux = mazoAleatorioComputador.get(i).retornarValor();
				if((valorAux == 10|| valorAux == 11 || valorAux == 12|| 
				   valorAux == 13||valorAux == 1 )==false) {
					escaleraReal = false;
				}
			}
			if(escaleraReal==true) {
				return 10;
			}
			ArrayList<Carta> mazoPalo =  new ArrayList<Carta>();
			if(escaleraReal==false) {
				{
					   {
						//Condicion para verificar si hay una escalera de color;
						Collections.sort(copiaMazoAuxComputador,new OrdenarPorValor());
						Boolean escalera = true;
						Boolean escaleraColor = true;
						
							//Se toma el caso de diferencia igual a 1 o 0 ya que al ordenarlas
							//de menor a mayor hay dos posibles casos que no niegan la presencia 
						   ///de la escalera , que la resta sea 1, osea son consecutivas las dos cartas
							//o cuando es 0 que quiere decir que tienen el mismo valor.
							for(int i=0; i<4;i++) {
								int diferencia = copiaMazoAuxComputador.get(i+1).retornarValor()-
										   copiaMazoAuxComputador.get(i).retornarValor();
								if(diferencia != 1|| diferencia != 0 ){
									escaleraColor = false;
								}
								if(diferencia == 1) {
									if((copiaMazoAuxComputador.get(i+1).retornarPalo().equals(copiaMazoAuxComputador.get(i).retornarPalo()))==false) {
										escaleraColor = false;
									}
								}
							}

							if(escaleraColor==true) {
								return 9;
							}
							escalera = true;
							escaleraColor = true;
							//Los limites de los for aumentan en 1 porque miramos las distintas posibles manos
							//tomando en cuenta que el arreglo ya esta organizado y la mano solo se puede formar con
							//5 cartas
							for(int i=1; i<5;i++) {
								int diferencia = copiaMazoAuxComputador.get(i+1).retornarValor()-
										   copiaMazoAuxComputador.get(i).retornarValor();
								if(diferencia != 1|| diferencia != 0 ){
									escaleraColor = false;
								}
								if(diferencia == 1) {
									if((copiaMazoAuxComputador.get(i+1).retornarPalo().equals(copiaMazoAuxComputador.get(i).retornarPalo()))==false) {
										escaleraColor = false;
									}
								}
							}
										
							if(escaleraColor==true) {
								return 9;
							}		
							escalera = true;
							escaleraColor = true;
							
							for(int i=2; i<(copiaMazoAuxComputador.size()-1);i++) {
								int diferencia = copiaMazoAuxComputador.get(i+1).retornarValor()-
										   copiaMazoAuxComputador.get(i).retornarValor();
								if(diferencia != 1|| diferencia != 0 ){
									escaleraColor = false;
								}
								if(diferencia == 1) {
									if((copiaMazoAuxComputador.get(i+1).retornarPalo().equals(copiaMazoAuxComputador.get(i).retornarPalo()))==false) {
										escaleraColor = false;
									}
								}
							}
							
							if(escaleraColor==true) {
								return 9;
							}
						}
									
				}
				
				//Condicion poker (Four of a kind/ 4 cartas del mismo valor)
				for(int i =0;i<mazoAleatorioComputador.size(); i++) {
					if(mazoAleatorioComputador.get(i).retornarCantidad()==4) {
						return 8;
					}
				}
				
				//Condicion full house(un trio y una pareja)
				Boolean hayTres = false;
				for(int i =0;i<mazoAleatorioComputador.size(); i++) {
					if(mazoAleatorioComputador.get(i).retornarCantidad()==3 ) {
						hayTres = true;
						if(hayTres ==true) {
							if(mazoAleatorioComputador.get(i).retornarCantidad()==2) {
								return 7;
							}
						}
					}
				}

					//Empieza condicion de color 
					int corazones =0;
					int picas = 0;
					int treboles = 0;
					int diamantes = 0;
				
					
					for(int i =0; i<copiaMazoAuxComputador.size(); i++) {
						
						if("corazones".equals(copiaMazoAuxComputador.get(i).retornarPalo())) {
							corazones++;
						}
						if("picas".equals(copiaMazoAuxComputador.get(i).retornarPalo())) {
							picas++;
						}
						if("treboles".equals(copiaMazoAuxComputador.get(i).retornarPalo())) {
							treboles++;
						}
						if("diamantes".equals(copiaMazoAuxComputador.get(i).retornarPalo())) {
							diamantes++;
						}
					}
					
					if(5<=corazones||5<=treboles||5<=diamantes||5<=picas) {
						return 6;
					}
					
					{
						//Condicion para verificar si hay escalera;
						Collections.sort(copiaMazoAuxComputador,new OrdenarPorValor());
						Boolean escalera = true;
						for(int i=0; i<4;i++) {
							int diferencia = copiaMazoAuxComputador.get(i+1).retornarValor()-
									   copiaMazoAuxComputador.get(i).retornarValor();
							if(diferencia != 1|| diferencia != 0 ){
								escalera = false;
							}
						}

						if(escalera==true) {
							return 9;
						}
						escalera = true;
					
						for(int i=1; i<5;i++) {
							int diferencia = copiaMazoAuxComputador.get(i+1).retornarValor()-
									   copiaMazoAuxComputador.get(i).retornarValor();
							if(diferencia != 1|| diferencia != 0 ){
								escalera = false;
							}
							
						}
									
						if(escalera==true) {
							return 9;
						}		
						escalera = true;
						
						
						for(int i=2; i<(copiaMazoAuxComputador.size()-1);i++) {
							int diferencia = copiaMazoAuxComputador.get(i+1).retornarValor()-
									   copiaMazoAuxComputador.get(i).retornarValor();
							if(diferencia != 1|| diferencia != 0 ){
								escalera = false;
							}

						}
						
						if(escalera==true) {
							return 9;
						}
					}
			}
			
			//Condicion Trio
			for(int i =0;i<mazoAleatorioComputador.size(); i++) {
				if(mazoAleatorioComputador.get(i).retornarCantidad()==3) {
					return 4;
				}
			}
			
			//Condicion doble pareja;
			int hayDos =0;
			for(int i =0;i<mazoAleatorioComputador.size(); i++) {
				if(mazoAleatorioComputador.get(i).retornarCantidad()==2) {
					hayDos++;
				}
			}
			if(hayDos >= 2) {
				return 3;
			}
			
			//Condicion una pareja
			for(int i =0;i<mazoAleatorioComputador.size(); i++) {
				if(mazoAleatorioComputador.get(i).retornarCantidad()==2) {
					return 2;
				}
			}
			
			//Luego de entrar al if del caso en que todas las cartas son de distinto 
			//valor , si la funcion llega hasta este return es porque no entro en ninguno
			//de los otros casos , por descarto es el caso de la carta mas alta; 
			return 1;	
	}
	
	
	
	
	
	/**
	 * Determinar jugada jugador.
	 *
	 * @return the int
	 */
	public int determinarJugadaJugador() {
		
		//Condicion para determinar la escalera real
		Boolean escaleraReal = true;
		for(int i=0; i<mazoAleatorioJugador.size();i++) {
			int valorAux = mazoAleatorioJugador.get(i).retornarValor();
			if((valorAux == 10|| valorAux == 11 || valorAux == 12|| 
			   valorAux == 13||valorAux == 1 )==false) {
				escaleraReal = false;
			}
		}
		if(escaleraReal==true) {
			return 10;
		}
		
		
		if(escaleraReal==false) {
			{
				   {
					//Condicion para verificar si hay una escalera de color;
					Collections.sort(copiaMazoAuxJugador,new OrdenarPorValor());
					
					Boolean escalera = true;
					Boolean escaleraColor = true;
					ArrayList<Carta> mazoPalo =  new ArrayList<Carta>();
					for(int i=0; i<4;i++) {
						int diferencia = copiaMazoAuxJugador.get(i+1).retornarValor()-
								   copiaMazoAuxJugador.get(i).retornarValor();
						if(diferencia != 1 || diferencia != 0 ){
							escaleraColor = false;
						}
						if(diferencia == 1) {
							if((copiaMazoAuxJugador.get(i+1).retornarPalo().equals(copiaMazoAuxJugador.get(i).retornarPalo()))==false) {
								escaleraColor = false;
							}
						}
					}
					if(escaleraColor==true) {
						return 9;
					}
					escalera = true;
					escaleraColor = true;
					for(int i=1; i<5;i++) {
						int diferencia = copiaMazoAuxJugador.get(i+1).retornarValor()-
								   copiaMazoAuxJugador.get(i).retornarValor();
						if(diferencia != 1  || diferencia != 0){
							escaleraColor = false;
						}
						if(diferencia == 1) {
							if((copiaMazoAuxJugador.get(i+1).retornarPalo().equals(copiaMazoAuxJugador.get(i).retornarPalo()))==false) {
								escaleraColor = false;
							}
						}
					}
								
					if(escaleraColor==true) {
						return 9;
					}
					escalera = true;
					escaleraColor = true;
					
					for(int i=2; i<(copiaMazoAuxJugador.size()-1);i++) {
						int diferencia = copiaMazoAuxJugador.get(i+1).retornarValor()-
								   copiaMazoAuxJugador.get(i).retornarValor();
						if(diferencia != 1  || diferencia != 0){
							escaleraColor = false;
						}
						if(diferencia == 1) {
							if((copiaMazoAuxJugador.get(i+1).retornarPalo().equals(copiaMazoAuxJugador.get(i).retornarPalo()))==false) {
								escaleraColor = false;
							}
						}
					}
					
					if(escaleraColor==true) {
						return 9;
					}
										
				}
			}
				
			//Condicion poker (Four of a kind/ 4 cartas del mismo valor)
			for(int i =0;i<mazoAleatorioJugador.size(); i++) {
				if(mazoAleatorioJugador.get(i).retornarCantidad()==4) {
					return 8;
				}
			}
			//Condicion full house(un trio y una pareja)
			Boolean hayTres = false;
			for(int i =0;i<mazoAleatorioJugador.size(); i++) {
				if(mazoAleatorioJugador.get(i).retornarCantidad()==3 ) {
					hayTres = true;
					if(hayTres ==true) {
						if(mazoAleatorioJugador.get(i).retornarCantidad()==2) {
							return 7;
						}
					}
				}
			}
				//Empieza condicion de color 
				int corazones =0;
				int picas = 0;
				int treboles = 0;
				int diamantes = 0;
				
				for(int i =0; i<copiaMazoAuxJugador.size(); i++) {
					
					if("corazones".equals(copiaMazoAuxJugador.get(i).retornarPalo())) {
						corazones++;
					}
					if("picas".equals(copiaMazoAuxJugador.get(i).retornarPalo())) {
						picas++;
					}
					if("treboles".equals(copiaMazoAuxJugador.get(i).retornarPalo())) {
						treboles++;
					}
					if("diamantes".equals(copiaMazoAuxJugador.get(i).retornarPalo())) {
						diamantes++;
					}
				}
				
				if(5<=corazones||5<=treboles||5<=diamantes||5<=picas) {
					return 6;
				}
				
				{
					//Condicion para verificar si hay escalera;
					Collections.sort(copiaMazoAuxJugador,new OrdenarPorValor());

					Boolean escalera = true;
					
					ArrayList<Carta> mazoPalo =  new ArrayList<Carta>();
					for(int i=0; i<4;i++) {
						int diferencia = copiaMazoAuxJugador.get(i+1).retornarValor()-
								   copiaMazoAuxJugador.get(i).retornarValor();
						if(diferencia != 1 || diferencia != 0 ){
							escalera = false;
						}

					}

					if(escalera==true) {
						return 5;
					}
						
					escalera = true;
					for(int i=1; i<5;i++) {
						int diferencia = copiaMazoAuxJugador.get(i+1).retornarValor()-
								   copiaMazoAuxJugador.get(i).retornarValor();
						if(diferencia != 1  || diferencia != 0){
							escalera = false;
						}

					}
								
					if(escalera==true) {
						return 5;
					}
						
					
					escalera = true;

					for(int i=2; i<(copiaMazoAuxJugador.size()-1);i++) {
						int diferencia = copiaMazoAuxJugador.get(i+1).retornarValor()-
								   copiaMazoAuxJugador.get(i).retornarValor();
						if(diferencia != 1  || diferencia != 0){
							escalera = false;
						}

					}
					
					if(escalera==true) {
						return 5;
					}						
				}
		}
		
		//Condicion Trio
		for(int i =0;i<mazoAleatorioJugador.size(); i++) {
			if(mazoAleatorioJugador.get(i).retornarCantidad()==3) {
				return 4;
			}
		}
		
		//Condicion doble pareja;
		int hayDos =0;
		for(int i =0;i<mazoAleatorioJugador.size(); i++) {
			if(mazoAleatorioJugador.get(i).retornarCantidad()==2) {
				hayDos++;
			}
		}
		if(hayDos >= 2) {
			return 3;
		}
		
		//Condicion una pareja
		for(int i =0;i<mazoAleatorioJugador.size(); i++) {
			if(mazoAleatorioJugador.get(i).retornarCantidad()==2) {
				return 2;
			}
		}
		
		//Luego de entrar al if del caso en que todas las cartas son de distinto 
		//valor , si la funcion llega hasta este return es porque no entro en ninguno
		//de los otros casos , por descarto es el caso de la carta mas alta; 
		return 1;
	
}
	
	/**
	 * The Class OrdenarPorValor.
		Clase que debemos implementar para usar la funcion de Collection con arreglos
		de un tipo de dato no primitivo.
	 */
	private class OrdenarPorValor implements Comparator<Carta>{
		
		/**
		 * Compare.
		 *
		 * @param elemento1 the elemento 1
		 * @param elemento2 the elemento 2
		 * @return the int
		 */
		public int compare(Carta elemento1, Carta elemento2) {
			return elemento1.retornarValor()-elemento2.retornarValor();
		}		
	}
	
	
	private class OrdenarPorValorTipo implements Comparator<Tipo>{
		
		/**
		 * Compare.
		 *
		 * @param elemento1 the elemento 1
		 * @param elemento2 the elemento 2
		 * @return the int
		 */
		public int compare(Tipo elemento1, Tipo elemento2) {
			return elemento1.retornarValor()-elemento2.retornarValor();
		}		
	}
	
	
	/**
	 * The Class ventanaMensajes.
	 */
	private class ventanaMensajes extends JFrame {
		
		/** The icono. */
		private JLabel  mensaje , icono;
		
		/**
		 * Instantiates a new ventana mensajes.
		 */
		public ventanaMensajes(){
			initGUI();
			setUndecorated(true);
			setSize(new Dimension(500,200));
			setResizable(false);
			setLocationRelativeTo(null);
		}
	
		/**
		 * Inits the GUI.
		 */
		private void initGUI() {
			escucha = new Escucha();
		
			panelMensajes = new PanelFondo();
			panelMensajes.setPreferredSize(new Dimension(500,200));
			panelMensajes.establecerFondo("src/Recursos/fondoMesa.jpg");
		
			imagen = new ImageIcon("src/Recursos/repartir.gif");
			icono = new JLabel(imagen);
			panelMensajes.add(icono);
			
			imagen = new ImageIcon("src/Recursos/reparto.png");
			mensaje = new JLabel(imagen);
			panelMensajes.add(mensaje);
		
			imagen = new ImageIcon("src/Recursos/continuar.png");
			continuar = new JLabel(imagen);
			continuar.addMouseListener(escucha);
			panelMensajes.add(continuar);
			
			add(panelMensajes);	
		}
		
		/**
		 * Establecer mensaje.
		 *
		 * @param icono the icono
		 * @param mensaje the mensaje
		 */
		public void establecerMensaje(String icono, String mensaje) {
			imagen = new ImageIcon(icono);
			this.icono.setIcon(imagen);
			
			imagen = new ImageIcon(mensaje);
			this.mensaje.setIcon(imagen);
		}	
	}
	
	
	public int desempate() {
		Collections.sort(copiaMazoAuxComputador,new OrdenarPorValor());
		Collections.sort(copiaMazoAuxJugador,new OrdenarPorValor());
		
		Collections.sort(mazoAleatorioJugador,new OrdenarPorValorTipo());
		Collections.sort(mazoAleatorioComputador,new OrdenarPorValorTipo());
		if(determinarJugadaJugador()==9) {
			
		}
		//Caso de poker
		//Revisamos dos casos
		//1.Comparamos la carta de cantidad 4 y si esta es igual 
		//2.Comparamos la carta mas alta de las que quedan
		if(determinarJugadaJugador()==8) {
			int kickerJugador = 0;
			for(int i=0; i<mazoAleatorioJugador.size() ; i++) {
				if(mazoAleatorioJugador.get(i).retornarCantidad()==4) {
					kickerJugador = mazoAleatorioJugador.get(i).retornarValor();
				}
			}
			int kickerComputador = 0;
			for(int i=0; i<mazoAleatorioComputador.size() ; i++) {
				if(mazoAleatorioComputador.get(i).retornarCantidad()==4) {
					kickerComputador = mazoAleatorioComputador.get(i).retornarValor();
				}
			}
			if(kickerJugador<kickerComputador) {
				return 1;
			}
			if(kickerJugador>kickerComputador) {
				return 0;
			}
			else {
				int i= mazoAleatorioJugador.size()-1;
				while(mazoAleatorioJugador.get(i).retornarCantidad()==4) {
					kickerJugador = mazoAleatorioJugador.get(i).retornarValor();
					i--;
				}
				int j= mazoAleatorioComputador.size()-1;
				while(mazoAleatorioComputador.get(i).retornarCantidad()==4) {
					kickerComputador = mazoAleatorioComputador.get(i).retornarValor();
					i--;
				}
				
				if(kickerComputador <kickerJugador) {
					return 0;
				}
				if(kickerComputador >=kickerJugador) {
					return 1;
				}
					
			}
			
		}
		//Se compara la carta mas alta de cada uno de los mazos;
		if(determinarJugadaJugador()==6) {
			int kickerJugador=mazoAleatorioJugador.get(mazoAleatorioJugador.size()-1).retornarValor();
			int kickerComputador =mazoAleatorioComputador.get(mazoAleatorioComputador.size()-1).retornarValor();
			if(kickerJugador<kickerComputador) {
				return 1;
			}
			if(kickerJugador>kickerComputador) {
				return 0;
			}
		}
		
		if(determinarJugadaJugador()==5) {
			
		}
		
		//Compara primero el valor de cada trio y en caso de ser iguales
		//mira la carta mas alta restante;
		if(determinarJugadaJugador()==4) {
			int kickerJugador = 0;
			for(int i=0; i<mazoAleatorioJugador.size() ; i++) {
				if(mazoAleatorioJugador.get(i).retornarCantidad()==3) {
					kickerJugador = mazoAleatorioJugador.get(i).retornarValor();
				}
			}
			int kickerComputador = 0;
			for(int i=0; i<mazoAleatorioComputador.size() ; i++) {
				if(mazoAleatorioComputador.get(i).retornarCantidad()==3) {
					kickerComputador = mazoAleatorioComputador.get(i).retornarValor();
				}
			}
			if(kickerJugador<kickerComputador) {
				return 1;
			}
			if(kickerJugador>kickerComputador) {
				return 0;
			}
			else {
				int i= mazoAleatorioJugador.size()-1;
				while(mazoAleatorioJugador.get(i).retornarCantidad()==3) {
					kickerJugador = mazoAleatorioJugador.get(i).retornarValor();
					i--;
				}
				int j= mazoAleatorioComputador.size()-1;
				while(mazoAleatorioComputador.get(i).retornarCantidad()==3) {
					kickerComputador = mazoAleatorioComputador.get(i).retornarValor();
					i--;
				}
				
				if(kickerComputador <kickerJugador) {
					return 0;
				}
				if(kickerComputador >=kickerJugador) {
					return 1;
				}
					
			}
		}
		/*Compara la primera pareja, de ser igual mira la segunda y si se repite lo anterior
		 * solo queda tomar las cartas mas altas
		 * */
		if(determinarJugadaJugador()==3) {
			int kickerJugador = 0;
			int kickerJugadorAnterior =0;
			for(int i=0; i<mazoAleatorioJugador.size() ; i++) {
				if(mazoAleatorioJugador.get(i).retornarCantidad()==2) {
					kickerJugador = mazoAleatorioJugador.get(i).retornarValor();
					kickerJugadorAnterior = kickerJugador;
				}
			}
			int kickerComputador = 0;
			int kickerComputadorAnterior=0;
			for(int i=0; i<mazoAleatorioComputador.size() ; i++) {
				if(mazoAleatorioComputador.get(i).retornarCantidad()==2) {
					kickerComputador = mazoAleatorioComputador.get(i).retornarValor();
					kickerComputadorAnterior = kickerComputador;
				}
			}
			if(kickerJugador<kickerComputador) {
				return 1;
			}
			if(kickerJugador>kickerComputador) {
				return 0;
			}
			else {
				int i= mazoAleatorioJugador.size()-1;
				while((mazoAleatorioJugador.get(i).retornarCantidad()==2)&&
					  (mazoAleatorioJugador.get(i).retornarValor()==kickerJugador)) {
					kickerJugador = mazoAleatorioJugador.get(i).retornarValor();
					i--;
				}
				int j= mazoAleatorioComputador.size()-1;
				while((mazoAleatorioComputador.get(i).retornarCantidad()==2)&&
					   (mazoAleatorioComputador.get(i).retornarValor()==kickerComputador)) {
					kickerComputador = mazoAleatorioComputador.get(i).retornarValor();
					i--;
				}
				
				
				if(kickerComputador <kickerJugador) {
					return 0;
				}
				if(kickerComputador >kickerJugador) {
					return 1;
				}
				else {
					int q= mazoAleatorioJugador.size()-1;
					while((mazoAleatorioJugador.get(q).retornarCantidad()==2)&&
						  (mazoAleatorioJugador.get(q).retornarValor()==kickerJugador)&&
						  (mazoAleatorioJugador.get(q).retornarValor()==kickerJugadorAnterior)) {
						kickerJugador = mazoAleatorioJugador.get(q).retornarValor();
						i--;
					}
					int k= mazoAleatorioComputador.size()-1;
					while((mazoAleatorioComputador.get(k).retornarCantidad()==2)&&
						   (mazoAleatorioComputador.get(k).retornarValor()==kickerComputador)&&
						   (mazoAleatorioComputador.get(k).retornarValor()==kickerComputadorAnterior)) {
						kickerComputador = mazoAleatorioComputador.get(k).retornarValor();
						i--;
					}
					
					
					if(kickerComputador <kickerJugador) {
						return 0;
					}
					if(kickerComputador >=kickerJugador) {
						return 1;
					}	
				}
					
			}
		}
		
		if(determinarJugadaJugador()==2) {
			int kickerJugador = 0;
			for(int i=0; i<mazoAleatorioJugador.size() ; i++) {
				if(mazoAleatorioJugador.get(i).retornarCantidad()==2) {
					kickerJugador = mazoAleatorioJugador.get(i).retornarValor();
				}
			}
			int kickerComputador = 0;
			for(int i=0; i<mazoAleatorioComputador.size() ; i++) {
				if(mazoAleatorioComputador.get(i).retornarCantidad()==2) {
					kickerComputador = mazoAleatorioComputador.get(i).retornarValor();
				}
			}
			if(kickerJugador<kickerComputador) {
				return 1;
			}
			if(kickerJugador>kickerComputador) {
				return 0;
			}
			else {
				int i= mazoAleatorioJugador.size()-1;
				while(mazoAleatorioJugador.get(i).retornarCantidad()==2) {
					kickerJugador = mazoAleatorioJugador.get(i).retornarValor();
					i--;
				}
				int j= mazoAleatorioComputador.size()-1;
				while(mazoAleatorioComputador.get(i).retornarCantidad()==2) {
					kickerComputador = mazoAleatorioComputador.get(i).retornarValor();
					i--;
				}
				
				if(kickerComputador <kickerJugador) {
					return 0;
				}
				if(kickerComputador >=kickerJugador) {
					return 1;
				}
					
			}
		}
		//Se comparan las cartas mas altas de cada mazo
		if(determinarJugadaJugador()==1) {
			int kickerJugador=mazoAleatorioJugador.get(mazoAleatorioJugador.size()-1).retornarValor();
			int kickerComputador =mazoAleatorioComputador.get(mazoAleatorioComputador.size()-1).retornarValor();
			if(kickerJugador<kickerComputador) {
				return 1;
			}
			if(kickerJugador>kickerComputador) {
				return 0;
			}
		}
		return 1;
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
			if(e.getSource()==aceptar) {
				System.exit(0);
			}
			if(e.getSource()==cancelar) {
				warning.setEnabled(false);
				warning.setVisible(false);
			}
			
			if(e.getSource()==continuar) {
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
				
				if(estadoDelJuego==1) {
					panelJugador.repartirCartas();
					panelComputador.repartirCartas();
					ventanaMensajes.establecerMensaje("src/Recursos/fases.gif","src/Recursos/flop.png");
					panelDealer.activarApuesta();
				}
				estadoDelJuego++;
				ventanaMensajes.setVisible(false);
				ventanaMensajes.setEnabled(false);
				
				if(estadoDelJuego==2) {
	
					//Muestra la ventana para el caso del flop
				}
				if(estadoDelJuego==3) {
					panelMesa.etapasRonda(1);
					ventanaMensajes.establecerMensaje("src/Recursos/cartaSola1.gif","src/Recursos/turn.png");
					
				}
				if(estadoDelJuego==4) {
					panelMesa.etapasRonda(2);
					ventanaMensajes.establecerMensaje("src/Recursos/cartaSola2.gif","src/Recursos/river.png");
				}
				int puntajeJugador =0;
				int puntajeComputador =0;
				if(estadoDelJuego==5) {
					panelMesa.etapasRonda(3);
					establecerMazos();
					mazos();
					puntajeJugador = determinarJugadaJugador();
					puntajeComputador = determinarJugadaComputador();
					//Aqui iran las funciones de desempate
					if(puntajeJugador<puntajeComputador) {
						ventanaMensajes.establecerMensaje("src/Recursos/Ganador/perdisteReaccion.png","src/Recursos/Ganador/perdiste.png");
					}
					else {
						ventanaMensajes.establecerMensaje("src/Recursos/Ganador/ganasteReaccion.gif","src/Recursos/Ganador/ganaste.png");
					}
					
					panelComputador.mostrarCartas();
					JOptionPane.showMessageDialog(null, "Pasa el turno para conocer el ganador");
					madeMazosaEvaluar();
					evaluarMazo(mazoEvaluarJugador, manoJugador);

					for(int i=0; i<manoJugador.size();i++) {
						System.out.println("Carta: "+ manoJugador.get(i).retornarValor()+" Palo: "+manoJugador.get(i).retornarPalo());
					}	
					//System.out.println("Jugada: "+ jugada);
				}
				if(estadoDelJuego==6) {
					panelMensajes.setVisible(true);
					panelMensajes.setEnabled(true);
					if(puntajeJugador>puntajeComputador) {
						panelDealer.resultados("jugador");
					}
					if(puntajeJugador<puntajeComputador){
						panelDealer.resultados("computador");
					}
					else {
						int ganador = desempate();
						if(ganador==0) {
							panelDealer.resultados("jugador");
						}
						else {
							panelDealer.resultados("computador");
						}
						
					}
					JOptionPane.showMessageDialog(null, "Pasa el turno si deseas iniciar una nueva ronda");
				}
				
				if(estadoDelJuego==7) {
					
				}					
			} 
		}
	}
}
