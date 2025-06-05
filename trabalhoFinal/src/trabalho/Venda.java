/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;

/**
 *
 * @author 20182PF.CC0076
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Venda {

    private int idVenda;
    private LocalDateTime dataHora;
    private double valorTotal;
    private String statusVenda;
    private Cliente clienteAssociado;
    private Funcionario funcionarioResponsavel;

    private List<Produto> listaDeProdutos;
    private List<Integer> listaDeQuantidades;
    
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Venda(int idVenda, Cliente cliente, Funcionario funcionario) {
        this.idVenda = idVenda;
        this.dataHora = LocalDateTime.now();
        this.clienteAssociado = cliente;
        this.funcionarioResponsavel = funcionario;

        this.listaDeProdutos = new ArrayList<>();
        this.listaDeQuantidades = new ArrayList<>();

        this.statusVenda = "Em Aberto";
        this.valorTotal = 0.0;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getStatusVenda() {
        return statusVenda;
    }

    public Cliente getClienteAssociado() {
        return clienteAssociado;
    }

    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    public void setClienteAssociado(Cliente clienteAssociado) {
        this.clienteAssociado = clienteAssociado;
    }

    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public List<Produto> getListaDeProdutosVendidos() {
        return Collections.unmodifiableList(this.listaDeProdutos);
    }
    
    public List<Integer> getListaDeQuantidadesVendidas() {
        return Collections.unmodifiableList(this.listaDeQuantidades);
    }
    
    private int encontrarIndiceDoProduto(Produto produto) {
        for (int i = 0; i < this.listaDeProdutos.size(); i++) {
            if (this.listaDeProdutos.get(i).equals(produto)) {
                return i;
            }
        }
        return -1;
    }

    public boolean adicionarItem(Produto produto, int quantidadeAdicionar) {
        if (produto == null || quantidadeAdicionar <= 0) {
            System.err.println("Erro ao adicionar item: Produto nulo ou quantidade inválida.");
            return false;
        }

        if (!produto.isServico() && !produto.verificarEstoque(quantidadeAdicionar)) {
            System.err.println("Estoque insuficiente para o produto: " + produto.getNome() +
                               ". Desejado: " + quantidadeAdicionar + ", Disponível: " + produto.getQtdEstoque());
            return false;
        }

        int indiceExistente = encontrarIndiceDoProduto(produto);

        if (indiceExistente != -1) {
            int quantidadeAtual = this.listaDeQuantidades.get(indiceExistente);
            this.listaDeQuantidades.set(indiceExistente, quantidadeAtual + quantidadeAdicionar);
        } else {
            this.listaDeProdutos.add(produto);
            this.listaDeQuantidades.add(quantidadeAdicionar);
        }

        System.out.println("\n" + quantidadeAdicionar + "x " + produto.getNome() + " adicionado(s)/atualizado(s) na venda ID: " + this.idVenda);
        calcValorTotal();

        if (!produto.isServico()) {
            produto.atualizarEstoque(quantidadeAdicionar);
        }
        return true;
    }

    public boolean removerItem(Produto produto, int quantidadeRemover) {
        if (produto == null || quantidadeRemover <= 0) {
            System.err.println("Erro ao remover item: Produto nulo ou quantidade inválida.");
            return false;
        }

        int indiceExistente = encontrarIndiceDoProduto(produto);

        if (indiceExistente == -1) {
            System.err.println("Erro ao remover item: Produto " + produto.getNome() + " não encontrado na venda.");
            return false;
        }

        int quantidadeAtual = this.listaDeQuantidades.get(indiceExistente);
        if (quantidadeRemover > quantidadeAtual) {
            System.err.println("Erro ao remover item: Tentando remover " + quantidadeRemover +
                               " de " + produto.getNome() + ", mas apenas " + quantidadeAtual + " existem na venda.");
            return false;
        }

        if (quantidadeRemover == quantidadeAtual) {
            this.listaDeProdutos.remove(indiceExistente);
            this.listaDeQuantidades.remove(indiceExistente);
            System.out.println("Produto " + produto.getNome() + " removido completamente da venda ID: " + this.idVenda);
        } else {
            this.listaDeQuantidades.set(indiceExistente, quantidadeAtual - quantidadeRemover);
            System.out.println(quantidadeRemover + "x " + produto.getNome() + " removido(s) da venda ID: " + this.idVenda +
                               ". Restante: " + this.listaDeQuantidades.get(indiceExistente));
        }

        calcValorTotal();

        if (!produto.isServico()) {
            produto.atualizarEstoque(-quantidadeRemover);
        }
        return true;
    }

    public double calcValorTotal() {
        this.valorTotal = 0;
        for (int i = 0; i < this.listaDeProdutos.size(); i++) {
            Produto p = this.listaDeProdutos.get(i);
            Integer qtd = this.listaDeQuantidades.get(i);
            if (p != null && qtd != null) {
                this.valorTotal += p.getPreco() * qtd;
            }
        }
        return this.valorTotal;
    }

    @Override
    public String toString() {
        StringBuilder itensStr = new StringBuilder();
        if (listaDeProdutos.isEmpty()) {
            itensStr.append(" Nenhum item.");
        } else {
            for (int i = 0; i < this.listaDeProdutos.size(); i++) {
                Produto produto = this.listaDeProdutos.get(i);
                Integer quantidade = this.listaDeQuantidades.get(i);
                if (produto != null && quantidade != null) {
                    itensStr.append("\n    - ")
                            .append(produto.getNome())
                            .append(" (Qtd: ").append(quantidade)
                            .append(", Preço Unit.: R$").append(String.format("%.2f", produto.getPreco()))
                            .append(", Subtotal: R$").append(String.format("%.2f", produto.getPreco() * quantidade)).append(")");
                }
            }
        }

        return "\nVenda: " + idVenda +
               "\nData da Venda: " + formato.format(dataHora) +
               "\nStatus: " + statusVenda +
               "\nCliente: " + (clienteAssociado != null ? clienteAssociado.getNome() : "Não informado") +
               "\nFuncionário: " + (funcionarioResponsavel != null ? funcionarioResponsavel.getNome() : "Não informado") +
               "\nItens:" + itensStr.toString() +
               "\n\nVALOR TOTAL DA VENDA: R$" + String.format("%.2f", valorTotal);
    }

}