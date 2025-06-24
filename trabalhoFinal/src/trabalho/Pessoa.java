
package trabalho;

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

    // Getters que as  filhas precisam
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    
    public abstract void consultarHistorico();

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf;
    }
}