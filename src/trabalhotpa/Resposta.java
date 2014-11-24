package trabalhotpa;
import java.util.ArrayList;

public class Resposta extends Resultado {
	
	/**
	 * Questoes respondidas por um aluno de acordo com uma questao de prova
	 */
	private ArrayList<Questao> q;
	private ArrayList<String> q;
	private String opcao;
	
	public Resposta()
	{
		Resposta(null);
	}
	
	public Resposta(ArrayList<Questao> q)
	{
		this.q = q;
		nota<Float>(this.q.size());
	}
	
	public void setNota(int i, float nota)
	{
		notas.set(i, nota);
	}
	
	public float getNota(int i)
	{
		return notas.get(i);
	}
	
	/**
	 * Adiciona uma Questao de um resultado
	 */
	public void addQuestao(Questao q)
	{
		this.q.add<Questao>(q);
	}
	
}
