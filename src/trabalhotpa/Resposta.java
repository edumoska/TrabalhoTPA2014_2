/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhotpa;

/**
 *
 * @author Henrique Silveira
 */

public class Resposta extends Resultado {
	
	private String texto;
	private final Questao questao;
	
	public Resposta (Questao questao, Solucao solucao){
                super("resposta", solucao);
		this.questao = questao;
		this.nota = 0;
	}
	
        public String getTexto(){
		return this.texto;
	}
	
	public void setTexto(String texto){
		this.texto = texto;
	}
                
}
