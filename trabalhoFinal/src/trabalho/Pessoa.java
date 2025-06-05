/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;

/**
 *
 * @author 20182PF.CC0076
 */

public abstract class Pessoa { 
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;

    public Pessoa(String nome, String cpf, String telefone, String endereco) {
        this.nome = nome;
        this.setCpf(cpf);
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null && (cpf.length() == 11 || cpf.length() == 14)) {
            this.cpf = cpf;
        } else {
            System.err.println("CPF inválido fornecido: " + cpf + ". CPF não foi alterado.");
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public abstract void consultarHistorico();

    @Override
    public String toString() {
        return 
                "Nome: " + nome +
                ", Cpf: " + cpf +
                ", Telefone: " + telefone +
                ", Endereco: " + endereco;
    }
}