package com.Rodrigo.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.Rodrigo.Conexion.ConexionBd;
import com.Rodrigo.Entidades.usuario;

public class ClsLoguinDao {
	ConexionBd cn = new ConexionBd();
	Connection con = cn.RetornarConexion();
	public usuario Loguin(usuario user) {
		usuario usu = new usuario();
		try {
			CallableStatement statement = con.prepareCall("call sp_s_Login(?,?);");
			statement.setString("pUsuario", user.getUsuario());
			statement.setString("pPass", user.getPassword());
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				usu.setIdUsuario(res.getInt("idUsuario"));
				usu.setUsuario(res.getString("Usuario"));
				usu.setPassword(res.getString("Password"));
				usu.setId(res.getInt("tipoUsuario"));
			}
			
		}catch (Exception e) {
			System.out.println("No se encontro el usuario" + e);
		}
		return usu;
	}
}
