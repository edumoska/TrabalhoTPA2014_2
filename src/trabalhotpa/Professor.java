/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhotpa;

/**
 *
 * @author ayrtex
 */
public class Professor extends Pessoa {

    private String cpf;
    private boolean gerente;
    
    public Professor(String nome, String cpf, String telefone, String email, String senha, boolean gerente){
        super(nome, telefone, email, senha);
        this.cpf = cpf;
        this.gerente = gerente;
    }
    public String getCPF(){
        return cpf;
    }
    public boolean getGerente(){
        return gerente;
    }
    public void setGerente(boolean gerente){
        this.gerente = gerente;
    }
}
