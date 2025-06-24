// Arquivo: trabalho/Venda.java
// CÓDIGO FINAL E CORRETO

package trabalho;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private int idVenda;
    private LocalDateTime dataHora;
    private Cliente clienteAssociado;
    private Funcionario funcionarioResponsavel;
    private String statusVenda;
    private double valorTotal;
    
    private List<Produto> listaDeProdutos;
    private List<Integer> listaDeQuantidades;

    public Venda(int idVenda, Cliente cliente, Funcionario funcionario) {
        this.idVenda = idVenda;
        this.clienteAssociado = cliente;
        this.funcionarioResponsavel = funcionario;
        this.dataHora = LocalDateTime.now();
        this.statusVenda = "Em Aberto";
        this.valorTotal = 0.0;
        
        this.listaDeProdutos = new ArrayList<>();
        this.listaDeQuantidades = new ArrayList<>();
    }


    public void adicionarItem(Produto produto, int quantidade) {
        if (produto == null || quantidade <= 0) {
            System.out.println("Erro: Produto inválido ou quantidade deve ser maior que zero.");
            return;
        }

        // Verifica o estoque ANTES de adicionar
        if (!produto.verificarEstoque(quantidade)) {
            System.out.println("Estoque insuficiente para o produto: " + produto.getNome());
            return;
        }

        this.listaDeProdutos.add(produto);
        this.listaDeQuantidades.add(quantidade);

        this.valorTotal += produto.getPreco() * quantidade;

        produto.removerDoEstoque(quantidade);
        System.out.println(quantidade + "x " + produto.getNome() + " adicionado(s) à venda.");
    }


    public int getIdVenda() {
        return this.idVenda;
    }

    public String getStatusVenda() {
        return this.statusVenda;
    }
    
    public void setStatusVenda(String status) {
        this.statusVenda = status;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public List<Produto> getProdutos() {
        return this.listaDeProdutos;
    }

    public List<Integer> getQuantidades() {
        return this.listaDeQuantidades;
    }
    
    public Cliente getClienteAssociado() {
        return this.clienteAssociado;
    }
    
    @Override
    public String toString() {
        return String.format("Venda ID: %d, Cliente: %s, Valor: R$%.2f", 
            this.idVenda, this.clienteAssociado.getNome(), this.valorTotal);
    }
}