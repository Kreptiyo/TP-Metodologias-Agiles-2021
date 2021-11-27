package interfaces_graficas;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.MatteBorder;

import dominio.Login;
import gestores.Gestor_Login;

public class Interfaz_Grafica_Login extends JPanel 
{
	private JPanel panelMenu;
	private JTextField textFieldNumDocumento;
	private JPasswordField passwordField;
	private Gestor_Login gestorLogin;

	public Interfaz_Grafica_Login(JFrame pantallaPrincipal) 
	{
		super();
		gestorLogin = new Gestor_Login();
		this.armarPanel(pantallaPrincipal);
	}
	
	public void armarPanel(JFrame pantallaPrincipal) {
		setLayout(null);
		
		panelMenu = new JPanel();
		panelMenu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelMenu.setBackground(SystemColor.scrollbar);
		panelMenu.setBounds(305, 200, 450, 360);
		add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblTitulo = new JLabel("LOGIN");
		lblTitulo.setForeground(Color.BLUE);
		lblTitulo.setBackground(Color.BLUE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(197, 110, 64, 14);
		panelMenu.add(lblTitulo);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBackground(SystemColor.scrollbar);
		rdbtnCliente.setBounds(107, 143, 64, 23);
		panelMenu.add(rdbtnCliente);
		
		JRadioButton rdbtnVendedor = new JRadioButton("Vendedor");
		rdbtnVendedor.setBackground(SystemColor.scrollbar);
		rdbtnVendedor.setBounds(190, 143, 85, 23);
		panelMenu.add(rdbtnVendedor);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBackground(SystemColor.scrollbar);
		rdbtnAdmin.setBounds(291, 143, 64, 23);
		panelMenu.add(rdbtnAdmin);
		
		 ButtonGroup group = new ButtonGroup();
		 group.add(rdbtnCliente);
		 group.add(rdbtnVendedor);
		 group.add(rdbtnAdmin);
		 
		 JLabel lblNumDocumento = new JLabel("Nro. Documento");
		 lblNumDocumento.setBounds(115, 176, 95, 14);
		 panelMenu.add(lblNumDocumento);
		 
		 JLabel lblContraseña = new JLabel("Contrase\u00F1a");
		 lblContraseña.setBounds(136, 201, 74, 14);
		 panelMenu. add(lblContraseña);
		 
		 textFieldNumDocumento = new JTextField();
		 textFieldNumDocumento.addKeyListener(new KeyAdapter() 
			{
				@Override
				public void keyTyped(KeyEvent e) 
				{
					if(textFieldNumDocumento.getText().length()>10) 
					{
						e.consume();
					}
					char input = e.getKeyChar();
					if((input < '0' || input > '9') && input != '\b')
					{
						e.consume();
					}

				}
			});
		 textFieldNumDocumento.setBounds(213, 173, 86, 20);
		 panelMenu.add(textFieldNumDocumento);
		 textFieldNumDocumento.setColumns(10);
		 
		 passwordField = new JPasswordField();
		 passwordField.setBounds(213, 201, 86, 20);
		 panelMenu.add(passwordField);
		 passwordField.setColumns(10);
		 
		 JButton btnIngresar = new JButton("Ingresar");
		 btnIngresar.addActionListener(e->
			{
				if(rdbtnCliente.isSelected())
				{
					String tipoUsuario = "CLIENTE";
					Integer idUsuario = gestorLogin.verificarUsuario(textFieldNumDocumento.getText(), String.valueOf(passwordField.getPassword()), tipoUsuario);
					if(idUsuario != null && idUsuario > 0)
					{
						Login.id = idUsuario;
						Login.tipoUsuario = tipoUsuario;
						this.setVisible(false);
						JPanel panelCliente = new Menu_Principal(pantallaPrincipal);
						panelCliente.setVisible(true);
						pantallaPrincipal.setContentPane(panelCliente);
						pantallaPrincipal.setTitle("Menu de Cliente");
					}
					else
					{
						JOptionPane.showMessageDialog(pantallaPrincipal,
							    "El usuario o contraseña son incorrectos","Datos invalidos",
							    JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else if(rdbtnVendedor.isSelected())
				{
					System.out.println("IMPLEMENTAR MENU VENDEDOR");
					/*
					Integer idUsuario = null;
					String tipoUsuario = "VENDEDOR";
					idUsuario = gestorLogin.verificarUsuario(numDocumento, password, tipoUsuario);
					if(idUsuario != null && idUsuario > 0)
					{
						this.setVisible(false);
						JPanel panelVendedor = new Menu_Vendedor(pantallaPrincipal, idUsuario);
						panelVendedor.setVisible(true);
						pantallaPrincipal.setContentPane(panelVendedor);
						pantallaPrincipal.setTitle("Menu de Vendedor");
					}
					else
					{
						JOptionPane.showMessageDialog(pantallaPrincipal,
							    "El usuario o contraseña son incorrectos","Datos invalidos",
							    JOptionPane.ERROR_MESSAGE);
					}
					*/
				}
				else if(rdbtnAdmin.isSelected())
				{
					/*
					Integer idUsuario = null;
					String tipoUsuario = "ADMINISTRADOR";
					idUsuario = gestorLogin.verificarUsuario(numDocumento, password, tipoUsuario);
					if(idUsuario != null && idUsuario > 0)
					{
						this.setVisible(false);
						JPanel panelAdministrador = new Menu_Principal(pantallaPrincipal);
						panelAdministrador.setVisible(true);
						pantallaPrincipal.setContentPane(panelAdministrador);
						pantallaPrincipal.setTitle("Menu de Administrador");
					}
					else
					{
						JOptionPane.showMessageDialog(pantallaPrincipal,
							    "El usuario o contraseña son incorrectos","Datos invalidos",
							    JOptionPane.ERROR_MESSAGE);
					}
					*/
					this.setVisible(false);
					JPanel panelAdministrador = new Menu_Principal(pantallaPrincipal);
					panelAdministrador.setVisible(true);
					pantallaPrincipal.setContentPane(panelAdministrador);
					pantallaPrincipal.setTitle("Menu de Administrador");
				}
				else
				{
					JOptionPane.showMessageDialog(pantallaPrincipal,
						    "Seleccione un tipo de usuario porfavor","Datos incompletos",
						    JOptionPane.ERROR_MESSAGE);
				}
			});
		 btnIngresar.setBounds(188, 232, 89, 23);
		 panelMenu.add(btnIngresar);
		 
		 this.setVisible(true);

	}
}