/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa.ui;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import trabalhotpa.ICurso;

/**
 *
 * @author Eduardo
 */
public class MenuPrincipal {
    private ICurso curso;
    private boolean logado=false;
    
    public MenuPrincipal(ICurso c){
        curso = c;
    }
    
    private String readLine(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private int readInt(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    public boolean menu(){
        
        System.out.println("Trabalho de TPA");
        
        System.out.println("Escolha a opção:");
        System.out.println("1 - Login");
        if(logado){
            System.out.println("2 - Gerenciar Professores");
            System.out.println("3 - Gerenciar Alunos");
            System.out.println("4 - Gerenciar Disciplinas");
            System.out.println("5 - Gerenciar Turmas");
            System.out.println("6 - Criar Template de Questão");
            System.out.println("7 - Operações com Exames");
            System.out.println("8 - Inscrever em Turmas");
            System.out.println("9 - Logout");
        }
        System.out.println("0 - Sair");
        int opcao;
        do {
            opcao = readInt();
            switch(opcao){
                case 1: Login(); break;
                case 2: if(logado) Professores(); break;
                case 3: if(logado) Alunos(); break;
                case 4: if(logado) Disciplinas(); break;
                case 5: if(logado) Turmas(); break;
                case 6: if(logado) Template(); break;
                case 7: if(logado) Exames(); break;
                case 8: if(logado) Inscricao(); break;
                case 9: if(logado) Logout(); break;
                case 0: System.out.println("Saindo..."); return false;
                default: System.out.println("opção inválida");
            }
        }while(opcao < 0 || opcao > 9);
        return true;
    }
    
    private void Login(){
        System.out.print("Usuario: ");
        String user = readLine();
        System.out.print("Senha: ");
        String senha = readLine();
        if(curso.login(user, senha)){
            System.out.println("usuário " + user + " logado com sucesso");
            logado = true;
        }else
            System.out.println("usuário ou senha inválido");
    } 
    
    private void Professores(){
        System.out.println("Gerenciar Professores");
        
        System.out.println("Escolha a opção:");
        System.out.println("1 - Incluir Professor");
        System.out.println("2 - Excluir Professor");
        System.out.println("0 - voltar");
        
        int opcao;
        do{
            opcao = readInt();
            switch(opcao){
                case 1: incluirProfessor(); break;
                case 2: excluirProfessor(); break;
                case 0: System.out.println("voltando...");
                default: System.out.println("opção inválida");
            }
        }while(opcao < 0 && opcao > 2);
    }
    
    private void Alunos(){
        System.out.println("Gerenciar Alunos");
        
        System.out.println("Escolha a opção:");
        System.out.println("1 - Incluir Aluno");
        System.out.println("2 - Excluir Aluno");
        System.out.println("0 - voltar");
        
        int opcao;
        do{
            opcao = readInt();
            switch(opcao){
                case 1: incluirAluno(); break;
                case 2: excluirAluno(); break;
                case 0: System.out.println("voltando...");
                default: System.out.println("opção inválida");
            }
        }while(opcao < 0 && opcao > 2);        
    }
    
    private void Disciplinas(){
        System.out.println("Gerenciar Disciplinas");
        
        System.out.println("Escolha a opção:");
        System.out.println("1 - Incluir Disciplina");
        System.out.println("2 - Excluir Disciplina");
        System.out.println("0 - voltar");
        
        int opcao;
        do{
            opcao = readInt();
            switch(opcao){
                case 1: incluirDisciplina(); break;
                case 2: excluirDisciplina(); break;
                case 0: System.out.println("voltando...");
                default: System.out.println("opção inválida");
            }
        }while(opcao < 0 && opcao > 2);        
    }
    
    private void Turmas(){
        System.out.println("Gerenciar Turmas");
        
        System.out.println("Escolha a opção:");
        System.out.println("1 - Incluir Turma");
        System.out.println("2 - Excluir Turma");
        System.out.println("0 - voltar");
        
        int opcao;
        do{
            opcao = readInt();
            switch(opcao){
                case 1: incluirTurma(); break;
                case 2: excluirTurma(); break;
                case 0: System.out.println("voltando...");
                default: System.out.println("opção inválida");
            }
        }while(opcao < 0 && opcao > 2);        
    }
    
    private void Exames(){
        System.out.println("Operações com Exames");
        
        System.out.println("Escolha a opção:");
        System.out.println("1 - Criar Exame");
        System.out.println("2 - Responder Exame");
        System.out.println("3 - Corrigir Exame");
        System.out.println("0 - voltar");
        
        int opcao;
        do{
            opcao = readInt();
            switch(opcao){
                case 1: CriarExame(); break;
                case 2: ResponderExame(); break;
                case 3: CorrigirExame(); break;
                case 0: System.out.println("voltando...");
                default: System.out.println("opção inválida");
            }
        }while(opcao < 0 && opcao > 3);                
    }

    private boolean confirmar(String msg){
        System.out.println(msg + " (s/n)");
        String op;
        do {
            op = readLine();
        } while(!op.equals("s") && !op.equals("n"));
        return op.equals("s");
    }
    
    private void Template(){
        StringBuilder template = new StringBuilder();
        String disc,txt;
        boolean achou;
        
        Map<String,String> disciplinas = curso.getDisciplinas();
        
        System.out.print("Digite o código da disciplina: ");
        disc = readLine();
        if(!disciplinas.containsKey(disc)){
            System.out.print("Código de disciplina inexistente");
            return;
        }
                       
        System.out.println("Digite o texto do novo template de Questão.");
        System.out.println("Digite uma linha em branco para terminar.");
        do{
            txt = readLine();
            if(!txt.isEmpty()){
                if(!template.toString().isEmpty())
                    template.append("\n");
                template.append(txt);
            }
        }while(!txt.isEmpty());
        
        if(confirmar("Deseja criar o template de Questão com o texto:\n\""+template.toString()+"\"?") )
            curso.criarTemplate(disc, template.toString());
    }
    
    private void Inscricao(){
        String turma,disc;
        boolean achou;
        
        Map<String,String> disciplinas = curso.getDisciplinas();
        
        do{
            System.out.print("Digite o código da disciplina ou 0 (zero) para cancelar: ");
            disc = readLine();
            if(disc.equals("0"))
                return;
            achou = disciplinas.containsKey(disc);
            if(!achou)
                System.out.print("Código de disciplina inexistente");
        }while(!achou);
        
        List<String> turmas = curso.getTurmas(disc);
        
        do{
            System.out.print("Digite o código da turma ou 0 (zero) para cancelar: ");
            turma = readLine();
            if(turma.equals("0"))
                return;
            achou = turmas.contains(turma);
            if(!achou)
                System.out.print("Código de turma inexistente para a disciplina "+ disc);
        }while(!achou);

        if(confirmar("Deseja se inscrever na turma" + turma + " da disciplina "+ disc +"?") )
            curso.inscreverEmTurma(turma,disc);
    }
    
    private void Logout(){
        curso.logout();
        logado = false;
    }

    private void incluirProfessor() {
        System.out.println("Incluir Professor");
        
        System.out.print("Cpf: ");
        String cpf = readLine();
        System.out.print("Nome: ");
        String nome = readLine();
        System.out.print("Telefone: ");
        String telefone = readLine();
        System.out.print("Email: ");
        String email = readLine();
        System.out.print("Gerente (s/n): ");
        String gerente = readLine();
        
        if(confirmar("Deseja criar o Professor "+ nome+"?"))
            curso.criarProfessor(nome, telefone, email, cpf, gerente.equals("s"));
    }

    private void excluirProfessor() {
        System.out.println("Excluir Professor");
        
        Map<String,String> professores = curso.getProfessores();
        
        System.out.print("Cpf: ");
        String cpf = readLine();
        
        if(!professores.containsKey(cpf)){
            System.out.println("Não existe professor com o CPF digitado");
            return;
        }
        
        String nome = professores.get(cpf);
        
        if(confirmar("Deseja excluir o Professor "+ nome+"?"))
            curso.removerProfessor(cpf);
    }

    private void incluirAluno() {
        System.out.println("Incluir Aluno");
        
        System.out.print("Matricula: ");
        String matricula = readLine();
        System.out.print("Nome: ");
        String nome = readLine();
        System.out.print("Telefone: ");
        String telefone = readLine();
        System.out.print("Email: ");
        String email = readLine();
        
        if(confirmar("Deseja criar o Aluno "+ nome+"?"))
            curso.criarAluno(nome, telefone, email, matricula);
    }

    private void excluirAluno() {
        System.out.println("Excluir Aluno");
        
        Map<String,String> alunos = curso.getAlunos();
        
        System.out.print("Matricula: ");
        String matricula = readLine();
        
        if(!alunos.containsKey(matricula)){
            System.out.println("Não existe aluno com a matricula digitada");
            return;
        }
        
        String nome = alunos.get(matricula);
        
        if(confirmar("Deseja excluir o Aluno "+ nome+"?"))
            curso.removerAluno(matricula);
    }

    private void incluirDisciplina() {
        System.out.println("Incluir Disciplina");
        
        System.out.print("Codigo: ");
        String codigo = readLine();
        System.out.print("Nome: ");
        String nome = readLine();
        System.out.print("CH: ");
        int ch = readInt();
        
        if(confirmar("Deseja criar a disciplina "+ nome+"?"))
            curso.criarDisciplina(codigo, nome, ch);
    }

    private void excluirDisciplina() {
        System.out.println("Excluir Disciplina");
        
        Map<String,String> disciplinas = curso.getDisciplinas();
        
        System.out.print("Codigo: ");
        String codigo = readLine();
        
        if(!disciplinas.containsKey(codigo)){
            System.out.println("Não existe disciplina com o codigo digitado");
            return;
        }
        
        String nome = disciplinas.get(codigo);
        
        if(confirmar("Deseja excluir a disciplina "+ nome+"?"))
            curso.removerDisciplina(codigo);
    }

    private void incluirTurma() {
        System.out.println("Incluir Turma");
        
        System.out.print("Codigo da Disciplna: ");
        String codigo = readLine();
        System.out.print("Nome da Turma: ");
        String nome = readLine();
        
        Map<String,String> disciplinas = curso.getDisciplinas();
        if(!disciplinas.containsKey(codigo)){
            System.out.println("Não existe disciplina com o codigo digitado");
            return;
        }
        
        String disc = disciplinas.get(codigo);
        
        if(confirmar("Deseja criar a turma "+ nome+" da disciplina "+ disc+"?"))
            curso.criarTurma(codigo, nome);
    }

    private void excluirTurma() {
        System.out.println("Excluir Turma");
        
        System.out.print("Codigo da Disciplna: ");
        String codigo = readLine();
        System.out.print("Nome da Turma: ");
        String nome = readLine();
        
        Map<String,String> disciplinas = curso.getDisciplinas();
        if(!disciplinas.containsKey(codigo)){
            System.out.println("Não existe disciplina com o codigo digitado");
            return;
        }
        
        String disc = disciplinas.get(codigo);
        
        if(confirmar("Deseja remover a turma "+ nome+" da disciplina "+ disc+"?"))
            curso.removerTurma(codigo, nome);
    }

    private void CriarExame() {
        System.out.println("Criar Exame");
        
        System.out.print("Codigo da Disciplna: ");
        String codigo = readLine();
        
        Map<String,String> disciplinas = curso.getDisciplinas();
        if(!disciplinas.containsKey(codigo)){
            System.out.println("Não existe disciplina com o codigo digitado");
            return;
        }
        String disc = disciplinas.get(codigo);

        System.out.print("Nome da Turma: ");
        String nome = readLine();
        
        List<String> turmas = curso.getTurmas(codigo);
        if(!turmas.contains(nome)){
            System.out.println("Não existe turma com o nome digitado na disciplina " + disc);
            return;
        }

        System.out.print("Nome do Exame: ");
        String exame = readLine();
        System.out.print("Tipo do Exame (1=trabalho,2=prova): ");
        int tipo = readInt();
        
        if(!confirmar("Deseja criar o exame "+ exame +" na turma " + nome + " da disciplina "+ disc+"?"))
            return;
            
        curso.criarExame(codigo, nome, exame, tipo);
        
        System.out.print("Quantidade de questões: ");
        int qtdQ = readInt();
        
        for(int i=0; i < qtdQ; i++){
            System.out.print("Texto da Questão "+(i+1)+": ");
            String questao = readLine();
            System.out.print("Questão Objetiva? (s/n): ");
            String op = readLine();
            boolean objetiva = op.equals("s");
            int num = curso.adicionarQuestao(disc, nome, exame, questao, objetiva);
            if(objetiva){
                System.out.print("Quantidade de opções: ");
                int qtdO = readInt();
                for(int j=0; j < qtdO; j++){
                    System.out.print("Texto da Opção "+(j+1)+": ");
                    String opcao = readLine();
                    curso.adicionarOpcao(disc, nome, exame, num, opcao);
                }
            }
        }
    }

    private void ResponderExame() {
        System.out.println("Responder Prova");
        
        System.out.print("Codigo da Disciplna: ");
        String codigo = readLine();
        
        Map<String,String> disciplinas = curso.getDisciplinas();
        if(!disciplinas.containsKey(codigo)){
            System.out.println("Não existe disciplina com o codigo digitado");
            return;
        }
        String disc = disciplinas.get(codigo);

        System.out.print("Nome da Turma: ");
        String nome = readLine();
        
        List<String> turmas = curso.getTurmas(codigo);
        if(!turmas.contains(nome)){
            System.out.println("Não existe turma com o nome digitado na disciplina " + disc);
            return;
        }
        
        System.out.print("Nome do Exame: ");
        String exame = readLine();
        
        List<String> exames = curso.getExames(disc,nome);
        if(!exames.contains(exame)){
            System.out.println("Não existe exame com o nome digitado na turma " + nome + " da disciplina " + disc);
            return;
        }
        
        int qtd = curso.totalQuestoes(disc,nome,codigo);
        if(qtd == 0){
            System.out.print("Caminho do trabalho: ");
            String caminho = readLine();
            curso.responderExame(nome, disc, exame, caminho);
        } else
            for(int i=1; i <= qtd; i++){
                System.out.print("Resposta da questão "+ i +": ");
                String questao = readLine();
                curso.responderExame(nome, disc, exame, i, questao);
            }
    }

    private void CorrigirExame() {
        System.out.println("Corrigir Prova");
        
        System.out.print("Codigo da Disciplna: ");
        String codigo = readLine();
        
        Map<String,String> disciplinas = curso.getDisciplinas();
        if(!disciplinas.containsKey(codigo)){
            System.out.println("Não existe disciplina com o codigo digitado");
            return;
        }
        String disc = disciplinas.get(codigo);

        System.out.print("Nome da Turma: ");
        String nome = readLine();
        
        List<String> turmas = curso.getTurmas(codigo);
        if(!turmas.contains(nome)){
            System.out.println("Não existe turma com o nome digitado na disciplina " + disc);
            return;
        }
        
        System.out.print("Nome do Exame: ");
        String exame = readLine();
        
        List<String> exames = curso.getExames(disc,nome);
        if(!exames.contains(exame)){
            System.out.println("Não existe exame com o nome digitado na turma " + nome + " da disciplina " + disc);
            return;
        }
        
        List<Integer> solucoes = curso.getSolucoes(disc, nome, exame);
        
        int qtd = curso.totalQuestoes(disc,nome,codigo);
        for(Integer codigoSolucao: solucoes){
            if(qtd == 0) {
                System.out.print("Nota: ");
                String nota = readLine();
                System.out.print("comentário: ");
                String comentario = readLine();
                curso.corrigirExame(disc, nome, exame,codigoSolucao, Float.valueOf(nota), comentario);
            } else {
                for(int i=1; i <= qtd; i++){
                    System.out.print("Nota da questão "+ i +": ");
                    String nota = readLine();
                    System.out.print("comentário da questão "+ i +": ");
                    String comentario = readLine();
                    curso.corrigirExame(disc, nome, exame, codigoSolucao, i, Float.valueOf(nota), comentario);
                }
            }
        }
    }

}
