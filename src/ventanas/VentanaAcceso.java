package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import imagen.fondo;

public class VentanaAcceso extends JFrame {

	private JPanel contentPane;
	private JPasswordField cont;
	private JTextField usu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					VentanaAcceso frame = new VentanaAcceso();
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
	public VentanaAcceso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\crair\\Downloads\\1626195.png"));
		setTitle("INICIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		fondo p = new fondo();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(173, 11, 119, 30);
		p.add(lblNewLabel);
		
		cont = new JPasswordField();
		cont.setBounds(173, 144, 119, 20);
		p.add(cont);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_1.setBounds(173, 119, 119, 14);
		p.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASE\u00D1A");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_2.setBounds(159, 175, 157, 14);
		p.add(lblNewLabel_2);
		
		usu = new JTextField();
		usu.setBounds(173, 85, 119, 20);
		p.add(usu);
		usu.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CONTRASEÑA USE1MN USUARIO usetaquilla
				if(cont.getText().contentEquals("USE1MN") & usu.getText().contentEquals("usetaquilla")) {
					/*taquilla ejem1 = new taquilla();
					ejem1.setVisible(true);
					dispose();*/
				}
				else
					if(cont.getText().contentEquals("USE2MN") & usu.getText().contentEquals("useobras")) {
						Bobras ejem2 = new Bobras();
						ejem2.setVisible(true);
						dispose();
					}
					else
						if(cont.getText().contentEquals("USE3MN") & usu.getText().contentEquals("userh")) {
							/*rh ejem3 = new rh();
							ejem3.setVisible(true);
							dispose();*/
							
						}
						
						else
							if(cont.getText().contentEquals("USEGGMN") & usu.getText().contentEquals("usegerente")) {
								/*gerente ejem4 = new gerente();
								ejem4.setVisible(true);
								dispose();*/
							}else {
								JOptionPane.showMessageDialog(null,"Usuario no reconocido");
								
							}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(59, 215, 89, 23);
		p.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBounds(265, 215, 89, 23);
		p.add(btnNewButton_1);
		
		
	}
}
