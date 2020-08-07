package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;

import imagen.fondo;

public class VentanaAEE extends JFrame {
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

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private JTextField txtid;
	private JTextField txtnombre;
	private JTextField txtnomaut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					VentanaAEE frame = new VentanaAEE();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VentanaAEE() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\crair\\Downloads\\1626195.png"));
		setTitle("EDITAR OBRAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		fondo p = new fondo();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EDITAR OBRAS");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(158, 27, 148, 14);
		p.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID de obra");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 58, 74, 14);
		p.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.setBounds(131, 56, 64, 20);
		p.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(10, 89, 64, 14);
		p.add(lblNewLabel_2);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(131, 87, 86, 20);
		p.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de obra");
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(10, 122, 94, 14);
		p.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pintura", "Escultura"}));
		comboBox.setBounds(130, 118, 76, 20);
		p.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre del autor");
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(10, 167, 116, 14);
		p.add(lblNewLabel_4);
		
		txtnomaut = new JTextField();
		txtnomaut.setBounds(131, 165, 86, 20);
		p.add(txtnomaut);
		txtnomaut.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha adquirida");
		lblNewLabel_5.setForeground(Color.YELLOW);
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(10, 194, 116, 14);
		p.add(lblNewLabel_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy/MMM/dd");
		dateChooser.setBounds(131, 196, 106, 20);
		p.add(dateChooser);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
				con=getConnection();
				try {
					ps=(PreparedStatement) con.prepareStatement("INSERT INTO obra id_ob,nom_ob,tip_ob,nom_aut,fecha "
							+ "VALUES(?,?,?,?,?)");
					ps.setString(1,txtid.getText());
					ps.setString(2,txtnombre.getText());
					ps.setString(3,comboBox.getActionCommand());
					ps.setString(4,txtnomaut.getText());
					ps.setString(5,dateChooser.getDateFormatString());
					int res = ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null,"Registro guardado");
					}else {
						JOptionPane optionPane = new JOptionPane("ERROR AL GUARDAR", JOptionPane.ERROR_MESSAGE);    
						JDialog dialog = optionPane.createDialog("¡ERROR!");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					}
					con.close();
				}catch(SQLException e1) {
					System.out.println(e1.getMessage());
					System.out.println(e1.getStackTrace());
				}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(15, 227, 89, 23);
		p.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				con=getConnection();
				try {
					ps=(PreparedStatement)con.prepareStatement("UPDATE obra SET nom_ob=?,tip_ob=?,nom_aut=?,fecha=? WHERE id_ob=?");
					
					ps.setString(1,txtnombre.getText());
					ps.setString(2,comboBox.getActionCommand());
					ps.setString(3,txtnomaut.getText());
					//ps.setByte(4, dateChooser.getCalendarButton());
					ps.setString(5,txtid.getText());
					
					int res = ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null,"Registro modificado");
					}else {
						JOptionPane optionPane = new JOptionPane("ERROR AL MODIFICAR", JOptionPane.ERROR_MESSAGE);    
						JDialog dialog = optionPane.createDialog("¡ERROR!");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					}
					con.close();
				}catch(Exception e2) {
					JOptionPane optionPane = new JOptionPane("ERROR DE CONEXION", JOptionPane.ERROR_MESSAGE);    
					JDialog dialog = optionPane.createDialog("¡ERROR!");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
					System.out.println(e2.getMessage());
					System.out.println(e2.getStackTrace());
				}
			}	
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBounds(114, 227, 89, 23);
		p.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection con=null;
				con=getConnection();
				try {
					ps=(PreparedStatement)con.prepareStatement("DELETE FROM obra WHERE id_ob=?");
					ps.setInt(1,Integer.parseInt(txtid.getText()));
					int res=ps.executeUpdate();
					if(res>0) {
						JOptionPane.showMessageDialog(null,"Registro eliminado");
					}else {
						JOptionPane optionPane = new JOptionPane("ERROR AL ELIMINAR", JOptionPane.ERROR_MESSAGE);    
						JDialog dialog = optionPane.createDialog("¡ERROR!");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					}
					con.close();
				}catch(Exception e3) {
					JOptionPane optionPane = new JOptionPane("ERROR DE CONEXION", JOptionPane.ERROR_MESSAGE);    
					JDialog dialog = optionPane.createDialog("¡ERROR!");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
					System.out.println(e3.getMessage());
					System.out.println(e3.getStackTrace());
				}
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_2.setBounds(213, 227, 89, 23);
		p.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Regresar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bobras ob = new Bobras();
				ob.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_3.setBounds(312, 228, 112, 23);
		p.add(btnNewButton_3);
		
		
	}
	

	protected Connection conectar() throws ClassNotFoundException, SQLException {
	
		return null;
	}
}