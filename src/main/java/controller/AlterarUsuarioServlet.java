package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioDAO;

@WebServlet("/editar")
public class AlterarUsuarioServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idUsuario = Integer.parseInt(req.getParameter("id"));
		UsuarioDAO udao = new UsuarioDAO();
		Usuario usuarioSelecionado = udao.getUsuarioById(idUsuario);

		req.setAttribute("usuario", usuarioSelecionado);
	
		RequestDispatcher rd = req.getRequestDispatcher("/alterarUsuario.jsp");
        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuarioAlterado = new Usuario();		
		usuarioAlterado.setNOME_U(req.getParameter("nome"));
		usuarioAlterado.setEMAIL_U(req.getParameter("email"));
		usuarioAlterado.setSENHA_U(req.getParameter("senha"));
		usuarioAlterado.setID_USUARIO(Integer.parseInt(req.getParameter("id")));
		
		UsuarioDAO cd = new UsuarioDAO();
		cd.update(usuarioAlterado);	
		resp.sendRedirect("home");
	}

}
