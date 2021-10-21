package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import interfaces_graficas.Alta_Propietario;
import interfaces_graficas.Interfaz_Grafica_Listar_Propietarios;

public class App extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		JFrame app = new App();
		
		
		JPanel panel1 = new Interfaz_Grafica_Listar_Propietarios(app);
		
		app.setContentPane(panel1);
		app.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		app.setSize(1040, 805);
		app.setResizable(false);
		app.setLocationRelativeTo(null);
		app.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public App() {

	}


}
