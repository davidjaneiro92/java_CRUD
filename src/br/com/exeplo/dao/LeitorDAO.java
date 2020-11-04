package br.com.exeplo.dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import br.com.exemplo.model.Leitor;
import br.com.exeplo.util.ConnectionFactory;

public class LeitorDAO {
	
	private Leitor leitor;
	private java.sql.Connection conn;		//conect ao banco de dados 
	private java.sql.PreparedStatement ps;	//permite execultar querys
	private ResultSet rs;			//tabela

 	 public LeitorDAO() throws Exception {
 		 try {
 			conn = ConnectionFactory.getConection();
 		 }catch(Exception e) {
 			 throw new Exception("Erro ao conectar ao BD!! "+ e.getMessage());
 		 }
 		 
 	 }
 	 
 	 public void salvar(Leitor leitor) throws Exception {
 		 try {
  			String sql = "INSERT INTO tbleitor(codLeitor, nomeLeitor, tipoLeitor)"
  					+"values(?,?,?)";
  			ps = conn.prepareStatement(sql);
  			ps.setInt(1, leitor.getCodLeitoe());
  			ps.setString(2, leitor.getNomeLeitor());
  			ps.setString(3, leitor.getTipoLeitor());
  			ps.executeUpdate();
  					
  		 }catch(Exception e) {
  			 throw new Exception("Erro ao Salvar!!! "+ e.getMessage());
  			
  		 }
 	 }
 	 
 	public ArrayList<Leitor> listarTodos() throws Exception {
 		ArrayList<Leitor> lista = new ArrayList<Leitor>();
 		 try {
 			 ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM tbLeitor");
 			 rs = ps.executeQuery();
 			 while(rs.next()) {
 				 int codLeitor = rs.getInt("codLeitor");
 				 String nomeLeitor = rs.getString("nomeLeitor");
 				 String tipoLeitor = rs.getString("tipoLeitor");
 				 leitor = new Leitor(codLeitor, nomeLeitor, tipoLeitor);
 				 lista.add(leitor);
 			 }
 		 return lista;
 		 }catch(Exception e) {
  			 throw new Exception("Erro ao lista "+ e.getMessage());
  		 }
 	 }
 	 
 	 public Leitor consultar (int codLeitor) throws Exception {
  		 try {
  			 ps = conn.prepareStatement("SELECT * FROM tbLeitor WHERE codLeitor=?");
  			 ps.setInt(1, codLeitor);
  			 rs = ps.executeQuery();
  			 if(rs.next()) {
  				 String nomeLeitor = rs.getString("nomeLeitor");
  				 String tipoLeitor = rs.getString("tipoLeitor");
  				 leitor = new Leitor(codLeitor, nomeLeitor, tipoLeitor);
  				 
  			 }
  		 return leitor;
  		 
  		 }catch(Exception e) {
   			 throw new Exception("Erro ao Salvar "+ e.getMessage());
   		 }
  	 }
 		 public void alterar(Leitor leitor) throws Exception {
 	 		 try {
 	  			String sql = "UPDATE tbLeitor SET nomeLeitor=?, tipoLeitor=? "
 	  					+"WHERE codLeitor=?";
 	  			ps = conn.prepareStatement(sql);
 	  			ps.setString(1, leitor.getNomeLeitor());
 	  			ps.setString(2, leitor.getTipoLeitor());
 	  			ps.setInt(3, leitor.getCodLeitoe());
 	  			ps.executeUpdate();		
 	  		 }catch(Exception e) {
 	  		 throw new Exception("Erro ao altera "+ e.getMessage());
 	 	 }
 	 }
 		public void excluir(int codLeitor) throws Exception {
	 		 try {
	  			String sql = "DELETE FROM tbleitor "
	  					+"WHERE codLeitor=?";
	  			ps = conn.prepareStatement(sql);
	  			ps.setInt(1, codLeitor);
	  			ps.executeUpdate();	
	  		 }catch(Exception e) {
	  			 throw new Exception("Erro ao excluir "+ e.getMessage());
	  	}
	 }
}
