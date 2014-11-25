/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa;

/**
 *
 * @author victor
 */
public class Questao {
    //armazena o nome da questão
    private String enunciado;
    private String dificuldade;
    private float pontuacao;
    //constroi o objeto questão 
    public Questao(String Enunciado, String Dificuldade, float Pontuacao){
        this.enunciado = Enunciado;
        this.dificuldade = Dificuldade;
        this.pontuacao = Pontuacao;
    }
    
    //retorna o nome da questão
    public String getEnunciadoQuestao(){
        return this.enunciado;
    }
    
    //retorna a dificuldade da questão
    public String getDificuldadeQuestao(){
        return this.dificuldade;
    }
    
    //altera o nome da questão
    public void setEnunciadoQuestao(String nome){
        this.enunciado = nome;
    }
    
    //altera a dificuldade da questão
    public void setDificuldadeQuestao(String Dificuldade){
        this.dificuldade = Dificuldade;
    } 
    //retorna a pontuação da questão
    public float getPontuacaodaQuestao(){
        return this.pontuacao;
    }
    
    //altera o nome da questão
    public void setPontuacaoQuestao(float Pontuacao){
        this.pontuacao = Pontuacao;
    }
}