package com.Rodrigo.Entidades;

public class Loguin {

	protected String User;
	protected String Pass;
	protected int TipoUser;
	
	public int getTipoUser() {
		return TipoUser;
	}
	public void setTipoUser(int tipoUser) {
		TipoUser = tipoUser;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	
}
