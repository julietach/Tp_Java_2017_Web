package data;
import entity.*;
import util.ApplicationException;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

public class DataReserva implements Serializable{
	public ArrayList<Reserva> getAll() throws ApplicationException{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> res = new ArrayList<Reserva>();
		try{ 
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("Select  *  from reserva  inner join elemento  on reserva.id_el=elemento.id_el");
			if (rs!= null ){
				while(rs.next()){
					Reserva r = new Reserva();
					r.setElemento(new Elemento());
					r.setPersona(new Persona());
					r.setId_res(rs.getInt("id_res"));
					r.getElemento().setId_El(rs.getInt("id_el"));
					r.getElemento().setNombre_El(rs.getString("nombre_el"));
					r.getElemento().getTipoElemento().setId_TE(rs.getInt("id_te"));
					//r.getElemento().getTipoElemento().setNombre_TE(rs.getString("nombre_te"));
					r.getPersona().setId_per(rs.getInt("id_per"));
					r.setFecha(rs.getDate("fecha"));
					r.setHora(rs.getTime("hora"));
					r.setDetalle(rs.getString("detalle"));
					r.setEstado(rs.getString("estado"));
					res.add(r);
						
				}
			}
			
		} catch (SQLException e ){
			//throw e;
		} catch (ApplicationException ade){
			throw ade;
		} try {
			if(rs!=null) rs.close();
			if (stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e){
				e.printStackTrace();
			}
			return res;
		
	} 

   public void add (Reserva r) throws Exception{
    	PreparedStatement stmt=null;
    	ResultSet keyResultSet=null;
    	try{ stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
				"insert into reserva(id_el, id_te, fecha, hora, detalle, estado, id_per) " +
				 "values (?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
    		  stmt.setInt(1,r.getElemento().getId_El());
    		  stmt.setInt(2,r.getElemento().getTipoElemento().getId_TE());
    		  stmt.setDate(3,r.getFecha()); 
    		  stmt.setTime(4,r.getHora());
    		  stmt.setString(5,r.getDetalle());
    		  stmt.setString(6, r.getEstado());
    		  stmt.setInt(7,r.getPersona().getId_per());
    		  
    		  stmt.executeUpdate();
    		  keyResultSet=stmt.getGeneratedKeys();
    		  if (keyResultSet!=null && keyResultSet.next()){
    			  r.setId_res(keyResultSet.getInt(1));
    		  }
    		
    	} catch (SQLException | ApplicationException e){
    		throw e;
    	}try { 
    			if (keyResultSet!=null)keyResultSet.close();
    			if (stmt!=null)stmt.close();
    			FactoryConexion.getInstancia().releaseConn();
    	} catch (SQLException e ){
    		e.printStackTrace();
    	}
    } 
  

public ResultSet getResultSet() throws ApplicationException{	
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT id_res, id_el, id_te, fecha, hora, detalle, estado, id_per " +
					"FROM reserva  inner join elemento  on reserva.id_el=elemento.id_el where id_te=?");			
			rs = stmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			throw e;
		}

		return rs;
		
	}


public void update(Reserva r){
	//ResultSet rs=null;
	PreparedStatement stmt=null;	
	try {
		stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
				"UPDATE reserva SET id_el=?, id_te=?, fecha=?, hora=?, detalle=?, estado=? WHERE id_res=?");	
		
		 stmt.setInt(1,r.getElemento().getId_El());
		  stmt.setInt(2,r.getElemento().getTipoElemento().getId_TE());
		 // stmt.setString(3,r.getPersona().getDni());
		  stmt.setDate(3, (Date) r.getFecha());
		  stmt.setTime(4,(Time) r.getHora());
		  stmt.setString(5,r.getDetalle());
		  stmt.setString(6,r.getEstado());
		  stmt.setInt(7, r.getId_res());
		  
		  stmt.execute();
		
	} catch (SQLException e) {			
		e.printStackTrace();
	} catch (ApplicationException e) {			
		e.printStackTrace();
	}

}

public void delete(Reserva r){
	PreparedStatement stmt=null;		
	try {
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
				"delete from reserva where id_res=?");
		stmt.setInt(1,r.getId_res());
		stmt.execute();
	} catch (SQLException e) {			
		e.printStackTrace();
	} catch (ApplicationException e) {			
		e.printStackTrace();
	}
	
	
}
public int  validaDisponibilidad(Reserva re) throws ApplicationException{
	PreparedStatement stmt= null;
	ResultSet rs=null;
	ArrayList<Reserva> res = new ArrayList<Reserva>();
	int i=0;
	try{ 
	stmt= FactoryConexion.getInstancia().getConn().prepareStatement( "Select * from reserva r where (r.id_el=? and id_te=?) in"+
	"(select r.id_el from reserva where r.`fecha`=? and r.hora=?)");
		stmt.setInt(1,re.getElemento().getId_El());
		stmt.setInt(2,re.getElemento().getTipoElemento().getId_TE());
		stmt.setDate(3,re.getFecha());
		stmt.setTime(4,re.getHora());
		 
		 rs=stmt.executeQuery();
		 if (rs!= null ){
			while(rs.next()){
					i=1;
			}
		}
		
	} catch (SQLException e ){
		//throw e;
	} catch (ApplicationException ade){
		throw ade;
	} try {
		if(rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return (i);
		
	
} }
