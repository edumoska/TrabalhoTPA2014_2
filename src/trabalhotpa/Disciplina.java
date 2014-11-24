/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
/**
 *
 * @author ayrtex
 */
public class Disciplina {
    private String nome;
    private String codigo;
    private int CH;
    private HashMap<String, Turma> turmas;
    private ArrayList<TemplateQuestao> templates;
    
    Disciplina(String nome, String codigo, int CH){
        this.nome = nome;
        this.codigo = codigo;
        this.CH = CH;
        this.turmas  = new HashMap<>();
        this.templates = new ArrayList<>();
    }
    
    public void addTurmas(String nome, Professor p, String codigo){
        Turma t = new Turma(nome, p, codigo);
        turmas.put(codigo, t);
    }
    public void removeTurma(String codigoTurma){
        turmas.remove(codigoTurma);
    }
    public boolean addAluno(String codigoTurma, Aluno a){
        Turma temp = turmas.get(codigoTurma);
        return temp.addAluno(a);
    }
    public String getCodigo(){
        return this.codigo;
    }
    public int getCH(){
        return this.CH;
    }
    public String getNome(){
        return this.nome;
    }
    public HashMap<String, String> getTurmas(){
        HashMap<String, String> tur = new HashMap<>();
        Turma t;
        for(Map.Entry<String, Turma> ts : turmas.entrySet()){
            t = ts.getValue();
            tur.put(t.getCodigo(), t.getNome());
        }
        return tur;
    }
    public HashMap<String, String> getMinhasTurmas(Professor p){
        HashMap<String, String> minhasTurmas = new HashMap<>();
        Turma t;
        for(Map.Entry<String, Turma> ts : turmas.entrySet()){
            t = ts.getValue();
            if(p.getCPF().equals(t.getProfessor().getCPF())){
                minhasTurmas.put(t.getCodigo(), t.getNome());
            }
        }
        return minhasTurmas;
    }
    public HashMap<String, String> getMinhasTurmas(Aluno a){
        HashMap<String, String> minhasTurmas = new HashMap<>();
        Turma t;
        for(Map.Entry<String, Turma> ts : turmas.entrySet()){
            t = ts.getValue();
            ArrayList<Aluno> alus = t.getAlunos();
            for(Aluno al : alus){
                if(al.getMatricula().equals(a.getMatricula())){
                    minhasTurmas.put(t.getCodigo(), t.getNome());
                    break;
                }
            }
        }
        return minhasTurmas;
    }
    public ArrayList<Turma> getTurmasAtivas(){
        ArrayList<Turma> turms = new ArrayList<>();
        Turma temp;
        for(Map.Entry<String, Turma> ts : turmas.entrySet()){
            temp = ts.getValue();
            if(temp.getEncerrada() == false){
                turms.add(temp);
            }
        }
        return turms;
    }
    //public void TemplateQuestao(String nomeTemplate, String questao, String grauDeDificuldade)
    public Integer addTemplate(String nomeTemplate, String questao, String grauDeDificuldade){
        TemplateQuestao novo = new TemplateQuestao(nomeTemplate, questao, grauDeDificuldade);
        templates.add(novo);
        return templates.indexOf(novo);
    }
//public void TemplateQuestao(String nomeTemplate, String questao, String grauDeDificuldade, int numMaxDeOpcao)
    public Integer addTemplate(String nomeTemplate, String questao, String grauDeDificuldade, int numMaxDeOpcao){
        TemplateQuestao novo = new TemplateQuestao(nomeTemplate, questao, grauDeDificuldade, numMaxDeOpcao);
        templates.add(novo);
        return templates.indexOf(novo);
    }
    public ArrayList<TemplateQuestao> getTemplates(){
        return this.templates;
    }
}

