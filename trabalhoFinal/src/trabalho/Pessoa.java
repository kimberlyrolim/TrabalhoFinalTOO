// Arquivo: trabalho/Pessoa.java

package trabalho;

// Classe base para Cliente e Funcionario
public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected String endereco;

    public Pessoa(String nome, String cpf, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Getters que as classes filhas precisam
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    
    // Um método abstrato pode forçar as classes filhas a terem seu próprio consultarHistorico
    public abstract void consultarHistorico();

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf;
    }
}