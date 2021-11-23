package app;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import interfaces_graficas.Interfaz_Generar_Reserva;
import interfaces_graficas.Menu_Principal;

public class App extends JFrame 
{
	
	public App() 
	{
		JMenuBar menuBar;
		JMenu menuArchivo;
		JMenu menuAyuda;
		JMenuItem menuItemSalir;
		menuBar = new JMenuBar();

		menuArchivo = new JMenu("Archivo");
		menuAyuda = new JMenu("Ayuda");
		
		menuItemSalir = new JMenuItem("Salir");
		menuItemSalir.addActionListener( e -> System.exit(0));
		menuArchivo.add(menuItemSalir);
		
		menuBar.add(menuArchivo);
		menuBar.add(menuAyuda);
		this.setJMenuBar(menuBar);
	}
	
	public static void main(String[] args) 
	{
		
		JFrame app = new App();
		
		app.setTitle("MENU PRINCIPAL");
		
		JPanel panel = new Menu_Principal(app);
		JPanel panel2 = new Interfaz_Generar_Reserva(app, 1, 1);
		
		app.setContentPane(panel2);
		app.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		app.setSize(1040, 825);
		app.setResizable(false);
		app.setLocationRelativeTo(null);
		app.setVisible(true);
		  
		  
		
	}
	
}
