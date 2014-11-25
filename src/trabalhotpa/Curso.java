/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayrtex
 */
public class Curso implements ICurso {
    private HashMap<String,Disciplina> disciplinas; 
    private HashMap<String, Aluno>    alunos;
    private HashMap<String, Professor> professores;
    //Para uso interno/////////////
    private boolean loggedIn;
    private char tipoLogin;
    private boolean gerente;
    private Aluno alu;
    private Professor prof;
    //////////////////////////////
    
    public Curso(){
        disciplinas = new HashMap<>();
        alunos = new HashMap<>();
        professores = new HashMap<>();
        loggedIn = false;
        tipoLogin = '\0';
        gerente = false;
        alu = null;
        prof = null;
    }
    
    public boolean login(String user, String senha){
        if(loggedIn == true){
            logout();
        }
        
        Aluno a;
        a = alunos.get(user);
        if(a != null){
            if(a.isSenha(senha)){
                alu = a;
                loggedIn = true;
                tipoLogin = 'a';
            }
        }
        Professor p;
        p = professores.get(user);
        if(p != null){
            if(p.isSenha(senha)){
                prof = p;
                loggedIn = true;
                tipoLogin = 'p';
                gerente = p.getGerente();
            }
        }
        return loggedIn;
    }
    
    public void logout(){
        loggedIn = false;
        gerente = false;
        tipoLogin = '\0';
        alu = null;
        prof = null;
    }
   
    //////////////////////////////////////
    
    ////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    // Todos

    // retorna codigo e nome das disciplinas
    public Map<String,String> getDisciplinas(){
        HashMap<String, String> retDisciplinas = new HashMap<>();
        Disciplina dis;
        for(Map.Entry<String, Disciplina> d : disciplinas.entrySet()){
            dis = d.getValue();
            retDisciplinas.put(dis.getCodigo(), dis.getNome());
        }
        return retDisciplinas;
    }
    
    // retorna codigo e nomes das turmas que o aluno esta inscrito ou que o professor vai ministrar
    public Map<String,String> getMinhasTurmas(){
        HashMap<String, String> retMinhasTurmas = new HashMap<>();
        HashMap<String, String> temp;
        for(Map.Entry<String, Disciplina> sd : disciplinas.entrySet()){
            Disciplina dis = sd.getValue();
            retMinhasTurmas.put(dis.getCodigo(), dis.getNome());
            if(alu != null){
                temp = dis.getMinhasTurmas(alu);
                retMinhasTurmas.putAll(temp);
            }else if(prof != null){
                temp = dis.getMinhasTurmas(prof);
                retMinhasTurmas.putAll(temp);
            }
        }
        return retMinhasTurmas;
    }
    
    // codigo e nome das turmas de uma disciplina
    public List getTurmas(String codigoDisciplina){
        Disciplina dis = disciplinas.get(codigoDisciplina);
        ArrayList <String> ret = new ArrayList<>();
        String str;
        for(Map.Entry<String, String> lsd : dis.getTurmas().entrySet()){
            str = lsd.getValue();
            ret.add(str);
        }
        return ret;
    }
    
    // retorna o nome dos exams de uma avaliação
    public List<String> getExames(String codigoDisciplina, String codigoTurma, String codigoAvaliacao){
        ArrayList<Turma> turms;
        ArrayList<String> nomeExames = new ArrayList<>();
        Disciplina temp;
        for(Map.Entry<String, Disciplina> ts : disciplinas.entrySet()){
            temp = ts.getValue();
            turms = temp.getTurmasAtivas();
            if(!turms.isEmpty()){
                for(Turma temp2 : turms){
                    if(temp2.isCodigoAvaliacao(codigoAvaliacao)){
                        nomeExames.addAll(temp2.getNomeAvaliacoes());
                    }
                }
            }
        }
        return nomeExames;
    }
    
    // retorna o número de questões de um exame (trabalho retorna 1)
    public int totalQuestoes(String codigoDisciplina, String codigoTurma, String codigoExame){
        
    }
    ///////////////////////////////////////////////////////////////////////////////
    // Gerente
    
    public void criarDisciplina(String codigo, String nome, int ch){
        Disciplina d = new Disciplina(codigo, nome, ch);
        disciplinas.put(codigo, d);
    }
    
    public void removerDisciplina(String codigo){
        disciplinas.remove(codigo);
    }

    // retorna o cpf e nome dos professores
    public Map<String,String> getProfessores(){
        HashMap<String, String> profs = new HashMap<>();
        Professor pr;
        for (Map.Entry<String, Professor> z : professores.entrySet()) {
            pr = z.getValue();
            profs.put(pr.getCPF(), pr.getNome());
        }
        return profs;
    }
    public void criarProfessor(String nome, String telefone, String email, String cpf, boolean gerente, String senha){
        Professor p = new Professor(nome, cpf, telefone, email, senha, gerente);
        professores.put(cpf, p);
    }
    public void removerProfessor(String cpf){
        professores.remove(cpf);
    }
    
