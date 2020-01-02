package poker;


/*SEGUNDA ENTREGA DEL PROYECTO
 * Gonzalez Nebrijo Melissa 1832127
 * Gonzalez Hernandez Michelle 1871074
 * */

import java.util.Random;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class MazoCartas.
 * Aqui instanciamos las 52 cartas que hacen parte del juego Hold em Texas
 */
public class MazoCartas {
	
	/** The mazo cartas. */
	private Carta mazoCartas[];
	
	/** The imagen carta. */
	private ImageIcon imagenCarta;
	
	/**
	 * Instantiates a new mazo cartas.
	 */
	public MazoCartas() {
		mazoCartas = new Carta[52];
		
		// Palo de corazones
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/A.png");
		Carta carta1 = new Carta(imagenCarta,"corazones", 1);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/2.png");
		Carta carta2 = new Carta(imagenCarta,"corazones", 2);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/3.png");
		Carta carta3 = new Carta(imagenCarta,"corazones", 3);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/4.png");
		Carta carta4 = new Carta(imagenCarta,"corazones", 4);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/5.png");
		Carta carta5 = new Carta(imagenCarta,"corazones", 5);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/6.png");
		Carta carta6 = new Carta(imagenCarta,"corazones", 6);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/7.png");
		Carta carta7 = new Carta(imagenCarta,"corazones", 7);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/8.png");
		Carta carta8 = new Carta(imagenCarta,"corazones", 8);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/9.png");
		Carta carta9 = new Carta(imagenCarta,"corazones", 9);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/10.png");
		Carta carta10 = new Carta(imagenCarta,"corazones", 10);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/J.png");
		Carta carta11 = new Carta(imagenCarta,"corazones", 11);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/Q.png");
		Carta carta12 = new Carta(imagenCarta,"corazones", 12);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo corazones/K.png");
		Carta carta13 = new Carta(imagenCarta,"corazones", 13);
		
		
		//Palo de diamantes
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo diamantes/A.png");
		Carta carta14 = new Carta(imagenCarta,"diamantes", 1);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo diamantes/2.png");
		Carta carta15 = new Carta(imagenCarta,"diamantes", 2);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo diamantes/3.png");
		Carta carta16 = new Carta(imagenCarta,"diamantes", 3);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo diamantes/4.png");
		Carta carta17 = new Carta(imagenCarta,"diamantes", 4);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo diamantes/5.png");
		Carta carta18 = new Carta(imagenCarta,"diamantes", 5);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo diamantes/6.png");
		Carta carta19 = new Carta(imagenCarta,"diamantes", 6);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo diamantes/7.png");
		Carta carta20 = new Carta(imagenCarta,"diamantes", 7);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo diamantes/8.png");
		Carta carta21 = new Carta(imagenCarta,"diamantes", 8);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo diamantes/9.png");
		Carta carta22 = new Carta(imagenCarta,"diamantes", 9);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo diamantes/10.png");
		Carta carta23 = new Carta(imagenCarta,"diamantes", 10);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo diamantes/J.png");
		Carta carta24 = new Carta(imagenCarta,"diamantes", 11);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo diamantes/Q.png");
		Carta carta25 = new Carta(imagenCarta,"diamantes", 12);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo diamantes/K.png");
		Carta carta26 = new Carta(imagenCarta,"diamantes", 13);
		
		//Palo  picas 
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo picas/A.png");
		Carta carta27 = new Carta(imagenCarta,"picas", 1);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo picas/2.png");
		Carta carta28 = new Carta(imagenCarta,"picas", 2);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo picas/3.png");
		Carta carta29 = new Carta(imagenCarta,"picas", 3);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo picas/4.png");
		Carta carta30 = new Carta(imagenCarta,"picas", 4);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo picas/5.png");
		Carta carta31 = new Carta(imagenCarta,"picas", 5);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo picas/6.png");
		Carta carta32 = new Carta(imagenCarta,"picas", 6);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo picas/7.png");
		Carta carta33 = new Carta(imagenCarta,"picas", 7);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo picas/8.png");
		Carta carta34 = new Carta(imagenCarta,"picas", 8);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo picas/9.png");
		Carta carta35 = new Carta(imagenCarta,"picas", 9);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo picas/10.png");
		Carta carta36 = new Carta(imagenCarta,"picas", 10);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo picas/J.png");
		Carta carta37 = new Carta(imagenCarta,"picas", 11);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo picas/Q.png");
		Carta carta38 = new Carta(imagenCarta,"picas", 12);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo picas/K.png");
		Carta carta39 = new Carta(imagenCarta,"picas", 13);
		
		
		//Palo de treboles
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo treboles/A.png");
		Carta carta40 = new Carta(imagenCarta,"treboles", 1);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo treboles/2.png");
		Carta carta41 = new Carta(imagenCarta,"treboles", 2);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo treboles/3.png");
		Carta carta42 = new Carta(imagenCarta,"treboles", 3);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo treboles/4.png");
		Carta carta43 = new Carta(imagenCarta,"treboles", 4);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo treboles/5.png");
		Carta carta44 = new Carta(imagenCarta,"treboles", 5);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo treboles/6.png");
		Carta carta45 = new Carta(imagenCarta,"treboles", 6);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo treboles/7.png");
		Carta carta46 = new Carta(imagenCarta,"treboles", 7);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo treboles/8.png");
		Carta carta47 = new Carta(imagenCarta,"treboles", 8);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo treboles/9.png");
		Carta carta48 = new Carta(imagenCarta,"treboles", 9);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo treboles/10.png");
		Carta carta49 = new Carta(imagenCarta,"treboles", 10);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo treboles/J.png");
		Carta carta50 = new Carta(imagenCarta,"treboles", 11);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo treboles/Q.png");
		Carta carta51 = new Carta(imagenCarta,"treboles", 12);
		
		imagenCarta = new ImageIcon("src/Recursos/Cartas completas/Palo treboles/K.png");
		Carta carta52 = new Carta(imagenCarta,"treboles", 13);
		
		mazoCartas[0] = carta1;
		mazoCartas[1] = carta2;
		mazoCartas[2] = carta3;
		mazoCartas[3] = carta4;
		mazoCartas[4] = carta5;
		mazoCartas[5] = carta6;
		mazoCartas[6] = carta7;
		mazoCartas[7] = carta8;
		mazoCartas[8] = carta9;
		mazoCartas[9] = carta10;
		mazoCartas[10] = carta11;
		mazoCartas[11] = carta12;
		mazoCartas[12] = carta13;
		mazoCartas[13] = carta14;
		mazoCartas[14] = carta15;
		mazoCartas[15] = carta16;
		mazoCartas[16] = carta17;
		mazoCartas[17] = carta18;
		mazoCartas[18] = carta19;
		mazoCartas[19] = carta20;
		mazoCartas[20] = carta21;
		mazoCartas[21] = carta22;
		mazoCartas[22] = carta23;
		mazoCartas[23] = carta24;
		mazoCartas[24] = carta25;
		mazoCartas[25] = carta26;
		mazoCartas[26] = carta27;
		mazoCartas[27] = carta28;
		mazoCartas[28] = carta29;
		mazoCartas[29] = carta30;
		mazoCartas[30] = carta31;
		mazoCartas[31] = carta32;
		mazoCartas[32] = carta33;
		mazoCartas[33] = carta34;
		mazoCartas[34] = carta35;
		mazoCartas[35] = carta36;
		mazoCartas[36] = carta37;
		mazoCartas[37] = carta38;
		mazoCartas[38] = carta39;
		mazoCartas[39] = carta40;
		mazoCartas[40] = carta41;
		mazoCartas[41] = carta42;
		mazoCartas[42] = carta43;
		mazoCartas[43] = carta44;
		mazoCartas[44] = carta45;
		mazoCartas[45] = carta46;
		mazoCartas[46] = carta47;
		mazoCartas[47] = carta48;
		mazoCartas[48] = carta49;
		mazoCartas[49] = carta50;
		mazoCartas[50] = carta51;
		mazoCartas[51] = carta52;
	
	}
	
	/**
	 * Retornar carta.
	 *Retorna una carta aleatoria y esta es borrada del mazo
	 * @return the carta
	 */
	public Carta retornarCarta() {
		Random aleatorio = new Random();
		int cartaAleatoria = aleatorio.nextInt(52);
		Carta cartaAux = mazoCartas[cartaAleatoria];
		if(mazoCartas[cartaAleatoria] != null) {
			mazoCartas[cartaAleatoria] = null;
			return cartaAux;
		}
		else {
			while(mazoCartas[cartaAleatoria] == null) {
				cartaAleatoria = aleatorio.nextInt(52);
				cartaAux = mazoCartas[cartaAleatoria];
			}
			mazoCartas[cartaAleatoria] = null;
			return cartaAux;
		}
	}	
}
