package controlers;
import java.io.Serializable;
import java.util.ArrayList;
import data.DataTipoElemento;
import entity.TipoElemento;



public class CtrlABMCTipoElemento implements Serializable{
	
	private DataTipoElemento dataTipoEl;	
	private ArrayList<TipoElemento> tipoEl ;

	public CtrlABMCTipoElemento(){
		
		dataTipoEl = new DataTipoElemento();
		tipoEl = new ArrayList<TipoElemento>();		
	}

	public void add(TipoElemento te)throws Exception{
		dataTipoEl.add(te);
	}

	public void delete(TipoElemento te)throws Exception{
		dataTipoEl.delete(te);
	}
	
	public void update(TipoElemento te)throws Exception{
		dataTipoEl.update(te);
	}
	public ArrayList<TipoElemento> getAll() throws Exception {
		//return this.pers;
		return dataTipoEl.getAll();
		
	}

	public TipoElemento getByNombre(TipoElemento te)throws Exception {
		//return this.pers.get(this.pers.indexOf(p));
		return dataTipoEl.getByNombre(te);
	}
	
	public TipoElemento getByNombre(String nombre_TE) throws Exception {
		TipoElemento te= new TipoElemento();
		te.setNombre_TE(nombre_TE);
		System.out.println(te.getNombre_TE());
		return getByNombre(te);
	}
	

	
}
	

