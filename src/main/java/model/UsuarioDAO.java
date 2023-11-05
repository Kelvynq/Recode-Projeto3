package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Usuario usuario) {
		// os ? são os parâmetros que nós vamos adicionar na base de dados
		String sql = "INSERT INTO usuario(NOME_U,EMAIL_U,SENHA_U)" + " VALUES(?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();
			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNOME_U());
			pstm.setString(2, usuario.getEMAIL_U());
			pstm.setString(3, usuario.getSENHA_U());
			// Executa a sql para inserção dos dados
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void removeById(int id) {
		String sql = "DELETE FROM usuario WHERE ID_USUARIO = ?";
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

 
	public void update(Usuario usuario) {
		String sql = "UPDATE usuario SET NOME_U = ?, EMAIL_U = ?, SENHA_U = ? " + " WHERE ID_USUARIO = ?";
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();
			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNOME_U());
			pstm.setString(2, usuario.getEMAIL_U());
			pstm.setString(3, usuario.getSENHA_U());
			pstm.setInt(4, usuario.getID_USUARIO() );
			// Executa a sql para inserção dos dados
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public List<Usuario> getUsuarios() {
		String sql = "SELECT * FROM usuario";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				Usuario usuario = new Usuario();
				usuario.setID_USUARIO(rset.getInt("ID_USUARIO"));
				usuario.setNOME_U(rset.getString("NOME_U"));
				usuario.setEMAIL_U(rset.getString("EMAIL_U"));
				usuario.setSENHA_U(rset.getString("SENHA_U"));
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuarios;
	}
 

	public Usuario getUsuarioById(int id) {
		String sql = "SELECT * FROM usuario where ID_USUARIO = ?";
		Usuario usuario = new Usuario();
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			usuario.setNOME_U(rset.getString("NOME_U"));
			usuario.setEMAIL_U(rset.getString("EMAIL_U"));
			usuario.setSENHA_U(rset.getString("SENHA_U"));
			usuario.setID_USUARIO(rset.getInt("ID_USUARIO"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}
}