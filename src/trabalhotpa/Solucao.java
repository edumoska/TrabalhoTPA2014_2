package trabalhotpa;

import java.util.ArrayList;
import java.util.List;

public class Solucao {
	
	/**
	 * Lista dos resultados de um avaliação
	 * 
	 * Cada resultado representa um exame, no qual está associado a mesma
         * turma.
	 * 
	 */
	private ArrayList<Resultado> resultados;
	
	/**
	 * Avaliacao do aluno na qual se refere essa solução
	 */
	private Avaliacao a;
        
        /**
         * Lista do nome de todos os exames. o Exame na ordem i se refere
         * ao resultado na ordem i em resultados
         */
        private List<String> exames;
        
	/**
	 * identificador de uma Solucao
	 */
	private int codigo;
        
        /**
         *  Gerador de código para cada Solucao criada
         */
        private static int geradorCodigo;
	
        // inicializa o gerador com o codigo do primeiro objeto criado
        static {
            
            geradorCodigo = 0;
        
        }
	
	public Solucao(Avaliacao a)
	{
		this.a = a;
                
                exames = a.getExames();
                
                // tamanho de resultados o mesmo que exames
		this.resultados = new ArrayList<>(a.getExames().size());
                codigo = geradorCodigo++;
	}
        
        /**
         * Dados o nome do exame pega o resultado correspondente
         */
        public Resultado getResultado(String exameNome)
        {
            Resultado r = null;
            
            
            for (int i = 0; i < exames.size(); i++)
            {
                if (exames.get(i).equalsIgnoreCase(exameNome))
                {
                    return resultados.get(i);
                }
            }
            
            return r;
        }
        
        /**
         * Retorna o código da Solucao
         */
        public int getCodigo()
        {
            return codigo;
        }
	
	/**
	 * Insere uma Avaliacao na solucao do aluno
	 */
	public void setAvaliacao(Avaliacao a)
	{
		this.a = a;
        }
        
        /**
         * Adiciona um documento a lista de resultados
         * 
         * @param t
         * @param caminho
         * @return 
         */
        public boolean addDocumento(Trabalho t, String caminho)
        {
            return resultados.add(new Documento(t, caminho, this));
        }
        
        /**
         * Retorna uma lista de todos os resultados
         */
        public List<Resultado> getResultados()
        {
            ArrayList<Resultado> r = new ArrayList<>(resultados.size());
            
            for (Resultado t: resultados)
            {
                r.add(t);
            }
            
            return r;
        }
        
        /**
         * Adiciona uma resposta a lista de resultados da solução
         * @param q
         * @return 
         */
        public boolean addResposta(Questao q)
        {
            return resultados.add(new Resposta(q, this));
        }
        
        /**
         * Retorna todos os Trabalhos da Solucao
         * 
         * @return
         */
        public List<Resultado> getDocumentos()
        {
            ArrayList<Resultado> documentos = new ArrayList<>();
            
            for (Resultado r: resultados)
            {
                if (r.getTipo().equalsIgnoreCase("documento"))
                    documentos.add(r);
            }
            
            return documentos;
        }
        
        /**
         * Retornas todas as respostas do documento
         */
        public List<Resultado> getRespostas()
        {
            ArrayList<Resultado> respostas = new ArrayList<>();
            
            for (Resultado r: resultados)
            {
                if (r.getTipo().equalsIgnoreCase("resposta"))
                    respostas.add(r);
            }
            
            return respostas;
        }
        
        /**
         * Somatorio da nota dada pelo professor em cada um dos seus resultados
         * 
         * @return double O total da nota
         */
        public double calcularNota()
        {
            double total = 0.0;
            
            for (Resultado r: resultados)
                total += r.getNota();
            
            return total;
        }
        
        public boolean removeResultado(Resultado r)
        {
            exames.remove(resultados.indexOf(r));
            return resultados.remove(r);
        }
}