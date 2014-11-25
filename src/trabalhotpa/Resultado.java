package trabalhotpa;


public abstract class Resultado {
	
        /**
	 * Nota dada pelo professor
	 */
	protected float nota;
        
        /**
         * Solucao do resultado
         */
        private Solucao solucao;
        
        /**
         * Tipo do resultado
         */
        private String tipo;
        
        /**
         * Comentario sobre resultado de uma prova ou documento de trabalho
         */
        private String comentario;
        
        Resultado(String tipo, Solucao solucao)
        {
            this.tipo = tipo;
            this.solucao = solucao;
            comentario = null;
        }
        
        public String getComentario()
        {
            return comentario;
        }
        
        public void setComentario(String comentario)
        {
            this.comentario = comentario;
        }
        public String getTipo()
        {
            return tipo;
            
        }
        
	public float getNota()
	{
		return nota;
	}
	
	public void setNota(float nota)
	{
		this.nota = nota;
	}
        
        public Solucao getSolucao()
        {
            return solucao;
        }
        
        public void setSolucao(Solucao s)
        {
            solucao = s;
        }
}
