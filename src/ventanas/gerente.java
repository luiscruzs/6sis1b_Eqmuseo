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
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import imagen.fondo;
import trabajomuseo.bienvenido;
import trabajomuseo.gerente;
import trabajomuseo.obras;
import trabajomuseo.rh;
import trabajomuseo.taquilla;

public class gerente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					gerente frame = new gerente();
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
	public gerente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\crair\\Downloads\\1626195.png"));
		setTitle("GERENTE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		fondo p = new fondo();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GERENTE");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(181, 22, 91, 14);
		p.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("TAQUILLA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taquilla taq = new taquilla();
				taq.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBounds(30, 102, 102, 58);
		p.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("OBRAS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vobras ob = new Vobras();
				ob.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBounds(168, 102, 102, 58);
		p.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("R.H");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rh h = new rh();
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_2.setBounds(302, 102, 102, 58);
		p.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Regresar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAcceso bi = new VentanaAcceso();
				bi.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_3.setBounds(168, 227, 104, 23);
		p.add(btnNewButton_3);
	}

}