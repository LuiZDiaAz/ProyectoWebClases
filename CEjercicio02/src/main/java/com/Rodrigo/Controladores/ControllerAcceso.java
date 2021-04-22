package com.Rodrigo.Controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rodrigo.DAO.ClsUsuario;
import com.Rodrigo.Entidades.Loguin;
import com.Rodrigo.Entidades.usuario;
import com.Rodrigo.Negocio.clsLoguin;

/**
 * Servlet implementation class ControllerAcceso
 */
@WebServlet("/ControllerAcceso")
public class ControllerAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerAcceso() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		usuario log = new usuario();
		clsLoguin clsL = new clsLoguin();

		log.setUsuario(user);
		log.setPassword(pass);

		int valoracceso = clsL.acceso(log);

		if (valoracceso == 1) {
			System.out.println("Welcome" + user);
			ClsUsuario usuarioDao = new ClsUsuario();
			ArrayList<usuario> Listado = new ArrayList<usuario>();

			for (var iterar : usuarioDao.TraerUsuario()) {
				System.out.println(iterar.getUsuario());
				usuario usu = new usuario();
				usu.setIdUsuario(iterar.getIdUsuario);
				usu.setUsuario(iterar.getUsuario());
				usu.setPassword(iterar.getPassword());
				usu.setId(iterar.getTipoUsuario());
				Listado.add(usu);
			}
			request.setAttribute("usuarios", Listado);
			getServletContext().getRequestDispatcher("/Saludo.jsp").forward(request, response);
		}else if(valoracceso == 2){
			System.out.println("Usuario Normal");
			response.sendRedirect("standard.jsp");
		} else {
			response.sendRedirect("Error.jsp");
		}

	}
}
