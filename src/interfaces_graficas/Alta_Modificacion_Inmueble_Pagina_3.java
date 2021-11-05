package interfaces_graficas;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import excepciones.BaseDeDatosException;
import excepciones.Datos_Invalidos_Exception;
import gestores.Gestor_Inmueble;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;

public class Alta_Modificacion_Inmueble_Pagina_3 extends JPanel {
	
	private JLabel lblInformacionExtra;
	private JSeparator separator;
	private JLabel lblObservaciones;
	private JTextPane descripcion;
	private JLabel lblImagenes;
	private JEditorPane editorPane;
	private JButton btnCancelar;
	private JButton btnImagen;
	private JButton btnAceptar;
	
	/*Recibe el panel anterior para poder moverse entre interfaces con la posibilidad de volver al anterior*/
	
	private Gestor_Inmueble gestorInmueble;
	
	/**
	 * @wbp.parser.constructor
	 */
	public Alta_Modificacion_Inmueble_Pagina_3(JFrame pantallaPrincipal, Gestor_Inmueble gi) {
		this.gestorInmueble = gi;
		this.armarPanel(pantallaPrincipal);
	}
	
	public Alta_Modificacion_Inmueble_Pagina_3(JFrame pantallaPrincipal, String descripcion) {
		this.armarPanel(pantallaPrincipal);
		this.setearDatos(descripcion);
	}
	
	
	
	public void armarPanel(JFrame pantallaPrincipal) {
		
		setLayout(null);
		
		lblInformacionExtra = new JLabel("Informaci\u00F3n extra acerca del inmueble");
		lblInformacionExtra.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblInformacionExtra.setBounds(10, 40, 373, 20);
		add(lblInformacionExtra);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(389, 53, 625, 20);
		add(separator);
		
		lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblObservaciones.setBounds(113, 90, 143, 25);
		add(lblObservaciones);
		
		descripcion = new JTextPane();
		descripcion.setBounds(113, 126, 805, 212);
		descripcion.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(descripcion.getText().length()>499) 
				{
					e.consume();
				}
				char c= e.getKeyChar();
				if(Character.isLowerCase(c)) 
				{
					String cad = (""+c).toUpperCase();
					c=cad.charAt(0);
					e.setKeyChar(c);
				}

			}
		});
		add(descripcion);
		
		lblImagenes = new JLabel("Imagenes:");
		lblImagenes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImagenes.setBounds(113, 349, 108, 25);
		add(lblImagenes);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(113, 385, 805, 128);
		add(editorPane);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBounds(914, 717, 100, 40);
		add(btnCancelar);
		
		btnImagen = new JButton("Adjuntar Imagen");
		btnImagen.setBounds(786, 524, 132, 30);
		add(btnImagen);
		
		btnAceptar = new JButton("Crear Inmueble");
		btnAceptar.addActionListener(e-> {
			
			try {
				
				gestorInmueble.actualizarModelo_Datos_Extras(this.descripcion.getText());
				gestorInmueble.crear_Inmueble();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (BaseDeDatosException e1) {
				e1.printStackTrace();
			}
			
		});
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAceptar.setBounds(746, 717, 158, 40);
		add(btnAceptar);

	}
	
	private void mostrarMensajeError(JFrame padre, String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.ERROR_MESSAGE);
	}
	
	private void setearDatos(String descripcion) {
		this.descripcion.setText(descripcion);
	}
	
}
