/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Eduardo
 */
public interface ICurso {
    ////////////////////////////////////////////////////////////////////////////////
    // Todos

    /**
     * Realiza login no sistema com o usuário e senha informado
     * @param user
     * @param senha
     * @return verdadeiro se conseguiu logar no sistema
     */
    public boolean login(String user, String senha);
    /**
     * Realiza logout no sistema
     */
    public void logout();

    /**
     * retorna codigo de nome das disciplinas
     * @return Map<Codigo,nome>
     */
    public Map<String,String> getDisciplinas();
    /**
     * retorna codigo da disciplina e nomes das turmas que o aluno esta inscrito ou que o professor vai ministrar
     * @return Map<CodigoDisciplina,nomeTurma>
     */     
    public Map<String,String> getMinhasTurmas();
    /**
     * retorna nome das turmas de uma disciplina
     * @param codigoDisciplina
     * @return List<Nome>
     */
    public List getTurmas(String codigoDisciplina);

    /**
     * retorna o nome dos exams de uma turma
     * @param codigoDisciplina
     * @param codigoTurma
     * @return List<Nome>
     */ 
    public List<String> getExames(String codigoDisciplina, String codigoTurma, String codigoAvaliacao);
    /**
     * retorna o número de questões de um exame (trabalho retorna 1)
     * @param codigoDisciplina
     * @param codigoTurma
     * @param codigoExame
     * @return Quantidade de questoes
     */
    public int totalQuestoes(String codigoDisciplina, String codigoTurma, String codigoExame);

    ///////////////////////////////////////////////////////////////////////////////
    // Gerente

    /**
     * Cria uma disciplina
     * @param código
     * @param nome
     * @param ch 
     */
    public void criarDisciplina(String código, String nome, int ch);
    /**
     * Remove uma disciplina
     * @param código 
     */
    public void removerDisciplina(String código);

    /**
     * retorna o cpf e nome dos professores
     * @return Map<Cpf,Nome>
     */
    public Map<String,String> getProfessores();
    /**
     * Cria um professor
     * @param nome
     * @param telefone
     * @param email
     * @param cpf
     * @param gerente 
     */
    public void criarProfessor(String nome, String telefone, String email, String cpf, boolean gerente);
    /**
     * remove um professor
     * @param cpf 
     */
    public void removerProfessor(String cpf);

    /**
     * retorna matricula e nome dos alunos
     * @return Map<Matricula,nome>
     */
    public Map<String,String> getAlunos();
    /**
     * Cria um aluno
     * @param nome
     * @param telefone
     * @param email
     * @param matricula 
     */
    public void criarAluno(String nome, String telefone, String email, String matricula);
    /**
     * Remove um aluno
     * @param matricula 
     */
    public void removerAluno(String matricula);

    /**
     * Cria uma turma em uma disciplina
     * @param codigoDisciplina
     * @param nome 
     */
    public void criarTurma(String codigoDisciplina, String nome);
    /**
     * remove uma turma de uma disciplina
     * @param codigoDisciplina
     * @param nome 
     */
    public void removerTurma(String codigoDisciplina, String nome);

    ///////////////////////////////////////////////////////////////////////////////////
    // Gerente e Professor

    /**
     * Cria um template de questão. Retorna codigo e texto dos templates de uma disciplina
     * @param codigoDisciplina
     * @return Map<Codigo,texto>
     */
    public Map<Integer,String> getTemplates(String codigoDisciplina);
    /**
     * Cria um template de questão. Retorna o codigo do novo template criado
     * @param codigoDisciplina
     * @param template
     * @return codigo do template
     */
    public int criarTemplate(String codigoDisciplina, String template);

    /**
     * Cria um exame. Retorna o nome do exame criado
     * @param codigoDisciplina
     * @param nomeTurma
     * @param nomeExame
     * @param tipo
     * @return nome do exame
     */
    public String criarExame(String codigoDisciplina, String nomeTurma,String nomeExame, int tipo);
    /**
     * Cria um exame. Retorna o nome do exame criado
     * @param codigoDisciplina
     * @param nomeTurma
     * @param nomeExame
     * @param tipo
     * @param codigoTemplate
     * @return nome do exame
     */
    public String criarExame(String codigoDisciplina, String nomeTurma,String nomeExame, int tipo, int codigoTemplate);

