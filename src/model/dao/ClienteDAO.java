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
		
	

	}