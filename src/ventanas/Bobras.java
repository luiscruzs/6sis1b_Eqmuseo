package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

import imagen.fondo;


public class Bobras extends JFrame {
	final String CONTROLADOR = "com.mysql.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/obras";
	final String USUARIO = "root";
	final String CLAVE = "1234";
	PreparedStatement ps;
	ResultSet rs;
	Connection conexion = null;

	public Connection getConnection() {

		try {
			Class.forName(CONTROLADOR);
			conexion = (Connection) DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexión OK");

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar el controlador");
			e.printStackTrace();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la conexión");
			e.printStackTrace();
		}

		return conexion;
	}
	
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtnombre;
	private JTextField txttpo;
	private JTextField txtnomaut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					Bobras frame = new Bobras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bobras() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\crair\\Downloads\\1626195.png"));
		setTitle("OBRAS DE ARTE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		fondo p = new fondo();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OBRAS DE ARTE");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(164, 30, 144, 14);
		p.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID de obra");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 70, 80, 14);
		p.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.setBounds(100, 68, 71, 20);
		p.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(10, 105, 71, 14);
		p.add(lblNewLabel_2);
		
		txtnombre = new JTextField();
		txtnombre.setEnabled(false);
		txtnombre.setBounds(98, 103, 86, 20);
		p.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de obra");
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(10, 139, 86, 14);
		p.add(lblNewLabel_3);
		
		txttpo = new JTextField();
		txttpo.setEnabled(false);
		txttpo.setBounds(98, 137, 86, 20);
		p.add(txttpo);
		txttpo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Autor");
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(10, 177, 71, 14);
		p.add(lblNewLabel_4);
		
		txtnomaut = new JTextField();
		txtnomaut.setEnabled(false);
		txtnomaut.setBounds(98, 175, 86, 20);
		p.add(txtnomaut);
		txtnomaut.setColumns(10);
		
		JButton btnNewButton = new JButton("B\u00FAscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
				con=getConnection();
				try {
					ps=con.prepareStatement("SELECT * FROM obra WHERE id_ob=?");
					ps.setString(1,txtid.getText());
					rs=ps.executeQuery();
					if(rs.next()) {
						txtnombre.setText(rs.getString("nom_ob"));
						txttpo.setText(rs.getString("tip_ob"));
						txtnomaut.setText(rs.getString("nom_aut"));
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(24, 227, 89, 23);
		p.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAEE edo = new VentanaAEE();
				edo.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBounds(153, 227, 89, 23);
		p.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Regresar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 VentanaAcceso bien= new  VentanaAcceso();
				bien.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_2.setBounds(289, 227, 112, 23);
		p.add(btnNewButton_2);
	}

}