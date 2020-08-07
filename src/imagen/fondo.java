package imagen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class fondo extends javax.swing.JPanel{
	private static final long serialVersionUID =1L;
	
public fondo() {
	this.setSize(800,800);
}
@Override
public void paintComponent(Graphics g) {
	Dimension tamanio = getSize();
	ImageIcon ImagenFondo = new ImageIcon(getClass().getResource("WhatsApp Image 2020-07-14 at 8.46.36 PM.jpeg"));
	g.drawImage(ImagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height,null);
	setOpaque(false);
	super.paintComponent(g);
}
}