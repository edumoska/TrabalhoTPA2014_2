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
public abstract class Pessoa {
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    
    public Pessoa(String nome, String telefone, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }
    public String getNome(){
        return nome;
    }
    public String getTelefone(){
        return telefone;
    }
    public String getEmail(){
        return email;
    }
    public boolean isSenha(String senha){
        return this.senha.equals(senha);
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setSenha(String senhaantiga,String senhanova){
        if(this.senha == senhaantiga)
            this.senha = senhanova;
    }
}
