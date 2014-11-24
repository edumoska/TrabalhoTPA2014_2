package trabalhotpa;

public abstract class Exame {
	private String nome;
	private String codigoDisciplina;
	private String nomeTurma;
	private int tipo;
	private int codigoTemplate;
	
	public abstract int getNumeroDeQuestoes();

	public Exame(String codigoDisciplina, String nomeTurma, String nomeExame,
			int tipo) {
		this.codigoDisciplina = codigoDisciplina;
		this.nomeTurma = nomeTurma;
		nome = nomeExame;
		this.tipo = tipo;
	}

	public Exame(String codigoDisciplina, String nomeTurma, String nomeExame,
			int tipo, int codigoTemplate) {
		this.codigoDisciplina = codigoDisciplina;
		this.nomeTurma = nomeTurma;
		nome = nomeExame;
		this.tipo = tipo;
		this.codigoTemplate = codigoTemplate;
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

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCodigoTemplate() {
		return codigoTemplate;
	}

	public void setCodigoTemplate(int codigoTemplate) {
		this.codigoTemplate = codigoTemplate;
	}
}
