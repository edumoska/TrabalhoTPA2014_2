/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.modelo;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Eduardo
 */
public interface ICurso {
    ////////////////////////////////////////////////////////////////////////////////
    // Todos

    public boolean login(String user, String senha);
    public void logout();

    // retorna codigo de nome das disciplinas
    public Map<String,String> getDisciplinas();
    // retorna codigo da disciplina e nomes das turmas que o aluno esta inscrito ou que o professor vai ministrar
    public Map<String,String> getMinhasTurmas();
    // retorna nome das turmas de uma disciplina
    public List<String> getTurmas(String codigoDisciplina);

    // retorna o nome das avaliações de uma turma
    public List<String> getAvaliacoes(String codigoTurma);
    // retorna o nome dos exams de uma avaliação
    public List<String> getExames(int codigoAvaliacao);
    // retorna o número de questões de um exame (trabalho retorna 1)
    public int totalQuestoes(String codigoExame);

    ///////////////////////////////////////////////////////////////////////////////
    // Gerente

    public void criarDisciplina(String código, String nome, int ch);
    public void removerDisciplina(String código);

    // retorna o cpf e nome dos professores
    public Map<String,String> getProfessores();
    public void criarProfessor(String nome, String telefone, String email, String cpf, boolean gerente);
    public void removerProfessor(String cpf);

    // retorna matricula e nome dos alunos
    public Map<String,String> getAlunos();
    public void criarAluno(String nome, String telefone, String email, String matricula);
    public void removerAluno(String matricula);

    // retorna codigo e nome das turmas
    public Map<String,String> getTurmas();
    public void criarTurma(String codigoDisciplina, String nome);
    public void removerTurma(String codigoDisciplina, String nome);

    ///////////////////////////////////////////////////////////////////////////////////
    // Gerente e Professor

    //retorna codigo e texto dos templates de uma disciplina
    public Map<Integer,String> getTemplates(String codigoDisciplina);
    // retorna o codigo do novo template criado
    public int criarTemplate(String codigoDisciplina, String template);

    // retorna o nome do exame criado
    public String criarExame(int codigoAvaliacao,String nomeExame, int tipo);
    // retorna o nome do exame criado
    public String criarExame(int codigoAvaliacao,String nomeExame, int tipo, int codigoTemplate);

    // retorna o numeor da questao criada
    public int adicionarQuestao(String nomeExame, String textoQuestao, boolean objetiva);
    // retorna a letra da opcao criada
    public char adicionarOpcao(String nomeExame, int numeroQuestao, String textoOpcao);
    public void setCorreta(String nomeExame, int numeroQuestao, char letra);

    // retorna codigo das solucoes de um exame
    public List<Integer> getSolucoes(String nomeExame);
    // retorna codigo do exame e o texto do documento
    public Map<String,String> getResultadosDocumento(int codigoSolucao);
    // retorna codigo do exame e o texto da resposta de uma questão de uma solucao
    public Map<String,String> getResultadosResposta(int codigoSolucao, int numeroQuestao);
    public void corrigirTrabalho(String codigoExame, int codigoSolucao, float nota, String comentario);
    public void corrigirProva(String codigoExame, int codigoSolucao, int numeroQuestao, float nota, String comentario);

    /////////////////////////////////////////////////////////////////////////////////////
    // Aluno

    // retorna se o aluno foi inscrito na turma ou não
    public boolean inscreverEmTurma(String codigoTurma);
    public void responderExame(String nomeExame, int numeroQuestao, String resposta);
    public void responderExame(String nomeExame, String resposta);

    // retorna a nota de uma aluno em um exame
    public float notaResultado(String nomeExame);
    // retorna o comentário do resultado de um trabalho
    public String visualizarResultadoDocumento(String nomeExame);
    // retorna o numero da questão e o comentário de uma prova
    public Map<Integer,String> visualizarResultadoResposta(String nomeExame);
    // retorna o numero da questão e a nota da questão de uma prova 
    public Map<Integer,Float> notaResultadoResposta(String nomeExame);

    
}
