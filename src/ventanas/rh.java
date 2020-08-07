package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
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
import com.mysql.jdbc.PreparedStatement;

import imagen.fondo;

public class rh extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtnombre;
	private JTextField txtedad;
	private JTextField txtpuesto;
	private JTextField txtsexo;
	private JTextField txtfecha;
	
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
			conexion = (Connection) DriverManager.getConnection(URL, USUARIO, CLAVE );

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar el controlador");
			e.printStackTrace();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la conexión");
			e.printStackTrace();
		}

		return conexion;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					rh frame = new rh();
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
	public rh() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\crair\\Downloads\\1626195.png"));
		setTitle("RECURSOS HUMANOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 321);
		fondo p = new fondo();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RECURSOS HUMANOS");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(143, 25, 183, 14);
		p.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID laboral");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 51, 82, 14);
		p.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.setBounds(161, 45, 64, 20);
		p.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(10, 80, 71, 14);
		p.add(lblNewLabel_2);
		
		txtnombre = new JTextField();
		txtnombre.setEnabled(false);
		txtnombre.setBounds(161, 78, 86, 20);
		p.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Edad");
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(10, 117, 53, 14);
		p.add(lblNewLabel_3);
		
		txtedad = new JTextField();
		txtedad.setEnabled(false);
		txtedad.setBounds(161, 115, 34, 20);
		p.add(txtedad);
		txtedad.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Puesto");
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(10, 179, 71, 14);
		p.add(lblNewLabel_4);
		
		txtpuesto = new JTextField();
		txtpuesto.setEnabled(false);
		txtpuesto.setBounds(161, 177, 86, 20);
		p.add(txtpuesto);
		txtpuesto.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo");
		lblNewLabel_5.setForeground(Color.YELLOW);
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(10, 142, 46, 14);
		p.add(lblNewLabel_5);
		
		txtsexo = new JTextField();
		txtsexo.setBounds(161, 146, 64, 20);
		p.add(txtsexo);
		txtsexo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha de contrataci\u00F3n");
		lblNewLabel_6.setForeground(Color.YELLOW);
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_6.setBounds(10, 209, 145, 31);
		p.add(lblNewLabel_6);
		
		txtfecha = new JTextField();
		txtfecha.setBounds(161, 217, 86, 20);
		p.add(txtfecha);
		txtfecha.setColumns(10);
		
		JButton btnNewButton = new JButton("B\u00FAscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//aqui van las acciones para buscar el empleado mediante id 
				Connection con=null;
				con=getConnection();
				try {
					ps=(PreparedStatement) con.prepareStatement("SELECT * FROM empleado WHERE id_emp=?");
					ps.setString(1,txtid.getText());
					rs=ps.executeQuery();
					if(rs.next()) {
						txtnombre.setText(rs.getString("nom_ob"));
						txtedad.setText(rs.getString("edad"));
						txtsexo.setText(rs.getString("sexo"));
						txtpuesto.setText(rs.getString("puesto"));
						txtfecha.setText(rs.getString("fecha_cont"));
						
					}
					
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(10, 248, 89, 23);
		p.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleado emp = new empleado();
				emp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBounds(158, 248, 89, 23);
		p.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Regresar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAcceso bi = new VentanaAcceso();
				bi.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_2.setBounds(292, 248, 107, 23);
		p.add(btnNewButton_2);
		
		
	}

}