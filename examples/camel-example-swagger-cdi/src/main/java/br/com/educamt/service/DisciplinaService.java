package br.com.educamt.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import br.com.educamt.model.Disciplina;

@Named("disciplinaService")
public class DisciplinaService {

	public List<Disciplina> listarDisciplinasPorProfessor(Integer idProfessor){
		
		List<Disciplina> listaDisciplinas = new ArrayList<>();
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			connection = DriverManager.getConnection("jdbc:postgresql://govhack.cpghth3efxd9.sa-east-1.rds.amazonaws.com:5432/govhack","govhack", "govhackmt10");
			
			String selectSQL = "SELECT * FROM disciplina WHERE id_professor = ?";
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idProfessor);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				
				Disciplina disciplina = new Disciplina();
				
				disciplina.setIdDisciplina(rs.getInt("id_disciplina"));
				disciplina.setCodigo(rs.getString("cd_disciplina"));
				disciplina.setDescricaoDisciplina(rs.getString("ds_disciplina"));
				disciplina.setIdProfessor(rs.getInt("id_professor"));
				disciplina.setPeriodo(rs.getString("periodo"));
				disciplina.setDescricaoTurma(rs.getString("ds_turma"));
				disciplina.setIdTurma(rs.getInt("id_turma"));
				
				listaDisciplinas.add(disciplina);
				
			}
			
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return listaDisciplinas;
	}
	
}