package br.com.educamt.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Representa uma disciplina")
public class Disciplina {

	private Integer idDisciplina;
	
	private String codigo;
	
	private String descricaoDisciplina;
	
	private Integer idProfessor;
	
	private String periodo;
	
	private Integer idTurma;
	
	private String descricaoTurma;

	@ApiModelProperty(value = "O id da disciplia", required = true)
	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	@ApiModelProperty(value = "O código da disciplia", required = true)
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@ApiModelProperty(value = "A descrição da disciplia", required = true)
	public String getDescricaoDisciplina() {
		return descricaoDisciplina;
	}

	public void setDescricaoDisciplina(String descricaoDisciplina) {
		this.descricaoDisciplina = descricaoDisciplina;
	}

	@ApiModelProperty(value = "O id de um professor que ministra a disciplia", required = true)
	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	@ApiModelProperty(value = "O período da disciplia", required = true)
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	@ApiModelProperty(value = "O  da disciplia", required = true)
	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	@ApiModelProperty(value = "A descrição da turma da disciplia", required = true)
	public String getDescricaoTurma() {
		return descricaoTurma;
	}

	public void setDescricaoTurma(String descricaoTurma) {
		this.descricaoTurma = descricaoTurma;
	}
	
}