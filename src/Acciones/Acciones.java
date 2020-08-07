package Acciones;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;

import ventanas.VentanaAEE;

public class Acciones {
	final String CONTROLADOR = "com.mysql.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/producto";
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
	/**Agregar**/
	public void Agregar(VentanaAEE var) {
		
		
	}
	
	/*
	//buscar
	public void Buscar() {
		Connection con=null;
		con=getConnection();
		try {
			ps=con.prepareStatement("SELECT * FROM productos WHERE id_prod=?");
			ps.setString(1,txtid.getText());
			rs=ps.executeQuery();
			if(rs.next()) {
				txtcodigo.setText(rs.getString("codigo"));
				txtnombre.setText(rs.getString("nombre"));
				txtunidad.setText(rs.getString("unidad"));
				txtprecio.setText(rs.getString("precio"));
				txtalmacen.setText(rs.getString("cant_almacen"));
			}else {
				JOptionPane.showMessageDialog(null,"¡ERROR! REGISTRO NO ENCONTRADO");
				limpiar();
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}/* Actualizamos siempre las tablas despues del registro 
		//mostrarDatosUsandoLogica();
		//limpiar();
		
	}
	//editar
	
	
	//eliminar
	
	
	//private void limpiar() {
		txtid.setText("");
		txtcodigo.setText("");
		txtnombre.setText("");
		txtunidad.setText("");
		txtprecio.setText("");
		txtalmacen.setText("");
	}*/
	
}
