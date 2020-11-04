package br.com.exeplo.util;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	public static Connection getConection() throws Exception {
		//metodo getConnection - não ira tratar erros 
		try {
		//indica o DB mysql e aponta para o driver 
		Class.forName("com.mysql.jdbc.Driver");
		//conexão com DB
		String login = "root";
		String senha = "";
		String url = "jdbc:mysql://localhost:3306/dbleitor";
		return DriverManager.getConnection(url,login,senha);	
		//JOptionPane.showMessageDialog(null, "");
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
		public static void main(String[] args) {
			try {
			Connection conn = ConnectionFactory.getConection();
			JOptionPane.showMessageDialog(null, "DB Conectado");
			}catch(Exception e) {
				e.printStackTrace();
			
		}
	}
}
