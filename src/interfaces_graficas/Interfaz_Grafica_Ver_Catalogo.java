package interfaces_graficas;

import javax.swing.JPanel;

import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import dominio.Inmueble;
import gestores.Gestor_Inmueble;
import modelos_tablas.Modelo_Tabla_Ver_Catalogo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_Grafica_Ver_Catalogo extends JPanel {
	private JTextField textFieldFechaEmision;
	private JTable table;
	private Modelo_Tabla_Ver_Catalogo modeloTabla;
	private List<Inmueble> listaDeInmuebles;
	private Gestor_Inmueble gestorInmueble;

	
	public Interfaz_Grafica_Ver_Catalogo(JFrame pantallaPrincipal)
	{
		gestorInmueble = new Gestor_Inmueble();
		listaDeInmuebles = gestorInmueble.listarTodos();
		System.out.println(listaDeInmuebles.size());
		armarPanel(pantallaPrincipal);
	}
	
	
	public void armarPanel(JFrame pantallaPrincipal) {
		setLayout(null);
		
		JLabel lblFechaEmision = new JLabel("Fecha de Emision:");
		lblFechaEmision.setBounds(41, 42, 118, 14);
		add(lblFechaEmision);
		
		textFieldFechaEmision = new JTextField();
		textFieldFechaEmision.setEditable(false);
		textFieldFechaEmision.setEnabled(false);
		textFieldFechaEmision.setBounds(153, 39, 86, 20);
		add(textFieldFechaEmision);
		textFieldFechaEmision.setColumns(10);
		
		
		modeloTabla = new Modelo_Tabla_Ver_Catalogo(listaDeInmuebles);
		table = new JTable();
		table.setBounds(10, 245, 899, 445);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(10, 108, 1002, 556);
		add(scrollPane);
		
		JButton btnReservar = new JButton("Generar Reserva");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReservar.setBounds(10, 694, 149, 51);
		add(btnReservar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e->
		{
			this.setVisible(false);
			JPanel panelMenuPrincipal = new Menu_Principal(pantallaPrincipal);
			pantallaPrincipal.setContentPane(panelMenuPrincipal);
			pantallaPrincipal.setTitle("MENU PRINCIPAL");
		});
		btnVolver.setBounds(863, 694, 149, 51);
		add(btnVolver);

	}
}
