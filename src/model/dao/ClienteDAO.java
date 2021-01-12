package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.bean.Cliente;
import model.bean.Filme;


public class ClienteDAO {

		public void create(Cliente c) {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			try {
				stmt = con.prepareStatement("INSERT INTO CLIENTE (nome, email, idade) VALUES"
						+ "(?,?,?)");
				stmt.setString(1, c.getNome());
				stmt.setString(2, c.getEmail());
				stmt.setInt(3, c.getIdade());
				
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar: "+ e);
			}finally{
				ConnectionFactory.closeConnection(con, stmt);
			}
		}
		 public List<Cliente> read(){
			 Connection con = ConnectionFactory.getConnection();
			 PreparedStatement stmt = null;
			 ResultSet rs = null;
			 List<Cliente> clientes= new ArrayList<>();
			 
			 try {
			 stmt = con.prepareStatement("SELECT * FROM cliente;");
			 rs = stmt.executeQuery();
			 while(rs.next()) {
				 Cliente c = new Cliente();
				 c.setId_cliente(rs.getInt("id_cliente"));
				 c.setNome(rs.getString("nome"));
				 c.setEmail(rs.getString("email"));
				 c.setIdade(rs.getInt("idade"));
				
				clientes.add(c);
	 
			 }
			 
			 }catch(SQLException e) {
				 JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD "+ e);
				 e.printStackTrace();
			 }finally {
				 ConnectionFactory.closeConnection(con, stmt, rs);
			 }
			 return clientes;
		 }
		 
		  public Cliente read(int id_cliente) {
			  Connection con = ConnectionFactory.getConnection();
			  PreparedStatement stmt = null;
			  ResultSet rs = null;
			  Cliente c = new Cliente();
			  
			  try {
				stmt = con.prepareStatement("SELECT * FROM cliente WHERE id_cliente = ? LIMIT 1;");
		        stmt.setInt(1, id_cliente);
		        rs = stmt.executeQuery();
		        if(rs != null && rs.next())	{	
		             c.setId_cliente(rs.getInt("id_cliente"));
		        	 c.setNome(rs.getString("nome"));
		        	 c.setEmail(rs.getString("email"));
					 c.setIdade(rs.getInt("idade"));

		        }
			  
			  } catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConnection(con,stmt,rs);
			}
			  return c;
			  
		  } 
		 public void update(Cliente c) {
			  Connection con = ConnectionFactory.getConnection();
			  PreparedStatement stmt = null;
			  
			  try {
				stmt = con.prepareStatement("UPDATE cliente SET nome=?, email=?, idade=? WHERE id_cliente=?;");
			    stmt.setString(1, c.getNome());
			    stmt.setString(2, c.getEmail());
			    stmt.setInt(3, c.getIdade());
			    stmt.setInt(4, c.getId_cliente());
			    stmt.executeUpdate();
			    JOptionPane.showMessageDialog(null, "Cliente atualizado");
			  
			  } catch (SQLException e) {
				  JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e);
				
			}finally {
				ConnectionFactory.closeConnection(con, stmt);
			}  	  
			  
		  }
		  public void delete(Cliente c) {
			  Connection con = ConnectionFactory.getConnection();
			  PreparedStatement stmt = null;
			  
			  try {
				  stmt = con.prepareStatement("DELETE FROM cliente WHERE id_cliente = ? ");
				  stmt.setInt(1, c.getId_cliente());
				  stmt.executeUpdate();
				  JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
				  
			  } catch(SQLException e) {
				 JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ e);
			  }finally {
				  ConnectionFactory.closeConnection(con,stmt);
			  }
		  }
		
	

	}