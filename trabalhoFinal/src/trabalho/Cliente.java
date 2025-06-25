

package trabalho;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Cliente extends Pessoa {
    private int idCliente;
    private String email;
    protected List<Venda> historicoCompras;

    public Cliente(int idCliente, String nome, String cpf, String telefone, String endereco, String email) {
        super(nome, cpf, telefone, endereco);
        this.idCliente = idCliente;
        this.email = email;
        this.historicoCompras = new ArrayList<>();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Venda> getHistoricoCompras() {
        return historicoCompras;
    }

    public void adicionarCompraAoHistorico(Venda venda) {
        if (venda != null) {
            this.historicoCompras.add(venda);
        }
    }

    @Override
    public void consultarHistorico() {
        System.out.println("--- Histórico de Compras do Cliente: " + this.getNome() + " ---");
        System.out.println("ID Cliente: " + this.idCliente + " | CPF: " + this.getCpf());

        if (historicoCompras.isEmpty()) {
            System.out.println("\nNenhuma compra registrada.");
            return;
        }

        for (Venda venda : historicoCompras) {
            System.out.println(String.format(
                "\n  - Venda ID: %d | Status: %s | Valor Total: R$%.2f",
                venda.getIdVenda(),        
                venda.getStatusVenda(),    
                venda.getValorTotal()      
            ));

            System.out.println("    Itens Comprados:");

            List<Produto> produtosDaVenda = venda.getProdutos();
            List<Integer> quantidadesDaVenda = venda.getQuantidades();
            
            for (int i = 0; i < produtosDaVenda.size(); i++) {
                Produto produto = produtosDaVenda.get(i);
                Integer quantidade = quantidadesDaVenda.get(i);
                
                System.out.println(String.format(
                    "      - %s (%dx)",
                    produto.getNome(), 
                    quantidade
                ));
            }
        }
        System.out.println("\n" + "-".repeat(50));
    }
    

    @Override
    public String toString() {
        return
                " Cliente: " + idCliente +
                ", Pessoa: " + super.toString() + // Inclui nome, cpf, telefone, endereco da classe Pessoa
                ", Email: " + email;
    }
}