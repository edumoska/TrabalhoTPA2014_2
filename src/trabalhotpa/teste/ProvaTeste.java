/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.teste;

import trabalhotpa.Prova;
import trabalhotpa.Questao;
import trabalhotpa.QuestaoObjetiva;

/**
 *
 * @author Marcello
 */
public class ProvaTeste implements Teste{

    @Override
    public void run() throws Exception{
        Prova p = new Prova("Prova1");
        
        if(!p.getNome().equals("prova1")) throw new Exception("Prova: getNome: valor retornado não esperado");
        p.setNome("Prova 1");
        if(!p.getNome().equals("prova 1")) throw new Exception("Prova: getNome: valor retornado não esperado");
        
        p.adicionarQuestao(new Questao("Questão 1","facil",2));
        p.adicionarQuestao(new Questao("Questão 2","médio",3));
        p.adicionarQuestao(new QuestaoObjetiva("Questão 3","difícil",5,1));
        
        if(p.getNumeroDeQuestoes() != 3)   throw new Exception("Prova: getNumeroDeQuestoes: valor retornado não esperado");

    }
    
}
