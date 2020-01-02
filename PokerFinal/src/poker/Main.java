package poker;

/*SEGUNDA ENTREGA DEL PROYECTO
 * Gonzalez Nebrijo Melissa 1832127
 * Gonzalez Hernandez Michelle 1871074
 * */

import java.awt.EventQueue;

import javax.swing.UIManager;


public class Main {

	public static void main(String[] args) {
		try {
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		}
		catch(Exception e){}
		EventQueue.invokeLater(new Runnable() {public void run() {VentanaPrincipal miVentana = 
		new VentanaPrincipal ();}});		
	}
}
