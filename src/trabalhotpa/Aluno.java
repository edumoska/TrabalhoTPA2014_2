package trabalhotpa;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ayrtex
 */
public class Aluno extends Pessoa {
    private float cr;
    private String matricula;
    ////////////////////////////////////////////////////////////////////////
    public Aluno(String nome, String telefone, String email, String senha, float cr, String matricula) {
        super(nome, telefone, email, senha);
        this.cr = cr;
        this.matricula = matricula;
    }
    public String getMatricula(){
        return matricula;
    }
    public float getCR(){
        return cr;
    }
    public void setCR(float cr){
        this.cr = cr;
    }
}
