package br.com.educamt.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import br.com.educamt.model.Aluno;

@Named("alunoService")
public class AlunoService {

	public List<Aluno> listarAlunosPorResponsavel(Integer idResponsavel) {

		List<Aluno> listaAlunos = new ArrayList<>();

		try {

			Class.forName("org.postgresql.Driver");

			Connection connection = null;
			PreparedStatement preparedStatement = null;

			connection = DriverManager.getConnection("jdbc:postgresql://govhack.cpghth3efxd9.sa-east-1.rds.amazonaws.com:5432/govhack", "govhack", "govhackmt10");

			String selectSQL = "select a.id_aluno, a.ds_aluno, a.data_nascimento, a.contato1 from aluno a inner join rl_responsavel_aluno rla on a.id_aluno = rla.id_aluno inner join responsavel_aluno resp on rla.id_responsavel_aluno = resp.id_responsavel_aluno where resp.id_responsavel_aluno =  ?";
			
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idResponsavel);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Aluno aluno = new Aluno();

				aluno.setIdAluno(rs.getInt("id_aluno"));
				aluno.setNome(rs.getString("ds_aluno"));
				aluno.setDataNascimento(rs.getDate("data_nascimento"));
				aluno.setContato(rs.getString("contato1"));

				listaAlunos.add(aluno);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return listaAlunos;
	}

	public List<Aluno> listarTodosAlunos() {

		List<Aluno> listaAlunos = new ArrayList<>();

		try {

			Class.forName("org.postgresql.Driver");

			Connection connection = null;
			PreparedStatement preparedStatement = null;

			connection = DriverManager.getConnection(
					"jdbc:postgresql://govhack.cpghth3efxd9.sa-east-1.rds.amazonaws.com:5432/govhack", "govhack",
					"govhackmt10");

			String selectSQL = "SELECT * FROM aluno";
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Aluno aluno = new Aluno();

				aluno.setIdAluno(rs.getInt("id_aluno"));
				aluno.setNome(rs.getString("ds_aluno"));
				aluno.setDataNascimento(rs.getDate("data_nascimento"));
				aluno.setContato(rs.getString("contato1"));

				listaAlunos.add(aluno);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return listaAlunos;
	}

}