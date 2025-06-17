// Arquivo: trabalho/Cliente.java
// CÓDIGO FINAL E CORRETO

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
    // >>>>>>>>> MÉTODO EDITADO ABAIXO <<<<<<<<<<
    public void consultarHistorico() {
        // 1. Cabeçalho principal com os dados do cliente
        System.out.println("--- Histórico de Compras do Cliente: " + this.getNome() + " ---");
        System.out.println("ID Cliente: " + this.idCliente + " | CPF: " + this.getCpf());

        // 2. Verifica se o histórico está vazio
        if (historicoCompras.isEmpty()) {
            System.out.println("\nNenhuma compra registrada.");
            return;
        }

        // 3. Itera sobre cada objeto Venda no histórico
        for (Venda venda : historicoCompras) {
            // Para cada venda, imprime um cabeçalho com seus detalhes
            System.out.println(String.format(
                "\n  - Venda ID: %d | Status: %s | Valor Total: R$%.2f",
                venda.getIdVenda(),        // Assumindo que Venda tem getIdVenda()
                venda.getStatusVenda(),    // Assumindo que Venda tem getStatusVenda()
                venda.getValorTotal()      // Assumindo que Venda tem getValorTotal()
            ));

            System.out.println("    Itens Comprados:");

            // 4. Itera sobre as listas de produtos e quantidades daquela venda
            // Assumindo que Venda tem getProdutos() (retorna List<Produto>)
            // e getQuantidades() (retorna List<Integer>)
            List<Produto> produtosDaVenda = venda.getProdutos();
            List<Integer> quantidadesDaVenda = venda.getQuantidades();
            
            for (int i = 0; i < produtosDaVenda.size(); i++) {
                Produto produto = produtosDaVenda.get(i);
                Integer quantidade = quantidadesDaVenda.get(i);
                
                System.out.println(String.format(
                    "      - %s (%dx)",
                    produto.getNome(), // Assumindo que Produto tem getNome()
                    quantidade
                ));
            }
        }
        // 5. Rodapé para finalizar o relatório
        System.out.println("\n" + "-".repeat(50));
    }
    // >>>>>>>>> FIM DO MÉTODO EDITADO <<<<<<<<<<

    @Override
    public String toString() {
        return
                " Cliente: " + idCliente +
                ", Pessoa: " + super.toString() + // Inclui nome, cpf, telefone, endereco da classe Pessoa
                ", Email: " + email;
    }
}