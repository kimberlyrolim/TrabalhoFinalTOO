
package trabalho;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um funcionário da loja, gerenciando seus dados e histórico de vendas.
 */
public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String cargo;
    private LocalDate dataAdmissao;
    
    private List<Venda> historicoVendas;

    // Construtor
    public Funcionario(int idFuncionario, String nome, String cpf, String telefone, String endereco, String cargo, LocalDate dataAdmissao) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cargo = cargo;
        this.dataAdmissao = dataAdmissao;
        
        this.historicoVendas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void registrarVenda(Venda venda) {
        this.historicoVendas.add(venda);
        System.out.println("Venda ID " + venda.getIdVenda() + " registrada para o funcionário " + this.nome);
    }

    public void consultarHistorico() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Cargo: " + this.cargo);
        System.out.println("Data de Admissão: " + this.dataAdmissao.format(formatador));
        
        if (this.historicoVendas.isEmpty()) {
            System.out.println("\nNenhuma venda registrada para este funcionário.");
            return; 
        }

        System.out.println("\n-- Vendas Realizadas --");
        double totalVendido = 0.0;
        for (Venda venda : this.historicoVendas) {
            System.out.println(String.format(
                "  - Venda ID: %d | Cliente: %s | Valor: R$%.2f", 
                venda.getIdVenda(), 
                venda.getClienteAssociado().getNome(), 
                venda.getValorTotal()
            ));
            totalVendido += venda.getValorTotal();
        }
        
        System.out.println(String.format("\nValor Total Vendido pelo funcionário: R$%.2f", totalVendido));
        System.out.println("-".repeat(50));
    }
}