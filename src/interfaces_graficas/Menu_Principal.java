package interfaces_graficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import dominio.Login;

public class Menu_Principal extends JPanel 
{
	private JPanel panelMenu;
	private JButton btnGestionarPropietarios;
	private JButton btnGestionarInmuebles;
	private JButton btnListaDeInmuebles;
	private JButton btnABMCliente;
	private JButton btnAbmVendedor;
	private JLabel lblMenuPrincipal;
	private JButton btnVerReservas;

	public Menu_Principal(JFrame pantallaPrincipal) 
	{
		super();
		this.armarPanel(pantallaPrincipal);
	}
	
	
	public void armarPanel(JFrame pantallaPrincipal) 
	{
		setLayout(null);
		panelMenu = new JPanel();
		panelMenu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelMenu.setBackground(SystemColor.scrollbar);
		panelMenu.setBounds(305, 200, 450, 441);
		add(panelMenu);
		panelMenu.setLayout(null);
		
		//PARA VER SI SE GUARDO CORRECTAMENTE EL ID Y EL TIPO DE USUARIO
		System.out.println("Remover esto de Interfaz Menu Principal");
		System.out.println("ID usuario: " + Login.id);
		System.out.println("Tipo de usuario: " + Login.tipoUsuario + " \n");
		
		btnGestionarPropietarios = new JButton("Gestionar Propietarios");
		btnGestionarPropietarios.addActionListener(e->
		{
			this.setVisible(false);
			JPanel panelABMPropietario = new Interfaz_Grafica_Listar_Propietarios(pantallaPrincipal);
			panelABMPropietario.setVisible(true);
			pantallaPrincipal.setContentPane(panelABMPropietario);
			pantallaPrincipal.setTitle("Gestionar Propietarios");
		});
		btnGestionarPropietarios.setBounds(85, 88, 280, 40);
		btnGestionarPropietarios.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelMenu.add(btnGestionarPropietarios);
		
		btnGestionarInmuebles = new JButton("Gestionar Inmuebles");
		btnGestionarInmuebles.addActionListener(e->
		{
			this.setVisible(false);
			JPanel panelGestionarInmueble = new Interfaz_Gestionar_Inmueble(pantallaPrincipal);
			panelGestionarInmueble.setVisible(true);
			pantallaPrincipal.setContentPane(panelGestionarInmueble);
			pantallaPrincipal.setTitle("Gestionar Inmuebles");
		});
		btnGestionarInmuebles.setBounds(85, 138, 280, 40);
		btnGestionarInmuebles.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelMenu.add(btnGestionarInmuebles);
		
		btnListaDeInmuebles = new JButton("Lista de Inmuebles");
		btnListaDeInmuebles.addActionListener(e->
		{
			this.setVisible(false);
			JPanel panelListaDeInmuebles = new Interfaz_Consultar_Inmuebles(pantallaPrincipal);
			panelListaDeInmuebles.setVisible(true);
			pantallaPrincipal.setContentPane(panelListaDeInmuebles);
			pantallaPrincipal.setTitle("Lista de Inmuebles");
		});
		btnListaDeInmuebles.setBounds(85, 184, 280, 40);
		btnListaDeInmuebles.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelMenu.add(btnListaDeInmuebles);
		
		btnABMCliente = new JButton("ABM Cliente");
		btnABMCliente.setBounds(85, 230, 280, 40);
		btnABMCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnABMCliente.addActionListener(e->
		{
			
			this.setVisible(false);
			JPanel panelListaDeClientes = new Lista_Cliente(pantallaPrincipal);
			panelListaDeClientes.setVisible(true);
			pantallaPrincipal.setContentPane(panelListaDeClientes);
			pantallaPrincipal.setTitle("Lista de Clientes");
			
		});
		panelMenu.add(btnABMCliente);
		
		JButton btnVerCatalogo = new JButton("Ver Catalogo");
		btnVerCatalogo.addActionListener(e->
		{
			
			this.setVisible(false);
			JPanel panelVerCatalogo = new Interfaz_Grafica_Ver_Catalogo(pantallaPrincipal);
			panelVerCatalogo.setVisible(true);
			pantallaPrincipal.setContentPane(panelVerCatalogo);
			pantallaPrincipal.setTitle("Catalogo");
			
		});
		btnVerCatalogo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVerCatalogo.setBounds(85, 278, 280, 40);
		panelMenu.add(btnVerCatalogo);
		
		btnVerReservas = new JButton("Ver Reservas");
		btnVerReservas.addActionListener(e->
		{
			
			this.setVisible(false);
			JPanel panelVerReservas = new Interfaz_Grafica_Ver_Reservas(pantallaPrincipal);
			panelVerReservas.setVisible(true);
			pantallaPrincipal.setContentPane(panelVerReservas);
			pantallaPrincipal.setTitle("Catalogo");
			
		});
		btnVerReservas.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVerReservas.setBounds(85, 329, 280, 40);
		panelMenu.add(btnVerReservas);
		
		lblMenuPrincipal = new JLabel("Men\u00FA Principal");
		lblMenuPrincipal.setForeground(new Color(0, 0, 255));
		lblMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMenuPrincipal.setBounds(155, 11, 140, 35);
		panelMenu.add(lblMenuPrincipal);
		
		btnAbmVendedor = new JButton("ABM Vendedor");
		btnAbmVendedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAbmVendedor.setBounds(85, 379, 280, 40);
		btnAbmVendedor.addActionListener(e->
		{
			
			this.setVisible(false);
			JPanel panelListaDeVendedores = new Lista_Vendedor(pantallaPrincipal);
			panelListaDeVendedores.setVisible(true);
			pantallaPrincipal.setContentPane(panelListaDeVendedores);
			pantallaPrincipal.setTitle("Lista de Vendedores");
			
		});
		panelMenu.add(btnAbmVendedor);
	
		this.setVisible(true);

	}
}