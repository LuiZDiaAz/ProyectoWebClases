package com.Rodrigo.Negocio;

import com.Rodrigo.DAO.ClsLoguinDao;
import com.Rodrigo.Entidades.*;

public class clsLoguin {

	
	public int acceso(usuario log) {
		int acceso = 0;
		/*if(log.getUser().equals("Luis") && log.getPass().equals("123")) {
			acceso = 1;
			
		}
		else {
			
		}*/
		
		ClsLoguinDao loginDao = new ClsLoguinDao();
		usuario usu = new usuario();
		
		usu=loginDao.Loguin(log);
		if(usu!=null) {
			if(usu.getId()==1) {
				acceso = 1;
			}else if(usu.getId()==2){
				acceso= 2;
			}
			System.out.println("Usuario encontrado... Bienvenido: " + usu.getUsuario());
		}else {
			System.out.println("Usuario vacio");
		}
		return acceso;
	}
}
