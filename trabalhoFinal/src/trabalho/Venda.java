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
    
    // As listas que armazenam os itens da venda
    private List<Produto> listaDeProdutos;
    private List<Integer> listaDeQuantidades;

    public Venda(int idVenda, Cliente cliente, Funcionario funcionario) {
        this.idVenda = idVenda;
        this.clienteAssociado = cliente;
        this.funcionarioResponsavel = funcionario;
        this.dataHora = LocalDateTime.now();
        this.statusVenda = "Em Aberto";
        this.valorTotal = 0.0;
        
        // Inicializa as listas como ArrayLists vazias
        this.listaDeProdutos = new ArrayList<>();
        this.listaDeQuantidades = new ArrayList<>();
    }

    // --- LÓGICA DA VENDA ---

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

        // Atualiza o valor total da venda
        this.valorTotal += produto.getPreco() * quantidade;

        // Dá baixa no estoque
        produto.removerDoEstoque(quantidade);
        System.out.println(quantidade + "x " + produto.getNome() + " adicionado(s) à venda.");
    }

    // --- GETTERS E SETTERS (AQUI ESTÁ A CORREÇÃO) ---

    // Getter para o ID da Venda
    public int getIdVenda() {
        return this.idVenda;
    }

    // Getter para o Status
    public String getStatusVenda() {
        return this.statusVenda;
    }
    
    // Setter para o Status (usado no seu main)
    public void setStatusVenda(String status) {
        this.statusVenda = status;
    }

    // Getter para o Valor Total
    public double getValorTotal() {
        return this.valorTotal;
    }

    // Getter para a lista de Produtos (aqui estava o erro)
    public List<Produto> getProdutos() {
        // Correção: retorna a lista de produtos em vez de lançar erro
        return this.listaDeProdutos;
    }

    // Getter para a lista de Quantidades
    public List<Integer> getQuantidades() {
        // Correção: retorna a lista de quantidades em vez de lançar erro
        return this.listaDeQuantidades;
    }
    
    // Getter para o Cliente
    public Cliente getClienteAssociado() {
        return this.clienteAssociado;
    }
    
    // toString para quando você quiser uma representação simples da Venda
    @Override
    public String toString() {
        return String.format("Venda ID: %d, Cliente: %s, Valor: R$%.2f", 
            this.idVenda, this.clienteAssociado.getNome(), this.valorTotal);
    }
}