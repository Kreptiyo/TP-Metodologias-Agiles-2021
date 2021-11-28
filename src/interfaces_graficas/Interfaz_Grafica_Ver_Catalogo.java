package interfaces_graficas;

import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dominio.Login;
import gestores.Gestor_Catalogo;
import gestores.Gestor_Reserva;
import modelos_tablas.Modelo_Tabla_Ver_Catalogo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Interfaz_Grafica_Ver_Catalogo extends JPanel {
	private JTextField textFieldFechaEmision;
	private JTable table;
	private Modelo_Tabla_Ver_Catalogo modeloTabla;
	private Gestor_Catalogo gestorCatalogo;
	private Gestor_Reserva gestorReserva;
	
	public Interfaz_Grafica_Ver_Catalogo(JFrame pantallaPrincipal)
	{
		gestorCatalogo = new Gestor_Catalogo();
		gestorReserva = new Gestor_Reserva();
		armarPanel(pantallaPrincipal);
	}
	
	
	public void armarPanel(JFrame pantallaPrincipal) {
		setLayout(null);
		
		JLabel lblFechaEmision = new JLabel("Fecha de Emision:");
		lblFechaEmision.setBounds(41, 42, 118, 14);
		add(lblFechaEmision);
		
		
		textFieldFechaEmision = new JTextField(gestorCatalogo.buscarCatalogo(Login.id).getFechaEmision());
		textFieldFechaEmision.setEditable(false);
		textFieldFechaEmision.setBounds(153, 39, 86, 20);
		add(textFieldFechaEmision);
		textFieldFechaEmision.setColumns(10);
		
		
		
		modeloTabla = new Modelo_Tabla_Ver_Catalogo(gestorCatalogo.buscarCatalogo(Login.id).getInmuebles());
		table = new JTable();
		table.setBounds(10, 245, 899, 445);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(10, 108, 1002, 556);
		add(scrollPane);
		
		JButton btnReservar = new JButton("Generar Reserva");
		btnReservar.addActionListener(e->
		{
			if(table.getSelectedRow() != -1) 
			{
				Integer idInmueble = modeloTabla.obtenerIdInmueble(table.getSelectedRow());
				if(gestorReserva.obtenerIdReservaConIdInmueble(idInmueble) < 0)
				{
					this.setVisible(false);
					JPanel panelGenerarReserva = new Interfaz_Generar_Reserva(pantallaPrincipal, Login.id, idInmueble);
					pantallaPrincipal.setContentPane(panelGenerarReserva);
				}
				else
				{
					this.mostrarMensajeAdvertencia(pantallaPrincipal, "Inmueble ya reservado.", "Debe seleccionar un inmueble"+"\n"+" que no haya sido reservado");
				}
			}
			else 
			{
				this.mostrarMensajeAdvertencia(pantallaPrincipal, "No seleccionó ningun inmueble.", "Debe seleccionar un inmueble"+"\n"+"para reservarlo.");
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
		
		if(!Login.tipoUsuario.equals("CLIENTE"))
		{
			btnReservar.setEnabled(false);
		}

	}
	
	public void mostrarMensajeExito(JFrame padre ,String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarMensajeAdvertencia(JFrame padre ,String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.WARNING_MESSAGE);
	}
	
}
