package trabalhotpa;

public class Trabalho extends Exame {
	private String enunciado;

	public Trabalho(String nome,String enunciado) {
		super(nome);
		this.enunciado = enunciado;
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