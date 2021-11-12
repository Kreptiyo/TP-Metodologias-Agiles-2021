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

public class Menu_Principal extends JPanel 
{
	private JPanel panelMenu;
	private JButton btnGestionarPropietarios;
	private JButton btnGestionarInmuebles;
	private JButton btnListaDeInmuebles;
	private JButton btnABMCliente;
	private JLabel lblMenuPrincipal;

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
		panelMenu.setBounds(305, 200, 450, 360);
		add(panelMenu);
		panelMenu.setLayout(null);
		
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
		panelMenu.add(btnABMCliente);
		
		lblMenuPrincipal = new JLabel("Men\u00FA Principal");
		lblMenuPrincipal.setForeground(new Color(0, 0, 255));
		lblMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMenuPrincipal.setBounds(155, 11, 140, 35);
		panelMenu.add(lblMenuPrincipal);
		
		this.setVisible(true);

	}
}