/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;

/**
 *
 * @author 20182PF.CC0076
 */

public class Produto {
    private int idProduto;
    private String nome;
    private String descricao;
    private double preco;
    private int qtdEstoque;
    private boolean servico;

    public Produto(int idProduto, String nome, String descricao, double preco, int qtdEstoque, boolean servico) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.servico = servico;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public boolean isServico() {
        return servico;
    }

    public void setServico(boolean servico) {
        this.servico = servico;
    }

    public boolean cadastrarProduto() {
        System.out.println("Produto cadastrado: " + nome + " (ID: " + idProduto + ")");
        return true;
    }

    public void atualizarEstoque(int quantidadeVendidaOuAdicionada) {
        if (quantidadeVendidaOuAdicionada > 0 && this.qtdEstoque >= quantidadeVendidaOuAdicionada) {
            this.qtdEstoque -= quantidadeVendidaOuAdicionada;
            System.out.println("Estoque do produto " + nome + " atualizado para: " + this.qtdEstoque);
        } else if (quantidadeVendidaOuAdicionada <=0) {
            System.err.println("Quantidade para atualização de estoque deve ser positiva.");
        }
        else {
            System.err.println("Erro ao atualizar estoque do produto " + nome + ": quantidade insuficiente.");
        }
    }
    
    public void setNovoEstoque(int novoEstoque) {
        this.qtdEstoque = novoEstoque;
         System.out.println("Estoque do produto " + nome + " definido para: " + this.qtdEstoque);
    }


    public boolean verificarEstoque(int quantidadeDesejada) {
        return this.qtdEstoque >= quantidadeDesejada;
    }

    @Override
    public String toString() {
        return 
               " Produto: " + idProduto +
               ", Nome: " + nome + '\'' +
               ", Preço: " + String.format("%.2f",preco) +
               ", QtdEstoque: " + qtdEstoque +
               ", Serviço: " + servico;
    }
}