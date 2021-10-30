package interfaces_graficas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

public class Alta_Modificacion_Inmueble_Pagina_3 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Alta_Modificacion_Inmueble_Pagina_3(JFrame pantallaPrincipal) {
		
		setLayout(null);
		
		JLabel lblInformacionExtra = new JLabel("Informaci\u00F3n extra acerca del inmueble");
		lblInformacionExtra.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblInformacionExtra.setBounds(10, 40, 373, 20);
		add(lblInformacionExtra);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(389, 53, 625, 20);
		add(separator);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblObservaciones.setBounds(113, 90, 143, 25);
		add(lblObservaciones);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(113, 126, 805, 128);
		add(textPane);
		
		JLabel lblImagenes = new JLabel("Imagenes:");
		lblImagenes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImagenes.setBounds(113, 284, 108, 25);
		add(lblImagenes);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(113, 320, 805, 128);
		add(editorPane);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBounds(914, 717, 100, 40);
		add(btnCancelar);
		
		JButton btnImagen = new JButton("Adjuntar Imagen");
		btnImagen.setBounds(786, 459, 132, 30);
		add(btnImagen);
		
		JButton btnPginaAnterior = new JButton("P\u00E1gina Anterior");
		btnPginaAnterior.setForeground(Color.BLACK);
		btnPginaAnterior.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPginaAnterior.setBounds(736, 526, 182, 25);
		add(btnPginaAnterior);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAceptar.setBounds(804, 717, 100, 40);
		add(btnAceptar);

	}

}
