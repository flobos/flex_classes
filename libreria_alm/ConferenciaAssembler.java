package libreria_alm;


import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Map;

import flex.data.DataSyncException;
import flex.data.assemblers.AbstractAssembler;


public class ConferenciaAssembler extends AbstractAssembler {

public Collection fill(List fillArgs) {
	frm_conferencias_alumno dao = new frm_conferencias_alumno();
	if (fillArgs == null || fillArgs.size() == 0) {
		return dao.getConferencias(); 
		}
	else{
		return dao.getConferenciasPARAM((String) fillArgs.get(0), (String) fillArgs.get(1));
	}
}



	public void createItem(libreria_alm.obj_trece_campos item) {
		frm_conferencias_alumno dao = new frm_conferencias_alumno();
	dao.create((libreria_alm.obj_trece_campos) item);
	}
	
	
	
	public void updateItem(Object newVersion, Object prevVersion, List changes) {
	libreria_alm.obj_trece_campos aux = (libreria_alm.obj_trece_campos) newVersion;
	
	frm_conferencias_alumno dao = new frm_conferencias_alumno();
	boolean success = dao.update((libreria_alm.obj_trece_campos) newVersion, (libreria_alm.obj_trece_campos) prevVersion,
	changes);
	if (!success) {
	String campo_uno = ((libreria_alm.obj_trece_campos) newVersion).getcampo_uno();
	throw new DataSyncException(dao.getConferencia(campo_uno), changes);
	}
	}
	
	public void deleteItem(Object item) {
		frm_conferencias_alumno dao = new frm_conferencias_alumno();
	boolean success = dao.delete((libreria_alm.obj_ocho_campos) item);
	if (!success) {
	String campo_uno = ((libreria_alm.obj_ocho_campos) item).getcampo_uno();
	throw new DataSyncException(dao.getConferencia(campo_uno), null);
	}
	}

}