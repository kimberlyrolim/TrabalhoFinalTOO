/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TesteTrabalho;

/**
 *
 * @author 20182PF.CC0076
 */
// Main.java
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import trabalho.Cliente;
import trabalho.Funcionario; 
import trabalho.Produto;
import trabalho.Venda;

public class TesteTrabalho {
    public static void main(String[] args) throws UnsupportedEncodingException { //prof eu coloco isso pq só assim o texto sai formatado
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));  //prof eu coloco isso pq só assim o texto sai formatado

        System.out.println("--- Produtos ---");
        Produto produto1 = new Produto(1, "Mouse", "Bluetooth", 50.00, 100, false);
        Produto produto2 = new Produto(2, "SSD", "M2 256 GB", 200.00, 100, false);
        Produto produto3 = new Produto(3, "Manutenção", "Troca de HD para SSD M2 256 GB", 100.00, 1000, true); // Serviço

        produto1.cadastrarProduto();
        produto2.cadastrarProduto();
        produto3.cadastrarProduto();
        System.out.println();

        System.out.println("--- Estoque Atual ---");
        System.out.println("Estoque de " + produto1.getNome() +" "+ produto1.getQtdEstoque());
        System.out.println("Estoque de " + produto2.getNome() +" "+ produto2.getQtdEstoque());
        System.out.println("Estoque de " + produto3.getNome() +" " + produto3.getQtdEstoque());
        System.out.println();

        Funcionario func1 = new Funcionario(1, "Kimberly", "123.456.789-10", "98877-6655", "Avenida Brasil, 10", "Vendedor", LocalDate.of(2020, 5, 15));
      
        Cliente cliente1 = new Cliente(1, "Mariana", "987.654.321-10", "91122-3344", "Av. Presidente Vargas, 20", "mariana@teste.com");
    
        System.out.println("--- Venda 1 ---");
        Venda venda1 = new Venda(1, cliente1, func1);
        System.out.println("Venda criada: " + venda1.getIdVenda() + " para cliente: " + venda1.getClienteAssociado().getNome());
        
        venda1.adicionarItem(produto1, 2); // Compra 2 mouse
        venda1.adicionarItem(produto2, 1); // Compra 1 ssd
        venda1.adicionarItem(produto3, 1); // Contrata 1 serviço

        System.out.println("Valor total calculado da Venda 1: R$" + String.format("%.2f",venda1.getValorTotal()));
        System.out.println();
        
        venda1.setStatusVenda("Pagamento Efetuado");
        cliente1.adicionarCompraAoHistorico(venda1);
        func1.registrarVenda(venda1);

        System.out.println("\n--- Nota Fiscal 1 ---");
        System.out.println(venda1); 
        System.out.println();


        System.out.println("--- Estoque Atualizado ---");
        System.out.println("Estoque de " + produto1.getNome() + ": " + produto1.getQtdEstoque());
        System.out.println("Estoque de " + produto2.getNome() + ": " + produto2.getQtdEstoque());
        System.out.println("Estoque de " + produto3.getNome() + " (Serviço, não altera): " + produto3.getQtdEstoque());
        System.out.println();

        System.out.println("--- Venda 2 ---");
        Venda venda2 = new Venda(2, cliente1, func1);
        venda2.adicionarItem(produto2, 5); // Compra SSD
        System.out.println("Valor total Venda 2: R$" + String.format("%.2f", venda2.getValorTotal()));
        
        venda2.setStatusVenda("Pagamento Efetuado");
        cliente1.adicionarCompraAoHistorico(venda2);
        func1.registrarVenda(venda2);
        
        System.out.println("--- Estoque Atualizado ---");
        System.out.println("Estoque de " + produto1.getNome() + ": " + produto1.getQtdEstoque());
        System.out.println("Estoque de " + produto2.getNome() + ": " + produto2.getQtdEstoque());
        System.out.println("Estoque de " + produto3.getNome() + ": " + produto3.getQtdEstoque());
      
        System.out.println("\n--- Histórico do Cliente ---");
        cliente1.consultarHistorico();
        System.out.println();
        
        System.out.println("\n--- Histórico do Funcionário ---");
        func1.consultarHistorico();
        System.out.println();
        
    }
}