package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioDAO;

@WebServlet("/home")
public class ListarUsuariosServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Usuario> lista = new ArrayList<Usuario>();
		UsuarioDAO udao = new UsuarioDAO();		
		lista = udao.getUsuarios();		
		req.setAttribute("listaUsuarios", lista);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cadastrou2.jsp");
		dispatcher.forward(req, resp);
	}

}