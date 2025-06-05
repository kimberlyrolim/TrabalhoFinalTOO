/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;

/**
 *
 * @author 20182PF.CC0076
 */
// Cliente.java
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
        System.out.println("Histórico de Compras do Cliente: " + getNome() + " (ID Cliente: " + idCliente + ", CPF: " + getCpf() + ")");
        if (historicoCompras.isEmpty()) {
            System.out.println("  Nenhuma compra registrada.");
            return;
        }
        for (Venda venda : historicoCompras) {
            System.out.println("  - " + venda.toString());
        }
    }

    @Override
    public String toString() {
        return 
               " Cliente: " + idCliente +
               ", Pessoa: " + super.toString() + // Inclui nome, cpf, telefone, endereco da classe Pessoa
               ", Email: " + email;
    }

}