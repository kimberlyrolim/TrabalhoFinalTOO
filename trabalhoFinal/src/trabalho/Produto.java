// Arquivo: trabalho/Produto.java

package trabalho;

public class Produto {
    private int idProduto;
    private String nome;
    private String descricao;
    private double preco;
    private int qtdEstoque;
    private boolean isServico;

    public Produto(int idProduto, String nome, String descricao, double preco, int qtdEstoque, boolean isServico) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.isServico = isServico;
    }

    // Métodos que a classe Venda precisa
    public boolean verificarEstoque(int quantidade) {
        if (this.isServico) {
            return true; // Serviços sempre têm "estoque"
        }
        return this.qtdEstoque >= quantidade;
    }

    public void removerDoEstoque(int quantidade) {
        if (!this.isServico) {
            this.qtdEstoque -= quantidade;
        }
    }
    
    public void cadastrarProduto() {
        System.out.println("Produto/Serviço '" + this.nome + "' cadastrado.");
    }
    
    // Getters que outras classes usam
    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }
    
    public int getQtdEstoque(){
        return this.qtdEstoque;
    }
}