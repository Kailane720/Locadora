package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Filme;

public class FilmeDAO {

		public void create(Filme f) {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			try {
				stmt = con.prepareStatement("INSERT INTO FILME (titulo, tempo, imagem3d,dublado,sinopse,categoria ) VALUES"
						+ "(?,?,?,?,?,?)");
				stmt.setString(1, f.getTitulo());
				stmt.setInt(2, f.getTempo());
				stmt.setBoolean(3, f.isImagem3d());
				stmt.setBoolean(4, f.isDublado());
				stmt.setString(5, f.getSinopse());
				stmt.setString(6, f.getCategoria());
				
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Filme Salvo com sucesso!");
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
			}finally{
				ConnectionFactory.closeConnection(con, stmt);
			}
		}
	}


