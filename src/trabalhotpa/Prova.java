/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa;

import java.util.ArrayList;
/**
 *
 * @author victor
 */
public class Prova extends Exame{
    //armazena uma lista de questões
    private final ArrayList<Questao> prova;
    //armazena o nome da prova
    private String nome;
    //pontuação total da prova
    private float pontuacaoTotal;
    //constroi o objeto prova
    public Prova(String codigoDisciplina, String nomeTurma, String name,int tipo){
        super( codigoDisciplina, nomeTurma, name,tipo);
        this.pontuacaoTotal = 0;
        this.prova = new ArrayList<Questao>();
    }
    
    //adiciona uma nova questão na lista de questões na prova
    public void adicionarQuestao(String nomeDaQuestao, String Dificuldade,float Pontuacao){
        Questao q = new Questao(nomeDaQuestao, Dificuldade, Pontuacao);
        this.prova.add(q);
        this.pontuacaoTotal += q.getPontuacaodaQuestao();
    }
    
    //adiciona uma nova questão objetiva na lista de questões na prova
    public void adicionarQuestao(String nomeDaQuestao, String Dificuldade, int quantidade,float Pontuacao){
        Questao q = new QuestaoObjetiva(nomeDaQuestao, Dificuldade, quantidade, Pontuacao);
        this.prova.add(q);
        this.pontuacaoTotal += q.getPontuacaodaQuestao();
    }
    
    //adiciona uma questão do template pela sua posição
    public void addQuestaoTemplate(TemplateQuestao t){
        this.prova.add(t.getQuestaoTemplate());
        this.pontuacaoTotal += t.getQuestaoTemplate().getPontuacaodaQuestao();
    }
    
    //retorna a pontuação total da prova
    public float getPontuacaoTotalDaProva(){
        return this.pontuacaoTotal;
    }
    //retorna o numero de questões
    @Override
    public int getNumeroDeQuestoes(){
        return this.prova.size();
    }
    
    //remove uma questão lista pela sua posição
    public void removeQuestao(int index){
        this.prova.remove(index);
    }
    
    //retorna o objeto questão da prova pela sua posição
    public Questao getQuestaoProva(int index){
        return this.prova.get(index);
    }
}

