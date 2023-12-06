package br.org.sesisp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import br.org.sesisp.controller.conexao;
import br.org.sesisp.model.aluno;

public class CrudDAO {
	
	//CRUD C-Create R - Read U - Update D - Delete
	
	//CREATE (inserir dados)
		public void create(br.org.sesisp.model.aluno aluno) {
			String sql = "INSERT INTO alunos(nome, idade) VALUES (?, ?)";
			Connection conn = null;
			PreparedStatement p = null;
			try {
				conn = conexao.criandoConexao();
				p = (PreparedStatement) conn.prepareStatement(sql);//cast
				p.setString(1, aluno.getNome());
				p.setInt(2, aluno.getIdade());
				p.execute();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "erro ao inserir dados!! \nERRO " + e);
			}finally {
				try {
					if (p != null);
				}catch(Exception e) {
					e.printStackTrace();
			}
			}
	}//fim CREATE
		//*****************
		
		//método update
		public void update(br.org.sesisp.model.aluno aluno) {
			String sql = "UPDATE alunos SET nome = ?; idade = ? WHERE ra = ?"; //atualizo o nome e a idade quando o ra for...
			Connection conn = null;
			PreparedStatement p = null;//link com banco
			try {
				conn = conexao.criandoConexao();
				p = (PreparedStatement) conn.prepareStatement(sql);//cast
				p.setString(1, aluno.getNome());
				p.setInt(2, aluno.getIdade());
				p.setInt(3, aluno.getRa());
				p.execute();//grava dados no banco 
				JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
				System.out.println("Dados atualizados com sucesso");
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
			}
			}
			
//fim classe CRUD
// R - Read
public List <aluno> read(){
	String sql = "SELECT * FROM alunos";
	List<aluno> alunos = new ArrayList<aluno>();
	Connection conn = null;
	PreparedStatement p = null;
	ResultSet resultado = null;
	
	try {
		conn = conexao.criandoConexao();
		p = (PreparedStatement) conn.prepareStatement(sql);//cast
		resultado = p.executeQuery();
				while(resultado.next()) {
					aluno ver_aluno = new aluno();
					ver_aluno.setRa(resultado.getInt("ra"));
					ver_aluno.setNome(resultado.getString("nome"));
					ver_aluno.setIdade(resultado.getInt("idade"));
					alunos.add(ver_aluno);
				}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if (p != null);
		}catch(Exception e) {
			e.printStackTrace();
	}
	}
	return alunos;
	}
	//D - Delete
	public boolean delete (int ra ) {
		String sql = "DELETE FROM alunos WHERE ra = ?";
			Connection conn = null;
			PreparedStatement p = null;
			try {
				conn = conexao.criandoConexao();
				p = (PreparedStatement) conn.prepareStatement(sql);//cast
				p.setInt(1, ra);
				p.execute();
				JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
				System.out.println("Dados excluidos com sucesso");
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir dados");
			}finally {
				try {
					if (p != null);
				}catch(Exception e) {
					e.printStackTrace();
			}
	}
			return false;
	}
}

