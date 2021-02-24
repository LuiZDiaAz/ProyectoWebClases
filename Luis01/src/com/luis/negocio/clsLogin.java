package com.luis.negocio;

import com.luis.entidades.Login;

public class clsLogin {
	
	public int acceso(Login log) {
		
		int acceso =0;
		if (log.getUser().equals("Luis") && log.getPass().equals("123"))
		{
		acceso =1;
		}
		
		return acceso;
	}
	
}
