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
public class TemplateQuestao{

    //armazena o nome do template
    private String nameTemplate;
    private Questao questoes;
    private int identificador;
    //contrutor do objeto template de questão
     public void  TemplateQuestao( String nomeTemplate, String questao, String grauDeDificuldade, int id, float Pontuacao){
         this.nameTemplate = nomeTemplate;
         this.identificador = id;
         questoes = new Questao(questao, grauDeDificuldade, Pontuacao);
     }
     public void  TemplateQuestao( String nomeTemplate, String questao, String grauDeDificuldade, int numMaxDeOpcao, int id,float Pontuacao){
         this.nameTemplate = nomeTemplate;
         this.identificador = id;
         questoes = new QuestaoObjetiva(questao, grauDeDificuldade, numMaxDeOpcao, Pontuacao);
     }
     //adiciona o nome do template
     public void setnameTemplate (String nomeTemplate){
         this.nameTemplate = nomeTemplate;
     }
     // retorna uma string com o nome da questão
     public String getnomeTemplate(){
         return this.nameTemplate;
     }
     //retorna uma questão do temp´late
     public Questao getQuestaoTemplate(){
         return this.questoes;
     }
     public int getId(){
         return this.identificador;
     }
     public void setId(int id){
         this.identificador = id;
     }
}
