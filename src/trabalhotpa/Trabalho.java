package trabalhotpa;

public class Trabalho extends Exame {
	private String enunciado;

	public Trabalho(String codigoDisciplina, String nomeTurma,
			String nomeExame, int tipo) {
		super(codigoDisciplina, nomeTurma, nomeExame, tipo);
	}

	public Trabalho(String codigoDisciplina, String nomeTurma,
			String nomeExame, int tipo, int codigoTemplate) {
		super(codigoDisciplina, nomeTurma, nomeExame, tipo, codigoTemplate);
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public int getNumeroDeQuestoes() {
		return 1;
	}
}