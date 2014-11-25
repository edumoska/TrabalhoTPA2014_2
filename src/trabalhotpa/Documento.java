/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhotpa;

import java.util.Date;

/**
 *
 * @author Henrique Silveira
 */

public class Documento extends Resultado {
	
	private final Trabalho trabalho;
	private String texto;
	private Date dataEntregue;
        private String endereco;
		
	public Documento (Trabalho trabalho, String texto, Solucao solucao){
                super("documento", solucao);
		this.trabalho = trabalho;
		this.nota = 0;	
		this.texto = texto;
        }
        
	public String getTexto(){
		return this.texto;
	}
	
	public void setTexto(String texto){
		this.texto = texto;
	}
	
	public Date getDataEntregue(){
	
		return this.dataEntregue;
	}
	
	public void setDataEntregue(Date data){
		this.dataEntregue = data;
	}   
    
	public String getEndereco(){
		return this.endereco;
	}
	
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}

}
