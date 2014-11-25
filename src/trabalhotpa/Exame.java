package trabalhotpa;

public abstract class Exame {
	private String nome;
		
	public abstract int getNumeroDeQuestoes();
	
	public Exame(String nome){
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
