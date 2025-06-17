// Arquivo: trabalho/Funcionario.java

package trabalho;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um funcionário da loja, gerenciando seus dados e histórico de vendas.
 */
public class Funcionario {
    // Atributos do Funcionário
    private int idFuncionario;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String cargo;
    private LocalDate dataAdmissao;
    
    // Atributo para armazenar o histórico de vendas realizadas
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
        
        // Sempre que um funcionário é criado, sua lista de histórico é inicializada (vazia)
        this.historicoVendas = new ArrayList<>();
    }

    // --- Getters para acessar os dados encapsulados ---
    public String getNome() {
        return nome;
    }

    // --- Métodos para o Histórico ---

    /**
     * Adiciona uma venda à lista de histórico do funcionário.
     * Este método é chamado a partir da classe principal.
     * @param venda A venda a ser registrada.
     */
    public void registrarVenda(Venda venda) {
        this.historicoVendas.add(venda);
        System.out.println("Venda ID " + venda.getIdVenda() + " registrada para o funcionário " + this.nome);
    }

    /**
     * Exibe no console os dados do funcionário e um relatório de suas vendas.
     */
    public void consultarHistorico() {
        // Define um formatador para a data ficar mais legível (dd/MM/yyyy)
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Cargo: " + this.cargo);
        System.out.println("Data de Admissão: " + this.dataAdmissao.format(formatador));
        
        if (this.historicoVendas.isEmpty()) {
            System.out.println("\nNenhuma venda registrada para este funcionário.");
            return; // Termina a execução do método se não houver vendas
        }

        System.out.println("\n-- Vendas Realizadas --");
        double totalVendido = 0.0;
        // Itera sobre a lista de vendas do funcionário
        for (Venda venda : this.historicoVendas) {
            // Usa os getters da classe Venda para obter os detalhes
            System.out.println(String.format(
                "  - Venda ID: %d | Cliente: %s | Valor: R$%.2f", 
                venda.getIdVenda(), 
                venda.getClienteAssociado().getNome(), // Supondo que Venda tem getClienteAssociado() e Cliente tem getNome()
                venda.getValorTotal()
            ));
            totalVendido += venda.getValorTotal();
        }
        
        System.out.println(String.format("\nValor Total Vendido pelo funcionário: R$%.2f", totalVendido));
        System.out.println("-".repeat(50));
    }
}