package whwnit;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import connection.ConnectionWHW;
import whohavewashed.WhW;

public class WhWNIT {
	
	public void create(WhW w) {
		
		Connection con = ConnectionWHW.receberConexao();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO WhW (dia, pessoa, refeicao, louca, outros)VALUES(?,?,?,?,?)");
			stmt.setString(1, w.getDia());
			stmt.setString(2, w.getPessoa());
			stmt.setString(3, w.getRefeicao());
			stmt.setString(4, w.getLouca());
			stmt.setString(5, w.getOutros());
			
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			Logger.getLogger(WhWNIT.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}finally {
			ConnectionWHW.closeConnection(con, stmt);
		}
	}
	
	public ArrayList<WhW> mostrarTodos(){
		ArrayList<WhW> whw = new ArrayList<>();
		
		Connection con = ConnectionWHW.receberConexao();
		String sql = "SELECT * FROM WhW";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				WhW whwf = new WhW();
				whwf.setDia(rs.getString("dia"));
				whwf.setPessoa(rs.getString("pessoa"));
				whwf.setLouca(rs.getString("louca"));
				whwf.setRefeicao(rs.getString("refeicao"));
				whwf.setOutros(rs.getString("outros"));
				
				whw.add(whwf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return(whw);
	}
	public void excluirPorCodigo(int codigo) {
		Connection con = ConnectionWHW.receberConexao();
		
		String sql = "DELETE FROM WhW WHERE cod=?";
		
		try {
			PreparedStatement preparador =  con.prepareStatement(sql);
			preparador.setInt(1,codigo);
			
			preparador.execute();
			preparador.close();
			System.out.println("Excluído com Sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