    // retorna matricula e nome dos alunos
    public Map<String,String> getAlunos(){
        HashMap<String, String> alun = new HashMap<>();
        Aluno a;
        for(Map.Entry<String, Aluno> p : alunos.entrySet()){
            a = p.getValue();
            alun.put(a.getMatricula(), a.getNome());
        }
        return alun;
    }
    public void criarAluno(String nome, String telefone, String email, String matricula, String senha){
        //Aluno(String nome, String telefone, String email, String senha, float cr, String matricula)
        Aluno a = new Aluno(nome, telefone, email, senha, (float)0.0, matricula);
        alunos.put(matricula, a);
    }
    public void removerAluno(String matricula){
        alunos.remove(matricula);
    }
    
    // retorna codigo e nome das turmas
    public Map<String,String> getTurmas(){
        Disciplina temp;
        HashMap<String, String> tran;
        HashMap<String, String> turms = new HashMap<>();
        for(Map.Entry<String, Disciplina> d : disciplinas.entrySet()){
            temp = d.getValue();
            tran = temp.getTurmas();
            if(!tran.isEmpty())
                turms.putAll(tran);
        }
        return turms;
    }
    public void criarTurma(String codigoDisciplina, String nome, String codigoTurma){
        Disciplina temp = disciplinas.get(codigoDisciplina);
        temp.addTurmas(nome, null, codigoTurma);
    }
    public void removerTurma(String codigoDisciplina, String codigoTurma){
        Disciplina temp = disciplinas.get(codigoDisciplina);
        temp.removeTurma(codigoTurma);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////
    // Gerente e Professor
    
    //retorna codigo e texto dos templates de uma disciplina
    public Map<Integer,String> getTemplates(String codigoDisciplina){
        Disciplina d = disciplinas.get(codigoDisciplina);
        HashMap<Integer, String> ret = new HashMap<>();
        ArrayList<TemplateQuestao> vet = d.getTemplates();
        for(TemplateQuestao t : vet){
            ret.put(vet.indexOf(t), t.getnomeTemplate());
        }
        return ret;
    }
    
    // retorna o codigo do novo template criado
    //public void TemplateQuestao(String nomeTemplate, String questao, String grauDeDificuldade)
    public Integer criarTemplate(String codigoDisciplina, String nomeTemplate, String questao, String grauDeDificuldade){
        Disciplina d = disciplinas.get(codigoDisciplina);
        return d.addTemplate(nomeTemplate, questao, grauDeDificuldade);
    }
    //public void TemplateQuestao(String nomeTemplate, String questao, String grauDeDificuldade, int numMaxDeOpcao)
    public Integer criarTemplate(String codigoDisciplina, String nomeTemplate, String questao, String grauDeDificuldade, int numMaxDeOpcao){
        Disciplina d = disciplinas.get(codigoDisciplina);
        return d.addTemplate(nomeTemplate, questao, grauDeDificuldade, numMaxDeOpcao);
    }
    // retorna o nome do exame criado
    public String criarExame(int codigoAvaliacao,String nomeExame, int tipo){
        
    }
    
    // retorna o nome do exame criado
    public String criarExame(int codigoAvaliacao,String nomeExame, int tipo, int codigoTemplate){
        
    }
    
    // retorna o numero da questao criada
    public int adicionarQuestao(String nomeExame, String textoQuestao, boolean objetiva){
        
    }
    
    // retorna a letra da opcao criada
    public char adicionarOpcao(String nomeExame, int numeroQuestao, String textoOpcao){
        
    }
    public void setCorreta(String nomeExame, int numeroQuestao, char letra){
        
    }

    // retorna codigo das solucoes de um exame
    public List<Integer> getSolucoes(String nomeExame){
        
    }
    
    // retorna codigo do exame e o texto do documento
    public Map<String,String> getResultadosDocumento(int codigoSolucao){
        
    }
    
    // retorna codigo do exame e o texto da resposta de uma questão de uma solucao
    public Map<String,String> getResultadosResposta(int codigoSolucao, int numeroQuestao){
        
    }
    public void corrigirTrabalho(String codigoExame, int codigoSolucao, float nota, String comentario){
        
    }
    public void corrigirProva(String codigoExame, int codigoSolucao, int numeroQuestao, float nota, String comentario){
        
    }
    
    /////////////////////////////////////////////////////////////////////////////////////
    // Aluno
    
    // retorna se o aluno foi inscrito na turma ou não
    public boolean inscreverEmTurma(String codigoDisciplina, String codigoTurma){
        Disciplina temp = disciplinas.get(codigoDisciplina);
        return temp.addAluno(codigoTurma, alu);
    }
    public void responderExame(String nomeExame, int numeroQuestao, String resposta){
      
    }
    public void responderExame(String nomeExame, String resposta){
        
    }
    
    // retorna a nota de uma aluno em um exame
    public float notaResultado(String codigoDisciplina, String codigoTurma, String nomeExame){
        
    }
    
    // retorna o comentário do resultado de um trabalho
    public String visualizarResultadoDocumento(String codigoDisciplina, String codigoTurma, String nomeExame){
        
    }
    
    // retorna o numero da questão e o comentário de uma prova
    public Map<Integer,String> visualizarResultadoResposta(String codigoDisciplina, String codigoTurma, String nomeExame){
        
    }
    
    // retorna o numero da questão e a nota da questão de uma prova 
    public Map<Integer,Float> notaResultadoResposta(String codigoDisciplina, String codigoTurma, String nomeExame){
        
    }
    /////////////////////////////////////////////////////////////////////////////////////   
}
