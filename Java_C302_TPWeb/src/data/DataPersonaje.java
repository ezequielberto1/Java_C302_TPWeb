package data;


import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import entidades.*;
import utils.ApplicationException;

public class DataPersonaje {

	public DataPersonaje(){

	}

	public void add(Personaje p){
		ResultSet rs=null;
		PreparedStatement stmt=null;


		try {
			stmt=MySqlConexion.getInstancia().getConn().prepareStatement(
					"insert into personajes(nom_personaje, vida, energia, defensa, evasion, ptos_totales)"+
							" values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getVida());
			stmt.setInt(3, p.getEnergia());
			stmt.setInt(4, p.getDefensa());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPtos_totales());
			stmt.execute();

			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setCodigo(rs.getInt(1));
			}

		} 
		catch (SQLException e) {

			e.printStackTrace();
		} 
		catch (ApplicationException e) {

			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) 
					rs.close();
				if(stmt!=null)
					stmt.close();
				MySqlConexion.getInstancia().releaseConn();
			} 
			catch (ApplicationException e) {

				e.printStackTrace();
			} 
			catch (SQLException e) {

				e.printStackTrace();
			}
		}		
	}


	public void update(Personaje p, String nom){
		PreparedStatement stmt=null;

		try {
			stmt= MySqlConexion.getInstancia().getConn().prepareStatement(
					"update personajes set nom_personaje=?, vida=?, energia=?, defensa=?, evasion=?, ptos_totales=?"+
					" where nom_personaje=?");

			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getVida());
			stmt.setInt(3, p.getEnergia());
			stmt.setInt(4, p.getDefensa());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPtos_totales());
			stmt.setString(7, nom);	

			stmt.execute();
		} 
		catch (SQLException e) {

			e.printStackTrace();
		} 
		catch (ApplicationException e) {

			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)
					stmt.close();
				MySqlConexion.getInstancia().releaseConn();
			} 
			catch (SQLException e) {

				e.printStackTrace();
			} 
			catch (ApplicationException e) {

				e.printStackTrace();
			}
		}
	}


	public void delete(int cod, String nom){
		PreparedStatement stmt=null;


		try {
			stmt = MySqlConexion.getInstancia().getConn().prepareStatement(
					"DELETE FROM personajes WHERE cod_personaje=? and nom_personaje=?");
			stmt.setInt(1, cod);
			stmt.setString(2, nom);


			stmt.execute();
			MySqlConexion.getInstancia().getConn().close();
		} 
		catch (SQLException e) {

			e.printStackTrace();
		} 
		catch (ApplicationException e) {

			e.printStackTrace();
		} 
		finally {
			try {
				if(stmt!=null)
					stmt.close();
				MySqlConexion.getInstancia().releaseConn();
			} catch (SQLException e) {

				e.printStackTrace();
			} catch (ApplicationException e) {

				e.printStackTrace();
			}
		}		
	}


	public Personaje getByNombre(String nom){

		Personaje p=null;

		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = MySqlConexion.getInstancia().getConn().prepareStatement(
					"select cod_personaje, nom_personaje, vida, energia, defensa, evasion, ptos_totales from personajes"+
					" where nom_personaje=?");
			stmt.setString(1, nom);
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Personaje();
				p.setCodigo(rs.getInt("cod_personaje"));				
				p.setNombre(rs.getString("nom_personaje"));
				p.setVida(rs.getInt("vida"));
				p.setEnergia(rs.getInt("energia"));
				p.setDefensa(rs.getInt("defensa"));
				p.setEvasion(rs.getInt("evasion"));
				p.setPtos_totales(rs.getInt("ptos_totales"));
			}
		} 
		catch (SQLException e) {

			e.printStackTrace();
		} 
		catch (ApplicationException e) {

			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				MySqlConexion.getInstancia().releaseConn();
			} catch (SQLException e) {

				e.printStackTrace();
			} catch (ApplicationException e) {

				e.printStackTrace();
			}
		}		
		return p;
	}

	public Personaje getByCodigo(int cod){

		Personaje p=null;

		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = MySqlConexion.getInstancia().getConn().prepareStatement(
					"select cod_personaje, nom_personaje, vida, energia, defensa, evasion, ptos_totales from personajes"+
					" where cod_personaje=?");
			stmt.setInt(1, cod);
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Personaje();
				p.setCodigo(rs.getInt("cod_personaje"));				
				p.setNombre(rs.getString("nom_personaje"));
				p.setVida(rs.getInt("vida"));
				p.setEnergia(rs.getInt("energia"));
				p.setDefensa(rs.getInt("defensa"));
				p.setEvasion(rs.getInt("evasion"));
				p.setPtos_totales(rs.getInt("ptos_totales"));
			}
		} 
		catch (SQLException e) {

			e.printStackTrace();
		} 
		catch (ApplicationException e) {

			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				MySqlConexion.getInstancia().releaseConn();
			} catch (SQLException e) {

				e.printStackTrace();
			} catch (ApplicationException e) {

				e.printStackTrace();
			}
		}		
		return p;
	}

	public boolean coincideNombre(String nom){


		boolean coincide=false;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = MySqlConexion.getInstancia().getConn().prepareStatement(
					"select cod_personaje, nom_personaje, vida, energia, defensa, evasion, ptos_totales from personajes"+
					" where nom_personaje=?");
			stmt.setString(1, nom);
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				coincide=true;
			}
		} 
		catch (SQLException e) {

			e.printStackTrace();
		} 
		catch (ApplicationException e) {

			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				MySqlConexion.getInstancia().releaseConn();
			} catch (SQLException e) {

				e.printStackTrace();
			} catch (ApplicationException e) {

				e.printStackTrace();
			}
		}		
		return coincide;
	}

	public boolean coincideCodigoNom(int cod, String nom){


		boolean coincide=false;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = MySqlConexion.getInstancia().getConn().prepareStatement(
					"select cod_personaje, nom_personaje, vida, energia, defensa, evasion, ptos_totales from personajes"+
					" where cod_personaje=? and nom_personaje=?");
			stmt.setInt(1, cod);
			stmt.setString(2, nom);
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				coincide=true;
			}
		} 
		catch (SQLException e) {

			e.printStackTrace();
		} 
		catch (ApplicationException e) {

			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				MySqlConexion.getInstancia().releaseConn();
			} catch (SQLException e) {

				e.printStackTrace();
			} catch (ApplicationException e) {

				e.printStackTrace();
			}
		}		
		return coincide;
	}
	
	public void cargarListaPersonajes(JTable tabla) throws ApplicationException {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		DefaultTableModel model;

		try {

			stmt = MySqlConexion.getInstancia().getConn().prepareStatement("select * from personajes order by cod_personaje asc");
			rs = stmt.executeQuery();
			model = buildTableModel(rs);
			tabla.setModel(model);
			TableColumnModel m = tabla.getColumnModel();
			
		} catch (SQLException ex) {

			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();


		}
		finally{
			try {
				if (rs!=null)
					rs.close();
				if (stmt!=null)stmt.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
			throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		/**/for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}
		
		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);

	}
}


