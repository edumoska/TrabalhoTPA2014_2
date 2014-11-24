package trabalhotpa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author victor
 */

import java.util.ArrayList;

public class QuestaoObjetiva extends Questao{
    //armazena uma lista de opções da questão objetiva
    private final ArrayList<String> opcoes;
    private int numeroDeOpcoes;
    private final int opcoesMax;
    //constrói o objeto QuestaoObjetiva
    public QuestaoObjetiva(String nomeDaQuestao, String Dificuldade, int quantidade, float Pontuacao){
        super(nomeDaQuestao, Dificuldade,Pontuacao);
        this.opcoes = new ArrayList <String>();
        this.opcoesMax = quantidade;
    }
    
    //Adiciona uma opção a questão em fila
    private void controlaOpcoes(String opcao){
        this.opcoes.add(opcao);
        this.numeroDeOpcoes ++;
    }
    //controla o numero de opções e retorna true se adicionou a opção
    public boolean addOpcoes(String opcao){
        if(numeroDeOpcoes < this.opcoesMax){
            controlaOpcoes(opcao);
            return true;
        }
        return false;
    }
    
    //remove uma opção pela sua posição
    private void controlaRemoveOpcao(int index){
        this.opcoes.remove(index);
        this.numeroDeOpcoes --;
    }
    
    //controla o numero de opções e retorna true se removeu a opção
    public boolean removeOpcoes(int index){
        if(numeroDeOpcoes > 0){
            controlaRemoveOpcao(index);
            return true;
        }
        return false;
    }
    
    //retorna a opção da questão
    public String getOpcaoQuestao(int index){
        return opcoes.get(index);
    }
}
