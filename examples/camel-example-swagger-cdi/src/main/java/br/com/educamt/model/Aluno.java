package br.com.educamt.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Representa um aluno")
public class Aluno {

	private Integer idAluno;
	
	private String nome;
	
	private Date dataNascimento;
	
	private String contato;

	@ApiModelProperty(value = "O id do aluno", required = true)
	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	@ApiModelProperty(value = "O nome do aluno", required = true)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ApiModelProperty(value = "A data de nascimento do aluno", required = true)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@ApiModelProperty(value = "O contato do resposável pelo aluno", required = true)
	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
}
