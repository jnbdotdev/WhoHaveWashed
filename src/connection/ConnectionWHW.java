package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import whwnit.WhWNIT;

public class ConnectionWHW {

	public Statement stm;
	public ResultSet rs;
	private String driver = "com.mysql.jdbc.Driver";
	private String caminho = "jdbc:mysql://localhost:3306/WhoHaveWashed?useSSL=false";
	private String usuario = "root";
	private String senha = "root";
	public Connection con;
	
	public void conexao() {		
		System.setProperty("jdbc.Drivers", driver);
		try {
			con = DriverManager.getConnection(caminho, usuario, senha);
			System.out.println("Success");
		}catch(SQLException ex) {
			Logger.getLogger(WhWNIT.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao se conectar com o Banco de Dados:\n"+ex.getMessage());
		}
	}
	public void desconecta() {
		try {
			con.close();
			JOptionPane.showMessageDialog(null, "Desconectado com Sucesso");
		}catch(SQLException ex) {
			Logger.getLogger(WhWNIT.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao se desconectar com o Banco de Dados:\n"+ex.getMessage());
		}
	}
	@SuppressWarnings("static-access")
	public void executaSQL(String sql) {
		try {
			stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			stm.execute(sql);
			rs = stm.executeQuery(sql);
		} catch(SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Executar SQL:\n"+ex.getMessage());
		}
	}
	public static Connection receberConexao() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WhoHaveWashed?useSSL=false","root","root");
			System.out.println("Banco de Dados conectado com sucesso");
		} catch (SQLException e) {
			System.err.println("Nao foi possivel conectar ao banco de dados");
			e.printStackTrace();
		}
					
		return con;
	}
	public static void closeConnection(Connection con) {
		
		try {
			if (con != null) {
			con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
	closeConnection(con);
	try {
		if(stmt != null) {
			stmt.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con, stmt);
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
	}
}
	
}
