package trabalhotpa;

import java.util.ArrayList;

public class Turma {
	private String nome;
	private String codigoDisciplina;
	private ArrayList<Aluno> alunosInscritos;
	private Professor professor;
	private Avaliacao avaliacao;
	private Disciplina disciplina;

	public Turma(String nome, Professor professor, String codigoDisciplina) {
		this.nome = nome;
		this.professor = professor;
		this.codigoDisciplina = codigoDisciplina;
		alunosInscritos = new ArrayList<>();
	}

	public Turma(String nome, String codigoDisciplina) {
		this.nome = nome;
		this.professor = null;
		this.codigoDisciplina = codigoDisciplina;
		alunosInscritos = new ArrayList<>();
	}

	public boolean addAluno(Aluno aluno) {
		if (alunosInscritos.add(aluno))
			return true;
		else
			return false;
	}

	public void removerAluno(String matricula) {
		for (Aluno item : alunosInscritos) {
			if (item.getMatricula() == matricula) {
				alunosInscritos.remove(item);
			}
		}
	}

	public ArrayList<Aluno> getAlunos(){
			return alunosInscritos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Professor getProfessor() {
		return professor;
	}
}
