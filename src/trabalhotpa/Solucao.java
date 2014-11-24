package trabalhotpa;

import java.util.ArrayList;

public class Solucao {
	
	/**
	 * Ajuda na geração de um código de solução
	 */
	private static int geradorID = 0;
	
	/**
	 * Lista dos resultados de um avaliação
	 * 
	 * Um resultado pode ser um conjunto de Documento que representa
	 * um trabalho e/ou conjunto de resposta de questões de uma prova
	 */
	ArrayList<Resultado> r;
	
	/**
	 * Avaliacao do aluno na qual se refere essa solução
	 */
	Avaliacao a;
	
	/**
	 * Código que identifica uma Solucao
	 */
	int codigo;
	
	public Solucao(Avaliacao a)
	{
		Solucao(a, null);
	}
	
	public Solucao(Avaliacao a, ArrayList<Resultado> r)
	{
		this.a = a;
		this.r = r;
		codigo = geradorID++;
	}
	
	/**
	 * Cria um Objeto Resultado dependendo do tipo
	 */
	public Resultado createResultado(String tipo)
	{
		switch (tipo)
		{
			case tipo.equalsIgnoreCase("resultado"):
			
			break;
			
			case tipo.equalsIgnoreCase("Documento"):
			
			break;
			
			default: return null;
			
		}
	}
	
	/**
	 * Retorna uma lista de todos os trabalhos de uma solução
	 */
	public ArrayList<Documento> getDocumentos()
	{
		ArrayList<Documento> docs = new ArrayList<Documento>();
		
		for (Resultado t: r)
		{
			if (t instanceof Trabalho)
				docs.add(t);
		}
		
		return docs;
	}
	
	/**
	 * Insere uma Avaliacao na solucao do aluno
	 */
	public void setAvaliacao(Avaliacao a)
	{
		this.a = a;
	}
	
	/**
	 * Adiciona um documento de um trabalho junto com o caminhode onde está
	 * o documento
	 */
	public void addDocumento(Trabalho t, String caminho)
	{
		Document doc = new Document(t, caminho);
		this.r.add(doc);
	}
	
	public void inserirNotaDocumento()
	{
		
	}
	
	public void addResposta()
	{
		Reposta r = new Reposta();
	}
	
	public void removeResultado(Resultado r)
	{
		this.r.remove(r);
	}
	
    
    // retorna o comentário do resultado de um trabalho
    public String visualizarResultadoDocumento(String codigoDisciplina, String codigoTurma, String nomeExame){
		
		List<Exame> exames = a.getExames();
		
		for(Exame e: exames)
		{
			if (e.getCodigoDisciplina() == codigoDisciplina && e.getCodigoTurma() == codigoTurma && nomeExame == e.getNomeExame())
				return 
		}
		
		return null;
	}
}
