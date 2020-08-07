package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import imagen.fondo;

public class empleado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtPrimerApellido;
	private JTextField txtSegundoApellido;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					empleado frame = new empleado();
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
	public empleado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\crair\\Downloads\\1626195.png"));
		setTitle("EMPLEADOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		fondo p = new fondo();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLEADOS");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(180, 27, 111, 14);
		p.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID laboral");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 51, 79, 14);
		p.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(99, 49, 68, 20);
		p.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(10, 88, 68, 14);
		p.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 86, 86, 20);
		p.add(textField_1);
		textField_1.setColumns(10);
		
		txtPrimerApellido = new JTextField();
		txtPrimerApellido.setText("Primer apellido");
		txtPrimerApellido.setBounds(195, 86, 86, 20);
		p.add(txtPrimerApellido);
		txtPrimerApellido.setColumns(10);
		
		txtSegundoApellido = new JTextField();
		txtSegundoApellido.setText("Segundo apellido");
		txtSegundoApellido.setBounds(291, 86, 86, 20);
		p.add(txtSegundoApellido);
		txtSegundoApellido.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Edad");
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(10, 135, 68, 14);
		p.add(lblNewLabel_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(99, 133, 29, 20);
		p.add(spinner);
		
		JLabel lblNewLabel_4 = new JLabel("Puesto");
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(10, 193, 68, 14);
		p.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Gerente", "Recursos humanos", "Taquilla", "Encargado de obras", "Gu\u00EDa"}));
		comboBox.setBounds(99, 190, 111, 20);
		p.add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo");
		lblNewLabel_5.setForeground(Color.YELLOW);
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(10, 168, 57, 14);
		p.add(lblNewLabel_5);
		
		JRadioButton masculino = new JRadioButton("M");
		buttonGroup.add(masculino);
		masculino.setForeground(Color.BLACK);
		masculino.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		masculino.setBounds(99, 160, 50, 23);
		p.add(masculino);
		
		JRadioButton femenino = new JRadioButton("F");
		buttonGroup.add(femenino);
		femenino.setForeground(Color.BLACK);
		femenino.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		femenino.setBounds(158, 160, 50, 23);
		p.add(femenino);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(10, 277, 89, 23);
		p.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBounds(109, 277, 89, 23);
		p.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_2.setBounds(208, 277, 89, 23);
		p.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Regresar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rh r = new rh();
				r.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_3.setBounds(313, 277, 111, 23);
		p.add(btnNewButton_3);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha de contrataci\u00F3n");
		lblNewLabel_6.setForeground(Color.YELLOW);
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_6.setBounds(10, 235, 139, 14);
		p.add(lblNewLabel_6);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(156, 229, 111, 20);
		p.add(dateChooser);
	}
}