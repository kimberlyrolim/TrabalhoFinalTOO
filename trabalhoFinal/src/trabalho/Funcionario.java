/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;

/**
 *
 * @author 20182PF.CC0076
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
    private int idFuncionario;
    private String cargo;
    private LocalDate dataAdmissao;
    
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Funcionario(int idFuncionario, String nome, String cpf, String telefone, String endereco, String cargo, LocalDate dataAdmissao) {
        super(nome, cpf, telefone, endereco); // Chama o construtor de Pessoa
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
        this.dataAdmissao = dataAdmissao;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public boolean registrarVenda(Venda venda) { 
        if (venda != null) {
            System.out.println("Funcionário " + getNome() + " (ID: " + idFuncionario + ") registrou a venda ID: " + venda.getIdVenda());
            return true;
        }
        System.err.println("Funcionário " + getNome() + " (ID: " + idFuncionario + ") falhou ao registrar a venda (venda nula).");
        return false;
    }

    @Override
    public void consultarHistorico() {
        System.out.println("Consultando informações/histórico do funcionário: " + getNome());
        System.out.println("Cargo: " + this.cargo);
        System.out.println("Data de Admissão: " + this.dataAdmissao);
    }

    @Override
    public String toString() {
        return
                "Funcionário: "+idFuncionario + 
                ", Nome: " + getNome() + '\'' +
                ", Cpf: " + getCpf() + '\'' +
                ", Cargo: " + cargo + '\'' +
                ", Admissão: " + formato.format(dataAdmissao) ;
    }
}