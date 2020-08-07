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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class taquilla extends JFrame {

	final String CONTROLADOR = "com.mysql.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/obras";
	final String USUARIO = "root";
	final String CLAVE = "1234";
	PreparedStatement ps;
	ResultSet rs;
	Connection conexion = null;
    public Connection conectar() {	
        
        try {
            Class.forName(CONTROLADOR);
            conexion = (Connection) DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión OK");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar el controlador");
            e.printStackTrace();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error en la conexión");
            e.printStackTrace();
        }
        
        return conexion;
    }

	private JPanel contentPane;
	private JTextField textField;
	private JTextField total;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					taquilla frame = new taquilla();
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
	public taquilla() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\crair\\Downloads\\1626195.png"));
		setTitle("TAQUILLA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		fondo p = new fondo();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo de boleto");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(10, 53, 111, 14);
		p.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TAQUILLA");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(182, 22, 100, 19);
		p.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"General", "Estudiante", "Tercera edad"}));
		comboBox.setBounds(131, 51, 100, 20);
		p.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("No. de boletos");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(10, 92, 100, 14);
		p.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Subtotal  $");
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(10, 134, 91, 14);
		p.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(92, 132, 47, 20);
		p.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Total      $");
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(10, 159, 77, 14);
		p.add(lblNewLabel_4);
		
		total = new JTextField();
		total.setEnabled(false);
		total.setBounds(92, 157, 47, 20);
		p.add(total);
		total.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 90, 34, 20);
		p.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Aprobar venta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Item;
				Item= comboBox.getSelectedItem().toString();
				double num;
				double result;
				if (Item.equalsIgnoreCase("General")) {
					
					num = Double.parseDouble(textField_2.getText());
					result = num*80;
					total.setText(String.valueOf(result));
					
				}
					else
						if (Item.equalsIgnoreCase("Estudiante")) {
							
							num = Double.parseDouble(textField_2.getText());
							result = num*50;
							total.setText(String.valueOf(result));
							
						}
						else
							if (Item.equalsIgnoreCase("Tercera edad")) {
								
								num = Double.parseDouble(textField_2.getText());
								result = num*60;
								total.setText(String.valueOf(result));
								
							}
				Connection conexion = null;
				try {
					conexion = conectar();
					ps = (PreparedStatement) conexion.prepareStatement("INSERT INTO taquilla(id_boleto, tipo_bol, pre_bol =?");
					ps.setString(2, comboBox.getToolTipText());
					ps.setString(3, textField_2.getText());
					int res = ps.executeUpdate();
					if (res > 0) {
						JOptionPane.showMessageDialog(null, "dato guardado");
						
					}
					else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
					conexion.close();
				} catch (Exception e1){
					System.err.println(e1);
					
				}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(12, 213, 127, 23);
		p.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar venta");
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBounds(162, 214, 138, 23);
		p.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Regresar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAcceso bien = new VentanaAcceso();
				bien.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_2.setBounds(324, 214, 100, 23);
		p.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ventas");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venta ven = new venta();
				ven.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_3.setBounds(345, 0, 89, 23);
		p.add(btnNewButton_3);
		
		
	}
}