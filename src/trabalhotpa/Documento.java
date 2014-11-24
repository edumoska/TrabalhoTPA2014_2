package trabalhotpa;

import java.util.Date;

public class Documento extends Resultado {
	
	/**
	 * O trabalho a que se refere o Documento
	 */	
	private Trabalho t;
	
	/**
	 * Comentario sobre o resultado do trabalho, dado por um professor
	 */
	private String comentario;
	
	/**
	 * Texto que representa o documento do aluno de um trabalho
	 */
	private String doc;
	
	/**
	 * Data de entrega do trabalho
	 */
	private Date dataEntrega;
	
	public Documento(Trabalho t, String doc)
	{
		this.t = t;
		this.caminho = caminho;
		this.comentario = comentario;
		this.doc = doc;
	}
	
	public Trabalho getTrabalho()
	{
		return trabalho;
	}
	
	public void setTrabalho(Trabalho t)
	{
		this.t = t;
	}
	
	/**
	 * Retorna o Documento que representa o arquivo 
	 */
	public String getDoc()
	{
		return doc;
	}
	
	/**
	 * Insere um comentario do Resultado de um trabalho
	 */
	public void setComentario(String comentario)
	{
		this.comentario = comentario;
	}
	
	/**
	 * retorna o comentario do Resultado do Trabalho
	 */
	public String getComentario()
	{
		return comentario;
	}
}
