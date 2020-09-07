package br.com.helio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.helio.enums.PerfilUsuarioEnum;
import br.com.helio.enums.StatusUsuarioEnum;
import br.com.helio.jdbc.ConnectionFactory;
import br.com.helio.model.Usuario;

public class UsuarioDAO {
	private Connection connection;

	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}

	public void adicionaUsuario(Usuario usuario) {
		String sql = 
				"INSERT INTO usuarios (nome,email,dataNascimento,status,dataInclusao,dataModificacao,motivoAlteracao,"
				+ "senha,perfil) values (?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			
			if (usuario.getDataNascimento() == null)
				pstmt.setDate(3, null);
			else
				pstmt.setDate(3, new Date(usuario.getDataNascimento().getTimeInMillis()));
			
			pstmt.setString(4, StatusUsuarioEnum.BLOQUEADO.getStatusUsuario());
			//pstmt.setDate(5, new Date(Calendar.getInstance().getTimeInMillis()));
			pstmt.setTimestamp(5, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			pstmt.setDate(6, null);
			pstmt.setString(7, null);
			pstmt.setString(8, usuario.getSenha());
			pstmt.setString(9, usuario.getPerfil());
			
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Usuario> getListUsers() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios";
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getNString("nome"));
				
				if (rs.getString("email") == null)
					usuario.setEmail("");
				else
					usuario.setEmail(rs.getString("email"));
				
				Calendar data = null;
				if (rs.getDate("dataNascimento") == null) {
					usuario.setDataNascimento(null);
				} else {
					data = Calendar.getInstance();
					data.setTime(rs.getDate("dataNascimento"));
					usuario.setDataNascimento(data);
				}
				
				usuario.setStatus(rs.getString("status"));
				
				data = Calendar.getInstance();
				data.setTime(rs.getTimestamp("dataInclusao"));
				usuario.setDataInclusao(data);
				
				if (rs.getTimestamp("dataModificacao") == null) {
					usuario.setDataModificacao(null);
				} else {
					data = Calendar.getInstance();
					data.setTime(rs.getTimestamp("dataModificacao"));
					usuario.setDataModificacao(data);
				}
				
				if (rs.getString("motivoAlteracao") == null)
					usuario.setMotivoAlteracao(null);
				else
					usuario.setMotivoAlteracao(rs.getString("motivoAlteracao"));
				
				if (rs.getString("senha") == null)
					usuario.setSenha(null);
				else
					usuario.setSenha(rs.getString("senha"));
				
				if (rs.getString("perfil") == null)
					usuario.setPerfil(null);
				else
					usuario.setPerfil(rs.getString("perfil"));
				
				usuarios.add(usuario);
			}
			
			rs.close();
			pstmt.close();
			return usuarios;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void removeUser(Long id) {
		String sql = "DELETE FROM usuarios WHERE id = ?";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(sql);
			pstmt.setLong(1, id);
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public Usuario getUserById(Long id) {
		String sql = "SELECT * FROM usuarios WHERE id = ?";
		
		try {
			Usuario usuario = null;
			PreparedStatement pstmt = this.connection.prepareStatement(sql);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				
				Calendar data = null;
				if (rs.getDate("dataNascimento") == null) {
					usuario.setDataNascimento(null);
				} else {
					data = Calendar.getInstance();
					data.setTime(rs.getDate("dataNascimento"));
					usuario.setDataNascimento(data);
				}
				
				usuario.setStatus(rs.getString("status"));
				
				data = Calendar.getInstance();
				data.setTime(rs.getTimestamp("dataInclusao"));
				//data.setTime(rs.getDate("dataInclusao"));
				usuario.setDataInclusao(data);
				
				if (rs.getTimestamp("dataModificacao") == null) {
					usuario.setDataModificacao(null);
				} else {
					data = Calendar.getInstance();
					data.setTime(rs.getTimestamp("dataModificacao"));
					usuario.setDataModificacao(data);
				}
				
				if (rs.getString("motivoAlteracao") == null)
					usuario.setMotivoAlteracao(null);
				else
					usuario.setMotivoAlteracao(rs.getString("motivoAlteracao"));
				
				if (rs.getString("senha") == null)
					usuario.setSenha(null);
				else
					usuario.setSenha(rs.getString("senha"));
				
				if (rs.getString("perfil") == null)
					usuario.setPerfil(null);
				else
					usuario.setPerfil(rs.getString("perfil"));
			}
			
			rs.close();
			pstmt.close();
			
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alteraStatusUsuario(String statusUsuario, Long id) {
		String sql = "UPDATE usuarios SET status = ?, dataModificacao = ?, motivoAlteracao = ? WHERE id = ?";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(sql);
			pstmt.setString(1, statusUsuario);
			//pstmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			pstmt.setTimestamp(2, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			
			if (statusUsuario.equals(StatusUsuarioEnum.ATIVO.getStatusUsuario())) 
				pstmt.setString(3, "Ativação do Usuário");
			else if (statusUsuario.equals(StatusUsuarioEnum.BLOQUEADO.getStatusUsuario()))
				pstmt.setString(3, "Bloqueio do Usuário");
			else
				pstmt.setString(3, "Inativação do Usuário");
			
			pstmt.setLong(4, id);
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alteraDadosUsuario(Usuario usuario) {
		String sql = "UPDATE usuarios SET nome = ?, email = ?, dataNascimento = ?, dataModificacao = ?, motivoAlteracao = ? "
				+ " WHERE id = ?";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(sql);
			//6 parametros
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			
			if (usuario.getDataNascimento() == null)
				pstmt.setDate(3, null);
			else
				pstmt.setDate(3, new Date(usuario.getDataNascimento().getTimeInMillis()));
			
			//pstmt.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
			pstmt.setTimestamp(4, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			
			pstmt.setString(5, usuario.getMotivoAlteracao());
			pstmt.setLong(6, usuario.getId());
			
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Usuario getUserByNameAndPassword(String nome, String senha) {
		String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ? AND status = ? AND perfil = ?";
		
		try {
			Usuario usuario = null;
			PreparedStatement pstmt = this.connection.prepareStatement(sql);
			pstmt.setString(1, nome);
			pstmt.setString(2, senha);
			pstmt.setString(3, StatusUsuarioEnum.ATIVO.getStatusUsuario());
			pstmt.setString(4, PerfilUsuarioEnum.ADMINISTRADOR.getPerfilUsuario());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				
				Calendar data = null;
				if (rs.getDate("dataNascimento") == null) {
					usuario.setDataNascimento(null);
				} else {
					data = Calendar.getInstance();
					data.setTime(rs.getDate("dataNascimento"));
					usuario.setDataNascimento(data);
				}
				
				usuario.setStatus(rs.getString("status"));
				
				data = Calendar.getInstance();
				data.setTime(rs.getTimestamp("dataInclusao"));
				usuario.setDataInclusao(data);
				
				if (rs.getTimestamp("dataModificacao") == null) {
					usuario.setDataModificacao(null);
				} else {
					data = Calendar.getInstance();
					data.setTime(rs.getTimestamp("dataModificacao"));
					usuario.setDataModificacao(data);
				}
				
				if (rs.getString("motivoAlteracao") == null)
					usuario.setMotivoAlteracao(null);
				else
					usuario.setMotivoAlteracao(rs.getNString("motivoAlteracao"));
				
				if (rs.getString("senha") == null)
					usuario.setSenha(null);
				else
					usuario.setSenha(rs.getString("senha"));
				
				if (rs.getString("perfil") == null)
					usuario.setPerfil(null);
				else
					usuario.setPerfil(rs.getString("perfil"));
			}
			rs.close();
			pstmt.close();
			
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alteraSenhaUsuario(Long id, String senha) {
		String sql = "UPDATE usuarios SET senha = ?, dataModificacao = ?, motivoAlteracao = ? WHERE id = ?";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(sql);
			pstmt.setString(1, senha);
			//pstmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			pstmt.setTimestamp(2, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			pstmt.setString(3, "Alteração de Senha");
			pstmt.setLong(4, id);
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alteraPerfilUsuario(Long id, String perfil) {
		String sql = "UPDATE usuarios SET perfil = ?, dataModificacao = ?, motivoAlteracao = ? WHERE id = ?";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(sql);
			pstmt.setString(1, perfil);
			//pstmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			pstmt.setTimestamp(2, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			pstmt.setString(3, "Alteração de Perfil");
			pstmt.setLong(4, id);
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}