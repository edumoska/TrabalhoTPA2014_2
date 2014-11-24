package trabalhotpa;


public abstract class Resultado {
	/**
	 * Nota dada pelo professor
	 */
	private float nota;
	
	/**
	 * Verifica se o resultado está correto
	 */
	protected boolean correto;
	
	public float getNota()
	{
		return nota;
	}
	
	public void setNota(float nota)
	{
		this.nota = nota;
	}
}