    /**
     * Adiciona questão em um exame. retorna o numero da questao criada
     * @param codigoDisciplina
     * @param nomeTurma
     * @param nomeExame
     * @param textoQuestao
     * @param objetiva
     * @return número da questão
     */
    public int adicionarQuestao(String codigoDisciplina, String nomeTurma,String nomeExame, String textoQuestao, boolean objetiva);
    /**
     * Adiciona opção no exame de uma turma. Retorna a letra da opcao criada
     * @param codigoDisciplina
     * @param nomeTurma
     * @param nomeExame
     * @param numeroQuestao
     * @param textoOpcao
     * @return 
     */ 
    public char adicionarOpcao(String codigoDisciplina, String nomeTurma,String nomeExame, int numeroQuestao, String textoOpcao);
    /**
     * Informa qual a opçãoo correta para uma questão objetiva
     * @param codigoDisciplina
     * @param nomeTurma
     * @param nomeExame
     * @param numeroQuestao
     * @param letra 
     */
    public void setCorreta(String codigoDisciplina, String nomeTurma,String nomeExame, int numeroQuestao, char letra);

    /**
     * retorna codigo das solucoes de um exame
     * @param codigoDisciplina
     * @param nomeTurma
     * @param nomeExame
     * @return List<Codigo>
     */
    public List<Integer> getSolucoes(String codigoDisciplina, String nomeTurma,String nomeExame);
    /**
     * retorna codigo do exame e o texto do documento
     * @param codigoSolucao
     * @return Map<Codigo,documento>
     */ 
    public Map<String,String> getResultadosDocumento(int codigoSolucao);
    /**
     * retorna codigo do exame e o texto da resposta de uma questão de uma solucao
     * @param codigoSolucao
     * @param numeroQuestao
     * @return 
     */
    public Map<String,String> getResultadosResposta(int codigoSolucao, int numeroQuestao);
    /**
     * Corrige a solução do trabalho de uma turma
     * @param codigoDisciplina
     * @param nomeTurma
     * @param codigoExame
     * @param codigoSolucao
     * @param nota
     * @param comentario 
     */
    public void corrigirExame(String codigoDisciplina, String nomeTurma,String codigoExame, int codigoSolucao, float nota, String comentario);
    /**
     * Corrige a solução da prova de uma turma
     * @param codigoDisciplina
     * @param nomeTurma
     * @param codigoExame
     * @param codigoSolucao
     * @param numeroQuestao
     * @param nota
     * @param comentario 
     */
    public void corrigirExame(String codigoDisciplina, String nomeTurma,String codigoExame, int codigoSolucao, int numeroQuestao, float nota, String comentario);

    /////////////////////////////////////////////////////////////////////////////////////
    // Aluno

    /**
     * Inscreve um aluno em uma turma
     * @param codigoTurma
     * @param codigoDisciplina
     * @return se o aluno foi inscrito na turma ou não
     */
    public boolean inscreverEmTurma(String codigoTurma, String codigoDisciplina);
    /**
     * Responde a uma prova de uma turma
     * @param codigoTurma
     * @param codigoDisciplina
     * @param nomeExame
     * @param numeroQuestao
     * @param resposta 
     */ 
    public void responderExame(String codigoTurma, String codigoDisciplina, String nomeExame, int numeroQuestao, String resposta);
    /** 
     * Responde a um trabalho de uma turma
     * @param codigoTurma
     * @param codigoDisciplina
     * @param nomeExame
     * @param resposta 
     */
    public void responderExame(String codigoTurma, String codigoDisciplina, String nomeExame, String resposta);

    /**
     * retorna a nota de uma aluno em um exame
     * @param codigoTurma
     * @param codigoDisciplina
     * @param nomeExame
     * @return a nota de uma aluno em um exame
     */
    public float notaResultado(String codigoTurma, String codigoDisciplina, String nomeExame);
    /**
     * retorna o comentário do resultado de um trabalho
     * @param codigoTurma
     * @param codigoDisciplina
     * @param nomeExame
     * @return o comentário do resultado de um trabalho
     */
    public String visualizarResultadoDocumento(String codigoTurma, String codigoDisciplina, String nomeExame);
    /**
     * retorna o numero da questão e o comentário de uma prova
     * @param codigoTurma
     * @param codigoDisciplina
     * @param nomeExame
     * @return Map<Numero,comentario>
     */
    public Map<Integer,String> visualizarResultadoResposta(String codigoTurma, String codigoDisciplina, String nomeExame);
    /**
     * retorna o numero da questão e a nota da questão de uma prova 
     * @param codigoTurma
     * @param codigoDisciplina
     * @param nomeExame
     * @return Map<Numero,nota>
     */
    public Map<Integer,Float> notaResultadoResposta(String codigoTurma, String codigoDisciplina, String nomeExame);

    
}
