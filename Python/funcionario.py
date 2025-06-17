# Arquivo: funcionario.py
# CÓDIGO FINAL E COMPLETO

from datetime import datetime
from typing import Optional

# Supondo que você tenha um arquivo pessoa.py com a classe Pessoa
# Se não tiver, remova a herança: class Funcionario:
from pessoa import Pessoa 

class Funcionario(Pessoa):
    
    
    # PASSO 1: O construtor é flexível para a data de admissão
    def __init__(self, nome: str, cpf: str, telefone: str, endereco: str, matricula: str, cargo: str, data_admissao: Optional[datetime] = None):
     
        super().__init__(nome, cpf, telefone, endereco)
        self._matricula = matricula
        self.cargo = cargo
        
        # Lógica que permite setar a data ou usar a data atual como padrão
        if data_admissao is None:
            self._data_admissao = datetime.now()
        else:
            self._data_admissao = data_admissao
        
        # Lista para registrar as vendas de cada funcionário
        self.historico_vendas = []

    # Propriedades para acessar atributos encapsulados de forma segura
    @property
    def matricula(self) -> str:
        return self._matricula

    @property
    def data_admissao(self) -> datetime:
        return self._data_admissao

    # PASSO 2: Método para que a classe Venda possa adicionar a si mesma ao histórico
    def adicionar_venda_ao_historico(self, venda):
        """Este método é chamado pela classe Venda para registrar uma compra."""
        self.historico_vendas.append(venda)

    # PASSO 3: Método final para consultar os dados e o histórico de vendas
    def consultar_historico(self):
        """Exibe os dados do funcionário e um resumo de seu histórico de vendas."""
        print(f"\n--- Histórico de Vendas do Funcionário: {self.nome} ---")
        
        # Exibe as informações do cargo, como solicitado
        print(f"Cargo: {self.cargo}")
        # Formata a data para um formato mais legível (Dia/Mês/Ano)
        print(f"Data de Admissão: {self.data_admissao.strftime('%d/%m/%Y')}")
        
        if not self.historico_vendas:
            print("\nNenhuma venda registrada para este funcionário.")
            return

        print("\n-- Vendas Realizadas --")
        total_vendido = 0
        for venda in self.historico_vendas:
            # Acessa os atributos da venda para exibir um resumo útil
            total_vendido += venda.valor_total
            print(f"  - Venda ID: {venda._id_venda} | Cliente: {venda._cliente.nome} | Valor: R$ {venda.valor_total:.2f}")
        
        print(f"\nValor Total Vendido pelo funcionário: R$ {total_vendido:.2f}")
        print("-" * 50)

    def __str__(self):
        """Representação em string do objeto Funcionário."""
        return f"Funcionário: {self.nome} | Matrícula: {self.matricula} | Cargo: {self.cargo}"